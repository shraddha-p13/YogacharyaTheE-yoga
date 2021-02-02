import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { BlogsComponent } from './blogs/blogs.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { HealthyRecipesComponent } from './healthy-recipes/healthy-recipes.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { SpecialDietComponent } from './special-diet/special-diet.component';
import { HealthyRecipes1Component } from './healthy-recipes1/healthy-recipes1.component'
import { HealthyRecipes2Component } from './healthy-recipes2/healthy-recipes2.component'
import { HealthyRecipes3Component } from './healthy-recipes3/healthy-recipes3.component'
import { HealthyRecipes4Component } from './healthy-recipes4/healthy-recipes4.component'
import { HealthyRecipes5Component } from './healthy-recipes5/healthy-recipes5.component'
import { SpecialDiet1Component } from './special-diet1/special-diet1.component'
import { SpecialDiet2Component } from './special-diet2/special-diet2.component'
import { SpecialDiet3Component } from './special-diet3/special-diet3.component'
import { SpecialDiet4Component } from './special-diet4/special-diet4.component'
import { SpecialDiet5Component } from './special-diet5/special-diet5.component'
import { Blog1Component } from './blog1/blog1.component'
import { Blog2Component } from './blog2/blog2.component'
import { Blog3Component } from './blog3/blog3.component'
import { AfterLoginComponent } from './after-login/after-login.component'

const routes: Routes = [
  {
    path: " ", redirectTo: "home", pathMatch: "full"
  },
  {
    path: "blog1", component: Blog1Component
  },
  {
    path: "blog2", component: Blog2Component
  },
  {
    path: "blog3", component: Blog3Component
  },
  {
    path: "healthy-recipes", component: HealthyRecipesComponent
  },
  {
    path: "healthy-recipes1", component: HealthyRecipes1Component
  },
  {
    path: "healthy-recipes2", component: HealthyRecipes2Component
  },
  {
    path: "healthy-recipes3", component: HealthyRecipes3Component
  },
  {
    path: "healthy-recipes4", component: HealthyRecipes4Component
  },
  {
    path: "healthy-recipes5", component: HealthyRecipes5Component
  },
  {
    path: "special-diet", component: SpecialDietComponent
  },
  {
    path: "special-diet1", component: SpecialDiet1Component
  },
  {
    path: "special-diet2", component: SpecialDiet2Component
  },
  {
    path: "special-diet3", component: SpecialDiet3Component
  },
  {
    path: "special-diet4", component: SpecialDiet4Component
  },
  {
    path: "special-diet5", component: SpecialDiet5Component
  },
  {
    path: "register", component: RegisterComponent
  },
  {
    path: "about", component: AboutComponent
  },
  {
    path: "contact-us", component: ContactUsComponent
  },
  {
    path: "home", component: HomeComponent
  },
  {
    path: "login", component: LoginComponent
  },
  {
    path: "blogs", component: BlogsComponent
  },
  {
    path: "after-login", component: AfterLoginComponent
  },
  {
    path: "**", component: HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
