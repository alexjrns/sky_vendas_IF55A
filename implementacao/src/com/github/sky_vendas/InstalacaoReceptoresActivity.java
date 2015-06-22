package com.github.sky_vendas;

import com.example.sky_vendas.R;
import com.github.sky_vendas.model.DadosCliente;
import com.github.sky_vendas.model.Endereco;
import com.github.sky_vendas.model.InstalacaoDosReceptores;
import com.github.sky_vendas.model.Receptor;

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

public class InstalacaoReceptoresActivity extends Activity {
	private final Context CONTEXTO = this;

	private ImageButton btnVoltar;
	private ImageButton btnAvancar;
	private RadioButton rbApto;
	private RadioButton rbCasa;
	private EditText edtEndereco;
	private EditText edtNumero;
	private EditText edtAptoCasa;
	private EditText edtComplemento;
	private EditText edtBairro;
	private EditText edtNomeCondominio;
	private EditText edtNomeEdificio;
	private EditText edtCidade;
	private EditText edtUF;
	private EditText edtCEP;
	private EditText edtPontoReferencia;
	private EditText edtNomeResponsavelAntendimentoInstalador;
	private CheckBox chkPrincipalSKY;
	private CheckBox chkPrincipalHD;
	private CheckBox chkPrincipalFullHD;
	private CheckBox chkPrincipalHDCanaisAbertos;
	private CheckBox chkOpcionalSKY;
	private CheckBox chkOpcionalHD;
	private CheckBox chkOpcionalFullHD;
	private CheckBox chkOpcionalHDCanaisAbertos;
	private CheckBox chkBandaLargaSKY;
	private CheckBox chkBandaLargaHD;
	private CheckBox chkBandaLargaFullHD;
	private CheckBox chkBandaLargaHDCanaisAbertos;
	
	private DadosCliente objDadosCliente;
	private InstalacaoDosReceptores objInstalacaoReceptores;
	private Endereco objEnderecoCobranca;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_instalacao_receptores);
		btnVoltar = (ImageButton) findViewById(R.id.btnVoltar3);
		btnVoltar.setOnClickListener(lstVoltar);
		btnAvancar = (ImageButton) findViewById(R.id.btnAvancar3);
		btnAvancar.setOnClickListener(lstAvancar);
		
		rbApto = (RadioButton) findViewById(R.id.rbApto);
		rbCasa = (RadioButton) findViewById(R.id.rbCasa);
		edtEndereco = (EditText) findViewById(R.id.edtEndereco);
		edtNumero = (EditText) findViewById(R.id.edtNumero);
		edtAptoCasa = (EditText) findViewById(R.id.edtAptoCasa);
		edtComplemento = (EditText) findViewById(R.id.edtComplemento);
		edtBairro = (EditText) findViewById(R.id.edtBairro);
		edtNomeCondominio = (EditText) findViewById(R.id.edtNomeDoCondominio);
		edtNomeEdificio = (EditText) findViewById(R.id.edtNomeDoEdificio);
		edtCidade = (EditText) findViewById(R.id.edtCidade);
		edtUF = (EditText) findViewById(R.id.edtUF);
		edtCEP = (EditText) findViewById(R.id.edtCEP);
		edtPontoReferencia = (EditText) findViewById(R.id.edtPontoReferencia);
		edtNomeResponsavelAntendimentoInstalador = (EditText) findViewById(R.id.edtNomeResponsavelAtendimentoInstalador);
		chkPrincipalSKY = (CheckBox) findViewById(R.id.chkPrincipalSKY);
		chkPrincipalHD = (CheckBox) findViewById(R.id.chkPrincipalHD);
		chkPrincipalFullHD = (CheckBox) findViewById(R.id.chkPrincipalFullHD);
		chkPrincipalHDCanaisAbertos = (CheckBox) findViewById(R.id.chkPrincipalHDCanaisAbertos);
		chkOpcionalSKY = (CheckBox) findViewById(R.id.chkOpcionalSKY);
		chkOpcionalHD = (CheckBox) findViewById(R.id.chkOpcionalHD);
		chkOpcionalFullHD = (CheckBox) findViewById(R.id.chkOpcionalFullHD);
		chkOpcionalHDCanaisAbertos = (CheckBox) findViewById(R.id.chkOpcionalHDCanaisAbertos);
		chkBandaLargaSKY = (CheckBox) findViewById(R.id.chkBandaLargaSKY);
		chkBandaLargaHD = (CheckBox) findViewById(R.id.chkBandaLargaHD);
		chkBandaLargaFullHD = (CheckBox) findViewById(R.id.chkBandaLargaFullHD);
		chkBandaLargaHDCanaisAbertos = (CheckBox) findViewById(R.id.chkBandaLargaHDCanaisAbertos);

		objDadosCliente = (DadosCliente) getIntent().getSerializableExtra("objDadosCliente");
		objInstalacaoReceptores = (InstalacaoDosReceptores) getIntent().getSerializableExtra("objInstalacaoReceptores");
		objEnderecoCobranca = (Endereco) getIntent().getSerializableExtra("objEnderecoCobranca");
		
		if(objInstalacaoReceptores != null)
			preencheTela();
	}

	OnClickListener lstVoltar = new OnClickListener() {
		@Override
		public void onClick(View v) {
			try {
				this.finalize();
			} catch (Throwable e) {
				e.printStackTrace();
			}
			Intent i = new Intent(CONTEXTO, DadosClienteActivity.class);
			i.putExtra("instalacaoReceptores", criaObjeto());
			i.putExtra("objEnderecoCobranca", objEnderecoCobranca);
			i.putExtra("objDadosCliente", objDadosCliente);
			startActivity(i);
		}
	};
	
	OnClickListener lstAvancar = new OnClickListener() {
		@Override
		public void onClick(View v) {
			if(validaCampos()){
				Intent i = new Intent(CONTEXTO, EnderecoCobrancaActivity.class);
				//i.putExtra("instalacaoReceptores", criaObjeto());
				i.putExtra("objEnderecoCobranca", objEnderecoCobranca);
				i.putExtra("objDadosCliente", objDadosCliente);
				startActivity(i);				
			}
		}
	};

	private void preencheTela(){
		if(objInstalacaoReceptores.isCasa()){
			rbApto.setChecked(false);
			rbCasa.setChecked(true);
		}else{
			rbApto.setChecked(true);
			rbCasa.setChecked(false);			
		}
		edtEndereco.setText(objInstalacaoReceptores.getEndereco().getEndereco());
		edtNumero.setText(objInstalacaoReceptores.getEndereco().getNumero());
		edtAptoCasa.setText(objInstalacaoReceptores.getEndereco().getAptoCasa());
		edtComplemento.setText(objInstalacaoReceptores.getEndereco().getComplemento());
		edtBairro.setText(objInstalacaoReceptores.getEndereco().getBairro());
		edtNomeCondominio.setText(objInstalacaoReceptores.getNomeCondominio());
		edtNomeEdificio.setText(objInstalacaoReceptores.getNomeEdificio());
		edtCidade.setText(objInstalacaoReceptores.getEndereco().getCidade());
		edtUF.setText(objInstalacaoReceptores.getEndereco().getuF());
		edtCEP.setText(objInstalacaoReceptores.getEndereco().getcEP());
		edtPontoReferencia.setText(objInstalacaoReceptores.getPontoReferencia());
		edtNomeResponsavelAntendimentoInstalador.setText(objInstalacaoReceptores.getNomeResponsavelAntendimentoAoInstalador());
		chkPrincipalSKY.setChecked(objInstalacaoReceptores.getPrincipal().issKY());
		chkPrincipalHD.setChecked(objInstalacaoReceptores.getPrincipal().ishD());
		chkPrincipalFullHD.setChecked(objInstalacaoReceptores.getPrincipal().isFullHD());
		chkPrincipalHDCanaisAbertos.setChecked(objInstalacaoReceptores.getPrincipal().isHdAdicionais());
		chkOpcionalSKY.setChecked(objInstalacaoReceptores.getOpcional().issKY());
		chkOpcionalHD.setChecked(objInstalacaoReceptores.getOpcional().ishD());
		chkOpcionalFullHD.setChecked(objInstalacaoReceptores.getOpcional().isFullHD());
		chkOpcionalHDCanaisAbertos.setChecked(objInstalacaoReceptores.getOpcional().isHdAdicionais());
		chkBandaLargaSKY.setChecked(objInstalacaoReceptores.getBandaLarga().issKY());
		chkBandaLargaHD.setChecked(objInstalacaoReceptores.getBandaLarga().ishD());
		chkBandaLargaFullHD.setChecked(objInstalacaoReceptores.getBandaLarga().isFullHD());
		chkBandaLargaHDCanaisAbertos.setChecked(objInstalacaoReceptores.getBandaLarga().isHdAdicionais());
	}
	
	private boolean validaCampos(){
		if(!rbCasa.isChecked() && !rbApto.isChecked()){
			SingletonUtilitario.imprime(CONTEXTO, getString(R.string.lblAtencao), getString(R.string.lblENecessarioSelecionarCasaOuApto));
			return false;
		}
		if(edtEndereco == null || edtEndereco.getText().toString().equals("")){
			SingletonUtilitario.imprime(CONTEXTO, getString(R.string.lblAtencao), getString(R.string.lblEObrigatorioOPreenchimentoDoCampo) + " ENDEREÇO");
			return false;
		}
		if(edtNumero == null || edtNumero.getText().toString().equals("")){
			SingletonUtilitario.imprime(CONTEXTO, getString(R.string.lblAtencao), getString(R.string.lblEObrigatorioOPreenchimentoDoCampo) + " NÚMERO");
			return false;
		}
		if(edtAptoCasa == null || edtAptoCasa.getText().toString().equals("")){
			SingletonUtilitario.imprime(CONTEXTO, getString(R.string.lblAtencao), getString(R.string.lblEObrigatorioOPreenchimentoDoCampo) + " APTO/CASA");
			return false;
		}
		if(edtBairro == null || edtBairro.getText().toString().equals("")){
			SingletonUtilitario.imprime(CONTEXTO, getString(R.string.lblAtencao), getString(R.string.lblEObrigatorioOPreenchimentoDoCampo) + " BAIRRO");
			return false;
		}
		if(edtCidade == null || edtCidade.getText().toString().equals("")){
			SingletonUtilitario.imprime(CONTEXTO, getString(R.string.lblAtencao), getString(R.string.lblEObrigatorioOPreenchimentoDoCampo) + " CIDADE");
			return false;
		}
		if(edtUF == null || edtUF.getText().toString().equals("")){
			SingletonUtilitario.imprime(CONTEXTO, getString(R.string.lblAtencao), getString(R.string.lblEObrigatorioOPreenchimentoDoCampo) + " UF");
			return false;
		}
		if(edtCEP == null || edtCEP.getText().toString().equals("")){
			SingletonUtilitario.imprime(CONTEXTO, getString(R.string.lblAtencao), getString(R.string.lblEObrigatorioOPreenchimentoDoCampo) + " CEP");
			return false;
		}
		return true;
	}

	private InstalacaoDosReceptores criaObjeto(){
		Receptor principal = new Receptor(0, chkPrincipalSKY.isChecked(), chkPrincipalHD.isChecked(), 
				chkPrincipalFullHD.isChecked(), chkPrincipalHDCanaisAbertos.isChecked());
		Receptor opcional = new Receptor(0, chkOpcionalSKY.isChecked(), chkOpcionalHD.isChecked(), 
				chkOpcionalFullHD.isChecked(), chkOpcionalHDCanaisAbertos.isChecked());
		Receptor bandaLarga = new Receptor(0, chkBandaLargaSKY.isChecked(), chkBandaLargaHD.isChecked(), 
				chkBandaLargaFullHD.isChecked(), chkBandaLargaHDCanaisAbertos.isChecked());
		Endereco endereco = new Endereco(0, edtEndereco.getText().toString(), edtNumero.getText().toString(), 
				edtAptoCasa.getText().toString(), edtComplemento.getText().toString(), edtBairro.getText().toString(), 
				edtCidade.getText().toString(), edtUF.getText().toString(), edtCEP.getText().toString());

		InstalacaoDosReceptores objInstalacao = new InstalacaoDosReceptores(0, rbCasa.isChecked(), endereco, 
				edtNomeCondominio.getText().toString(), edtNomeEdificio.getText().toString(), 
				edtPontoReferencia.getText().toString(), edtNomeResponsavelAntendimentoInstalador.getText().toString(), 
				principal, opcional, bandaLarga);
		objInstalacaoReceptores = objInstalacao;
		return objInstalacao;
	}
}
