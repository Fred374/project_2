import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OrdersComponent } from './components/orders/orders.component';
import { ChooserestaurantComponent } from './components/chooserestaurant/chooserestaurant.component';
import { MoodforwhatComponent } from './components/moodforwhat/moodforwhat.component';
import { RestaurantOrdersComponent } from './components/restaurant-orders/restaurant-orders.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RestaurantmenuComponent } from './components/restaurantmenu/restaurantmenu.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { OrdersTableComponent } from './components/restaurant-orders/components/orders-table/orders-table.component';
import { RestSideNavComponent } from './components/restaurant-orders/components/rest-side-nav/rest-side-nav.component';
import { OrdersPt2Component } from './components/orders-pt2/orders-pt2.component';
import { LoginComponent } from './components/login/login.component';
import { AddFoodComponent } from './components/add-food/add-food.component';
import { DriverOrdersComponent } from './components/driver-orders/driver-orders.component';
import { BreakfastandbrunchComponent } from './components/breakfastandbrunch/breakfastandbrunch.component';
import { JuiceandsmoothieComponent } from './components/juiceandsmoothie/juiceandsmoothie.component';
import { SushiComponent } from './components/sushi/sushi.component';
import { SpinnerComponent } from './components/shared/spinner/spinner.component';
import { AlertComponent } from './components/shared/alert/alert.component';

@NgModule({
  declarations: [
    AppComponent,
    OrdersComponent,
    ChooserestaurantComponent,
    MoodforwhatComponent,
    RestaurantOrdersComponent,
    NavbarComponent,
    RestaurantmenuComponent,
    RegistrationComponent,
    OrdersTableComponent,
    RestSideNavComponent,
    OrdersPt2Component,
    LoginComponent,
    AddFoodComponent,
    DriverOrdersComponent,
    BreakfastandbrunchComponent,
    JuiceandsmoothieComponent,
    SushiComponent,
    SpinnerComponent,
    AlertComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
