import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit{


  constructor(private loginService:LoginService){}


  ngOnInit(): void {

  }

  getDetails(){
    this.loginService.getAllUsers().subscribe(details=>{
      console.log(details);
      
    })
  }
}
