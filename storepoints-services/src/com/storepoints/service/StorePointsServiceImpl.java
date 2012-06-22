package com.storepoints.service;



import java.util.ArrayList;
import java.util.List;

import com.storepoints.dto.Account;
import com.storepoints.dto.StoreType;

@javax.jws.WebService(portName = "StorePointsServiceImplPort", serviceName = "StorePointsService")
public class StorePointsServiceImpl implements StorePointsService {
	
	private static List<Account> accounts = new ArrayList<Account>();
	
	static{
		Account acct1 = new Account();
		acct1.setAccountid("1234");
		acct1.setAccountName("Saravana Stores");
		acct1.setStorePoint(1000);
		acct1.setStoreType(StoreType.TEXT);
		
		Account acct2 = new Account();
		acct2.setAccountid("5678");
		acct2.setAccountName("Pothys Stores");
		acct2.setStorePoint(500);
		acct2.setStoreType(StoreType.TEXT);

		
		Account acct3 = new Account();
		acct3.setAccountid("5678");
		acct3.setAccountName("Saravana Bavan");
		acct3.setStorePoint(100);
		acct3.setStoreType(StoreType.REST);
		
		accounts.add(acct1);
		accounts.add(acct2);
		accounts.add(acct3);

	}
	

	@Override
	public List<Account> getAccounts(String storeType){
	
		List<Account> accountsSType = new ArrayList<Account>();
		
		System.out.println("Service providing the list of accounts");
		
		for(Account account: accounts){
			if(account.getStoreType().toString().equals(storeType)){
				accountsSType.add(account);
			}
		}

		
		return accountsSType;
		
	}
	
}
