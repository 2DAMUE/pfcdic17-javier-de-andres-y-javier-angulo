package com.example.angul.futa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main4Activity extends AppCompatActivity {
    ListView listView;
    public final static String TAG = MainActivity.class.getSimpleName();
    String URL = "http://api.football-data.org/v1/competitions/";
    String url;
    EqClasificacion[] eqClasificacions;
    Activity c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        listView = (ListView) findViewById(R.id.listviewcla);


        Intent i = getIntent();
        int codigo = i.getIntExtra(MainActivity.NUM, 0);
        String cod = codigo + "/leagueTable";

        url = URL + cod;
        Log.d(TAG, "url: " + url);

        obtenerdatos();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                EqClasificacion eqClasificacion = new EqClasificacion();
                eqClasificacion=eqClasificacions[i];
                Intent intent = new Intent(view.getContext(), Main6Activity.class);

                intent.putExtra("Datos equipo: ", eqClasificacion);
                startActivity(intent);

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
            Log.i(TAG, "URL: " + url);
            Call call = client.newCall(request);

            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        String result = response.body().string();
                        Log.i(TAG, "datos que recibimos: " + result);
                        if (response.isSuccessful()) {
                            eqClasificacions = getequips(result);
                            mostrardatos();

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


    }

    private EqClasificacion[] getequips(String Json)throws JSONException {

        //objeto principal
        JSONObject result = new JSONObject(Json);

        //llamar primera rama
        JSONArray jsonArray = result.getJSONArray("standing");
        eqClasificacions = new EqClasificacion[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {
            //en cada vuelta cogemos el objeto q tenemos en cada posicion
            JSONObject posinfo = jsonArray.getJSONObject(i);
            //crear nuevo
            eqClasificacions[i] = new EqClasificacion();
            eqClasificacions[i].setPosition(posinfo.getString("position"));
            eqClasificacions[i].setTeamName(posinfo.getString("teamName"));
            eqClasificacions[i].setPlayedGames(posinfo.getString("playedGames"));
            eqClasificacions[i].setPoints(posinfo.getString("points"));
            eqClasificacions[i].setGoals(posinfo.getString("goals"));
            eqClasificacions[i].setGoalsAgainst(posinfo.getString("goalsAgainst"));
            eqClasificacions[i].setGoalDifference(posinfo.getString("goalDifference"));
            eqClasificacions[i].setWins(posinfo.getString("wins"));
            eqClasificacions[i].setDraws(posinfo.getString("draws"));
            eqClasificacions[i].setLosses(posinfo.getString("losses"));

            Log.d(TAG, "equipo: " + posinfo.getString("teamName"));

        }
        return eqClasificacions;
    }


    private void mostrardatos() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG,"vamos pa ya4");
                AdaptadorClasificacion adaptadorClasificacion = new AdaptadorClasificacion(Main4Activity.this, eqClasificacions);

                listView.setAdapter(adaptadorClasificacion);
            }
        });

    }

}
