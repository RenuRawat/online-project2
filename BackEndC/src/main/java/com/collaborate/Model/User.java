package com.collaborate.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;






@Entity
@Table(name="AdminTable")
public class User{
	

//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int userId;
	@Id
	
	
    private String username;
	
	
	/*public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}*/
	
	 @NotNull(message="firstname is Null")
	private String firstname; 
	 @NotNull(message="surname is Null")
	private String surname; 
	
	@Pattern(regexp="^[789]\\d{9}$",message="number should be of 10 digits,and begins 9,8,7 since in india")
	 @NotNull
	 @Size(min=8, max=10, message="Enter correct number")
	private String phone;
	@Column(unique=true, nullable=false)
	private String email; 
	//private String confmemail;
	
	@NotNull(message="Password is Null")
	@Size(min=6 , max=12 , message="password lenght should be more than 6 and less than 12")
	private String password; 
	//private String confpassword;
	
	//private LocalDate birthDate;
	//private char gender;
	
	
	private String role; 
	private String status; 
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name="on_line")
	private Boolean isOnline;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	} 
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	public Boolean getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(Boolean isOnline) {
		this.isOnline = isOnline;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
	
/*	public String getConfmemail() {
		return confmemail;
	}
	public void setConfmemail(String confmemail) {
		this.confmemail = confmemail;
	}
	public String getConfpassword() {
		return confpassword;
	}
	public void setConfpassword(String confpassword) {
		this.confpassword = confpassword;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}*/

	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	
	
	
}