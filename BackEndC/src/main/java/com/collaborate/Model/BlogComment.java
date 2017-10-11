package com.collaborate.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Blogcomment")
public class BlogComment {
	
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
private int id;
private String commentText;

@ManyToOne
private User commentedBy; //FK commentedBy_username
private Date commentedOn;

@ManyToOne
private BlogPost blogPost; //FK blogpost_id








public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCommentText() {
	return commentText;
}

public void setCommentText(String commentText) {
	this.commentText = commentText;
}

public User getCommentedBy() {
	return commentedBy;
}

public void setCommentedBy(User commentedBy) {
	this.commentedBy = commentedBy;
}

public Date getCommentedOn() {
	return commentedOn;
}

public void setCommentedOn(Date commentedOn) {
	this.commentedOn = commentedOn;
}

public BlogPost getBlogPost() {
	return blogPost;
}

public void setBlogPost(BlogPost blogPost) {
	this.blogPost = blogPost;
}

	
	
	
	

}
