CREATE TABLE vehicle (
   id INT NOT NULL,
   policy_number  VARCHAR(30) NOT NULL,
   effective_date TIMESTAMP NOT NULL,
   expire_date    TIMESTAMP NOT NULL,
   vin            VARCHAR(25) NOT NULL,
   removed        BOOLEAN DEFAULT FALSE,
   PRIMARY KEY(id)
);
