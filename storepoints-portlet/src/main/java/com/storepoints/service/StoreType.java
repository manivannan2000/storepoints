
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
 *     &lt;enumeration value="RESTAURANTS"/>
 *     &lt;enumeration value="TEXTILES"/>
 *     &lt;enumeration value="JEWEL"/>
 *     &lt;enumeration value="FURNITURES"/>
 *     &lt;enumeration value="GROCERY"/>
 *     &lt;enumeration value="PHARMA"/>
 *     &lt;enumeration value="ELECTRONICS"/>
 *     &lt;enumeration value="STATIONARY"/>
 *     &lt;enumeration value="OTHER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "storeType")
@XmlEnum
public enum StoreType {

    RESTAURANTS,
    TEXTILES,
    JEWEL,
    FURNITURES,
    GROCERY,
    PHARMA,
    ELECTRONICS,
    STATIONARY,
    OTHER;

    public String value() {
        return name();
    }

    public static StoreType fromValue(String v) {
        return valueOf(v);
    }

}
