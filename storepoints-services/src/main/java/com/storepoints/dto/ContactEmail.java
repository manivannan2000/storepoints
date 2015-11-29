package com.storepoints.dto;

public class ContactEmail {
	
	private String contactEmailID;
	

	private String contactEmailAddress;
	
	private StatusType contactEmailStatus;

	private String addedDate;
	
	public String getContactEmailID() {
		return contactEmailID;
	}

	public void setContactEmailID(String contactEmailID) {
		this.contactEmailID = contactEmailID;
	}
	
	public String getContactEmailAddress() {
		return contactEmailAddress;
	}

	public void setContactEmailAddress(String contactEmailAddress) {
		this.contactEmailAddress = contactEmailAddress;
	}
	
	
	public String getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(String addedDate) {
		this.addedDate = addedDate;
	}
	
	public StatusType getContactEmailStatus() {
		return contactEmailStatus;
	}

	public void setContactEmailStatus(StatusType contactEmailStatus) {
		this.contactEmailStatus = contactEmailStatus;
	}

}
