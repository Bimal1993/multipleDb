# multipleDb
Example to connect two database in a single spring boot application

Based on two different databases

spring.datasource.jdbc-url=jdbc:h2:mem:testdb
spring.datasource.username=user1
spring.datasource.password=
spring.datasource.driverClassName=org.h2.Driver


employee.datasource.jdbc-url=jdbc:mysql://localhost:3306/test1
employee.datasource.username=root
employee.datasource.password=bimal@123
#bar.datasource.driver-class-name=org.h2.Driver

spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
