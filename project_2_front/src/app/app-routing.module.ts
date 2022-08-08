import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChooserestaurantComponent } from './chooserestaurant/chooserestaurant.component';
import { OrdersComponent } from './components/orders/orders.component';
import { MoodforwhatComponent } from './moodforwhat/moodforwhat.component';
import { RestaurantOrdersComponent } from './restaurant-orders/restaurant-orders.component';

const routes: Routes = [
  {path: "orders", component: OrdersComponent},
  {path: "mood", component: MoodforwhatComponent},
  {path: "restaurant/orders", component: RestaurantOrdersComponent},
  {path: "chooseRestaurant", component: ChooserestaurantComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
