import { Injectable } from '@angular/core';
import { Order } from '../models/order';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {
  orders:Order[] = []
  currentOrder:Order = new Order();
  constructor() { }
}
