package com.pro.Evol.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Oders {
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getOrderid() {
		return orderid;
	}


	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}


	public String getCartid() {
		return cartid;
	}


	public void setCartid(String cartid) {
		this.cartid = cartid;
	}


	public String getPaymode() {
		return paymode;
	}


	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}


	public String getShipmentaddress() {
		return shipmentaddress;
	}


	public void setShipmentaddress(String shipmentaddress) {
		this.shipmentaddress = shipmentaddress;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Id
	@GeneratedValue
	private int id;
	
	
	@Column(columnDefinition = "varchar(30)")
	private String username,orderid,cartid,paymode,shipmentaddress,status;
	

	

}
