package com.collaborate.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="AdminTable")
public class User implements Serializable{
	

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int Id;
	private String firstname; 
	private String lastname; 
	private String passwword; 
	private String emailId; 
	private String role; 
	private String status; 
	private String online;
	
	
	
	public int getId() {
		return Id;
	}
	public void setId(int userId) {
		this.Id = userId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPasswword() {
		return passwword;
	}
	public void setPasswword(String passwword) {
		this.passwword = passwword;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOnline() {
		return online;
	}
	public void setOnline(String online) {
		this.online = online;
	}

}
