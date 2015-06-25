package com.github.sky_vendas;

import com.example.sky_vendas.R;
import com.example.sky_vendas.R.id;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

public class PontoDeVendaActivity extends Activity {
	private final Context CONTEXTO = this;
	private Spinner spnPontosDeVenda;
	private ImageButton btnAvancar;
	
	private String[] arraySpinner;
	
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
		setContentView(R.layout.activity_ponto_de_venda);
		
		objDadosCliente = (DadosCliente) getIntent().getSerializableExtra("objDadosCliente");
		objInstalacaoReceptores = (InstalacaoDosReceptores) getIntent().getSerializableExtra("objInstalacaoReceptores");
		objEnderecoCobranca = (Endereco) getIntent().getSerializableExtra("objEnderecoCobranca");
		objProgramacaoPromocoes = (ProgramacaoPromocoes) getIntent().getSerializableExtra("objProgramacaoPromocoes");
		objComodatoVendas = (ComodatoVendas) getIntent().getSerializableExtra("objComodatoVendas");
		objDadosParaDebito = (DadosParaDebito) getIntent().getSerializableExtra("objDadosParaDebito");		

		btnAvancar = (ImageButton) findViewById(R.id.btnAvancar1);
		btnAvancar.setOnClickListener(lstAvancar);
		spnPontosDeVenda = (Spinner) findViewById(R.id.spnPontoVenda);
		
		arraySpinner = new String[]{ "SKY Londrina"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner);
        spnPontosDeVenda.setAdapter(adapter);
	}

	private OnClickListener lstAvancar = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent i = new Intent(CONTEXTO, DadosClienteActivity.class);
			i.putExtra("objDadosCliente", objInstalacaoReceptores);
			i.putExtra("objInstalacaoReceptores", objInstalacaoReceptores);
			i.putExtra("objEnderecoCobranca", objEnderecoCobranca);
			i.putExtra("objProgramacaoPromocoes", objProgramacaoPromocoes);
			i.putExtra("objComodatoVendas", objComodatoVendas);
			i.putExtra("objDadosParaDebito", objDadosParaDebito);
			startActivity(i);
		}
	};
}
