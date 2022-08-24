package com.upc.curso.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.upc.curso.entidades.Filtro;
import com.upc.curso.repositorios.IEstado;
import com.upc.curso.repositorios.IFiltro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.curso.entidades.Cliente;
import com.upc.curso.entidades.Pedido;
import com.upc.curso.repositorios.ClienteRepositorio;
import com.upc.curso.repositorios.PedidoRepositorio;

@Service
public class Negocio {

	@Autowired ClienteRepositorio clienteRepositorio;
	@Autowired PedidoRepositorio pedidoRepositorio;
	
	public Cliente obtenerCliente(String dni) {
		return clienteRepositorio.buscarCliente(dni);
	}
	
	public Cliente obtenerCliente(Long numeroPedido){
		Optional<Pedido> pedido = pedidoRepositorio.findById(numeroPedido);
		return pedido.get().getCliente();
	}
	public Cliente registrarCliente(Cliente cliente ) {
		return clienteRepositorio.save(cliente);
	}

	public List<Pedido> obtenerPedidosDNI(String dni){
		Cliente cliente = clienteRepositorio.buscarCliente(dni);
		return cliente.getPedidos();
	}
	public List<IFiltro> obtenerReportePedidosIGV2(){
		return pedidoRepositorio.obtenerReporteIGV2();
	}
	public List<Filtro> obtenerReportePedidosIGVDni(String dni){
		return pedidoRepositorio.obtenerReporteIGVDni(dni);
	}
	public List<Filtro> obtenerReportePedidosIGV(String dni){
		Cliente cliente = clienteRepositorio.buscarCliente(dni);
		List<Filtro> filtros = new ArrayList<>();
		for(Pedido p:cliente.getPedidos()){
			Filtro filtro = new Filtro(p.getCodigo(),p.getDescripcion(),p.getPrecio(),
					p.getEstado(),p.getPrecio()*0.18);
			filtros.add(filtro);
		}
		return filtros;
	}
	public Pedido realizarPedido(String dni, Pedido pedido){
		Cliente cliente = clienteRepositorio.buscarCliente(dni);
		pedido.setCliente(cliente);// ojo
		pedido.setCodigoRespuesta("00");// enviado
		return pedidoRepositorio.save(pedido);
	}
	public Pedido realizarPedido2(Pedido pedido){
		return pedidoRepositorio.save(pedido);
	}

	public List<IEstado> obtenerEstados(){
		return pedidoRepositorio.obtenerEstados();
	}

    public List<Pedido> obtenerPedidos() {
		return pedidoRepositorio.findAll();
    }
}

