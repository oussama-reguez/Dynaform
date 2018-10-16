package control;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;
import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import model.ResetPassword;
import model.User;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import dao.Language;
import dao.UserDao;

@ManagedBean(name="userMB")
@ViewScoped
public class UserMB {

	static final int JPEG=5;

	@EJB
	UserDao dao ;
	
private List<String> generatedUserNames=new ArrayList<String>();;
private String Password ;
private String selectedName; 
private String token;
private  BufferedImage resizedImage;

@ManagedProperty(value = "#{login}")
Login login ;

public void success(){
	System.out.println("success");
//	System.out.println(dao.diff());
}
public String getUserLanguage(){
	String language="en";
	if (login.getUser()!=null){
		language=login.getUser().getLanguage();
	}
	System.out.println(language);
	return language;
	
}
	public void setLogin(Login login) {
	this.login = login;
}

	public Login getLogin() {
	return login;
}

	public String getSelectedName() {
	return selectedName;
}

public void setSelectedName(String selectedName) {
	this.selectedName = selectedName;
}

	public String getPassword() {
	return Password;
}
	public void updateUsername(){
		System.out.println("started");
		user.setUsername("tla");
	}
	
	public void sendEmail( String toOne, String subject, String body ) {
        final String username = "dynaform";
        final String password = "ll789456123";

        Properties props = new Properties();
        props.put( "mail.smtp.auth", "true" );
        props.put( "mail.smtp.starttls.enable", "true" );
        props.put( "mail.smtp.host", "smtp.mail.yahoo.com" );
        props.put( "mail.smtp.port", "587" );

        Session session = Session.getInstance( props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication( username, password );
                    }
                } );

        try {

            Message message = new MimeMessage( session );
            message.setFrom( new InternetAddress( "dynaform@yahoo.com" ) );

            message.setRecipients( Message.RecipientType.TO,
                    InternetAddress.parse( toOne ) );
            message.setContent(body  ,"text/html");
            message.setSubject( subject );
          //  message.setText( body );

            Transport.send( message );

        } catch ( MessagingException e ) {
            throw new RuntimeException( e );
        }
    }
	
	
public void initResetPassword() throws IOException{
int id=0;

	try{
	String user_id=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("user_id");
	token=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("token");
	id=Integer.parseInt(user_id);
	System.out.println(id);
	//FacesContext.getCurrentInstance().getExternalContext().dispatch("login.xhtml");

	if(dao.findToken(id, token)==false){
		System.out.println("bad token");
	}
	else{
		
	 user=dao.findUser(id);
	 
	}
	
	}
 catch(java.lang.NumberFormatException ex)
{
	 System.out.println("erreur!!!!!!");
		//FacesContext.getCurrentInstance().getExternalContext().dispatch("login.xhtml");
}
	
}
public void setPassword(String password) {
	Password = password;
}
	private User user=new User() ;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	 
	public void forgetPassword() throws IOException{
	String email=user.getEmail();
	
		SecureRandom random = new SecureRandom();
	String token=new BigInteger(130, random).toString(32);
	System.out.println(email);
  User user=dao.findUser(email);
	ResetPassword resetPassword = new ResetPassword();
	resetPassword.setUser(user);
	resetPassword.setToken(token);
	dao.persist(resetPassword);


	String link="http://localhost:8081/formm/faces/ResetPassword.xhtml"+"?user_id="+user.getIdUser()+"&token="+token;
	String body=Language.message("email_message")+link;
String object=Language.message("email_object");
sendEmail(user.getEmail(),object, body);
System.out.println("done");
 	
	}
	
	public void changeForgottenPassword(){
		String password = getMD5(user.getPassword());
		
		user.setPassword(password);
		ResetPassword reset= new ResetPassword();
		reset.setToken(token);
		dao.updateUser(user);
		dao.delete(reset);
		System.out.println("password changed");
		
	
	}
	
	public void changeLanguage(){
		User loggedUser = login.getUser();
		loggedUser.setLanguage(user.getLanguage());
	System.out.println(user.getLanguage());
	System.out.println(loggedUser.getLanguage());
	dao.updateUser(loggedUser);
	login.setLocale(new Locale(loggedUser.getLanguage()));
	
	System.out.println("done lanuguage");
	}
	
	
	public void randomUserNames(String userName){
 
		int i=0;
		while(i<3){
	
			Random rand = new Random();

			int  number = rand.nextInt(100) + 1;
			
			
			String name=userName.concat(Integer.toString(number));
			System.out.println(name);
			
			if(dao.findUserName(name)==false){
				i++;
				generatedUserNames.add(name);
			}
			
		}
		for(String s:generatedUserNames){
			System.out.println(s);
		}
	}
	
	public void initUser(){
		User loggedUser = login.getUser();
		
		user.setIdUser(loggedUser.getIdUser());
		user.setPassword(loggedUser.getPassword());
		user.setUsername(loggedUser.getUsername());
		user.setUser_picture(loggedUser.getUser_picture());
		user.setFirstName(loggedUser.getFirstName());
		user.setLastName(loggedUser.getLastName());
		user.setGender(loggedUser.getGender());
		user.setEmail(loggedUser.getEmail());
		user.setBirthDate(loggedUser.getBirthDate());
		user.setLanguage(loggedUser.getLanguage());
		
		
		System.out.println(user.getFirstName());
	}
	
	
	 public void handleFileUpload(FileUploadEvent event) throws IOException {
		System.out.println("started");
		 UploadedFile file=event.getFile();
		System.out.println(file.getContentType()); 
		 InputStream inputStream=file.getInputstream();
	        
	        BufferedImage originalImage = ImageIO.read(inputStream);
			int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
	 
			 resizedImage = new BufferedImage(32, 32, type);
			Graphics2D g = resizedImage.createGraphics();
			g.drawImage(originalImage, 0, 0, 32, 32, null);
			g.dispose();
			FacesMessage message =  new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", Language.message("success_upload_picture"));
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("growl", message);	
			System.out.println("type"+resizedImage.getType());
			

System.out.println("done");
	 }
	 
	public void changeUserPicture() throws IOException{
		String name=Integer.toString(resizedImage.hashCode());
		if(resizedImage.getType()==JPEG){
			
			
			ImageIO.write(resizedImage, "jpg", new File("g:\\images\\user\\"+name+".jpg")); 
			login.getUser().setUser_picture("/images/user/"+name+".jpg");

			}
			else{
				ImageIO.write(resizedImage, "jpg", new File("g:\\images\\user\\"+name+".png")); 
				login.getUser().setUser_picture("/images/user/"+name+".png");
			}
		dao.updateUser(login.getUser());
		FacesMessage message =  new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", Language.message("success_Picture_change"));
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage("growl", message);	
	}

	
	public void saveChanges(){
		login.setUser(user);
		dao.updateUser(user);
		FacesMessage message =  new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", Language.message("success_change"));
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage("growl", message);	
		
	}
	public void validatePassword(FacesContext ctx, UIComponent component, Object value) 
			throws ValidatorException
{
System.out.println("startede");
String password = value.toString();
System.out.println(password);
System.out.println(user.getPassword());
if(!password.equals(user.getPassword())){
FacesMessage message =  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", Language.message("match_password"));
FacesContext context = FacesContext.getCurrentInstance();
context.addMessage(component.getClientId(context), message);	

throw new  ValidatorException(message);
}

}
	public void isUsernameValid(FacesContext ctx, UIComponent component, Object value) 
			throws ValidatorException
{
System.out.println("started");
FacesMessage message =  new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks.");
FacesContext context = FacesContext.getCurrentInstance();
context.addMessage(component.getClientId(context), message);	

throw new  ValidatorException(message);

}

	public List<String> getGeneratedUserNames() {
		return generatedUserNames;
	}

	public void setGeneratedUserNames(List<String> generatedUserNames) {
		this.generatedUserNames = generatedUserNames;
	}

	public void validateUserName(FacesContext ctx, UIComponent component, Object value){
		String username=value.toString();
boolean result=dao.findUserName(username);
if(result==true)
{
	FacesMessage message =  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", Language.message("not_available_user_name"));
	FacesContext context = FacesContext.getCurrentInstance();
	context.addMessage(component.getClientId(context), message);	
	randomUserNames((String) value);
	throw new  ValidatorException(message);
	
}
else {
	 FacesMessage message =  new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", Language.message("available_user_name"));
	 generatedUserNames.clear();
	  FacesContext context = FacesContext.getCurrentInstance();
	  context.addMessage(component.getClientId(context), message);	
}
	}
	
public void validateName(FacesContext ctx, UIComponent component, Object value){
	String name=value.toString();
	if(!name.matches( "[a-zA-z]+([ '-][a-zA-Z]+)*" )){
		
		 FacesMessage message =  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "'"+name+"'"+Language.message("validate_name") );
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(component.getClientId(context), message);	
	}
}
public void verifyPassword(FacesContext ctx, UIComponent component, Object value){
	String password = getMD5(value.toString());
	if(!login.getUser().getPassword().equals(password)){
		FacesMessage message =  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", Language.message("incorrect_password"));
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(component.getClientId(context), message);	

		throw new  ValidatorException(message);
	}
}

public  String getMD5(String input) {
    try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        BigInteger number = new BigInteger(1, messageDigest);
        String hashtext = number.toString(16);
        // Now we need to zero pad it if you actually want the full 32 chars.
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }
    catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
    }
}
public void changePassword(){
	String md5Password=getMD5(user.getPassword());
	login.getUser().setPassword(md5Password);
	dao.updateUser(login.getUser());
	FacesContext context = FacesContext.getCurrentInstance();
	context.addMessage("test", new FacesMessage(FacesMessage.SEVERITY_INFO, Language.message("success_password_change"), null));
	System.out.println("finish");
}
	public void validateEmail (FacesContext ctx, UIComponent component, Object value) {
		
	String email=value.toString();
	System.out.println("emailvalidation");
	try {
	      InternetAddress emailAddr = new InternetAddress(email);
	      emailAddr.validate();
	      if(dao.findEmail(email)){		
	    	  if (!email.equals(login.getUser().getEmail())){
	    		  FacesMessage message =  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Email already in use chooose another one");
	    			FacesContext context = FacesContext.getCurrentInstance();
	    			context.addMessage(component.getClientId(context), message);	

	    			throw new  ValidatorException(message);
	    	  }
				
		}
	     
	   } catch (AddressException ex) {
		   FacesMessage message =  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "invalid email format");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(component.getClientId(context), message);	

			throw new  ValidatorException(message);
	   }
	
		
	}
	
	public void findUserByEmail (FacesContext ctx, UIComponent component, Object value) {
		String email=value.toString();
		System.out.println("emailvalidation");
		try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		      if(!dao.findEmail(email)){		
		    	
		    		  FacesMessage message =  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Sorry, no user found with this email");
		    			FacesContext context = FacesContext.getCurrentInstance();
		    			context.addMessage(component.getClientId(context), message);	

		    			throw new  ValidatorException(message);
		    	  }
		      
					
			
		     
		   } catch (AddressException ex) {
			   FacesMessage message =  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "invalid email format");
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(component.getClientId(context), message);	

				throw new  ValidatorException(message);
		   }
		
		
	}
	
	public void handleChange(ValueChangeEvent event){  
		
	user.setUsername((String)event.getNewValue());	
		}
	
	public String createAccount(){
		System.out.println("ss"+user.getUsername());
	String 	md5_password=getMD5(user.getPassword());
	user.setPassword(md5_password);
	dao.persist(user);
	FacesContext context = FacesContext.getCurrentInstance();
	
	
    context.getExternalContext().getFlash().setKeepMessages(true);
  
    
   
    context.addMessage("test", new FacesMessage(FacesMessage.SEVERITY_INFO, "welecom", null));
	
	 return "/Presets/succesRegistration?faces-redirect=true";
		
	}
	public void test(){
		System.out.println("test");
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("fr"));
		
	}
}
