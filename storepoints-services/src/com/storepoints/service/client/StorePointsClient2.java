package com.storepoints.service.client;

import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.storepoints.dto.Account;
import com.storepoints.service.StorePointsService;



public class StorePointsClient2 {

	
	private static final QName SERVICE_NAME = new QName("http://service.storepoints.com/",
			"StorePointsService");
	private static final QName PORT_NAME = new QName("http://service.storepoints.com/",
			"StorePointsServiceImplPort");
	
	private static final String WSDL_LOCATION = "http://localhost:8080/orderapp/StorePointsService?wsdl";


 public static void main(String[] args) throws Exception{
	 

		URL wsdlURL = new URL(WSDL_LOCATION);
		Service service = Service.create(wsdlURL, SERVICE_NAME);
		StorePointsService port = service.getPort(PORT_NAME, StorePointsService.class);
		
		
		 Client client = (Client) ClientProxy.getClient(port);
		 client.getInInterceptors().add(new LoggingInInterceptor());
	     client.getOutInterceptors().add(new LoggingOutInterceptor()); 

	 
	 
	 
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//				new String[] { "com/storepoints/service/client/storepoints-client-beans.xml" });
//		StorePointsService storePointsClient = (StorePointsService) context.getBean("storePointsClient");
		
		String storeType ="REST";
		storeType="TEXT";
		List<Account> accounts = port.getAccounts(storeType);
		
		
		System.out.println("Printing accounts for storepoints...");
		
		for(Account account: accounts){

			System.out.println("Accounts: getId:"+account.getAccountid());
			System.out.println("Accounts: getName:"+account.getAccountName());
			System.out.println("Accounts: storePoints:"+account.getStorePoint());
		}
		
 }

}
