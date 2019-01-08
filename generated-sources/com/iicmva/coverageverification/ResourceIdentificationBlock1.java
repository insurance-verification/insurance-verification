
package com.iicmva.coverageverification;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Combination of constructs that together identify a specific resource. | The terms used to specifically describe a vehicle.
 * 
 * <p>Java class for ResourceIdentificationBlock_1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResourceIdentificationBlock_1"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="VIN" type="{http://www.iicmva.com/CoverageVerification/}ResourceIdentifier_11"/&gt;
 *         &lt;element name="Make" type="{http://www.iicmva.com/CoverageVerification/}ResourceIdentifier_12" minOccurs="0"/&gt;
 *         &lt;element name="Model" type="{http://www.iicmva.com/CoverageVerification/}ResourceIdentifier_12" minOccurs="0"/&gt;
 *         &lt;element name="Year" type="{http://www.iicmva.com/CoverageVerification/}DateTimeText_2" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceIdentificationBlock_1", propOrder = {
    "vin",
    "make",
    "model",
    "year"
})
public class ResourceIdentificationBlock1 {

    @XmlElement(name = "VIN", required = true)
    protected ResourceIdentifier11 vin;
    @XmlElement(name = "Make")
    protected ResourceIdentifier12 make;
    @XmlElement(name = "Model")
    protected ResourceIdentifier12 model;
    @XmlElement(name = "Year")
    protected DateTimeText2 year;

    /**
     * Gets the value of the vin property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceIdentifier11 }
     *     
     */
    public ResourceIdentifier11 getVIN() {
        return vin;
    }

    /**
     * Sets the value of the vin property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceIdentifier11 }
     *     
     */
    public void setVIN(ResourceIdentifier11 value) {
        this.vin = value;
    }

    /**
     * Gets the value of the make property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceIdentifier12 }
     *     
     */
    public ResourceIdentifier12 getMake() {
        return make;
    }

    /**
     * Sets the value of the make property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceIdentifier12 }
     *     
     */
    public void setMake(ResourceIdentifier12 value) {
        this.make = value;
    }

    /**
     * Gets the value of the model property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceIdentifier12 }
     *     
     */
    public ResourceIdentifier12 getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceIdentifier12 }
     *     
     */
    public void setModel(ResourceIdentifier12 value) {
        this.model = value;
    }

    /**
     * Gets the value of the year property.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeText2 }
     *     
     */
    public DateTimeText2 getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeText2 }
     *     
     */
    public void setYear(DateTimeText2 value) {
        this.year = value;
    }

}
