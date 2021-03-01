## Cinema Ticket Service

This project was developed according to Solid principles using N-layer architecture with authorization and authentication included.
The following layers were created **DB layer,** **DAO layer,** **Service layer,** **Controllers layer.**

On the following diagram the relations between the different enteties is represented.

![img](https://user-images.githubusercontent.com/74858422/109378729-8d614600-78dd-11eb-9b1f-9528a95e77b6.png)

**Brief description of the app functions and roles of users:**

User is allowed to:
- Register himself in the app
- Log in to the app
- View available movies, movie sessions and cinema halls
- Add tickets into the shopping cart
- Complete his order
- View the orders history

Admin has access to POST, GET, PUT and DELETE methods for almost all endpoints, except user-exclusive endpoints (/shopping_cart and /orders)

**Technologies used:**
- Java
- Spring Core
- Spring MVC 
- Spring Security
- Hibernate
- Jackson
- Tomcat

**To run the application:**

- Install JDK (https://www.oracle.com/java/technologies/javase-downloads.html)
- Download and install servlet container (Tomcat)
- Download and install Database (MySQL) and set up the connection to DB in db.properties file
- There are 2 user roles - "USER" and "ADMIN". To log in as admin use "admin" as and login "admin" as password
- To test the application suggest using Postman or other API-testing applications

### written by Andrii Bardin
