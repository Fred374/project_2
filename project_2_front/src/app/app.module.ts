import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OrdersComponent } from './components/orders/orders.component';
import { ChooserestaurantComponent } from './chooserestaurant/chooserestaurant.component';
import { MoodforwhatComponent } from './moodforwhat/moodforwhat.component';

@NgModule({
  declarations: [
    AppComponent,
    OrdersComponent,
    ChooserestaurantComponent,
    MoodforwhatComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
