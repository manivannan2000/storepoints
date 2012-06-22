
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

    private final static QName _GetAccounts_QNAME = new QName("http://service.storepoints.com/", "getAccounts");
    private final static QName _StoreAccount_QNAME = new QName("http://service.storepoints.com/", "StoreAccount");
    private final static QName _GetAccountsResponse_QNAME = new QName("http://service.storepoints.com/", "getAccountsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.storepoints.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAccounts }
     * 
     */
    public GetAccounts createGetAccounts() {
        return new GetAccounts();
    }

    /**
     * Create an instance of {@link Account }
     * 
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link GetAccountsResponse }
     * 
     */
    public GetAccountsResponse createGetAccountsResponse() {
        return new GetAccountsResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Account }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.storepoints.com/", name = "StoreAccount")
    public JAXBElement<Account> createStoreAccount(Account value) {
        return new JAXBElement<Account>(_StoreAccount_QNAME, Account.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.storepoints.com/", name = "getAccountsResponse")
    public JAXBElement<GetAccountsResponse> createGetAccountsResponse(GetAccountsResponse value) {
        return new JAXBElement<GetAccountsResponse>(_GetAccountsResponse_QNAME, GetAccountsResponse.class, null, value);
    }

}
