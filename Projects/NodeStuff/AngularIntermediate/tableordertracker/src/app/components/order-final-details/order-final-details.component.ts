import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from 'src/app/models/order';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-order-final-details',
  templateUrl: './order-final-details.component.html',
  styleUrls: ['./order-final-details.component.css']
})
export class OrderFinalDetailsComponent implements OnInit {

  order:Order = new Order();
  constructor(private ordersService:OrdersService, private router:Router) { }

  ngOnInit(): void {
    this.order = this.ordersService.currentOrder;
  }
  backToMain(){
    this.router.navigate(['/main'])
  }
}
