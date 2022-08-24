package com.upc.conversion;

import com.upc.conversion.entidades.TpCliente;
import com.upc.conversion.negocio.Negocio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConversionApplicationTests {

    @Autowired
    private Negocio negocio;

    @Test
    void contextLoads() {
    }

    @Test
    void probarRegistroCliente(){
        TpCliente cliente = new TpCliente();
        cliente.setDni("88888888");
        cliente.setEmail("carlos@gmail.com");
        cliente.setNombre("Pepe");
        cliente.setTelefono("99999999");
        negocio.grabar(cliente);
    }

}
