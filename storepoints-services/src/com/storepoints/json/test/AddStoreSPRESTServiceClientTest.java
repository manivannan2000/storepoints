package com.storepoints.json.test;

import com.storepoints.couchdb.rs.client.AddStoreSPRESTServiceClient;
import com.storepoints.dto.Store;
import com.storepoints.dto.StoreType;

public class AddStoreSPRESTServiceClientTest {
	
	public static void main(String arg[]){
		
		
		Store store = new Store();
		
		store.setStoreId("0004");
		store.setStoreName("New Store 1.4");
		store.setStoreType(StoreType.FURNITURES);
		
		AddStoreSPRESTServiceClient addStoreSPRESTServiceClient= new AddStoreSPRESTServiceClient(store);
		
		addStoreSPRESTServiceClient.makePutServiceCall();
		
		System.out.println("Status of adding the store:"+addStoreSPRESTServiceClient.getStoredStatus());
		
		
	}

}
