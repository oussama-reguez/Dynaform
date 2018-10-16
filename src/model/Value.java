package model;

import java.io.Serializable;

import javax.persistence.*;



@Entity
@NamedQuery(name="Value.findAll", query="SELECT v FROM Value v")
public class Value implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_VALUE")
	private int idValue;

	private String value;

	//bi-directional many-to-one association to SubmittedForm
	@ManyToOne
	@JoinColumn(name="ID_SUBMITTED_FORM")
	private SubmittedForm submittedForm;

	//bi-directional many-to-one association to Input
	@ManyToOne
	@JoinColumn(name="ID_INPUT")
	private Input input;

	public Value() {
	}

	public int getIdValue() {
		return this.idValue;
	}

	public void setIdValue(int idValue) {
		this.idValue = idValue;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public SubmittedForm getSubmittedForm() {
		return this.submittedForm;
	}

	public void setSubmittedForm(SubmittedForm submittedForm) {
		this.submittedForm = submittedForm;
	}

	public Input getInput() {
		return this.input;
	}

	public void setInput(Input input) {
		this.input = input;
	}

}