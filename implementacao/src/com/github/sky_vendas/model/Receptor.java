package com.github.sky_vendas.model;

public class Receptor {
	private int id;
	private boolean sKY;
	private boolean hD;
	private boolean fullHD;
	private boolean hdAdicionais;
	
	public Receptor() {
		super();
	}

	public Receptor(int id, boolean sKY, boolean hD, boolean fullHD,
			boolean hdAdicionais) {
		super();
		this.id = id;
		this.sKY = sKY;
		this.hD = hD;
		this.fullHD = fullHD;
		this.hdAdicionais = hdAdicionais;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean issKY() {
		return sKY;
	}

	public boolean ishD() {
		return hD;
	}

	public boolean isFullHD() {
		return fullHD;
	}

	public boolean isHdAdicionais() {
		return hdAdicionais;
	}

	public void setsKY(boolean sKY) {
		this.sKY = sKY;
	}

	public void sethD(boolean hD) {
		this.hD = hD;
	}

	public void setFullHD(boolean fullHD) {
		this.fullHD = fullHD;
	}

	public void setHdAdicionais(boolean hdAdicionais) {
		this.hdAdicionais = hdAdicionais;
	}

}
