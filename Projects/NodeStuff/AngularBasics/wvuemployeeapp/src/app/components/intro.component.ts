// steps to create a component
// 1. create a typescript class
// 2. Decorator (meta information to the class) 
//      includes 
//      template: html template to use 
//      what is selector:name of compenent
// 3. write html
// 4. add the component to the app.module

import {Component} from "@angular/core";//TS unlike Nod js uses import statements

@Component({
    selector:'app-intro', // the html tage you will use to pull this component
    template: `
        <h1>About WVU Revature</h1>
        <h3>The best branch at Revature</h3>
        <p>Located in Morgantown West Virginia</p>
        <button (click)="revealInfo()">{{buttonLabel}}</button>
        <app-contact-info *ngIf="showContactInfo"></app-contact-info>

        <button (click)="sayHello()">Hello</button>
    ` // the html for the component
})

export class IntroComponent{

    showContactInfo:boolean = false;
    buttonLabel:string = "Show Contact Info"
    sayHello(){
        console.log("Hello")
    }

    toggleInfo(){
        this.showContactInfo = !this.showContactInfo;
    }
    revealInfo(){
        this.toggleInfo()
        if(this.showContactInfo){
            this.buttonLabel = "Hide Contact Info"
        }
        else{
            this.buttonLabel = "Show Contact Info"
        }
    }
}