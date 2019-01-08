
package com.iicmva.coverageverification;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * Identifies the role and identity of an individual. | Defines the party that that information is being requested on.
 * 
 * <p>Java class for IndividualBlock_3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndividualBlock_3"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="ParsedName" type="{http://www.iicmva.com/CoverageVerification/}IndividualNameComponent_2"/&gt;
 *             &lt;element name="Name" type="{http://www.iicmva.com/CoverageVerification/}NameText_1" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="Name" type="{http://www.iicmva.com/CoverageVerification/}NameText_1"/&gt;
 *           &lt;/sequence&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="SocialSecurityNumber" type="{http://www.iicmva.com/CoverageVerification/}PartyIdentifier_9" minOccurs="0"/&gt;
 *         &lt;element name="DriversLicense" type="{http://www.iicmva.com/CoverageVerification/}PartyIdentifier_8" minOccurs="0"/&gt;
 *         &lt;element name="FEIN" type="{http://www.iicmva.com/CoverageVerification/}PartyIdentifier_8" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndividualBlock_3", propOrder = {
    "content"
})
public class IndividualBlock3 {

    @XmlElementRefs({
        @XmlElementRef(name = "SocialSecurityNumber", namespace = "http://www.iicmva.com/CoverageVerification/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ParsedName", namespace = "http://www.iicmva.com/CoverageVerification/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Name", namespace = "http://www.iicmva.com/CoverageVerification/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DriversLicense", namespace = "http://www.iicmva.com/CoverageVerification/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FEIN", namespace = "http://www.iicmva.com/CoverageVerification/", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> content;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Name" is used by two different parts of a schema. See: 
     * line 467 of file:/C:/source/insurance-verification-system/src/main/resources/wsdl/CoverageVerification.wsdl
     * line 460 of file:/C:/source/insurance-verification-system/src/main/resources/wsdl/CoverageVerification.wsdl
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link PartyIdentifier9 }{@code >}
     * {@link JAXBElement }{@code <}{@link NameText1 }{@code >}
     * {@link JAXBElement }{@code <}{@link PartyIdentifier8 }{@code >}
     * {@link JAXBElement }{@code <}{@link PartyIdentifier8 }{@code >}
     * {@link JAXBElement }{@code <}{@link IndividualNameComponent2 }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getContent() {
        if (content == null) {
            content = new ArrayList<JAXBElement<?>>();
        }
        return this.content;
    }

}
