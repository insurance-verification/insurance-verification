
package com.iicmva.coverageverification;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Details of a status. | Describes the result of the inquiry.
 * 
 * <p>Java class for ParsedStatusComponent_3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParsedStatusComponent_3"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ResponseCode" type="{http://www.iicmva.com/CoverageVerification/}EventCode_7"/&gt;
 *         &lt;element name="UnconfirmedReasonCode" type="{http://www.iicmva.com/CoverageVerification/}EventCode_8" maxOccurs="5" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParsedStatusComponent_3", propOrder = {
    "responseCode",
    "unconfirmedReasonCode"
})
public class ParsedStatusComponent3 {

    @XmlElement(name = "ResponseCode", required = true)
    protected EventCode7 responseCode;
    @XmlElement(name = "UnconfirmedReasonCode")
    protected List<EventCode8> unconfirmedReasonCode;

    /**
     * Gets the value of the responseCode property.
     * 
     * @return
     *     possible object is
     *     {@link EventCode7 }
     *     
     */
    public EventCode7 getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventCode7 }
     *     
     */
    public void setResponseCode(EventCode7 value) {
        this.responseCode = value;
    }

    /**
     * Gets the value of the unconfirmedReasonCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unconfirmedReasonCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnconfirmedReasonCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EventCode8 }
     * 
     * 
     */
    public List<EventCode8> getUnconfirmedReasonCode() {
        if (unconfirmedReasonCode == null) {
            unconfirmedReasonCode = new ArrayList<EventCode8>();
        }
        return this.unconfirmedReasonCode;
    }

}
