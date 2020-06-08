# ServerIndexing_springBoot
ServerIndexing is a project created over Stack springBoot and Spring data MongoDB. The projects provides with multiple Rest API created by 
Spring Boot Web Pack. The project provides all the basic CRUD operations to mongoDB database with user accessible REST APIs. It also provides
additional features like auto increment and muliple addition, deletion, updation over the database with one request.It also provides an
Customized Exception Response for some operations which could be modified as per the need.

### Primary Goals:
1. Create a REST APIs using Spring Boot.
2. Create a connection of Spring Boot with mondoDB for CRUD applications with Spring Data mongoDB.
3. Create Customized Exception Handling for some operations for providing specific Exception handling.

## Installation
- The [reference documentation](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/html/) includes detailed installation instructions as well as a comprehensive getting started guide for Spring Boot.
- The [reference documentation](https://spring.io/guides/gs/accessing-data-mongodb/) includes detailed instructions for mongoDB operations with Spring Boot and Spring Data MongoDB.
- Install MongoDB on your laptop with [mongoDB installation](https://docs.mongodb.com/manual/tutorial) according to your Operating System.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.
1. Git clone the reposity with command or fork it to you repository and git clone to that repository:
```
  git clone https://github.com/vardhmanhundia/ServerIndexing_springBot.git
```
2. Open the installed file on your favourite IDE. I used [Intellij IDEA](https://www.jetbrains.com/idea/download/)
3. Install MongoDB on your laptop with [mongoDB installation](https://docs.mongodb.com/manual/tutorial) according to your Operating System.
4. Create a Directory at a place and add empty data directory inside the Directory You Created.
5. Open the terminal or CMD(windows) and open the root of the created directory.
6. Initialize the mongoDB database with this folder which will initiate the mongoDB database at default address 127.0.0.1
```
  mongod --dbpath=data --bind_ip 127.0.0.1
```
7. Create a database name **ServerDB** using mongoDB cli or [MongoDB Compass Community](https://www.mongodb.com/products/compass)
8. Run the Spring Boot Server and you would get output as below
![ServerRunning](../assets/serverRunning.png?raw=true)
9. Test the REST APIs using [Postman](https://www.postman.com/downloads/). I have provided an API Collection for all the operations for postman with [Operations](https://www.getpostman.com/collections/bd2d2e8e643ef98aaf35)
![Postman Request Example](../assets/postmanRequest.png?raw=true)

## Further Versions
Please CheckOut the updated versions for this project
- [SwaggUI documentation](https://github.com/vardhmanhundia/Swaggi_ServerIndex)
- [Server Index Dockerized](https://github.com/vardhmanhundia/ServerIndex_Dockerized)
- [Server_Index React App](https://github.com/vardhmanhundia/ServerIndexing_ReactApp)
