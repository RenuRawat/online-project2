package com.collaborate.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Table(name="AppliedJobTable")
@Entity
public class JobApplied
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Date postedOn;
	
	@ManyToOne
	private User applyBy;
	
	
	private String jobTitle;
	private String position;
	private String companyname;
	private String location;
	private char status;
	
	
	
	public User getApplyBy() {
		return applyBy;
	}
	public void setApplyBy(User applyBy) {
		this.applyBy = applyBy;
	}
	public Date getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	
	
		
}