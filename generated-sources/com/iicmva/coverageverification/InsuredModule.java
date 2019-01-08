
package com.iicmva.coverageverification;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Describes the party information is being requested on.
 * 
 * <p>Java class for InsuredModule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InsuredModule"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PrimaryNameInformation" type="{http://www.iicmva.com/CoverageVerification/}IndividualBlock_3"/&gt;
 *         &lt;element name="AdditionalNamesInformation" type="{http://www.iicmva.com/CoverageVerification/}IndividualBlock_3" maxOccurs="20" minOccurs="0"/&gt;
 *         &lt;element name="Address" type="{http://www.iicmva.com/CoverageVerification/}AddressBlock_1"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsuredModule", propOrder = {
    "primaryNameInformation",
    "additionalNamesInformation",
    "address"
})
public class InsuredModule {

    @XmlElement(name = "PrimaryNameInformation", required = true)
    protected IndividualBlock3 primaryNameInformation;
    @XmlElement(name = "AdditionalNamesInformation")
    protected List<IndividualBlock3> additionalNamesInformation;
    @XmlElement(name = "Address", required = true)
    protected AddressBlock1 address;

    /**
     * Gets the value of the primaryNameInformation property.
     * 
     * @return
     *     possible object is
     *     {@link IndividualBlock3 }
     *     
     */
    public IndividualBlock3 getPrimaryNameInformation() {
        return primaryNameInformation;
    }

    /**
     * Sets the value of the primaryNameInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndividualBlock3 }
     *     
     */
    public void setPrimaryNameInformation(IndividualBlock3 value) {
        this.primaryNameInformation = value;
    }

    /**
     * Gets the value of the additionalNamesInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalNamesInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalNamesInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IndividualBlock3 }
     * 
     * 
     */
    public List<IndividualBlock3> getAdditionalNamesInformation() {
        if (additionalNamesInformation == null) {
            additionalNamesInformation = new ArrayList<IndividualBlock3>();
        }
        return this.additionalNamesInformation;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link AddressBlock1 }
     *     
     */
    public AddressBlock1 getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressBlock1 }
     *     
     */
    public void setAddress(AddressBlock1 value) {
        this.address = value;
    }

}
