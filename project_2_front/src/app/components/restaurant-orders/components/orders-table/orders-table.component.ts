import { Component, Input, OnInit } from '@angular/core';
import { Order } from 'src/app/models/order';
import { OrderStatus } from 'src/app/models/order-status';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-orders-table',
  templateUrl: './orders-table.component.html',
  styleUrls: ['./orders-table.component.css']
})
export class OrdersTableComponent implements OnInit {

  // Getting orders from RestaurantOrders parent component
  @Input() orders : Order[] = [];
  filteredOrders : Order[] = this.orders;
  selectedOrder? : Order;

  // Getting selected view option (changed in RestSideNav component) from RestaurantOrders
  @Input() selectedViewOption : number = 1;

  constructor(private orderService: OrdersService) { }

  ngOnInit(): void {

  }

  ngOnChanges() {
    // When selectedViewOption is changed calling the following
    this.filterOrders()
  }

  filterOrders() {

    let newFilteredOrders : Order[] = [];

    // If order status matches user selection we add it to the new array
    for (let o of this.orders) {
      if (o.orderStatusId?.orderStatusId == this.selectedViewOption) {
        newFilteredOrders.push(o);
      } 
    }

    this.filteredOrders = newFilteredOrders
  }

  updateOrderStatus() {

    let orderStatus = new OrderStatus(2,"Ready");

    this.selectedOrder!.orderStatusId = orderStatus;

    this.orderService.updateOrder(this.selectedOrder!).subscribe(data => {
      this.filterOrders()
    })


  }

}
