// Arrays store items in ordered index manner
// Arrays can store anything
// Dynamically resized


let hello = function(){

}
let ray = [1,"F",true,1.1,null, {name:"Adame", age:5}, hello];
console.log(ray);

// add to array
ray.push("Steve")
console.log(ray)

// remove from array
ray.pop();
console.log(ray);

let person = ray[5]; // not technically get element from array syntax
console.log(person)

console.log(ray.length)

// iterate
for(let i = 0; i<ray.length; i++){
    console.log(ray[i])
}
// for of loop
for (let element of ray){
    console.log(element)
}

// arrays are objects
let steven = {name:"steven",age:30,profession:"supervisor"}
console.log(steven['profession']) 
// square brackets  is actually a property selector syntax








