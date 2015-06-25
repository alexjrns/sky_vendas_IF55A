package com.github.sky_vendas;

import java.util.ArrayList;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.sky_vendas.R;
import com.example.sky_vendas.R.layout;
import com.github.sky_vendas.model.PedidoVenda;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class VisualizarPedidosActivity extends Activity {
	private Context CONTEXTO = this;
	private ListView pedListView;
	private ArrayList<PedidoVenda> pedidos = new ArrayList<PedidoVenda>();
	private ArrayAdapter<PedidoVenda> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_visualizar_pedidos);
		
		pedListView = (ListView) findViewById(R.id.lvPedidos);
		pedListView.setOnItemClickListener(lstClick);
		adapter = new ArrayAdapter<PedidoVenda>(CONTEXTO, android.R.layout.simple_list_item_1, pedidos);
		pedListView.setAdapter(adapter);
		atualizaListView();
	};
	
	private OnItemClickListener lstClick = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			PedidoVenda pedido = pedidos.get(position);
			//Toast.makeText(ShowAllAccountsActivity.this, "Its balance is " + pedido.getBalance(), Toast.LENGTH_SHORT).show();
		}
	};
	
	private void atualizaListView(){
		String resourceURL = SingletonUtilitario.getResourceURL() + "/pedido";
		AsyncHttpClient httpClient = new AsyncHttpClient();
		
		httpClient.get(resourceURL, new JsonHttpResponseHandler() {
			public void onSuccess(int statusCode, Header[] headers, JSONArray jsonArray) {
				pedidos.clear();
				for (int i = 0; i < jsonArray.length(); i++) {
					try {
						JSONObject obj = jsonArray.getJSONObject(i);
						PedidoVenda p = new PedidoVenda(obj.getString("nomeRazao"));
						pedidos.add(p);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				adapter.notifyDataSetChanged();
			}
		});
	}
}
