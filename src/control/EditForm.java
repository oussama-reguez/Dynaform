package control;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import model.Form;
import model.Input;
import model.ListValue;
import model.Type;

import org.joda.time.DateTime;
import org.primefaces.event.CloseEvent;

import dao.FormDao;


@ManagedBean
@ViewScoped
public class EditForm {
    private List<Input> inputs = new ArrayList<Input>();
    private List<Input> removedInputs = new ArrayList<Input>();
    private List<Type> choices = new ArrayList<Type>();
    private List<ListValue> list = new ArrayList<ListValue>();
 public Type TEXTAREA;
 public Type SELECT;
    public String test ;
    public int selectedRow=0;
    public Input selectedInput ;
    
    
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
Type	CHECKBOX  = new Type();
CHECKBOX.setIdType(104);
CHECKBOX.setType("check boxes");
Type MULTIPLECHOICE = new Type();
MULTIPLECHOICE.setIdType(105);
MULTIPLECHOICE.setType("radio boxes");

Type DATE = new Type();
DATE.setIdType(106);
DATE.setType("date");

	choices.add(TEXTAREA); 
	 choices.add(PARAGRAPH);
	 choices.add(SELECT);
	 choices.add(CHECKBOX);
	 choices.add(MULTIPLECHOICE);
	 choices.add(DATE);
	 
}

	
 
 public List<Type> getChoices() {
	return choices;
}

public void setChoices(List<Type> choices) {
	this.choices = choices;
}

@PostConstruct
 public void Init(){
	 System.out.println("post constuct");
	 test="hl";
	 InitChoices();
	 form = dao.getForm(74);
System.out.println(form.getName());
	inputs=form.getInputs();
for(Input input:inputs){
	System.out.println(input.getTitle());
}

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
	
	public void delete(CloseEvent event){
		selectedRow = (Integer) event.getComponent().getAttributes().get("selectedRow");
		removedInputs.add(inputs.get(selectedRow));
		inputs.remove(selectedRow);
		int i=0;
		for(Input inputt:inputs){
			inputt.setOrder(i);
			i++;
		}
    
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
	        	inputs.clear();
	        	form.setName("Untitled");
	        	
	        	Input input= initInput(101, new Input());
	        	input.setOrder(0);
	        	input.setListValues(list);
	        		 inputs.add(input);
	        }
	    
	 public void submit(){
		
		for(Input input:removedInputs){
			dao.delete(input);
		}
		
		form.setInputs(inputs);
		 DateTime dt = new DateTime();
		form.setModifiedDate(dt.toDate());
		dao.updateForm(form);
	
	 }
	

	 }
	 