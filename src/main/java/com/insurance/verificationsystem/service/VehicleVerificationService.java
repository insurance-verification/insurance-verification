package com.insurance.verificationsystem.service;

import com.iicmva.coverageverification.*;
import com.insurance.verificationsystem.audit.AuditRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

public class VehicleVerificationService {

    private static final Logger logger = LoggerFactory.getLogger(VehicleVerificationService.class);

    private final VehicleValidationService vehicleValidationService;
    @Autowired
    private AuditRepository auditRepository;
    
    @Value("${verificationsystem.response.naic:}")
    private String naic;
    @Value("${verificationsystem.request.policy-regex:}")
    private String policyRegex;

    public VehicleVerificationService(VehicleValidationService vehicleValidationService) {
        this.vehicleValidationService = requireNonNull(vehicleValidationService);
    }

    public CoverageResponseDocument checkCoverage(CoverageRequest request) {
        logger.info("Start checking coverage");
        VehicleInfo vehicleInfo = toVehicleInfo(request);
        logger.info("Extracted vehicle info : " + vehicleInfo.toString());
        try {
            List<ValidationResult> results = this.vehicleValidationService.validate(vehicleInfo);
            auditRepository.save(vehicleInfo, results);
            return toCoverageResponse(request, results);
        } catch (Exception e) {
            logger.error("Error when checking coverage", e);
            return new CoverageResponseDocument();
        }
    }

    private CoverageResponseDocument toCoverageResponse(CoverageRequest request, List<ValidationResult> results) {
        CoverageResponseDocument response = createResponse();
        fillSameInfo(request, response);
        logger.info("Request validation results:" + results);
        WsdlVersion wsdlVersion = WsdlVersion.defineVersion(request.getPublicationVersion());
        List<String> errorCodes = results.stream()
                .map(wsdlVersion::getCode)
                .flatMap(o -> o.isPresent() ? Stream.of(o.get()) : Stream.empty())
                .limit(5)
                .collect(Collectors.toList());
        if(naic != null && !naic.isEmpty()){
            if(response.getDetail().getPolicyInformation().getOrganizationDetails()!=null){
                response.getDetail().getPolicyInformation().setOrganizationDetails(new OrganizationBlock4());
            }
            response.getDetail().getPolicyInformation().getOrganizationDetails().setNAIC(new PartyIdentifier18());
            response.getDetail().getPolicyInformation().getOrganizationDetails().getNAIC().setValue(naic);
        }
        else if(hasOrg(response.getDetail().getPolicyInformation())){
            response.getDetail().getPolicyInformation().getOrganizationDetails().setNAIC(null);;
        }
        
        response.getDetail().getPolicyInformation().setCoverageStatus(toStatus(errorCodes));
        return response;
    }

    private boolean hasOrg(CoveragePolicyResponseModule policyInformation) {
        return policyInformation != null && policyInformation.getCoverageStatus() != null
                && policyInformation.getOrganizationDetails() != null;
    }

    private VehicleInfo toVehicleInfo(CoverageRequest request) {
        VehicleInfo vehicleInfo = new VehicleInfo();
        CoverageRequest.Detail detail = request.getDetail();
        if(detail != null) {
            if(
                detail.getVehicleInformation() != null &&
                detail.getVehicleInformation().getVehicleDetails() != null &&
                detail.getVehicleInformation().getVehicleDetails().getVIN() != null
            ) {
                vehicleInfo.setVin(detail.getVehicleInformation().getVehicleDetails().getVIN().getValue());
            }
            if(detail.getPolicyInformation() != null && detail.getPolicyInformation().getPolicyDetails() != null) {
                DocumentDetailBlock3 policyDetails = detail.getPolicyInformation().getPolicyDetails();
                if(policyDetails.getPolicyKey() != null) {
                    vehicleInfo.setPolicyNumber(policyDetails.getPolicyKey().getValue());
                    if(policyRegex!=null && policyRegex.trim().length()>0){
                        Matcher matcher = Pattern.compile(policyRegex).matcher(vehicleInfo.getPolicyNumber());
                        if(matcher.matches()){
                            vehicleInfo.setPolicyNumber(matcher.group(1));
                        }
                    }
                }
                if(policyDetails.getVerificationDate() != null && policyDetails.getVerificationDate().getValue() != null) {
                    vehicleInfo.setVerificationDate(
                            policyDetails.getVerificationDate().getValue().toGregorianCalendar().toZonedDateTime().toLocalDateTime()
                    );
                }
            }
        }
        return vehicleInfo;
    }

    private StatusInformationBlock4 toStatus(List<String> errorCodes) {
        StatusInformationBlock4 status = new StatusInformationBlock4();
        status.setResponseDetails(new ParsedStatusComponent3());

        EventCode7 eventCode = new EventCode7();
        eventCode.setValue(errorCodes.isEmpty() ? EventCode7Content.CONFIRMED : EventCode7Content.UNCONFIRMED);

        status.getResponseDetails().setResponseCode(eventCode);
        for(String errorCode : errorCodes) {
            EventCode8 error = new EventCode8();
            error.setValue(errorCode);
            status.getResponseDetails().getUnconfirmedReasonCode().add(error);
        }
        return status;
    }

    private CoverageResponseDocument createResponse() {
        CoverageResponseDocument response = new CoverageResponseDocument();
        response.setDetail(new CoverageResponseDocument.Detail());
        response.getDetail().setPolicyInformation(new CoveragePolicyResponseModule());
        return response;
    }

    private void fillSameInfo(CoverageRequest request, CoverageResponseDocument response) {
        response.setPublicationDate(request.getPublicationDate());
        response.setPublicationVersion(request.getPublicationVersion());
        response.setRequestorInformation(request.getRequestorInformation());
        if(request.getDetail() != null) {
            CoveragePolicyResponseModule policyInformation = response.getDetail().getPolicyInformation();
            CoveragePolicyRequestModule requestPolicyModule = request.getDetail().getPolicyInformation();
            policyInformation.setOrganizationDetails(requestPolicyModule.getOrganizationDetails());
            policyInformation.setPolicyDetails(requestPolicyModule.getPolicyDetails());
        }
    }
}
