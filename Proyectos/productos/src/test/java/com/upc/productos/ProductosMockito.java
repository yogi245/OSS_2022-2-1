package com.upc.productos;

import com.upc.productos.entidades.Producto;
import com.upc.productos.negocio.ProductoNegocio;
import com.upc.productos.repositorio.ProductoRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductosMockito {
     @Autowired
     private ProductoNegocio productoNegocio;
     @MockBean
     private ProductoRepositorio productoRepositorio;

     @Test
     void registrarTest(){
          Producto producto = new Producto(3L, "Fresa", 12, 12);
          when(productoRepositorio.save(producto)).thenReturn(producto);
          Assertions.assertEquals(producto,productoNegocio.registrar(producto));
     }

     @Test
     void calcularPrecioVentaTest(){
          Producto producto = new Producto(3L, "Fresa", 12, 12);
          when(productoRepositorio.findById(3L)).thenReturn(Optional.of(producto));
          try {
               double precioVenta = productoNegocio.calcularPrecioVenta(3L);
               Assertions.assertEquals(14.16, precioVenta,0.01);
          } catch (Exception e) {
               throw new RuntimeException(e);
          }
     }


}
