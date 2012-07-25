package com.storepoints.service;

public class AccountData {
	
	private String accountId;
	
	private String storeId;
	
	private String storeName;
	
	private String storeLandMark;

	private int storePoint;

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getStorePoint() {
		return storePoint;
	}

	public void setStorePoint(int storePoint) {
		this.storePoint = storePoint;
	}
	
	public String getStoreLandMark() {
		return storeLandMark;
	}

	public void setStoreLandMark(String storeLandMark) {
		this.storeLandMark = storeLandMark;
	}
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
}
