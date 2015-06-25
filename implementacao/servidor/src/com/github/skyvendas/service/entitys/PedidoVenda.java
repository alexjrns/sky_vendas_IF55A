package com.github.skyvendas.service.entitys;

import java.io.Serializable;
import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PedidoVenda implements Serializable{
	private static final long serialVersionUID = 6287892481238593709L;
	private int id;
	private Calendar data;
	private double codigo;

	private PontoDeVendas pontoDeVendas;
	private DadosCliente dadosDoCliente;
	private InstalacaoDosReceptores instalacaoDosReceptores;
	private Endereco enderecoDeCobranca;
	private ProgramacaoPromocoes programacaoEPromocoes;
	private ComodatoVendas comodatoVendas;
	private DadosParaDebito dadosParaDebito;

	public PedidoVenda() {
		super();
	}

	public PedidoVenda(int id, Calendar data, double codigo,
			PontoDeVendas pontoDeVendas, DadosCliente dadosDoCliente,
			InstalacaoDosReceptores instalacaoDosReceptores,
			Endereco enderecoDeCobranca,
			ProgramacaoPromocoes programacaoEPromocoes,
			ComodatoVendas comodatoVendas, DadosParaDebito dadosParaDebito) {
		super();
		this.id = id;
		this.data = data;
		this.codigo = codigo;
		this.pontoDeVendas = pontoDeVendas;
		this.dadosDoCliente = dadosDoCliente;
		this.instalacaoDosReceptores = instalacaoDosReceptores;
		this.enderecoDeCobranca = enderecoDeCobranca;
		this.programacaoEPromocoes = programacaoEPromocoes;
		this.comodatoVendas = comodatoVendas;
		this.dadosParaDebito = dadosParaDebito;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public Calendar getData() {
		return data;
	}

	public double getCodigo() {
		return codigo;
	}

	public PontoDeVendas getPontoDeVendas() {
		return pontoDeVendas;
	}

	public DadosCliente getDadosDoCliente() {
		return dadosDoCliente;
	}

	public InstalacaoDosReceptores getInstalacaoDosReceptores() {
		return instalacaoDosReceptores;
	}

	public Endereco getEnderecoDeCobranca() {
		return enderecoDeCobranca;
	}

	public ProgramacaoPromocoes getProgramacaoEPromocoes() {
		return programacaoEPromocoes;
	}

	public ComodatoVendas getComodatoVendas() {
		return comodatoVendas;
	}

	public DadosParaDebito getDadosParaDebito() {
		return dadosParaDebito;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public void setCodigo(double codigo) {
		this.codigo = codigo;
	}

	public void setPontoDeVendas(PontoDeVendas pontoDeVendas) {
		this.pontoDeVendas = pontoDeVendas;
	}

	public void setDadosDoCliente(DadosCliente dadosDoCliente) {
		this.dadosDoCliente = dadosDoCliente;
	}

	public void setInstalacaoDosReceptores(
			InstalacaoDosReceptores instalacaoDosReceptores) {
		this.instalacaoDosReceptores = instalacaoDosReceptores;
	}

	public void setEnderecoDeCobranca(Endereco enderecoDeCobranca) {
		this.enderecoDeCobranca = enderecoDeCobranca;
	}

	public void setProgramacaoEPromocoes(ProgramacaoPromocoes programacaoEPromocoes) {
		this.programacaoEPromocoes = programacaoEPromocoes;
	}

	public void setComodatoVendas(ComodatoVendas comodatoVendas) {
		this.comodatoVendas = comodatoVendas;
	}

	public void setDadosParaDebito(DadosParaDebito dadosParaDebito) {
		this.dadosParaDebito = dadosParaDebito;
	}
	
	
}
