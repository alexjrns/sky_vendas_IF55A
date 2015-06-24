package com.github.sky_vendas;

import com.example.sky_vendas.R;
import com.github.sky_vendas.model.ComodatoVendas;
import com.github.sky_vendas.model.DadosCliente;
import com.github.sky_vendas.model.DadosParaDebito;
import com.github.sky_vendas.model.Endereco;
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

public class DadosParaDebitoActivity extends Activity {
	private final Context CONTEXTO = this;
	
	private CheckBox chkDebitoVisa;
	private CheckBox chkDebitoHipercard;
	private CheckBox chkDebitoDiners;
	private CheckBox chkDebitoMasterCard;
	private CheckBox chkDebitoAmex;
	private CheckBox chkDebitoElo;
	private EditText edtNumeroDoCartao;
	private EditText edtDataDeValidadeDoCartao;
	private CheckBox chkBanrisul;
	private CheckBox chkBradesco;
	private CheckBox chkBancoDoBrasil;
	private CheckBox chkCitibank;
	private CheckBox chkCIF;
	private CheckBox chkHSBC;
	private CheckBox chkItau;
	private CheckBox chkSantander;
	private CheckBox chkSicredi;
	private EditText edtAgencia;
	private EditText edtContaCorrente;
	private ImageButton btnVoltar;
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
		setContentView(R.layout.activity_dados_para_debito);
		
		chkDebitoVisa = (CheckBox) findViewById(R.id.chkDebitoVisa);
		chkDebitoHipercard = (CheckBox) findViewById(R.id.chkDebitoHipercard);
		chkDebitoDiners = (CheckBox) findViewById(R.id.chkDebitoDiners);
		chkDebitoMasterCard = (CheckBox) findViewById(R.id.chkDebitoMasterCard);
		chkDebitoAmex = (CheckBox) findViewById(R.id.chkDebitoAmex);
		chkDebitoElo = (CheckBox) findViewById(R.id.chkDebitoElo);
		edtNumeroDoCartao = (EditText) findViewById(R.id.edtNumeroCartao);
		edtDataDeValidadeDoCartao = (EditText) findViewById(R.id.edtDataDeValidadeCartao);
		chkBanrisul = (CheckBox) findViewById(R.id.chkbanrisul);
		chkBradesco = (CheckBox) findViewById(R.id.chkBradesco);
		chkBancoDoBrasil = (CheckBox) findViewById(R.id.chkBancoDoBrasil);
		chkCitibank = (CheckBox) findViewById(R.id.chkCitibank);
		chkCIF = (CheckBox) findViewById(R.id.chkCIF);
		chkHSBC = (CheckBox) findViewById(R.id.chkHSBC);
		chkItau = (CheckBox) findViewById(R.id.chkItau);
		chkSantander = (CheckBox) findViewById(R.id.chkSantander);
		chkSicredi = (CheckBox) findViewById(R.id.chkSicredi);
		edtAgencia = (EditText) findViewById(R.id.edtAgencia);
		edtContaCorrente = (EditText) findViewById(R.id.edtContaCorrente);
		btnVoltar = (ImageButton) findViewById(R.id.btnVoltar6);
		btnVoltar.setOnClickListener(lstVoltar);
		btnAvancar = (ImageButton) findViewById(R.id.btnAvancar6);
		btnAvancar.setOnClickListener(lstAvancar);
		
		objDadosCliente = (DadosCliente) getIntent().getSerializableExtra("objDadosCliente");
		objInstalacaoReceptores = (InstalacaoDosReceptores) getIntent().getSerializableExtra("objInstalacaoReceptores");
		objEnderecoCobranca = (Endereco) getIntent().getSerializableExtra("objEnderecoCobranca");
		objProgramacaoPromocoes = (ProgramacaoPromocoes) getIntent().getSerializableExtra("objProgramacaoPromocoes");
		objComodatoVendas = (ComodatoVendas) getIntent().getSerializableExtra("objComodatoVendas");
		objDadosParaDebito = (DadosParaDebito) getIntent().getSerializableExtra("objDadosParaDebito");

		if(objDadosParaDebito != null)
			preencheTela();
	}
	
	private OnClickListener lstVoltar = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent i = new Intent(CONTEXTO, ComodatoVendaActivity.class);
			i.putExtra("objDadosCliente", objDadosCliente);
			i.putExtra("objInstalacaoReceptores", objInstalacaoReceptores);
			i.putExtra("objEnderecoCobranca", objEnderecoCobranca);
			i.putExtra("objProgramacaoPromocoes", objProgramacaoPromocoes);
			i.putExtra("objComodatoVendas", objComodatoVendas);

			i.putExtra("objDadosParaDebito", criaObjeto());
			startActivity(i);
			
		}
	};
	
	private OnClickListener lstAvancar = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent i = new Intent(CONTEXTO, ConfirmaPedidoActivity.class);
			i.putExtra("objDadosCliente", objDadosCliente);
			i.putExtra("objInstalacaoReceptores", objInstalacaoReceptores);
			i.putExtra("objEnderecoCobranca", objEnderecoCobranca);
			i.putExtra("objProgramacaoPromocoes", objProgramacaoPromocoes);
			i.putExtra("objComodatoVendas", objComodatoVendas);

			i.putExtra("objDadosParaDebito", criaObjeto());
			startActivity(i);
			
		}
	};
	
	private DadosParaDebito criaObjeto(){
		DadosParaDebito dadosParaDebito = new DadosParaDebito(0, chkDebitoVisa.isChecked(), chkDebitoHipercard.isChecked(), 
				chkDebitoDiners.isChecked(), chkDebitoMasterCard.isChecked(), chkDebitoAmex.isChecked(), 
				chkDebitoElo.isChecked(), edtNumeroDoCartao.getText().toString(), edtDataDeValidadeDoCartao.getText().toString(),
				edtAgencia.getText().toString(), edtContaCorrente.getText().toString(), chkBanrisul.isChecked(), 
				chkBradesco.isChecked(), chkBancoDoBrasil.isChecked(), chkCitibank.isChecked(), chkCIF.isChecked(), 
				chkHSBC.isChecked(), chkItau.isChecked(), chkSantander.isChecked(), chkSicredi.isChecked());
		this.objDadosParaDebito = dadosParaDebito;
		return dadosParaDebito;
	}
	
	private void preencheTela(){
		chkDebitoVisa.setChecked(objDadosParaDebito.isVisa());
		chkDebitoHipercard.setChecked(objDadosParaDebito.isHipercard());
		chkDebitoDiners.setChecked(objDadosParaDebito.isDinners());
		chkDebitoMasterCard.setChecked(objDadosParaDebito.isMasterCard());
		chkDebitoAmex.setChecked(objDadosParaDebito.isAmex());
		chkDebitoElo.setChecked(objDadosParaDebito.isElo());
		edtNumeroDoCartao.setText(objDadosParaDebito.getNumeroCartao());
		edtDataDeValidadeDoCartao.setText(objDadosParaDebito.getDataValidade());
		chkBanrisul.setChecked(objDadosParaDebito.isBanrisul());
		chkBradesco.setChecked(objDadosParaDebito.isBradesco());
		chkBancoDoBrasil.setChecked(objDadosParaDebito.isBancoBrasil());
		chkCitibank.setChecked(objDadosParaDebito.isCityBank());
		chkCIF.setChecked(objDadosParaDebito.iscEF());
		chkHSBC.setChecked(objDadosParaDebito.ishSBC());
		chkItau.setChecked(objDadosParaDebito.isItau());
		chkSantander.setChecked(objDadosParaDebito.isSantander());
		chkSicredi.setChecked(objDadosParaDebito.isSicredi());
		edtAgencia.setText(objDadosParaDebito.getAgencia());
		edtContaCorrente.setText(objDadosParaDebito.getContaCorrente());
	}
}
