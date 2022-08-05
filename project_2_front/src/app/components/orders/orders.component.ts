import { Component, OnInit } from '@angular/core';
import { OrderItem } from 'src/app/models/order-item';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  public orderItem: OrderItem = {
    orderItemId: 0,
    orderItemFood: {
      foodItemId: 0,
      foodItemCost: 0,
      foodItemName: "",
      foodItemRestaurantId: 0
    },
    orderItemNum: 0,
    orderItemTotalCost: 0
  };

  constructor() { }

  ngOnInit(): void {
  }

}
