import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InstructorComponent } from './instructor/instructor.component';
import { TraineeComponent } from './trainee/trainee.component';
import { CoursesComponent } from './courses/courses.component';
import { LogoutComponent } from './logout/logout.component';
import { LoginComponent } from './login/login.component';
import { AddCourseComponent } from './add-course/add-course.component';
import { AddInstructorComponent } from './add-instructor/add-instructor.component';


const routes: Routes = [
  {
    path: " ", redirectTo: "login", pathMatch: "full"
  },
  {
    path: "login", component: LoginComponent
  },
  {
    path: "instructor", component: InstructorComponent
  },
  {
    path: "trainee", component: TraineeComponent
  },
  {
    path: "courses", component: CoursesComponent
  },
  {
    path: "logout", component: LogoutComponent
  },
  {
    path: "add-course", component: AddCourseComponent
  },
  {
    path: "add-instructor", component: AddInstructorComponent
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
