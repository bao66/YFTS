package com.mercury.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Traders")
public class Traders {
	@Id
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;
	@Column(name="balance")
	private double balance;
	@Column(name="authority")
	private String authority;
	@Column(name="enable")
	private int enable;
	
	public Traders(){}
	public Traders(String username, String password, String email, double balance,
		String authority, int enable){
		this.username=username;
		this.password=password;
		this.email=email;
		this.balance=balance;
		this.authority=authority;
		this.enable=enable;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	
	//Just for testing mapping
	@Override
	public String toString(){
		return username+" "+password+" "+email+" "+balance+" "+authority+" "+enable;
	}

}
