import { Component } from '@angular/core';
import {LoginService} from "./services/login.service";
import {UserRequest} from "./models/UserRequest";
import {Observable} from "rxjs";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor() {
  }
  
}
