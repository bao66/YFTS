package com.mercury.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Stocks")
public class Stocks {
	@Id
	@Column(name="companyname")
	private String companyName;
	@Column(name="numofavailable")
	private int numOfAvailable;
	
	public Stocks(){}
	public Stocks(String companyName, int numOfAvailable){
		this.companyName=companyName;
		this.numOfAvailable=numOfAvailable;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getNumOfAvailable() {
		return numOfAvailable;
	}
	public void setNumOfAvailable(int numOfAvailable) {
		this.numOfAvailable = numOfAvailable;
	}

	//Only for testing mapping
	@Override
	public String toString(){
		return companyName+" "+numOfAvailable;
	}
}
