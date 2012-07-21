package com.storepoints.json.test;

import com.storepoints.couchdb.rs.client.GetUserRESTServiceClient;
import com.storepoints.dto.ContactEmailList;
import com.storepoints.dto.User;

public class GetUserRESTServiceClientTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		GetUserRESTServiceClient getUserRESTServiceClient = new GetUserRESTServiceClient("5107701784");
		
		getUserRESTServiceClient.makeGetServiceCall();
		
		User user = getUserRESTServiceClient.getUser();
		
		ContactEmailList contactEmailList= user.getContactEmailList();
		
		if(contactEmailList!=null)
			System.out.println("Contact emailList is not null");
		else
			System.out.println("Contact emailList is null");
			
		

	}

}
