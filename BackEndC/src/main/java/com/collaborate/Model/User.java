package com.collaborate.Model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@SuppressWarnings("serial")
@Component
@Entity
@Table(name="AdminTable")
public class User implements Serializable{
	

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int userId;
	private String firstname; 
	private String surname; 
	private String phone;
	private String emailId; 
	private String confmemail;
	private String passwword; 
	private String confpassword;
	
	private LocalDate birthDate;
	private char gender;
	
	private String role; 
	private String status; 
	private Boolean isOnline;
	
	
	
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
		
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public Boolean getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(Boolean isOnline) {
		this.isOnline = isOnline;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getConfmemail() {
		return confmemail;
	}
	public void setConfmemail(String confmemail) {
		this.confmemail = confmemail;
	}
	public String getPasswword() {
		return passwword;
	}
	public void setPasswword(String passwword) {
		this.passwword = passwword;
	}
	public String getConfpassword() {
		return confpassword;
	}
	public void setConfpassword(String confpassword) {
		this.confpassword = confpassword;
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

	
	
}