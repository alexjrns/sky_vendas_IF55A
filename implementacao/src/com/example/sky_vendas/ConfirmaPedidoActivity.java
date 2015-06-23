package com.example.sky_vendas;

import java.util.Calendar;

import com.github.sky_vendas.model.ComodatoVendas;
import com.github.sky_vendas.model.DadosCliente;
import com.github.sky_vendas.model.DadosParaDebito;
import com.github.sky_vendas.model.Endereco;
import com.github.sky_vendas.model.InstalacaoDosReceptores;
import com.github.sky_vendas.model.PedidoVenda;
import com.github.sky_vendas.model.ProgramacaoPromocoes;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConfirmaPedidoActivity extends Activity {

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
		
		txtNomeCliente.setText(objDadosCliente.getNomeRazao());
	}

	public PedidoVenda criaPedido(){
		return new PedidoVenda(0, Calendar.getInstance(), 15, null, objDadosCliente, objInstalacaoReceptores,
				objEnderecoCobranca, objProgramacaoPromocoes, objComodatoVendas, objDadosParaDebito);
	}
}
