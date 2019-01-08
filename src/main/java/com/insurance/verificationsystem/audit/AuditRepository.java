package com.insurance.verificationsystem.audit;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;

import com.insurance.verificationsystem.service.ValidationResult;
import com.insurance.verificationsystem.service.VehicleInfo;

public class AuditRepository {

    private static final Logger logger = LoggerFactory.getLogger(AuditRepository.class);

    private final SimpleJdbcInsertOperations jdbcInsertRequest;
    private final SimpleJdbcInsertOperations jdbcInsertResult;
    JdbcTemplate auditJdbcTemplate;
    String auditRequestTableName;
    String auditResponseTableName;

    public AuditRepository(@Qualifier("AuditSource") final JdbcTemplate auditJdbcTemplate,
            final String auditRequestTableName, final String auditResponseTableName) {
        jdbcInsertRequest = new SimpleJdbcInsert(auditJdbcTemplate).includeSynonymsForTableColumnMetaData()
                .withTableName(auditRequestTableName).usingGeneratedKeyColumns("id");
        jdbcInsertResult = new SimpleJdbcInsert(auditJdbcTemplate).includeSynonymsForTableColumnMetaData()
                .withTableName(auditResponseTableName);
        this.auditJdbcTemplate = auditJdbcTemplate;
        this.auditRequestTableName = auditRequestTableName;
        this.auditResponseTableName = auditResponseTableName;
    }

    public void save(final VehicleInfo request, final List<ValidationResult> results) {
        try {
            doSave(request, results);
        } catch (final Exception e) {
            logger.error("Error when saving audit.", e);
        }
    }

    private void doSave(final VehicleInfo request, final List<ValidationResult> results) throws SQLException {

        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("vin", request.getVin());
        parameters.put("policy_number", request.getPolicyNumber());
        parameters.put("verification_date", request.getVerificationDate());
        parameters.put("request_date", LocalDateTime.now());

        final Number id = jdbcInsertRequest.executeAndReturnKey(parameters);

        results.stream().map(ValidationResult::getNewCode).filter(Optional::isPresent).map(Optional::get).forEach(r -> {
            final Map<String, Object> p = new HashMap<>();
            p.put("request_id", id.longValue());
            p.put("error_code", r);
            jdbcInsertResult.execute(p);
        });
        if(results.isEmpty()){
            final Map<String, Object> p = new HashMap<>();
            p.put("request_id", id.longValue());
            p.put("error_code", "Confirmed");
            jdbcInsertResult.execute(p);
            
        }
        
    }

}
