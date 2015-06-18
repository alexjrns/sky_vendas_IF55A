package com.github.sky_vendas.model;

import java.util.Calendar;

public class PedidoVenda {
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
}
