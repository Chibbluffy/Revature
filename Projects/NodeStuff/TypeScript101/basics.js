var fname = "adam"; // typescript does automatic infering of the type if you do not put it
var num = 100;
function greet(name) {
    console.log("Hello " + name);
}
greet(fname);
//greet(num); // this gives an error before you even run the code
