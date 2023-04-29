import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import {Injectable} from '@angular/core';
import { LoginService } from "./login.service";
import { Observable } from 'rxjs';

@Injectable()
export class AuthInterceptor implements HttpInterceptor{

  constructor(private loginService:LoginService){}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    const isLogged = this.loginService.isLoggedIn();
    const token = this.loginService.getToken();
    const isApiUrl = request.url.startsWith("http://localhost:8080")

    console.log(isApiUrl);

    if (isLogged && isApiUrl) {
      request = request.clone({
          setHeaders: {
              Authorization: `Bearer ${token}`
          }
      });
  }

    return next.handle(request);
  }
}
