
package com.iicmva.coverageverification;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Grouping of information that is used to specify an individual's name. | Name of the individual.
 * 
 * <p>Java class for IndividualNameComponent_2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndividualNameComponent_2"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Prefix" type="{http://www.iicmva.com/CoverageVerification/}NameText_2" minOccurs="0"/&gt;
 *         &lt;element name="GivenName" type="{http://www.iicmva.com/CoverageVerification/}NameText_4"/&gt;
 *         &lt;element name="MiddleName" type="{http://www.iicmva.com/CoverageVerification/}NameText_5" minOccurs="0"/&gt;
 *         &lt;element name="Surname" type="{http://www.iicmva.com/CoverageVerification/}NameText_6" maxOccurs="2"/&gt;
 *         &lt;element name="Suffix" type="{http://www.iicmva.com/CoverageVerification/}NameText_2" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndividualNameComponent_2", propOrder = {
    "prefix",
    "givenName",
    "middleName",
    "surname",
    "suffix"
})
public class IndividualNameComponent2 {

    @XmlElement(name = "Prefix")
    protected NameText2 prefix;
    @XmlElement(name = "GivenName", required = true)
    protected NameText4 givenName;
    @XmlElement(name = "MiddleName")
    protected NameText5 middleName;
    @XmlElement(name = "Surname", required = true)
    protected List<NameText6> surname;
    @XmlElement(name = "Suffix")
    protected NameText2 suffix;

    /**
     * Gets the value of the prefix property.
     * 
     * @return
     *     possible object is
     *     {@link NameText2 }
     *     
     */
    public NameText2 getPrefix() {
        return prefix;
    }

    /**
     * Sets the value of the prefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameText2 }
     *     
     */
    public void setPrefix(NameText2 value) {
        this.prefix = value;
    }

    /**
     * Gets the value of the givenName property.
     * 
     * @return
     *     possible object is
     *     {@link NameText4 }
     *     
     */
    public NameText4 getGivenName() {
        return givenName;
    }

    /**
     * Sets the value of the givenName property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameText4 }
     *     
     */
    public void setGivenName(NameText4 value) {
        this.givenName = value;
    }

    /**
     * Gets the value of the middleName property.
     * 
     * @return
     *     possible object is
     *     {@link NameText5 }
     *     
     */
    public NameText5 getMiddleName() {
        return middleName;
    }

    /**
     * Sets the value of the middleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameText5 }
     *     
     */
    public void setMiddleName(NameText5 value) {
        this.middleName = value;
    }

    /**
     * Gets the value of the surname property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the surname property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSurname().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameText6 }
     * 
     * 
     */
    public List<NameText6> getSurname() {
        if (surname == null) {
            surname = new ArrayList<NameText6>();
        }
        return this.surname;
    }

    /**
     * Gets the value of the suffix property.
     * 
     * @return
     *     possible object is
     *     {@link NameText2 }
     *     
     */
    public NameText2 getSuffix() {
        return suffix;
    }

    /**
     * Sets the value of the suffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameText2 }
     *     
     */
    public void setSuffix(NameText2 value) {
        this.suffix = value;
    }

}
