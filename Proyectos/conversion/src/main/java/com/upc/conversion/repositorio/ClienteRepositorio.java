package com.upc.conversion.repositorio;

import com.upc.conversion.entidades.TpCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<TpCliente,Long> {
}
