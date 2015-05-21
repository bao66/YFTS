package com.mercury.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OwnsKey implements Serializable{
	private String username;
	private String companyName;
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
	
	@Override
	public int hashCode(){
		return (username+" "+companyName).hashCode();
	}
	
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof OwnsKey)) return false;
		OwnsKey ok=(OwnsKey)obj;
		return username.equals(ok.username) && companyName.equals(ok.companyName);
	}

}
