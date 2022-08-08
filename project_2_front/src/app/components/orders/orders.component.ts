import { Component, OnInit } from '@angular/core';
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

  constructor(private os: OrdersService) { }

  getFoods() {
    this.os.getFood(this.resId).subscribe(
      (data:any) => {
        this.orderItem = data.body;
        console.log(this.orderItem);
      }
    )
  }

  ngOnInit(): void {
    this.getFoods();
  }

}
