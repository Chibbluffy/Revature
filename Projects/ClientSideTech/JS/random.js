// ... is deconstructor
let arr = [1,2,3,4,5]
let newArr = [...arr,6,7,8,9]

let num1 = 100.7.toExponential()

// 'this' keyword is broken
var name = "Adam"

var person = {
    name: "Tim",
    describeSelf: function(){
        const self = this
        console.log(`Hi my name is ${this.name}`)
        let inner = function(){
            console.log(`my name is ${self.name}`)
            // console.log(`my name is ${this.name}`)
            // 'this' is undefined inside here
        }
        inner()
    }
}
person.describeSelf()


