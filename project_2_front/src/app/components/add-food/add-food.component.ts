import { Component, OnInit } from '@angular/core';
import { FoodItem } from 'src/app/models/food-item';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-add-food',
  templateUrl: './add-food.component.html',
  styleUrls: ['./add-food.component.css']
})
export class AddFoodComponent implements OnInit {

  public foodItem : FoodItem = {
    foodItemId : 0,
    foodItemName : "",
    foodItemCost : 0,
    restaurantIdFk : 4966752
  }

  constructor(private os: OrdersService) { }

  addFood() {
    console.log(this.foodItem);
    this.os.addFood(this.foodItem).subscribe(
      (data: any) => {
        this.foodItem = data;
        console.log(this.foodItem);
        alert("Menu Item has been added");
      }, () => {
        alert("An error occured.");
      }
    );
  }

  ngOnInit(): void {
  }

}
