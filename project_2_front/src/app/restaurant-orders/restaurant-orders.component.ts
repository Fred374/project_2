import { Component, OnInit } from '@angular/core';
import { Order } from '../models/order';
import { OrdersService } from '../services/orders.service';

@Component({
  selector: 'app-restaurant-orders',
  templateUrl: './restaurant-orders.component.html',
  styleUrls: ['./restaurant-orders.component.css']
})
export class RestaurantOrdersComponent implements OnInit {

  testArr = ["One", "Two", "Three", "Four", "Five"]
  orders : Order[] = [];

  constructor(private orderService:OrdersService) { }

  getOrdersForRestaurant() {
    this.orderService.getOrdersForRestaurant(4966752).subscribe(data => this.orders = data.body as Order[])
    console.log("code ran")
  }

  ngOnInit(): void {

    this.getOrdersForRestaurant();
    console.log(this.orders)
  }

}
