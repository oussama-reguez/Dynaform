package control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import model.Form;
import model.Input;
import model.SubmittedForm;
import model.Value;
import dao.FormDao;


@ManagedBean
@ViewScoped
public class DisplayForm {
	@EJB
	FormDao dao ;
	private List<Value> values = new ArrayList<Value>();
	private Form form;
private int form_id ;
	@ManagedProperty(value = "#{login}")
	Login login ;
	
	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}


	public Form getForm() {
		return form;
	}


	public void setForm(Form form) {
		this.form = form;
	}
	private List<String> test = new ArrayList<String>();
	public List<String> getTest() {
		return test;
	}


	public void setTest(List<String> test) {
		this.test = test;
	}


	public List<Value> getValues() {
		return values;
	}


	public void setValues(List<Value> values) {
		this.values = values;
	}


	
public void validateRequest() throws IOException{
		
      	try{
      		 form_id = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form_id"));

      		}
      		catch(java.lang.NumberFormatException ex){
      			//erreur form_id
      			form_id=0;
      			FacesContext.getCurrentInstance().getExternalContext().dispatch("/faces/Presets/notFound.xhtml");
      	
      		}
    form	=dao.getForm(form_id);
      System.out.println("verifying form ");
      if(form==null ){
    System.out.println("form  not found ");
      	
		FacesContext.getCurrentInstance().getExternalContext().dispatch("/faces/Presets/notFound.xhtml");
    
      }
      
      if(login.dao.verifySubmission(login.getUser(),form)){
    	  FacesContext.getCurrentInstance().getExternalContext().dispatch("/faces/Presets/failSubmission.xhtml");
    	
        	System.out.println("fail submission");
		} 
     
}
	
public void initDisplay() throws IOException{
	validateRequest();
	 List<Input> inputs=form.getInputs();
for(Input input:inputs){
	Value value = new  Value();
	value.setInput(input);
	values.add(value);
}
test.add("sdf");
test.add("sdddf");

}
	
	public void convert(ValueChangeEvent event){
	System.out.println(event.getNewValue());
	
	}
	public String submit() throws ParseException, IOException{
	
		SubmittedForm submittedForm = new SubmittedForm();
		 Date dt = new Date();
		 submittedForm.setUser(login.getUser());
			submittedForm.setDate(dt); 
			submittedForm.setForm(form);
			submittedForm.setName(dao.generateRandomName());
			
for(Value value:values){
	value.setSubmittedForm(submittedForm);
	   System.out.println(value.getValue());
       if(value.getInput().getType().getIdType()==106){
    	   try {
    		   String pattern="E MMM dd HH:mm:ss z y";
    		   SimpleDateFormat formatter = new SimpleDateFormat(pattern);
    		   String dateInString =value.getValue();
    		   	Date date = formatter.parse(dateInString);
    		   	System.out.println(date);
    		   	 formatter = new SimpleDateFormat("yyyy-MM-dd");
    		   	 System.out.println("dd");
    		   	System.out.println(formatter.format(date));
                value.setValue(formatter.format(date));
    		   } catch (ParseException e) {
    		   	e.printStackTrace();
    		   }
    	   
       }
       
       System.out.println(value.getValue());
     
    // String date = simpleDateFormat.format(value.getValue());
    // System.out.println(date);
      // value.setValue(date);
       
	}

submittedForm.setValues(values);
		dao.persist(submittedForm);
		System.out.println("done ");
		System.out.println("tala");
		// FacesContext.getCurrentInstance().getExternalContext().dispatch("/Presets/successSubmission");
		return("/Presets/successSubmission?faces-redirect=true");
	
}
	


}
	
	


