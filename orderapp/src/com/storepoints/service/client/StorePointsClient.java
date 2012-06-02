package com.storepoints.service.client;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.storepoints.dto.Account;
import com.storepoints.service.StorePointsService;


public class StorePointsClient {
	
 public static void main(String[] args){
	 
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "com/storepoints/service/client/storepoints-client-beans.xml" });
		StorePointsService storePointsClient = (StorePointsService) context.getBean("storePointsClient");

		List<Account> accounts = storePointsClient.getAccounts();
		
		
		System.out.println("Printing accounts for storepoints...");
		
		for(Account account: accounts){

			System.out.println("Accounts: getId:"+account.getAccountid());
			System.out.println("Accounts: getName:"+account.getAccountName());
			System.out.println("Accounts: storePoints:"+account.getStorePoint());
		}
		
 }

}
