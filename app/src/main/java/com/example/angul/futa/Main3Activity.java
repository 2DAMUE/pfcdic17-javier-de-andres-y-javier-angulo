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
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.angul.futa.MainActivity.NUM;

public class Main3Activity extends AppCompatActivity {
    ListView listViewEq;
    TextView txtNoL;
    //public static final String URL = "http://api.football-data.org/v1/competitions/";
    public final static String TAG = MainActivity.class.getSimpleName();
    String URL = "http://api.football-data.org/v1/competitions/";
    String url;
    Equipos[] equiposes;
    int codigo;

    public static final String NUME = "numero";
    Button btnCla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        listViewEq = (ListView) findViewById(R.id.listequi);
        txtNoL = (TextView) findViewById(R.id.txtnl);

        btnCla = (Button) findViewById(R.id.btnclasificacion);

        Intent i = getIntent();
        codigo = i.getIntExtra(NUM, 0);
        String cod = codigo + "/teams";

        url = URL + cod;
        Log.d(TAG, "url: " + url);

        obtenerdatos();
        if (codigo == 426) {
            txtNoL.setText("Premier League 2016/17");
        } else if (codigo == 424) {
            txtNoL.setText("European Championships France 2016");
        } else if (codigo == 427) {
            txtNoL.setText("Championship 2016/17");
        } else if (codigo == 428) {
            txtNoL.setText("League One 2016/17");
        } else if (codigo == 429) {
            txtNoL.setText("FA-Cup 2016/17");
        } else if (codigo == 430) {
            txtNoL.setText("Bundesliga 2016/17");
        } else if (codigo == 431) {
            txtNoL.setText("2. Bundesliga 2016/17");
        } else if (codigo == 432) {
            txtNoL.setText("DFB-Pokal 2016/17");
        } else if (codigo == 433) {
            txtNoL.setText("Eredivisie 2016/17");
        } else if (codigo == 434) {
            txtNoL.setText("Ligue 1 2016/17");
        } else if (codigo == 435) {
            txtNoL.setText("Ligue 2 2016/17");
        } else if (codigo == 436) {
            txtNoL.setText("Primera Division 2016/17");
        } else if (codigo == 437) {
            txtNoL.setText("Liga Adelante 2016/17");
        } else if (codigo == 438) {
            txtNoL.setText("Serie A 2016/17");
        } else if (codigo == 439) {
            txtNoL.setText("Primeira Liga 2016/17");
        } else if (codigo == 440) {
            txtNoL.setText("Champions League 2016/17");
        } else if (codigo == 441) {
            txtNoL.setText("Serie B");
        } else if (codigo == 442) {
            txtNoL.setText("English National League");
        } else if (codigo == 443) {
            txtNoL.setText("League Two");
        } else {
            txtNoL.setText("NO EXISTE");

        }

        btnCla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clasificacion();
            }
        });

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

    private void obtenerdatos() {
        if (isNetworkAvailable()) {
            OkHttpClient client = new OkHttpClient();
            Log.i(TAG, "Entro en obtener datos: ");
            final Request request = new Request.Builder().url(url).build();
            Log.i(TAG, "URL: "+url);
            Call call = client.newCall(request);

            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                    try {
                        String result = response.body().string();
                        Log.i(TAG, "datosqrecibimos: " + result);
                        if (response.isSuccessful()) {
                            equiposes = getequips(result);
                            mostrardatos();

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }




    private Equipos[] getequips(String Json) throws JSONException {
//objeto principal
        JSONObject result = new JSONObject(Json);

        //llamar primera rama
        JSONArray jsonArray = result.getJSONArray("teams");
        equiposes = new Equipos[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {
            //en cada vuelta cogemos el objeto q tenemos en cada posicion
            JSONObject posinfo = jsonArray.getJSONObject(i);
            //crear nuevo blog blogs[i] = new Blog();
            equiposes[i] = new Equipos();
            //coger cada
            equiposes[i].setNameEquipo(posinfo.getString("name"));
            equiposes[i].setCode(posinfo.getString("code"));

            Log.d(TAG, "equipo: " + posinfo.getString("name"));
        }
        return equiposes;
    }

    private void mostrardatos() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG,"vamos pa ya mostrados");
                AdaptadorEquipos adaptadorEquipos = new AdaptadorEquipos(Main3Activity.this, equiposes);

                listViewEq.setAdapter(adaptadorEquipos);
            }
        });
    }

    private void clasificacion() {
        Intent i  = new Intent(this, Main4Activity.class);
        i.putExtra(NUM, codigo);
        startActivity(i);
    }


}
