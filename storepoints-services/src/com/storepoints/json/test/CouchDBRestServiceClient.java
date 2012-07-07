package com.storepoints.json.test;

import java.util.List;

import org.apache.cxf.jaxrs.client.Client;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;

import com.storepoints.dto.Store;
import com.storepoints.dto.Stores;

public class CouchDBRestServiceClient {
	
	public static void main(String arg[]){
		
//		WebClient client = WebClient.create("http://localhost:5984/");
//		
//		Stores stores = (Stores) client.path("storepoints_dev/stores").accept("application/json").get(Stores.class);
		

		Stores storesProxy = JAXRSClientFactory.create("http://localhost:5984/storepoints_dev/stores", Stores.class);

		Client client = WebClient.client(storesProxy).accept("application/json");
		
		
		WebClient httpClient = WebClient.fromClient(client);
		
		for(Store store: storesProxy.getStoreList()){
			
			System.out.println("StoreName:"+store.getStoreName());
		}
		
	}

}
