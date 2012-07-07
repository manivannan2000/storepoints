package com.storepoints.memcached.data;

import java.util.ArrayList;
import java.util.List;

import com.storepoints.dto.ContactPhone;
import com.storepoints.dto.ContactPhoneList;
import com.storepoints.dto.StatusType;
import com.storepoints.dto.User;

public class StorePointsUsersTable {
	
	private static List<User> users = new ArrayList<User>();
	
	
	static{
		
		User user1 = new User();
		user1.setUserId("UUID1");
		user1.setFirstName("UUID1_FirstName");
		user1.setLastName("UUID1_LastName");
		
		ContactPhone contactPhone1User1 = new ContactPhone();
		
		contactPhone1User1.setContactPhoneID("UUID1_PHONE1");
		
		contactPhone1User1.setContactPhoneNumber("5107701784");
		
		contactPhone1User1.setContactPhoneStatus(StatusType.ACTIVE);
		
		contactPhone1User1.setAddedDate("06/23/2012");
		
		
		ContactPhoneList contactPhoneList = new ContactPhoneList();
		
	
		contactPhoneList.getContactPhoneList().add(contactPhone1User1);
		
		user1.setContactPhoneList(contactPhoneList);
		
		User user2 = new User();
		user2.setUserId("UUID2");
		user2.setFirstName("UUID2_FirstName");
		user2.setLastName("UUID2_LastName");
		
		ContactPhone contactPhone1User2 = new ContactPhone();
		
		contactPhone1User2.setContactPhoneID("UUID2_PHONE1");
		
		contactPhone1User2.setContactPhoneNumber("5102849640");
		
		contactPhone1User2.setContactPhoneStatus(StatusType.ACTIVE);
		
		contactPhone1User2.setAddedDate("06/23/2012");
		
		
		ContactPhoneList contactPhoneListUser2 = new ContactPhoneList();
		
	
		contactPhoneListUser2.getContactPhoneList().add(contactPhone1User2);
		
		user2.setContactPhoneList(contactPhoneListUser2);
		
		
		
		users.add(user1);
		users.add(user2);
		
	}

	public static List<User> getUsers() {
		return users;
	}
	
	

}
