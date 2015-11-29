package com.storepoints.dto;

import java.util.ArrayList;
import java.util.List;



public class User {
	
	private String userId;
	
	private ContactPhoneList contactPhoneList;
	
	private ContactEmailList contactEmailList;
	
	private List<String> storeList;
	
	private String firstName;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	private String lastName;
	
	public ContactPhoneList getContactPhoneList() {
		return contactPhoneList;
	}

	public void setContactPhoneList(ContactPhoneList contactPhoneList) {
		this.contactPhoneList = contactPhoneList;
	}

	public ContactEmailList getContactEmailList() {
		return contactEmailList;
	}

	public void setContactEmailList(ContactEmailList contactEmailList) {
		this.contactEmailList = contactEmailList;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public List<String> getStoreList(){
		if(storeList==null){
			storeList = new ArrayList<String>();
		}

		return storeList;
	}

 
}
