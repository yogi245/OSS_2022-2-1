package com.upc.productos;

import com.upc.productos.entidades.Producto;
import com.upc.productos.negocio.ProductoNegocio;
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
	public void probarRegistro(){
		Producto producto = new Producto();
		producto.setDescripcion("Fanta");
		producto.setPrecio(3);
		producto.setStock(10);
		productoNegocio.registrar(producto);
	}

}
