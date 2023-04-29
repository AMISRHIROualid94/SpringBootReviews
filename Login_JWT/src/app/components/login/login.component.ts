import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{


loginForm:FormGroup
userRequest = {
  username:"",
  password:""
}

constructor(private formBuilder:FormBuilder,
    private loginService:LoginService){

  }


  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
  });
  }

  get f() { return this.loginForm.controls; }


  onSubmit(){
    this.userRequest.username = this.f['username'].value
    this.userRequest.password = this.f['password'].value
    if (this.loginForm.valid) {
      console.log("the Forme is submitted!");
      //generate token
      this.loginService.generateToken(this.userRequest).subscribe(
        (token:any) =>{
          this.loginService.loginUser(token);
          window.location.href="/dashboard";
      });
    }else{
      console.log("Fields are empty!!");
    }
  }
}
