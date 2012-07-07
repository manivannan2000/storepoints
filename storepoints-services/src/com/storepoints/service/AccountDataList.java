package com.storepoints.service;

import java.util.ArrayList;
import java.util.List;

public class AccountDataList {
	
	
	private List<AccountData> accountData;

	public List<AccountData> getAccountData() {
		
		if(accountData==null){
			accountData = new ArrayList<AccountData>();
		}
		return accountData;
	}
	

}
