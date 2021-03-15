import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Item } from 'src/app/models/item';
import { Order } from 'src/app/models/order';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-edit-orders',
  templateUrl: './edit-orders.component.html',
  styleUrls: ['./edit-orders.component.css']
})
export class EditOrdersComponent implements OnInit {
  items:Item[] = [
    new Item("Pizza", 0, 8),
    new Item("LARGE Pizza", 0, 12),
    new Item("Burger", 0, 6),
    new Item("GIANT Burger", 0, 12),
    new Item("Fries", 0, 2.5),
    new Item("Edamame", 0, 3),
    new Item("Fried Rice", 0, 9),
    new Item("Egg Roll", 0, 1),
    new Item("NOODLE", 0, 7),
    new Item("Soup of the day", 0, 5),
    new Item("Add Extra meat", 0, 2.5),
    new Item("Add Extra veggies", 0, 2)
  ]
  constructor(private ordersService:OrdersService, private router:Router) { }

  addItem(item:Item){
    item.count += 1
  }
  removeItem(item:Item){
    item.count = Math.max(0, item.count-1)
  }
  sendOrder(){
    this.ordersService.currentOrder.items = this.items;
    this.router.navigate(['/revieworder'])
  }
  ngOnInit(): void {
      const currentOrder:Order = this.ordersService.currentOrder
      this.items = currentOrder.items
  }
}
