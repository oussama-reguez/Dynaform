package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the submitted_form database table.
 * 
 */
@Entity
@Table(name="submitted_form")
@NamedQuery(name="SubmittedForm.findAll", query="SELECT s FROM SubmittedForm s")
public class SubmittedForm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_SUBMITTED_FORM")
	private int idSubmittedForm;

	@Column(name="NAME")
	private String name;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_")
	private Date date;

	//bi-directional many-to-one association to Value
	@OneToMany(mappedBy="submittedForm",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Value> values;

	//bi-directional many-to-one association to Form
	@ManyToOne
	@JoinColumn(name="ID_FORM")
	private Form form;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="ID_USER")
	private User user;

	public SubmittedForm() {
	}

	public int getIdSubmittedForm() {
		return this.idSubmittedForm;
	}

	public void setIdSubmittedForm(int idSubmittedForm) {
		this.idSubmittedForm = idSubmittedForm;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Value> getValues() {
		return this.values;
	}

	public void setValues(List<Value> values) {
		this.values = values;
	}

	public Value addValue(Value value) {
		getValues().add(value);
		value.setSubmittedForm(this);

		return value;
	}

	public Value removeValue(Value value) {
		getValues().remove(value);
		value.setSubmittedForm(null);

		return value;
	}

	public Form getForm() {
		return this.form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}