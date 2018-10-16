package model;

import java.io.Serializable;

import javax.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the form database table.
 * 
 */
@Entity
@NamedQuery(name="Form.findAll", query="SELECT f FROM Form f")
public class Form implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_FORM")
	private int idForm;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DATE")
	private Date creationDate;

	@Temporal(TemporalType.DATE)
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;

	private String name;
	@Column(name="FORM_PICTURE")
	private String form_picture="/images/form/default.jpg" ;
	
	public String getForm_picture() {
		return form_picture;
	}

	public void setForm_picture(String form_picture) {
		this.form_picture = form_picture;
	}
	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="ID_USER")
	private User user;

	//bi-directional many-to-one association to Input
	@OneToMany(mappedBy="form" ,cascade = CascadeType.ALL)
	@OrderBy("order ASC")
	private List<Input> inputs;

	//bi-directional many-to-one association to SubmittedForm
	@OneToMany(mappedBy="form" ,cascade = CascadeType.ALL)
	@OrderBy("date DSC")
	private List<SubmittedForm> submittedForms;

	public Form() {
	}

	public int getIdForm() {
		return this.idForm;
	}

	public void setIdForm(int idForm) {
		this.idForm = idForm;
	}

	public Date getCreationDate()
	{
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Input> getInputs() {
		return this.inputs;
	}

	public void setInputs(List<Input> inputs) {
		this.inputs = inputs;
	}

	public Input addInput(Input input) {
		getInputs().add(input);
		input.setForm(this);

		return input;
	}

	public Input removeInput(Input input) {
		getInputs().remove(input);
		input.setForm(null);

		return input;
	}

	public List<SubmittedForm> getSubmittedForms() {
		return this.submittedForms;
	}

	public void setSubmittedForms(List<SubmittedForm> submittedForms) {
		this.submittedForms = submittedForms;
	}

	public SubmittedForm addSubmittedForm(SubmittedForm submittedForm) {
		getSubmittedForms().add(submittedForm);
		submittedForm.setForm(this);

		return submittedForm;
	}

	public SubmittedForm removeSubmittedForm(SubmittedForm submittedForm) {
		getSubmittedForms().remove(submittedForm);
		submittedForm.setForm(null);

		return submittedForm;
	}
public String formatCreationDate(){
	SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
	// Printing the date
	
	
	return dateFormatter.format(creationDate);
}
public String formatModifiedDate(){
	SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
	// Printing the date
	
	
	return dateFormatter.format(modifiedDate);
}
}