package com.storepoints.service.client.test;

import java.util.List;
import com.storepoints.service.Account;
import com.storepoints.service.client.GetAccountsServiceClient;

public class GetAccountsServiceClientTest {
	
	public static void main(String arg[]){

		GetAccountsServiceClient getAccountsServiceClient = new GetAccountsServiceClient("REST");
		getAccountsServiceClient.makeServiceCall();
		
		
		List<Account> accounts =getAccountsServiceClient.getAccounts();
		
		
		for(Account account: accounts){

			System.out.println("Accounts: getId:"+account.getAccountid());
			System.out.println("Accounts: getName:"+account.getAccountName());
			System.out.println("Accounts: storePoints:"+account.getStorePoint());
		}

		
		
		
	}
}
