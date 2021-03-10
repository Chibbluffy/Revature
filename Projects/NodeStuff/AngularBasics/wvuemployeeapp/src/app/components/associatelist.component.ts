import { Component } from "@angular/core";


@Component({
    selector:'app-associate-list',
    template: `
        <h3>Graduates from Revature</h3>
        <ul>
            <li *ngFor="let associate of associates">{{associate}}</li>
        </ul>
        <button (click)="deleteAssociate()">Delete</button>
        <button (click)="addAssociate()">Add</button>
        <input [(ngModel)]="name">
        <h6>{{name}}</h6>
        `
})

export class AssociateComponent{
    name:string=''
    associates:string[] = ["Jaxon", "Peter", "John", "Francis", "Dan", "Kaitlin", "Edwin", "Dylan"]
    deleteAssociate(){
        this.associates.pop()
    }
    addAssociate(){
        this.associates.push(this.name);
    }
}