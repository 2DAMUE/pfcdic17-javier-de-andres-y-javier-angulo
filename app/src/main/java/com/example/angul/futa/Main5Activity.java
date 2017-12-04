package com.example.angul.futa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Main5Activity extends AppCompatActivity {
    Button btnLog;
    TextView txtLog;
    EditText edLog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        txtLog = (TextView)findViewById(R.id.textView5);
        edLog = (EditText) findViewById(R.id.editText2);
        btnLog = (Button)findViewById(R.id.button3);

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarse();
            }
        });
    }

    public void registrarse(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
