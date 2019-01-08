
package com.iicmva.coverageverification;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResourceCode_9_Content.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ResourceCode_9_Content"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="CombinedSingleLimit"/&gt;
 *     &lt;enumeration value="PerOccurrence"/&gt;
 *     &lt;enumeration value="PerPerson"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ResourceCode_9_Content")
@XmlEnum
public enum ResourceCode9Content {


    /**
     * Combined Single Limit
     * 
     */
    @XmlEnumValue("CombinedSingleLimit")
    COMBINED_SINGLE_LIMIT("CombinedSingleLimit"),

    /**
     * Per Occurrence
     * 
     */
    @XmlEnumValue("PerOccurrence")
    PER_OCCURRENCE("PerOccurrence"),

    /**
     * Per Person
     * 
     */
    @XmlEnumValue("PerPerson")
    PER_PERSON("PerPerson");
    private final String value;

    ResourceCode9Content(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ResourceCode9Content fromValue(String v) {
        for (ResourceCode9Content c: ResourceCode9Content.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
