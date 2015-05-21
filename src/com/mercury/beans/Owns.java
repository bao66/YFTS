package com.mercury.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="owns")
@IdClass(OwnsKey.class)
public class Owns {
	@Id
	@Column(name="username")
	private String username;
	@Id
	@Column(name="companyName")
	private String companyName;
	@Column(name="quantity")
	private int quantity;
	
	public Owns(){}
	public Owns(String username, String companyName, int quantity){
		this.username=username;
		this.companyName=companyName;
		this.quantity=quantity;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	//Only for testing mapping
	@Override
	public String toString(){
		return username+" "+companyName+" "+quantity;
	}
}
