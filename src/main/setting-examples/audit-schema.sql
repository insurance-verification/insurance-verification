CREATE TABLE auditrequest (
   id INT auto_increment NOT NULL,
   policy_number        VARCHAR(30),
   verification_date    TIMESTAMP,
   request_date         TIMESTAMP NOT NULL,
   vin                  VARCHAR(25),
   PRIMARY KEY(id)
);

CREATE TABLE auditresponse (
   request_id INT NOT NULL,
   error_code VARCHAR(10),

   foreign key (request_id) references auditrequest(id),

   PRIMARY KEY(request_id, error_code)
);