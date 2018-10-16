package control;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import model.Form;
import model.Input;
import model.ListValue;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

import dao.FormDao;
import dao.StatDao;

@ManagedBean
@ViewScoped
public class StatForm {
	@EJB
	FormDao dao ;
	@EJB
	StatDao statDao ;
	
	@ManagedProperty(value = "#{login}")
	Login login ;

	private int form_id;
	private Long avgAge;
	private Long nbrSubmissions;
	private LineChartModel dateModel;
    private BarChartModel ageBarModel;
	private List<Input> inputs = new ArrayList<Input>();
	private PieChartModel pieModel;
	private List<PieChartModel> pieModels=new ArrayList<PieChartModel>();
	private List<LineChartModel> dateModels=new ArrayList<LineChartModel>();;
	
	
	public List<LineChartModel> getDateModels() {
		return dateModels;
	}

	public void setDateModels(List<LineChartModel> dateModels) {
		this.dateModels = dateModels;
	}

	public BarChartModel getAgeBarModel() {
		return ageBarModel;
	}

	public void setAgeBarModel(BarChartModel ageBarModel) {
		this.ageBarModel = ageBarModel;
	}

	public LineChartModel getDateModel() {
		return dateModel;
	}

	public void setDateModel(LineChartModel dateModel) {
		this.dateModel = dateModel;
	}

	public BarChartModel getAgebarModel() {
		return ageBarModel;
	}

	public void setAgebarModel(BarChartModel agebarModel) {
		ageBarModel = agebarModel;
	}

	public PieChartModel getPieModel() {
		return pieModel;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

	

	public Long getAvgAge() {
		return avgAge;
	}

	public void setAvgAge(Long avgAge) {
		this.avgAge = avgAge;
	}

	public Long getNbrSubmissions() {
		return nbrSubmissions;
	}

	public void setNbrSubmissions(Long nbrSubmissions) {
		this.nbrSubmissions = nbrSubmissions;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	public List<PieChartModel> getPieModels() {
		return pieModels;
	}

	public void setPieModels(List<PieChartModel> pieModels) {
		this.pieModels = pieModels;
	}

	public List<Input> getInputs() {
		return inputs;
	}

	public void setInputs(List<Input> inputs) {
		this.inputs = inputs;
	}
	
	private void createDateModels(Input input){
		LineChartModel  dateModel = new LineChartModel();
	    List<Object[]> counts=statDao.countValuesByDate(input);
		      
		        LineChartSeries series1 = new LineChartSeries();
		        series1.setLabel("Series 1");
		    
		     for(Object[] c :counts){
		    	  System.out.println("started");


		    	  
		    		series1.set(c[1], (Number) c[0]);
		    		

		        }
		      
		       
		      
		        dateModel.addSeries(series1);
		        dateModel.setTitle(input.getTitle());
		        dateModel.setZoom(true);
		        dateModel.getAxis(AxisType.Y).setLabel("nb Dates");
		        DateAxis axis = new DateAxis("Dates");
		        axis.setTickAngle(-50);
		        axis.setTickFormat("%b %#d, %y");
		         
		        dateModel.getAxes().put(AxisType.X, axis);
		        dateModels.add(dateModel);
		        
	}
	
	
	private void createPieModels(Input input) {
		 pieModel = new PieChartModel();
		 pieModel.setTitle(input.getTitle());
	     pieModel.setLegendPosition("w");
	         for(ListValue value:input.getListValues()){
	        	
	        	Long count = dao.countvalues(value, input);
	       	        	
	        pieModel.set(value.getValue(), count);
	        
	         }
	        
	        pieModels.add(pieModel);
	       System.out.println("pie models " +pieModels.size());
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

	 public void initStat() throws IOException{
	
		validateRequest();
	initAgeBarModel();
	initDateModel();
	



Form form=dao.getForm(form_id);
avgAge=statDao.avgAge(form);
nbrSubmissions=statDao.countSubmissions(form_id);


inputs = form.getInputs();
	for(Input input:inputs){
		if(input.getType().getIdType()==102 ||input.getType().getIdType()==105){
			createPieModels(input);
			}
		if(input.getType().getIdType()==106){
			createDateModels(input);
			}
		}
		}
	
	public void initAgeBarModel(){
		ageBarModel = new BarChartModel();
		Long[] counts=statDao.getCountsByGender(form_id); 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Male");
        boys.set("", counts[0]);
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Female");
        girls.set("", counts[1]);
        ageBarModel.addSeries(boys);
        ageBarModel.addSeries(girls);   
	}
	
	public void initDateModel(){
		 dateModel = new LineChartModel();
	     List<Object[]> counts=statDao.countSubmissionsByDate(form_id);
	      
	        LineChartSeries series1 = new LineChartSeries();
	        series1.setLabel("Series 1");
	    
	      for(Object[] c :counts){
	    	  System.out.println("started");
	    	  System.out.println("date: "+(Date) c[1]+" count"+(Number) c[0]);
	    	  Date date=(Date) c[1];
	    		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
	    		String formattedDate = dateFormatter.format(date);
	    		series1.set(formattedDate, (Number) c[0]);
	    		

	        }
	      
	        dateModel.addSeries(series1);
	        dateModel.setTitle("Submission dates");
	        dateModel.setZoom(true);
	        dateModel.getAxis(AxisType.Y).setLabel("Forms");
	        DateAxis axis = new DateAxis("Dates");
	        axis.setTickAngle(-50);
	        axis.setTickFormat("%b %#d, %y");
	         
	        dateModel.getAxes().put(AxisType.X, axis);
	       
	}
	}
