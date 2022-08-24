package com.upc.conversion.repositorio;

import com.upc.conversion.entidades.TpPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositorio extends JpaRepository<TpPedido,Long> {
}
