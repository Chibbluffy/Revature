// TS has a lot of support of OOP
// TS had classes before JS did

interface Calculator{
    power(base:number, exponent:number)
}

class Person implements Calculator{

    // you can have access modifiers in TS
    // but they dont do anything
    // they just hide it in IDE
    name:string
    age:number

    constructor(name:string, age:number){
        this.name = name
        this.age = age
    }
    describeSelf(){
        console.log(`Hi my name is ${this.name} I am this old: ${this.age}`);
    }
    power(base:number, exponent:number){
        return base**exponent
    }
}

const adam = new Person("Adam", 19)

adam.describeSelf()

class Dog{
    constructor(public owner:string, public name:string, public age:number){

    }
}

let clifford = new Dog("Emily Elizabeth", "Clifford", 8)

