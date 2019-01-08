
package com.iicmva.coverageverification;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EventCode_7_Content.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EventCode_7_Content"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="Confirmed"/&gt;
 *     &lt;enumeration value="Unconfirmed"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EventCode_7_Content")
@XmlEnum
public enum EventCode7Content {


    /**
     * Confirmed
     * 
     */
    @XmlEnumValue("Confirmed")
    CONFIRMED("Confirmed"),

    /**
     * Unconfirmed
     * 
     */
    @XmlEnumValue("Unconfirmed")
    UNCONFIRMED("Unconfirmed");
    private final String value;

    EventCode7Content(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EventCode7Content fromValue(String v) {
        for (EventCode7Content c: EventCode7Content.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
