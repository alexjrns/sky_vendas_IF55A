package com.github.sky_vendas.model;

import java.io.Serializable;
import java.util.Calendar;

public class DadosCliente implements Serializable {
	private static final long serialVersionUID = 454202921870607468L;

	private int codigo;
	private String tipoPessoa;
	private Calendar dataNascimento;
	private String nomeRazao;
	private String telefoneResidencial;
	private String telefoneComercial;
	private String ramal;
	private boolean sexo;
	private String telefoneCelular;
	private String estadoCivil;
	private String cpfCNPJ;
	private String rgIeRNE;
	private String email;
	private boolean emailNaoInformado;
	
	public DadosCliente() {
		super();
	}

	public DadosCliente(int codigo, String tipoPessoa, Calendar dataNascimento,
			String nomeRazao, String telefoneResidencial,
			String telefoneComercial, String ramal, boolean sexo,
			String telefoneCelular, String estadoCivil, String cpfCNPJ,
			String rgIeRNE, String email, boolean emailNaoInformado) {
		super();
		this.codigo = codigo;
		this.tipoPessoa = tipoPessoa;
		this.dataNascimento = dataNascimento;
		this.nomeRazao = nomeRazao;
		this.telefoneResidencial = telefoneResidencial;
		this.telefoneComercial = telefoneComercial;
		this.ramal = ramal;
		this.sexo = sexo;
		this.telefoneCelular = telefoneCelular;
		this.estadoCivil = estadoCivil;
		this.cpfCNPJ = cpfCNPJ;
		this.rgIeRNE = rgIeRNE;
		this.email = email;
		this.emailNaoInformado = emailNaoInformado;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public String getNomeRazao() {
		return nomeRazao;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public String getRamal() {
		return ramal;
	}

	public boolean isSexo() {
		return sexo;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public String getCpfCNPJ() {
		return cpfCNPJ;
	}

	public String getRgIeRNE() {
		return rgIeRNE;
	}

	public String getEmail() {
		return email;
	}

	public boolean isEmailNaoInformado() {
		return emailNaoInformado;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setNomeRazao(String nomeRazao) {
		this.nomeRazao = nomeRazao;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public void setCpfCNPJ(String cpfCNPJ) {
		this.cpfCNPJ = cpfCNPJ;
	}

	public void setRgIeRNE(String rgIeRNE) {
		this.rgIeRNE = rgIeRNE;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmailNaoInformado(boolean emailNaoInformado) {
		this.emailNaoInformado = emailNaoInformado;
	}
}
