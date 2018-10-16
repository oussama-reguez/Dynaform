package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the input database table.
 * 
 */
@Entity
@NamedQuery(name="Input.findAll", query="SELECT i FROM Input i")
public class Input implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_INPUT")
	private int idInput;

	@Transient 
	 private Object value; 
	@Column(name="INPUT_ORDER")
	 private int order;  
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Column(name="`LABEL`")
	private String label;

	

	private String title;

	//bi-directional many-to-one association to Form

	@JoinColumn(name="ID_FORM")
	private Form form;

	//bi-directional many-to-one association to Type
	@ManyToOne
	@JoinColumn(name="ID_TYPE")
	private Type type;

	//bi-directional many-to-one association to ListValue
	@OneToMany(mappedBy="input",cascade = CascadeType.ALL)
	private List<ListValue> listValues;

	//bi-directional many-to-one association to Value
	@OneToMany(mappedBy="input",cascade = CascadeType.ALL)
	private List<Value> values;

	public Input() {
	}

	public int getIdInput() {
		return this.idInput;
	}

	public void setIdInput(int idInput) {
		this.idInput = idInput;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}



	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Form getForm() {
		return this.form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<ListValue> getListValues() {
		return this.listValues;
	}

	public void setListValues(List<ListValue> listValues) {
		this.listValues = listValues;
	}

	public ListValue addListValue(ListValue listValue) {
		getListValues().add(listValue);
		listValue.setInput(this);

		return listValue;
	}

	public ListValue removeListValue(ListValue listValue) {
		getListValues().remove(listValue);
		listValue.setInput(null);

		return listValue;
	}

	public List<Value> getValues() {
		return this.values;
	}

	public void setValues(List<Value> values) {
		this.values = values;
	}

	public Value addValue(Value value) {
		getValues().add(value);
		value.setInput(this);

		return value;
	}

	public Value removeValue(Value value) {
		getValues().remove(value);
		value.setInput(null);

		return value;
	}

}