import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FoodItem } from 'src/app/models/food-item';
import { User } from 'src/app/models/user';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-add-food',
  templateUrl: './add-food.component.html',
  styleUrls: ['./add-food.component.css']
})
export class AddFoodComponent implements OnInit {

  user = JSON.parse(localStorage.getItem("currentUser") || "{}");
  resId = this.user.userLastName;

  public foodItemArr: FoodItem[] = [];

  public foodItem: FoodItem = {
    foodItemId: 0,
    foodItemName: "",
    foodItemCost: 0,
    restaurantIdFk: this.resId
  };

  constructor(private os: OrdersService, private router: Router) { }

  getFoods() {
    this.os.getFood(this.resId).subscribe(
      (data: any) => {
        this.foodItemArr = data.body;
      }
    );
  }

  addFood() {
    console.log(this.foodItem);
    this.os.addFood(this.foodItem).subscribe(
      (data: any) => {
        alert("Menu Item has been added");
        this.foodItem = {
          foodItemId: 0,
          foodItemName: "",
          foodItemCost: 0,
          restaurantIdFk: this.resId
        };
        this.getFoods();
      }, () => {
        alert("An error occured.");
      }
    );
  }

  ngOnInit(): void {
    this.getFoods();
  }

}
