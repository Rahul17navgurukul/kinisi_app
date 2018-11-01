package com.rahulfreeforyou.rk.auroville;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView tvname,tvprice,tvdescr,tv_count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        tvname = findViewById(R.id.tvname);
        tvprice = findViewById(R.id.tvprice);
        tvdescr = findViewById(R.id.tvdes);
        tv_count = findViewById(R.id.count_tv);

        String value = getIntent().getStringExtra("data1");
        String value2 = getIntent().getStringExtra("data2");
        String value3 = getIntent().getStringExtra("data3");
        String count = getIntent().getStringExtra("ele_count");


        tvname.setText("Select cycle: "+value);
        tvprice.setText("Price: "+value2);
        tvdescr.setText("About: "+value3);
        tv_count.setText(count);


    }
}
