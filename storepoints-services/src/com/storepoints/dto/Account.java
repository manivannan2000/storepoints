package com.storepoints.dto;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "StoreAccount")
public class Account {
	
	/**
	 * version V1 for storepoints.
	 */
	private String accountid;

	private String storeid;

	private int storePoint;

	public String getStoreid() {
		return storeid;
	}

	public void setStoreid(String storeid) {
		this.storeid = storeid;
	}
	
	public int getStorePoint() {
		return storePoint;
	}

	public void setStorePoint(int storePoint) {
		this.storePoint = storePoint;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	
}
