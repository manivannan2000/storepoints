package com.storepoints.couchdb.rs.client;

import java.util.Iterator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetStoreTypeSPRESTServiceClient extends AbstractSPRESTServiceClient {

	@Override
	protected String getSPRESTServiceRequest() {
		return "storeType";
	}
	
	@Override
	protected String getSPRESTPostData(){
		//As the service is primarily to get data.
		return null;
	}
	

	@Override
	protected void inflateResponse(Object responseObj) {
		JSONObject jsonObject = JSONObject.fromObject((String)responseObj);
		
		
		JSONArray storeJSONArray = (JSONArray)jsonObject.get(getSPRESTServiceRequest()+"List");
		
		Iterator iteratorStore= storeJSONArray.iterator();
		
		while(iteratorStore.hasNext()){
			
			JSONObject storeJSONObject =(JSONObject)iteratorStore.next();

//			Store store =(Store)JSONSerializer.toJava((JSONObject)iteratorStore.next());
			
			System.out.println("StoreType name from couchDB:"+storeJSONObject.get(getSPRESTServiceRequest()+"Name"));
			
			
//			if(store!=null){
//				System.out.println("Store name from couchDB:"+store.getStoreName());
//			}
		}

	}

}
