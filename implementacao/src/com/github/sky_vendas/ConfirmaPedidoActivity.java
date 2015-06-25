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
import com.github.sky_vendas.model.Format;
import com.github.sky_vendas.model.InstalacaoDosReceptores;
import com.github.sky_vendas.model.PedidoVenda;
import com.github.sky_vendas.model.ProgramacaoPromocoes;
import com.github.sky_vendas.model.Receptor;
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
	private int fotoNumber = 0;
	private String photoName;

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

		
		btnInserirFoto = (Button) findViewById(R.id.btnInserirImagem);
		//btnInserirFoto.setOnClickListener(lstInserirFoto);
	}

	private OnClickListener lstInserirFoto = new OnClickListener() {
	@Override
	public void onClick(View v) {
		PackageManager packageManager = CONTEXTO.getPackageManager();
		if(packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {

			Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			//i.putExtra(MediaStore.EXTRA_OUTPUT, getCaminhoArquivo());
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
	/*
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
			Log.d("skyvendas", "erro na criacao do arquivo");
	
		fotoNumber++;
		String fileName = "foto" + fotoNumber + ".jpg";
		photoName = diretorioMidia.getPath() + File.separator + fileName;
	
		return Uri.fromFile(new File(photoName));
	}
*/
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
	
	private String criaJSON(PedidoVenda tPedido){
		String jason = "{\n";
		/* Objeto dados do cliente */
		jason += "\"dadosDoCliente\":{\n";	
			jason += ("\"codigo\":" + tPedido.getDadosDoCliente().getCodigo() + ", \n");
			jason += Format.jsonString("tipoPessoa", tPedido.getDadosDoCliente().getTipoPessoa());
			//params.put("dataNascimento", tPedido.getDadosDoCliente().getDataNascimento());
			jason += Format.jsonString("nomeRazao", tPedido.getDadosDoCliente().getNomeRazao());
			jason += Format.jsonString("telefoneResidencial", tPedido.getDadosDoCliente().getTelefoneResidencial());
			jason += Format.jsonString("telefoneComercial", tPedido.getDadosDoCliente().getTelefoneComercial());
			jason += Format.jsonString("ramal", tPedido.getDadosDoCliente().getRamal());
			jason += Format.jsonString("telefoneCelular", tPedido.getDadosDoCliente().getTelefoneCelular());
			jason += Format.jsonString("estadoCivil", tPedido.getDadosDoCliente().getEstadoCivil());
			jason += Format.jsonString("cpfCNPJ", tPedido.getDadosDoCliente().getCpfCNPJ());
			jason += Format.jsonString("rgIeRNE", tPedido.getDadosDoCliente().getRgIeRNE());
			jason += Format.jsonString("email", tPedido.getDadosDoCliente().getEmail());
			jason += ("\"sexo\":" + tPedido.getDadosDoCliente().isSexo()+ ",\n");
			jason += ("\"emailNaoInformado\":" + tPedido.getDadosDoCliente().isEmailNaoInformado());
		jason += "\n},";
		
		/* Objeto endereço de cobrança */
		jason += "\"enderecoDeCobranca\":{\n";
			jason += Format.jsonString("endereco", tPedido.getEnderecoDeCobranca().getEndereco());
			jason += Format.jsonString("numero", tPedido.getEnderecoDeCobranca().getNumero());
			jason += Format.jsonString("aptoCasa", tPedido.getEnderecoDeCobranca().getAptoCasa());
			jason += Format.jsonString("complemento", tPedido.getEnderecoDeCobranca().getComplemento());
			jason += Format.jsonString("bairro", tPedido.getEnderecoDeCobranca().getBairro());
			jason += Format.jsonString("cidade", tPedido.getEnderecoDeCobranca().getCidade());
			jason += Format.jsonString("uF", tPedido.getEnderecoDeCobranca().getuF());
			jason += ("\"cEP\":\"" + tPedido.getEnderecoDeCobranca().getcEP() + "\"\n");
		jason += "\n}, ";

		/* Objeto instalação dos receptores */
		jason += "\"instalacaoDosReceptores\":{\n";
			//Endereco de instalacao
			jason += "\"endereco\":{\n";
				jason += Format.jsonString("endereco", tPedido.getInstalacaoDosReceptores().getEndereco().getEndereco());
				jason += Format.jsonString("numero", tPedido.getInstalacaoDosReceptores().getEndereco().getNumero());
				jason += Format.jsonString("aptoCasa", tPedido.getInstalacaoDosReceptores().getEndereco().getAptoCasa());
				jason += Format.jsonString("complemento", tPedido.getInstalacaoDosReceptores().getEndereco().getComplemento());
				jason += Format.jsonString("bairro", tPedido.getInstalacaoDosReceptores().getEndereco().getBairro());
				jason += Format.jsonString("cidade", tPedido.getInstalacaoDosReceptores().getEndereco().getCidade());
				jason += Format.jsonString("uF", tPedido.getInstalacaoDosReceptores().getEndereco().getuF());
				jason += ("\"cEP\":\"" + tPedido.getInstalacaoDosReceptores().getEndereco().getcEP() + "\"\n");
			jason += "\n}, ";

			jason += ("\"casa\":" + tPedido.getInstalacaoDosReceptores().isCasa()+ ",\n");
			jason += Format.jsonString("nomeCondominio", tPedido.getInstalacaoDosReceptores().getNomeCondominio());		
			jason += Format.jsonString("nomeEdificio", tPedido.getInstalacaoDosReceptores().getNomeEdificio());
			jason += Format.jsonString("pontoReferencia", tPedido.getInstalacaoDosReceptores().getPontoReferencia());			
			
			//Receptor principal
			jason += "\"principal\":{\n";
				jason += Format.jsonBoolean("sKY", tPedido.getInstalacaoDosReceptores().getPrincipal().issKY());
				jason += Format.jsonBoolean("hD", tPedido.getInstalacaoDosReceptores().getPrincipal().ishD());
				jason += Format.jsonBoolean("fullHD", tPedido.getInstalacaoDosReceptores().getPrincipal().isFullHD());
				jason += ("\"hdAdicionais\": " + tPedido.getInstalacaoDosReceptores().getPrincipal().isHdAdicionais() + "\n");
			jason += "\n}, ";
			
			//Receptor opcional
			jason += "\"opcional\":{\n";
				jason += Format.jsonBoolean("sKY", tPedido.getInstalacaoDosReceptores().getOpcional().issKY());
				jason += Format.jsonBoolean("hD", tPedido.getInstalacaoDosReceptores().getOpcional().ishD());
				jason += Format.jsonBoolean("fullHD", tPedido.getInstalacaoDosReceptores().getOpcional().isFullHD());
				jason += ("\"hdAdicionais\": " + tPedido.getInstalacaoDosReceptores().getOpcional().isHdAdicionais() + "\n");
			jason += "\n}, ";
			
			//Receptor banda larga
			jason += "\"bandaLarga\":{\n";
				jason += Format.jsonBoolean("sKY", tPedido.getInstalacaoDosReceptores().getBandaLarga().issKY());
				jason += Format.jsonBoolean("hD", tPedido.getInstalacaoDosReceptores().getBandaLarga().ishD());
				jason += Format.jsonBoolean("fullHD", tPedido.getInstalacaoDosReceptores().getBandaLarga().isFullHD());
				jason += ("\"hdAdicionais\": " + tPedido.getInstalacaoDosReceptores().getBandaLarga().isHdAdicionais() + "\n");
			jason += "\n}, ";
			jason += ("\"nomeResponsavelAntendimentoAoInstalador\":\"" + tPedido.getInstalacaoDosReceptores().getNomeResponsavelAntendimentoAoInstalador() + "\"\n");
			jason += "\n}, ";
			
			/* Objeto Programacao e promocoes */
			jason += "\"programacaoEPromocoes\":{\n";
				jason += Format.jsonString("informacoesAdicionais", tPedido.getProgramacaoEPromocoes().getInformacoesAdicionais());
				jason += Format.jsonDouble("total", tPedido.getProgramacaoEPromocoes().getTotal());
				jason += Format.jsonDouble("payTV", tPedido.getProgramacaoEPromocoes().getPayTV());
				jason += Format.jsonDouble("opcionaisPayTV", tPedido.getProgramacaoEPromocoes().getOpcionaisPayTV());
				jason += Format.jsonDouble("opcionalBandaLarga", tPedido.getProgramacaoEPromocoes().getOpcionalBandaLarga());
				jason += Format.jsonBoolean("sKYFit", tPedido.getProgramacaoEPromocoes().issKYFit());
				jason += Format.jsonBoolean("sKYFit2", tPedido.getProgramacaoEPromocoes().issKYFit2());
				jason += Format.jsonBoolean("sKYPrePagoLivre12Meses", tPedido.getProgramacaoEPromocoes().issKYPrePagoLivre12Meses());
				jason += Format.jsonBoolean("sKYMixHd", tPedido.getProgramacaoEPromocoes().issKYMixHd());
				jason += Format.jsonBoolean("sKYLigth2", tPedido.getProgramacaoEPromocoes().issKYLigth2());
				jason += Format.jsonBoolean("hDTVHBOMax", tPedido.getProgramacaoEPromocoes().ishDTVHBOMax());
				jason += Format.jsonBoolean("hDTVTelecine", tPedido.getProgramacaoEPromocoes().ishDTVTelecine());
				jason += Format.jsonBoolean("hDTVCinema", tPedido.getProgramacaoEPromocoes().ishDTVCinema());
				jason += Format.jsonBoolean("hDTVFullHBOMax", tPedido.getProgramacaoEPromocoes().ishDTVFullHBOMax());
				jason += Format.jsonBoolean("hDTVFullTelecine", tPedido.getProgramacaoEPromocoes().ishDTVFullTelecine());
				jason += Format.jsonBoolean("hDTVFullCinema", tPedido.getProgramacaoEPromocoes().ishDTVFullCinema());
				jason += Format.jsonBoolean("opcionalHD", tPedido.getProgramacaoEPromocoes().isOpcionalHD());
				jason += Format.jsonBoolean("opcionalFullHDTV", tPedido.getProgramacaoEPromocoes().isOpcionalFullHDTV());
				jason += Format.jsonBoolean("hBO", tPedido.getProgramacaoEPromocoes().ishBO());
				jason += Format.jsonBoolean("telecineHD", tPedido.getProgramacaoEPromocoes().isTelecineHD());
				jason += Format.jsonBoolean("hBOHD", tPedido.getProgramacaoEPromocoes().ishBOHD());
				jason += Format.jsonBoolean("maxHD", tPedido.getProgramacaoEPromocoes().isMaxHD());
				jason += Format.jsonBoolean("hBODigital4", tPedido.getProgramacaoEPromocoes().ishBODigital4());
				jason += Format.jsonBoolean("hBOMax", tPedido.getProgramacaoEPromocoes().ishBOMax());
				jason += Format.jsonBoolean("hBOBrasil", tPedido.getProgramacaoEPromocoes().ishBOBrasil());
				jason += Format.jsonBoolean("telecine", tPedido.getProgramacaoEPromocoes().isTelecine());
				jason += Format.jsonBoolean("telecine3", tPedido.getProgramacaoEPromocoes().isTelecine3());
				jason += Format.jsonBoolean("premierFC", tPedido.getProgramacaoEPromocoes().isPremierFC());
				jason += Format.jsonBoolean("combate", tPedido.getProgramacaoEPromocoes().isCombate());
				jason += Format.jsonBoolean("bandsports", tPedido.getProgramacaoEPromocoes().isBandsports());
				jason += Format.jsonBoolean("sexZone", tPedido.getProgramacaoEPromocoes().isSexZone());
				jason += Format.jsonBoolean("plyaboyTV", tPedido.getProgramacaoEPromocoes().isPlyaboyTV());
				jason += Format.jsonBoolean("sexyHot", tPedido.getProgramacaoEPromocoes().isSexyHot());
				jason += Format.jsonBoolean("hustlerTV", tPedido.getProgramacaoEPromocoes().isHustlerTV());
				jason += Format.jsonBoolean("nHK", tPedido.getProgramacaoEPromocoes().isnHK());
				jason += Format.jsonBoolean("europa", tPedido.getProgramacaoEPromocoes().isEuropa());
				jason += Format.jsonBoolean("deutscheWelle", tPedido.getProgramacaoEPromocoes().isDeutscheWelle());
				jason += Format.jsonBoolean("rAIInternational", tPedido.getProgramacaoEPromocoes().isrAIInternational());
				jason += Format.jsonBoolean("sICInternational", tPedido.getProgramacaoEPromocoes().issICInternational());
				jason += Format.jsonBoolean("tV5Monde", tPedido.getProgramacaoEPromocoes().istV5Monde());
				jason += Format.jsonBoolean("tVZ", tPedido.getProgramacaoEPromocoes().istVZ());
				jason += Format.jsonBoolean("bandnews", tPedido.getProgramacaoEPromocoes().isBandnews());
				jason += Format.jsonBoolean("bandaLarga2Mb", tPedido.getProgramacaoEPromocoes().isBandaLarga2Mb());
				jason += Format.jsonBoolean("bandaLarga4Mb", tPedido.getProgramacaoEPromocoes().isBandaLarga4Mb());
				jason += Format.jsonBoolean("sKYPrime24H", tPedido.getProgramacaoEPromocoes().issKYPrime24H());
				jason += ("\"sKYAssistPremuim\":\"" + tPedido.getProgramacaoEPromocoes().issKYAssistPremuim() + "\"\n");
			jason += "\n}, ";
			
			/* Objeto Comodato vendas */
			jason += "\"comodatoVendas\":{\n";
				jason += Format.jsonBoolean("atoTaxaDeAdesaoComodato", tPedido.getComodatoVendas().isAtoTaxaDeAdesaoComodato());
				jason += Format.jsonBoolean("atoVenda", tPedido.getComodatoVendas().isAtoVenda());
				jason += Format.jsonDouble("atoValor", tPedido.getComodatoVendas().getAtoValor());
				jason += Format.jsonBoolean("atoCartaoCreditoDebito", tPedido.getComodatoVendas().isAtoCartaoCreditoDebito());
				jason += Format.jsonBoolean("atoDebitoAutomaticoContaCorrente", tPedido.getComodatoVendas().isAtoDebitoAutomaticoContaCorrente());
				jason += Format.jsonBoolean("atoFichaCompensacao", tPedido.getComodatoVendas().isAtoFichaCompensacao());
				jason += Format.jsonBoolean("atoPECPPB", tPedido.getComodatoVendas().isAtoPECPPB());
				jason += Format.jsonBoolean("atoCEFFinanciamento", tPedido.getComodatoVendas().isAtoCEFFinanciamento());
				jason += Format.jsonBoolean("mensalidadeCartaoCreditoDebito", tPedido.getComodatoVendas().isMensalidadeCartaoCreditoDebito());
				jason += Format.jsonBoolean("mensalidadeDebitoAutomaticoContaCorrente", tPedido.getComodatoVendas().isMensalidadeDebitoAutomaticoContaCorrente());
				jason += Format.jsonBoolean("mensalidadeBoletoBancario", tPedido.getComodatoVendas().isMensalidadeBoletoBancario());
				jason += Format.jsonBoolean("prePagoAVista", tPedido.getComodatoVendas().isPrePagoAVista());
				jason += Format.jsonBoolean("prePagoparcelado12meses", tPedido.getComodatoVendas().isPrePagoparcelado12meses());
				jason += Format.jsonDouble("prePagoValor", tPedido.getComodatoVendas().getPrePagoValor());
				jason += Format.jsonInt("prePagoQtdParcelas", tPedido.getComodatoVendas().getPrePagoQtdParcelas());
				jason += ("\"prePagoValorParcela\":" + Format.getString(tPedido.getComodatoVendas().getPrePagoValorParcela()) + "\n");
			jason += "\n}, ";
			
			/* Objeto Dados para débito */
			jason += "\"dadosParaDebito\":{\n";
				jason += Format.jsonBoolean("visa", tPedido.getDadosParaDebito().isVisa());
				jason += Format.jsonBoolean("hipercard",tPedido.getDadosParaDebito().isHipercard()); 
				jason += Format.jsonBoolean("dinners", tPedido.getDadosParaDebito().isDinners());
				jason += Format.jsonBoolean("masterCard", tPedido.getDadosParaDebito().isMasterCard());
				jason += Format.jsonBoolean("amex", tPedido.getDadosParaDebito().isAmex());
				jason += Format.jsonBoolean("elo", tPedido.getDadosParaDebito().isElo());
				jason += Format.jsonString("numeroCartao", tPedido.getDadosParaDebito().getNumeroCartao());
				jason += Format.jsonString("dataValidade", tPedido.getDadosParaDebito().getDataValidade());
				jason += Format.jsonString("agencia", tPedido.getDadosParaDebito().getAgencia());
				jason += Format.jsonString("contaCorrente", tPedido.getDadosParaDebito().getContaCorrente());
				jason += Format.jsonBoolean("banrisul", tPedido.getDadosParaDebito().isBanrisul());
				jason += Format.jsonBoolean("bradesco", tPedido.getDadosParaDebito().isBradesco());
				jason += Format.jsonBoolean("bancoBrasil", tPedido.getDadosParaDebito().isBancoBrasil());
				jason += Format.jsonBoolean("cityBank", tPedido.getDadosParaDebito().isCityBank());
				jason += Format.jsonBoolean("cEF", tPedido.getDadosParaDebito().iscEF());
				jason += Format.jsonBoolean("hSBC", tPedido.getDadosParaDebito().ishSBC());
				jason += Format.jsonBoolean("itau", tPedido.getDadosParaDebito().isItau());
				jason += Format.jsonBoolean("santander", tPedido.getDadosParaDebito().isSantander());
				jason += Format.jsonBoolean("sicredi", tPedido.getDadosParaDebito().isSicredi());
				jason += ("\"sicredi\": " + tPedido.getDadosParaDebito().isSicredi() + "\n");
			jason += "\n} ";
		jason += "\n}\n}";	
		return jason;
	}
	
	private void enviaPedido(){
		PedidoVenda pPedido = criaPedido();

		String resourceURL = SingletonUtilitario.getResourceURL() + "/pedido";
		AsyncHttpClient httpClient = new AsyncHttpClient();

		JSONObject params = new JSONObject();
		try {
			params = new JSONObject(criaJSON(pPedido));
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

		Toast.makeText(CONTEXTO, R.string.lblPedidoCadastradoComSucesso, Toast.LENGTH_SHORT).show();
		startActivity(new Intent(CONTEXTO, MainActivity.class));
		
		/*httpClient.post(CONTEXTO, resourceURL, entity, "application/json", new JsonHttpResponseHandler() {
			public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
				Toast.makeText(CONTEXTO, R.string.lblPedidoCadastradoComSucesso, Toast.LENGTH_SHORT).show();
				startActivity(new Intent(CONTEXTO, MainActivity.class));
			};
		});*/
	}
}
