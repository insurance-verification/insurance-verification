
package com.iicmva.coverageverification;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Identifies the role and identity of an individual. | Defines the individual requesting the  information.
 * 
 * <p>Java class for IndividualBlock_2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndividualBlock_2"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="ParsedName" type="{http://www.iicmva.com/CoverageVerification/}IndividualNameComponent_2" minOccurs="0"/&gt;
 *           &lt;element name="Name" type="{http://www.iicmva.com/CoverageVerification/}NameText_1" minOccurs="0"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndividualBlock_2", propOrder = {
    "parsedName",
    "name"
})
public class IndividualBlock2 {

    @XmlElement(name = "ParsedName")
    protected IndividualNameComponent2 parsedName;
    @XmlElement(name = "Name")
    protected NameText1 name;

    /**
     * Gets the value of the parsedName property.
     * 
     * @return
     *     possible object is
     *     {@link IndividualNameComponent2 }
     *     
     */
    public IndividualNameComponent2 getParsedName() {
        return parsedName;
    }

    /**
     * Sets the value of the parsedName property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndividualNameComponent2 }
     *     
     */
    public void setParsedName(IndividualNameComponent2 value) {
        this.parsedName = value;
    }

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
