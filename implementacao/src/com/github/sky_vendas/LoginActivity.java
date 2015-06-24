package com.github.sky_vendas;

import java.io.UnsupportedEncodingException;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.sky_vendas.R;
import com.github.sky_vendas.model.Usuario;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class LoginActivity extends Activity {
	private final Context CONTEXTO = this;
	private final int LOGIN_REQUEST = 23;
	private EditText login;
	private EditText senha;
	private Button entrar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		login = (EditText) findViewById(R.id.edtLogin);
		senha = (EditText) findViewById(R.id.edtSenha);
		entrar = (Button) findViewById(R.id.btnEntrar);
		entrar.setOnClickListener(lstEntrar);
		
		/* Se o usuario ja tiver feito o login ele estará salva no SharedPreferences e abre o sistema direto */
		SharedPreferences preferences =	getSharedPreferences("skyvendas", Context.MODE_PRIVATE);
		String login = preferences.getString("usuarioLogadoLogin", "");
		if(!login.equals("")){
			Intent i = new Intent(CONTEXTO, MainActivity.class);
			startActivityForResult(i, LOGIN_REQUEST);
		}
	}

	private OnClickListener lstEntrar = new OnClickListener() {		
		@Override
		public void onClick(View v) {
			if(!isOnline()){
				Toast.makeText(CONTEXTO, R.string.lblParaEntrarNoSistemaConecteseAInternet, Toast.LENGTH_LONG).show();
			}else{
				if(validaCampos()){
					logarWEB();
				}
			}
		}
	};
	
	private void logar(Usuario usu){
		if(usu != null){
			SharedPreferences preferences =	getSharedPreferences("skyvendas", Context.MODE_PRIVATE);
			Editor editor = preferences.edit();
			editor.putString("usuarioLogadoLogin", usu.getLogin());
			editor.putString("usuarioLogadoSenha", usu.getSenha());
			editor.commit();

			Intent i = new Intent(CONTEXTO, MainActivity.class);
			startActivityForResult(i, LOGIN_REQUEST);	
		} else{
			SingletonUtilitario.imprime(CONTEXTO, getString(R.string.lblAtencao), getString(R.string.lblUsuarioEOuSenhaInvalidos));
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == LOGIN_REQUEST) {
	    	if (resultCode == 100) {
	    		this.finish();
	        }
	    }
	}

	private boolean validaCampos(){
		if(login.getText().toString().equals("") || login == null){
			Toast.makeText(CONTEXTO, R.string.lblOPreenchimentoDoCampoLOGINEObrigatorio, Toast.LENGTH_SHORT).show();
			return false;
		}
		if(senha.getText().toString().equals("") || senha == null){
			Toast.makeText(CONTEXTO, R.string.lblOPreenchimentoDoCampoSENHAEObrigatorio, Toast.LENGTH_SHORT).show();
			return false;
		}
		return true;
	}

	private void logarWEB(){
		String tLogin = login.getText().toString();
		String tSenha = senha.getText().toString();
		
		String resourceURL = SingletonUtilitario.getResourceURL() + "/login";
		AsyncHttpClient httpClient = new AsyncHttpClient();

		JSONObject params = new JSONObject();
		try {
			params.put("login", tLogin);
			params.put("senha", tSenha);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		
		StringEntity entity = null;
		try {
			entity = new StringEntity(params.toString());
			entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));	 
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		httpClient.post(CONTEXTO, resourceURL, entity, "application/json", new JsonHttpResponseHandler() {
			public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
				try {
					logar(new Usuario(response.getString("login"), response.getString("senha")));
				} catch (JSONException e) {
					logar(null);
					e.printStackTrace();
				}
			};
		});
	}
	
	private boolean isOnline(){
		ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		return manager.getActiveNetworkInfo() != null && manager.getActiveNetworkInfo().isConnectedOrConnecting();
	}
}
