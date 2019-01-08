CREATE TABLE vehicle (
   id INT NOT NULL,
   policy_number  VARCHAR(30) NOT NULL,
   effective_date TIMESTAMP NOT NULL,
   expire_date    TIMESTAMP NOT NULL,
   vin            VARCHAR(25) NOT NULL,
   removed        BOOLEAN DEFAULT FALSE,
   PRIMARY KEY(id)
);
/*
CREATE TABLE IVS_AuditRequest (
   id INT auto_increment NOT NULL,
   policy_number        VARCHAR(30),
   verification_date    TIMESTAMP,
   request_date         TIMESTAMP NOT NULL,
   vin                  VARCHAR(25),
   PRIMARY KEY(id)
);

CREATE TABLE IVS_AuditResponse(
   request_id INT NOT NULL,
   error_code VARCHAR(10),

   foreign key (request_id) references IVS_AuditRequest(id),

   PRIMARY KEY(request_id, error_code)
);*/