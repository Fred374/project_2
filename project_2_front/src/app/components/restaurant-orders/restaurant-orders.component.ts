import { Component, OnInit } from '@angular/core';
import { Order } from '../../models/order';
import { OrdersService } from '../../services/orders.service';

@Component({
  selector: 'app-restaurant-orders',
  templateUrl: './restaurant-orders.component.html',
  styleUrls: ['./restaurant-orders.component.css']
})
export class RestaurantOrdersComponent implements OnInit {

  orders : Order[] = [];
  selectedViewOption : number = 1;
  

  constructor(private orderService:OrdersService) { }

  ngOnInit(): void {

    this.getOrdersForRestaurant();
    console.log(this.orders)
  }

  getOrdersForRestaurant() {
    this.orderService.getOrdersForRestaurant(4966752).subscribe(data => {
      this.orders = data.body as Order[];
      console.log(this.orders);
      })
    console.log("code ran")
  }

  changeViewOption(newViewOption : number) {
    this.selectedViewOption = newViewOption;
    console.log(newViewOption)
  }

}
