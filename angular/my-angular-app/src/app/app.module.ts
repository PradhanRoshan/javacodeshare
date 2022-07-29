import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CalcComponent } from './components/calc/calc.component';
import { ArrayComponent } from './components/array/array.component';
import { AddressComponent } from './components/address/address.component';
import { EmployeeListComponent } from './components/employee-list/employee-list.component';
import { EmployeeAddComponent } from './components/employee-add/employee-add.component';
import { EmployeeAddReactiveComponent } from './components/employee-add-reactive/employee-add-reactive.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PostComponent } from './components/post/post.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { CommentsComponent } from './components/comments/comments.component';
import {HttpClientModule} from '@angular/common/http';
import { ProductComponent } from './components/product/product.component';
import { CategoryComponent } from './components/category/category.component';

@NgModule({
  declarations: [
    AppComponent,
    CalcComponent,
    ArrayComponent,
    AddressComponent,
    EmployeeListComponent,
    EmployeeAddComponent,
    EmployeeAddReactiveComponent,
    PostComponent,
    DashboardComponent,
    CommentsComponent,
    ProductComponent,
    CategoryComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
