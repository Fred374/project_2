import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { FoodItem } from 'src/app/models/food-item';
import { Order } from 'src/app/models/order';
import { OrderItem } from 'src/app/models/order-item';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  resId = 4966752;

  public orderItem: OrderItem[] = [];
  public foodItem: FoodItem[] = [];

  constructor(private os: OrdersService, private router: Router) { }

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
    //console.log(order);
    this.os.sendOrder(order).subscribe(
      (data: any) => {
        this.os.order = data;
        //console.log(this.os.order);
        alert("Your food has been ordered.");
        this.router.navigate(['ordersPt2'])
      }, () => {
        alert("An error occured.");
      }
    );
  }

  ngOnInit(): void {
    this.getFoods();
  }

}
