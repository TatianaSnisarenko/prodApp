Product Application

Used technologies:
Java, SQL, Spring (MVC, Data, Security, Spring Boot), JSP или (HTML и CSS и JS или React Angular), Maven, Tomcat, Git

This web application allows:
1. Perform user registration
2. Perform user authorization
3. Perform CRUD operations on the following objects:

==========================

Product:
UUID;
String name;
BigDecimal price;
Producer of the product;

==========================

Producer:
UUID;
String name;
List of products;

==========================

Role
UUID;
String name;

==========================

user
UUID;
String email address;
String password;
String firstName;
String lastName;
List of roles;

==========================

User roles:

1. Admin - has the ability to perform all CRUD operations
2. User - has read-only access

The database stores data about producers and products.
Each product has one producer, and each producer has a list of products.

Pages:

1. Producers (list of manufacturers the ability to create new, edit and delete created producers)
2. Products (list of products, the ability to create new, edit and delete created products)
3. Users (a list of all users of the application, the ability to create new, edit and delete created users) - ONLY for ADMIN (and reading and editing)

==========================

Instructions for starting application locally:

Preconditions:
-IDE
-Postgres DB

- clone repository
- open project in your IDE
- start db
- run all ddl.sql and dml.sql
- configure application.poperties acoording to your db configurations
- start the application
- use http://localhost:8085/ to reach the application
- use admin user credentials to reach all the functionality:
login: super@gmail.com
password:  password