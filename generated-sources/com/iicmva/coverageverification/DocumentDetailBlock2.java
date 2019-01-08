
package com.iicmva.coverageverification;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies a logical or physical document level of contextual information, unique identification number, creation date, etc. | Defines the reason the requestor needs the insurance information.
 * 
 * <p>Java class for DocumentDetailBlock_2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentDetailBlock_2"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ReasonCode" type="{http://www.iicmva.com/CoverageVerification/}ReasonCode_1"/&gt;
 *         &lt;element name="TrackingNumber" type="{http://www.iicmva.com/CoverageVerification/}ResourceIdentifier_12" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentDetailBlock_2", propOrder = {
    "reasonCode",
    "trackingNumber"
})
public class DocumentDetailBlock2 {

    @XmlElement(name = "ReasonCode", required = true)
    protected ReasonCode1 reasonCode;
    @XmlElement(name = "TrackingNumber")
    protected ResourceIdentifier12 trackingNumber;

    /**
     * Gets the value of the reasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link ReasonCode1 }
     *     
     */
    public ReasonCode1 getReasonCode() {
        return reasonCode;
    }

    /**
     * Sets the value of the reasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReasonCode1 }
     *     
     */
    public void setReasonCode(ReasonCode1 value) {
        this.reasonCode = value;
    }

    /**
     * Gets the value of the trackingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceIdentifier12 }
     *     
     */
    public ResourceIdentifier12 getTrackingNumber() {
        return trackingNumber;
    }

    /**
     * Sets the value of the trackingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceIdentifier12 }
     *     
     */
    public void setTrackingNumber(ResourceIdentifier12 value) {
        this.trackingNumber = value;
    }

}
