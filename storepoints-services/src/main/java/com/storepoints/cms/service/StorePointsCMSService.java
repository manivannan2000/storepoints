package com.storepoints.cms.service;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public interface StorePointsCMSService {
	
	@WebMethod
	String getStorePointsCMSServiceName();

}
