package com.example.splash_r2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    final int DELAY = 5000;
    ImageView ivSplashLogo;
    TextView tvHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ivSplashLogo = findViewById(R.id.splashLogo);
        tvHeader = findViewById(R.id.tvHeader);

        Animation my_animation = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.my_animation);
        Animation my_text_animation = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.text_animation_left_to_right);
        ivSplashLogo.setAnimation(my_animation);
        tvHeader.setAnimation(my_text_animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,
                        MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, DELAY);

    }
}