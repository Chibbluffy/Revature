// TS has helpful features that take advantage of JS dynamiv nature
// object literal types
// this function returns an object that has these properties
function createPerson():{name:string,age:number}{
    let steve = {name:"steven",age:30,profession:"Trainer"}
    return steve;
}

let person = createPerson();

// union types which specify an OR relationship
// can return 2 diff types
function random():number|string{
    const randomNumber = Math.random()
    if (randomNumber<.5){
        return "I am a string"
    }
    else {
        return 1000;
    }
}

let y = random();
x

function getSqrt(num:number):number|never{
    if (num<0){
        throw "You cannot get sqrt of a negative num"
    }
    return Math.sqrt(num)

}
let z = getSqrt(100)

// you can have value return types
function coinFlip():"Heads"|"Tails"{
    const randomNumber = Math.random();
    return randomNumber<.5? "Heads":"Tails"
}

let result = coinFlip();

function getStatusMessage(statusCode: 1|2|3){
    
}