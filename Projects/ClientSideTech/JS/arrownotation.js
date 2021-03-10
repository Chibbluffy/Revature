// arrow notation has flexibility regarding syntax

let hola = (name)=>{
    console.log(name)
}

hola("tim")

// dont need parens if only one param
let bonjour = name => {
    console.log(name)
}

bonjour("tam")

// do not need curlies if body is an expression with a value and you return it
let add = (num1, num2) =>  num1+num2;
let addition = (num1, num2) => {
    return num1 + num2;
}

let sum = add(1,5);
console.log(sum)

let degreesF = degreesC => (degreesC-32)*5/9;