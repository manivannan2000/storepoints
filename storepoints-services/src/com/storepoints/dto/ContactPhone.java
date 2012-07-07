package com.storepoints.dto;

public class ContactPhone {
	
	private String contactPhoneID;
	
	private String contactPhoneNumber;

	private StatusType contactPhoneStatus;


	private String addedDate;
	
	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	public StatusType getContactPhoneStatus() {
		return contactPhoneStatus;
	}

	public void setContactPhoneStatus(StatusType contactPhoneStatus) {
		this.contactPhoneStatus = contactPhoneStatus;
	}

	public String getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(String addedDate) {
		this.addedDate = addedDate;
	}

	public String getContactPhoneID() {
		return contactPhoneID;
	}

	public void setContactPhoneID(String contactPhoneID) {
		this.contactPhoneID = contactPhoneID;
	}
	

}
