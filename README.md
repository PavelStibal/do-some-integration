# Do some integration
This repository implements the specification in [cra_interview_task_apache_camel.md](https://github.com/PavelStibal/do-some-integration/blob/master/cra_interview_task_apache_camel.md)

### But in short, what is it supposed to do?
This is a maven project with two modules.
The first one is called **IntegrationService**. This module/service receives a message from a client and then maps the message to a CommonModel. The CommonModel is sent to the messageBroker, where the Consumer receives message and again the message is mapped to the CommonModel. 
If the CommonModel sets the operation to PostAccount, the message is sent to the second module/service, which is called **BillingService**. The message is then written out in the BillingService.

## Build project
This is a maven project, the project can be easily built with below command.
```
mvn clean install
```

## Run service
When the project is built. Both services can be started. 

**Attention! services have to run separately.**

```
java -jar integration-service/target/integration-service-0.1.0-SNAPSHOT.jar
java -jar "Billing service/target/billing-service-0.1.0-SNAPSHOT.jar"
```

### Test/Call Services:
The services can be called after being started. For example using postman or command line.

Commands for **IntegrationService**:
```
curl --location 'http://localhost:8080/CRMEvent/Account' --header 'Content-Type: application/json' --data '{
    "id": 12345,
    "firstname": "John",
    "lastname": "Doe",
    "updatedAt": "2023-02-14 10:38:00"
}'
```

Commands for **BillingService**:
```
curl --location 'http://localhost:9090/BillingService/BillingAccount' --header 'Content-Type: application/json' --data '{
    "id": 12345,
    "name": "John Doe",
    "lastUpdate": "2023-02-14"
}'
```