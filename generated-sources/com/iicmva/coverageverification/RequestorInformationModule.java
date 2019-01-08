
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
 * Defines the party requesting the insurance information.
 * 
 * <p>Java class for RequestorInformationModule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestorInformationModule"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="Individual" type="{http://www.iicmva.com/CoverageVerification/}IndividualBlock_2"/&gt;
 *             &lt;element name="Organization" type="{http://www.iicmva.com/CoverageVerification/}OrganizationBlock_3" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="Organization" type="{http://www.iicmva.com/CoverageVerification/}OrganizationBlock_3"/&gt;
 *           &lt;/sequence&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="ReasonDetails" type="{http://www.iicmva.com/CoverageVerification/}DocumentDetailBlock_2" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestorInformationModule", propOrder = {
    "content"
})
public class RequestorInformationModule {

    @XmlElementRefs({
        @XmlElementRef(name = "Organization", namespace = "http://www.iicmva.com/CoverageVerification/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ReasonDetails", namespace = "http://www.iicmva.com/CoverageVerification/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Individual", namespace = "http://www.iicmva.com/CoverageVerification/", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> content;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Organization" is used by two different parts of a schema. See: 
     * line 99 of file:/C:/source/insurance-verification-system/src/main/resources/wsdl/CoverageVerification.wsdl
     * line 92 of file:/C:/source/insurance-verification-system/src/main/resources/wsdl/CoverageVerification.wsdl
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
     * {@link JAXBElement }{@code <}{@link IndividualBlock2 }{@code >}
     * {@link JAXBElement }{@code <}{@link DocumentDetailBlock2 }{@code >}
     * {@link JAXBElement }{@code <}{@link OrganizationBlock3 }{@code >}
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
