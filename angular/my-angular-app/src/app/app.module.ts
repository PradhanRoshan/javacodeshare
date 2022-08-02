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
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ListViewAllModule } from '@syncfusion/ej2-angular-lists';
import { TextBoxAllModule } from '@syncfusion/ej2-angular-inputs';
import { DropDownListModule } from '@syncfusion/ej2-angular-dropdowns';
import { SidebarModule, MenuAllModule, TreeViewAllModule, ToolbarAllModule} from '@syncfusion/ej2-angular-navigations';
import { RadioButtonModule, ButtonModule } from '@syncfusion/ej2-angular-buttons';
import { EmployeeComponent } from './components/employee/employee/employee.component';
import { EmployeeStatComponent } from './components/employee/employee-stat/employee-stat.component';
import { EmployeeListComponentRxjs } from './components/employee/employee-list/employee-list.component';
import { EmployeeAddComponentRxjs } from './components/employee/employee-add/employee-add.component';
import { LoginComponent } from './auth/component/login/login.component';

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
    CategoryComponent,
    EmployeeComponent,
    EmployeeStatComponent,
    EmployeeListComponentRxjs,
    EmployeeAddComponentRxjs,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    SidebarModule,
    ToolbarAllModule,
    TextBoxAllModule,
    RadioButtonModule,
    MenuAllModule,
    ButtonModule,
    TreeViewAllModule,
    ListViewAllModule,
    DropDownListModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
