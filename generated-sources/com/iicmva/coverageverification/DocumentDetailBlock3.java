
package com.iicmva.coverageverification;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies a logical or physical document level of contextual information, unique identification number, creation date, etc. | The specific items that identify an insurance policy
 * 
 * <p>Java class for DocumentDetailBlock_3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentDetailBlock_3"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="VerificationDate" type="{http://www.iicmva.com/CoverageVerification/}DateTime_1"/&gt;
 *         &lt;element name="PolicyKey" type="{http://www.iicmva.com/CoverageVerification/}ResourceIdentifier_12"/&gt;
 *         &lt;element name="PolicyState" type="{http://www.iicmva.com/CoverageVerification/}ResourceIdentifier_14"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentDetailBlock_3", propOrder = {
    "verificationDate",
    "policyKey",
    "policyState"
})
public class DocumentDetailBlock3 {

    @XmlElement(name = "VerificationDate", required = true)
    protected DateTime1 verificationDate;
    @XmlElement(name = "PolicyKey", required = true)
    protected ResourceIdentifier12 policyKey;
    @XmlElement(name = "PolicyState", required = true)
    protected ResourceIdentifier14 policyState;

    /**
     * Gets the value of the verificationDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime1 }
     *     
     */
    public DateTime1 getVerificationDate() {
        return verificationDate;
    }

    /**
     * Sets the value of the verificationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime1 }
     *     
     */
    public void setVerificationDate(DateTime1 value) {
        this.verificationDate = value;
    }

    /**
     * Gets the value of the policyKey property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceIdentifier12 }
     *     
     */
    public ResourceIdentifier12 getPolicyKey() {
        return policyKey;
    }

    /**
     * Sets the value of the policyKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceIdentifier12 }
     *     
     */
    public void setPolicyKey(ResourceIdentifier12 value) {
        this.policyKey = value;
    }

    /**
     * Gets the value of the policyState property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceIdentifier14 }
     *     
     */
    public ResourceIdentifier14 getPolicyState() {
        return policyState;
    }

    /**
     * Sets the value of the policyState property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceIdentifier14 }
     *     
     */
    public void setPolicyState(ResourceIdentifier14 value) {
        this.policyState = value;
    }

}
