import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { FoodItem } from 'src/app/models/food-item';
import { Order } from 'src/app/models/order';
import { OrderItem } from 'src/app/models/order-item';
import { Restaurant } from 'src/app/models/restaurant';
import { User } from 'src/app/models/user';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  resId = this.os.resId;

  public orderItem: OrderItem[] = [];
  public foodItem: FoodItem[] = [];
  public res: Restaurant = {
    name: "",
    address: "",
    location_string: ""
  };
  public user: User = {};


  constructor(private os: OrdersService, private router: Router) { }

  getRes() {
    this.os.getRes().subscribe(
      (data: any) => {
        console.log(data.results);
        this.res.name = data.results.data[0].name;
        this.res.address = data.results.data[0].address;
        this.res.location_string = data.results.data[0].location_string;
      }
    )
  }

  getFoods() {
    this.os.getFood(this.resId).subscribe(
      (data: any) => {
        this.foodItem = data.body;
        for (let i = 0; i < this.foodItem.length; i++) {
          let order: OrderItem = {
            orderItemId: 0,
            foodItemId: this.foodItem[i],
            orderItemNum: 0,
            orderItemTotalCost: 0
          }
          this.orderItem[i] = order;
        }
      }
    )
  }

  btn() {
    let orderCost = 0;
    for (let i = 0; i < this.orderItem.length; i++) {
      if (this.orderItem[i].orderItemNum > 0) {
        this.orderItem[i].orderItemTotalCost = this.orderItem[i].orderItemNum * this.orderItem[i].foodItemId.foodItemCost;
        orderCost += this.orderItem[i].orderItemTotalCost;
      } else {
        this.orderItem.splice(i, 1);
        i--;
      }
    }
    //console.log(this.orderItem);
    let order: Order = {
      orderCost: orderCost,
      restaurantIdFk: this.resId,
      orderItems: this.orderItem
    }
    this.os.userId = this.user.userId || 0;
    //console.log(order);
    this.os.sendOrder(order).subscribe(
      (data: any) => {
        this.os.order = data;
        console.log(this.os.order);
        alert("Your food has been ordered.");
        this.router.navigate(['ordersPt2'])
      }, () => {
        alert("An error occured.");
      }
    );
  }

  ngOnInit(): void {
    this.getFoods();
    this.getRes();
    this.user = JSON.parse(localStorage.getItem("currentUser") || "")
    console.log(this.user);
  }

}
