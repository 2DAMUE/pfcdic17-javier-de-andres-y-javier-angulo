package com.example.angul.futa;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button btnBuscar, btnMislig;
    String URL = "http://api.football-data.org/v1/competitions/";
    public final static String TAG = MainActivity.class.getSimpleName();
    Ligas[] ligas;
    EditText ednum;
    public static final String NUM = "numero";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listview);
        btnBuscar = (Button)findViewById(R.id.button);
        btnMislig = (Button) findViewById(R.id.button2);
        ednum = (EditText) findViewById(R.id.editText);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leernum();
            }
        });
        btnMislig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Misligas();
            }
        });

        obtenerdatos();



}


    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }
        return isAvailable;

    }

    public void obtenerdatos() {
        if (isNetworkAvailable()) {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder().url(URL).build();
            Call call = okHttpClient.newCall(request);

            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        String result = response.body().string();
                        Log.i(TAG, "datosqrecibimos: " + result);
                        if(response.isSuccessful()){
                            ligas = getLigas(result);
                            mostrardatos();

                        }

                    }catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private Ligas[]getLigas(String Json) throws  JSONException{


        //llamar primera rama
        JSONArray jsonArray = new JSONArray(Json);
        Ligas[]ligas = new Ligas[jsonArray.length()];
        Ligas ligs;
        //for para recorrer primera rama
        for (int i = 0; i < jsonArray.length(); i++) {
            ligs = new Ligas();
            //en cada vuelta cogemos el objeto q tenemos en cada posicion
            JSONObject posinfo = jsonArray.getJSONObject(i);
            //coger cada

            ligs.setId(posinfo.getString("id"));
            ligs.setnLiga(posinfo.getString("caption"));
            ligas[i] = ligs;


            Log.d(TAG, "id: " + posinfo.getString("id"));
        }

        return ligas;
    }
    public void mostrardatos() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG,"vamos pa ya");
                Adaptador adaptador = new Adaptador(MainActivity.this, ligas);

                listView.setAdapter(adaptador);
            }
        });
    }



    public void leernum() {
        if (ednum.getText().toString().equals("")) {
            Toast.makeText(this, "INTRODUCE UN codigo de los de la lista", Toast.LENGTH_LONG).show();
        } else {
            int num = Integer.parseInt(ednum.getText().toString());
            if (num > 0) {
                Intent i = new Intent(this, Main3Activity.class);
                i.putExtra(NUM, num);
                startActivity(i);
            }
        }

    }

    public void Misligas(){
        Intent i = new Intent(this, MostarBotones.class);
        startActivity(i);
    }
    }
