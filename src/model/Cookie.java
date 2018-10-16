package model;



import javax.persistence.*;



@Entity
@Table(name="cookie")
public class Cookie  {
	@Id
	@Column(name="ID")
	private String id;
	@ManyToOne
	@JoinColumn(name="ID_USER")
	private User user;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	


}