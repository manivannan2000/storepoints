package com.storepoints.service.client.test;

import java.util.List;
import com.storepoints.service.AccountData;
import com.storepoints.service.client.GetAccountsServiceClient;

public class GetAccountsServiceClientTest {
	
	public static void main(String arg[]){

//		GetAccountsServiceClient getAccountsServiceClient = new GetAccountsServiceClient("5107701784","RESTAURANTS");
		GetAccountsServiceClient getAccountsServiceClient = new GetAccountsServiceClient("5107701784","TEXTILES");
		
		getAccountsServiceClient.makeServiceCall();
		
		
		List<AccountData> accounts =getAccountsServiceClient.getAccountsData();
		
		
		for(AccountData account: accounts){

			System.out.println("Accounts: getId:"+account.getAccountId());
			System.out.println("Accounts: getStoreName:"+account.getStoreName());
			System.out.println("Accounts: storePoints:"+account.getStorePoint());
		}

		
		
		
	}
}
