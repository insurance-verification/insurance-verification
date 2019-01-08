
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
 * Detailed breakout of the information that is often found on the Address Lines of a mailing address such as apartment, building, department, floor, mail stop, room, and suite. | Detailed breakout of the information that is often found on the address lines of a mailing address such as apartment, building, department, floor, mail stop, room, or suite.
 * 
 * <p>Java class for SubsiteAddressComponent_1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubsiteAddressComponent_1"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="Apartment" type="{http://www.iicmva.com/CoverageVerification/}LocationText_2"/&gt;
 *             &lt;element name="Building" type="{http://www.iicmva.com/CoverageVerification/}LocationText_7" minOccurs="0"/&gt;
 *             &lt;element name="Department" type="{http://www.iicmva.com/CoverageVerification/}LocationText_7" minOccurs="0"/&gt;
 *             &lt;element name="Floor" type="{http://www.iicmva.com/CoverageVerification/}LocationText_2" minOccurs="0"/&gt;
 *             &lt;element name="Room" type="{http://www.iicmva.com/CoverageVerification/}LocationText_2" minOccurs="0"/&gt;
 *             &lt;element name="Suite" type="{http://www.iicmva.com/CoverageVerification/}LocationText_2" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="Building" type="{http://www.iicmva.com/CoverageVerification/}LocationText_7"/&gt;
 *             &lt;element name="Department" type="{http://www.iicmva.com/CoverageVerification/}LocationText_7" minOccurs="0"/&gt;
 *             &lt;element name="Floor" type="{http://www.iicmva.com/CoverageVerification/}LocationText_2" minOccurs="0"/&gt;
 *             &lt;element name="Room" type="{http://www.iicmva.com/CoverageVerification/}LocationText_2" minOccurs="0"/&gt;
 *             &lt;element name="Suite" type="{http://www.iicmva.com/CoverageVerification/}LocationText_2" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="Department" type="{http://www.iicmva.com/CoverageVerification/}LocationText_7"/&gt;
 *             &lt;element name="Floor" type="{http://www.iicmva.com/CoverageVerification/}LocationText_2" minOccurs="0"/&gt;
 *             &lt;element name="Room" type="{http://www.iicmva.com/CoverageVerification/}LocationText_2" minOccurs="0"/&gt;
 *             &lt;element name="Suite" type="{http://www.iicmva.com/CoverageVerification/}LocationText_2" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="Floor" type="{http://www.iicmva.com/CoverageVerification/}LocationText_2"/&gt;
 *             &lt;element name="Room" type="{http://www.iicmva.com/CoverageVerification/}LocationText_2" minOccurs="0"/&gt;
 *             &lt;element name="Suite" type="{http://www.iicmva.com/CoverageVerification/}LocationText_2" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="Room" type="{http://www.iicmva.com/CoverageVerification/}LocationText_2"/&gt;
 *             &lt;element name="Suite" type="{http://www.iicmva.com/CoverageVerification/}LocationText_2" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="Suite" type="{http://www.iicmva.com/CoverageVerification/}LocationText_2"/&gt;
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
@XmlType(name = "SubsiteAddressComponent_1", propOrder = {
    "content"
})
public class SubsiteAddressComponent1 {

    @XmlElementRefs({
        @XmlElementRef(name = "Apartment", namespace = "http://www.iicmva.com/CoverageVerification/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Floor", namespace = "http://www.iicmva.com/CoverageVerification/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Suite", namespace = "http://www.iicmva.com/CoverageVerification/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Building", namespace = "http://www.iicmva.com/CoverageVerification/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Department", namespace = "http://www.iicmva.com/CoverageVerification/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Room", namespace = "http://www.iicmva.com/CoverageVerification/", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> content;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Building" is used by two different parts of a schema. See: 
     * line 572 of file:/C:/source/insurance-verification-system/src/main/resources/wsdl/CoverageVerification.wsdl
     * line 545 of file:/C:/source/insurance-verification-system/src/main/resources/wsdl/CoverageVerification.wsdl
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
     * {@link JAXBElement }{@code <}{@link LocationText2 }{@code >}
     * {@link JAXBElement }{@code <}{@link LocationText2 }{@code >}
     * {@link JAXBElement }{@code <}{@link LocationText7 }{@code >}
     * {@link JAXBElement }{@code <}{@link LocationText2 }{@code >}
     * {@link JAXBElement }{@code <}{@link LocationText2 }{@code >}
     * {@link JAXBElement }{@code <}{@link LocationText7 }{@code >}
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
