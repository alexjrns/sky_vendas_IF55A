package com.github.skyvendas.service.entitys;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProgramacaoPromocoes implements Serializable{
	private static final long serialVersionUID = -6459801903315727609L;
	private int id;
	private String informacoesAdicionais;
	private double total;
	private double payTV;
	private double opcionaisPayTV;
	private double opcionalBandaLarga;
	
	/* Pacotes */
	private boolean sKYFit;
	private boolean sKYFit2;
	private boolean sKYPrePagoLivre12Meses;
	
	/* Pacotes HDTV */
	private boolean sKYMixHd;
	private boolean sKYLigth2;
	
	/* Combos HDTV */
	private boolean hDTVHBOMax;
	private boolean hDTVTelecine;
	private boolean hDTVCinema;
	
	/* Combos HDTV Full */
	private boolean hDTVFullHBOMax;
	private boolean hDTVFullTelecine;
	private boolean hDTVFullCinema;
	
	/* Conteúdos opcionais */
	private boolean opcionalHD;
	private boolean opcionalFullHDTV;
	private boolean hBO;
	private boolean telecineHD;
	private boolean hBOHD;
	private boolean maxHD;
	private boolean hBODigital4;
	private boolean hBOMax;
	private boolean hBOBrasil;
	private boolean telecine;
	private boolean telecine3;
	private boolean premierFC;
	private boolean combate;
	private boolean bandsports;
	private boolean sexZone;
	private boolean plyaboyTV;
	private boolean sexyHot;
	private boolean hustlerTV;
	private boolean nHK;
	private boolean europa;
	private boolean deutscheWelle;
	private boolean rAIInternational;
	private boolean sICInternational;
	private boolean tV5Monde;
	private boolean tVZ;
	private boolean bandnews;
	private boolean bandaLarga2Mb;
	private boolean bandaLarga4Mb;
	private boolean sKYPrime24H;
	private boolean sKYAssistPremuim;
	
	public ProgramacaoPromocoes() {
		super();
	}

	public ProgramacaoPromocoes(int id, String informacoesAdicionais,
			double total, double payTV, double opcionaisPayTV,
			double opcionalBandaLarga, boolean sKYFit, boolean sKYFit2,
			boolean sKYPrePagoLivre12Meses, boolean sKYMixHd,
			boolean sKYLigth2, boolean hDTVHBOMax, boolean hDTVTelecine,
			boolean hDTVCinema, boolean hDTVFullHBOMax,
			boolean hDTVFullTelecine, boolean hDTVFullCinema,
			boolean opcionalHD, boolean opcionalFullHDTV, boolean hBO,
			boolean telecineHD, boolean hBOHD, boolean maxHD,
			boolean hBODigital4, boolean hBOMax, boolean hBOBrasil,
			boolean telecine, boolean telecine3, boolean premierFC,
			boolean combate, boolean bandsports, boolean sexZone,
			boolean plyaboyTV, boolean sexyHot, boolean hustlerTV, boolean nHK,
			boolean europa, boolean deutscheWelle, boolean rAIInternational,
			boolean sICInternational, boolean tV5Monde, boolean tVZ,
			boolean bandnews, boolean bandaLarga2Mb, boolean bandaLarga4Mb,
			boolean sKYPrime24H, boolean sKYAssistPremuim) {
		super();
		this.id = id;
		this.informacoesAdicionais = informacoesAdicionais;
		this.total = total;
		this.payTV = payTV;
		this.opcionaisPayTV = opcionaisPayTV;
		this.opcionalBandaLarga = opcionalBandaLarga;
		this.sKYFit = sKYFit;
		this.sKYFit2 = sKYFit2;
		this.sKYPrePagoLivre12Meses = sKYPrePagoLivre12Meses;
		this.sKYMixHd = sKYMixHd;
		this.sKYLigth2 = sKYLigth2;
		this.hDTVHBOMax = hDTVHBOMax;
		this.hDTVTelecine = hDTVTelecine;
		this.hDTVCinema = hDTVCinema;
		this.hDTVFullHBOMax = hDTVFullHBOMax;
		this.hDTVFullTelecine = hDTVFullTelecine;
		this.hDTVFullCinema = hDTVFullCinema;
		this.opcionalHD = opcionalHD;
		this.opcionalFullHDTV = opcionalFullHDTV;
		this.hBO = hBO;
		this.telecineHD = telecineHD;
		this.hBOHD = hBOHD;
		this.maxHD = maxHD;
		this.hBODigital4 = hBODigital4;
		this.hBOMax = hBOMax;
		this.hBOBrasil = hBOBrasil;
		this.telecine = telecine;
		this.telecine3 = telecine3;
		this.premierFC = premierFC;
		this.combate = combate;
		this.bandsports = bandsports;
		this.sexZone = sexZone;
		this.plyaboyTV = plyaboyTV;
		this.sexyHot = sexyHot;
		this.hustlerTV = hustlerTV;
		this.nHK = nHK;
		this.europa = europa;
		this.deutscheWelle = deutscheWelle;
		this.rAIInternational = rAIInternational;
		this.sICInternational = sICInternational;
		this.tV5Monde = tV5Monde;
		this.tVZ = tVZ;
		this.bandnews = bandnews;
		this.bandaLarga2Mb = bandaLarga2Mb;
		this.bandaLarga4Mb = bandaLarga4Mb;
		this.sKYPrime24H = sKYPrime24H;
		this.sKYAssistPremuim = sKYAssistPremuim;
	}

	public int getId() {
		return id;
	}

	public String getInformacoesAdicionais() {
		return informacoesAdicionais;
	}

	public double getTotal() {
		return total;
	}

	public double getPayTV() {
		return payTV;
	}

	public double getOpcionaisPayTV() {
		return opcionaisPayTV;
	}

	public double getOpcionalBandaLarga() {
		return opcionalBandaLarga;
	}

	public boolean issKYFit() {
		return sKYFit;
	}

	public boolean issKYFit2() {
		return sKYFit2;
	}

	public boolean issKYPrePagoLivre12Meses() {
		return sKYPrePagoLivre12Meses;
	}

	public boolean issKYMixHd() {
		return sKYMixHd;
	}

	public boolean issKYLigth2() {
		return sKYLigth2;
	}

	public boolean ishDTVHBOMax() {
		return hDTVHBOMax;
	}

	public boolean ishDTVTelecine() {
		return hDTVTelecine;
	}

	public boolean ishDTVCinema() {
		return hDTVCinema;
	}

	public boolean ishDTVFullHBOMax() {
		return hDTVFullHBOMax;
	}

	public boolean ishDTVFullTelecine() {
		return hDTVFullTelecine;
	}

	public boolean ishDTVFullCinema() {
		return hDTVFullCinema;
	}

	public boolean isOpcionalHD() {
		return opcionalHD;
	}

	public boolean isOpcionalFullHDTV() {
		return opcionalFullHDTV;
	}

	public boolean ishBO() {
		return hBO;
	}

	public boolean isTelecineHD() {
		return telecineHD;
	}

	public boolean ishBOHD() {
		return hBOHD;
	}

	public boolean isMaxHD() {
		return maxHD;
	}

	public boolean ishBODigital4() {
		return hBODigital4;
	}

	public boolean ishBOMax() {
		return hBOMax;
	}

	public boolean ishBOBrasil() {
		return hBOBrasil;
	}

	public boolean isTelecine() {
		return telecine;
	}

	public boolean isTelecine3() {
		return telecine3;
	}

	public boolean isPremierFC() {
		return premierFC;
	}

	public boolean isCombate() {
		return combate;
	}

	public boolean isBandsports() {
		return bandsports;
	}

	public boolean isSexZone() {
		return sexZone;
	}

	public boolean isPlyaboyTV() {
		return plyaboyTV;
	}

	public boolean isSexyHot() {
		return sexyHot;
	}

	public boolean isHustlerTV() {
		return hustlerTV;
	}

	public boolean isnHK() {
		return nHK;
	}

	public boolean isEuropa() {
		return europa;
	}

	public boolean isDeutscheWelle() {
		return deutscheWelle;
	}

	public boolean isrAIInternational() {
		return rAIInternational;
	}

	public boolean issICInternational() {
		return sICInternational;
	}

	public boolean istV5Monde() {
		return tV5Monde;
	}

	public boolean istVZ() {
		return tVZ;
	}

	public boolean isBandnews() {
		return bandnews;
	}

	public boolean isBandaLarga2Mb() {
		return bandaLarga2Mb;
	}

	public boolean isBandaLarga4Mb() {
		return bandaLarga4Mb;
	}

	public boolean issKYPrime24H() {
		return sKYPrime24H;
	}

	public boolean issKYAssistPremuim() {
		return sKYAssistPremuim;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setInformacoesAdicionais(String informacoesAdicionais) {
		this.informacoesAdicionais = informacoesAdicionais;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setPayTV(double payTV) {
		this.payTV = payTV;
	}

	public void setOpcionaisPayTV(double opcionaisPayTV) {
		this.opcionaisPayTV = opcionaisPayTV;
	}

	public void setOpcionalBandaLarga(double opcionalBandaLarga) {
		this.opcionalBandaLarga = opcionalBandaLarga;
	}

	public void setsKYFit(boolean sKYFit) {
		this.sKYFit = sKYFit;
	}

	public void setsKYFit2(boolean sKYFit2) {
		this.sKYFit2 = sKYFit2;
	}

	public void setsKYPrePagoLivre12Meses(boolean sKYPrePagoLivre12Meses) {
		this.sKYPrePagoLivre12Meses = sKYPrePagoLivre12Meses;
	}

	public void setsKYMixHd(boolean sKYMixHd) {
		this.sKYMixHd = sKYMixHd;
	}

	public void setsKYLigth2(boolean sKYLigth2) {
		this.sKYLigth2 = sKYLigth2;
	}

	public void sethDTVHBOMax(boolean hDTVHBOMax) {
		this.hDTVHBOMax = hDTVHBOMax;
	}

	public void sethDTVTelecine(boolean hDTVTelecine) {
		this.hDTVTelecine = hDTVTelecine;
	}

	public void sethDTVCinema(boolean hDTVCinema) {
		this.hDTVCinema = hDTVCinema;
	}

	public void sethDTVFullHBOMax(boolean hDTVFullHBOMax) {
		this.hDTVFullHBOMax = hDTVFullHBOMax;
	}

	public void sethDTVFullTelecine(boolean hDTVFullTelecine) {
		this.hDTVFullTelecine = hDTVFullTelecine;
	}

	public void sethDTVFullCinema(boolean hDTVFullCinema) {
		this.hDTVFullCinema = hDTVFullCinema;
	}

	public void setOpcionalHD(boolean opcionalHD) {
		this.opcionalHD = opcionalHD;
	}

	public void setOpcionalFullHDTV(boolean opcionalFullHDTV) {
		this.opcionalFullHDTV = opcionalFullHDTV;
	}

	public void sethBO(boolean hBO) {
		this.hBO = hBO;
	}

	public void setTelecineHD(boolean telecineHD) {
		this.telecineHD = telecineHD;
	}

	public void sethBOHD(boolean hBOHD) {
		this.hBOHD = hBOHD;
	}

	public void setMaxHD(boolean maxHD) {
		this.maxHD = maxHD;
	}

	public void sethBODigital4(boolean hBODigital4) {
		this.hBODigital4 = hBODigital4;
	}

	public void sethBOMax(boolean hBOMax) {
		this.hBOMax = hBOMax;
	}

	public void sethBOBrasil(boolean hBOBrasil) {
		this.hBOBrasil = hBOBrasil;
	}

	public void setTelecine(boolean telecine) {
		this.telecine = telecine;
	}

	public void setTelecine3(boolean telecine3) {
		this.telecine3 = telecine3;
	}

	public void setPremierFC(boolean premierFC) {
		this.premierFC = premierFC;
	}

	public void setCombate(boolean combate) {
		this.combate = combate;
	}

	public void setBandsports(boolean bandsports) {
		this.bandsports = bandsports;
	}

	public void setSexZone(boolean sexZone) {
		this.sexZone = sexZone;
	}

	public void setPlyaboyTV(boolean plyaboyTV) {
		this.plyaboyTV = plyaboyTV;
	}

	public void setSexyHot(boolean sexyHot) {
		this.sexyHot = sexyHot;
	}

	public void setHustlerTV(boolean hustlerTV) {
		this.hustlerTV = hustlerTV;
	}

	public void setnHK(boolean nHK) {
		this.nHK = nHK;
	}

	public void setEuropa(boolean europa) {
		this.europa = europa;
	}

	public void setDeutscheWelle(boolean deutscheWelle) {
		this.deutscheWelle = deutscheWelle;
	}

	public void setrAIInternational(boolean rAIInternational) {
		this.rAIInternational = rAIInternational;
	}

	public void setsICInternational(boolean sICInternational) {
		this.sICInternational = sICInternational;
	}

	public void settV5Monde(boolean tV5Monde) {
		this.tV5Monde = tV5Monde;
	}

	public void settVZ(boolean tVZ) {
		this.tVZ = tVZ;
	}

	public void setBandnews(boolean bandnews) {
		this.bandnews = bandnews;
	}

	public void setBandaLarga2Mb(boolean bandaLarga2Mb) {
		this.bandaLarga2Mb = bandaLarga2Mb;
	}

	public void setBandaLarga4Mb(boolean bandaLarga4Mb) {
		this.bandaLarga4Mb = bandaLarga4Mb;
	}

	public void setsKYPrime24H(boolean sKYPrime24H) {
		this.sKYPrime24H = sKYPrime24H;
	}

	public void setsKYAssistPremuim(boolean sKYAssistPremuim) {
		this.sKYAssistPremuim = sKYAssistPremuim;
	}

}
