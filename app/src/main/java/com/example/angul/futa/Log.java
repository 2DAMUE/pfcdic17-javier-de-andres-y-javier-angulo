package com.example.angul.futa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Log extends AppCompatActivity {
Button btLog;
    EditText edLogin;
    TextView txtLoging;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        btLog = (Button)findViewById(R.id.buttonLog);
        txtLoging = (TextView) findViewById(R.id.txtIng);
        edLogin = (EditText) findViewById(R.id.edLo);


        btLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regis();
            }
        });
    }


    public void regis(){
        if(edLogin.getText().toString().equals("")){
            Toast.makeText(this, "Necesita poner un nombre", Toast.LENGTH_LONG).show();
        }else{
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }

    }
}
