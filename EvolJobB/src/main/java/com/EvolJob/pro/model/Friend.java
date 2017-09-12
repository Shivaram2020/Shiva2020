package com.EvolJob.pro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="frienddetails")
public class Friend {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;

@Column(name="from_id")
private String fromid;

@Column(name="to_id")
private String to;
private char status;

								/*Generating Getters and Setters*/

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFrom() {
	return fromid;
}
public void setFromId(String from) {
	this.fromid = from;
}
public String getTo() {
	return to;
}
public void setTo(String to) {
	this.to = to;
}
public char getStatus() {
	return status;
}
public void setStatus(char status) {
	this.status = status;
}

}

