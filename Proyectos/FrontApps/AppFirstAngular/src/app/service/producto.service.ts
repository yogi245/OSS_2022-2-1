import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http' // importar a mano
import { map, Observable } from 'rxjs';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  URL_SERVICES = 'http://localhost:8080'
  private urlBase = this.URL_SERVICES + "/api";
  private httpHeaders = new HttpHeaders({'Content-type' : 'application/json'});
  //inyectar http y reegistrarlo en app.module.ts
  constructor(private http: HttpClient) { }

  getProductList() : Observable<any> {
    console.log("Llamando a REST:" + this.urlBase + "/productosVentas");
    return this.http.get(this.urlBase + '/productosVentas').
                         pipe(map(response => response as Product[]));
  }
}
