// Semi-colons in JS are optional
// Semicolons are actually required for JS to run
// most interpreters will autoinsert semicolons where it thinks it is appropriate

function getPerson(){
    return {
        name: "adam",
        ager:19
    }
}

let adam = getPerson();

console.log(adam);