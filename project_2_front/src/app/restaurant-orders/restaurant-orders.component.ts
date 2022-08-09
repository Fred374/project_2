import { Component, OnInit } from '@angular/core';
import { OrdersService } from '../services/orders.service';

@Component({
  selector: 'app-restaurant-orders',
  templateUrl: './restaurant-orders.component.html',
  styleUrls: ['./restaurant-orders.component.css']
})
export class RestaurantOrdersComponent implements OnInit {

  testArr = ["One", "Two", "Three", "Four", "Five"]

  constructor(private orderService:OrdersService) { }

  ngOnInit(): void {
  }

}
