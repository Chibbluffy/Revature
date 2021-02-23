// Objects in JS
// JS is NOT class based
// can create objects without having a class already defined
// Objects are just key value pairs
// more like dictionaries in python

// object literal
// JSO (JAVASCRIPT OBJECT)
let adam = {
    name:"Adam", 
    age:20,
    sayHello: function(){
        console.log("Hi I'm "+this.name)
    },
    sayName: ()=>{
        console.log("My name is "+this.name)
    }
}
console.log(adam)
console.log(adam.name)


// objects are always mutable. can add / change properties anytime

adam.age = true
adam.location="Virginia"

console.log(adam)

adam.sayHello()

// a method is a function attached to an object


// turn JSO into JSON
// functions are NOT represented in the JSON
// JSON are for state information of object
let json = JSON.stringify(adam);
console.log(json)

// Objects are a lot easier to work with
// JSON strings into objects
let adam2 = JSON.parse(json);
console.log(adam.name);

// prototypal inheritance
let childAdam = {name:"Adam Jr"}

// do not set prototypes this way. it is really inefficient
childAdam.__proto__ = adam;     
// an object can inherit the properties of another through prototype property

childAdam.sayHello();

adam.sayName();
childAdam.sayName();

// for functions that are methods, use 'this' keyword
// for functions that do not use 'this' you can use arrow notation


// JS before classes
// constructor function to create objects

function Person(name="", age=0){
    this.name = name;
    this.age = age;
    this.welcome = function(){
        console.log("welcome home master")
    }
}

let kevin = new Person("Kevin", 25)
kevin.welcome()

// JS since ES6 has classes

class Employee{
    eId;
    fname;
    lname;
    department;

    constructor(eId,fname,lname,department){
        this.eId = eId
        this.fname = fname
        this.lname = lname
        this.department = department

    }
    describeSelf(){
        console.log("I am "+this.fname)
        console.log("I work in "+this.department)
    }
}

let mary = new Employee(100,"Mary","shelly","main")

mary.describeSelf()





