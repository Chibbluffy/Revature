import {Component} from '@angular/core'

@Component({
    selector:'app-calculator-view',
    template: `
        <div class="fullcalc">
        

        <input *ngFor="let value of values; index as i; trackBy:customTrackBy"
               [(ngModel)]="values[i]">

        <button (click)="addInput()">Add another box</button>
        <button (click)="clearInput()">Reset boxes</button>
        <h5>{{result}}</h5>
        
        <button (click)="addAll()">+</button>
        <button (click)="subtractAll()">-</button>
        <button (click)="multiplyAll()">*</button>
        <button (click)="divideAll()">/</button>
        <button (click)="powerAll()">^</button>
       
        </div>
        <p>Calculation History</p>
        <ul>
            <li *ngFor="let calculation of calculations">{{calculation}}</li>
        </ul>
    `
})

export class CalculatorView{
    values = ["0", "0"]
    result = "0";
    calculations:string[] = []
    calculation:string = ""

    addInput(){
        this.values.push("0")
    }
    clearInput(){
        this.values = ["0", "0"]
    }
    
    addAll(){
        let res:number = 0
        this.values.map((value)=>{
            res += parseInt(value)
        })
        this.result = res.toString()
        this.pushCalculation("+")
    }
    subtractAll(){
        let res:number = parseInt(this.values[0])*2
        this.values.map((value)=>{
            res -= parseInt(value)
        })
        this.result = res.toString()
        this.pushCalculation("-")
    }
    multiplyAll(){
        let res:number = 1
        this.values.map((value)=>{
            res *= parseInt(value)
        })
        this.result = res.toString()
        this.pushCalculation("*")
    }
    divideAll(){
        let res:number = parseInt(this.values[0])
        for (let i = 1; i < this.values.length-1; i++) {
            res /= parseInt(this.values[i])
        }
        this.result = res.toString()
        this.pushCalculation("/")
    }
    powerAll(){
        let res:number = parseInt(this.values[0])
        for (let i = 1; i < this.values.length-1; i++) {
            res **= parseInt(this.values[i])
        }
        this.result = res.toString()
        this.pushCalculation("^")
    }
    pushCalculation(operation:string){
        let calculation:string = ``;
        for (let i = 0; i < this.values.length-1; i++) {
            calculation += `${this.values[i]}${operation}`
        }
        calculation += `${this.values[this.values.length-1]} = ${this.result}`
        this.calculations.push(calculation)
    }
    customTrackBy(index: number, obj: any):any{
        return index
    }

}