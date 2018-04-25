# Spring Boot Shipping System
**A Spring Boot MVC application that allows a user to manage ships, shipping companies and orders.**

*Author: Matthew Shiel*

*Student ID: G00338622*


## Original Problem Statement

> Write a Spring Boot MVC application that allows a user to manage Ships, Shipping Companies and Orders.
The application should be written in Spring Boot based on the skeleton application available on Moodle and should use the Spring MVC n-tier architecture – Controllers, Services, Repositories, Views, with the appropriate data/logic in each tier.


## Prerequisites 

*Assumes that Eclipse IDE For Java EE Developers, WAMP/MAMP and Spring Tools are installed*

*Eclipse can be downloaded at* **http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/oxygen3a**

*WAMP/MAMP can be downloaded at* **http://www.wampserver.com/en/#download-wrapper**

*Spring tools can be downloaded through Eclipse*

## How to Run The Program

**1. Run MySQL**
```bash
Open WAMP/MAMP and start MySQL
```

**2. Add the Shipping Database to MySQL**

```bash
Open your MySQL console and enter:

> DROP IF EXISTS shipping;

> CREATE DATABASE shipping;

> USE shipping;
```

**3. Clone/Download the Repository**
```bash
> git clone https://github.com/mattshiel/spring-boot-shipping-system.git
```
**4. Open the Project in Eclipse**

```bash
File -> Open Projects from File System -> [location of the project] -> Finish
```

**5. Run the Shipping System**

```bash
Run As -> Spring Boot App
```

**6. Open localhost and Use the Shipping System**

```bash
Choose a web broswer and open http://localhost:8080/
```

**Note:**
> If you receive an error about the MySQL server password, navigate to data.sql in the project and change the username and password to your -u and -p according to your MySQL setup.

## References
1. Mr. Gerard Harrison - Lecturer at GMIT
2. https://medium.com/@gustavo.ponce.ch/spring-boot-spring-mvc-spring-security-mysql-a5d8545d837d
3. https://www.youtube.com/watch?v=vgPkUVF862g
