package com.github.sky_vendas.model;

import java.io.Serializable;

public class ComodatoVendas implements Serializable {
	private static final long serialVersionUID = 71836904938708472L;
	private int id;

	/* Comodato/Venda (no ato) */
	private boolean atoTaxaDeAdesaoComodato;
	private boolean atoVenda;
	private double atoValor;
	private boolean atoCartaoCreditoDebito;
	private boolean atoDebitoAutomaticoContaCorrente;
	private boolean atoFichaCompensacao;
	private boolean atoPECPPB;
	private boolean atoCEFFinanciamento;
	
	/* Mensalidades de programa��o */
	private boolean mensalidadeCartaoCreditoDebito;
	private boolean mensalidadeDebitoAutomaticoContaCorrente;
	private boolean mensalidadeBoletoBancario;
	
	/* SKY Pr�-pago livre 12 meses */
	private boolean prePagoAVista;
	private boolean prePagoparcelado12meses;
	private double prePagoValor;
	private int prePagoQtdParcelas;
	private double prePagoValorParcela;

	public ComodatoVendas() {
		super();
	}

	public ComodatoVendas(int id, boolean atoTaxaDeAdesaoComodato, boolean atoVenda,
			double atoValor, boolean atoCartaoCreditoDebito,
			boolean atoDebitoAutomaticoContaCorrente,
			boolean atoFichaCompensacao, boolean atoPECPPB, boolean atoCEFFinanciamento,
			boolean mensalidadeCartaoCreditoDebito,
			boolean mensalidadeDebitoAutomaticoContaCorrente,
			boolean mensalidadeBoletoBancario, boolean prePagoAVista,
			boolean prePagoparcelado12meses, double prePagoValor,
			int prePagoQtdParcelas, double prePagoValorParcela) {
		super();
		this.id = id;
		this.atoTaxaDeAdesaoComodato = atoTaxaDeAdesaoComodato;
		this.atoVenda = atoVenda;
		this.atoValor = atoValor;
		this.atoCartaoCreditoDebito = atoCartaoCreditoDebito;
		this.atoDebitoAutomaticoContaCorrente = atoDebitoAutomaticoContaCorrente;
		this.atoFichaCompensacao = atoFichaCompensacao;
		this.atoPECPPB = atoPECPPB;
		this.atoCEFFinanciamento = atoCEFFinanciamento;
		this.mensalidadeCartaoCreditoDebito = mensalidadeCartaoCreditoDebito;
		this.mensalidadeDebitoAutomaticoContaCorrente = mensalidadeDebitoAutomaticoContaCorrente;
		this.mensalidadeBoletoBancario = mensalidadeBoletoBancario;
		this.prePagoAVista = prePagoAVista;
		this.prePagoparcelado12meses = prePagoparcelado12meses;
		this.prePagoValor = prePagoValor;
		this.prePagoQtdParcelas = prePagoQtdParcelas;
		this.prePagoValorParcela = prePagoValorParcela;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isAtoTaxaDeAdesaoComodato() {
		return atoTaxaDeAdesaoComodato;
	}

	public boolean isAtoVenda() {
		return atoVenda;
	}

	public double getAtoValor() {
		return atoValor;
	}

	public boolean isAtoCEFFinanciamento() {
		return atoCEFFinanciamento;
	}

	public void setAtoCEFFinanciamento(boolean atoCEFFinanciamento) {
		this.atoCEFFinanciamento = atoCEFFinanciamento;
	}

	public boolean isAtoCartaoCreditoDebito() {
		return atoCartaoCreditoDebito;
	}

	public boolean isAtoDebitoAutomaticoContaCorrente() {
		return atoDebitoAutomaticoContaCorrente;
	}

	public boolean isAtoFichaCompensacao() {
		return atoFichaCompensacao;
	}

	public boolean isAtoPECPPB() {
		return atoPECPPB;
	}

	public boolean isMensalidadeCartaoCreditoDebito() {
		return mensalidadeCartaoCreditoDebito;
	}

	public boolean isMensalidadeDebitoAutomaticoContaCorrente() {
		return mensalidadeDebitoAutomaticoContaCorrente;
	}

	public boolean isMensalidadeBoletoBancario() {
		return mensalidadeBoletoBancario;
	}

	public boolean isPrePagoAVista() {
		return prePagoAVista;
	}

	public boolean isPrePagoparcelado12meses() {
		return prePagoparcelado12meses;
	}

	public double getPrePagoValor() {
		return prePagoValor;
	}

	public int getPrePagoQtdParcelas() {
		return prePagoQtdParcelas;
	}

	public double getPrePagoValorParcela() {
		return prePagoValorParcela;
	}

	public void setAtoTaxaDeAdesaoComodato(boolean atoTaxaDeAdesaoComodato) {
		this.atoTaxaDeAdesaoComodato = atoTaxaDeAdesaoComodato;
	}

	public void setAtoVenda(boolean atoVenda) {
		this.atoVenda = atoVenda;
	}

	public void setAtoValor(double atoValor) {
		this.atoValor = atoValor;
	}

	public void setAtoCartaoCreditoDebito(boolean atoCartaoCreditoDebito) {
		this.atoCartaoCreditoDebito = atoCartaoCreditoDebito;
	}

	public void setAtoDebitoAutomaticoContaCorrente(
			boolean atoDebitoAutomaticoContaCorrente) {
		this.atoDebitoAutomaticoContaCorrente = atoDebitoAutomaticoContaCorrente;
	}

	public void setAtoFichaCompensacao(boolean atoFichaCompensacao) {
		this.atoFichaCompensacao = atoFichaCompensacao;
	}

	public void setAtoPECPPB(boolean atoPECPPB) {
		this.atoPECPPB = atoPECPPB;
	}

	public void setMensalidadeCartaoCreditoDebito(
			boolean mensalidadeCartaoCreditoDebito) {
		this.mensalidadeCartaoCreditoDebito = mensalidadeCartaoCreditoDebito;
	}

	public void setMensalidadeDebitoAutomaticoContaCorrente(
			boolean mensalidadeDebitoAutomaticoContaCorrente) {
		this.mensalidadeDebitoAutomaticoContaCorrente = mensalidadeDebitoAutomaticoContaCorrente;
	}

	public void setMensalidadeBoletoBancario(boolean mensalidadeBoletoBancario) {
		this.mensalidadeBoletoBancario = mensalidadeBoletoBancario;
	}

	public void setPrePagoAVista(boolean prePagoAVista) {
		this.prePagoAVista = prePagoAVista;
	}

	public void setPrePagoparcelado12meses(boolean prePagoparcelado12meses) {
		this.prePagoparcelado12meses = prePagoparcelado12meses;
	}

	public void setPrePagoValor(double prePagoValor) {
		this.prePagoValor = prePagoValor;
	}

	public void setPrePagoQtdParcelas(int prePagoQtdParcelas) {
		this.prePagoQtdParcelas = prePagoQtdParcelas;
	}

	public void setPrePagoValorParcela(double prePagoValorParcela) {
		this.prePagoValorParcela = prePagoValorParcela;
	}

}
