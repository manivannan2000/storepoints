package com.storepoints.memcached.data;

import java.util.ArrayList;
import java.util.List;

import com.storepoints.dto.Account;

public class StorePointsAccountsTable {
	
	private static List<Account> accounts = new ArrayList<Account>();
	

	static{
		
		Account acct0= new Account();
		acct0.setAccountid("A5107701784");
		acct0.setStoreid("df649394-d416-4ca7-998b-7f079469cfeb");
		acct0.setStorePoint(1000);

		
		Account acct1 = new Account();
		acct1.setAccountid("A5107701784");
		acct1.setStoreid("7241a2b0-68ba-4476-ac3f-0ad8ee2f7feb");
		acct1.setStorePoint(1000);


		Account acct2 = new Account();
		acct2.setAccountid("A5107701784");
		acct2.setStoreid("d8afc4bd-07fd-47c3-a5a6-c63de417401b");
		acct2.setStorePoint(1000);


		Account acct3 = new Account();
		acct3.setAccountid("A5102849640");
		acct3.setStoreid("df649394-d416-4ca7-998b-7f079469cfeb");
		acct3.setStorePoint(500);

		
		Account acct4 = new Account();
		acct4.setAccountid("A5102849640");
		acct4.setStoreid("7241a2b0-68ba-4476-ac3f-0ad8ee2f7feb");
		acct4.setStorePoint(500);


		Account acct5 = new Account();
		acct5.setAccountid("A5102849640");
		acct5.setStoreid("d8afc4bd-07fd-47c3-a5a6-c63de417401b");
		acct5.setStorePoint(500);
		

		accounts.add(acct0);
		accounts.add(acct1);
		accounts.add(acct2);
		accounts.add(acct3);
		accounts.add(acct4);
		accounts.add(acct5);
	}
	
	public static List<Account> getAccounts() {
		return accounts;
	}



}
