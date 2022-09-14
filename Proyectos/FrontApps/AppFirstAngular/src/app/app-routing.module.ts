import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateProductComponent } from './create-product/create-product.component';
import { HomeProductComponent } from './home-product/home-product.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ProductListMaterialComponent } from './product-list-material/product-list-material.component';
import { ProductListComponent } from './product-list/product-list.component';

const routes: Routes = [
  {path:"home", component:HomeProductComponent},
  {path: "list", component:ProductListComponent},
  {path: "material", component:ProductListMaterialComponent},
  {path: "create", component: CreateProductComponent},
  {path: '', redirectTo: '/home', pathMatch:'full'},
  {path:'**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
