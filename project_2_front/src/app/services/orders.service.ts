import { HttpClient, HttpResponse } from '@angular/common/http'
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FoodItem } from '../models/food-item';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  constructor(private http: HttpClient) { }

  getFood(resId: number): Observable<HttpResponse<FoodItem[]>> {
    return this.http.get("localhost:4009/food/food_item/" + resId, { observe: "response" }) as Observable<HttpResponse<FoodItem[]>>;
  }

}
