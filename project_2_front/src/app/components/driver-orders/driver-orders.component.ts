import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/models/order';
import { OrderStatus } from 'src/app/models/order-status';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-driver-orders',
  templateUrl: './driver-orders.component.html',
  styleUrls: ['./driver-orders.component.css'],
})
export class DriverOrdersComponent implements OnInit {
  selectedOrder?: Order;

  public readyOrders: Order[] = [];
  public pikedUpOrders: Order[] = [];

  // public tableOrders: Order[] = [];

  public hasActiveOrder = false;

  ngOnInit(): void {
    this.getOrders();
  }

  ngOnChanges(): void {
    this.getOrders()
  }

  constructor(private os: OrdersService) {}

  getOrders() {
    this.os.getOrdersByStatus(2).subscribe(
    data => {
      this.readyOrders = data.body as Order[];
      console.log('data: ' + data.body);
    });

    this.os.getOrdersByStatus(3).subscribe(
      data => {
      this.pikedUpOrders = data.body as Order[];
      console.log('data: ' + data.body);
    });
  }

  takeOrder() {
    console.log(this.selectedOrder?.orderId);

    let orderStatus = new OrderStatus(3, 'Picked Up');
    this.selectedOrder!.orderStatusId = orderStatus;

    this.os.updateOrder(this.selectedOrder!).subscribe((data) => {
      this.getOrders()
      this.hasActiveOrder = true;
    });


  }


  deliverOrder() {
    console.log(this.selectedOrder?.orderId);

    let orderStatus = new OrderStatus(4, 'Delivered');
    this.selectedOrder!.orderStatusId = orderStatus;

    this.os.updateOrder(this.selectedOrder!).subscribe((data) => {
      this.getOrders()
      this.hasActiveOrder = false;
    });


    // location.reload();
  }

}
