package dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.joda.time.LocalDate;
import org.joda.time.Years;

import model.Form;
import model.Input;



@Stateless
public class StatDao {

	@PersistenceContext( unitName = "formm" )
    private EntityManager       em;
	
	
public Long avgAge(Form form){
		
		String sql ="select s.user.birthDate  from SubmittedForm s where s.form.idForm=:idForm";
	Query query =em.createQuery(sql);
	query.setParameter("idForm", form.getIdForm());
List<Date> dates = (List<Date>) query.getResultList();

int ages=0;
int i=0;
LocalDate now = new LocalDate();
for(Date date:dates){
	LocalDate birthdate = new LocalDate (date);
	System.out.println(birthdate);
	
	Years age = Years.yearsBetween(birthdate,now);
	
	int ss=age.getYears();
	System.out.println( "age "+ ss);
	ages=ages+ss;
	i++;
}
System.out.println("sum"+ages);
System.out.println("count "+i);
 long avg=ages/i;

	return  (avg);
		
	}
	public Long countSubmissions(int formId){
		String sql = "select count(f.idSubmittedForm) from SubmittedForm f where f.form.idForm="+formId ;
		Query query=em.createQuery(sql);
		return ((Long) query.getSingleResult());
		
		
	}
	

	public Form getForm(int id ) {

		Form form = null ;


				 form = em.find(Form.class, id);
				if(form!=null) em. refresh(form);
				
				 
			
		return form;

		}
	
	public List<Object[]> countValuesByDate(Input input){
		String sql = "select count(v.value), v.value from Value v where v.input.idInput=:idInput group by v.value"   ;
		Query query=em.createQuery(sql);
		query.setParameter("idInput", input.getIdInput());
		@SuppressWarnings("unchecked")
		List<Object[]> counts= query.getResultList();
		System.out.println("start?");
		
		
		for(Object[] c :counts){
			
	    	 System.out.println(c[0] +"  "+c[1]);
	    	
	    	 /* Date date=(Date) c[1];
	    		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
	    		String formattedDate = dateFormatter.format(date);
	    		series1.set(formattedDate, (Number) c[0]);*/
	    		

	    	 
	        }
		return counts;
	}
	
	public List<Object[]> countSubmissionsByDate(int formId){
		String sql = "select  count(f.idSubmittedForm) , f.date  from SubmittedForm f where f.form.idForm=:id group by f.date"   ;
		Query query=em.createQuery(sql);
		query.setParameter("id", formId);
		@SuppressWarnings("unchecked")
		List<Object[]> counts= query.getResultList();
		System.out.println("start?");
		
		
		for(Object[] c :counts){
			 System.out.println("started");
	    	  System.out.println("date: "+(Date) c[1]+" count"+(Number) c[0]);
	    	 /* Date date=(Date) c[1];
	    		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
	    		String formattedDate = dateFormatter.format(date);
	    		series1.set(formattedDate, (Number) c[0]);*/
	    		

	    	 
	        }

	return counts;
	}
		public Long[] getCountsByGender(int formId){
		Long[] counts = new  Long[2];
		String sql = "select count(f.idSubmittedForm) from SubmittedForm f where f.form.idForm=:formId and f.user.gender='male'";
		
		Query query=em.createQuery(sql);
		query.setParameter("formId", formId);
			
		counts[0] = (Long) query.getSingleResult();
 sql = "select count(f.idSubmittedForm) from SubmittedForm f where f.form.idForm=:formId and f.user.gender='female'";
		
		 query=em.createQuery(sql);
		 query.setParameter("formId", formId);
		 counts[1]=(Long) query.getSingleResult();
		return counts;
	}
	public Double getAverageAge(int formId){
String sql = "select avg(f.user.age) from SubmittedForm f where f.form.idForm=:formId ";
		
		Query query=em.createQuery(sql);
		query.setParameter("formId", formId);
		
		return (Double) query.getSingleResult();
		
	}
	
	
	public List<Object[]> countSubmissionsByDate(int formId,Date CreationDate){
		String sql = "select count(f.idSubmittedForm) , f.date  from SubmittedForm f where f.form.idForm="+formId +"  group by FUNC('DAY', f.date) "  ;
		Query query=em.createQuery(sql);
		query.setParameter("start", CreationDate, TemporalType.DATE);
		Date now = new Date();
		query.setParameter("end", now, TemporalType.DATE);
		@SuppressWarnings("unchecked")
		List<Object[]>  result=(List<Object[]> ) query.getResultList();
		return (result);
		
		
		
	}
	public List<Object[]> teste(){
		String sql = "select f.name , f.idForm  from Form f ";
		Query query=em.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Object[]>  result=(List<Object[]> ) query.getResultList();
		return (result) ;
		
		
	}
}
