
package com.iicmva.coverageverification;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Describes the value and purpose of a monetary amount. Can also optionally include the value and reason for adjustments to an amount.  All concrete amount blocks must clearly state the purpose and effect of adjustments (indicate if an amount includes an ad | Describes coverage limit configurations and maximum payment amounts for an insurance loss.
 * 
 * <p>Java class for AmountBlock_1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AmountBlock_1"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TypeofLimit" type="{http://www.iicmva.com/CoverageVerification/}ResourceCode_9"/&gt;
 *         &lt;element name="CoverageAmount" type="{http://www.iicmva.com/CoverageVerification/}Amount_1"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmountBlock_1", propOrder = {
    "typeofLimit",
    "coverageAmount"
})
public class AmountBlock1 {

    @XmlElement(name = "TypeofLimit", required = true)
    protected ResourceCode9 typeofLimit;
    @XmlElement(name = "CoverageAmount", required = true)
    protected Amount1 coverageAmount;

    /**
     * Gets the value of the typeofLimit property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceCode9 }
     *     
     */
    public ResourceCode9 getTypeofLimit() {
        return typeofLimit;
    }

    /**
     * Sets the value of the typeofLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceCode9 }
     *     
     */
    public void setTypeofLimit(ResourceCode9 value) {
        this.typeofLimit = value;
    }

    /**
     * Gets the value of the coverageAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Amount1 }
     *     
     */
    public Amount1 getCoverageAmount() {
        return coverageAmount;
    }

    /**
     * Sets the value of the coverageAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Amount1 }
     *     
     */
    public void setCoverageAmount(Amount1 value) {
        this.coverageAmount = value;
    }

}
