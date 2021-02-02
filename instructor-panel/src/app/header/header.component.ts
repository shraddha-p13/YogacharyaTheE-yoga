import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Subscription } from 'rxjs';
import { LoginEventEmmiterService } from '../services/login-event-emmiter.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  clickEventsubscription!: Subscription;
  showUserInformation: boolean = false;
  userDetails: any;

  isUserLogin: boolean = false;
  constructor(private loginEventService: LoginEventEmmiterService, private router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
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
    this.router.navigate(['/login']);
    this.toastr.success('Logout Successfully', 'Success');
  }

}
