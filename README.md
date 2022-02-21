Swagger UI : 
      
      http://localhost:8080/swagger-ui/
      
Database migration Scripts: 

    resources/db/migration 
    To add new migration script create sql file which begins V{number}__{name}.sql for example V2__insertPayment.sql
    
It startes on :8080 port.

Hibernate will create and update existing tables, is you want to change this behaviour change in application.properties file spring.flyway.enabled=true


For database please change this url : 
                  spring.datasource.url=jdbc:mysql://localhost:3306/test
                  spring.datasource.username=
                  spring.datasource.password=
