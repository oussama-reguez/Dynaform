package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_USER")
	private int idUser;
     @Column(name="GENDER")
     private String gender;
     @Column(name="AGE")
     private int age ;
     @Column(name="LANGUAGE")
     private String language="en" ;
	private String email;
	@Column(name="FIRSTNAME")
	private String firstName;
	@Column(name="LASTNAME")
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="BIRTHDATE")
	private Date birthDate ;
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private String password;


	private String username;
	@Column(name="USER_PICTURE")
	private String user_picture="/images/user/default.jpg" ;

	public String getUser_picture() {
		return user_picture;
	}

	public void setUser_picture(String user_picture) {
		this.user_picture = user_picture;
	}

	//bi-directional many-to-one association to Form
	@OneToMany(mappedBy="user")
	private List<Form> forms;

	//bi-directional many-to-one association to SubmittedForm
	@OneToMany(mappedBy="user")
	private List<SubmittedForm> submittedForms;

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Form> getForms() {
		return this.forms;
	}

	public void setForms(List<Form> forms) {
		this.forms = forms;
	}

	public Form addForm(Form form) {
		getForms().add(form);
		form.setUser(this);

		return form;
	}

	public Form removeForm(Form form) {
		getForms().remove(form);
		form.setUser(null);

		return form;
	}

	public List<SubmittedForm> getSubmittedForms() {
		return this.submittedForms;
	}

	public void setSubmittedForms(List<SubmittedForm> submittedForms) {
		this.submittedForms = submittedForms;
	}

	public SubmittedForm addSubmittedForm(SubmittedForm submittedForm) {
		getSubmittedForms().add(submittedForm);
		submittedForm.setUser(this);

		return submittedForm;
	}

	public SubmittedForm removeSubmittedForm(SubmittedForm submittedForm) {
		getSubmittedForms().remove(submittedForm);
		submittedForm.setUser(null);

		return submittedForm;
	}

}