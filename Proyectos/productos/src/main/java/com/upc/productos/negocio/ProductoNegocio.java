package com.upc.productos.negocio;

import com.upc.productos.entidades.Producto;
import com.upc.productos.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoNegocio {
   //Inyectando Repositorio
    @Autowired
    private ProductoRepositorio productoRepositorio;

    public Producto registrar(Producto producto){
        return productoRepositorio.save(producto);
    }

}
