package com.storepoints.dto;

import java.util.ArrayList;
import java.util.List;

public class ContactEmailList {
	
	private List<ContactEmail> contactEmailList;

	public List<ContactEmail> getContactEmailList() {
		if(contactEmailList==null){
			contactEmailList = new ArrayList<ContactEmail>();
		}
		
		return contactEmailList;
	}

}
