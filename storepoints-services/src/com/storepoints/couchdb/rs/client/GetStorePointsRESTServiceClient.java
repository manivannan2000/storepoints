package com.storepoints.couchdb.rs.client;

import java.util.Iterator;
import java.util.List;

import com.storepoints.dto.Account;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetStorePointsRESTServiceClient extends AbstractRESTServiceClient {
	
	private Account account;
	
	private String storeDBHost;
	
	private String storeDBName;
	
	private String primaryContactId;
	
	public GetStorePointsRESTServiceClient(String storeDBHost, String storeDBName,String primaryContactId){
		this.storeDBHost = storeDBHost;
		this.storeDBName = storeDBName;
		this.primaryContactId = primaryContactId;
	}

	public Account getAccount() {
		return account;
	}
	
	public String getStoreDBHost() {
		return storeDBHost;
	}

	public String getStoreDBName() {
		return storeDBName;
	}

	@Override
	protected String getRESTUrl(){
		return	"http://"+getStoreDBHost()+":5984/"+getStoreDBName();
	}
	
	
	@Override
	protected String getSPRESTPostData(){
		//As this service is primarily to get data.
		return null;
	}

	@Override
	protected String getSPRESTServiceRequest() {
		return "_design/storeaccounts/_view/by_accountprimarycontactid_get_storeaccount?key=%22"+getPrimaryContactId()+"%22";
	}
	
	public String getPrimaryContactId() {
		return primaryContactId;
	}


	@Override
	protected void inflateResponse(Object responseObj) {

		JSONObject jsonObject = JSONObject.fromObject((String)responseObj);
		
		JSONArray storeJSONArray = (JSONArray)jsonObject.get("rows");
		
		Iterator iteratorStore = storeJSONArray.iterator();
		
		while(iteratorStore.hasNext()) {
			
			JSONObject storeRowJSONObject =(JSONObject)iteratorStore.next();
				
			JSONObject storeJSONObject = (JSONObject)storeRowJSONObject.get("value");
			
			account = new Account();
			
			account.setAccountId((String)storeJSONObject.get("storeAccountId"));
			
			account.setStorePoint(storeJSONObject.getInt("storePoints"));
			
		}

	}

}
