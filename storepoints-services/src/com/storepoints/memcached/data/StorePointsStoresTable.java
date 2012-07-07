package com.storepoints.memcached.data;

import java.util.ArrayList;
import java.util.List;

import com.storepoints.couchdb.rs.client.GetStoresSPRESTServiceClient;
import com.storepoints.dto.Store;
import com.storepoints.dto.StoreType;

public class StorePointsStoresTable {

	private static List<Store> stores = new ArrayList<Store>();
	
	private static String _rev="";

	static {
		
		GetStoresSPRESTServiceClient getStoresSPRESTServiceClient= new GetStoresSPRESTServiceClient(stores, true);
		getStoresSPRESTServiceClient.makeGetServiceCall();
		_rev=getStoresSPRESTServiceClient.getRevision();
		
		getStoresSPRESTServiceClient= new GetStoresSPRESTServiceClient(stores, false);
		getStoresSPRESTServiceClient.makeGetServiceCall();
		
	}
	
	public static List<Store> getStores() {
		
		try{

		List<Store> storesLatest = new ArrayList<Store>();
		GetStoresSPRESTServiceClient getStoresSPRESTServiceClient= new GetStoresSPRESTServiceClient(storesLatest, true);
		getStoresSPRESTServiceClient.makeGetServiceCall();
		String _revLatest=getStoresSPRESTServiceClient.getRevision();
		
		if(!_rev.equals(_revLatest)){
			
			getStoresSPRESTServiceClient= new GetStoresSPRESTServiceClient(storesLatest, false);
			getStoresSPRESTServiceClient.makeGetServiceCall();
			
			for(Store store:storesLatest){
				if(!stores.contains(store))
					stores.add(store);
			}
			
		}

		}catch(Throwable excp){
			excp.printStackTrace();
		}
		
		return stores;
	}

	
	
}
