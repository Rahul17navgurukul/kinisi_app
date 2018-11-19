package com.rahulfreeforyou.rk.auroville;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Booking_Confirmed extends AppCompatActivity {

    Toolbar toolbar;
    Button my_booking , more_cycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking__confirmed);

        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.back_button);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pay = new Intent(Booking_Confirmed.this,Share_Detail.class);
                startActivity(pay);
                finish();
            }
        });

        my_booking = findViewById(R.id.my_booking);
        more_cycle = findViewById(R.id.more);



        more_cycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sec = new Intent(Booking_Confirmed.this,SecondActivity.class);
                startActivity(sec);
            }
        });
    }
}
