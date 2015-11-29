package com.storepoints.memcached.data;

import java.util.ArrayList;
import java.util.List;

import com.storepoints.couchdb.rs.client.GetStoreRESTServiceClient;
import com.storepoints.couchdb.rs.client.GetStoresRESTServiceClient;
import com.storepoints.dto.Store;
import com.storepoints.dto.StoreType;

public class StorePointsStoresDAO {

	private static List<Store> stores = new ArrayList<Store>();
	
	private static String _rev="";
	
	
	public StorePointsStoresDAO(){
		
	}

	static {
		
		GetStoresRESTServiceClient getStoresSPRESTServiceClient= new GetStoresRESTServiceClient(stores, true);
		getStoresSPRESTServiceClient.makeGetServiceCall();
		_rev=getStoresSPRESTServiceClient.getRevision();
		
		getStoresSPRESTServiceClient= new GetStoresRESTServiceClient(stores, false);
		getStoresSPRESTServiceClient.makeGetServiceCall();
		
	}
	
	public List<Store> getStores() {
		
		try{

		List<Store> storesLatest = new ArrayList<Store>();
		GetStoresRESTServiceClient getStoresSPRESTServiceClient= new GetStoresRESTServiceClient(storesLatest, true);
		getStoresSPRESTServiceClient.makeGetServiceCall();
		String _revLatest=getStoresSPRESTServiceClient.getRevision();
		
		if(!_rev.equals(_revLatest)){
			
			getStoresSPRESTServiceClient= new GetStoresRESTServiceClient(storesLatest, false);
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
	
	
	public Store getStore(String storeId){
		
		GetStoreRESTServiceClient getStoreSPRESTServiceClient= new GetStoreRESTServiceClient(storeId);
		getStoreSPRESTServiceClient.makeGetServiceCall();
		
		return getStoreSPRESTServiceClient.getStore();

		
	}

	
	
}
