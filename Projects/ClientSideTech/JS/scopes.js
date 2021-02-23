// scopes in JS
// scoping is done mostly by keywords (var, let, const)

// let is block scope
// var is function scope
// const is block scope

// let can be redefined, const is constant


x = 100; // global variable
// no keyword = global
console.log(x);

let y = 1000;
console.log(y);

function hello(){
    {
        let greeting = "Hello"
        console.log(greeting);
    }
    // console.log(greeting); // error
}

hello();

function hola(){
    // global vars are dangerous
    vamanos = "hola" // global, CAN BE USED OUTSIDE FUNCTION
    console.log(vamanos)
}

hola();

// have to run hola() first, so that vamanos is defined
console.log(vamanos)


function bonjour(){
    {
        var greet = "Bonjour" // var is function scope
        console.log(greet)
    }
    console.log(greet) // var escapes the block, into the function
}

bonjour()

function hoisting(){
    console.log(adam) // prints undefined if var adam is made after
    // gives error if not
    var adam = "Adam"

    // before a single line of code in a function is executed
    // all var variables are given the default value of undefined
}

hoisting();


