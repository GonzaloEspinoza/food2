package com.example.gonzaloe.restaurant;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gonzaloe.restaurant.ItemMenu.ItemMenuStructure;
import com.example.gonzaloe.restaurant.ItemMenu.MenuBaseAdapter;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.zip.Inflater;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {


    private ListView LIST;
    private ArrayList<ItemMenuStructure> LISTINFO;
    private Context root;
    private MenuBaseAdapter ADAPTER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        root = this;

        LISTINFO = new ArrayList<ItemMenuStructure>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //loadData();
        loadComponents();

    }


    private void loadData(String keysrt) {

        AsyncHttpClient client = new AsyncHttpClient();

        String url="http://192.168.1.5:4030/api/v1.0/home2/search="+keysrt;


        //Toast.makeText(MainActivity.this, srt, Toast.LENGTH_SHORT).show();

        client.get(url, new JsonHttpResponseHandler(){
        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

               try{

                   JSONArray listaData = response.getJSONArray("info");

                   for (int i = 0;i < listaData.length();i++){
                       JSONObject obj = listaData.getJSONObject(i);

                       String url = (String)obj.getJSONArray("gallery").get(0);
                       String id = obj.getString("_id");
                       String ciudad = obj.getString("city");
                       String estado =obj.getString("estado");
                       String cuartos = obj.getString("cuartos");
                       String baños = obj.getString("baños");
                       String superfiie = obj.getString("superficie");
                       String antiguedad = obj.getString("antiguedad");
                       String calle = obj.getString("street");
                       String descripcion = obj.getString("descripcion");
                       String precio = obj.getString("price");
                       String latitud = obj.getString("lat");
                       String longitud = obj.getString("lon");
                       String vecindario = obj.getString("neighborhood");

                       //String contcto = obj.getString("contact");

                       Toast.makeText(MainActivity.this, vecindario, Toast.LENGTH_SHORT).show();


                       ItemMenuStructure item = new ItemMenuStructure(url,ciudad,estado,precio);

                       LISTINFO.add(item);
                   }
                   ADAPTER = new MenuBaseAdapter(root,LISTINFO);
                   LIST.setAdapter(ADAPTER);

               } catch (JSONException e) {
                   e.printStackTrace();
               }
        }

        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

        }

        });

    }


    private void loadComponents() {

        LIST = (ListView)this.findViewById(R.id.foodlist);

        EditText search = (EditText)this.findViewById(R.id.searchfood);

        //evesntos_________
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        String str = charSequence.toString();
                        loadData(str);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
