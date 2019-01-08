
package com.iicmva.coverageverification;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * A word or phrase that constitutes the distinctive designation of a person or thing. | The title before an individual's name.
 * 
 * <p>Java class for NameText_2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NameText_2"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.iicmva.com/CoverageVerification/&gt;NameText_2_Content"&gt;
 *       &lt;attribute name="LanguageIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="LanguageLocaleIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NameText_2", propOrder = {
    "value"
})
public class NameText2 {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "LanguageIdentifier")
    protected String languageIdentifier;
    @XmlAttribute(name = "LanguageLocaleIdentifier")
    protected String languageLocaleIdentifier;

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
     * Gets the value of the languageLocaleIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguageLocaleIdentifier() {
        return languageLocaleIdentifier;
    }

    /**
     * Sets the value of the languageLocaleIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguageLocaleIdentifier(String value) {
        this.languageLocaleIdentifier = value;
    }

}
