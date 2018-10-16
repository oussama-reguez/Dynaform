package control;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import model.Form;
import dao.FormDao;
 
@ManagedBean
@ViewScoped
public class Search {
	private  List<Form> forms;
	private int formNumbers; 
	private String searchType="Form Name" ;
	 public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public int getFormNumbers() {
		return formNumbers;
	}

	public void setFormNumbers(int formNumbers) {
		this.formNumbers = formNumbers;
	}

	public List<Form> getForms() {
		return forms;
	}

	public void setForms(List<Form> forms) {
		this.forms = forms;
	}

	
	@EJB
		FormDao dao ;
	 private String txt ;
  public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}


private  String search;
   
	 public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public List<String> completeText(String query) {
		   List<String> results = new ArrayList<String>();
	        
	      results=dao.autoComplete(query, searchType) ;
	   
	        return results;
	    }
	    public void test(){
	    	System.out.println("gekek");
	    }
	 @PostConstruct
	 void init(){
		 search = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("search");
		 searchType = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("searchType");
		if(search !=null && searchType != null){
			forms=dao.findForms(search,searchType);
			formNumbers=forms.size();
			
		}
		else {
			searchType="Form Name";
		}
		if(forms==null){
			System.out.println(" no result null");
		}
		
		 System.out.println("search "+search);
		 System.out.println("txt "+txt);
	 }
	 public void listen(){
		 System.out.println("listening");
		 System.out.println(txt);
	 }
	 public void redirect(){
		 try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("search.xhtml?search=" + txt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
}