import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http'
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FoodItem } from '../models/food-item';
import { Order } from '../models/order';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  httpOptions = {
    
    headers: new HttpHeaders({ 
      'Access-Control-Allow-Origin':'*'
    })
  };

  constructor(private http: HttpClient) { }

  getFood(resId: number): Observable<HttpResponse<FoodItem[]>> {
    //console.log(this.http.get("http://localhost:4009/food/food_item/" + resId, this.httpOptions) as Observable<HttpResponse<FoodItem[]>>);
    
    return this.http.get("http://localhost:4009/food/food_item/" + resId, {observe: "response"}) as Observable<HttpResponse<FoodItem[]>>;
  }

  getOrdersForRestaurant(resId: number): Observable<HttpResponse<Order[]>> {

    let orders = this.http.get("localhost:4009/food/order/for-restaurant/" + resId, {observe: "response"}) as Observable<HttpResponse<Order[]>>;
    console.log(orders)
    return orders;
  }

}
