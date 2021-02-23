// for in is for iterating over the properties of an object

let player = {
    name: "steph curry",
    height: 75,
    position: "p guard",
    grow:function(){
        this.height += 1;
    }
}

for (let prop in player){
    console.log(player[prop])
}

