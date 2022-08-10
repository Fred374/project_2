import { Component, OnInit } from '@angular/core';
import { FoodItem } from 'src/app/models/food-item';
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
  public foodItem: FoodItem[] = []

  constructor(private os: OrdersService) { }

  getFoods() {
    this.os.getFood(this.resId).subscribe(
      (data:any) => {
        this.foodItem = data.body;
        for(let i = 0; i<this.foodItem.length; i++) {
          let order: OrderItem = {
            orderItemId : 0,
            orderItemFood : this.foodItem[i],
            orderItemNum : 0,
            orderItemTotalCost : 0
          }
          this.orderItem[i] = order;
        }
      }
    )
  }

  ngOnInit(): void {
    this.getFoods();
  }

}
