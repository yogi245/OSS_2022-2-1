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
    public Producto buscar(Long codigo) throws Exception{
        Producto producto;
        producto = productoRepositorio.findById(codigo).orElseThrow(() -> new
                Exception("No se encontró entidad"));
        return producto;
    }
    public double calcularPrecioVenta(Long codigo) throws Exception{
          Producto producto;
          producto = buscar(codigo);
          return calcularPrecioVenta(producto);
    }
    public double calcularDescuento(Producto producto){
        double descuento=0;
        if(producto.getStock()>20){
            descuento = 0.10*producto.getPrecio();
        }
        return descuento;
    }
    public double calcularIGV(Producto producto){
        return producto.getPrecio()*0.18;
    }
    public double calcularPrecioVenta(Producto producto){
        return producto.getPrecio() + calcularIGV(producto) - calcularDescuento(producto);
    }

}
