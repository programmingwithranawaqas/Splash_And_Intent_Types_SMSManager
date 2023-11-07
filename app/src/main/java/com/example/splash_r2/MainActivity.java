package com.example.splash_r2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText etName, etAddress,etUrl, etPhone;
    Button btnCancel, btnSubmit;
    LinearLayout llGetInformation;
    TextView tvGetInformation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        Animation animation = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.my_animation);
        llGetInformation.setAnimation(animation);

        Animation tAnim = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.header_animation);

            tvGetInformation.setAnimation(tAnim);



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString().trim();
                String address =etAddress.getText().toString().trim();
                String phone =etPhone.getText().toString().trim();
                String url =etUrl.getText().toString().trim();

                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("address", address);
                intent.putExtra("phone", phone);
                intent.putExtra("url", url);

                startActivity(intent);


            }
        });

    }
    public void init()
    {
        etName = findViewById(R.id.etUsername);
        etAddress = findViewById(R.id.etAddress);
        etUrl = findViewById(R.id.etUrl);
        etPhone = findViewById(R.id.etPhone);
        btnCancel = findViewById(R.id.btnCancel);
        btnSubmit = findViewById(R.id.btnSubmit);
        llGetInformation = findViewById(R.id.llGetInformation);
        tvGetInformation = findViewById(R.id.tvGetInformation);
    }
}