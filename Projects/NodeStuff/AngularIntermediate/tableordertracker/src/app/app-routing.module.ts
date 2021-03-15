import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllOrdersDashboardComponent } from './components/all-orders-dashboard/all-orders-dashboard.component';
import { EditOrdersComponent } from './components/edit-orders/edit-orders.component';
import { NewOrdersComponent } from './components/new-orders/new-orders.component';
import { ReviewOrderComponent } from './components/review-order/review-order.component';

const routes: Routes = [
  {path:"neworder",component:NewOrdersComponent},
  {path:"editorder",component:EditOrdersComponent},
  {path:"revieworder",component:ReviewOrderComponent},
  {path:"allorders",component:AllOrdersDashboardComponent},
  {path:"**",component:AllOrdersDashboardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
