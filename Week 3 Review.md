#Client Side Tech Review
- 3 pillars of client side technology
	1. HTML
		- Structure and content
	2. CSS
		- Styling
	3. JS
		- Logic/dynamic webpages 

#HTML
- Hyper Text Markup Language
- Based on tags/elements
- Elements can be nested
- Elements have attributes
- NOT A PROGRAMMING LANGUAGE

#CSS
- Cascading Style Sheets
- Cascading Algorithm is what determines the final CSS for an element
	- Closest more specific CSS wins
- Bootstrap is a popular CSS library
	- Created by Twitter

#JavaScript
- The only programming language on the internet essentially
	- Al browsers run JS
- Has almost nothing in common with Java
- Scopes in JS
	- Global (put nothing in front of variable) AVOID
	- Function (put var in front of the variable) AVOID ALWAYS
	- Block 
		- let => the variable can be reassigned
		- const => the variable cannot be reassigned
- Objects
	- Just key value pairs
	- Not class based
	- Object literal syntax `{name:"Adam",age:19}`
	- Prototypal inheritance
- Truthy Falsey
	- JS has very aggressive type coercion 
		- "JS will compare apples to oranges even if they are both bananas"
	- Any value in JS can be coerced into true or false
	- Every value  is true EXCEPT the falsey values
		- 0
		- ""
		- Null
		- Undefined
		- NaN
		- False
	- ==
		- JS will perform type coercion then compare values
	- === (strict equality)
		- JS will compare both value and type
- Primitive Types in JS
	- String
	- Number
	- Boolean
	- Undefined
	- Null
	- Symbol
- Arrays
	- Can hold anything in JS
	- Dynamically sized
- Functions in JS
	- Functions are OBJECTS
	- JS is a fairly functional language
	- Types of function
		- Method
			- Function that is a property of an object
		- Callback Function
			- Function passed in as an argument to another function
			- `.addEventListener("click",callbackFunc)`
		- Arrow Function
			- `() -> {}`
				- The binding of the "this" keyword is constant in an arrow function
				- below are all the same*
				- `let greet = name => "hello "+name`
				- `let greet = (name) => "hello "+name`
				- `let greet = (name) => {return "hello "+name}`
		- Higher Order Function
			- A function that takes in a callback function
			- MyArray.map()
		- Anonymous Function
			- Arrow function that is not assigned to anything
			- A function with no name and defined on the spot
- AJAX
	- Asynchronous JavaScript and XML
	- We can use this to Issue http requests in JS without having to reload the entire page
		- HTML forms reload the entire page by default
		- Web used to require peple to reload the entire page whenever you sent an http request
	- Async Await and Promises
		- Async is a keyword that marks a function as asynchronous
			- It allows you to use the await keyword within that function
			- an Async functoi always returns a promise
		- Promise
			- An empty object that will eventually hold a value
			- can await a promise which means JS will hold off on executing code on the function until the object/promise is fulfilled
		- 
- Closures
	- Function within a function
	- The inner function can use variables defined in the outer function

	
	
	
JavaScript Classes , 
Objects are key value pairs. 
Always mutable. 

Type coercion. 
Access modifiers

Java vs JS
compiled language vs Interpreted language

AJAX
- Can do requests without reloading whole page
- How to know when promise is fulfilled??

HOISTING
- function hoisting
- variable hoisting

Semicolons

Arrays 

Item potency - safe operation. safe to repeat. GET is item potent. POST is NOT. 

element vs attribute

DOM

CSS selecting

CSS Grids

HTML <meta> tag

loading in JS from another source
- <script src=?>
- link, src, href

Type coercion

For in, for each

addEventListener

callback function

data types

Objects in Java vs JS
- inheritance 
- 

Fetch

AJAX

Web Hosting

Security issues

Cross site request forgeries
- OOS security rules
- Session ID
- JWTs
- 

MVC patterns
- Model View Controller patterns
- 

Responsive 
- changes while resizing, or on different devices
- CSS
- set diff rules for viewpoints
- 

unshift method
- 
