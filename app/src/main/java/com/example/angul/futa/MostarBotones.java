package com.example.angul.futa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MostarBotones extends AppCompatActivity {

    Button bt11, bt22, bt33;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostar_botones);


        bt11 = (Button)findViewById(R.id.button5);
        bt22 = (Button)findViewById(R.id.button6);
        bt33 = (Button)findViewById(R.id.button7);

        bt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actividadInsertarLiga();
            }
        });

        bt22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actividadMostrarLiga();
            }
        });

        bt33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actividadModificarLiga();
            }
        });
    }

    public void actividadInsertarLiga (){
        Intent intent=new Intent(this,InsertarLiga.class);
        startActivity(intent);
    }
    public void actividadMostrarLiga() {
        Intent intent=new Intent(this,MostrarLiga.class);
        startActivity(intent);
    }
    public void actividadModificarLiga() {
        Intent intent=new Intent(this,ModificarLiga.class);
        startActivity(intent);
    }

}
