import { HttpClient, HttpResponse } from '@angular/common/http'
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FoodItem } from '../models/food-item';
import { Orders } from '../models/orders';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  constructor(private http: HttpClient) { }

  getFood(restaurant_id: number): Observable<HttpResponse<FoodItem>> {
    return this.http.get("", { observe: "response" }) as Observable<HttpResponse<FoodItem>>;
  }


}
