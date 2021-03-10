import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AssociateComponent } from './components/associatelist.component';
import { ContactInformationComponent } from './components/contactinfo.component';
import { EmployeeComponent } from './components/employee.component';
import { IntroComponent } from './components/intro.component';

import {FormsModule} from '@angular/forms'

// every application only has one app.module
// like a table of contents
// whenever you make a component you have to add it in here as well

@NgModule({
  declarations: [
    AppComponent,
    IntroComponent,
    EmployeeComponent,
    ContactInformationComponent,
    AssociateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule // FormsModule is not default imported
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
