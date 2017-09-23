package com.EvolJob.pro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserDetails")
public class User {
@Id
	@Column(columnDefinition = "varchar(15)")
	private String username;
	@Column(columnDefinition = "varchar(15)")
	private String password,role;
	@Column(columnDefinition = "varchar(50)")
	private String email;
	@Column(columnDefinition = "varchar(15)")
	private int mobileno;
	@Column(columnDefinition = "varchar(100)")
	private String address;
	
	@Column(columnDefinition = "varchar(100)")
	private String currentstatus;
	
	@Column(name="status")
	private boolean online;

	
	
	public String getCurrentstatus() {
		return currentstatus;
	}
	public void setCurrentstatus(String currentstatus) {
		this.currentstatus = currentstatus;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMobileno() {
		return mobileno;
	}
	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}

public boolean isOnline() {
	return online;
}
public void setOnline(boolean online) {
	this.online = online;
}

}