// callback function is any functoni that is passed as a parameter to another function

let hola = (name) => {
    console.log(`Hola ${name}`)
}

hola("tim")

let gutentag = (name) => {
    console.log(`Gutentag ${name}`)
}

gutentag("mike")

function customGreeter(name, language){
    language(name) // this is a callback function
}

customGreeter("Cam", gutentag) // gutentag is the callback function
customGreeter("Green", hola)

// arrays are super common place to see array
let fighters = ["Peach", "Mario", "Luigi", "Fox", "Falco", "Ness", "Kirby"];

for (let fighter of fighters){
    console.log(fighter)
}

let print = (something) => {
    console.log(something)
}

print(fighters)
fighters.forEach(print)

// anonymous callback function
// never assigned a name
fighters.forEach((something) => {
    console.log("Anonymous "+something)
})


let nums = [10,25,-40,70,-10,53,-4]

function sortDescending(num1, num2){
    if(num1<num2){
        return 1;
    }
    if(num1>num2){
        return -1;
    }
    return 0;
}

nums.sort(sortDescending)
console.log(nums)

// filter is a function that takes in a callback function
// if that function returns true, it will be returned 

function isNegative(num){
    if (num<0){return true}
    return false
}

console.log(nums.filter(isNegative))

let tempsF = [100,303,31,45,64]

function FtoC(f){
    let c = (f-32)*5/9
    return c;
}

let tempsC = tempsF.map(FtoC)
console.log(tempsC)
// map returns array of values with function applied to each

let freezingTempsC = tempsF.map(FtoC).filter(isNegative)
print(freezingTempsC)


// higher-order function is the function that takes in the callback function
// EX. map, filter, sort, forEach











