package com.github.sky_vendas;

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

public class ComodatoVendaActivity extends Activity {
	private final Context CONTEXTO = this;

	private CheckBox chkTaxaDeAdesao;
	private CheckBox chkVenda;
	private EditText edtValor;
	private CheckBox chkCartaoCreditoDebito;
	private CheckBox chkDebitoAutomatico;
	private CheckBox chkFichaCompensacao;
	private CheckBox chkCEFFInanciamento;
	private CheckBox chkPECPFB;
	private CheckBox chkCartaoCreditoDebitoMensalidadeProgramacao;
	private CheckBox chkDebitoAutomaticoMensalidadeProgramacao;
	private CheckBox chkBoletoBancario;
	private RadioButton rbAVista;
	private RadioButton rbParcelado;
	private EditText edtValorPrePago;
	private EditText edtQuantidadeDeParcelas;
	private EditText edtValorDaParcela;
	private ImageButton btnVoltar;
	private ImageButton btnAvancar;
	
	/* Objetos compartilhados */
	private DadosCliente objDadosCliente;
	private InstalacaoDosReceptores objInstalacaoReceptores;
	private Endereco objEnderecoCobranca;
	private ProgramacaoPromocoes objProgramacaoPromocoes;
	private ComodatoVendas objComodatoVendas;
	private DadosParaDebito objDadosParaDebito;
	/*		*/
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comodato_venda);
		
		chkTaxaDeAdesao = (CheckBox) findViewById(R.id.chkTaxaDeAdesao);
		chkVenda = (CheckBox) findViewById(R.id.chkVenda);
		edtValor = (EditText) findViewById(R.id.edtValor);
		chkCartaoCreditoDebito = (CheckBox) findViewById(R.id.chkCartaoCreditoEDebito);
		chkDebitoAutomatico = (CheckBox) findViewById(R.id.chkDebitoAutomaticoContaCorrente);
		chkFichaCompensacao = (CheckBox) findViewById(R.id.chkFichaDeCompensacao);
		chkCEFFInanciamento = (CheckBox) findViewById(R.id.chkCEFFinanciamento);
		chkPECPFB = (CheckBox) findViewById(R.id.chkPECPFB);
		chkCartaoCreditoDebitoMensalidadeProgramacao = (CheckBox) findViewById(R.id.chkCartaoCreditoDebitoMensalidadesProgramacao);
		chkDebitoAutomaticoMensalidadeProgramacao = (CheckBox) findViewById(R.id.chkDebitoAutomaticoContaCorrenteMensalidadesProgramacao);
		chkBoletoBancario = (CheckBox) findViewById(R.id.chkBoletoBancario);
		rbAVista = (RadioButton) findViewById(R.id.rbAVista);
		rbParcelado= (RadioButton) findViewById(R.id.rbParcelado);
		edtValorPrePago = (EditText) findViewById(R.id.edtValorPrePago);
		edtQuantidadeDeParcelas = (EditText) findViewById(R.id.edtQuantidadeDeParcelas);
		edtValorDaParcela = (EditText) findViewById(R.id.edtValorDaParcela);
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

		if(objComodatoVendas != null)
			preencheTela();
	}
	
	private OnClickListener lstVoltar = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent i = new Intent(CONTEXTO, ProgramacaoPromocoesActivity.class);
			i.putExtra("objDadosCliente", objDadosCliente);
			i.putExtra("objInstalacaoReceptores", objInstalacaoReceptores);
			i.putExtra("objEnderecoCobranca", objEnderecoCobranca);
			i.putExtra("objProgramacaoPromocoes", objProgramacaoPromocoes);
			i.putExtra("objDadosParaDebito", objDadosParaDebito);
			
			i.putExtra("objComodatoVendas", criaObjeto());
			startActivity(i);
		}
	};
	
	private OnClickListener lstAvancar = new OnClickListener() {
		@Override
		public void onClick(View v) {
			if(validaCampos()){
				Intent i = new Intent(CONTEXTO, DadosParaDebitoActivity.class);
				i.putExtra("objDadosCliente", objDadosCliente);
				i.putExtra("objInstalacaoReceptores", objInstalacaoReceptores);
				i.putExtra("objEnderecoCobranca", objEnderecoCobranca);
				i.putExtra("objProgramacaoPromocoes", objProgramacaoPromocoes);
				i.putExtra("objDadosParaDebito", objDadosParaDebito);

				i.putExtra("objComodatoVendas", criaObjeto());
				startActivity(i);
			}
		}
	};

	private boolean validaCampos(){
		if(edtValor == null || edtValor.getText().toString().equals("")){
			SingletonUtilitario.imprime(CONTEXTO, getString(R.string.lblAtencao), getString(R.string.lblEObrigatorioOPreenchimentoDoCampo) + " VALOR");
			return false;
		}
		return true;
	}
	
	private ComodatoVendas criaObjeto(){
		ComodatoVendas comodatoVendas = new ComodatoVendas(0, chkTaxaDeAdesao.isChecked(), chkVenda.isChecked(), 
				Format.getDouble(edtValor.getText().toString(), 0.0), chkCartaoCreditoDebito.isChecked(), 
				chkDebitoAutomatico.isChecked(), chkFichaCompensacao.isChecked(), chkPECPFB.isChecked(), 
				chkCEFFInanciamento.isChecked(), chkCartaoCreditoDebitoMensalidadeProgramacao.isChecked(), 
				chkDebitoAutomaticoMensalidadeProgramacao.isChecked(), chkBoletoBancario.isChecked(), 
				(rbAVista.isChecked() ? true : false), (rbParcelado.isChecked() ? true : false), 
				Format.getDouble(edtValorPrePago.getText().toString(), 0.0), 
				Format.getInt(edtQuantidadeDeParcelas.getText().toString()),
				Format.getDouble(edtValorDaParcela.getText().toString(), 0.0));
		this.objComodatoVendas = comodatoVendas;
		return comodatoVendas;
	}

	private void preencheTela(){
		chkTaxaDeAdesao.setChecked(objComodatoVendas.isAtoTaxaDeAdesaoComodato());
		chkVenda.setChecked(objComodatoVendas.isAtoVenda());
		edtValor.setText(Format.getString(objComodatoVendas.getAtoValor()));
		chkCartaoCreditoDebito.setChecked(objComodatoVendas.isAtoCartaoCreditoDebito());
		chkDebitoAutomatico.setChecked(objComodatoVendas.isAtoDebitoAutomaticoContaCorrente());
		chkFichaCompensacao.setChecked(objComodatoVendas.isAtoFichaCompensacao());
		chkCEFFInanciamento.setChecked(objComodatoVendas.isAtoCEFFinanciamento());
		chkPECPFB.setChecked(objComodatoVendas.isAtoPECPPB());
		chkCartaoCreditoDebitoMensalidadeProgramacao.setChecked(objComodatoVendas.isMensalidadeCartaoCreditoDebito());
		chkDebitoAutomaticoMensalidadeProgramacao.setChecked(objComodatoVendas.isMensalidadeDebitoAutomaticoContaCorrente());
		chkBoletoBancario.setChecked(objComodatoVendas.isMensalidadeBoletoBancario());
		rbAVista.setChecked(objComodatoVendas.isPrePagoAVista());
		rbParcelado.setChecked(objComodatoVendas.isPrePagoparcelado12meses());
		edtValorPrePago.setText(Format.getString(objComodatoVendas.getPrePagoValor()));
		edtQuantidadeDeParcelas.setText(Format.getString(objComodatoVendas.getPrePagoQtdParcelas()));
		edtValorDaParcela.setText(Format.getString(objComodatoVendas.getPrePagoValorParcela()));
	}
}
