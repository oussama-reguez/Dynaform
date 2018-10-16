package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.joda.time.LocalDate;
import org.joda.time.Years;

import model.Form;
import model.User;

@Stateless
public class UserDao {

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
	

	
	public void updateUser(Object user){
		em.merge(user);
	}

	public User findUser(int id){
		
		Query q=null;

		String		sql="select f from User f where f.idUser=:id";
		
			 q = em.createQuery(sql); 
		q.setParameter("id", id);
		User user =(User) q.getSingleResult();
		return user;
	}
	public Boolean findToken(int id_user,String token){
		Query q=null;
boolean result=false;
		String		sql="select count(r.token) from ResetPassword r where r.user.idUser=:id and r.token=:token";
		
			 q = em.createQuery(sql); 
		q.setParameter("id", id_user);
		q.setParameter("token", token);
		Long count =(Long) q.getSingleResult();
System.out.println("count"+count);
		
		if( count.intValue() !=0){
			result=true;
			
		}
		return result;
		
	}
	
	public void delete(Object o ){

		o=em.merge(o);
		em.remove(o);

}

	public User findUser(String email){
		Query q=null;

		String		sql="select f from User f where f.email=:email";
		
			 q = em.createQuery(sql); 
		q.setParameter("email", email	);
		User user =(User) q.getSingleResult();
		return user;
	}
	public  Boolean findEmail(String email){
		
		boolean result=false;
	Long count;
		Query q=null;

		String		sql="select count(f.idUser) from User f where f.email=:email";
		
			 q = em.createQuery(sql); 
		q.setParameter("email", email	);
		count=(Long)q.getSingleResult();
		
		System.out.println("count"+count);
		
		if( count.intValue() !=0){
			result=true;
			
		}
		return result;
	}
	
	
	public void persist(Object object){
		em.persist(object);
	}
	public void requestPassword(String email){
		
	}
}
