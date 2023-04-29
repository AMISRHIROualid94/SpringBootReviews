import { Injectable, SkipSelf } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {UserRequest} from "../models/UserRequest";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  baseUrl = "http://localhost:8080"

  constructor(private http:HttpClient) { }


  generateToken(userRequest:UserRequest):Observable<any>{
    return this.http.post(`${this.baseUrl}/users/authenticate`,userRequest,{  responseType: 'text' as 'json' });
  }

  loginUser(token:any){
    localStorage.setItem("token",token)
    return true;
  }

  getToken(){
    return localStorage.getItem("token")
  }

  isLoggedIn(){
    let token = localStorage.getItem("token");
    return !!token ;
  }

  logout(){
    localStorage.removeItem("token")
    return true;
  }


  ///////////////

  getAllUsers():Observable<any>{
    return this.http.get(`${this.baseUrl}/users/all`);

  }
}
