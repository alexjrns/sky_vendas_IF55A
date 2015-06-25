package com.github.skyvendas.service;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

@SuppressWarnings("restriction")
public class RESTServiceServer {
	public static void main(String[] args) {
        try {
			HttpServer server = HttpServerFactory.create("http://localhost:8084/");
            server.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }    
}
