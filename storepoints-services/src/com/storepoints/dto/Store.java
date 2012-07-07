package com.storepoints.dto;

public class Store {
	
	private String storeId;

	private String storeName;
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
	
	@Override
	public int hashCode(){
		return storeId.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
	    return (obj instanceof Store 
	            && hashCode() == ((Store) obj).hashCode());
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
