import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http'
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FoodItem } from '../models/food-item';
import { Order } from '../models/order';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {


  order: Order = {
    orderCost: 0,
    restaurantIdFk: 0,
    orderItems: [],
  };

  httpOptions = {

    headers: new HttpHeaders({
      'Access-Control-Allow-Origin': '*'
    })
  };

  constructor(private http: HttpClient) { }

  getFood(resId: number): Observable<HttpResponse<FoodItem[]>> {
    //console.log(this.http.get("http://localhost:4009/food/food-item/" + resId, this.httpOptions) as Observable<HttpResponse<FoodItem[]>>);

    return this.http.get("http://localhost:4009/food/food-item/" + resId, { observe: "response" }) as Observable<HttpResponse<FoodItem[]>>;
  }

  getOrdersForRestaurant(resId: number): Observable<HttpResponse<Order[]>> {

    let orders = this.http.get("http://localhost:4009/food/order/for-restaurant/" + resId, { observe: "response" }) as Observable<HttpResponse<Order[]>>;
    // console.log(orders)
    return orders;
  }

  getOrdersByStatus(orderStatus: number): Observable<HttpResponse<Order[]>> {
    let orders = this.http.get("http://localhost:4009/food/order/ready/" + orderStatus, { observe: "response" }) as Observable<HttpResponse<Order[]>>;
    return orders;
  }

  public sendOrder(order: Order): Observable<Order> {
    let standinValue = 1; // standinValue for user
    return this.http.post<Order>("http://localhost:4009/food/order/" + standinValue + "/1", order, this.httpOptions);
  }

  public addFood(foodItem: FoodItem): Observable<FoodItem> {
    return this.http.post<FoodItem>("http://localhost:4009/food/food-item/", foodItem, this.httpOptions);
  }

  public updateOrder(updatedOrder: Order): Observable<Order> {
    return this.http.put<Order>("http://localhost:4009/food/order/update", updatedOrder, this.httpOptions);
  }

}
