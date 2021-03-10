const fname:string = "adam"; // typescript does automatic infering of the type if you do not put it

const num = 100;

function greet(name:string){
    console.log(`Hello ${name}`);
}

greet(fname);
//greet(num); // this gives an error before you even run the code

// functions can have return types
function phraseLength(phrase:string):number{
    const length:number = phrase.length;
    return length;
}

function isEven(num:number):boolean{
    return num%2===0;
}

isEven(5);