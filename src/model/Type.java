package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the type database table.
 * 
 */
@Entity
@NamedQuery(name="Type.findAll", query="SELECT t FROM Type t")
public class Type implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TYPE")
	private int idType;

	private String type;

	//bi-directional many-to-one association to Input
	@OneToMany(mappedBy="type")
	private List<Input> inputs;

	public Type() {
	}

	public int getIdType() {
		return this.idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Input> getInputs() {
		return this.inputs;
	}

	public void setInputs(List<Input> inputs) {
		this.inputs = inputs;
	}

	public Input addInput(Input input) {
		getInputs().add(input);
		input.setType(this);

		return input;
	}

	public Input removeInput(Input input) {
		getInputs().remove(input);
		input.setType(null);

		return input;
	}

}