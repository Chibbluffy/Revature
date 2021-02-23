// functions in JS
// functions can take in any parameters
// cannot overload function

function greet(name){
    console.log("hello "+name)
}
greet("you")
greet(5)

// functions can take any amount of parameters
greet()                     // "hello undefined"
greet("kevin", "ignored")   // "hello kevin"

function add(num1, num2){
    return num1+num2
}
function add(num1, num2){
    return (num1 -false) + (num2 -false) // enlightened JS
}


console.log(add("788","12"))

// cannot define default type in ES6, but you can define default vaue
function subtract (num1=0, num2=0){
    return num1-num2;
}

subtract(100);      //100

// FUNCTIONS ARE OBJECTS
// CAN STORE IN VABIABLES
let add2 = add;
console.log(add2(75,45));

let multiply = function(num1, num2){
    return num1+num2
}

let divide = (num1, numd)=>{
    return num1/num2
}



