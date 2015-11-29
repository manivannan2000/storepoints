package com.storepoints.json.test;

import java.util.ArrayList;
import java.util.List;

import com.storepoints.couchdb.rs.client.GetStoresRESTServiceClient;
import com.storepoints.dto.Store;

public class GetStoresSPRESTServiceClientTest {
	
	public static void main(String arg[]){
		
		List<Store> stores = new ArrayList<Store>();
		GetStoresRESTServiceClient getStoresSPRESTServiceClient= new GetStoresRESTServiceClient(stores,true);
		getStoresSPRESTServiceClient.makeGetServiceCall();
		
		System.out.println("For revision only call:"+getStoresSPRESTServiceClient.getRevision());
		System.out.println("Stores size For revision only call:"+stores.size());
		
		getStoresSPRESTServiceClient= new GetStoresRESTServiceClient(stores,false);
		getStoresSPRESTServiceClient.makeGetServiceCall();
		
		System.out.println("For NO revision only call:"+getStoresSPRESTServiceClient.getRevision());
		System.out.println("Stores size For NO revision only call:"+stores.size());
		
	}

}
