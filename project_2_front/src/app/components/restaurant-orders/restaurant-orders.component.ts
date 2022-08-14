import { Component, OnInit } from '@angular/core';
import { Order } from '../../models/order';
import { OrdersService } from '../../services/orders.service';

@Component({
  selector: 'app-restaurant-orders',
  templateUrl: './restaurant-orders.component.html',
  styleUrls: ['./restaurant-orders.component.css']
})
export class RestaurantOrdersComponent implements OnInit {

  // Getting Restaurant info
  user = JSON.parse(localStorage.getItem("currentUser") || "{}");
  restaurantId = this.user.userLastName;

  orders : Order[] = [];
  selectedViewOption : number = 1;

  areOrdersLoaded = false;
  

  constructor(private orderService:OrdersService) { }

  ngOnInit(): void {

    this.getOrdersForRestaurant();
    console.log(this.orders)
  }

  getOrdersForRestaurant() {
    this.orderService.getOrdersForRestaurant(this.restaurantId).subscribe(
      data => {
      this.orders = data.body as Order[];
      this.areOrdersLoaded = true;
      },
      error => {
        console.log(error);
      }
      )
    console.log("code ran")
  }

  changeViewOption(newViewOption : number) {
    this.selectedViewOption = newViewOption;
    console.log(newViewOption)
  }

}
