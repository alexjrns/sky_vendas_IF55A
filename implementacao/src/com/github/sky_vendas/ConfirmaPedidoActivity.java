package com.github.sky_vendas;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.sky_vendas.R;
import com.example.sky_vendas.R.id;
import com.example.sky_vendas.R.layout;
import com.github.sky_vendas.model.ComodatoVendas;
import com.github.sky_vendas.model.DadosCliente;
import com.github.sky_vendas.model.DadosParaDebito;
import com.github.sky_vendas.model.Endereco;
import com.github.sky_vendas.model.InstalacaoDosReceptores;
import com.github.sky_vendas.model.PedidoVenda;
import com.github.sky_vendas.model.ProgramacaoPromocoes;
import com.github.sky_vendas.model.Usuario;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmaPedidoActivity extends Activity {
	private Context CONTEXTO = this;
	
	/* Objetos compartilhados */
	private DadosCliente objDadosCliente;
	private InstalacaoDosReceptores objInstalacaoReceptores;
	private Endereco objEnderecoCobranca;
	private ProgramacaoPromocoes objProgramacaoPromocoes;
	private ComodatoVendas objComodatoVendas;
	private DadosParaDebito objDadosParaDebito;
	/**/
	
	private TextView txtNomeCliente;
	private Button btnConfirmar;
	private Button btnInserirFoto;
	int fotoNumber = 0;
	String photoName;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirma_pedido);

		txtNomeCliente = (TextView) findViewById(R.id.txtNomeCliente);
		
		objDadosCliente = (DadosCliente) getIntent().getSerializableExtra("objDadosCliente");
		objInstalacaoReceptores = (InstalacaoDosReceptores) getIntent().getSerializableExtra("objInstalacaoReceptores");
		objEnderecoCobranca = (Endereco) getIntent().getSerializableExtra("objEnderecoCobranca");
		objProgramacaoPromocoes = (ProgramacaoPromocoes) getIntent().getSerializableExtra("objProgramacaoPromocoes");
		objComodatoVendas = (ComodatoVendas) getIntent().getSerializableExtra("objComodatoVendas");
		objDadosParaDebito = (DadosParaDebito) getIntent().getSerializableExtra("objDadosParaDebito");
		
		if(objDadosCliente != null)
			txtNomeCliente.setText(objDadosCliente.getNomeRazao());
		btnConfirmar = (Button) findViewById(R.id.btnConfirmaPedido);
		btnConfirmar.setOnClickListener(lstConfirmar);
		
		btnInserirFoto = (Button) findViewById(R.id.btnInserirFoto);
		btnInserirFoto.setOnClickListener(lstInserirFoto);
	}
	
	private OnClickListener lstInserirFoto = new OnClickListener() {
		@Override
		public void onClick(View v) {
			PackageManager packageManager = CONTEXTO.getPackageManager();
			if(packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {

				Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				i.putExtra(MediaStore.EXTRA_OUTPUT, getCaminhoArquivo());
				if(i.resolveActivity(CONTEXTO.getPackageManager()) != null) {
					startActivityForResult(i, 34);
				}
				else {
					Toast.makeText(CONTEXTO, getString(R.string.lblVoceNaoPossuiUmAplicativoDeCameraPadrao), Toast.LENGTH_SHORT).show();
				}
			}
			else {
				Toast.makeText(CONTEXTO, getString(R.string.lblSeuDispositivoNaoPossuiCameraFotografica), Toast.LENGTH_SHORT).show();
			}
		}
	};
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 34) {
			if (resultCode == RESULT_OK) {
				Uri takenPhotoUri = Uri.fromFile(new File(photoName));
				Bitmap takenImage = BitmapFactory.decodeFile(takenPhotoUri.getPath());
				ImageView ivPreview = (ImageView) findViewById(R.id.imgAssinatura);
				ivPreview.setImageBitmap(takenImage);
			} 
			else { 
				Toast.makeText(this, "Picture was not taken!", Toast.LENGTH_SHORT).show();
			}
		}
	}

	protected Uri getCaminhoArquivo() {
		File diretorioMidia = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "medias06");

		if (!diretorioMidia.exists() && !diretorioMidia.mkdirs())
			Log.d("medias06", "error creating the file");

		fotoNumber++;
		String fileName = "foto" + fotoNumber + ".jpg";
		photoName = diretorioMidia.getPath() + File.separator + fileName;

		return Uri.fromFile(new File(photoName));
	}
	
	private OnClickListener lstConfirmar = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Builder alertDialogBuilder = new Builder(CONTEXTO);
			alertDialogBuilder.setTitle(R.string.lblPergunta);
			alertDialogBuilder.setMessage(R.string.lblTemCertezaQueDesejaSalvarEEnviarEssePedido);
			alertDialogBuilder.setCancelable(false);

			alertDialogBuilder.setPositiveButton(R.string.lblSim, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					setResult(100);
					enviaPedido();
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
	};

	private PedidoVenda criaPedido(){
		return new PedidoVenda(0, Calendar.getInstance(), 15, null, objDadosCliente, objInstalacaoReceptores,
				objEnderecoCobranca, objProgramacaoPromocoes, objComodatoVendas, objDadosParaDebito);
	}
	
	private void enviaPedido(){
		PedidoVenda pPedido = criaPedido();

		String resourceURL = SingletonUtilitario.getResourceURL() + "/pedido";
		AsyncHttpClient httpClient = new AsyncHttpClient();

		JSONObject params = new JSONObject();
		try {
			params.put("pedido", pPedido);
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
				Toast.makeText(CONTEXTO, R.string.lblPedidoCadastradoComSucesso, Toast.LENGTH_SHORT).show();
				startActivity(new Intent(CONTEXTO, MainActivity.class));
				/*try {
					logar(new Usuario(response.getString("login"), response.getString("senha")));
				} catch (JSONException e) {
					e.printStackTrace();
				}*/
			};
		});
		Toast.makeText(CONTEXTO, "Post Feito", Toast.LENGTH_SHORT).show();
	}
}
