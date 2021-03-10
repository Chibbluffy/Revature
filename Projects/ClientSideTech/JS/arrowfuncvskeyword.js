// ES6 introduced an arrow function
// thi this keeyword in JS is kinda broken
// JS has "late binding" of 'this' keyword
// the objects referred to by 'this' is based on where it is executed
// not where it is defined

hello = "Global"

function sayHello(){
    console.log(this.hello)
}
let sayHello3 = () =>{
    console.log(this.hello)
    // equivalent to console.log(Window.hello)
}

sayHello(); // the function is executed in the context of the top level script
// in the top level script refers to the global window object

let adam = {
        hello:"This hello is in adam",
        sayHello2:sayHello, // attaching function definition to a property of an object
        // when the same function is executed in an object,
        // the context of 'this' changes to refer to the object the function is attached to
        sayHello4:sayHello3 // in arrow notation
        // the 'this' that is changed will never change
        // it will always be global
}

adam.sayHello2()
adam.sayHello4()