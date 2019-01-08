
package com.iicmva.coverageverification;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RequestorInformation" type="{http://www.iicmva.com/CoverageVerification/}RequestorInformationModule" minOccurs="0"/&gt;
 *         &lt;element name="Detail"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="PolicyInformation" type="{http://www.iicmva.com/CoverageVerification/}CoveragePolicyResponseModule"/&gt;
 *                   &lt;element name="InsuredInformation" type="{http://www.iicmva.com/CoverageVerification/}InsuredModule" minOccurs="0"/&gt;
 *                   &lt;element name="VehicleInformation" type="{http://www.iicmva.com/CoverageVerification/}RiskInformationModule" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="PublicationVersion" use="required" type="{http://www.iicmva.com/CoverageVerification/}PublicationVersionType" /&gt;
 *       &lt;attribute name="PublicationDate" use="required" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "requestorInformation",
    "detail"
})
@XmlRootElement(name = "CoverageResponseDocument")
public class CoverageResponseDocument {

    @XmlElement(name = "RequestorInformation")
    protected RequestorInformationModule requestorInformation;
    @XmlElement(name = "Detail", required = true)
    protected CoverageResponseDocument.Detail detail;
    @XmlAttribute(name = "PublicationVersion", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String publicationVersion;
    @XmlAttribute(name = "PublicationDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar publicationDate;

    /**
     * Gets the value of the requestorInformation property.
     * 
     * @return
     *     possible object is
     *     {@link RequestorInformationModule }
     *     
     */
    public RequestorInformationModule getRequestorInformation() {
        return requestorInformation;
    }

    /**
     * Sets the value of the requestorInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestorInformationModule }
     *     
     */
    public void setRequestorInformation(RequestorInformationModule value) {
        this.requestorInformation = value;
    }

    /**
     * Gets the value of the detail property.
     * 
     * @return
     *     possible object is
     *     {@link CoverageResponseDocument.Detail }
     *     
     */
    public CoverageResponseDocument.Detail getDetail() {
        return detail;
    }

    /**
     * Sets the value of the detail property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoverageResponseDocument.Detail }
     *     
     */
    public void setDetail(CoverageResponseDocument.Detail value) {
        this.detail = value;
    }

    /**
     * Gets the value of the publicationVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicationVersion() {
        return publicationVersion;
    }

    /**
     * Sets the value of the publicationVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicationVersion(String value) {
        this.publicationVersion = value;
    }

    /**
     * Gets the value of the publicationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPublicationDate() {
        return publicationDate;
    }

    /**
     * Sets the value of the publicationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPublicationDate(XMLGregorianCalendar value) {
        this.publicationDate = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="PolicyInformation" type="{http://www.iicmva.com/CoverageVerification/}CoveragePolicyResponseModule"/&gt;
     *         &lt;element name="InsuredInformation" type="{http://www.iicmva.com/CoverageVerification/}InsuredModule" minOccurs="0"/&gt;
     *         &lt;element name="VehicleInformation" type="{http://www.iicmva.com/CoverageVerification/}RiskInformationModule" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "policyInformation",
        "insuredInformation",
        "vehicleInformation"
    })
    public static class Detail {

        @XmlElement(name = "PolicyInformation", required = true)
        protected CoveragePolicyResponseModule policyInformation;
        @XmlElement(name = "InsuredInformation")
        protected InsuredModule insuredInformation;
        @XmlElement(name = "VehicleInformation")
        protected RiskInformationModule vehicleInformation;

        /**
         * Gets the value of the policyInformation property.
         * 
         * @return
         *     possible object is
         *     {@link CoveragePolicyResponseModule }
         *     
         */
        public CoveragePolicyResponseModule getPolicyInformation() {
            return policyInformation;
        }

        /**
         * Sets the value of the policyInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link CoveragePolicyResponseModule }
         *     
         */
        public void setPolicyInformation(CoveragePolicyResponseModule value) {
            this.policyInformation = value;
        }

        /**
         * Gets the value of the insuredInformation property.
         * 
         * @return
         *     possible object is
         *     {@link InsuredModule }
         *     
         */
        public InsuredModule getInsuredInformation() {
            return insuredInformation;
        }

        /**
         * Sets the value of the insuredInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link InsuredModule }
         *     
         */
        public void setInsuredInformation(InsuredModule value) {
            this.insuredInformation = value;
        }

        /**
         * Gets the value of the vehicleInformation property.
         * 
         * @return
         *     possible object is
         *     {@link RiskInformationModule }
         *     
         */
        public RiskInformationModule getVehicleInformation() {
            return vehicleInformation;
        }

        /**
         * Sets the value of the vehicleInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link RiskInformationModule }
         *     
         */
        public void setVehicleInformation(RiskInformationModule value) {
            this.vehicleInformation = value;
        }

    }

}
