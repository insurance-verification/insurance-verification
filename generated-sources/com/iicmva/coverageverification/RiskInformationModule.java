
package com.iicmva.coverageverification;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Defines the information used to identify a risk.
 * 
 * <p>Java class for RiskInformationModule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RiskInformationModule"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="VehicleDetails" type="{http://www.iicmva.com/CoverageVerification/}ResourceIdentificationBlock_1"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RiskInformationModule", propOrder = {
    "vehicleDetails"
})
public class RiskInformationModule {

    @XmlElement(name = "VehicleDetails", required = true)
    protected ResourceIdentificationBlock1 vehicleDetails;

    /**
     * Gets the value of the vehicleDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceIdentificationBlock1 }
     *     
     */
    public ResourceIdentificationBlock1 getVehicleDetails() {
        return vehicleDetails;
    }

    /**
     * Sets the value of the vehicleDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceIdentificationBlock1 }
     *     
     */
    public void setVehicleDetails(ResourceIdentificationBlock1 value) {
        this.vehicleDetails = value;
    }

}
