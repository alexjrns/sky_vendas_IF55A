package com.github.skyvendas.service.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.skyvendas.service.dao.PedidoXMLDAO;
import com.github.skyvendas.service.entitys.DadosCliente;
import com.github.skyvendas.service.entitys.Endereco;
import com.github.skyvendas.service.entitys.PedidoVenda;

@Path("pedido")
public class PedidoCompraResource {

	public PedidoCompraResource() {
	}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PedidoVenda> getPedido() {
    	PedidoXMLDAO dao = new PedidoXMLDAO();
    	return dao.getAll();
    }
	
	@Path("{pedido_numero}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PedidoVenda getPedido(@PathParam("pedido_numero") int pedNumber) {
    	PedidoXMLDAO dao = new PedidoXMLDAO();
    	return dao.getById(pedNumber);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String salvaPedido(PedidoVenda pedido) {
    	PedidoXMLDAO dao = new PedidoXMLDAO();
    	return dao.save(pedido);
    }

}
