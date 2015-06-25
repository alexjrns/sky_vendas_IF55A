package com.github.skyvendas.service.entitys;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InstalacaoDosReceptores implements Serializable{
	private static final long serialVersionUID = 9029726773980749969L;
	private int id;
	private boolean casa;
	private Endereco endereco;
	private String nomeCondominio;
	private String nomeEdificio;
	private String pontoReferencia;
	private String nomeResponsavelAntendimentoAoInstalador;
	private Receptor principal;
	private Receptor opcional;
	private Receptor bandaLarga;

	public InstalacaoDosReceptores() {
		super();
	}

	public InstalacaoDosReceptores(int id, boolean casa, Endereco endereco,
			String nomeCondominio, String nomeEdificio,	String pontoReferencia,
			String nomeResponsavelAntendimentoAoInstalador, Receptor principal,
			Receptor opcional, Receptor bandaLarga) {
		super();
		this.id = id;
		this.casa = casa;
		this.endereco = endereco;
		this.nomeCondominio = nomeCondominio;
		this.nomeEdificio = nomeEdificio;
		this.pontoReferencia = pontoReferencia;
		this.nomeResponsavelAntendimentoAoInstalador = nomeResponsavelAntendimentoAoInstalador;
		this.principal = principal;
		this.opcional = opcional;
		this.bandaLarga = bandaLarga;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isCasa() {
		return casa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public String getNomeCondominio() {
		return nomeCondominio;
	}

	public String getNomeEdificio() {
		return nomeEdificio;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public String getNomeResponsavelAntendimentoAoInstalador() {
		return nomeResponsavelAntendimentoAoInstalador;
	}

	public Receptor getPrincipal() {
		return principal;
	}

	public Receptor getOpcional() {
		return opcional;
	}

	public Receptor getBandaLarga() {
		return bandaLarga;
	}

	public void setCasa(boolean casa) {
		this.casa = casa;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setNomeCondominio(String nomeCondominio) {
		this.nomeCondominio = nomeCondominio;
	}

	public void setNomeEdificio(String nomeEdificio) {
		this.nomeEdificio = nomeEdificio;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

	public void setNomeResponsavelAntendimentoAoInstalador(
			String nomeResponsavelAntendimentoAoInstalador) {
		this.nomeResponsavelAntendimentoAoInstalador = nomeResponsavelAntendimentoAoInstalador;
	}

	public void setPrincipal(Receptor principal) {
		this.principal = principal;
	}

	public void setOpcional(Receptor opcional) {
		this.opcional = opcional;
	}

	public void setBandaLarga(Receptor bandaLarga) {
		this.bandaLarga = bandaLarga;
	}

}
