package com.upc.productos.repositorio;

import com.upc.productos.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // opcional
public interface ProductoRepositorio extends JpaRepository<Producto,Long> {
}
