import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HealthyRecipesComponent } from './healthy-recipes/healthy-recipes.component';
import { SpecialDietComponent } from './special-diet/special-diet.component';
import { AboutComponent } from './about/about.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { BlogsComponent } from './blogs/blogs.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { ToastrModule } from 'ngx-toastr';
import { HealthyRecipes2Component } from './healthy-recipes2/healthy-recipes2.component';
import { HealthyRecipes3Component } from './healthy-recipes3/healthy-recipes3.component';
import { HealthyRecipes4Component } from './healthy-recipes4/healthy-recipes4.component';
import { HealthyRecipes1Component } from './healthy-recipes1/healthy-recipes1.component';
import { HealthyRecipes5Component } from './healthy-recipes5/healthy-recipes5.component';
import { SpecialDiet1Component } from './special-diet1/special-diet1.component';
import { SpecialDiet2Component } from './special-diet2/special-diet2.component';
import { SpecialDiet3Component } from './special-diet3/special-diet3.component';
import { SpecialDiet4Component } from './special-diet4/special-diet4.component';
import { SpecialDiet5Component } from './special-diet5/special-diet5.component';
import { Blog1Component } from './blog1/blog1.component';
import { Blog2Component } from './blog2/blog2.component';
import { Blog3Component } from './blog3/blog3.component';
import { AfterLoginComponent } from './after-login/after-login.component';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HealthyRecipesComponent,
    SpecialDietComponent,
    AboutComponent,
    ContactUsComponent,
    RegisterComponent,
    HomeComponent,
    LoginComponent,
    BlogsComponent,
    HealthyRecipes2Component,
    HealthyRecipes3Component,
    HealthyRecipes4Component,
    HealthyRecipes1Component,
    HealthyRecipes5Component,
    SpecialDiet1Component,
    SpecialDiet2Component,
    SpecialDiet3Component,
    SpecialDiet4Component,
    SpecialDiet5Component,
    Blog1Component,
    Blog2Component,
    Blog3Component,
    AfterLoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    NgMultiSelectDropDownModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
