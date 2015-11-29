package com.storepoints.dto;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "StoreAccount")
public class Account {
	
	private String accountId;

	private int storePoint;

	public int getStorePoint() {
		return storePoint;
	}

	public void setStorePoint(int storePoint) {
		this.storePoint = storePoint;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	
}
