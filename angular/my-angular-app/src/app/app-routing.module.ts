import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/component/login/login.component';
import { AuthguardService } from './auth/service/authguard.service';
import { CategoryComponent } from './components/category/category.component';
import { CommentsComponent } from './components/comments/comments.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { EmployeeComponent } from './components/employee/employee/employee.component';
import { PostComponent } from './components/post/post.component';
import { ProductComponent } from './components/product/product.component';

const routes: Routes = [
  {path:'' ,component: DashboardComponent},
  {path:'login' ,component: LoginComponent},
  {path:'dashboard' ,component: DashboardComponent},
  {path:'posts' ,component: PostComponent},
  {path:'comments/:postId', component: CommentsComponent},
  {path: 'products' , component: ProductComponent},
  {path: 'category' , component: CategoryComponent},
  {path: 'employee' , component: EmployeeComponent,
                    canActivate:[AuthguardService]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
