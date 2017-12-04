package com.example.angul.futa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main6Activity extends AppCompatActivity {
    TextView nombre, pos, puntos,jugados, victorias, empates, derrotas, goles, golesfav, golescon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        nombre = (TextView)findViewById(R.id.tNombreEq);
        pos = (TextView)findViewById(R.id.tposicion);
        puntos  = (TextView)findViewById(R.id.tpuntos);
        jugados= (TextView)findViewById(R.id.tplayedGames);
        victorias= (TextView)findViewById(R.id.tpartiganados);
        empates = (TextView)findViewById(R.id.tpartempatados);
        derrotas = (TextView)findViewById(R.id.tpartidosperdidos);
        goles=  (TextView)findViewById(R.id.tgoals);
        golesfav=(TextView)findViewById(R.id.tgoalsfavor);
        golescon= (TextView)findViewById(R.id.tgoalscontra);

        Intent i = this.getIntent();
        EqClasificacion eqClasificacion = i.getParcelableExtra("Datos equipo: ");

        nombre.setText(eqClasificacion.getTeamName());
        pos.setText("Posicion: " + eqClasificacion.getPosition());

        puntos.setText("Puntos: " + eqClasificacion.getPoints());
        jugados.setText("Partidos jugados: " + eqClasificacion.getPlayedGames());
        victorias.setText("Partidos ganados: " +eqClasificacion.getWins());
        empates .setText("Partidos empates: " +eqClasificacion.getDraws());
        derrotas .setText("Partidos derrotas: " +eqClasificacion.getLosses());
        goles.setText("Diferencia Goles total: " +eqClasificacion.getGoalsAgainst());
        golesfav.setText("Goles favor: " +eqClasificacion.getGoals());
        golescon.setText("Goles en contra: " +eqClasificacion.getGoalsAgainst());

    }
}
