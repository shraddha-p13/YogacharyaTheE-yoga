import { Component, OnInit } from '@angular/core';
import { LoginEventEmmiterService } from '../services/login-event-emmiter.service';
import { Subscription } from 'rxjs';
import { UserDetails } from '../register/model/UserDetails';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  clickEventsubscription!: Subscription;
  showUserInformation: boolean = false;
  userDetails: any;

  constructor(private loginEventService: LoginEventEmmiterService, private router: Router, private toastr: ToastrService) { }

  ngOnInit() {
    this.showNavIfUserIsLoggedIn();

    this.clickEventsubscription = this.loginEventService.getClickEvent().subscribe(() => {
      this.showNavIfUserIsLoggedIn();
    });
  }

  showNavIfUserIsLoggedIn() {
    let isLoggedIn = localStorage.getItem('isLoggedIn');
    if (isLoggedIn || isLoggedIn != null) {
      this.showUserInformation = true;
      this.loadDetailsForUser();
    } else {
      this.showUserInformation = false;
    }
  }
  loadDetailsForUser() {
    this.userDetails = localStorage.getItem('userDetails');
  }

  logout() {
    localStorage.clear();
    this.showNavIfUserIsLoggedIn();
    this.router.navigate(['/home']);
    this.toastr.success("Logout successfully", 'Success');
  }
}
