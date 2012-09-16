package com.storepoints.json.test;

import com.storepoints.couchdb.rs.client.GetStorePointsRESTServiceClient;
import com.storepoints.dto.Account;

public class GetStorePointsRESTServiceClientTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GetStorePointsRESTServiceClient getStorePointsRESTServiceClient= new GetStorePointsRESTServiceClient("127.0.0.1","store1_tnr_chn_in","5107701784");
		
		getStorePointsRESTServiceClient.makeGetServiceCall();
		
		
		Account account = getStorePointsRESTServiceClient.getAccount();
		
		System.out.println("AccountID"+account.getAccountId());
		
		
		
	}

}
