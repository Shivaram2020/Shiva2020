package com.pro.Evol.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Product<MultipartFile> {
	@Id
	@GeneratedValue
	@Column (columnDefinition="integer(10)")
	private int prodid;
	@Column (columnDefinition="integer(5)")
	private int catid,suppid,quantity,offid;
	@Column (columnDefinition="integer(10)")
	private int price;
	@Column (columnDefinition="varchar(30)")
	private String prodname;
	@Column (columnDefinition="varchar(500)")
	private String proddesc;
	
	@Transient
	MultipartFile pimage;
	
	public int getOffid() {
		return offid;
	}
	public void setOffid(int offid) {
		this.offid = offid;
	}
	
	public MultipartFile getPimage() {
		return pimage;
	}
	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}
	public String getProddesc() {
		return proddesc;
	}
	public void setProddesc(String proddesc) {
		this.proddesc = proddesc;
	}
	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public int getSuppid() {
		return suppid;
	}
	public void setSuppid(int suppid) {
		this.suppid = suppid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	

}
