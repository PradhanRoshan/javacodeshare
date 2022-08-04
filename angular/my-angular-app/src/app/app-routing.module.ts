import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/component/login/login.component';
import { LogoutComponent } from './auth/component/logout/logout.component';
import { ProfileComponent } from './auth/component/profile/profile.component';
import { SignUpComponent } from './auth/component/sign-up/sign-up.component';
import { AuthguardService } from './auth/service/authguard.service';
import { CategoryComponent } from './components/category/category.component';
import { CommentsComponent } from './components/comments/comments.component';
import { CountryComponent } from './components/country/country.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { EmployeeComponent } from './components/employee/employee/employee.component';
import { PostComponent } from './components/post/post.component';
import { ProductComponent } from './components/product/product.component';
import { VendorComponent } from './components/vendor/vendor.component';

const routes: Routes = [
  {path:'' ,component: DashboardComponent},
  {path:'login' ,component: LoginComponent},
  {path:'dashboard' ,component: DashboardComponent},
  {path:'posts' ,component: PostComponent},
  {path:'comments/:postId', component: CommentsComponent},
  {path: 'products' , component: ProductComponent},
  {path: 'category' , component: CategoryComponent},
  {path: 'vendor' , component: VendorComponent},
  {path: 'cities' , component: CountryComponent},
  {path: 'employee' , component: EmployeeComponent,
                    canActivate:[AuthguardService]},
  {path:'logout' ,component: LogoutComponent},
  {path:'sign-up' ,component: SignUpComponent},
  {path:'profile' ,component: ProfileComponent,
                  canActivate:[AuthguardService] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
