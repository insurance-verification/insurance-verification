
package com.iicmva.coverageverification;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.iicmva.coverageverification package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SubsiteAddressComponent1Apartment_QNAME = new QName("http://www.iicmva.com/CoverageVerification/", "Apartment");
    private final static QName _SubsiteAddressComponent1Building_QNAME = new QName("http://www.iicmva.com/CoverageVerification/", "Building");
    private final static QName _SubsiteAddressComponent1Department_QNAME = new QName("http://www.iicmva.com/CoverageVerification/", "Department");
    private final static QName _SubsiteAddressComponent1Floor_QNAME = new QName("http://www.iicmva.com/CoverageVerification/", "Floor");
    private final static QName _SubsiteAddressComponent1Room_QNAME = new QName("http://www.iicmva.com/CoverageVerification/", "Room");
    private final static QName _SubsiteAddressComponent1Suite_QNAME = new QName("http://www.iicmva.com/CoverageVerification/", "Suite");
    private final static QName _IndividualBlock3ParsedName_QNAME = new QName("http://www.iicmva.com/CoverageVerification/", "ParsedName");
    private final static QName _IndividualBlock3Name_QNAME = new QName("http://www.iicmva.com/CoverageVerification/", "Name");
    private final static QName _IndividualBlock3SocialSecurityNumber_QNAME = new QName("http://www.iicmva.com/CoverageVerification/", "SocialSecurityNumber");
    private final static QName _IndividualBlock3DriversLicense_QNAME = new QName("http://www.iicmva.com/CoverageVerification/", "DriversLicense");
    private final static QName _IndividualBlock3FEIN_QNAME = new QName("http://www.iicmva.com/CoverageVerification/", "FEIN");
    private final static QName _AddressBlock1StreetAddress_QNAME = new QName("http://www.iicmva.com/CoverageVerification/", "StreetAddress");
    private final static QName _AddressBlock1SubsiteAddress_QNAME = new QName("http://www.iicmva.com/CoverageVerification/", "SubsiteAddress");
    private final static QName _AddressBlock1City_QNAME = new QName("http://www.iicmva.com/CoverageVerification/", "City");
    private final static QName _AddressBlock1CountrySubdivision_QNAME = new QName("http://www.iicmva.com/CoverageVerification/", "CountrySubdivision");
    private final static QName _AddressBlock1PostalCode_QNAME = new QName("http://www.iicmva.com/CoverageVerification/", "PostalCode");
    private final static QName _AddressBlock1Country_QNAME = new QName("http://www.iicmva.com/CoverageVerification/", "Country");
    private final static QName _RequestorInformationModuleIndividual_QNAME = new QName("http://www.iicmva.com/CoverageVerification/", "Individual");
    private final static QName _RequestorInformationModuleOrganization_QNAME = new QName("http://www.iicmva.com/CoverageVerification/", "Organization");
    private final static QName _RequestorInformationModuleReasonDetails_QNAME = new QName("http://www.iicmva.com/CoverageVerification/", "ReasonDetails");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.iicmva.coverageverification
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CoverageRequest }
     * 
     */
    public CoverageRequest createCoverageRequest() {
        return new CoverageRequest();
    }

    /**
     * Create an instance of {@link CoverageResponseDocument }
     * 
     */
    public CoverageResponseDocument createCoverageResponseDocument() {
        return new CoverageResponseDocument();
    }

    /**
     * Create an instance of {@link RequestorInformationModule }
     * 
     */
    public RequestorInformationModule createRequestorInformationModule() {
        return new RequestorInformationModule();
    }

    /**
     * Create an instance of {@link CoverageRequest.Detail }
     * 
     */
    public CoverageRequest.Detail createCoverageRequestDetail() {
        return new CoverageRequest.Detail();
    }

    /**
     * Create an instance of {@link CoverageResponseDocument.Detail }
     * 
     */
    public CoverageResponseDocument.Detail createCoverageResponseDocumentDetail() {
        return new CoverageResponseDocument.Detail();
    }

    /**
     * Create an instance of {@link InsuredModule }
     * 
     */
    public InsuredModule createInsuredModule() {
        return new InsuredModule();
    }

    /**
     * Create an instance of {@link RiskInformationModule }
     * 
     */
    public RiskInformationModule createRiskInformationModule() {
        return new RiskInformationModule();
    }

    /**
     * Create an instance of {@link CoveragePolicyRequestModule }
     * 
     */
    public CoveragePolicyRequestModule createCoveragePolicyRequestModule() {
        return new CoveragePolicyRequestModule();
    }

    /**
     * Create an instance of {@link CoveragePolicyResponseModule }
     * 
     */
    public CoveragePolicyResponseModule createCoveragePolicyResponseModule() {
        return new CoveragePolicyResponseModule();
    }

    /**
     * Create an instance of {@link AmountBlock1 }
     * 
     */
    public AmountBlock1 createAmountBlock1() {
        return new AmountBlock1();
    }

    /**
     * Create an instance of {@link ResourceIdentificationBlock1 }
     * 
     */
    public ResourceIdentificationBlock1 createResourceIdentificationBlock1() {
        return new ResourceIdentificationBlock1();
    }

    /**
     * Create an instance of {@link StatusInformationBlock4 }
     * 
     */
    public StatusInformationBlock4 createStatusInformationBlock4() {
        return new StatusInformationBlock4();
    }

    /**
     * Create an instance of {@link DocumentDetailBlock2 }
     * 
     */
    public DocumentDetailBlock2 createDocumentDetailBlock2() {
        return new DocumentDetailBlock2();
    }

    /**
     * Create an instance of {@link DocumentDetailBlock3 }
     * 
     */
    public DocumentDetailBlock3 createDocumentDetailBlock3() {
        return new DocumentDetailBlock3();
    }

    /**
     * Create an instance of {@link AddressBlock1 }
     * 
     */
    public AddressBlock1 createAddressBlock1() {
        return new AddressBlock1();
    }

    /**
     * Create an instance of {@link IndividualBlock2 }
     * 
     */
    public IndividualBlock2 createIndividualBlock2() {
        return new IndividualBlock2();
    }

    /**
     * Create an instance of {@link IndividualBlock3 }
     * 
     */
    public IndividualBlock3 createIndividualBlock3() {
        return new IndividualBlock3();
    }

    /**
     * Create an instance of {@link OrganizationBlock3 }
     * 
     */
    public OrganizationBlock3 createOrganizationBlock3() {
        return new OrganizationBlock3();
    }

    /**
     * Create an instance of {@link OrganizationBlock4 }
     * 
     */
    public OrganizationBlock4 createOrganizationBlock4() {
        return new OrganizationBlock4();
    }

    /**
     * Create an instance of {@link ParsedStatusComponent3 }
     * 
     */
    public ParsedStatusComponent3 createParsedStatusComponent3() {
        return new ParsedStatusComponent3();
    }

    /**
     * Create an instance of {@link SubsiteAddressComponent1 }
     * 
     */
    public SubsiteAddressComponent1 createSubsiteAddressComponent1() {
        return new SubsiteAddressComponent1();
    }

    /**
     * Create an instance of {@link IndividualNameComponent2 }
     * 
     */
    public IndividualNameComponent2 createIndividualNameComponent2() {
        return new IndividualNameComponent2();
    }

    /**
     * Create an instance of {@link Amount1 }
     * 
     */
    public Amount1 createAmount1() {
        return new Amount1();
    }

    /**
     * Create an instance of {@link LocationIdentifier1 }
     * 
     */
    public LocationIdentifier1 createLocationIdentifier1() {
        return new LocationIdentifier1();
    }

    /**
     * Create an instance of {@link LocationText1 }
     * 
     */
    public LocationText1 createLocationText1() {
        return new LocationText1();
    }

    /**
     * Create an instance of {@link LocationText2 }
     * 
     */
    public LocationText2 createLocationText2() {
        return new LocationText2();
    }

    /**
     * Create an instance of {@link LocationText7 }
     * 
     */
    public LocationText7 createLocationText7() {
        return new LocationText7();
    }

    /**
     * Create an instance of {@link LocationText9 }
     * 
     */
    public LocationText9 createLocationText9() {
        return new LocationText9();
    }

    /**
     * Create an instance of {@link LocationCode2 }
     * 
     */
    public LocationCode2 createLocationCode2() {
        return new LocationCode2();
    }

    /**
     * Create an instance of {@link LocationCode3 }
     * 
     */
    public LocationCode3 createLocationCode3() {
        return new LocationCode3();
    }

    /**
     * Create an instance of {@link NameText1 }
     * 
     */
    public NameText1 createNameText1() {
        return new NameText1();
    }

    /**
     * Create an instance of {@link NameText2 }
     * 
     */
    public NameText2 createNameText2() {
        return new NameText2();
    }

    /**
     * Create an instance of {@link NameText4 }
     * 
     */
    public NameText4 createNameText4() {
        return new NameText4();
    }

    /**
     * Create an instance of {@link NameText5 }
     * 
     */
    public NameText5 createNameText5() {
        return new NameText5();
    }

    /**
     * Create an instance of {@link NameText6 }
     * 
     */
    public NameText6 createNameText6() {
        return new NameText6();
    }

    /**
     * Create an instance of {@link PartyIdentifier18 }
     * 
     */
    public PartyIdentifier18 createPartyIdentifier18() {
        return new PartyIdentifier18();
    }

    /**
     * Create an instance of {@link PartyIdentifier8 }
     * 
     */
    public PartyIdentifier8 createPartyIdentifier8() {
        return new PartyIdentifier8();
    }

    /**
     * Create an instance of {@link PartyIdentifier9 }
     * 
     */
    public PartyIdentifier9 createPartyIdentifier9() {
        return new PartyIdentifier9();
    }

    /**
     * Create an instance of {@link DateTime1 }
     * 
     */
    public DateTime1 createDateTime1() {
        return new DateTime1();
    }

    /**
     * Create an instance of {@link ResourceCode9 }
     * 
     */
    public ResourceCode9 createResourceCode9() {
        return new ResourceCode9();
    }

    /**
     * Create an instance of {@link ResourceIdentifier11 }
     * 
     */
    public ResourceIdentifier11 createResourceIdentifier11() {
        return new ResourceIdentifier11();
    }

    /**
     * Create an instance of {@link ResourceIdentifier12 }
     * 
     */
    public ResourceIdentifier12 createResourceIdentifier12() {
        return new ResourceIdentifier12();
    }

    /**
     * Create an instance of {@link ResourceIdentifier14 }
     * 
     */
    public ResourceIdentifier14 createResourceIdentifier14() {
        return new ResourceIdentifier14();
    }

    /**
     * Create an instance of {@link ReasonCode1 }
     * 
     */
    public ReasonCode1 createReasonCode1() {
        return new ReasonCode1();
    }

    /**
     * Create an instance of {@link EventCode7 }
     * 
     */
    public EventCode7 createEventCode7() {
        return new EventCode7();
    }

    /**
     * Create an instance of {@link EventCode8 }
     * 
     */
    public EventCode8 createEventCode8() {
        return new EventCode8();
    }

    /**
     * Create an instance of {@link DateTimeText2 }
     * 
     */
    public DateTimeText2 createDateTimeText2() {
        return new DateTimeText2();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationText2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iicmva.com/CoverageVerification/", name = "Apartment", scope = SubsiteAddressComponent1 .class)
    public JAXBElement<LocationText2> createSubsiteAddressComponent1Apartment(LocationText2 value) {
        return new JAXBElement<LocationText2>(_SubsiteAddressComponent1Apartment_QNAME, LocationText2 .class, SubsiteAddressComponent1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationText7 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iicmva.com/CoverageVerification/", name = "Building", scope = SubsiteAddressComponent1 .class)
    public JAXBElement<LocationText7> createSubsiteAddressComponent1Building(LocationText7 value) {
        return new JAXBElement<LocationText7>(_SubsiteAddressComponent1Building_QNAME, LocationText7 .class, SubsiteAddressComponent1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationText7 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iicmva.com/CoverageVerification/", name = "Department", scope = SubsiteAddressComponent1 .class)
    public JAXBElement<LocationText7> createSubsiteAddressComponent1Department(LocationText7 value) {
        return new JAXBElement<LocationText7>(_SubsiteAddressComponent1Department_QNAME, LocationText7 .class, SubsiteAddressComponent1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationText2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iicmva.com/CoverageVerification/", name = "Floor", scope = SubsiteAddressComponent1 .class)
    public JAXBElement<LocationText2> createSubsiteAddressComponent1Floor(LocationText2 value) {
        return new JAXBElement<LocationText2>(_SubsiteAddressComponent1Floor_QNAME, LocationText2 .class, SubsiteAddressComponent1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationText2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iicmva.com/CoverageVerification/", name = "Room", scope = SubsiteAddressComponent1 .class)
    public JAXBElement<LocationText2> createSubsiteAddressComponent1Room(LocationText2 value) {
        return new JAXBElement<LocationText2>(_SubsiteAddressComponent1Room_QNAME, LocationText2 .class, SubsiteAddressComponent1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationText2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iicmva.com/CoverageVerification/", name = "Suite", scope = SubsiteAddressComponent1 .class)
    public JAXBElement<LocationText2> createSubsiteAddressComponent1Suite(LocationText2 value) {
        return new JAXBElement<LocationText2>(_SubsiteAddressComponent1Suite_QNAME, LocationText2 .class, SubsiteAddressComponent1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndividualNameComponent2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iicmva.com/CoverageVerification/", name = "ParsedName", scope = IndividualBlock3 .class)
    public JAXBElement<IndividualNameComponent2> createIndividualBlock3ParsedName(IndividualNameComponent2 value) {
        return new JAXBElement<IndividualNameComponent2>(_IndividualBlock3ParsedName_QNAME, IndividualNameComponent2 .class, IndividualBlock3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NameText1 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iicmva.com/CoverageVerification/", name = "Name", scope = IndividualBlock3 .class)
    public JAXBElement<NameText1> createIndividualBlock3Name(NameText1 value) {
        return new JAXBElement<NameText1>(_IndividualBlock3Name_QNAME, NameText1 .class, IndividualBlock3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PartyIdentifier9 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iicmva.com/CoverageVerification/", name = "SocialSecurityNumber", scope = IndividualBlock3 .class)
    public JAXBElement<PartyIdentifier9> createIndividualBlock3SocialSecurityNumber(PartyIdentifier9 value) {
        return new JAXBElement<PartyIdentifier9>(_IndividualBlock3SocialSecurityNumber_QNAME, PartyIdentifier9 .class, IndividualBlock3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PartyIdentifier8 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iicmva.com/CoverageVerification/", name = "DriversLicense", scope = IndividualBlock3 .class)
    public JAXBElement<PartyIdentifier8> createIndividualBlock3DriversLicense(PartyIdentifier8 value) {
        return new JAXBElement<PartyIdentifier8>(_IndividualBlock3DriversLicense_QNAME, PartyIdentifier8 .class, IndividualBlock3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PartyIdentifier8 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iicmva.com/CoverageVerification/", name = "FEIN", scope = IndividualBlock3 .class)
    public JAXBElement<PartyIdentifier8> createIndividualBlock3FEIN(PartyIdentifier8 value) {
        return new JAXBElement<PartyIdentifier8>(_IndividualBlock3FEIN_QNAME, PartyIdentifier8 .class, IndividualBlock3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationText9 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iicmva.com/CoverageVerification/", name = "StreetAddress", scope = AddressBlock1 .class)
    public JAXBElement<LocationText9> createAddressBlock1StreetAddress(LocationText9 value) {
        return new JAXBElement<LocationText9>(_AddressBlock1StreetAddress_QNAME, LocationText9 .class, AddressBlock1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubsiteAddressComponent1 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iicmva.com/CoverageVerification/", name = "SubsiteAddress", scope = AddressBlock1 .class)
    public JAXBElement<SubsiteAddressComponent1> createAddressBlock1SubsiteAddress(SubsiteAddressComponent1 value) {
        return new JAXBElement<SubsiteAddressComponent1>(_AddressBlock1SubsiteAddress_QNAME, SubsiteAddressComponent1 .class, AddressBlock1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationText1 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iicmva.com/CoverageVerification/", name = "City", scope = AddressBlock1 .class)
    public JAXBElement<LocationText1> createAddressBlock1City(LocationText1 value) {
        return new JAXBElement<LocationText1>(_AddressBlock1City_QNAME, LocationText1 .class, AddressBlock1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationCode2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iicmva.com/CoverageVerification/", name = "CountrySubdivision", scope = AddressBlock1 .class)
    public JAXBElement<LocationCode2> createAddressBlock1CountrySubdivision(LocationCode2 value) {
        return new JAXBElement<LocationCode2>(_AddressBlock1CountrySubdivision_QNAME, LocationCode2 .class, AddressBlock1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationIdentifier1 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iicmva.com/CoverageVerification/", name = "PostalCode", scope = AddressBlock1 .class)
    public JAXBElement<LocationIdentifier1> createAddressBlock1PostalCode(LocationIdentifier1 value) {
        return new JAXBElement<LocationIdentifier1>(_AddressBlock1PostalCode_QNAME, LocationIdentifier1 .class, AddressBlock1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationCode3 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iicmva.com/CoverageVerification/", name = "Country", scope = AddressBlock1 .class)
    public JAXBElement<LocationCode3> createAddressBlock1Country(LocationCode3 value) {
        return new JAXBElement<LocationCode3>(_AddressBlock1Country_QNAME, LocationCode3 .class, AddressBlock1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndividualBlock2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iicmva.com/CoverageVerification/", name = "Individual", scope = RequestorInformationModule.class)
    public JAXBElement<IndividualBlock2> createRequestorInformationModuleIndividual(IndividualBlock2 value) {
        return new JAXBElement<IndividualBlock2>(_RequestorInformationModuleIndividual_QNAME, IndividualBlock2 .class, RequestorInformationModule.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationBlock3 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iicmva.com/CoverageVerification/", name = "Organization", scope = RequestorInformationModule.class)
    public JAXBElement<OrganizationBlock3> createRequestorInformationModuleOrganization(OrganizationBlock3 value) {
        return new JAXBElement<OrganizationBlock3>(_RequestorInformationModuleOrganization_QNAME, OrganizationBlock3 .class, RequestorInformationModule.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentDetailBlock2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.iicmva.com/CoverageVerification/", name = "ReasonDetails", scope = RequestorInformationModule.class)
    public JAXBElement<DocumentDetailBlock2> createRequestorInformationModuleReasonDetails(DocumentDetailBlock2 value) {
        return new JAXBElement<DocumentDetailBlock2>(_RequestorInformationModuleReasonDetails_QNAME, DocumentDetailBlock2 .class, RequestorInformationModule.class, value);
    }

}
