import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})



export class UserService {

  baseURL: string = "http://localhost:4009/food/user";

  // we need HttpClient in order to make requests
  constructor(private http: HttpClient) { }

  httpOptions = {
  headers: new HttpHeaders({ 
    'Access-Control-Allow-Origin':'*',
    'Authorization':'authkey',
    'userid':'1'
  })
};

  // post request to insert a new user into backend
  public createUser(user: User, id:number): Observable<User> {
    return this.http.post<User>(this.baseURL + "/register/" + id, user, this.httpOptions);
  }

}