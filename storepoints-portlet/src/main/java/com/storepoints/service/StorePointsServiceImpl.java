package com.storepoints.service;

import java.util.ArrayList;
import java.util.List;

import com.storepoints.dto.Account;

public class StorePointsServiceImpl implements StorePointsService {

	@Override
	public List<Account> getAccounts(){
		List<Account> accounts = new ArrayList<Account>();
		
		Account acct1 = new Account();
		acct1.setAccountid("1234");
		acct1.setAccountName("Saravana Stores");
		acct1.setStorePoint(1000);
		
		Account acct2 = new Account();
		acct2.setAccountid("5678");
		acct2.setAccountName("Pothys Stores");
		acct2.setStorePoint(500);
		
		Account acct3 = new Account();
		acct3.setAccountid("5678");
		acct3.setAccountName("Saravana Bavan");
		acct3.setStorePoint(100);
		
		System.out.println("Service providing the list of accounts");

		accounts.add(acct1);
		accounts.add(acct2);
		accounts.add(acct3);
		
		return accounts;
		
	}
	
}
