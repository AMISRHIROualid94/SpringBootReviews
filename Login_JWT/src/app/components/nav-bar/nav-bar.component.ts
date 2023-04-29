import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit{

  public loggedIn = false;

  constructor(private loginService:LoginService,private router:Router){}

  ngOnInit(): void {
    this.loggedIn = this.loginService.isLoggedIn()
  }

  logout(){
    this.loginService.logout()
    window.location.href="/dashboard"

  }
}
