import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/models/order';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-driver-orders',
  templateUrl: './driver-orders.component.html',
  styleUrls: ['./driver-orders.component.css']
})
export class DriverOrdersComponent implements OnInit {

  public orders : Order[] = [];
  constructor(private os : OrdersService) { }

  getOrders() {
    this.os.getFood(1).subscribe(
      (data: any) => {
        this.orders = data.body;
      }
    );
  }

  ngOnInit(): void {
  }

}
