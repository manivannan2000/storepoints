
package com.storepoints.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for user complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="user">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contactEmailList" type="{http://service.storepoints.com/}contactEmailList" minOccurs="0"/>
 *         &lt;element name="contactPhoneList" type="{http://service.storepoints.com/}contactPhoneList" minOccurs="0"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user", propOrder = {
    "contactEmailList",
    "contactPhoneList",
    "firstName",
    "lastName",
    "userId"
})
public class User {

    protected ContactEmailList contactEmailList;
    protected ContactPhoneList contactPhoneList;
    protected String firstName;
    protected String lastName;
    protected String userId;

    /**
     * Gets the value of the contactEmailList property.
     * 
     * @return
     *     possible object is
     *     {@link ContactEmailList }
     *     
     */
    public ContactEmailList getContactEmailList() {
        return contactEmailList;
    }

    /**
     * Sets the value of the contactEmailList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactEmailList }
     *     
     */
    public void setContactEmailList(ContactEmailList value) {
        this.contactEmailList = value;
    }

    /**
     * Gets the value of the contactPhoneList property.
     * 
     * @return
     *     possible object is
     *     {@link ContactPhoneList }
     *     
     */
    public ContactPhoneList getContactPhoneList() {
        return contactPhoneList;
    }

    /**
     * Sets the value of the contactPhoneList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactPhoneList }
     *     
     */
    public void setContactPhoneList(ContactPhoneList value) {
        this.contactPhoneList = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

}
