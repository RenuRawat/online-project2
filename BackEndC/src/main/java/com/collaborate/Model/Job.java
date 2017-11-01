package com.collaborate.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JobTable")
public class Job {
	
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private String jobTitle, jobDescription, skillsRequired, salary, location, companyname, position, vacancy;
	
	
	private char status;
	

	private Date postedOn;
	
	private String q_10;
	private String q_12;
	private String q_ug;
	
	
	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
	public String getVacancy() {
		return vacancy;
	}

	public void setVacancy(String vacancy) {
		this.vacancy = vacancy;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getQ_10() {
		return q_10;
	}

	public void setQ_10(String q_10) {
		this.q_10 = q_10;
	}

	public String getQ_12() {
		return q_12;
	}

	public void setQ_12(String q_12) {
		this.q_12 = q_12;
	}

	public String getQ_ug() {
		return q_ug;
	}

	public void setQ_ug(String q_ug) {
		this.q_ug = q_ug;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getSkillsRequired() {
		return skillsRequired;
	}

	public void setSkillsRequired(String skillsRequired) {
		this.skillsRequired = skillsRequired;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}



	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}
	
	

	
}
