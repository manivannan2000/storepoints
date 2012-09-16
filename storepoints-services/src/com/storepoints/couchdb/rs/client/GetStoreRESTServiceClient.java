package com.storepoints.couchdb.rs.client;

import java.util.Iterator;
import java.util.List;

import com.storepoints.dto.Store;
import com.storepoints.dto.StoreType;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetStoreRESTServiceClient extends AbstractRESTServiceClient {
	
	private Store store;
	
	private String storeId;

	public String getStoreId() {
		return storeId;
	}


	public Store getStore() {
		return store;
	}


	public GetStoreRESTServiceClient(String storeId){
		this.storeId= storeId;
	}
	
	@Override
	protected String getRESTUrl(){
		return	"http://localhost:5984/storepoints_dev";
	}
	
	
	@Override
	protected String getSPRESTPostData(){
		//As this service is primarily to get data.
		return null;
	}

	@Override
	protected String getSPRESTServiceRequest() {
		return "_design/stores/_view/by_storeid_get_store?key=%22"+getStoreId()+"%22";
	}

	@Override
	protected void inflateResponse(Object responseObj) {

		JSONObject jsonObject = JSONObject.fromObject((String)responseObj);
		
		JSONArray storeJSONArray = (JSONArray)jsonObject.get("rows");
		
		Iterator iteratorStore = storeJSONArray.iterator();
		
		while(iteratorStore.hasNext()) {
			
			JSONObject storeRowJSONObject =(JSONObject)iteratorStore.next();
			
			JSONObject storeJSONObject = (JSONObject)storeRowJSONObject.get("value");
			
			System.out.println("Store name from couchDB:"+storeJSONObject.get("storeName"));
			
			store = new Store();
			store.setStoreId((String)storeJSONObject.get("storeId"));
			
			store.setStoreName((String)storeJSONObject.get("storeName"));
			
			store.setStoreLandMark((String)storeJSONObject.get("storeLandMark"));
			
			store.setAddressLine1((String)storeJSONObject.get("addressLine1"));
			
			store.setAddressLine2((String)storeJSONObject.get("addressLine2"));

			store.setStorePostalCode((String)storeJSONObject.get("storePostalCode"));

			store.setStoreCityCode((String)storeJSONObject.get("storeCityCode"));

			store.setStoreCountryCode((String)storeJSONObject.get("storeCountryCode"));
			
			store.setStoreType(StoreType.valueOf((String)storeJSONObject.get("storeType")));
			
			store.setStoreDBName((String)storeJSONObject.get("storeDBName"));
			
			store.setStoreDBHost((String)storeJSONObject.get("storeDBHost"));
			
		}

	}

}
