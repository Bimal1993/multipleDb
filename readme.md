Example to connect two database in a single spring boot application

Based on two different databases

spring.datasource.jdbc-url=jdbc:h2:mem:testdb spring.datasource.username=user1 spring.datasource.password= spring.datasource.driverClassName=org.h2.Driver

employee.datasource.jdbc-url=jdbc:mysql://localhost:3306/test1 employee.datasource.username=root employee.datasource.password=bimal@123 #bar.datasource.driver-class-name=org.h2.Driver

spring.jpa.generate-ddl=true spring.jpa.hibernate.ddl-auto=update spring.jpa.show-sql=true


#open mysql datbase in console
C:\Users\User>cd \

C:\>cd "Program Files\MySQL\MySQL Server 8.0\bin"

C:\Program Files\MySQL\MySQL Server 8.0\bin>mysql -u root -p
Enter password: *********
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 1376
Server version: 8.0.21 MySQL Community Server - GPL

Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> show databases
    -> ;
