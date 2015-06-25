package com.github.skyvendas.service.dao;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.github.skyvendas.service.entitys.PedidoVenda;

public class PedidoXMLDAO {
	private static final String XML_FILE = "./pedidostore.xml";
	private PedidoStore pedidoStore;
	
	public PedidoXMLDAO() {
		
		try {
			JAXBContext context = JAXBContext.newInstance(UsuarioStore.class);
			Unmarshaller um = context.createUnmarshaller();
			pedidoStore = (PedidoStore) um.unmarshal(new FileReader(XML_FILE));
			
		} catch (Exception e) {
			//empty store
			pedidoStore = new PedidoStore();
			pedidoStore.setName("store");
			pedidoStore.setPedidoList( new ArrayList<PedidoVenda>() );
		}
	}
	
	private void saveXML() {
		try {
			JAXBContext context = JAXBContext.newInstance(UsuarioStore.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(pedidoStore, new File(XML_FILE));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String save(PedidoVenda pedido) {
		pedidoStore.getPedidoList().add(pedido);
		saveXML();
		System.out.println("Pedido para o cliente: " + pedido.getDadosDoCliente().getNomeRazao() + " recebido");
		return "Pedido salvo com sucesso!";
	}

	public PedidoVenda getById(int id) {
		for(PedidoVenda p : pedidoStore.getPedidoList())
			if(p.getId() == id)
				return p;
		return null;
	}

	public List<PedidoVenda> getAll() {
		return pedidoStore.getPedidoList();
	}

}
