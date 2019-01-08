
package com.iicmva.coverageverification;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the role and identity of an organization. | Defines the organization requesting the information.
 * 
 * <p>Java class for OrganizationBlock_3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganizationBlock_3"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Name" type="{http://www.iicmva.com/CoverageVerification/}NameText_1"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganizationBlock_3", propOrder = {
    "name"
})
public class OrganizationBlock3 {

    @XmlElement(name = "Name", required = true)
    protected NameText1 name;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link NameText1 }
     *     
     */
    public NameText1 getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameText1 }
     *     
     */
    public void setName(NameText1 value) {
        this.name = value;
    }

}
