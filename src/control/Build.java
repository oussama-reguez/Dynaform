package control;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;





import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;


import javax.imageio.ImageIO;




import org.joda.time.DateTime;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;


import org.primefaces.model.DefaultDashboardModel;
import org.primefaces.model.UploadedFile;




import dao.FormDao;
import model.Form;
import model.Input;
import model.ListValue;
import model.Type;


@ManagedBean
@ViewScoped
public class Build {
    private List<Input> inputs = new ArrayList<Input>();
    private List<Input> removedInputs = new ArrayList<Input>();
    private List<Input> AddedInputs = new ArrayList<Input>();
    private int form_id=0;
    
  
	public int getForm_id() {
		return form_id;
	}


	public void setForm_id(int form_id) {
		this.form_id = form_id;
	}
	private List<Type> choices = new ArrayList<Type>();
    private List<ListValue> list = new ArrayList<ListValue>();
 public Type TEXTAREA;
 public Type SELECT;
 private DefaultDashboardModel model ;
    public String test ;
    public int selectedRow=0;
    public Input selectedInput ;
    private UploadedFile file;
    BufferedImage resizedImage;
    static final int JPEG=5;
	public DefaultDashboardModel getModel() {
		return model;
	}
	

	public void setModel(DefaultDashboardModel model) {
		this.model = model;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
public void showInputs(){
	int i=0;
	for(Input input:inputs){
	System.out.println("////////////////////////////////");
	System.out.println("input position :"+i);
	System.out.println("input order variable :"+input.getOrder());
	i++;
	System.out.println("input question"+input.getTitle());
	System.out.println("////////////////////////////////");
	}
}
public void addOussama(){
	Input input = new Input();
	input.setTitle("oussama");
	input.setType(TEXTAREA);
	inputs.add(input);
}
public void te(){
	System.out.println("te te");
}
	@ManagedProperty(value = "#{login}")
	Login login ;
 public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

public Input getSelectedInput() {
		return selectedInput;
	}

	public void setSelectedInput(Input selectedInput) {
		this.selectedInput = selectedInput;
	}

public int getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(int selectedRow) {
		this.selectedRow = selectedRow;
	}



private Form form ;
 public Form getForm() {
	return form;
}

public void setForm(Form form) {
	this.form = form;
}



@EJB
	FormDao dao ;
 

public void initTextArea(){
	TEXTAREA = new Type();
	TEXTAREA.setIdType(101);
	TEXTAREA.setType("textarea");
}

public void validateForm(){
	System.out.println(inputs.size());
	if(inputs.size()==0){
		RequestContext.getCurrentInstance().execute( "PF('dlg1').show()");
	}
	else {
		System.out.println("good");
		
	}
	System.out.println("done");
}

public Input initInput(int id,Input input){

	
	input.setForm(form);
	Type type = new Type();
type.setIdType(id);
	input.setType(type);
	if(type.getIdType()==102||type.getIdType()==105)
	{ListValue value = new ListValue();
	   value.setValue("");
	   value.setInput(input);

List<ListValue> list = new ArrayList<ListValue>();
list.add(value);
input.setListValues(list);}
return input;
}
public void InitChoices(){
	Type TEXTAREA = new Type();
	TEXTAREA.setIdType(101);
	TEXTAREA.setType("Text");
	Type SELECT = new Type();
	SELECT.setIdType(102);
	SELECT.setType("choose from a list");

	Type PARAGRAPH =new Type ();
	PARAGRAPH.setIdType(103);
	PARAGRAPH.setType("paragraph");

Type RADIOBOXES = new Type();
RADIOBOXES .setIdType(105);
RADIOBOXES .setType("radio boxes");

Type DATE = new Type();
DATE.setIdType(106);
DATE.setType("date");

	choices.add(TEXTAREA); 
	 choices.add(PARAGRAPH);
	 choices.add(SELECT);
	 choices.add(RADIOBOXES );
	 choices.add(DATE);
	 
}

	
 
 public List<Type> getChoices() {
	return choices;
}

public void setChoices(List<Type> choices) {
	this.choices = choices;
}



 


	

    
	

   
	public void valueChangeMethod(AjaxBehaviorEvent e){
		selectedRow = (Integer) e.getComponent().getAttributes().get("selectedRow");
	
		int id_type =inputs.get(selectedRow).getType().getIdType();
	
		if((id_type==102) || (id_type==104) ||(id_type==105)  ){
			
			
			ListValue value = new ListValue();
		   value.setValue("");
		   value.setInput(inputs.get(selectedRow));

	   List<ListValue> list = new ArrayList<ListValue>();
	  list.add(value);
	  inputs.get(selectedRow).setListValues(list);
   }
		

  
   }
		
		/*int position =getIdAjax(e);
		Input input  = inputs.get(position);
		
	    if (input.getType().getType().equals("select")){
	    	Type type = new Type();
	    	type.setIdType(102);
	    	
	    	
	   input.setType(type);
	   
	  
	    ListValue val = new ListValue();
	   val.setValue("");
	   val.setInput(input);
	   List <ListValue> list = new  ArrayList<ListValue>();
	   list.add(val);
	   input.setListValues(list);
	   System.out.println("input title" +input.getTitle());
	   if(input == null){
	   System.out.println("input = null");
	   
	   }
	   System.out.println("type="+input.getType().getType());
	    }
	   
		*/

	    //		Input input = new Input();
//		Type type=new Type();
//		type.setType("textarea");
//		input.setType(type);
//		inputs.add(input);
	    
	    	
		

   
    public List<Input> getInputs() {
		return inputs;
	}
	public void setInputs(List<Input> inputs) {
		this.inputs = inputs;
	}
	
	public void delete(ActionEvent event){
		System.out.println("start");
		selectedRow = (Integer) event.getComponent().getAttributes().get("selectedRow");
		System.out.println(selectedRow);
		inputs.remove(selectedRow);
		System.out.println("input Size" +inputs.size());
		int i=0;
		for(Input inputt:inputs){
			inputt.setOrder(i);
			i++;
		}
		showInputs();
		
    }
	
	public void deleteInput(ActionEvent event){
		System.out.println("start");
		selectedRow = (Integer) event.getComponent().getAttributes().get("selectedRow");
		System.out.println(selectedRow);
		removedInputs.add(selectedInput);
		inputs.remove(selectedRow);
		System.out.println("input Size" +inputs.size());
		int i=0;
		for(Input inputt:inputs){
			inputt.setOrder(i);
			i++;
		}
		showInputs();
		
	}
	public void addInput(ActionEvent actionEvent ) {
		
		Input input = initInput(101, new Input());
		selectedRow = (Integer) actionEvent.getComponent().getAttributes().get("selectedRow");
		//selectedInput = (Input) actionEvent.getComponent().getAttributes().get("selectedInput");
      input.setOrder(selectedRow+1);
     
		inputs.add(selectedRow+1, input);
		int i=0;
	for(Input inputt:inputs){
		inputt.setOrder(i);
		i++;
	}
		
	

	
		
			 
	}
	
 public void addValueList(ActionEvent actionEvent){
	 selectedRow = (Integer) actionEvent.getComponent().getAttributes().get("selectedRow");
	    ListValue val = new ListValue();
	    
	   val.setValue("");
	   val.setInput(inputs.get(selectedRow));
	inputs.get(selectedRow).getListValues().add(val);

	
	  
	 

	         
	 
 }
 
	

	
	
	
	


		
		

		// System.out.println(selectedInput.getTitle());
		/* List<ListValue> lists = new ArrayList<ListValue>();
		 for(ListValue value:inputs.get(fromIndex).getListValues()){
			 ListValue lvalue = new ListValue();
			 lvalue.setValue(value.getValue());
			 lists.add(lvalue);
		 }
	inputs.add(toIndex,inputs.get(fromIndex));
inputs.get(fromIndex).setListValues(lists);
	inputs.remove(fromIndex+1);
System.out.println("start order");
		 int i=0;
	for(Input input:inputs){
		input.setOrder(i);
		i++;
	}*/
	
	
		 public void addText(ActionEvent actionevent){
			 Input input = initInput(101, new Input());
				selectedRow = (Integer) actionevent.getComponent().getAttributes().get("selectedRow");
				//selectedInput = (Input) actionEvent.getComponent().getAttributes().get("selectedInput");
		      input.setOrder(selectedRow+1);
		     
				inputs.add(selectedRow+1, input);
				int i=0;
			for(Input inputt:inputs){
				inputt.setOrder(i);
				i++;
			}
			
		
		 }
		 public void addParagraph(ActionEvent actionevent){
			 Input input = initInput(103, new Input());
				selectedRow = (Integer) actionevent.getComponent().getAttributes().get("selectedRow");
				//selectedInput = (Input) actionEvent.getComponent().getAttributes().get("selectedInput");
		      input.setOrder(selectedRow+1);
		     
				inputs.add(selectedRow+1, input);
				int i=0;
			for(Input inputt:inputs){
				inputt.setOrder(i);
				i++;
			}
			
		
		 }
		 public void addList(ActionEvent actionevent){
			 Input input = initInput(102, new Input());
				selectedRow = (Integer) actionevent.getComponent().getAttributes().get("selectedRow");
				//selectedInput = (Input) actionEvent.getComponent().getAttributes().get("selectedInput");
		      input.setOrder(selectedRow+1);
		     
				inputs.add(selectedRow+1, input);
				int i=0;
			for(Input inputt:inputs){
				inputt.setOrder(i);
				i++;
			}
		 }
			
			 public void addRadio(ActionEvent actionevent){
				 Input input = initInput(105, new Input());
					selectedRow = (Integer) actionevent.getComponent().getAttributes().get("selectedRow");
					//selectedInput = (Input) actionEvent.getComponent().getAttributes().get("selectedInput");
			      input.setOrder(selectedRow+1);
			     
					inputs.add(selectedRow+1, input);
					int i=0;
				for(Input inputt:inputs){
					inputt.setOrder(i);
					i++;
				}
			 }
				 public void addDate(ActionEvent actionevent){
					 Input input = initInput(106, new Input());
						selectedRow = (Integer) actionevent.getComponent().getAttributes().get("selectedRow");
						//selectedInput = (Input) actionEvent.getComponent().getAttributes().get("selectedInput");
				      input.setOrder(selectedRow+1);
				     
						inputs.add(selectedRow+1, input);
						int i=0;
					for(Input inputt:inputs){
						inputt.setOrder(i);
						i++;
					}
			
			
		
		 }
	        public void clear(){
	        	//  
	        	RequestContext.getCurrentInstance().execute( "location.reload()");
	        	
	        	/*inputs = new ArrayList<Input>();
	        	form.setName("Untitled");
	        	
	        	Input input= initInput(101, new Input());
	        	input.setOrder(0);
	        	input.setListValues(list);
	        		 inputs.add(input);*/
	        }
	        
	        public void upload(FileUploadEvent event) throws IOException {
	        
if(file==null){
	System.out.println("null");
}
file=event.getFile();
		 		 InputStream inputStream=file.getInputstream();
		 	        
		 	        BufferedImage originalImage = ImageIO.read(inputStream);
		 			int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
		 	 
		 			 resizedImage = new BufferedImage(32, 32, type);
		 			Graphics2D g = resizedImage.createGraphics();
		 			g.drawImage(originalImage, 0, 0, 32, 32, null);
		 			g.dispose();
		 			changeFormPicture();
		 		
		 	System.out.println("done");
	        }
	    
	 
	 	public void changeFormPicture() throws IOException{
	 		String name=Integer.toString(resizedImage.hashCode());
	 		if(resizedImage.getType()==JPEG){
	 			
	 			
	 			ImageIO.write(resizedImage, "jpg", new File("g:\\images\\form\\"+name+".jpg")); 
	 		form.setForm_picture("/images/form/"+name+".jpg");

	 			}
	 			else{
	 				ImageIO.write(resizedImage, "jpg", new File("g:\\images\\form\\"+name+".png")); 
	 		 		form.setForm_picture("/images/form/"+name+".png");

	 			}
	 		RequestContext.getCurrentInstance().execute("PF('chartPanelWidhget').hide();");
	 		//dao.updateUser(login.getUser());
	 		FacesMessage message =  new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Picture changed successfully!");
	 		FacesContext context = FacesContext.getCurrentInstance();
	 		context.addMessage("growl", message);	
	 		
	 		
	 	}
	        
	        public void redirect() throws IOException{
	        	FacesContext.getCurrentInstance().getExternalContext().redirect("viewForms.xhtml");
	        }
	        
	 public void submit(){
		 if(inputs.size()==0){
				RequestContext.getCurrentInstance().execute( "PF('dlg1').show()");
			}
			else {
				form.setInputs(inputs);
				 DateTime dt = new DateTime();
				form.setCreationDate(dt.toDate());
				form.setUser(login.getUser());
				dao.persist(form);
				 
				System.out.println("form saved ");
				RequestContext.getCurrentInstance().execute( "PF('dlg3').show()");
			}
	System.out.println("submit");
	
		
	
	 }
	
	 
	 public void initNewForm(){
			
		 InitChoices();
		 form = new Form();
		 form.setName("Untitled");
		 
		 System.out.println("post constuct");

	Input input= initInput(101, new Input());
	input.setOrder(0);
	input.setListValues(list);
		 inputs.add(input);

	 }
	 
	 public void validateRequest() throws IOException{
		 int form_id;
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
	       else{
	     
	       	System.out.println("verifying ownership !!");
	       	if(form.getUser().getIdUser()!=login.getUser().getIdUser()){
	       		FacesContext.getCurrentInstance().getExternalContext().dispatch("/faces/Presets/accessDenied.xhtml");
	       
	       	System.out.println("access denied");
	       	}
	       	
	       }
	 }
	 public void initForm() throws IOException{
		 
		validateRequest();
		
		 InitChoices();
		

	inputs=form.getInputs();
	 }
	
	 public void removeInput(ActionEvent event){
			System.out.println("start removing");
			selectedRow = (Integer) event.getComponent().getAttributes().get("selectedRow");
			System.out.println(selectedRow);
			removedInputs.add(inputs.get(selectedRow));
			inputs.remove(selectedRow);
			System.out.println("input Size" +inputs.size());
			int i=0;
			for(Input inputt:inputs){
				inputt.setOrder(i);
				i++;
			}
			showInputs();
			
		 
	 }
	 public void showSuccessDialog(){
			RequestContext.getCurrentInstance().execute("PF('dgl2').show();");
	 }
public void updateForm(){
	 DateTime dt = new DateTime();
		form.setModifiedDate(dt.toDate());
	dao.updateForm(form);
	System.out.println("removed inputs "+removedInputs.size());
	for(Input input:removedInputs){
		System.out.println("deleted");
		dao.delete(input);
	}
	
	form.setInputs(inputs);
	
	
	System.out.println("done deleting");
}
	 }
	 



