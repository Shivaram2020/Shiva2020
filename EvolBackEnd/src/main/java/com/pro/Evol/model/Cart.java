package com.pro.Evol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Cart {
	@Id
	@GeneratedValue
	private int cartitemid;
	
	@Column(columnDefinition = "integer(10)")
	private int  prodid,quantity,price;
	
	@Column(columnDefinition = "varchar(30)")
	private String username;
	
	
	@Column(columnDefinition = "varchar(30)")
	private String productname,status;

	
	
   public int getCartitemid() {
		return cartitemid;
	}

	public void setCartitemid(int cartitemid) {
		this.cartitemid = cartitemid;
	}

	
	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
