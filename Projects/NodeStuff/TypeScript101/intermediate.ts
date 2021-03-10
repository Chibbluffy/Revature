// TS has types not in JS. Like void or never

function printName(name:string):void{
    console.log(name)
}

let x:void = printName("")

// try to avoid :any type
// same as pure JS

function myprint(something:any){
    console.log(something)
}

// never means the functioni shouold never end or must never return successfully
function infiniloop():never{
    while(true){
        console.log()
    }
}


// TS supports generics for arrays
const ssbuCharacters:Array<string> = ["Peach", "Zelda", "Mario", "Kirby"]
ssbuCharacters.push("Bowser")

//alternate syntax
const pastAssociates:string[] = ["Jaxon", "Peter", "Max"]

const tempsCelcius:string[] = ["100", "200", "300"]

const tempsFarenheit:number[] = tempsCelcius.map((temp)=>{
    const cTemp:number = Number(temp)
    return cTemp*9/5+32
})

console.log(tempsFarenheit)



