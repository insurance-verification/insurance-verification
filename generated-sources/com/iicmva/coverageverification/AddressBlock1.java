
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
 * Grouping of information used to specify the location address. | Describes what is commonly known as the mailing address.
 * 
 * <p>Java class for AddressBlock_1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddressBlock_1"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="StreetAddress" type="{http://www.iicmva.com/CoverageVerification/}LocationText_9" maxOccurs="2"/&gt;
 *             &lt;element name="SubsiteAddress" type="{http://www.iicmva.com/CoverageVerification/}SubsiteAddressComponent_1" minOccurs="0"/&gt;
 *             &lt;element name="City" type="{http://www.iicmva.com/CoverageVerification/}LocationText_1" minOccurs="0"/&gt;
 *             &lt;element name="CountrySubdivision" type="{http://www.iicmva.com/CoverageVerification/}LocationCode_2" minOccurs="0"/&gt;
 *             &lt;element name="PostalCode" type="{http://www.iicmva.com/CoverageVerification/}LocationIdentifier_1" minOccurs="0"/&gt;
 *             &lt;element name="Country" type="{http://www.iicmva.com/CoverageVerification/}LocationCode_3" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="SubsiteAddress" type="{http://www.iicmva.com/CoverageVerification/}SubsiteAddressComponent_1"/&gt;
 *             &lt;element name="City" type="{http://www.iicmva.com/CoverageVerification/}LocationText_1" minOccurs="0"/&gt;
 *             &lt;element name="CountrySubdivision" type="{http://www.iicmva.com/CoverageVerification/}LocationCode_2" minOccurs="0"/&gt;
 *             &lt;element name="PostalCode" type="{http://www.iicmva.com/CoverageVerification/}LocationIdentifier_1" minOccurs="0"/&gt;
 *             &lt;element name="Country" type="{http://www.iicmva.com/CoverageVerification/}LocationCode_3" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="City" type="{http://www.iicmva.com/CoverageVerification/}LocationText_1"/&gt;
 *             &lt;element name="CountrySubdivision" type="{http://www.iicmva.com/CoverageVerification/}LocationCode_2" minOccurs="0"/&gt;
 *             &lt;element name="PostalCode" type="{http://www.iicmva.com/CoverageVerification/}LocationIdentifier_1" minOccurs="0"/&gt;
 *             &lt;element name="Country" type="{http://www.iicmva.com/CoverageVerification/}LocationCode_3" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="CountrySubdivision" type="{http://www.iicmva.com/CoverageVerification/}LocationCode_2"/&gt;
 *             &lt;element name="PostalCode" type="{http://www.iicmva.com/CoverageVerification/}LocationIdentifier_1" minOccurs="0"/&gt;
 *             &lt;element name="Country" type="{http://www.iicmva.com/CoverageVerification/}LocationCode_3" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="PostalCode" type="{http://www.iicmva.com/CoverageVerification/}LocationIdentifier_1"/&gt;
 *             &lt;element name="Country" type="{http://www.iicmva.com/CoverageVerification/}LocationCode_3" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="Country" type="{http://www.iicmva.com/CoverageVerification/}LocationCode_3"/&gt;
 *           &lt;/sequence&gt;
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
@XmlType(name = "AddressBlock_1", propOrder = {
    "content"
})
public class AddressBlock1 {

    @XmlElementRefs({
        @XmlElementRef(name = "SubsiteAddress", namespace = "http://www.iicmva.com/CoverageVerification/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PostalCode", namespace = "http://www.iicmva.com/CoverageVerification/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Country", namespace = "http://www.iicmva.com/CoverageVerification/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "StreetAddress", namespace = "http://www.iicmva.com/CoverageVerification/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "City", namespace = "http://www.iicmva.com/CoverageVerification/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CountrySubdivision", namespace = "http://www.iicmva.com/CoverageVerification/", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> content;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "SubsiteAddress" is used by two different parts of a schema. See: 
     * line 342 of file:/C:/source/insurance-verification-system/src/main/resources/wsdl/CoverageVerification.wsdl
     * line 315 of file:/C:/source/insurance-verification-system/src/main/resources/wsdl/CoverageVerification.wsdl
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
     * {@link JAXBElement }{@code <}{@link SubsiteAddressComponent1 }{@code >}
     * {@link JAXBElement }{@code <}{@link LocationIdentifier1 }{@code >}
     * {@link JAXBElement }{@code <}{@link LocationCode3 }{@code >}
     * {@link JAXBElement }{@code <}{@link LocationCode2 }{@code >}
     * {@link JAXBElement }{@code <}{@link LocationText9 }{@code >}
     * {@link JAXBElement }{@code <}{@link LocationText1 }{@code >}
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
