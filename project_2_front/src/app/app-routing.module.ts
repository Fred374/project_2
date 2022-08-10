import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrdersPt2Component } from './components/orders-pt2/orders-pt2.component';
import { ChooserestaurantComponent } from './components/chooserestaurant/chooserestaurant.component';
import { OrdersComponent } from './components/orders/orders.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { MoodforwhatComponent } from './components/moodforwhat/moodforwhat.component';
import { RestaurantOrdersComponent } from './components/restaurant-orders/restaurant-orders.component';

const routes: Routes = [
  {path: "orders", component: OrdersComponent},
  {path: "mood", component: MoodforwhatComponent},
  {path: "restaurant/orders", component: RestaurantOrdersComponent},
  {path: "chooseRestaurant", component: ChooserestaurantComponent},
  {path: "registration", component: RegistrationComponent},
  {path: "ordersPt2", component: OrdersPt2Component}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
