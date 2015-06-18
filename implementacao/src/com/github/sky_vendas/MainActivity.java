package com.github.sky_vendas;

import com.example.sky_vendas.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	private final Context CONTEXTO = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

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
