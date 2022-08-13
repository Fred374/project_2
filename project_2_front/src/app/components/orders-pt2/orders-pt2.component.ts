import { Component, OnInit } from '@angular/core';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-orders-pt2',
  templateUrl: './orders-pt2.component.html',
  styleUrls: ['./orders-pt2.component.css']
})
export class OrdersPt2Component implements OnInit {

  constructor(public os: OrdersService) { }

  ngOnInit(): void {
  }

}
