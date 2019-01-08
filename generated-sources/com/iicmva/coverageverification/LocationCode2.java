
package com.iicmva.coverageverification;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * A list of codes that designates a place. | The highest level of subdivision within a country.
 * 
 * <p>Java class for LocationCode_2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LocationCode_2"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.iicmva.com/CoverageVerification/&gt;LocationCode_2_Content"&gt;
 *       &lt;attribute name="ListIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ListAgencyIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ListAgencyNameText" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ListNameText" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ListVersionIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="LanguageIdentifier" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *       &lt;attribute name="ListURI" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ListSchemeURI" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocationCode_2", propOrder = {
    "value"
})
public class LocationCode2 {

    @XmlValue
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String value;
    @XmlAttribute(name = "ListIdentifier")
    protected String listIdentifier;
    @XmlAttribute(name = "ListAgencyIdentifier")
    protected String listAgencyIdentifier;
    @XmlAttribute(name = "ListAgencyNameText")
    protected String listAgencyNameText;
    @XmlAttribute(name = "ListNameText")
    protected String listNameText;
    @XmlAttribute(name = "ListVersionIdentifier")
    protected String listVersionIdentifier;
    @XmlAttribute(name = "LanguageIdentifier")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String languageIdentifier;
    @XmlAttribute(name = "ListURI")
    protected String listURI;
    @XmlAttribute(name = "ListSchemeURI")
    protected String listSchemeURI;

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
     * Gets the value of the listIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListIdentifier() {
        return listIdentifier;
    }

    /**
     * Sets the value of the listIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListIdentifier(String value) {
        this.listIdentifier = value;
    }

    /**
     * Gets the value of the listAgencyIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListAgencyIdentifier() {
        return listAgencyIdentifier;
    }

    /**
     * Sets the value of the listAgencyIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListAgencyIdentifier(String value) {
        this.listAgencyIdentifier = value;
    }

    /**
     * Gets the value of the listAgencyNameText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListAgencyNameText() {
        return listAgencyNameText;
    }

    /**
     * Sets the value of the listAgencyNameText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListAgencyNameText(String value) {
        this.listAgencyNameText = value;
    }

    /**
     * Gets the value of the listNameText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListNameText() {
        return listNameText;
    }

    /**
     * Sets the value of the listNameText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListNameText(String value) {
        this.listNameText = value;
    }

    /**
     * Gets the value of the listVersionIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListVersionIdentifier() {
        return listVersionIdentifier;
    }

    /**
     * Sets the value of the listVersionIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListVersionIdentifier(String value) {
        this.listVersionIdentifier = value;
    }

    /**
     * Gets the value of the languageIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguageIdentifier() {
        return languageIdentifier;
    }

    /**
     * Sets the value of the languageIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguageIdentifier(String value) {
        this.languageIdentifier = value;
    }

    /**
     * Gets the value of the listURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListURI() {
        return listURI;
    }

    /**
     * Sets the value of the listURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListURI(String value) {
        this.listURI = value;
    }

    /**
     * Gets the value of the listSchemeURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListSchemeURI() {
        return listSchemeURI;
    }

    /**
     * Sets the value of the listSchemeURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListSchemeURI(String value) {
        this.listSchemeURI = value;
    }

}
