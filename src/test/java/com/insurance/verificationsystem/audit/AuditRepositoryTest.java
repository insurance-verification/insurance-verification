package com.insurance.verificationsystem.audit;

import com.insurance.verificationsystem.config.AuditConfig;
import com.insurance.verificationsystem.service.ValidationResult;
import com.insurance.verificationsystem.service.VehicleInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@JdbcTest
@RunWith(SpringRunner.class)
public class AuditRepositoryTest {

    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private AuditConfig auditConfig;

    private AuditRepository auditRepository;

    private final String AUDIT_REQUEST_TABLE_NAME = "AuditRequest";
    private final String AUDIT_RESPONSE_TABLE_NAME = "AuditResponse";

    private RowMapper<VehicleRequest> vehicleRequestMapper =
            new BeanPropertyRowMapper<>(VehicleRequest.class);
    private RowMapper<VehicleResponse> vehicleResponseMapper =
            new BeanPropertyRowMapper<>(VehicleResponse.class);

    @Before
    public void init() throws Exception {
        jdbcTemplate=auditConfig.auditJdbcTemplate();
        auditRepository = new AuditRepository(jdbcTemplate, AUDIT_REQUEST_TABLE_NAME, AUDIT_RESPONSE_TABLE_NAME);
    }

    @Test
    public void save() {
        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.setVin("v1");
        vehicleInfo.setPolicyNumber("p1");
        LocalDateTime verificationDate = LocalDateTime.of(2000, 1, 1, 1, 1, 1);
        vehicleInfo.setVerificationDate(verificationDate);

        auditRepository.save(vehicleInfo, Arrays.asList(
                new ValidationResult("o1", "n1"),
                new ValidationResult("o2", "n2")
        ));

        List<VehicleRequest> requests = jdbcTemplate.query("select * from " + AUDIT_REQUEST_TABLE_NAME, vehicleRequestMapper);
        VehicleRequest vehicleRequest = requests.get(0);
        assertNotNull(vehicleRequest.getId());
        assertNotNull(vehicleRequest.getVerificationDate());
        assertEquals("v1", vehicleRequest.getVin());
        assertEquals("p1", vehicleRequest.getPolicyNumber());
        assertEquals(verificationDate, vehicleRequest.getVerificationDate());

        List<VehicleResponse> responses = jdbcTemplate.query("select * from " + AUDIT_RESPONSE_TABLE_NAME, vehicleResponseMapper);
        assertEquals(2, responses.size());
        assertEquals(vehicleRequest.getId(), responses.get(0).getRequestId());
        assertEquals("n1", responses.get(0).getErrorCode());
        assertEquals(vehicleRequest.getId(), responses.get(1).getRequestId());
        assertEquals("n2", responses.get(1).getErrorCode());
    }

    public static class VehicleResponse {
        public int requestId;
        public String errorCode;

        public int getRequestId() {
            return requestId;
        }

        public void setRequestId(int requestId) {
            this.requestId = requestId;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }
    }

    public static class VehicleRequest {
        public int id;
        public String vin;
        public String policyNumber;
        public LocalDateTime verificationDate;
        public LocalDateTime requestDate;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getVin() {
            return vin;
        }

        public void setVin(String vin) {
            this.vin = vin;
        }

        public String getPolicyNumber() {
            return policyNumber;
        }

        public void setPolicyNumber(String policyNumber) {
            this.policyNumber = policyNumber;
        }

        public LocalDateTime getVerificationDate() {
            return verificationDate;
        }

        public void setVerificationDate(LocalDateTime verificationDate) {
            this.verificationDate = verificationDate;
        }

        public LocalDateTime getRequestDate() {
            return requestDate;
        }

        public void setRequestDate(LocalDateTime requestDate) {
            this.requestDate = requestDate;
        }
    }

}
