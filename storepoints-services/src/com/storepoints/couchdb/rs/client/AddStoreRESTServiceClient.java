package com.storepoints.couchdb.rs.client;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import com.storepoints.dto.Store;
import com.storepoints.dto.Stores;
import com.storepoints.memcached.data.StorePointsStoresTable;

public class AddStoreRESTServiceClient extends AbstractRESTServiceClient {

	private Store store;
	
	private Boolean storedStatus;
	

	public Boolean getStoredStatus() {
		return storedStatus;
	}

	public void setStoredStatus(Boolean storedStatus) {
		this.storedStatus = storedStatus;
	}

	public AddStoreRESTServiceClient(Store store) {
		this.store= store;
	}
	
	@Override
	protected String getSPRESTServiceRequest() {
		return "stores";
	}

	@Override
	protected String getSPRESTPostData() {
		
		Stores stores = new Stores();
		
		stores.setTitle("stores");
		List<Store> storesList = StorePointsStoresTable.getStores();
		
		GetStoresRESTServiceClient getStoresSPRESTServiceClient= new GetStoresRESTServiceClient(storesList, true);
		getStoresSPRESTServiceClient.makeGetServiceCall();
		String _rev=getStoresSPRESTServiceClient.getRevision();

		stores.set_rev(_rev);
		
		if(!storesList.contains(store))
			storesList.add(store);

		stores.setStoreList(storesList);
		
		
		return JSONSerializer.toJSON(stores).toString();
	}

	@Override
	protected void inflateResponse(Object responseObj) {
		
		JSONObject jsonObject = JSONObject.fromObject((String)responseObj);

		setStoredStatus( (Boolean)jsonObject.get("ok"));
		
	}

}
