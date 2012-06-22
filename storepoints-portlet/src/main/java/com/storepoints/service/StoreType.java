
package com.storepoints.service;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for storeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="storeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="REST"/>
 *     &lt;enumeration value="TEXT"/>
 *     &lt;enumeration value="OTHER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "storeType")
@XmlEnum
public enum StoreType {

    REST,
    TEXT,
    OTHER;

    public String value() {
        return name();
    }

    public static StoreType fromValue(String v) {
        return valueOf(v);
    }

}
