#Core banking microservice
This project is a Spring boot based core banking which exposes the REST endpoint /retainBanking/getAccountBalance
The API can only be accsessed with the below valid stuff:
* A valid Jwt Token in the header. This Jwt token can be created by running the authentication microservice
* The username corresponding to the Jwt token


### Dependencies

* Java 8 should be installed and available in the system. JAVA_HOME environment variable should be set and pointing to the location of Java 8.
* Maven should be installed in the system and set in PATH.
* A database like MySQL should be installed and accessible in the system.
* Also a table named **BankingAccount** should be created in the database (assuming that Banking User has been already created and populated).Below is a DDL and DML to create and populate the table:     

          DDL:   
          CREATE TABLE BankingAccount (
            id BIGINT AUTO_INCREMENT PRIMARY KEY,
            accountId BIGINT,
            accountType varchar(100),
            accountBalance FLOAT(10,2)
          );
          
          DML:    
          Insert into BankingAccount(accountId, accountType, accountBalance) values(10560, 'SAVINGS', 12567.75);


### Compiling and packaging

 `mvn clean package -DskipTests `

### Running program

The below command runs the program            

`mvn spring-boot:run" `
