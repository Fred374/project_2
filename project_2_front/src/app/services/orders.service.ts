import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http'
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FoodItem } from '../models/food-item';
import { Order } from '../models/order';
import { Restaurant } from '../models/restaurant';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {


  order: Order = {
    orderCost: 0,
    restaurantIdFk: 0,
    orderItems: [],
  };

  public resId = 0;
  userId = 0;

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
    return this.http.post<Order>("http://localhost:4009/food/order/" + this.userId + "/1", order, this.httpOptions);
  }

  public addFood(foodItem: FoodItem): Observable<FoodItem> {
    return this.http.post<FoodItem>("http://localhost:4009/food/food-item/", foodItem, this.httpOptions);
  }

  public updateOrder(updatedOrder: Order): Observable<Order> {
    return this.http.put<Order>("http://localhost:4009/food/order/update", updatedOrder, this.httpOptions);
  }

  public getRes(): Observable<HttpResponse<any>> {
    let httpOptions2 = {

      headers: new HttpHeaders({
        'Access-Control-Allow-Origin': '*',
        'content-type': 'application/x-www-form-urlencoded',
        'X-RapidAPI-Key': 'e4bdc59af0msh8b5b1607a363681p115b5ajsnc094041f20b8',
        'X-RapidAPI-Host': 'worldwide-restaurants.p.rapidapi.com'
      })
    };
    return this.http.post("https://worldwide-restaurants.p.rapidapi.com/search",
      "language=en_US&limit=30&location_id=" + this.resId + "&currency=USD", httpOptions2) as Observable<HttpResponse<any>>;
  }

}
