import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/components/login/login.component';
import { SignUpComponent } from './auth/components/sign-up/sign-up.component';
import { CartComponent } from './cart/components/cart/cart.component';
import { MasterComponent } from './dashboard/components/master/master.component';

const routes: Routes = [
  {path:'' ,component: LoginComponent},
  {path:'sign-up' ,component: SignUpComponent},
  {path:'dashboard' ,component: MasterComponent},
  {path:'cart' ,component: CartComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
