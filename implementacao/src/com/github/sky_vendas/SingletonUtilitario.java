package com.github.sky_vendas;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;

public abstract class SingletonUtilitario {
	//private static String resourceURL = "http://10.0.2.2:4000";
	//private static String resourceURL = "http://177.40.74.244:8080"; /* Em casa */
	private static String resourceURL = "http://200.150.82.154:8984"; /* No trabalho */
	
	public SingletonUtilitario() {
	}

	public static String getResourceURL() {
		return resourceURL;
	}

	public static void imprime(Context contexto, String titulo, CharSequence mensagem){
		Builder alertDialogBuilder = new Builder(contexto);
		alertDialogBuilder.setTitle(titulo);
		alertDialogBuilder.setMessage(mensagem);
		alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				arg0.cancel();
			}
		});
		AlertDialog dialog = alertDialogBuilder.create();
		dialog.show();		
	}
}
