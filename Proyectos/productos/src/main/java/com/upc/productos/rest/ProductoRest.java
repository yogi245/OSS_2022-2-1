package com.upc.productos.rest;

import com.upc.productos.entidades.Producto;
import com.upc.productos.negocio.ProductoNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductoRest {

    @Autowired
    private ProductoNegocio productoNegocio;

    @PostMapping("/producto")
    public Producto registrar(@RequestBody Producto producto){
        return productoNegocio.registrar(producto);
    }
    @GetMapping("/productos")
    public List<Producto> listar() {
        return productoNegocio.listado();
    }
    @GetMapping("/producto/{codigo}")
    public Producto buscar(@PathVariable(value = "codigo") Long codigo){
        try {
            return productoNegocio.buscar(codigo);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe", e);
        }
    }
    @DeleteMapping("/producto/{codigo}")
    public boolean borrar(@PathVariable(value = "codigo") Long codigo){
        try {
            return productoNegocio.borrar(codigo);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se borró", e);
        }
    }
    @GetMapping("/producto/precioVenta/{codigo}")
    public double calcularPrecioVenta(@PathVariable(value = "codigo") Long codigo){
        try {
            return productoNegocio.calcularPrecioVenta(codigo);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede calcular", e);
        }
    }

}
