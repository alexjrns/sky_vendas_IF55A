package com.github.sky_vendas;

import java.util.Calendar;

import com.example.sky_vendas.R;
import com.github.sky_vendas.model.ComodatoVendas;
import com.github.sky_vendas.model.DadosCliente;
import com.github.sky_vendas.model.DadosParaDebito;
import com.github.sky_vendas.model.Endereco;
import com.github.sky_vendas.model.Format;
import com.github.sky_vendas.model.InstalacaoDosReceptores;
import com.github.sky_vendas.model.ProgramacaoPromocoes;

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
	private ImageButton btnAvancar;
	
	/* Objetos compartilhados */
	private DadosCliente objDadosCliente;
	private InstalacaoDosReceptores objInstalacaoReceptores;
	private Endereco objEnderecoCobranca;
	private ProgramacaoPromocoes objProgramacaoPromocoes;
	private ComodatoVendas objComodatoVendas;
	private DadosParaDebito objDadosParaDebito;
	/*					*/
	
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
		btnAvancar = (ImageButton) findViewById(R.id.btnAvancar2);
		btnAvancar.setOnClickListener(lstAvancar);
		
		objDadosCliente = (DadosCliente) getIntent().getSerializableExtra("objDadosCliente");
		objInstalacaoReceptores = (InstalacaoDosReceptores) getIntent().getSerializableExtra("objInstalacaoReceptores");
		objEnderecoCobranca = (Endereco) getIntent().getSerializableExtra("objEnderecoCobranca");
		objProgramacaoPromocoes = (ProgramacaoPromocoes) getIntent().getSerializableExtra("objProgramacaoPromocoes");
		objComodatoVendas = (ComodatoVendas) getIntent().getSerializableExtra("objComodatoVendas");
		objDadosParaDebito = (DadosParaDebito) getIntent().getSerializableExtra("objDadosParaDebito");
		
		if(objDadosCliente != null)
			preencheTela();
	}

	OnClickListener lstAvancar = new OnClickListener() {
		@Override
		public void onClick(View v) {
			if(validaCampos()){
				Intent i = new Intent(CONTEXTO, InstalacaoReceptoresActivity.class);
				//i.putExtra("objDadosCliente", objDadosCliente);
				i.putExtra("objInstalacaoReceptores", objInstalacaoReceptores);
				i.putExtra("objEnderecoCobranca", objEnderecoCobranca);
				i.putExtra("objProgramacaoPromocoes", objProgramacaoPromocoes);
				i.putExtra("objComodatoVendas", objComodatoVendas);
				i.putExtra("objDadosParaDebito", objDadosParaDebito);

				i.putExtra("objDadosCliente", criaObjeto());
				startActivity(i);
			}
		}
	};
	
	private void preencheTela(){
		if(objDadosCliente.getTipoPessoa().equals("Física")){
			rbFisica.setChecked(true);
			rbJuridica.setChecked(false);
			rbEstrangeira.setChecked(false);	
		}else if(objDadosCliente.getTipoPessoa().equals("Jurídica")){
			rbFisica.setChecked(false);
			rbJuridica.setChecked(true);
			rbEstrangeira.setChecked(false);			
		}else if(objDadosCliente.getTipoPessoa().equals("Estrangeira")){
			rbFisica.setChecked(false);
			rbJuridica.setChecked(false);
			rbEstrangeira.setChecked(true);			
		}
		edtNomeRazao.setText(objDadosCliente.getNomeRazao());
		edtCPFCNPJ.setText(objDadosCliente.getCpfCNPJ());
		edtRGIECNE.setText(objDadosCliente.getRgIeRNE());
		//edtDataNascimento.setText(objDadosCliente.getDataNascimento());
		edtTelefoneResidencial.setText(objDadosCliente.getTelefoneResidencial());
		edtTelefoneComercial.setText(objDadosCliente.getTelefoneComercial());
		edtRamal.setText(objDadosCliente.getRamal());
		edtTelefoneCelular.setText(objDadosCliente.getTelefoneCelular());
		if(objDadosCliente.isSexo()){
			rbMasculino.setChecked(true);
			rbFeminino.setChecked(false);
		}else{
			rbMasculino.setChecked(false);
			rbFeminino.setChecked(true);			
		}
		if(objDadosCliente.getEstadoCivil().equals("Casado")){
			rbCasado.setChecked(true);
			rbSolteiro.setChecked(false);
			rbOutros.setChecked(false);
		}else if(objDadosCliente.getEstadoCivil().equals("Solteiro")){
			rbCasado.setChecked(false);
			rbSolteiro.setChecked(true);
			rbOutros.setChecked(false);
		}else{
			rbCasado.setChecked(false);
			rbSolteiro.setChecked(false);
			rbOutros.setChecked(true);
		}

		edtEmail.setText(objDadosCliente.getEmail());
		chkEmailNaoInformado.setChecked(objDadosCliente.isEmailNaoInformado());
	}
	
	private boolean validaCampos(){
		if(edtNomeRazao == null || edtNomeRazao.getText().toString().equals("")){
			SingletonUtilitario.imprime(CONTEXTO, getString(R.string.lblAtencao), getString(R.string.lblEObrigatorioOPreenchimentoDoCampo) + " NOME");
			return false;
		}
		if(edtCPFCNPJ == null || edtCPFCNPJ.getText().toString().equals("")){
			SingletonUtilitario.imprime(CONTEXTO, getString(R.string.lblAtencao), getString(R.string.lblEObrigatorioOPreenchimentoDoCampo) + " CPF/CNPJ");
			return false;
		}
		if(edtRGIECNE == null || edtRGIECNE.getText().toString().equals("")){
			SingletonUtilitario.imprime(CONTEXTO, getString(R.string.lblAtencao), getString(R.string.lblEObrigatorioOPreenchimentoDoCampo) + " RG/IE/CNE");
			return false;
		}
		if(edtDataNascimento == null || edtDataNascimento.getText().toString().equals("")){
			SingletonUtilitario.imprime(CONTEXTO, getString(R.string.lblAtencao), getString(R.string.lblEObrigatorioOPreenchimentoDoCampo) + " DATA DE NASCIMENTO");
			return false;
		} 
		/*if(edtDataNascimento == null || edtDataNascimento.getText().toString().length() != 8 || edtDataNascimento.getText().toString().length() != 10){
			SingletonUtilitario.imprime(CONTEXTO, "Atenção!", "Informe uma data de nascimento válida no formato DD/MM/AAAA");
			return false;
		}*/
		if(edtTelefoneResidencial == null || edtTelefoneResidencial.getText().toString().equals("")){
			SingletonUtilitario.imprime(CONTEXTO, getString(R.string.lblAtencao), getString(R.string.lblEObrigatorioOPreenchimentoDoCampo) + " TELEFONE RESIDENCIAL");
			return false;
		}
		if(edtTelefoneCelular == null || edtTelefoneCelular.getText().toString().equals("")){
			SingletonUtilitario.imprime(CONTEXTO, getString(R.string.lblAtencao), getString(R.string.lblEObrigatorioOPreenchimentoDoCampo) + " TELEFONE CELULAR");
			return false;
		}
		return true;
	}

	private DadosCliente criaObjeto(){
		String tipoPessoa = "Não informado";
		if(rbFisica.isChecked()){
			tipoPessoa = "Física";
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
