package com.storepoints.service.client.test;

import java.util.List;

import com.storepoints.service.Store;
import com.storepoints.service.client.GetStoresServiceClient;

public class GetStoresServiceClientTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		GetStoresServiceClient getStoresServiceClient= new GetStoresServiceClient();

		try{
		getStoresServiceClient.makeServiceCall();
		
		List<Store> stores = getStoresServiceClient.getStores();
		
		System.out.println("Stores size:"+stores.size());
		
		for(Store store: stores){
			System.out.println("Store ID:"+store.getStoreId());
			System.out.println("Store Name:"+store.getStoreName());
			System.out.println("Store Type:"+store.getStoreType());
			
			
		}
		
		} catch(Exception excp){
			excp.printStackTrace();
		}

	}

}
