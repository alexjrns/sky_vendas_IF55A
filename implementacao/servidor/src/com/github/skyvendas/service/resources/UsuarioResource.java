package com.github.skyvendas.service.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.skyvendas.service.dao.UsuarioXmlDAO;
import com.github.skyvendas.service.entitys.Usuario;

@Path("login")
public class UsuarioResource {
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Usuario logar(Usuario usuario) {
    	UsuarioXmlDAO dao = new UsuarioXmlDAO();
    	return dao.login(usuario.getLogin(), usuario.getSenha());
    }
	
	@Path("cad")
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Usuario salvar(Usuario usuario) {
    	UsuarioXmlDAO dao = new UsuarioXmlDAO();
    	dao.save(usuario);
    	return usuario;
    }
	
	/*
	 * @Path("lg")
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario logar(@PathParam("login") String login, @PathParam("senha") String senha) {
		System.out.println(login);
		System.out.println(senha);
		if(login != null && senha != null){
    		return new Usuario(login, senha);
    	}
    	return null;
    }
	 
	
    //@Path("{account_number}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Account getBalance(@PathParam("account_number") long acNumber) {
    	AccountXmlDAO dao = new AccountXmlDAO();
    	return dao.getById(acNumber);
    }

    @Path("{account_number}/withdraw/{value}")
    @PUT
    @Produces(MediaType.TEXT_PLAIN)    
    public String withdraw(@PathParam("account_number") long acNumber, @PathParam("value") double value) {
    	AccountXmlDAO dao = new AccountXmlDAO();
    	
    	return dao.withdraw(acNumber, value);
    }

    @Path("{account_number}/deposit/{value}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)    
    public String deposit(@PathParam("account_number") long acNumber, @PathParam("value") double value) {
    	AccountXmlDAO dao = new AccountXmlDAO();
    	
    	return dao.deposit(acNumber, value);
    }    
    
    @Path("{account_number}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)    
    public String closeAccount(@PathParam("account_number") long acNumber) {
    	AccountXmlDAO dao = new AccountXmlDAO();
    	
    	return dao.remove(acNumber);
    }*/
}
