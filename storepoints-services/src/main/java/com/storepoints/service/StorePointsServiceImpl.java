package com.storepoints.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.storepoints.couchdb.rs.client.AddStoreRESTServiceClient;
import com.storepoints.couchdb.rs.client.GetStorePointsRESTServiceClient;
import com.storepoints.dto.Account;
import com.storepoints.dto.ContactEmail;
import com.storepoints.dto.ContactEmailList;
import com.storepoints.dto.ContactPhone;
import com.storepoints.dto.ContactPhoneList;
import com.storepoints.dto.Store;
import com.storepoints.dto.StoreType;
import com.storepoints.dto.User;
import com.storepoints.memcached.data.SPUsersAccountsMapperTable;
import com.storepoints.memcached.data.StorePointsAccountDAO;
import com.storepoints.memcached.data.StorePointsStoresDAO;
import com.storepoints.memcached.data.StorePointsUsersDAO;

@javax.jws.WebService(portName = "StorePointsServiceImplPort", serviceName = "StorePointsService")
public class StorePointsServiceImpl implements StorePointsService {
	
	@Override
	public List<AccountData> getAccounts(String userContactId, String storeType) {
		
		List<AccountData> accountDataList = new ArrayList<AccountData>();

//		List<User> users =StorePointsUsersDAO.getUser(userContactId);
		User user = (new StorePointsUsersDAO()).getUser(userContactId);
		
		if(user==null){
			
			System.out.println("You do not have any points from the participating stores near you. Please visit the list of participating stores.");
			
		}else{
		
		for(String storeId: user.getStoreList()) {
			
			
			StorePointsStoresDAO storePointsStoresDAO = new StorePointsStoresDAO();
			
			Store store =storePointsStoresDAO.getStore(storeId);
			
			ContactPhoneList contactPhoneList =user.getContactPhoneList();
			
			for( ContactPhone contactPhone: contactPhoneList.getContactPhoneList()){
				
				AccountData accountData = getAccountData(store,contactPhone.getContactPhoneNumber());
				
				if(accountData!=null)
					accountDataList.add(accountData);
			}
			
			
			ContactEmailList contactEmailList = user.getContactEmailList();
			
			for( ContactEmail contactEmail: contactEmailList.getContactEmailList()){
				AccountData accountData = getAccountData(store,contactEmail.getContactEmailAddress());

				if(accountData!=null)
					accountDataList.add(accountData);
			}

		
		
//		for(Account account: StorePointsAccountDAO.getAccounts()){
//
//			System.out.println("StorePointsAccountsTable size:"+StorePointsAccountDAO.getAccounts().size());
//			
//			if(account.getAccountid().equals(accountId)){
//				
//				List<Store> stores=StorePointsStoresDAO.getStores();
//				List<Store> storesCopy= new ArrayList<Store>(stores);
//				
//				for(Store store: storesCopy) {
//					System.out.println("StorePointsStoresTable size:"+storesCopy.size());
//				
//					if(store.getStoreId().equals(account.getStoreid()) && store.getStoreType().toString().equals(storeType)){
//						AccountData accountData = new AccountData();
//						accountData.setAccountid(account.getAccountid());
//						accountData.setStoreid(account.getStoreid());
//						accountData.setStorePoint(account.getStorePoint());
//						accountData.setStoreName(store.getStoreName());
////						accountDataList.getAccountData().add(accountData);
//						accountDataList.add(accountData);
////						System.out.println("AccountDataList size:"+accountDataList.getAccountData().size());
//					}
//				}
//			}
//		}
		
//		getAccountsRs.setAccountDataList(accountDataList);
//		System.out.println("AccountDataList size(After loop):"+accountDataList.getAccountData().size());
		System.out.println("AccountDataList size(After loop):"+accountDataList.size());		
		
		 }
		}
		
		return accountDataList;
		
	}

	@Override
	public Status addStore(Store store) {
		
		Status returnObj= new Status();
		
		AddStoreRESTServiceClient addStoreSPRESTServiceClient= new AddStoreRESTServiceClient(store);
		
		addStoreSPRESTServiceClient.makePutServiceCall();
		
		System.out.println("Status of adding the store:"+addStoreSPRESTServiceClient.getStoredStatus());
		
		returnObj.setStatus(addStoreSPRESTServiceClient.getStoredStatus());

		return returnObj;
		
	}

	@Override
	public List<User> getUserList(String storeId, String accessKey) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Store> getStores(){
		
		return (new StorePointsStoresDAO()).getStores();
	}
	
	
	private AccountData getAccountData(Store store,String primaryContactId){
		
		AccountData accountData =null;
		
		GetStorePointsRESTServiceClient getStorePointsRESTServiceClient = new GetStorePointsRESTServiceClient(store.getStoreDBHost(),store.getStoreDBName(),primaryContactId);
		
		getStorePointsRESTServiceClient.makeGetServiceCall();
		
		Account account= getStorePointsRESTServiceClient.getAccount();
		
		if(account!=null){
			accountData = new AccountData();
			accountData.setAccountId(account.getAccountId());
			accountData.setStoreId(store.getStoreId());
			accountData.setStoreName(store.getStoreName());
			accountData.setStoreLandMark(store.getStoreLandMark());
			accountData.setStorePoint(account.getStorePoint());
			
		}

		return accountData;
	}
	
}
