import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../model/product';
import { ProductoService } from '../service/producto.service';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {

  product: Product = new Product();

  constructor(private productService: ProductoService , private router: Router) { }

  ngOnInit(): void {

  }

  save(){
    console.log(this.product);
    this.productService.createProduct(this.product).subscribe(
      data => this.router.navigate(['/list']) //asíncrono
    );
    console.log("continuando..")
 }

}
