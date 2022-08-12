import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-chooserestaurant',
  templateUrl: './chooserestaurant.component.html',
  styleUrls: ['./chooserestaurant.component.css']
})
export class ChooserestaurantComponent implements OnInit {

  constructor(private os: OrdersService, private router: Router) { }

  setRestaurant(resId: number) {
    this.os.resId = resId;
    this.router.navigate(['/orders']);
  }

  ngOnInit(): void {
  }

}
