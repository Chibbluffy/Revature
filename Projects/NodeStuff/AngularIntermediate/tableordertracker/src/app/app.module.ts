import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DollarsPipe } from './pipes/dollars.pipe';
import { OrderFinalDetailsComponent } from './components/order-final-details/order-final-details.component';
import { AllOrdersDashboardComponent } from './components/all-orders-dashboard/all-orders-dashboard.component';
import { FormsModule } from '@angular/forms';
import { NewOrdersComponent } from './components/new-orders/new-orders.component';
import { EditOrdersComponent } from './components/edit-orders/edit-orders.component';
import { ReviewOrderComponent } from './components/review-order/review-order.component';

@NgModule({
  declarations: [
    AppComponent,
    DollarsPipe,
    OrderFinalDetailsComponent,
    AllOrdersDashboardComponent,
    NewOrdersComponent,
    EditOrdersComponent,
    ReviewOrderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
