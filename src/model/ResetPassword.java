package model;



import javax.persistence.*;



@Entity
@Table(name="password_reset")
public class ResetPassword  {
	@Id
	@Column(name="TOKEN")
	private String token;
	@ManyToOne
	@JoinColumn(name="ID_USER")
	private User user;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	


}