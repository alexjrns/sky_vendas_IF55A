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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;

public class EnderecoCobrancaActivity extends Activity {
	private final Context CONTEXTO = this;

	private EditText edtEndereco;
	private EditText edtNumero;
	private EditText edtAptoCasa;
	private EditText edtComplemento;
	private EditText edtBairro;
	private EditText edtCidade;
	private EditText edtUF;
	private EditText edtCEP;
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
		setContentView(R.layout.activity_endereco_cobranca);
		
		edtEndereco = (EditText) findViewById(R.id.edtEnderecoCobranca);
		edtNumero = (EditText) findViewById(R.id.edtNumeroCobranca);
		edtAptoCasa = (EditText) findViewById(R.id.edtAptoCasaCobranca);
		edtComplemento = (EditText) findViewById(R.id.edtComplementoCobranca);
		edtBairro = (EditText) findViewById(R.id.edtBairroCobranca);
		edtCidade = (EditText) findViewById(R.id.edtCidadeCobranca);
		edtUF = (EditText) findViewById(R.id.edtUFCobranca);
		edtCEP = (EditText) findViewById(R.id.edtCEPCobranca);
		btnVoltar = (ImageButton) findViewById(R.id.btnVoltar4);
		btnVoltar.setOnClickListener(lstVoltar);
		btnAvancar = (ImageButton) findViewById(R.id.btnAvancar4);
		btnAvancar.setOnClickListener(lstAvancar);
		
		objDadosCliente = (DadosCliente) getIntent().getSerializableExtra("objDadosCliente");
		objInstalacaoReceptores = (InstalacaoDosReceptores) getIntent().getSerializableExtra("objInstalacaoReceptores");
		objEnderecoCobranca = (Endereco) getIntent().getSerializableExtra("objEnderecoCobranca");
		objProgramacaoPromocoes = (ProgramacaoPromocoes) getIntent().getSerializableExtra("objProgramacaoPromocoes");
		objComodatoVendas = (ComodatoVendas) getIntent().getSerializableExtra("objComodatoVendas");
		objDadosParaDebito = (DadosParaDebito) getIntent().getSerializableExtra("objDadosParaDebito");
		
		if(objEnderecoCobranca!=null)
			preencheTela();
	}
	
	private OnClickListener lstVoltar = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent i = new Intent(CONTEXTO, InstalacaoReceptoresActivity.class);
			i.putExtra("objDadosCliente", objDadosCliente);
			i.putExtra("objInstalacaoReceptores", objInstalacaoReceptores);
			i.putExtra("objProgramacaoPromocoes", objProgramacaoPromocoes);
			i.putExtra("objComodatoVendas", objComodatoVendas);
			i.putExtra("objDadosParaDebito", objDadosParaDebito);

			i.putExtra("objEnderecoCobranca", criaObjeto());
			startActivity(i);
		}
	};
	private OnClickListener lstAvancar = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent i = new Intent(CONTEXTO, ProgramacaoPromocoesActivity.class);
			i.putExtra("objDadosCliente", objDadosCliente);
			i.putExtra("objInstalacaoReceptores", objInstalacaoReceptores);
			i.putExtra("objProgramacaoPromocoes", objProgramacaoPromocoes);
			i.putExtra("objComodatoVendas", objComodatoVendas);
			i.putExtra("objDadosParaDebito", objDadosParaDebito);

			i.putExtra("objEnderecoCobranca", criaObjeto());
			startActivity(i);
		}
	};
	
	private Endereco criaObjeto(){
		Endereco endereco = new Endereco(0, edtEndereco.getText().toString(), edtNumero.getText().toString(), 
				edtAptoCasa.getText().toString(), edtComplemento.getText().toString(), edtBairro.getText().toString(), 
				edtCidade.getText().toString(), edtUF.getText().toString(), edtCEP.getText().toString());
		objEnderecoCobranca = endereco;
		return endereco;
	}
	
	private void preencheTela(){
		edtEndereco.setText(objEnderecoCobranca.getEndereco());
		edtNumero.setText(objEnderecoCobranca.getNumero());
		edtAptoCasa.setText(objEnderecoCobranca.getAptoCasa());
		edtComplemento.setText(objEnderecoCobranca.getComplemento());
		edtBairro.setText(objEnderecoCobranca.getBairro());
		edtCidade.setText(objEnderecoCobranca.getCidade());
		edtUF.setText(objEnderecoCobranca.getuF());
		edtCEP.setText(objEnderecoCobranca.getcEP());
	}
}
