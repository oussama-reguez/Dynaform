package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the list_value database table.
 * 
 */
@Entity
@Table(name="list_value")
@NamedQuery(name="ListValue.findAll", query="SELECT l FROM ListValue l")
public class ListValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_LIST_VALUE")
	private int idListValue;

	private String value;

	//bi-directional many-to-one association to Input
	@ManyToOne
	@JoinColumn(name="ID_INPUT")
	private Input input;

	public ListValue() {
	}

	public int getIdListValue() {
		return this.idListValue;
	}

	public void setIdListValue(int idListValue) {
		this.idListValue = idListValue;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Input getInput() {
		return this.input;
	}

	public void setInput(Input input) {
		this.input = input;
	}   
	public String toString ( ){
	    return value; 
	}

}