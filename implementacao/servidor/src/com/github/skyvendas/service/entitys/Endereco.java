package com.github.skyvendas.service.entitys;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Endereco implements Serializable{
	private static final long serialVersionUID = 5313899624505124770L;
	private int id;
	private String endereco;
	private String numero;
	private String aptoCasa;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uF;
	private String cEP;
	
	public Endereco() {
		super();
	}

	public Endereco(int id, String endereco, String numero, String aptoCasa,
			String complemento, String bairro, String cidade, String uF,
			String cEP) {
		super();
		this.id = id;
		this.endereco = endereco;
		this.numero = numero;
		this.aptoCasa = aptoCasa;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uF = uF;
		this.cEP = cEP;
	}

	public int getId() {
		return id;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getNumero() {
		return numero;
	}

	public String getAptoCasa() {
		return aptoCasa;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getuF() {
		return uF;
	}

	public String getcEP() {
		return cEP;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setAptoCasa(String aptoCasa) {
		this.aptoCasa = aptoCasa;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setuF(String uF) {
		this.uF = uF;
	}

	public void setcEP(String cEP) {
		this.cEP = cEP;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", endereco=" + endereco + ", numero="
				+ numero + ", aptoCasa=" + aptoCasa + ", complemento="
				+ complemento + ", bairro=" + bairro + ", cidade=" + cidade
				+ ", uF=" + uF + ", cEP=" + cEP + "]";
	}

}
