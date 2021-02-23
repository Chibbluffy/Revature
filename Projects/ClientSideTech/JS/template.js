// template literals
// quickly format strings
// remove all the + signs throughout code
// string interpolation


const name = "Tom"
let greeting = `Hi ${name}`;

console.log(greeting)

let adam = {
    name: "Adam",
    age:19,
    profession:"trainer",
    sayHello: function(){
        console.log(`Hi my name is ${this.name}. I am ${this.age} and I am a ${this.profession}`)
    }
}

adam.sayHello()