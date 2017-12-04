package com.example.angul.futa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LigaCompleta extends AppCompatActivity {
    TextView codigoLiga,nombreLiga,numeroEquipos;
    String codigo,nombre,equipos;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liga_completa);



    }
}
