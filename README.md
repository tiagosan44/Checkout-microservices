# Checkout-microservices

Checkout-microservices is a checkout simulation with microservices approach. This is made up of 3 microservices bill-services, 
logistic-services and checkout-service, each of them runs in indepedent docker containers.

## Build

After the code is dowloaded is necesary to build all the projects. For bill-service and logistic-service get into the path of each project and execute the command below:

```bash
mvn package
```
For chekcout service get into the project path aswell and execute the command below:

```bash
gradlew build 
```

## Run

For run the application just go to main path path and execute:

```bash
docker-compose up
```

## Usage

This application expose his main endpoint at http://localhost:9000/api/orders with the payload below:

```bash
{
    "id": 1234,
    "date": "22/06/2020",
    "direction": "Crr 30 av junin",
    "products": [
        {
            "id": 546,
            "quantity": 1,
            "cost": 100
        },
        {
            "id": 54,
            "quantity": 1,
            "cost": 200
        },
        {
            "id": 675,
            "quantity": 1,
            "cost": 300
        }
    ]
}

```
To see more information about each service you could go to each application swagger console:

```bash
 bill --> http://localhost:7000/swagger-ui.html
 logistic --> http://localhost:8000/swagger-ui.html
 checkout --> http://localhost:9000/swagger-ui.html
```

## Frameworks / librarys

### Maven 

Is useful tool for manage and build projects, I used it to build bill-service and logistic-service.

### Gradle

Is a build automation system that I used for manage checkout-service dependencies, it's a little bit more readeable than maven.

### Java Bean validation

It's a framework that allows to use annotations to validate bean data, I used it to validate request and responses data.

### Swagger

It is a tool to document apis. It is ideal for show how each API could be use. I use it to show the APIs of all services.

### Lombok

Project lombok is a library that helps to have cleaner code because it saves us from writing repetitive pieces of code like getters, setters and constructors. I used it to have shorter and cleaner classes.

### H2

It is relational database that can be embedded in Java applications. It was useful to save orders and products without a database server.
