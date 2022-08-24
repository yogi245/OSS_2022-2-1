package com.upc.conversion.negocio;

import com.upc.conversion.entidades.TpCliente;
import com.upc.conversion.repositorio.ClienteRepositorio;
import com.upc.conversion.repositorio.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Negocio {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Transactional(rollbackFor = Exception.class) //two face commit
    public TpCliente grabar(TpCliente tpCliente){
        return clienteRepositorio.save(tpCliente);
    }

}
