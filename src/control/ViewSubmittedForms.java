package control;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import model.SubmittedForm;
import model.Value;
import dao.FormDao;

@ManagedBean
@ViewScoped
public class ViewSubmittedForms {
	@EJB
	FormDao dao ;
	@ManagedProperty(value="#{login}")
	private Login login;
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	private List<SubmittedForm> subforms= new ArrayList<SubmittedForm>(); ;
	private List<Value> values= new ArrayList<Value>(); ;
	private SubmittedForm selectedSubforms ;
@PostConstruct
void init(){
	subforms=dao.getSubForms(login.getUser().getIdUser());
	for (SubmittedForm form:subforms){
		for(Value val:form.getValues()){
			System.out.println(val.getValue());
		}
	}
}
public void show(){
	System.out.println(selectedSubforms.getIdSubmittedForm());
}
public List<SubmittedForm> getSubforms() {
	return subforms;
}

public void setSubforms(List<SubmittedForm> subforms) {
	this.subforms = subforms;
}

public SubmittedForm getSelectedSubforms() {
	return selectedSubforms;
}

public void setSelectedSubforms(SubmittedForm selectedSubforms) {
	this.selectedSubforms = selectedSubforms;
}
public List<Value> getValues() {
	return values;
}
public void setValues(List<Value> values) {
	this.values = values;
}


}
