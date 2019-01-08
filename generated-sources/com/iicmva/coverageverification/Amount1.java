
package com.iicmva.coverageverification;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * A monetary amount. | The sum of dollars and cents that will be paid in a loss.
 * 
 * <p>Java class for Amount_1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Amount_1"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.iicmva.com/CoverageVerification/&gt;Amount_1_Content"&gt;
 *       &lt;attribute name="CurrencyIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="CurrencyCodeListVersionIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Amount_1", propOrder = {
    "value"
})
public class Amount1 {

    @XmlValue
    protected BigDecimal value;
    @XmlAttribute(name = "CurrencyIdentifier")
    protected String currencyIdentifier;
    @XmlAttribute(name = "CurrencyCodeListVersionIdentifier")
    protected String currencyCodeListVersionIdentifier;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * Gets the value of the currencyIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyIdentifier() {
        return currencyIdentifier;
    }

    /**
     * Sets the value of the currencyIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyIdentifier(String value) {
        this.currencyIdentifier = value;
    }

    /**
     * Gets the value of the currencyCodeListVersionIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCodeListVersionIdentifier() {
        return currencyCodeListVersionIdentifier;
    }

    /**
     * Sets the value of the currencyCodeListVersionIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCodeListVersionIdentifier(String value) {
        this.currencyCodeListVersionIdentifier = value;
    }

}
