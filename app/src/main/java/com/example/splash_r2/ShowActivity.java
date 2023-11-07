package com.example.splash_r2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    TextView tvUsername;
    ImageView ivCall, ivAddress, ivUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        init();

        Bundle data = getIntent().getExtras();
        String name = data.getString("name", "");
        String address = data.getString("address", "");
        String url = data.getString("url", "");
        String phone = data.getString("phone", "");

        if(!name.isEmpty())
        {
            tvUsername.setVisibility(View.VISIBLE);
            tvUsername.setText("Welcome "+name);
        }

        if(!address.isEmpty())
        {
            ivAddress.setVisibility(View.VISIBLE);
        }

        if (!url.isEmpty())
        {
            ivUrl.setVisibility(View.VISIBLE);
        }

        if(!phone.isEmpty())
        {
            ivCall.setVisibility(View.VISIBLE);
        }


        ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phone, null, "Hello "+name+",\nI have a good news for you. Call me back.", null, null);

                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+phone));
                startActivity(i);
            }
        });

        ivAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("geo:(0,0)?q="+Uri.encode(address)));
                startActivity(i);
            }
        });

        ivUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }

    public void init()
    {
        tvUsername = findViewById(R.id.tvUsername);
        ivAddress = findViewById(R.id.ivAddress);
        ivCall = findViewById(R.id.ivCall);
        ivUrl = findViewById(R.id.ivUrl);

        tvUsername.setVisibility(View.GONE);
        ivAddress.setVisibility(View.GONE);
        ivUrl.setVisibility(View.GONE);
        ivCall.setVisibility(View.GONE);

    }
}