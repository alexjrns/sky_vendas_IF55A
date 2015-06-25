package com.github.skyvendas.service.dao;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.github.skyvendas.service.entitys.PedidoVenda;

@XmlRootElement
public class PedidoStore {
	private String name;
	private ArrayList<PedidoVenda> pedidoList;
	
	public PedidoStore() {
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<PedidoVenda> getPedidoList() {
		return pedidoList;
	}
	public void setPedidoList(ArrayList<PedidoVenda> pedidoList) {
		this.pedidoList = pedidoList;
	}

}
