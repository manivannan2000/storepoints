package com.storepoints.service.client;

import java.util.List;

import javax.xml.bind.JAXBElement;


import com.storepoints.service.AccountData;
import com.storepoints.service.GetAccounts;
import com.storepoints.service.GetAccountsResponse;
import com.storepoints.service.ObjectFactory;

public class GetAccountsServiceClient  extends AbstractSPServiceClient{
	
	
	private List<AccountData> accountsData;

	private String storeType;
	private String contactName;
	
	public GetAccountsServiceClient(String contactName,String storeType){
		this.storeType=storeType;
		this.contactName=contactName;
	}
	
	public String getStoreType(){
		return storeType;
	}
	
	public List<AccountData> getAccountsData() {
		return accountsData;
	}

	public void setAccountsData(List<AccountData> accountsData) {
		this.accountsData = accountsData;
	}

	public String getContactName() {
		return contactName;
	}

	protected  void inflateResponse( Object responseObj) {
		
		JAXBElement<GetAccountsResponse> responseObjJAXB = (JAXBElement<GetAccountsResponse>)responseObj;
		
		GetAccountsResponse getAccountsResponse =responseObjJAXB.getValue();
		
		setAccountsData(getAccountsResponse.getReturn());
	}
	
	protected  Object getSPServiceRequest() {
		
		ObjectFactory objectFactory = new ObjectFactory();
		
		GetAccounts getAccounts =objectFactory.createGetAccounts();
		
		getAccounts.setArg0(getContactName());
		
		getAccounts.setArg1(getStoreType());
		
		return objectFactory.createGetAccounts(getAccounts);
	}
}
