package com.mercury.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="transactions")
public class Transactions {
	@Id
	@GeneratedValue(generator = "generator")     
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name="transid")
	private int transId;
	@Column(name="username")
	private String username;
	@Column(name="companyname")
	private String companyName;
	@Column(name="buyorsell")
	private int buyOrSell;
	@Column(name="quantity")
	private int quantity;
	@Column(name="transtime")
	private String transTime;
	@Column(name="stock_companyname")
	private String stock_companyName;
	@Column(name="trader_username")
	private String trader_username;
	@Column(name="unitprice")
	private double unitPrice;
	@Column(name="totalprice")
	private double totalPrice;
	
	public Transactions(){}
	public Transactions(String username, String companyName,
			int buyOrSell, int quantity, String transTime, String stock_companyName,
			String trader_username, double unitPrice, double totalPrice){
		this.username=username;
		this.companyName=companyName;
		this.buyOrSell=buyOrSell;
		this.quantity=quantity;
		this.transTime=transTime;
		this.stock_companyName=stock_companyName;
		this.trader_username=trader_username;
		this.unitPrice=unitPrice;
		this.totalPrice=totalPrice;
	}
	public int getTransId() {
		return transId;
	}
	public void setTransId(int transId) {
		this.transId = transId;
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
	public int getBuyOrSell() {
		return buyOrSell;
	}
	public void setBuyOrSell(int buyOrSell) {
		this.buyOrSell = buyOrSell;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getTransTime() {
		return transTime;
	}
	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}
	public String getStock_companyName() {
		return stock_companyName;
	}
	public void setStock_companyName(String stock_companyName) {
		this.stock_companyName = stock_companyName;
	}
	public String getTrader_username() {
		return trader_username;
	}
	public void setTrader_username(String trader_username) {
		this.trader_username = trader_username;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	//Only for testing mapping
	@Override
	public String toString(){
		return transId+" "+" "+username+" "+companyName+" "+buyOrSell+" "
				+quantity+" "+transTime+" "+stock_companyName+" "
				+trader_username+" "+unitPrice+" "+totalPrice;
	}

}
