import { summaryFileName } from '@angular/compiler/src/aot/util';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from 'src/app/models/order';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-all-orders-dashboard',
  templateUrl: './all-orders-dashboard.component.html',
  styleUrls: ['./all-orders-dashboard.component.css']
})
export class AllOrdersDashboardComponent implements OnInit {
  orders:Order[] = [];
  constructor(private ordersService:OrdersService, private router:Router) { }

  ngOnInit(): void {
    this.orders = this.ordersService.orders;
    this.calcAllOrderSums();
  }

  sumNoTax(order:Order):number{
    let orderSum:number = 0;
    order.items.forEach(item => {
      orderSum += item.price*item.count
    });
    return orderSum;
  }
  sumWithTax(order:Order):number{
    return this.sumNoTax(order)*1.1
  }
  sumAllNoTax:number = 0;
  sumAllWithTax:number = 0;
  calcAllOrderSums(){
    this.orders.forEach((order:Order) => {
      this.sumAllNoTax += this.sumNoTax(order)
      this.sumAllWithTax += this.sumWithTax(order)
    });
  }
  editOrder(order:Order){
    this.ordersService.currentOrder = order;
    this.router.navigate(['/editorder'])
  }
  addNewOrder(){
    this.ordersService.currentOrder = new Order(this.ordersService.orders.length+1);
    this.router.navigate(['/neworder'])
  }
}
  
