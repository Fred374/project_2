import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OrdersComponent } from './components/orders/orders.component';
import { ChooserestaurantComponent } from './components/orders/chooserestaurant/chooserestaurant.component';
import { MoodforwhatComponent } from './moodforwhat/moodforwhat.component';
import { RestaurantOrdersComponent } from './restaurant-orders/restaurant-orders.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RestaurantmenuComponent } from './components/orders/restaurantmenu/restaurantmenu.component';

@NgModule({
  declarations: [
    AppComponent,
    OrdersComponent,
    ChooserestaurantComponent,
    MoodforwhatComponent,
    RestaurantOrdersComponent,
    NavbarComponent,
    RestaurantmenuComponent
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
