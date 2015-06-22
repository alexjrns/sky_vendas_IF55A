package com.github.sky_vendas;

import com.example.sky_vendas.R;
import com.example.sky_vendas.R.layout;

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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_programacao_promocoes);
		
		btnVoltar = (ImageButton) findViewById(R.id.btnVoltar5);
		btnVoltar.setOnClickListener(lstVoltar);
		btnAvancar = (ImageButton) findViewById(R.id.btnAvancar5);
		btnAvancar.setOnClickListener(lstAvancar);
	}
	
	private OnClickListener lstAvancar = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent i = new Intent(CONTEXTO, ComodatoVendaActivity.class);
			/*i.putExtra("objDadosCliente", objDadosCliente);
			i.putExtra("objInstalacaoDosReceptores", objInstalacaoReceptores);
			i.putExtra("objEnderecoCobranca", criaObjeto());*/
			startActivity(i);
		}
	};
	private OnClickListener lstVoltar = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent i = new Intent(CONTEXTO, EnderecoCobrancaActivity.class);
			/*i.putExtra("objDadosCliente", objDadosCliente);
			i.putExtra("objInstalacaoDosReceptores", objInstalacaoReceptores);
			i.putExtra("objEnderecoCobranca", criaObjeto());*/
			startActivity(i);			
		}
	};
}
