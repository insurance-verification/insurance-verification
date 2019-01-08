
package com.iicmva.coverageverification;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Describes a specific status | Describes the status of the coverage for the policy listed in the inquiry.
 * 
 * <p>Java class for StatusInformationBlock_4 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StatusInformationBlock_4"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ResponseDetails" type="{http://www.iicmva.com/CoverageVerification/}ParsedStatusComponent_3"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatusInformationBlock_4", propOrder = {
    "responseDetails"
})
public class StatusInformationBlock4 {

    @XmlElement(name = "ResponseDetails", required = true)
    protected ParsedStatusComponent3 responseDetails;

    /**
     * Gets the value of the responseDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ParsedStatusComponent3 }
     *     
     */
    public ParsedStatusComponent3 getResponseDetails() {
        return responseDetails;
    }

    /**
     * Sets the value of the responseDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParsedStatusComponent3 }
     *     
     */
    public void setResponseDetails(ParsedStatusComponent3 value) {
        this.responseDetails = value;
    }

}
