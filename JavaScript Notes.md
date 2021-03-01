#JavaScript
- The programming language that every browser uses
	- front end languages
		- JS
		- JS
		- JS
- JS has a lot of weird quirks and rules
- Brendan Eich developed the language in about 9 days
	- Java VS JavaScript
		- Java
			- Ham
			- Strongly and statically typed
			- Compiled
			- Server-side 
			- Scalability
			- OOP
			- Access Modifiers
			- Multi-threaded
			- No Global Scope
			- Automatic memory management
			- Pass By Value
			- Java 8 
			- Controlled by Oracle
		- Javascript
			- Hamster
			- Dynamic and loosely typed
			- Interpreted
			- Client-side (node.js is a backend for JS)
			- Flexibility
			- Mostly Functional (multi-paradigm) (cake salad)
			- No Access Modifiers
			- Asynchronous 
			- Has Global Scope
			- Automatic memory management
			- Pass By Value (finer points with objects)
			- ES6
			- Language implementation of EcmaScript

#DOM
- Document Object Model
	- Tree of elements making up a webpage
- This is what JavaScript was created for
- JS exists to manipulate the dom
	- This manipulation allows us to make wob pages dynamic and responsive
	- with just html, CSS, pages can't really respond to user

#AJAX
- Asychronous JavaScript and XML
	- Almost no one uses this for xml anymore
	- Predates JSON
- JavaScript is an Asynchronous event driven language
- JS is single threaded and can only compute one thing at a time
	- if a piece of JS takes a while, your application cannot do anything else
- HTTP Requests are something that can take time
	- Most processing of code is in the order of nanoseconds
	- Getting a file or message from another computer on the other side of the world could take several seconds
	- We do not want our JS to stop working while it is waiting
- Async await/promises
	- Syntactic sugar (abstraction of more complicated callbacks)
	- Tell JS to delay processing something until it gets the information from the server back

	
#CORS
- Cross Origin Resource Sharing
- It is very easy to make JS just in a loop and make an infinite amount of http requests to a server
- Also very easy to make malicious JS that can make requests that read your cookies
- The web has a standard that JS CANNOT make http requests and have them be processed unless the Server allows it
	- Servers can specify what origins(ip addresses) are allowed to send JS http requests to them

#Web Security
- make sure people should have access to what they should
- and not have access to what they should not
- all security should be a holistic approach
	- there is no one perfect solution
	- you should add security throughout your application
- JWT's are one way in which we can add security to our application
	- JSON web tokens
	- JWT's are essentially unchangeable documents you can give to users.
		- When you give someone a JWT it is impossible for that person to edit the JWT without you noticing
		- This is the feature that gives JWT's the ability to be used for security
		- JWTs ARE NOT ENCRYPTED
		- Must be kept private for each user
		- like a government doc, like Social Security card
			- servers can tell if its edited or fake
			- server cannot tell if it is stolen
	- JWTs are ENCODED
		- means, turned into another format
		- turning a java object into JSON is 'encoding' the object into JSON format
		- JWTs are encoded in base64 text
- JWT is comprised of 3 parts
	- Header (meta info)
		- alg:
		- typ:
	- Body/Payload (data)
		- should be in JSON format
	- Signature
		- how the magic of an uneditable document is created
		- the signature is created by using the payload body and combining it in an algorithm to create a signature that cannot be reverse engineered

		
#How to give a JWT?
- There are a few approaches
	- Adam's way
		- Make a login request (/users/login)
			- in body, put username and password
		- Server generates JWT for the user/login
			- includes privileges and username, NEVER PASSWORD
		- The HTTPResponse will give JWT back as a cookie

	- Cookie: small text file stored in a browser
		- Often used to store user information
