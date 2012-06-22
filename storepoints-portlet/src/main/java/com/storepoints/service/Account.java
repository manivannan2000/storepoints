
package com.storepoints.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for account complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="account">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="storePoint" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="storeType" type="{http://service.storepoints.com/}storeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "account", propOrder = {
    "accountName",
    "accountid",
    "storePoint",
    "storeType"
})
public class Account {

    protected String accountName;
    protected String accountid;
    protected int storePoint;
    protected StoreType storeType;

    /**
     * Gets the value of the accountName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Sets the value of the accountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountName(String value) {
        this.accountName = value;
    }

    /**
     * Gets the value of the accountid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountid() {
        return accountid;
    }

    /**
     * Sets the value of the accountid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountid(String value) {
        this.accountid = value;
    }

    /**
     * Gets the value of the storePoint property.
     * 
     */
    public int getStorePoint() {
        return storePoint;
    }

    /**
     * Sets the value of the storePoint property.
     * 
     */
    public void setStorePoint(int value) {
        this.storePoint = value;
    }

    /**
     * Gets the value of the storeType property.
     * 
     * @return
     *     possible object is
     *     {@link StoreType }
     *     
     */
    public StoreType getStoreType() {
        return storeType;
    }

    /**
     * Sets the value of the storeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link StoreType }
     *     
     */
    public void setStoreType(StoreType value) {
        this.storeType = value;
    }

}
