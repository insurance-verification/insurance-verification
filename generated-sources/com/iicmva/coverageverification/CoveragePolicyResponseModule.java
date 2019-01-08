
package com.iicmva.coverageverification;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The information needed to provide a response to a policy inquiry.
 * 
 * <p>Java class for CoveragePolicyResponseModule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CoveragePolicyResponseModule"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CoverageStatus" type="{http://www.iicmva.com/CoverageVerification/}StatusInformationBlock_4"/&gt;
 *         &lt;element name="OrganizationDetails" type="{http://www.iicmva.com/CoverageVerification/}OrganizationBlock_4"/&gt;
 *         &lt;element name="PolicyDetails" type="{http://www.iicmva.com/CoverageVerification/}DocumentDetailBlock_3"/&gt;
 *         &lt;element name="BodilyInjuryCoverage" type="{http://www.iicmva.com/CoverageVerification/}AmountBlock_1" maxOccurs="2" minOccurs="0"/&gt;
 *         &lt;element name="PropertyDamageCoverage" type="{http://www.iicmva.com/CoverageVerification/}AmountBlock_1" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CoveragePolicyResponseModule", propOrder = {
    "coverageStatus",
    "organizationDetails",
    "policyDetails",
    "bodilyInjuryCoverage",
    "propertyDamageCoverage"
})
public class CoveragePolicyResponseModule {

    @XmlElement(name = "CoverageStatus", required = true)
    protected StatusInformationBlock4 coverageStatus;
    @XmlElement(name = "OrganizationDetails", required = true)
    protected OrganizationBlock4 organizationDetails;
    @XmlElement(name = "PolicyDetails", required = true)
    protected DocumentDetailBlock3 policyDetails;
    @XmlElement(name = "BodilyInjuryCoverage")
    protected List<AmountBlock1> bodilyInjuryCoverage;
    @XmlElement(name = "PropertyDamageCoverage")
    protected AmountBlock1 propertyDamageCoverage;

    /**
     * Gets the value of the coverageStatus property.
     * 
     * @return
     *     possible object is
     *     {@link StatusInformationBlock4 }
     *     
     */
    public StatusInformationBlock4 getCoverageStatus() {
        return coverageStatus;
    }

    /**
     * Sets the value of the coverageStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusInformationBlock4 }
     *     
     */
    public void setCoverageStatus(StatusInformationBlock4 value) {
        this.coverageStatus = value;
    }

    /**
     * Gets the value of the organizationDetails property.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationBlock4 }
     *     
     */
    public OrganizationBlock4 getOrganizationDetails() {
        return organizationDetails;
    }

    /**
     * Sets the value of the organizationDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationBlock4 }
     *     
     */
    public void setOrganizationDetails(OrganizationBlock4 value) {
        this.organizationDetails = value;
    }

    /**
     * Gets the value of the policyDetails property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentDetailBlock3 }
     *     
     */
    public DocumentDetailBlock3 getPolicyDetails() {
        return policyDetails;
    }

    /**
     * Sets the value of the policyDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentDetailBlock3 }
     *     
     */
    public void setPolicyDetails(DocumentDetailBlock3 value) {
        this.policyDetails = value;
    }

    /**
     * Gets the value of the bodilyInjuryCoverage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bodilyInjuryCoverage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBodilyInjuryCoverage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountBlock1 }
     * 
     * 
     */
    public List<AmountBlock1> getBodilyInjuryCoverage() {
        if (bodilyInjuryCoverage == null) {
            bodilyInjuryCoverage = new ArrayList<AmountBlock1>();
        }
        return this.bodilyInjuryCoverage;
    }

    /**
     * Gets the value of the propertyDamageCoverage property.
     * 
     * @return
     *     possible object is
     *     {@link AmountBlock1 }
     *     
     */
    public AmountBlock1 getPropertyDamageCoverage() {
        return propertyDamageCoverage;
    }

    /**
     * Sets the value of the propertyDamageCoverage property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountBlock1 }
     *     
     */
    public void setPropertyDamageCoverage(AmountBlock1 value) {
        this.propertyDamageCoverage = value;
    }

}
