package com.github.skyvendas.service.dao;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.github.skyvendas.service.entitys.Usuario;

public class UsuarioXmlDAO {
	private static final String XML_FILE = "./usuariostore.xml";
	private UsuarioStore usuarioStore;
	
	public UsuarioXmlDAO() {
		
		try {
			JAXBContext context = JAXBContext.newInstance(UsuarioStore.class);
			Unmarshaller um = context.createUnmarshaller();
			usuarioStore = (UsuarioStore) um.unmarshal(new FileReader(XML_FILE));
			
		} catch (Exception e) {
			//empty store
			usuarioStore = new UsuarioStore();
			usuarioStore.setName("store");
			usuarioStore.setUsuarioList( new ArrayList<Usuario>() );
		}
	}
	
	private void saveXML() {
		try {
			JAXBContext context = JAXBContext.newInstance(UsuarioStore.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(usuarioStore, new File(XML_FILE));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void save(Usuario usuario) {
		//long newNumber = System.currentTimeMillis();
		//account.setNumber( newNumber );
		usuarioStore.getUsuarioList().add(usuario);
		saveXML();
	}



	public Usuario login(String login, String senha) {
		for(Usuario u : usuarioStore.getUsuarioList())
			if(u.getLogin().equals(login))
				if(u.getSenha().equals(senha))
					return u;
		return null;
	}

	/*public String remove(long acNumber) {
		Usuario c = getById(acNumber);
		if(c == null)
			return "no account";
		
		usuarioStore.getUsuarioList().remove(c);
		saveXML();
		return "account removed";
	}

	public String withdraw(long acNumber, double value) {
		Usuario c = getById(acNumber);
		if(c == null)
			return "no account";
		
		if(value > c.getBalance())
			return "no money";
		
		double newBalance = c.getBalance() - value;
		c.setBalance( newBalance );
		saveXML();
		return "withdraw achieved";
	}

	public String deposit(int acNumber, double value) {
		Usuario c = getById(acNumber);
		if(u == null)
			return "no account";
	
		double newBalance = u.getBalance() + value;
		u.setBalance( newBalance );
		saveXML();
		return "deposit achieved";
	}
*/
	public List<Usuario> getAll() {
		return usuarioStore.getUsuarioList();
	}
}
