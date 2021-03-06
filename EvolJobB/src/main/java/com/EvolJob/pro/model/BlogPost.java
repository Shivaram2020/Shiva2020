package com.EvolJob.pro.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="BlogPostDetails")
public class BlogPost {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	@NotEmpty
private String blogTitle;
@Lob  //Large Object
private String description;// CLOB - Character Large Object
@ManyToOne
private User postedBy;
private Date postedOn;
private boolean approved;






public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBlogTitle() {
	return blogTitle;
}
public void setBlogTitle(String blogTitle) {
	this.blogTitle = blogTitle;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public User getPostedBy() {
	return postedBy;
}
public void setPostedBy(User postedBy) {
	this.postedBy = postedBy;
}
public Date getPostedOn() {
	return postedOn;
}
public void setPostedOn(Date postedOn) {
	this.postedOn = postedOn;
}
public boolean isApproved() {
	return approved;
}
public void setApproved(boolean approved) {
	this.approved = approved;
}

}
