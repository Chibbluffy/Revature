// types in JS
// primitive types and objects in JS

// primitives
let num = 10;           // number (no int, double, float)
let word = "hello"      // strings are primitive
let undef = undefined   // undefined is the default value of everything in JS
// should never actually set a value to undefined
let nul = null          // null, a nothing value you explicitly assign
let book = true         // boolean

// JS is a loosely typed language
// any variable can be coerced into another type
// coercion makes it hard to predict the result due to really quirky coersions

let x = 1000;
let y = "700";
console.log(x-y); // valid, prints 300
console.log(x+y); // valid, prints 1000700

console.log(x-true);    // 999
console.log("false"+10) // false10
console.log("false"-10) // NaN
console.log(""-10)      // -10
// "" => false => 0

// JS has truthy and falsy values
// everything is truthy except for the falsy values
// falsy values
console.log(Boolean(0));
console.log(Boolean(""));
console.log(Boolean(null));
console.log(Boolean(undefined));
console.log(Boolean(NaN));
console.log(Boolean(false));
// falsy values imply some kind of non-existence

console.log(Boolean("false"));  // true


// loose equality == perform type coersion on values to compare
let num1 = "1000"
let num2 = 1000
console.log(num1==num2)         // true

let a = false
let b = 0
let c = "false"

console.log(a==b)
console.log(b==c)
console.log(a==c)
console.log(c-a+b)

// coercion is not transitively true

let result = "me"*"you"
console.log(result)     // NaN
// NaN is always false
console.log(result == false) // false
console.log(result == result) // false


// avoid type coercion
// === compare value AND type
console.log(num1 === num2)
// look up the js coercion table for more





