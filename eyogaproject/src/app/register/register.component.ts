import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { first } from 'rxjs/operators';
import {
  ComparePassword,
} from "../customvalidator/customvalidator.validator";
import { LoginEventEmmiterService } from '../services/login-event-emmiter.service';
import { YogaService } from '../services/yoga.service';
import { UserDetails } from './model/UserDetails';
import { RegisterService } from './service/register.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
  registerForm!: FormGroup;
  submitted = false;
  userDetails!: UserDetails;
  isLoggedIn: boolean = false;

  constructor(private formBuilder: FormBuilder, private registerService: RegisterService, private loginEventEmmiterService: LoginEventEmmiterService, private router: Router, private toastr: ToastrService) { }

  ngOnInit() {

    this.registerForm = this.formBuilder.group(
      {
        firstName: ["", [Validators.required, ValidateFirstName]],
        lastName: ["", [Validators.required, ValidateLastName]],
        email: ["", [Validators.required, Validators.email]],
        contactNumber: ["", [Validators.required]],
        password: ["", [Validators.required, Validators.minLength(6)]]
      },
      {
        // Used custom form validator name
        //validator: ComparePassword("password", "confirmPassword")
      }
    );
  }

  get f() {
    return this.registerForm.controls;
  }

  onSubmit() {
    this.submitted = true;

    // Returns false if form is invalid
    if (this.registerForm.invalid) {
      console.log("Invalid form");
      this.registerForm.markAllAsTouched();
      return;
    }

    let firstName = this.registerForm.value.firstName;
    let lastName = this.registerForm.value.lastName;
    let email = this.registerForm.value.email;
    let contactNumber = this.registerForm.value.contactNumber;
    let password = this.registerForm.value.password;
    this.userDetails = new UserDetails(firstName, lastName, email, contactNumber, password);

    this.registerService.registerUser(this.userDetails).subscribe(data => {
      //this.registerForm.reset();
      localStorage.setItem('userDetails', JSON.stringify(data));
      this.isLoggedIn = true;
      localStorage.setItem('isLoggedIn', JSON.stringify(this.isLoggedIn));
      this.loginEventEmmiterService.sendClickEvent();
      this.router.navigate(['/after-login']);
    },
      error => {
        this.toastr.error(error.error.message, 'Registration Error');
      });

  }

}

// To validate first name
export function ValidateFirstName(control: AbstractControl) {
  // if (!control.value.startsWith("@")) {
  //   return { validFname: true };
  // }
  // return null;
  if (control.value.length <= 3) {
    return { validFname: true };
  }
  return null;
}

// To validate last name
export function ValidateLastName(control: AbstractControl) {
  if (control.value.length <= 3) {
    return { validLname: true };
  }
  return null;
}

