import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard {

constructor(private loginService:LoginService,
  private router:Router){}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

      let isLoggedIn:boolean  = this.loginService.isLoggedIn();
      if(!isLoggedIn){
        this.router.navigate(['login'])
      }

      return isLoggedIn;
  }

}
