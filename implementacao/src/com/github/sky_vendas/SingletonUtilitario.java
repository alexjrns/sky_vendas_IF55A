package com.github.sky_vendas;

public abstract class SingletonUtilitario {
	private static String resourceURL = "http://10.0.2.2:4000";
	
	public SingletonUtilitario() {
	}

	public static String getResourceURL() {
		return resourceURL;
	}

}
