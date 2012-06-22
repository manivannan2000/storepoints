package com.storepoints.service;

import java.util.List;

import javax.jws.WebService;
import javax.jws.WebMethod;

import com.storepoints.dto.Account;


@WebService
public interface StorePointsService {

	@WebMethod
	public List<Account> getAccounts(String storeType);
	
}
