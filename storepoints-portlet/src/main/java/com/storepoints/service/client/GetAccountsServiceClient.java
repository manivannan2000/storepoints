package com.storepoints.service.client;

import java.util.List;

import javax.xml.bind.JAXBElement;


import com.storepoints.service.Account;
import com.storepoints.service.GetAccounts;
import com.storepoints.service.GetAccountsResponse;
import com.storepoints.service.ObjectFactory;

public class GetAccountsServiceClient  extends AbstractSPServiceClient{
	
	
	private List<Account> accounts;
	private String storeType;
	
	public GetAccountsServiceClient(String storeType){
		this.storeType=storeType;
	}
	
	public String getStoreType(){
		return storeType;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	protected  void inflateResponse( Object responseObj){
		
		JAXBElement<GetAccountsResponse> responseObjJAXB = (JAXBElement<GetAccountsResponse>)responseObj;
		
		GetAccountsResponse getAccountsResponse =responseObjJAXB.getValue();
		
		setAccounts(getAccountsResponse.getReturn());
	}
	
	protected  Object getSPServiceRequest(){
		
		ObjectFactory objectFactory = new ObjectFactory();
		
		GetAccounts getAccounts =objectFactory.createGetAccounts();
		
		getAccounts.setArg0(getStoreType());
		
		return objectFactory.createGetAccounts(getAccounts);
	}
}
