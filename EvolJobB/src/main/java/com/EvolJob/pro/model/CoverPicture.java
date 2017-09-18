package com.EvolJob.pro.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="coverpicdetails")
public class CoverPicture {

@Id
private String username;

@Lob
private byte[] image;
	

								/*Generating Getters and Setters Method*/
	
		public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	

	
}