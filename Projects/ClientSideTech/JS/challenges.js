/*
JS questions
1. write a function sum that takes an array and sums the array
	a. the array can have numbers and strings that can be converted to numbers
	
2. write a function shippingCost that takes in an object with the properties {weight:number,overnight:boolean}
	this function should calculate the shipping cost. every kilogram adds $2.00 overnight doubles the cost.

3. write a function palindrome checks to see if a function is a palindrome "racecar", "mom" are palindromes

4. write a function currencyConverterUSD(amount, callbackFunction). It takes in an amount and a callback function
	the callback function should take in a number and return the value in another currency
	currencyConverterUSD(100, euroConverter) returns the value in euros.

5. map take an array of yes no strings and return an array of booleans
	["yes","no","yes"]  -> [true,false,true]

6. Create a car object that has a drive method, showMiles and milesDriven field. Each time you create a car it starts with 0
miles. the driveMethod takes in a number and increases miles driven by that amount. showMiles prints current mileage
use string templates for the showMiles

*/

// 1.
let sum = function(arr){
    let total = 0
    for (let i of arr){
        total += i
    }
    return total
}
let nums = [1,2,3,4]
console.log("\n1.")
console.log(sum(nums))

// 2.
let shippingCost = function(freight){
    let cost = freight.weight*2
    if (freight.overnight){
        cost *= 2
    }
    return cost
}
let cost = shippingCost({weight:5,overnight:true})
console.log("\n2.")
console.log(cost)

// 3.
let palindrome = function(str){
    for (let i = 0; i < str.length/2; i++){
        if (str.charAt(i) != str.charAt(str.length-i-1)){
            return false
        }
    }
    return true;
}
console.log("\n3.")
console.log("mom: " + palindrome("mom"))
console.log("racecar: " + palindrome("racecar"))
console.log("tom: " + palindrome("tom"))

// 4. 

let dollarToYen = function(amount){
    return amount*100
}
let currencyConverterUSD = function(amount, callback){
    return callback(amount)
}
console.log("\n4.")
console.log(currencyConverterUSD(100, dollarToYen))

// 5. 
let customToBoolean = function(str){
    if (str == "yes"){
        return true
    }
    if (str == "no"){
        return false
    }
    return str
}
let yesnos = ["yes","yes","no"]
let truefalses = yesnos.map(customToBoolean)
console.log("\n5. ")
console.log(truefalses)

// 6. 
function Car () {
    this.miles = 0,
    this.drive = function(miles){
        this.miles += miles
    },
    this.showMiles = function(){
        console.log(`Your car has driven ${this.miles} miles`)
    },
    this.milesDriven = function(){
        return(this.miles)
    }
}
console.log("\n6.")
let newCar = new Car()
newCar.showMiles()
newCar.drive(1337)
newCar.showMiles()

/*
Challenge

1. make your own array object. This object does not use the in built array at all. It supports
its own version of push and pop. You can also get by index

2. in question 6 make miles impossible to directly alter after creation
*/

// 1.
function myArray(){
    this.array = [],
    this.push = function(item){
        this.array.push(item)
    },
    this.pop = function(){
        this.array.pop()
    }
}
console.log("\n1.")
let newArray = new myArray()


// 2. 
function ConstantCar () {
    this.miles = 0,
    this.drive = function(miles){
        this.miles += miles
    },
    this.showMiles = function(){
        console.log(`Your car has driven ${this.miles} miles`)
    },
    this.milesDriven = function(){
        return(this.miles)
    }
}
console.log("\n2.")
let newCar = new ConstantCar(1337)
newCar.showMiles()
newCar.drive(1337)
newCar.showMiles()
