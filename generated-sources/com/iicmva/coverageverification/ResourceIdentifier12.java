
package com.iicmva.coverageverification;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Specified a supply or support, i.e. material or service. | Identifies information about the risk.
 * 
 * <p>Java class for ResourceIdentifier_12 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResourceIdentifier_12"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.iicmva.com/CoverageVerification/&gt;ResourceIdentifier_12_Content"&gt;
 *       &lt;attribute name="IDSchemeIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="IDSchemeNameText" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="IDSchemeAgencyIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="IDSchemeAgencyNameText" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="IDSchemeVersionIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="IDSchemeDataURI" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="IDSchemeURI" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceIdentifier_12", propOrder = {
    "value"
})
public class ResourceIdentifier12 {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "IDSchemeIdentifier")
    protected String idSchemeIdentifier;
    @XmlAttribute(name = "IDSchemeNameText")
    protected String idSchemeNameText;
    @XmlAttribute(name = "IDSchemeAgencyIdentifier")
    protected String idSchemeAgencyIdentifier;
    @XmlAttribute(name = "IDSchemeAgencyNameText")
    protected String idSchemeAgencyNameText;
    @XmlAttribute(name = "IDSchemeVersionIdentifier")
    protected String idSchemeVersionIdentifier;
    @XmlAttribute(name = "IDSchemeDataURI")
    protected String idSchemeDataURI;
    @XmlAttribute(name = "IDSchemeURI")
    protected String idSchemeURI;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the idSchemeIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDSchemeIdentifier() {
        return idSchemeIdentifier;
    }

    /**
     * Sets the value of the idSchemeIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDSchemeIdentifier(String value) {
        this.idSchemeIdentifier = value;
    }

    /**
     * Gets the value of the idSchemeNameText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDSchemeNameText() {
        return idSchemeNameText;
    }

    /**
     * Sets the value of the idSchemeNameText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDSchemeNameText(String value) {
        this.idSchemeNameText = value;
    }

    /**
     * Gets the value of the idSchemeAgencyIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDSchemeAgencyIdentifier() {
        return idSchemeAgencyIdentifier;
    }

    /**
     * Sets the value of the idSchemeAgencyIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDSchemeAgencyIdentifier(String value) {
        this.idSchemeAgencyIdentifier = value;
    }

    /**
     * Gets the value of the idSchemeAgencyNameText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDSchemeAgencyNameText() {
        return idSchemeAgencyNameText;
    }

    /**
     * Sets the value of the idSchemeAgencyNameText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDSchemeAgencyNameText(String value) {
        this.idSchemeAgencyNameText = value;
    }

    /**
     * Gets the value of the idSchemeVersionIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDSchemeVersionIdentifier() {
        return idSchemeVersionIdentifier;
    }

    /**
     * Sets the value of the idSchemeVersionIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDSchemeVersionIdentifier(String value) {
        this.idSchemeVersionIdentifier = value;
    }

    /**
     * Gets the value of the idSchemeDataURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDSchemeDataURI() {
        return idSchemeDataURI;
    }

    /**
     * Sets the value of the idSchemeDataURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDSchemeDataURI(String value) {
        this.idSchemeDataURI = value;
    }

    /**
     * Gets the value of the idSchemeURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDSchemeURI() {
        return idSchemeURI;
    }

    /**
     * Sets the value of the idSchemeURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDSchemeURI(String value) {
        this.idSchemeURI = value;
    }

}
