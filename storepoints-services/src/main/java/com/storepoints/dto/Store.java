package com.storepoints.dto;

public class Store {
	
	private String storeId;

	private String storeName;
	
	private String storeLandMark;
	
	private String addressLine1;

	private String addressLine2;
	
	private String storePostalCode;
	
	private String storeCityCode;
	
	private String storeCountryCode;

	private String storeDBName;
	
	private String storeDBHost;
	
	
	private StoreType storeType;
//	private String accessKey;

//	private String status;


	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}


	
	public StoreType getStoreType() {
		return storeType;
	}

	public void setStoreType(StoreType storeType) {
		this.storeType = storeType;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getStorePostalCode() {
		return storePostalCode;
	}

	public void setStorePostalCode(String storePostalCode) {
		this.storePostalCode = storePostalCode;
	}

	public String getStoreCityCode() {
		return storeCityCode;
	}

	public void setStoreCityCode(String storeCityCode) {
		this.storeCityCode = storeCityCode;
	}

	public String getStoreCountryCode() {
		return storeCountryCode;
	}

	public void setStoreCountryCode(String storeCountryCode) {
		this.storeCountryCode = storeCountryCode;
	}

	public String getStoreDBName() {
		return storeDBName;
	}

	public void setStoreDBName(String storeDBName) {
		this.storeDBName = storeDBName;
	}

	public String getStoreDBHost() {
		return storeDBHost;
	}

	public void setStoreDBHost(String storeDBHost) {
		this.storeDBHost = storeDBHost;
	}
	
	@Override
	public int hashCode(){
		return storeId.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
	    return (obj instanceof Store 
	            && hashCode() == ((Store) obj).hashCode());
	}
	
	public String getStoreLandMark() {
		return storeLandMark;
	}

	public void setStoreLandMark(String storeLandMark) {
		this.storeLandMark = storeLandMark;
	}
	
//	public String getAccessKey() {
//		return accessKey;
//	}
//
//	public void setAccessKey(String accessKey) {
//		this.accessKey = accessKey;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//


}
