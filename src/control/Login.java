package control;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import dao.Language;
import dao.LoginDao;
import model.User;
@ManagedBean(name="login")
@SessionScoped
public class Login {
	private boolean status =false ;
	private String redirectUrl;
	 private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	 private boolean firstLogin=true;
	 
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	private String test="testsss";
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	private User user= new User() ;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@EJB
	LoginDao dao ;

	
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
	public String login() {
   String password = user.getPassword();
   user.setPassword(getMD5(password));
User validUser= dao.verify(user);
        if (validUser==null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(Language.message("unknown_login")));
           
            return ( null);
        } else {
        	setStatus(true);
        	user=validUser;
        	String redirectUrl=(String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("redirectUrl");
        	 locale = new Locale(user.getLanguage());
             Language.setLanguage(user.getLanguage());
       if(redirectUrl!=null){
    	   HttpServletRequest origRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    	   System.out.println(origRequest.getRequestURI());
    	   System.out.println("urlz:"+redirectUrl);
    	   redirectUrl=redirectUrl.substring(12);
    	   System.out.println(redirectUrl);
    	   return redirectUrl;
       }
      
        	return "/main?faces-redirect=true";
            
        }
    }

	
	public void welcomeUser(){
		if(isStatus()&&firstLogin==true){
			FacesContext context = FacesContext.getCurrentInstance();
			
		      context.addMessage(null,new FacesMessage(Language.message("welcome"),  user.getFirstName()+" "+user.getLastName()));
	
		
			// RequestContext.getCurrentInstance().execute( "welcome()");
			System.out.println("welcome welcome");
		firstLogin=false;
		}
	}
    public String logout() {
    	
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
     
        return "/login?faces-redirect=true";
    }

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

 

	
	
}
