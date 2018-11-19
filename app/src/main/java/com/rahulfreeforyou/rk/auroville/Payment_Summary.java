package com.rahulfreeforyou.rk.auroville;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Payment_Summary extends AppCompatActivity {

    TextView tvname,tvprice,tvdescr,tv_count;
    Button book_cycle;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_summary);

        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.back_button);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pay = new Intent(Payment_Summary.this,SecondActivity.class);
                startActivity(pay);
                finish();
            }
        });


        tvname = findViewById(R.id.tvname);
        tvprice = findViewById(R.id.tvprice);
        tvdescr = findViewById(R.id.tvdes);
        tv_count = findViewById(R.id.count_tv);
        book_cycle = findViewById(R.id.book_cycle);

        String value = getIntent().getStringExtra("data1");
        String value2 = getIntent().getStringExtra("data2");
        String value3 = getIntent().getStringExtra("data3");
        String count = getIntent().getStringExtra("ele_count");


        tvname.setText("Select cycle: "+value);
        tvprice.setText("Price: "+value2);
        tvdescr.setText("About: "+value3);
        tv_count.setText(count);

        book_cycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent share_detail = new Intent(Payment_Summary.this,Share_Detail.class);
                startActivity(share_detail);
                finish();
            }
        });


    }
}
