package com.storepoints.dto;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "StoreAccount")
public class Account {
	
	/**
	 * version V1 for storepoints.
	 */
	private String accountid;
	private String accountName;
	private int storePoint;
	private StoreType storeType;

	public int getStorePoint() {
		return storePoint;
	}

	public void setStorePoint(int storePoint) {
		this.storePoint = storePoint;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}


	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	
	public StoreType getStoreType() {
		return storeType;
	}

	public void setStoreType(StoreType storeType) {
		this.storeType = storeType;
	}
}
