package com.rahulfreeforyou.rk.auroville;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button proceed;
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.back_button);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(main);
                finish();
            }
        });

        recyclerView = findViewById(R.id.rv);
        proceed =findViewById(R.id.proceed);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(SecondActivity.this,"clicked ",Toast.LENGTH_LONG).show();



            }
        });

        proceed.setEnabled(false);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Recycle_v_Adapter(this,data()));

    }



    public class Recycle_v_Adapter extends RecyclerView.Adapter<Recycle_v_Adapter.recyler> {


        Context c;
        ArrayList<ListAdapter> listAdapters;

        String count;


        public Recycle_v_Adapter(Context c , ArrayList<ListAdapter>listAdapters)
        {
            this.c = c;
            this.listAdapters = listAdapters;
        }




        @NonNull
        @Override
        public recyler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Context context;
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.carditem,parent,false);
            return new recyler(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final recyler holder, int position) {

            final ListAdapter itemholder = listAdapters.get(position);

            holder.imageView.setImageResource(itemholder.getImage());
            holder.name.setText(itemholder.getName());
            holder.price.setText(itemholder.getPrice());
            holder.desc.setText(itemholder.getDescription());
            holder.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    holder.btn.setText("Add to cart");
                    holder.elegantNumberButton.setVisibility(View.VISIBLE);
                    holder.btn.setVisibility(View.INVISIBLE);

                }
            });




            final String cyclename = holder.name.getText().toString();
            final String cycleprice = holder.price.getText().toString();
            final String cycledescri = holder.desc.getText().toString();


            holder.elegantNumberButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
                @Override
                public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {

                count = holder.elegantNumberButton.getNumber();
                    proceed.setEnabled(true);
                    proceed.setBackgroundColor(getResources().getColor(R.color.blue));


                }
            });


            proceed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent test = new Intent(SecondActivity.this,Payment_Summary.class);
                    test.putExtra("data1",cyclename);
                    test.putExtra("data2",cycleprice);
                    test.putExtra("data3",cycledescri);
                    test.putExtra("ele_count",count);
                    startActivity(test);
                }
            });

            holder.price_info.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent price_info = new Intent(SecondActivity.this,Price_info.class);
                    startActivity(price_info);

                }
            });




        }




        @Override
        public int getItemCount() {
            return listAdapters.size();
        }

        public class recyler extends RecyclerView.ViewHolder {

            ImageView imageView;
            TextView name , desc, price;
            Button btn;
            ElegantNumberButton elegantNumberButton;
            TextView price_info;


            public recyler(@NonNull View itemView) {
                super(itemView);

                imageView = itemView.findViewById(R.id.img);
                name = itemView.findViewById(R.id.name);
                desc = itemView.findViewById(R.id.des);
                price = itemView.findViewById(R.id.price);
                btn = itemView.findViewById(R.id.btnadd);
                elegantNumberButton = itemView.findViewById(R.id.elegant_num);
                price_info = itemView.findViewById(R.id.price_info);

            }
        }
    }



    public class ListAdapter{

        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        String description;
        String price;

        int image;

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }
    }

    private ArrayList data() {

        ArrayList<ListAdapter> listAdapters = new ArrayList<>();
        ListAdapter item = new ListAdapter();

        item.setImage(R.drawable.dema);
        item.setName("Sporty");
        item.setPrice("(Rs.125 per day)");
        item.setDescription("40-60 kms on single charge of 3 hours");
        listAdapters.add(item);

        item = new ListAdapter();
        item.setImage(R.drawable.one);
        item.setName("Hero");
        item.setPrice("(Rs.125 per day)");
        item.setDescription("40-60 kms on single charge of 3 hours");
        listAdapters.add(item);

        return listAdapters;

    }




}
