package com.github.sky_vendas.model;

public class DadosParaDebito {
	private int id;
	
	/* Débito automático no cartão de crédito */
	private boolean visa;
	private boolean hipercard;
	private boolean dinners;
	private boolean masterCard;
	private boolean amex;
	private boolean elo;
	private String numeroCartao;
	private String dataValidade;
	
	/* Débito automático em conta corrente */
	private String agencia;
	private String contaCorrente;
	
	private boolean banrisul;
	private boolean bradesco;
	private boolean bancoBrasil;
	private boolean cityBank;
	private boolean cEF;
	private boolean hSBC;
	private boolean itau;
	private boolean santander;
	private boolean sicredi;

	public DadosParaDebito() {
		super();
	}

	public DadosParaDebito(int id, boolean visa, boolean hipercard,
			boolean dinners, boolean masterCard, boolean amex, boolean elo,
			String numeroCartao, String dataValidade, String agencia,
			String contaCorrente, boolean banrisul, boolean bradesco,
			boolean bancoBrasil, boolean cityBank, boolean cEF, boolean hSBC,
			boolean itau, boolean santander, boolean sicredi) {
		super();
		this.id = id;
		this.visa = visa;
		this.hipercard = hipercard;
		this.dinners = dinners;
		this.masterCard = masterCard;
		this.amex = amex;
		this.elo = elo;
		this.numeroCartao = numeroCartao;
		this.dataValidade = dataValidade;
		this.agencia = agencia;
		this.contaCorrente = contaCorrente;
		this.banrisul = banrisul;
		this.bradesco = bradesco;
		this.bancoBrasil = bancoBrasil;
		this.cityBank = cityBank;
		this.cEF = cEF;
		this.hSBC = hSBC;
		this.itau = itau;
		this.santander = santander;
		this.sicredi = sicredi;
	}

	public int getId() {
		return id;
	}

	public boolean isVisa() {
		return visa;
	}

	public boolean isHipercard() {
		return hipercard;
	}

	public boolean isDinners() {
		return dinners;
	}

	public boolean isMasterCard() {
		return masterCard;
	}

	public boolean isAmex() {
		return amex;
	}

	public boolean isElo() {
		return elo;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public String getAgencia() {
		return agencia;
	}

	public String getContaCorrente() {
		return contaCorrente;
	}

	public boolean isBanrisul() {
		return banrisul;
	}

	public boolean isBradesco() {
		return bradesco;
	}

	public boolean isBancoBrasil() {
		return bancoBrasil;
	}

	public boolean isCityBank() {
		return cityBank;
	}

	public boolean iscEF() {
		return cEF;
	}

	public boolean ishSBC() {
		return hSBC;
	}

	public boolean isItau() {
		return itau;
	}

	public boolean isSantander() {
		return santander;
	}

	public boolean isSicredi() {
		return sicredi;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setVisa(boolean visa) {
		this.visa = visa;
	}

	public void setHipercard(boolean hipercard) {
		this.hipercard = hipercard;
	}

	public void setDinners(boolean dinners) {
		this.dinners = dinners;
	}

	public void setMasterCard(boolean masterCard) {
		this.masterCard = masterCard;
	}

	public void setAmex(boolean amex) {
		this.amex = amex;
	}

	public void setElo(boolean elo) {
		this.elo = elo;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public void setBanrisul(boolean banrisul) {
		this.banrisul = banrisul;
	}

	public void setBradesco(boolean bradesco) {
		this.bradesco = bradesco;
	}

	public void setBancoBrasil(boolean bancoBrasil) {
		this.bancoBrasil = bancoBrasil;
	}

	public void setCityBank(boolean cityBank) {
		this.cityBank = cityBank;
	}

	public void setcEF(boolean cEF) {
		this.cEF = cEF;
	}

	public void sethSBC(boolean hSBC) {
		this.hSBC = hSBC;
	}

	public void setItau(boolean itau) {
		this.itau = itau;
	}

	public void setSantander(boolean santander) {
		this.santander = santander;
	}

	public void setSicredi(boolean sicredi) {
		this.sicredi = sicredi;
	}

}
