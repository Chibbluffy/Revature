import {Component} from '@angular/core'

@Component({
    selector:'app-calculator-view',
    template: `
        <div class="fullcalc">
        <div>
        <input [(ngModel)]="value1">
        <input [(ngModel)]="value2">
        </div>

        <button (click)="addInput()">Add another box</button>
        <h5>{{result}}</h5>
        
        <button (click)="addAll()">+</button>
        <button (click)="subtractAll()">-</button>
        <button (click)="multiplyAll()">*</button>
        <button (click)="divideAll()">/</button>
       
        </div>
        <p>Calculation History</p>
        <ul>
            <li *ngFor="let calculation of calculations">{{calculation}}</li>
        </ul>
    `
})

export class CalculatorView{
    value1 = "0"
    value2 = "0"
    result = "0";
    calculations:string[] = []
    calculation:string = ""

    addInputBox(){
    }
    
    addAll(){
        let res:number = parseInt(this.value1) + parseInt(this.value2)
        this.result = res.toString()
        this.pushCalculation("+")
    }
    subtractAll(){
        let res:number = parseInt(this.value1) - parseInt(this.value2)
        this.result = res.toString()
        this.pushCalculation("-")
    }
    multiplyAll(){
        let res:number = parseInt(this.value1) * parseInt(this.value2)
        this.result = res.toString()
        this.pushCalculation("*")
    }
    divideAll(){
        let res:number = parseInt(this.value1) / parseInt(this.value2)
        this.result = res.toString()
        this.pushCalculation("/")
    }
    pushCalculation(operation:string){
        let calculation = `${this.value1}${operation}${this.value2} = ${this.result}`
        this.calculations.push(calculation)
    }
    resetState(){

    }

}