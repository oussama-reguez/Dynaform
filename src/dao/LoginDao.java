package dao;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Cookie;
import model.Form;
import model.User;
@Stateless
public class LoginDao {

	@PersistenceContext( unitName = "formm" )
    private EntityManager       em;
public  Boolean findUserName(String userName){
	
	boolean result=false;
Long count;
	Query q=null;

	String		sql="select count(f.idUser) from User f where f.username=:username";
	
		 q = em.createQuery(sql); 
	q.setParameter("username", userName	);
	count=(Long)q.getSingleResult();
	
	System.out.println("count"+count);
	
	if( count.intValue() !=0){
		result=true;
		
	}
	return result;
}

public Boolean verifySubmission(User user,Form form){
	Query q=null;
boolean result=false;
	String		sql="select count(r.idSubmittedForm) from SubmittedForm r where r.user.idUser=:id and r.form.idForm=:idForm";
	
		 q = em.createQuery(sql); 
	q.setParameter("id", user.getIdUser());
	q.setParameter("idForm", form.getIdForm());
	
	Long count =(Long) q.getSingleResult();
System.out.println("count"+count);
	
	if( count.intValue() !=0){
		result=true;
		
	}
	return result;
	
}

public User  findUser(String cookie){
	Query q=null;
	User user=null;
		String		sql="select c.user from Cookie r where c.id=:id";
		
			 q = em.createQuery(sql); 
		q.setParameter("id", cookie);
		try{
		 user =(User) q.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
			
		
		
		
		}
		
		return  user;
		
	
}
public User verify(User user){
		
	
	
	
		
		

		
		Query q=null;
			
			
				
		String		sql="select f from User f where f.username='"+user.getUsername()+"' and f.password='"+user.getPassword()+"'"; 
			 q = em.createQuery(sql); 
		
			 
			
			// Etape 4 : ex�cuter la requ�te
			
			

		 user=null;
			try {
				
			
			user= (User) q.getSingleResult();  
			if(user !=null){
				return user;
				
		}
			}
			catch(NoResultException e) {
				return null;
				
			
			
			
			}
			return user;
			
			
			
		

}
	
	
public Form getForm(int id ) {

Form form = null ;


		 form = em.find(Form.class, id);
		if(form!=null) em. refresh(form);
		
		 
	
return form;

}


}

