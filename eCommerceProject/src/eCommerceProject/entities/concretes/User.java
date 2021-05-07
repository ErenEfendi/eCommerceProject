package eCommerceProject.entities.concretes;

import eCommerceProject.entities.abstracts.Entity;

public class User implements Entity {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	public User(String firstname, String lastname, String email, String password) {
		super();
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
		this.password = password;
	}
	public String getFirstname() {
		return firstName;
	}
	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}
	public String getLastname() {
		return lastName;
	}
	public void setLastname(String lastname) {
		this.lastName = lastname;
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
	
}
