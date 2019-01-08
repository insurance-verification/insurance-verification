
package com.iicmva.coverageverification;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the role and identity of an organization. | Information provided to identify the insurance company.
 * 
 * <p>Java class for OrganizationBlock_4 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganizationBlock_4"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NAIC" type="{http://www.iicmva.com/CoverageVerification/}PartyIdentifier_18"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganizationBlock_4", propOrder = {
    "naic"
})
public class OrganizationBlock4 {

    @XmlElement(name = "NAIC", required = true)
    protected PartyIdentifier18 naic;

    /**
     * Gets the value of the naic property.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentifier18 }
     *     
     */
    public PartyIdentifier18 getNAIC() {
        return naic;
    }

    /**
     * Sets the value of the naic property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentifier18 }
     *     
     */
    public void setNAIC(PartyIdentifier18 value) {
        this.naic = value;
    }

}
