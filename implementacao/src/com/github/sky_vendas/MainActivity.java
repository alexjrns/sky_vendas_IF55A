package com.github.sky_vendas;

import com.example.sky_vendas.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	private final Context CONTEXTO = this;
	
	private ImageButton btnCadastrar;
	private ImageButton btnVisualizar;
	private ImageButton btnEditar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnCadastrar = (ImageButton) findViewById(R.id.btnCadastrar);
		btnCadastrar.setOnClickListener(lstCadastrar);
		btnVisualizar = (ImageButton) findViewById(R.id.btnVisualizar);
		btnVisualizar.setOnClickListener(lstVisualizar);
		btnEditar = (ImageButton) findViewById(R.id.btnEditar);
		btnEditar.setOnClickListener(lstEditar);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	OnClickListener lstCadastrar = new OnClickListener() {		
		@Override
		public void onClick(View v) {
			Intent i = new Intent(CONTEXTO, DadosClienteActivity.class);
			startActivity(i);
		}
	};
	
	OnClickListener lstVisualizar = new OnClickListener() {
		@Override
		public void onClick(View v) {

		}
	};
	
	OnClickListener lstEditar = new OnClickListener() {
		@Override
		public void onClick(View v) {

		}
	};

	private void confirmaSair(){
		Builder alertDialogBuilder = new Builder(CONTEXTO);
		alertDialogBuilder.setTitle(R.string.lblPergunta);
		alertDialogBuilder.setMessage(R.string.lblTemCertezaQueDesejaSairDoSistema);
		alertDialogBuilder.setCancelable(false);

		alertDialogBuilder.setPositiveButton(R.string.lblSim, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				setResult(100);
				MainActivity.this.finish();
			}
		});			
		
		alertDialogBuilder.setNegativeButton(R.string.lblNao, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				arg0.cancel();	
			}
		});
		AlertDialog dialog = alertDialogBuilder.create();
		dialog.show();			
	}	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}

		if (id == R.id.action_sair) {
			confirmaSair();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
