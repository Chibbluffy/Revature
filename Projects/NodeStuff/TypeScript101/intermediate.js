// TS has types not in JS. Like void or never
function printName(name) {
    console.log(name);
}
var x = printName("");
// try to avoid :any type
// same as pure JS
function myprint(something) {
    console.log(something);
}
// never means the functioni shouold never end or must never return successfully
function infiniloop() {
    while (true) {
        console.log();
    }
}
// TS supports generics for arrays
var ssbuCharacters = ["Peach", "Zelda", "Mario", "Kirby"];
ssbuCharacters.push("Bowser");
//alternate syntax
var pastAssociates = ["Jaxon", "Peter", "Max"];
var tempsCelcius = ["100", "200"];
var tempsFarenheit = tempsCelcius.map(function (temp) {
    var cTemp = Number(temp);
    return cTemp * 9 / 5 + 32;
});
console.log(tempsFarenheit);
