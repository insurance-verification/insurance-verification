
package com.iicmva.coverageverification;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReasonCode_1_Content.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReasonCode_1_Content"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="ACC"/&gt;
 *     &lt;enumeration value="ACCV"/&gt;
 *     &lt;enumeration value="BIVER"/&gt;
 *     &lt;enumeration value="PIPVER"/&gt;
 *     &lt;enumeration value="REGREN"/&gt;
 *     &lt;enumeration value="VEHREG"/&gt;
 *     &lt;enumeration value="VIOL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ReasonCode_1_Content")
@XmlEnum
public enum ReasonCode1Content {


    /**
     * Accident
     * 
     */
    ACC,

    /**
     * Traffic Violation with Accident
     * 
     */
    ACCV,

    /**
     * Bodily Injury (BI) Coverage Verification
     * 
     */
    BIVER,

    /**
     * Personal Injury Protection (PIP) Coverage Verification
     * 
     */
    PIPVER,

    /**
     * Registration Renewal
     * 
     */
    REGREN,

    /**
     * Registration of Vehicle
     * 
     */
    VEHREG,

    /**
     * Traffic Violation
     * 
     */
    VIOL;

    public String value() {
        return name();
    }

    public static ReasonCode1Content fromValue(String v) {
        return valueOf(v);
    }

}
