package com.storepoints.service.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;

import com.storepoints.cms.service.StorePointsCMSService;



public class StorePointsCMSClient {

	
	private static final QName SERVICE_NAME = new QName("http://service.cms.storepoints.com/",
			"StorePointsCMSService");
	private static final QName PORT_NAME = new QName("http://service.cms.storepoints.com/",
			"StorePointsCMSServiceImplPort");
	
	private static final String WSDL_LOCATION = "http://localhost:8080/storepoints-cms-services/StorePointsService?wsdl";


 public static void main(String[] args) throws Exception{
	 

		URL wsdlURL = new URL(WSDL_LOCATION);
		Service service = Service.create(wsdlURL, SERVICE_NAME);
		StorePointsCMSService port = service.getPort(PORT_NAME, StorePointsCMSService.class);
		
		
		 Client client = (Client) ClientProxy.getClient(port);
		 client.getInInterceptors().add(new LoggingInInterceptor());
	     client.getOutInterceptors().add(new LoggingOutInterceptor()); 

	     System.out.println("Service name:"+port.getStorePointsCMSServiceName());
		
 }

}
