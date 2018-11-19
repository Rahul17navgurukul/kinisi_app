package com.rahulfreeforyou.rk.auroville;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.reginald.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.List;

public class Share_Detail extends AppCompatActivity {
    Toolbar toolbar;
    Button confirm_booking;
    EditSpinner gov_id;
    EditText indian_number;
    EditText id_number;
    EditText other_phone_no;
    private long itemIdAtPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share__detail);

        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.back_button);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pay = new Intent(Share_Detail.this,SecondActivity.class);
                startActivity(pay);
                finish();
            }
        });

        confirm_booking = findViewById(R.id.confirm_booking);
        gov_id = findViewById(R.id.edit_spinner);
        id_number = findViewById(R.id.id_number);
        indian_number = findViewById(R.id.indian_phone_no);
        other_phone_no = findViewById(R.id.others_phone_no);

        EditSpinner();
        confirm_booking();

    }

    private void confirm_booking() {

        confirm_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent booking = new Intent(Share_Detail.this,Booking_Confirmed.class);
                startActivity(booking);

            }
        });

    }

    private void EditSpinner() {

        // Spinner Drop down elements
        List<String> List = new ArrayList<String>();
        List.add("Aadhar-Card");
        List.add("Pan-Card");
        List.add("Voter-Id");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, List);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        gov_id.setAdapter(dataAdapter);

        gov_id.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                Toast.makeText(getApplicationContext(),"Selected",Toast.LENGTH_LONG).show();
            }
        });



    }




}
