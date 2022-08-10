package com.upc.productos.repositorio;

import com.upc.productos.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // opcional
public interface ProductoRepositorio extends JpaRepository<Producto,Long> {
    public List<Producto> findByPrecioIsLessThan(double precio);
    @Query("SELECT p FROM Producto p WHERE p.precio<=:xprecio")
    public List<Producto> listadoxPrecio(@Param("xprecio") double xprecio);
    public List<Producto> findByDescripcionStartingWith(String prefijo);
}
