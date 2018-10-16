package dao;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import javax.persistence.Query;















import org.joda.time.LocalDate;
import org.joda.time.Years;

import model.Form;
import model.ListValue;
import model.SubmittedForm;
import model.User;
import model.Value;
import model.Input;

@Stateless
public class FormDao {
	

	@PersistenceContext( unitName = "formm" )
    private EntityManager       em;
	@Resource
	private EJBContext context;


	
	public String generateRandomName(){
		
		Date date=new Date();
		
		Long count;
		String sql ="select count(s.idSubmittedForm) from SubmittedForm s where FUNC('MONTH', s.date) =FUNC('MONTH', :date)   and  FUNC('YEAR', s.date) =FUNC('YEAR', :date) and  FUNC('DAY', s.date) =FUNC('DAY', :date) ";
	Query query =em.createQuery(sql);
	query.setParameter("date", date);
	count = (Long) query.getSingleResult();
	Format formatter = new SimpleDateFormat("yyyy-MM-dd");
	String formattedDate = formatter.format(date);

	return  (formattedDate+"-"+ ++count);
		
	}
	public Form getForm(int id ) {

Form form = null ;


		 form = em.find(Form.class, id);
		if(form!=null) em. refresh(form);
		
		 
	
return form;

}
public void delete(Object o ){

			o=em.merge(o);
			em.remove(o);

}


public List<Form> getForms(int id ) {

	
	String sql = "select f from Form f where f.user.idUser="+id;
	Query query=em.createQuery(sql);
	
	@SuppressWarnings("unchecked")
	List<Form> subforms = query.getResultList();
	
return subforms;

}


public List<Form> getInputs(Form form ) {

	
	String sql = "select f from Input f where f.form.idForm="+form.getIdForm()+" order by f.order";
	Query query=em.createQuery(sql);
	@SuppressWarnings("unchecked")
	List<Form> subforms = query.getResultList();
	
return subforms;

}
public Form verifyForm(int id,User user ){

	String sql = "select f from Form f where f.idForm=:idForm and f.user.idUser=:idUser";
	
	Query query=em.createQuery(sql);
	query.setParameter("idForm", id);
	query.setParameter("idUser", user.getIdUser());
	return ((Form) query.getSingleResult());
}

public Form verifyForm(int id ){

	String sql = "select f from Form f where f.idForm="+id;
	Query query=em.createQuery(sql);
	return ((Form) query.getSingleResult());
}
public List<SubmittedForm> getSubForms(int id ) {

	
	String sql = "select f from SubmittedForm f where f.user.idUser="+id;
	Query query=em.createQuery(sql);
	@SuppressWarnings("unchecked")
	List<SubmittedForm> subforms = query.getResultList();
	
return subforms;

}


public List<Value> getValues(int id ) {

	
	String sql = "select f from Value f where f.submittedForm.idSubmittedForm=:id";
	Query query=em.createQuery(sql);
	query.setParameter("id", id);
	@SuppressWarnings("unchecked")
	List<Value> values = query.getResultList();
	
return values;

}

public List<SubmittedForm> getSubFormsByForm(int id ) {

	
	String sql = "select f from SubmittedForm f where f.form.idForm=:id";
	Query query=em.createQuery(sql);
	query.setParameter("id", id);
	@SuppressWarnings("unchecked")
	List<SubmittedForm> subforms = query.getResultList();
	
return subforms;

}
public List<String> autoComplete(String title, String searchType){
	System.out.println("searchtype"+searchType);
	String sql =null;
	
	Query query=null;
	if(searchType.equals("Form Name")){
	sql = "select f.name from Form f where f.name like :search";
	query=em.createQuery(sql);
	query.setParameter("search", title+"%");
	
	}
	else {
		sql = "select f.user.username from Form f where f.user.username like :name";
		query=em.createQuery(sql);
		query.setParameter("name", title+"%");
	}
	@SuppressWarnings("unchecked")
	List<String> lists =query.getResultList();
	for(String s:lists)
	{
		System.out.println(s);
	}
	
	return lists ;
}



public List<Form> findForms(String title, String searchType){
	String sql =null;
	
	Query query=null;
	if(searchType.equals("Form Name")){
	sql = "select f from Form f where f.name like :search";
	query=em.createQuery(sql);
	query.setParameter("search", title);
	
	}
	else {
		sql = "select f from Form f where f.user.username = :name";
		query=em.createQuery(sql);
		query.setParameter("name", title);
	}
	
	
	@SuppressWarnings("unchecked")
	List<Form> result =(List<Form>) query.getResultList();
	return result;
}



public Long countvalues(ListValue listvalue ,Input input) {
	String lvalue = listvalue.getValue();
	Long count;
	String sql ="select count(v.idValue) from Value v where v.input.idInput="+input.getIdInput()+" and v.value= '"+lvalue+"'";
Query query =em.createQuery(sql);
count = (Long) query.getSingleResult();
return count;
}
public List<Input> getInputs(int id ){
	
	Form form=getForm(id);
	
	return form.getInputs();
}

public  void persistValue(Value c) {
	// Information d'acc�s � la base de donn�es
em.clear();

	 em.persist(c);
	

	
}
public void updateForm(Object Form){
	em.merge(Form);
}

public void persist(Object Form){
	em.persist(Form);
}

//public Form trouver( ind id )  {
//    Form form = null;
//    Query requete = em.createQuery( JPQL_SELECT_PAR_EMAIL );
//    requete.setParameter( PARAM_EMAIL, email );
//    try {
//        utilisateur = (Utilisateur) requete.getSingleResult();
//    } catch ( NoResultException e ) {
//        return null;
//    } catch ( Exception e ) {
//        throw new DAOException( e );
//    }
//    return utilisateur;
//}


	
		
	
	
	
}




