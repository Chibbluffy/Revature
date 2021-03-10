// TS has a lot of support of OOP
// TS had classes before JS did
var Person = /** @class */ (function () {
    function Person(name, age) {
        this.name = name;
        this.age = age;
    }
    Person.prototype.describeSelf = function () {
        console.log("Hi my name is " + this.name + " I am this old: " + this.age);
    };
    return Person;
}());
var adam = new Person("Adam", 19);
adam.describeSelf();
