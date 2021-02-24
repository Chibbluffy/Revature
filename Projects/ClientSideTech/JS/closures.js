// History of classes and encapsulation
// old school languages (ALGOL) had functions (very functional based)

function greetPerson(name){
    console.log(`Hells ${name}`)

    let sayHello = function(){
        console.log(`Hello my name is ${name}`)
    }
    sayHello()

    return {name, sayHello} // in JS you do not have to do property:property
}

greetPerson("Tom")
let tom = greetPerson("Tom")
console.log(tom.name)
tom.sayHello()
