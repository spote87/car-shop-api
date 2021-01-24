# Elo Ranking System

This is web application implemented using Spring Boot. This application contains backend APIs for _Frank's car shop_.
scores.

## Functionality

This application exposes below REST endpoints.

**1. **GET : /warehouses****

    This endpoint returns list of warehouses with all the cars in it

    Response Structure looks like:

          [{
            "name": "Warehouse A",
            "location": {
            "lat": "39.12788",
            "long": "-2.71398"
          },
          "_id": 1,
          "cars": {
            "location": "Suid wing",
            "vehicles": [{
            "make": "Mitsubishi",
            "model": "RVR",
            "price": 22560.18,
            "licensed": false,
            "_id": 1,
            "date_added": "2018-05-24",
            "year_model": 1995 }]
            } 
          }]

**2. **GET: /warehouse/{warehouseId}/car/{carId}****

    This endpoint returns specified Car's data from specified warehouse

    Response Structure looks like:

        {
          "warehouseName": "Warehouse A",
          "warehouseId": 100,
          "carId": 101,
          "location": {
            "name": "West wing",
            "lat": "47.13111",
            "long": "-61.54801"
          },
          "make": "Volkswagen",
          "model": "Jetta III",
          "year_model": 1995,
          "price": 12947.52,
          "licensed": true,
          "date_added": "2018-09-18"
      }

## System Design

Application is built using Spring Boot and Java 8. Maven is used for building the application.

This application is designed by keeping layered architecture in mind where controller/presentation layer contains _REST_
endpoint. Service layers contains business logic whereas repository contains code interacting with a database.

This application used in memory(H2) database so data saved in databased will be lost everytime server is restarted.

Warehouses/Cars test data present in a file _src/main/resources/test-cars-data.json_ is loaded in database on server
startup.

## How to Run Application

1. Clone this repository by executing below command

        git clone https://github.com/spote87/car-shop-api.git

2. Go to directory where you have checked out code and run below commands

        mvn clean install

        mvn spring-boot:run
   Second command will launch application. Once application is started, you can access it using below URL:

        http://localhost:8080/carshopapi/

**Note**: If port 8080 is already being used on your machine, please change value of _**server.port**_ in _
src/main/resources/application.properties_ to something else and try again.

You can access above REST services like below

        http://localhost:8080/carshopapi/warehouses
                        
