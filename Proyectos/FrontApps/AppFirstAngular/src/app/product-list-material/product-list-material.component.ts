import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {Product} from "../model/product";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {MatTableDataSource} from "@angular/material/table";
import { ProductoService } from '../service/producto.service';


@Component({
  selector: 'app-product-list-material',
  templateUrl: './product-list-material.component.html',
  styleUrls: ['./product-list-material.component.css']
})
export class ProductListMaterialComponent implements OnInit, AfterViewInit {

  displayedColumns =["id", "descripcion", "precio", "stock", "total"];
  dataSource =  new MatTableDataSource<Product>();

  @ViewChild(MatPaginator, {static:true} ) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(productService: ProductoService) {
    productService.getProductList().subscribe(products => this.dataSource.data = products);
    console.log("Load Products");
  }

  ngOnInit(): void {
   this.dataSource.paginator = this.paginator;
  }

  ngAfterViewInit(): void {
   this.dataSource.sort = this.sort;
  }
}
