
package com.storepoints.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.storepoints.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddStore_QNAME = new QName("http://service.storepoints.com/", "addStore");
    private final static QName _GetAccounts_QNAME = new QName("http://service.storepoints.com/", "getAccounts");
    private final static QName _GetStores_QNAME = new QName("http://service.storepoints.com/", "getStores");
    private final static QName _GetUserListResponse_QNAME = new QName("http://service.storepoints.com/", "getUserListResponse");
    private final static QName _GetStoresResponse_QNAME = new QName("http://service.storepoints.com/", "getStoresResponse");
    private final static QName _GetAccountsResponse_QNAME = new QName("http://service.storepoints.com/", "getAccountsResponse");
    private final static QName _GetUserList_QNAME = new QName("http://service.storepoints.com/", "getUserList");
    private final static QName _AddStoreResponse_QNAME = new QName("http://service.storepoints.com/", "addStoreResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.storepoints.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddStore }
     * 
     */
    public AddStore createAddStore() {
        return new AddStore();
    }

    /**
     * Create an instance of {@link GetUserListResponse }
     * 
     */
    public GetUserListResponse createGetUserListResponse() {
        return new GetUserListResponse();
    }

    /**
     * Create an instance of {@link GetStores }
     * 
     */
    public GetStores createGetStores() {
        return new GetStores();
    }

    /**
     * Create an instance of {@link GetAccounts }
     * 
     */
    public GetAccounts createGetAccounts() {
        return new GetAccounts();
    }

    /**
     * Create an instance of {@link GetStoresResponse }
     * 
     */
    public GetStoresResponse createGetStoresResponse() {
        return new GetStoresResponse();
    }

    /**
     * Create an instance of {@link GetUserList }
     * 
     */
    public GetUserList createGetUserList() {
        return new GetUserList();
    }

    /**
     * Create an instance of {@link GetAccountsResponse }
     * 
     */
    public GetAccountsResponse createGetAccountsResponse() {
        return new GetAccountsResponse();
    }

    /**
     * Create an instance of {@link AddStoreResponse }
     * 
     */
    public AddStoreResponse createAddStoreResponse() {
        return new AddStoreResponse();
    }

    /**
     * Create an instance of {@link ContactPhoneList }
     * 
     */
    public ContactPhoneList createContactPhoneList() {
        return new ContactPhoneList();
    }

    /**
     * Create an instance of {@link Store }
     * 
     */
    public Store createStore() {
        return new Store();
    }

    /**
     * Create an instance of {@link Status }
     * 
     */
    public Status createStatus() {
        return new Status();
    }

    /**
     * Create an instance of {@link AccountData }
     * 
     */
    public AccountData createAccountData() {
        return new AccountData();
    }

    /**
     * Create an instance of {@link ContactEmailList }
     * 
     */
    public ContactEmailList createContactEmailList() {
        return new ContactEmailList();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStore }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.storepoints.com/", name = "addStore")
    public JAXBElement<AddStore> createAddStore(AddStore value) {
        return new JAXBElement<AddStore>(_AddStore_QNAME, AddStore.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccounts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.storepoints.com/", name = "getAccounts")
    public JAXBElement<GetAccounts> createGetAccounts(GetAccounts value) {
        return new JAXBElement<GetAccounts>(_GetAccounts_QNAME, GetAccounts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStores }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.storepoints.com/", name = "getStores")
    public JAXBElement<GetStores> createGetStores(GetStores value) {
        return new JAXBElement<GetStores>(_GetStores_QNAME, GetStores.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.storepoints.com/", name = "getUserListResponse")
    public JAXBElement<GetUserListResponse> createGetUserListResponse(GetUserListResponse value) {
        return new JAXBElement<GetUserListResponse>(_GetUserListResponse_QNAME, GetUserListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStoresResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.storepoints.com/", name = "getStoresResponse")
    public JAXBElement<GetStoresResponse> createGetStoresResponse(GetStoresResponse value) {
        return new JAXBElement<GetStoresResponse>(_GetStoresResponse_QNAME, GetStoresResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.storepoints.com/", name = "getAccountsResponse")
    public JAXBElement<GetAccountsResponse> createGetAccountsResponse(GetAccountsResponse value) {
        return new JAXBElement<GetAccountsResponse>(_GetAccountsResponse_QNAME, GetAccountsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.storepoints.com/", name = "getUserList")
    public JAXBElement<GetUserList> createGetUserList(GetUserList value) {
        return new JAXBElement<GetUserList>(_GetUserList_QNAME, GetUserList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStoreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.storepoints.com/", name = "addStoreResponse")
    public JAXBElement<AddStoreResponse> createAddStoreResponse(AddStoreResponse value) {
        return new JAXBElement<AddStoreResponse>(_AddStoreResponse_QNAME, AddStoreResponse.class, null, value);
    }

}
