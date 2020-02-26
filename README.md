# Diff numbers

This project is a simple REST application to manager two list of numbers (left, right).

The application has three endpoints:
	
    POST at /v1/diff/{id}/left  - which should save a new number for post with passed {id} in left list
    POST at /v1/diff/{id}/right - which should save a new number for post with passed {id} in right list
    GET  at /v1/diff/{id}       - which should return all for a list with passed {id}
    DELETE  at improve/add/extend/left/{id}  - should pull id from left list.
    DELETE  at improve/add/extend/right/{id} - should pull id from right list 

You can see all details about endpoints here: 

http://localhost:8080/swagger-ui.html

All endpoints was create in `DiffControoller`. 
There is a service class `DiffService` that implement businnes rules. 
There are some tests that test this solution.
For integration test, there is a class: `DiffControollerTest`. 
For unit test, there is a class: `DiffServiceTest`. 
For each method, there is a javadoc comment that describes behavior.

This application needs: 

ºJDK 1.8 or later <br /> 
ºMaven 3.2+

To compile and created a jar file: 
<br />
use the command:
<br />
mvn clean install
to run it: 
<br />
java -jar target/diff-number-service.jar 

You can also use docker to run it.  

To Containerize it using docker (you must have docker in you environment):


To build: 
$ docker build -t diff/diff-number .

To run: 
$ docker run -p 8080:8080 -t diff/diff-number


To see CONTAINER_ID: 
$ docker ps

To stop: 
$ docker stop [CONTAINER_ID]

To remove: 
$ docker rm [CONTAINER_ID]


To Containerize it using docker-compose:

To run: 
$ docker-compose-up
