package com.storepoints.service;

import java.util.List;

import javax.jws.WebService;
import javax.jws.WebMethod;

import com.storepoints.dto.Account;
import com.storepoints.dto.Store;
import com.storepoints.dto.User;


@WebService
public interface StorePointsService {

	@WebMethod
	public List<AccountData> getAccounts(String userContactId, String storeType);
	
	@WebMethod
	public Status addStore(Store store);
	
	@WebMethod
	public List<User>  getUserList(String storeId,String accessKey);

	@WebMethod
	public List<Store>  getStores();
	
}
