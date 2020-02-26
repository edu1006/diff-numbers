# Diff numbersspowered by Spring Boot

This project is a simple REST application to manager diference list of numbers (left, right).

The application has three endpoints:
	
    POST at /v1/diff/{id}/left  - which should save a new number for post with passed {id} in left list
    POST at /v1/diff/{id}/right - which should save a new number for post with passed {id} in right list
    GET  at /v1/diff/{id}       - which should return all comments for a list with passed {id}

You can see all details about endpoints here: 

http://localhost:8080/swagger-ui.html

All endpoints are created in `DiffControoller`. 
There is a service class `DiffService` that implemented businnes rules. 
There are some tests that test this solution.
For integration test, there is a class: `DiffControollerTest`. 
For unit test, there is a class: `DiffServiceTest`. 
For each method, there is a javadoc commented that describesbehavior.

This application needs: 

ºJDK 1.8 or later
ºMaven 3.2+

To compile and created a jar file: 

use the command: nvn clean install
to run it: java -jar target/diff-number-service.jar 

You can use docker to run it.  

To Containerize it using docker:


To build: 
$ docker build -t diff/diff-number .

To run: 
$ docker run -p 8080:8080 -t diff/diff-number

To stop: 
$ docker stop [CONTAINER_ID]

To see CONTAINER_ID: 
$ docker ps

To remove: 
$ docker rm [CONTAINER_ID]


To Containerize it using docker-compose:

To run: 
$ docker-compose-up
