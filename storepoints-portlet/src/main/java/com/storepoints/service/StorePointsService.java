package com.storepoints.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.0
 * 2012-07-25T21:25:47.422-07:00
 * Generated source version: 2.6.0
 * 
 */
@WebService(targetNamespace = "http://service.storepoints.com/", name = "StorePointsService")
@XmlSeeAlso({ObjectFactory.class})
public interface StorePointsService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getUserList", targetNamespace = "http://service.storepoints.com/", className = "com.storepoints.service.GetUserList")
    @WebMethod
    @ResponseWrapper(localName = "getUserListResponse", targetNamespace = "http://service.storepoints.com/", className = "com.storepoints.service.GetUserListResponse")
    public java.util.List<com.storepoints.service.User> getUserList(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getAccounts", targetNamespace = "http://service.storepoints.com/", className = "com.storepoints.service.GetAccounts")
    @WebMethod
    @ResponseWrapper(localName = "getAccountsResponse", targetNamespace = "http://service.storepoints.com/", className = "com.storepoints.service.GetAccountsResponse")
    public java.util.List<com.storepoints.service.AccountData> getAccounts(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "addStore", targetNamespace = "http://service.storepoints.com/", className = "com.storepoints.service.AddStore")
    @WebMethod
    @ResponseWrapper(localName = "addStoreResponse", targetNamespace = "http://service.storepoints.com/", className = "com.storepoints.service.AddStoreResponse")
    public com.storepoints.service.Status addStore(
        @WebParam(name = "arg0", targetNamespace = "")
        com.storepoints.service.Store arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getStores", targetNamespace = "http://service.storepoints.com/", className = "com.storepoints.service.GetStores")
    @WebMethod
    @ResponseWrapper(localName = "getStoresResponse", targetNamespace = "http://service.storepoints.com/", className = "com.storepoints.service.GetStoresResponse")
    public java.util.List<com.storepoints.service.Store> getStores();
}
