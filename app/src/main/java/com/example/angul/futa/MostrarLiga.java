package com.example.angul.futa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MostrarLiga extends AppCompatActivity {

    ListView listview2;
    ArrayList<Liga> ligas=new ArrayList<>();
    ArrayList<String> nomLigas=new ArrayList<>();
    LigasDataSource ligasDataSource=new LigasDataSource(this);
    ArrayAdapter<String> adaptador;
    public static String CODIGO_LIGA="codigo_liga";
    public static String NOMBRE_LIGA="nombre_liga";
    public static String NUMERO_EQUIPOS="numero_equipos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_liga);
        listview2 = (ListView) findViewById(R.id.listview);
        listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long lon) {
                final int posicion=i;
                Intent intent=new Intent(MostrarLiga.this,LigaCompleta.class);
                Liga l =ligas.get(posicion);
                intent.putExtra(CODIGO_LIGA, ""+l.getCodLiga());
                intent.putExtra(NOMBRE_LIGA, l.getNombreLiga());
                intent.putExtra(NUMERO_EQUIPOS, ""+l.getNumeroParticipantes());
                startActivity(intent);
            }
        });
        ligas=ligasDataSource.readLigas();
        String lig;
        for(Liga l:ligas) {
            lig="Código de la liga: " +l.getCodLiga()+ " Nombre de la liga: " +l.getNombreLiga()+
                    " Número de equipos de la liga: " +l.getNumeroParticipantes();
            nomLigas.add(lig);
        }
        adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nomLigas);
        listview2.setAdapter(adaptador);
    }

    }

