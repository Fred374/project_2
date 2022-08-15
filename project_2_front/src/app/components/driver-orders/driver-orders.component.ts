import { getSafePropertyAccessString } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/models/order';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-driver-orders',
  templateUrl: './driver-orders.component.html',
  styleUrls: ['./driver-orders.component.css']
})
export class DriverOrdersComponent implements OnInit {

  public readyOrders : Order[] = [];
  constructor(private os : OrdersService) { }

  getOrders() {
    this.os.getByOrderStatus(2).subscribe(
      (data: any) => {
        this.readyOrders = data.body;
        console.log("readyorders: " + this.readyOrders + "data: " + data.body)

        //for (let i = 0; i < this.readyOrders.length; i++)
        //this.readyOrders[i].

      }
    );
  }



  ngOnInit(): void {
    this.getOrders()
  }

}
