package control;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import model.Form;
import dao.FormDao;

@ManagedBean
@ViewScoped
public class ViewForms {
	@EJB
	FormDao dao ;
	 @ManagedProperty(value="#{login}")
	private Login login;
	public void setLogin(Login login) {
		this.login = login;
	}

	public Login getLogin() {
		return login;
	}
	private List<Form> forms= new ArrayList<Form>(); ;
	
	private Form selectedForm ;

	public List<Form> getForms() {
		return forms;
	}

	public void setForms(List<Form> forms) {
		this.forms = forms;
	}

	public Form getSelectedForm() {
		return selectedForm;
	}

	public void setSelectedForm(Form selectedForm) {
		this.selectedForm = selectedForm;
	}
	@PostConstruct
	public void init(){
	
		forms=dao.getForms(login.getUser().getIdUser());
	}

	public void deleteForm(ActionEvent e){
	Form	form = (Form) e.getComponent().getAttributes().get("selectedForm");
		System.out.println("done");
forms.remove(form);
		dao.delete(form);
	}
		
	}

