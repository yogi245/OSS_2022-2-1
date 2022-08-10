package com.upc.productos;

import com.upc.productos.entidades.Producto;
import com.upc.productos.negocio.ProductoNegocio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductosApplicationTests {

	@Autowired
	private ProductoNegocio productoNegocio;

	@Test
	void contextLoads() {
	}
	@Test
	void probarRegistro(){
		Producto producto = new Producto();
		producto.setDescripcion("Leche");
		producto.setPrecio(12);
		producto.setStock(100);
		productoNegocio.registrar(producto);//
	}
	@Test
	void probarCalcularObtenerPrecioVenta(){
		try {
			double pv;
			pv = productoNegocio.calcularPrecioVenta(1L);
			Assertions.assertEquals(3.54,pv,0.01);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
