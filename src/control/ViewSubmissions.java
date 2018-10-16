package control;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import model.Form;
import model.SubmittedForm;
import model.Value;
import dao.FormDao;
@ManagedBean
@ViewScoped
public class ViewSubmissions {


	@EJB
	FormDao dao ;
private int id;
private int form_id;

@ManagedProperty(value = "#{login}")
Login login ;

public Login getLogin() {
	return login;
}
public void setLogin(Login login) {
	this.login = login;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public void generate(){
	System.out.println(dao.generateRandomName());
}
private List<SubmittedForm > submissions;
private List<Value >values;


public List<Value> getValues() {
	return values;
}
public void setValues(List<Value> values) {
	this.values = values;
}
private SubmittedForm selectedForm ;
public void execute( ActionEvent event ) {
	selectedForm = (SubmittedForm ) event.getComponent().getAttributes().get("selectedForm");
	System.out.println(selectedForm.getIdSubmittedForm());
	
	values=dao.getValues(selectedForm.getIdSubmittedForm());

}
public SubmittedForm getSelectedForm() {
	return selectedForm;
}

public void setSelectedForm(SubmittedForm selectedForm) {
	this.selectedForm = selectedForm;
}

public List<SubmittedForm> getSubmissions() {
	return submissions;
}

public void setSubmissions(List<SubmittedForm> submissions) {
	this.submissions = submissions;
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
    Form form	=dao.getForm(form_id);
      System.out.println("verifying form ");
      if(form==null ){
    System.out.println("form  not found ");
      	
		FacesContext.getCurrentInstance().getExternalContext().dispatch("/faces/Presets/notFound.xhtml");
    
      }
      else{
    
      	System.out.println("verifying ownership !!");
      	if(form.getUser().getIdUser()!=login.getUser().getIdUser()){
      		FacesContext.getCurrentInstance().getExternalContext().dispatch("/faces/Presets/accessDenied.xhtml");
      
      	System.out.println("access denied");
      	}
      	
      }
}



	public void initSubmissions() throws IOException{
		validateRequest();
	submissions=	dao.getSubFormsByForm(form_id);
	
		System.out.println("hello");
		System.out.println(submissions.size());
	}
	
}
