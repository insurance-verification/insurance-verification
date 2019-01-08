package com.insurance.verificationsystem.ws;

import com.iicmva.coverageverification.CoverageRequest;
import com.iicmva.coverageverification.CoverageResponseDocument;
import com.insurance.verificationsystem.service.VehicleVerificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

import static java.util.Objects.requireNonNull;

@Endpoint
public class VehicleVerificationEndpoint {

    private static final Logger logger = LoggerFactory.getLogger(VehicleVerificationEndpoint.class);

    private static JAXBContext jaxbContext;

    static {
        try {
            jaxbContext = JAXBContext.newInstance(CoverageRequest.class, CoverageResponseDocument.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private final VehicleVerificationService vehicleVerificationService;

    public VehicleVerificationEndpoint(VehicleVerificationService vehicleVerificationService) {
        this.vehicleVerificationService = requireNonNull(vehicleVerificationService);
    }

    @PayloadRoot(namespace = "http://www.iicmva.com/CoverageVerification/", localPart = "CoverageRequest")
    @ResponsePayload
    public CoverageResponseDocument checkCoverage(@RequestPayload CoverageRequest request) {
        logger.info("Request received: " + toString(request));
        CoverageResponseDocument response = this.vehicleVerificationService.checkCoverage(request);
        logger.info("Response sent: " + toString(response));
        return response;
    }

    private static String toString(Object o) {
        try {
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(o, sw);
            return sw.toString();
        } catch (Exception e) {
            return "Can't write to string " + o.getClass().toString();
        }
    }

}
