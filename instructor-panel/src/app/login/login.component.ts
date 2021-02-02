import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { LoginEventEmmiterService } from '../services/login-event-emmiter.service';
import { LoginDetails } from './model/LoginDetails';
import { LoginService } from './service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm!: FormGroup;
  submitted = false;
  loginDetails!: LoginDetails;
  isLoggedIn: boolean = false;
  constructor(private formBuilder: FormBuilder, private loginService: LoginService, private toastr: ToastrService, private router: Router, private loginEventEmmiterService: LoginEventEmmiterService) { }


  ngOnInit(): void {
    this.loginForm = this.formBuilder.group(
      {
        email: ["", [Validators.required, Validators.email]],
        password: ["", [Validators.required, Validators.minLength(6)]]
      });
  }

  onSubmit() {
    this.submitted = true;

    if (this.loginForm.invalid) {
      console.log("Invalid form");
      this.loginForm.markAllAsTouched();
      return;
    }

    let email = this.loginForm.value.email;
    let password = this.loginForm.value.password;
    this.loginDetails = new LoginDetails(email, password)
    this.loginService.login(this.loginDetails).subscribe(data => {
      this.loginForm.reset();
      localStorage.setItem('userDetails', JSON.stringify(data));
      this.isLoggedIn = true;
      localStorage.setItem('isLoggedIn', JSON.stringify(this.isLoggedIn));
      this.loginEventEmmiterService.sendClickEvent();
      this.router.navigate(['/profile']);
    },
      error => {
        this.toastr.error(error.error.message, 'Login Error');
      });
  }

}
