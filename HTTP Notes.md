#HTTP and Web Servers
- high description of internet
	- internet is basically computers messaging each other
	- primary way that computers message each other is via HTTP
		- Hyper Text Transfer Protocol

###HTTP
- request and response messaging system
- make a request and get a response
- This is 100% true

###Web Server
- Any computer that can handle HTTP requests
- Can write them in any language
	- Java, GO, Rust, Node.js, python

###Javalin
- Java dependency for creating web servers
- Similar to Express and Node.js
- Event driven.
	- Each http request is an event which triggers a lambda function in response
	- 

###The problem
- You have an internet full of webservers written in a dozen programming languages
- You want to make sure that they can all communicate with each other
- Every programming language is going to have different data types
	- Custom classes
	- only number type, int, double, float, signed, unsigned, etc

###The solution
- Universal format that any programming language can understand
- Strings are a data type found in essentially every single programming language
- Strings needed a universal format that any programming language could parse int it's own objects
	- It is impossible for a Java byte code object in the JVM to be correctly interpreted by Python.
- JSON (JavaScript Object Notation)
	- De-facto string format for sending information on the web
	- Based on JavaScript objects 
	- IT IS JUST A FORMATTED STRING
	```
	name = Tom
	age = 19
	profession = student
	=>  
	JSON, key value pairs
	{"name":"Tom", "age":19, "profession":"student"}
	```
	- 

##REST
- REpresentational State Transfer
- Type of Web Server API
	- Application program interface
- Theoretically a web server could respond http requests in an any way it wants
	- Return whatever you want
	- not a good idea
- RESTful web server/service
	- API that follows a specific convention and standards
	- Standardizes how we can communicate over the web
- Important features
	- Uses HTTP/HTTPS
	- REST is based on RESOURCES (collemthion of related objects)
	- These objects/resources are accessed via purposefully named URI(Uniform RESOURCE Interface) paths
	- HTP verbs indicate what is happening to that resource
- Example REST API
	- Company has employees
	- HTTP GET /employees
		- should return all employees in company
	- HTTP POST /employees
		- should create a new employee
	- HTTP GET /employees/35
		- should return one employee whose ID is 35
	- HTTP PUT /employees/41
		- should perform an update on employee of ID 41
	- HTTP DELETE /employees/54
		- should delete the employee of ID 54

- Status Codes
	- Web servers and REST applicatios are supposed to be language agnostic
	- Errors should be language agnostic
		- do not want to send the person using your API a Java Error code/exception
	- Simple numeric identifier of success or failure of a HTTP response
		- 100's Info
		- 200's Success
			- 201: Successfully created something
		- 300's Redirects
		- 400's Client side errors
			- 404: You requested something that does not exist
		- 500's Server side errors


