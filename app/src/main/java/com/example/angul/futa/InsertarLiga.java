package com.example.angul.futa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertarLiga extends AppCompatActivity {

    EditText editarNombreLiga,editarNumeroParticipantes;
    LigasDataSource ligasDataSource=new LigasDataSource(this);
    Liga liga;
    String nombreLiga;
    int numeroParticipantes;
    Button bti1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_liga);

        editarNombreLiga= (EditText) findViewById(R.id.editText3);
        editarNumeroParticipantes= (EditText) findViewById(R.id.editText4);
        bti1 = (Button)findViewById(R.id.button8);

        bti1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertarLiga();
            }
        });
    }

    public void insertarLiga(){
        if(editarNombreLiga.getText().toString().equals("") ||
                editarNumeroParticipantes.getText().toString().equals("")){
            Toast.makeText(this,"Debe rellenar los campos",Toast.LENGTH_SHORT).show();
        }else {
            nombreLiga=editarNombreLiga.getText().toString();
            numeroParticipantes=Integer.parseInt(editarNumeroParticipantes.getText().toString());
            liga=new Liga(-1,nombreLiga,numeroParticipantes);
            ligasDataSource.insertLiga(liga);
            Toast.makeText(this,"Se ha insertado la liga",Toast.LENGTH_SHORT).show();
            editarNombreLiga.setText("");
            editarNumeroParticipantes.setText("");
        }
    }
}
