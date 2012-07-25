package com.storepoints.json.test;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JsonConfig;
import net.sf.json.JSONSerializer;

import com.storepoints.dto.Stores;
import com.storepoints.memcached.data.StorePointsStoresDAO;

public class JavaToJSONTest {
	
	
	public static void main(String arg[]){
		
		Stores stores= new Stores();
		
		stores.set_rev("4-de00256ef78e2cd04945eabf58d3a293");
		
		stores.setTitle("stores");
		
		stores.setStoreList((new StorePointsStoresDAO()).getStores());

		String storesJSON = JSONSerializer.toJSON(stores).toString();
		
		
		System.out.println("JSON value for stores:"+storesJSON);
		
		
		
	}
	

}
