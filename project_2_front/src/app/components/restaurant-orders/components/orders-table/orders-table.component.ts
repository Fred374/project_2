import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { AlertComponent } from 'src/app/components/shared/alert/alert.component';
import { Order } from 'src/app/models/order';
import { OrderStatus } from 'src/app/models/order-status';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-orders-table',
  templateUrl: './orders-table.component.html',
  styleUrls: ['./orders-table.component.css']
})
export class OrdersTableComponent implements OnInit {

  // Accessing alert child component to be able to call its methods
  @ViewChild(AlertComponent) alertComponent! : AlertComponent;

  // Getting orders from RestaurantOrders parent component
  @Input() orders : Order[] = [];
  filteredOrders : Order[] = this.orders;
  selectedOrder? : Order;

  // UI variables
  @Input() areOrdersLoaded = true;

  isAlertActive = false;
  alertMessage = "";

  changeStatusButtonLabel = "Mark Ready";
  isStatusButonNeeded = true;
  orderTableHeader = "";
  snippetTimeColor = "var(--order-placed-color)";

  // Getting selected view option (changed in RestSideNav component) from RestaurantOrders
  @Input() selectedViewOption : number = 1;

  constructor(private orderService: OrdersService) { }

  ngOnInit(): void {
    
  }

  ngOnChanges() {
    // When selectedViewOption is changed calling the following
    this.filterOrders();
    this.setUpUI();
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

  setUpUI() {
    console.log(this.orders)

    switch (this.selectedViewOption ) {
      case 1:
        this.orderTableHeader = "New"
        this.changeStatusButtonLabel = "Ready";
        this.isStatusButonNeeded = true;
        this.snippetTimeColor = "var(--order-placed-color)"
        break;
      case 2:
        this.orderTableHeader = "Ready for pickup"
        this.changeStatusButtonLabel = "Not Ready";
        this.isStatusButonNeeded = true;
        this.snippetTimeColor = "var(--order-ready-color)"
        break;
      case 3:
        this.orderTableHeader = "Picked up"
        this.isStatusButonNeeded = false;
        this.snippetTimeColor = "var(--order-complete-color)"
        break;
      case 4:
        this.orderTableHeader = "Delivered"
        this.isStatusButonNeeded = false;
        this.snippetTimeColor = "var(--order-complete-color)"
        break;
    }

  }

  updateOrderStatus() {

    let orderStatus: OrderStatus;

    if (this.selectedViewOption == 1) {
      orderStatus = new OrderStatus(2,"Ready");
    } else {
      orderStatus = new OrderStatus(1,"Placed");
    }

    this.selectedOrder!.orderStatusId = orderStatus;

    this.orderService.updateOrder(this.selectedOrder!).subscribe(data => {
      this.filterOrders()
      this.alertComponent.displayAlert(this.selectedOrder?.userId?.userFirstName + "'s order status updated!", "success");
    })

  }

}
