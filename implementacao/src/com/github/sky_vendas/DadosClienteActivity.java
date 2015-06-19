package com.github.sky_vendas;

import java.util.Calendar;

import com.example.sky_vendas.R;
import com.github.sky_vendas.model.DadosCliente;
import com.github.sky_vendas.model.Format;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;

public class DadosClienteActivity extends Activity {
	private final Context CONTEXTO = this;
	
	private RadioButton rbFisica;
	private RadioButton rbJuridica;
	private RadioButton rbEstrangeira;
	private EditText edtNomeRazao;
	private EditText edtCPFCNPJ;
	private EditText edtRGIECNE;
	private EditText edtDataNascimento;
	private EditText edtTelefoneResidencial;
	private EditText edtTelefoneComercial;
	private EditText edtRamal;
	private EditText edtTelefoneCelular;
	private RadioButton rbMasculino;
	private RadioButton rbFeminino;
	private RadioButton rbCasado;
	private RadioButton rbSolteiro;
	private RadioButton rbOutros;
	private EditText edtEmail;
	private CheckBox chkEmailNaoInformado;
	private ImageButton btnVoltar;
	private ImageButton btnAvancar;
	
	private DadosCliente objDadosCliente;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dados_cliente);
		
		rbFisica = (RadioButton) findViewById(R.id.rbPessoaFisica);
		rbJuridica = (RadioButton) findViewById(R.id.rbPessoaJuridica);
		rbEstrangeira = (RadioButton) findViewById(R.id.rbPessoaEstrangeira);
		edtNomeRazao = (EditText) findViewById(R.id.edtNomeRazao);
		edtCPFCNPJ = (EditText) findViewById(R.id.edtCPFCNPJ);
		edtRGIECNE = (EditText) findViewById(R.id.edtRGIERNE);
		edtDataNascimento = (EditText) findViewById(R.id.edtDataNascimento);
		edtTelefoneResidencial = (EditText) findViewById(R.id.edtTelefoneResidencial);
		edtTelefoneComercial = (EditText) findViewById(R.id.edtTelefoneComercial);
		edtRamal = (EditText) findViewById(R.id.edtRamal);
		edtTelefoneCelular = (EditText) findViewById(R.id.edtTelefoneCelular);
		rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);
		rbFeminino = (RadioButton) findViewById(R.id.rbFeminino);
		rbCasado = (RadioButton) findViewById(R.id.rbCasado);
		rbSolteiro = (RadioButton) findViewById(R.id.rbSolteiro);
		rbOutros = (RadioButton) findViewById(R.id.rbOutros);
		edtEmail = (EditText) findViewById(R.id.edtEmail);
		chkEmailNaoInformado = (CheckBox) findViewById(R.id.chkEmailNaoInformado);
		btnVoltar = (ImageButton) findViewById(R.id.btnVoltar2);
		btnAvancar = (ImageButton) findViewById(R.id.btnAvancar2);
		btnAvancar.setOnClickListener(lstAvancar);
	}
	
	OnClickListener lstAvancar = new OnClickListener() {
		@Override
		public void onClick(View v) {
			if(validaCampos()){
				Intent i = new Intent(CONTEXTO, InstalacaoReceptoresActivity.class);
				i.putExtra("dadosCliente", criaObjeto());
				startActivityForResult(i, 10);
			}
		}
	};
	
	private boolean validaCampos(){
		if(edtNomeRazao == null || edtNomeRazao.getText().toString().equals("")){
			SingletonUtilitario.imprime(CONTEXTO, "Atenção", "É obrigatório o preenchimento do campo NOME!");
			return false;
		}
		if(edtCPFCNPJ == null || edtCPFCNPJ.getText().toString().equals("")){
			SingletonUtilitario.imprime(CONTEXTO, "Atenção", "É obrigatório o preenchimento do campo CPF/CNPJ!");
			return false;
		}
		return true;
	}

	private DadosCliente criaObjeto(){
		String tipoPessoa = "Não informado";
		if(rbFisica.isChecked()){
			tipoPessoa = "Fisica";
		}else if(rbJuridica.isChecked()){
			tipoPessoa = "Jurídica";
		}else if(rbEstrangeira.isChecked()){
			tipoPessoa = "Estrangeira";
		}
		String estadoCivil = "Outros";
		if(rbCasado.isChecked()){
			estadoCivil = "Casado";
		}else if(rbSolteiro.isChecked()){
			estadoCivil = "Solteiro";
		}
		Calendar dataNascimento = Format.getData(edtDataNascimento.getText().toString());
		DadosCliente dados = new DadosCliente(0, tipoPessoa, dataNascimento, edtNomeRazao.getText().toString(), 
				edtTelefoneResidencial.getText().toString(), edtTelefoneComercial.getText().toString(),
				edtRamal.getText().toString(), (rbMasculino.isChecked()), edtTelefoneCelular.getText().toString(), 
				estadoCivil, edtCPFCNPJ.getText().toString(), edtRGIECNE.getText().toString(), 
				edtEmail.getText().toString(), chkEmailNaoInformado.isChecked());
		objDadosCliente = dados;
		return dados;
	}
}
