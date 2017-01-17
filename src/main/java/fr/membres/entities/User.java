package fr.membres.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userID;
	
	private String email;
	
	private String password;
	
	private boolean actived;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	private List<UserRoles> roles;
	
	@OneToOne(mappedBy="user")
	private Membre membre;
	

	public Long getUserID() {
		return userID;
	}

	
	
	public Membre getMembre() {
		return membre;
	}



	public void setMembre(Membre membre) {
		this.membre = membre;
	}



	public User(String email, String password, boolean actived) {
		super();
		this.email = email;
		this.password = password;
		this.actived = actived;
	}



	public boolean isActived() {
		return actived;
	}



	public void setActived(boolean actived) {
		this.actived = actived;
	}



	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserRoles> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRoles> roles) {
		this.roles = roles;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
}
