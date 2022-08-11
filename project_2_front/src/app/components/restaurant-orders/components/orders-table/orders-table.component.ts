import { Component, Input, OnInit } from '@angular/core';
import { Order } from 'src/app/models/order';

@Component({
  selector: 'app-orders-table',
  templateUrl: './orders-table.component.html',
  styleUrls: ['./orders-table.component.css']
})
export class OrdersTableComponent implements OnInit {

  @Input() orders : Order[] = [];

  constructor() { }

  ngOnInit(): void {
  }

}
