import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { ProfileComponent } from './profile/profile.component';

const routes: Routes = [
  {
    path: " ", redirectTo: "login", pathMatch: "full"
  },
  {
    path: "profile", component: ProfileComponent
  },
  {
    path: "login", component: LoginComponent
  },
  {
    path: "logout", component: LogoutComponent
  },
  {
    path: "**", component: LoginComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
