import { Component, OnInit } from '@angular/core';
import { Product } from '../model/product';
import { ProductoService } from '../service/producto.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products : Product[];

  constructor(private productService:ProductoService) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData(){
    console.log("Reload!");
    this.productService.getProductList().subscribe(products => this.products);
  }

}
