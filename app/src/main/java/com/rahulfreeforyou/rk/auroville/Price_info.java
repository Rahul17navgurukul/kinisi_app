package com.rahulfreeforyou.rk.auroville;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Price_info extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Spinner spinner, spinner2;
    RecyclerView recyclerView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_info);

        toolbar = findViewById(R.id.price_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.close_btn);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent second = new Intent(Price_info.this,SecondActivity.class);
                startActivity(second);
                finish();
            }
        });


        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);

        recyclerView = findViewById(R.id.price_rv);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Price_Adapter(this,data()));



        spinnertwo();
        spinnerone();


    }

    private void spinnerone() {

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Step-Through");
        categories.add("Step-Through");
        categories.add("Step-Through");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    private void spinnertwo() {

        spinner2.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("For Volunteers");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner2.setAdapter(dataAdapter2);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {

    }




    public class Price_Adapter extends RecyclerView.Adapter<Price_Adapter.price_info> {


        Context c;
        ArrayList<ListAdapter> listAdapters;

        public Price_Adapter(Context c , ArrayList<ListAdapter>listAdapters)
        {
            this.c = c;
            this.listAdapters = listAdapters;
        }




        @NonNull
        @Override
        public Price_Adapter.price_info onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.price_info_card,parent,false);
            return new price_info(view);


        }

        @Override
        public void onBindViewHolder(@NonNull Price_Adapter.price_info holder, int position) {

            ListAdapter itemholder = listAdapters.get(position);

            holder.tv1.setText(itemholder.getDays());
            holder.tv2.setText(itemholder.getPrice());

        }

        @Override
        public int getItemCount() {
            return listAdapters.size();
        }

        public class price_info extends RecyclerView.ViewHolder {

            TextView tv1;
            TextView tv2;
            public price_info(@NonNull View itemView) {
                super(itemView);

                tv1 = itemView.findViewById(R.id.number_of_days);
                tv2 = itemView.findViewById(R.id.price_per_day);
            }
        }

    }

    public class ListAdapter{

        String days,price;

        public String getDays() {
            return days;
        }

        public void setDays(String days) {
            this.days = days;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }

    private ArrayList data() {

        ArrayList<ListAdapter> listAdapters = new ArrayList<>();
        ListAdapter item = new ListAdapter();


        item.setDays("0-15");
        item.setPrice("200 Rs./day");
        listAdapters.add(item);

        item = new ListAdapter();
        item.setDays("0-15");
        item.setPrice("200 Rs./day");
        listAdapters.add(item);

        item = new ListAdapter();
        item.setDays("0-15");
        item.setPrice("200 Rs./day");
        listAdapters.add(item);

        item = new ListAdapter();
        item.setDays("0-15");
        item.setPrice("200 Rs./day");
        listAdapters.add(item);

        return listAdapters;

    }

    }






