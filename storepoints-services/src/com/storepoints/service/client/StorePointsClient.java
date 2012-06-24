package com.storepoints.service.client;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.storepoints.dto.Account;
import com.storepoints.service.AccountData;
import com.storepoints.service.GetAccountsRs;
import com.storepoints.service.StorePointsService;


public class StorePointsClient {
	
 public static void main(String[] args){
	 
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "com/storepoints/service/client/storepoints-client-beans.xml" });
		StorePointsService storePointsClient = (StorePointsService) context.getBean("storePointsClient");
		
		String storeType ="RESTAURANTS";
		storeType="TEXTILES";
//		GetAccountsRs getAccountsRs = storePointsClient.getAccounts("5107701784",storeType);
		List<AccountData> accountDataList = storePointsClient.getAccounts("5107701784",storeType);
		
		
		System.out.println("Printing accounts for storepoints...");
		
//		for(AccountData accountData: getAccountsRs.getAccountDataList().getAccountData()){
		for(AccountData accountData: accountDataList){

			System.out.println("Accounts: getId:"+accountData.getAccountid());
			
			System.out.println("Accounts: storeName:"+accountData.getStoreName());
			
			System.out.println("Accounts: storePoints:"+accountData.getStorePoint());
		}
		
 }

}
