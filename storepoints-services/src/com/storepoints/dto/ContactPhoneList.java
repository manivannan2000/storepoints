package com.storepoints.dto;

import java.util.ArrayList;
import java.util.List;

public class ContactPhoneList {
	
	private List<ContactPhone> contactPhoneList;

	public List<ContactPhone> getContactPhoneList() {
		
		if(contactPhoneList==null){
			contactPhoneList = new ArrayList<ContactPhone>();
		}
		
		return contactPhoneList;
	}

}
