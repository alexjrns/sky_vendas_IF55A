package com.github.skyvendas.service.dao;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.github.skyvendas.service.entitys.Usuario;

@XmlRootElement
public class UsuarioStore {

	private String name;
	private ArrayList<Usuario> usuarioList;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Usuario> getUsuarioList() {
		return usuarioList;
	}
	public void setUsuarioList(ArrayList<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}
}
