package com.github.sky_vendas.model;

public class PontoDeVendas {
	private int id;
	private double codigoCredenciado;
	private double codigoPDV;
	private String nomePDV;
	private double codigoVendedor;
	private String nomeVendedor;
	
	public PontoDeVendas() {
		super();
	}

	public PontoDeVendas(int id, double codigoCredenciado, double codigoPDV,
			String nomePDV, double codigoVendedor, String nomeVendedor) {
		super();
		this.id = id;
		this.codigoCredenciado = codigoCredenciado;
		this.codigoPDV = codigoPDV;
		this.nomePDV = nomePDV;
		this.codigoVendedor = codigoVendedor;
		this.nomeVendedor = nomeVendedor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCodigoCredenciado() {
		return codigoCredenciado;
	}

	public double getCodigoPDV() {
		return codigoPDV;
	}

	public String getNomePDV() {
		return nomePDV;
	}

	public double getCodigoVendedor() {
		return codigoVendedor;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setCodigoCredenciado(double codigoCredenciado) {
		this.codigoCredenciado = codigoCredenciado;
	}

	public void setCodigoPDV(double codigoPDV) {
		this.codigoPDV = codigoPDV;
	}

	public void setNomePDV(String nomePDV) {
		this.nomePDV = nomePDV;
	}

	public void setCodigoVendedor(double codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

}
