package com.storepoints.couchdb.rs.client;

import java.util.Iterator;
import java.util.List;

import com.storepoints.dto.Store;
import com.storepoints.dto.StoreType;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetStoresRESTServiceClient extends AbstractRESTServiceClient {
	
	private List<Store> stores;
	
	private String revision;
	
	boolean revisionOnly;
	
	@Override
	protected String getRESTUrl(){
		return	"http://localhost:5984/storepoints_dev";
	}

	public List<Store> getStores() {
		return stores;
	}


	public GetStoresRESTServiceClient(List<Store> stores, boolean revisionOnly){
		this.stores= stores;
		this.revisionOnly=revisionOnly;
	}
	
	
	@Override
	protected String getSPRESTPostData(){
		//As this service is primarily to get data.
		return null;
	}

	@Override
	protected String getSPRESTServiceRequest() {
		return "stores";
	}

	@Override
	protected void inflateResponse(Object responseObj) {
		JSONObject jsonObject = JSONObject.fromObject((String)responseObj);
		
		
		JSONArray storeJSONArray = (JSONArray)jsonObject.get("storeList");
		
		if(revisionOnly){
			setRevision((String)jsonObject.get("_rev"));
			return;
		}
		
		Iterator iteratorStore= storeJSONArray.iterator();
		
		while(iteratorStore.hasNext()){
			
			JSONObject storeJSONObject =(JSONObject)iteratorStore.next();

//			Store store =(Store)JSONSerializer.toJava((JSONObject)iteratorStore.next());
			
			System.out.println("Store name from couchDB:"+storeJSONObject.get("storeName"));
			
			Store store = new Store();
			store.setStoreId((String)storeJSONObject.get("storeId"));
			store.setStoreName((String)storeJSONObject.get("storeName"));
			store.setStoreType(StoreType.valueOf((String)storeJSONObject.get("storeType")));
			
			stores.add(store);
			
			
//			if(store!=null){
//				System.out.println("Store name from couchDB:"+store.getStoreName());
//			}
		}

	}
	
	public String getRevision() {
		return revision;
	}


	public void setRevision(String revision) {
		this.revision = revision;
	}


}
