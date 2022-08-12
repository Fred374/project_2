import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrdersPt2Component } from './components/orders-pt2/orders-pt2.component';
import { ChooserestaurantComponent } from './components/chooserestaurant/chooserestaurant.component';
import { OrdersComponent } from './components/orders/orders.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { MoodforwhatComponent } from './components/moodforwhat/moodforwhat.component';
import { RestaurantOrdersComponent } from './components/restaurant-orders/restaurant-orders.component';
import { LoginComponent } from './components/login/login.component';
import { AddFoodComponent } from './components/add-food/add-food.component';
import { DriverOrdersComponent } from './components/driver-orders/driver-orders.component';
import { BreakfastandbrunchComponent } from './components/breakfastandbrunch/breakfastandbrunch.component';
import { JuiceandsmoothieComponent } from './components/juiceandsmoothie/juiceandsmoothie.component';

const routes: Routes = [
  { path: "orders", component: OrdersComponent },
  { path: "mood", component: MoodforwhatComponent },
  { path: "restaurant/orders", component: RestaurantOrdersComponent },
  { path: "chooseRestaurant", component: ChooserestaurantComponent },
  { path: "registration", component: RegistrationComponent },
  { path: "ordersPt2", component: OrdersPt2Component },
  { path: "login", component: LoginComponent },
  { path: "restaurant/addFood", component: AddFoodComponent },
  { path: "driver/orders", component: DriverOrdersComponent },
  {path: "/breakfast", component:BreakfastandbrunchComponent},
  {path: "/juiceandsmoothie", component:JuiceandsmoothieComponent},
  {path: ""}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
