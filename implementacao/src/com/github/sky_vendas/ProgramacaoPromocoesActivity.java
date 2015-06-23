package com.github.sky_vendas;

import com.example.sky_vendas.R;
import com.example.sky_vendas.R.layout;
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
import android.widget.ImageButton;

public class ProgramacaoPromocoesActivity extends Activity {
	private final Context CONTEXTO = this;
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
		setContentView(R.layout.activity_programacao_promocoes);
		
		btnVoltar = (ImageButton) findViewById(R.id.btnVoltar5);
		btnVoltar.setOnClickListener(lstVoltar);
		btnAvancar = (ImageButton) findViewById(R.id.btnAvancar5);
		btnAvancar.setOnClickListener(lstAvancar);

		objDadosCliente = (DadosCliente) getIntent().getSerializableExtra("objDadosCliente");
		objInstalacaoReceptores = (InstalacaoDosReceptores) getIntent().getSerializableExtra("objInstalacaoReceptores");
		objEnderecoCobranca = (Endereco) getIntent().getSerializableExtra("objEnderecoCobranca");
		objProgramacaoPromocoes = (ProgramacaoPromocoes) getIntent().getSerializableExtra("objProgramacaoPromocoes");
		objComodatoVendas = (ComodatoVendas) getIntent().getSerializableExtra("objComodatoVendas");
		objDadosParaDebito = (DadosParaDebito) getIntent().getSerializableExtra("objDadosParaDebito");
	}
	
	private OnClickListener lstAvancar = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent i = new Intent(CONTEXTO, ComodatoVendaActivity.class);
			i.putExtra("objDadosCliente", objDadosCliente);
			i.putExtra("objInstalacaoReceptores", objInstalacaoReceptores);
			i.putExtra("objEnderecoCobranca", objEnderecoCobranca);
			i.putExtra("objComodatoVendas", objComodatoVendas);
			i.putExtra("objDadosParaDebito", objDadosParaDebito);

			//i.putExtra("objProgramacaoPromocoes", criaObjeto());
			startActivity(i);
		}
	};
	private OnClickListener lstVoltar = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent i = new Intent(CONTEXTO, EnderecoCobrancaActivity.class);
			i.putExtra("objDadosCliente", objDadosCliente);
			i.putExtra("objInstalacaoReceptores", objInstalacaoReceptores);
			i.putExtra("objEnderecoCobranca", objEnderecoCobranca);
			i.putExtra("objComodatoVendas", objComodatoVendas);
			i.putExtra("objDadosParaDebito", objDadosParaDebito);

			//i.putExtra("objProgramacaoPromocoes", criaObjeto());
			startActivity(i);			
		}
	};
}
