package com.storepoints.service;

import java.util.ArrayList;
import java.util.List;

import com.storepoints.dto.Account;
import com.storepoints.dto.ContactPhone;
import com.storepoints.dto.ContactPhoneList;
import com.storepoints.dto.Store;
import com.storepoints.dto.StoreType;
import com.storepoints.dto.User;
import com.storepoints.memcached.data.SPUsersAccountsMapperTable;
import com.storepoints.memcached.data.StorePointsAccountsTable;
import com.storepoints.memcached.data.StorePointsStoresTable;
import com.storepoints.memcached.data.StorePointsUsersTable;

@javax.jws.WebService(portName = "StorePointsServiceImplPort", serviceName = "StorePointsService")
public class StorePointsServiceImpl implements StorePointsService {
	
	@Override
	public List<AccountData> getAccounts(String userContactId, String storeType) {
		
		
		String accountId = null;
		
		List<User> users =StorePointsUsersTable.getUsers();
		
		for(User user: users){
			ContactPhoneList contactPhoneList =user.getContactPhoneList();
			
			for( ContactPhone contactPhone: contactPhoneList.getContactPhoneList()){
				if(contactPhone.getContactPhoneNumber().equals(userContactId)){
					accountId =SPUsersAccountsMapperTable.getUsersAccountsMap().get(user.getUserId());
					break;
				}
			}
		}
		
		
		if(accountId==null){
			return null;
		}
		
//		GetAccountsRs getAccountsRs = new GetAccountsRs();
	
//		AccountDataList accountDataList = new AccountDataList();
		
//		getAccountsRs.setAccountDataList(accountDataList);
//		System.out.println("AccountDataList size(Before loop):"+accountDataList.getAccountData().size());
		
		List<AccountData> accountDataList = new ArrayList<AccountData>();
		
		System.out.println("Service providing the list of accounts for accountId:"+accountId);
		
		for(Account account: StorePointsAccountsTable.getAccounts()){

			System.out.println("StorePointsAccountsTable size:"+StorePointsAccountsTable.getAccounts().size());
			
			
			
			if(account.getAccountid().equals(accountId)){
				for(Store store: StorePointsStoresTable.getStores()) {
					System.out.println("StorePointsStoresTable size:"+StorePointsStoresTable.getStores().size());
				
					if(store.getStoreid().equals(account.getStoreid()) && store.getStoreType().toString().equals(storeType)){
						AccountData accountData = new AccountData();
						accountData.setAccountid(account.getAccountid());
						accountData.setStoreid(account.getStoreid());
						accountData.setStorePoint(account.getStorePoint());
						accountData.setStoreName(store.getStoreName());
//						accountDataList.getAccountData().add(accountData);
						accountDataList.add(accountData);
//						System.out.println("AccountDataList size:"+accountDataList.getAccountData().size());
					}
				}
			}
		}
		
//		getAccountsRs.setAccountDataList(accountDataList);
//		System.out.println("AccountDataList size(After loop):"+accountDataList.getAccountData().size());
		System.out.println("AccountDataList size(After loop):"+accountDataList.size());		
		
		return accountDataList;
		
	}

	@Override
	public void addStore(Store store) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getUserList(String storeId, String accessKey) {
		// TODO Auto-generated method stub
		return null;
	}
	
}