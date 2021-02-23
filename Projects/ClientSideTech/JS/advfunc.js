// JS is fairly functional
// Functions are objects
// Functions are first class 
// You can store them in variables and do anything else u can do with a normal object
let add = function(num1,num2){
    return num1+num2
}

console.log(add) // prints out a function OBJECT

add.something = 100 // valid
// functions are objects, you can add meaningless properties 
// bc every object in JS can be mutated at any time
console.log(add(100,50))
console.log(add.something)
console.log(add)

// functions are objects that have a hidden 'code' property
// you can invoke this code with ()
// like constructor was replaced with a function

// functions can have functions within them
// this is the origin of encapsulation



// this creates an object with these properties then return the obj
// 100% functional. No 'THIS' keyword object constructor
function createPerson(name, age){
    let person = {name:name, age:age}
    person.sayHello = function(){
        console.log("hello my name is "+name)
    }
    return person
}

let p = createPerson("adam",9)
console.log(p.sayHello());

function welcomeAll(people){
    let greet = function(person){
        console.log("hello "+person)
    }
    for (let p of people){
        greet(p)
    }
}

welcomeAll(['Tom','Rich','Adam','Yes'])
// cannot call greet outside of welcomeAll
// encapsulation***


// side note:
// spread operator
// turns an array into multiple arguments
let info = [100,300]
function subtract(num1, num2){
    return num1 - num2;
}
subtract(...info) 
// this will spread the elements into individual elements






