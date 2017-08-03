package com.pro.Evol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Offer {
	@Id
	@GeneratedValue
	private int offid;
	@Column(columnDefinition = "varchar(30)")
	private String offname;
@Column(columnDefinition="varchar(50)")
	private String offdesc;


public int getOffid() {
		return offid;
	}
	public void setOffid(int offid) {
		this.offid = offid;
	}
	public String getOffname() {
		return offname;
	}
	public void setOffname(String offname) {
		this.offname = offname;
	}
	public String getOffdesc() {
		return offdesc;
	}
	public void setOffdesc(String offdesc) {
		this.offdesc = offdesc;
	}


}
