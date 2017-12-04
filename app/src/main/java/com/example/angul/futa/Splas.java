package com.example.angul.futa;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splas extends AppCompatActivity {
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splas);

        textView = (TextView)findViewById(R.id.textView2);
        imageView = (ImageView) findViewById(R.id.imageView);

        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.up);

        rotate.setRepeatCount(Animation.INFINITE);
        imageView.startAnimation(rotate);
        openApp(true);

    }

    private void openApp(boolean locationPermision) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splas.this, Log.class);
                startActivity(intent);
                finish();
            }
        }, 4000);
    }
}
