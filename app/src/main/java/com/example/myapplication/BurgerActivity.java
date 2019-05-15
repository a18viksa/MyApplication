package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class BurgerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger2);
        Intent incomingIntent = getIntent();



        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String burgerkategori = extras.getString("category");
        String burgernamn = extras.getString("name");
        String burgerlokation = extras.getString("location");
        String burgerkompani = extras.getString("company");
        String burgersize = extras.getString("size");
        String burgercost = extras.getString("company");
        String burgeraux = extras.getString("auxdata");




        //String burgerkategori = incomingIntent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
        Log.d("burgare","burgerkategori:" + burgerkategori);
        //String burgernamn = incomingIntent.getStringExtra(MainActivity. EXTRA_MESSAGE4);

        Log.d("burgare","burgernamn:" + burgernamn);
        Log.d("burgare","burgerkategori:" + burgerkategori);


        TextView Bname =findViewById(R.id.NamntextView);
        Bname.setText("Name: "+burgernamn);

        TextView Bkat =findViewById(R.id.Kategoriview);
        Bkat.setText("Category: "+burgerkategori);

        TextView Bkom =findViewById(R.id.kompaniView);
        Bkom.setText("Company: "+burgerkompani);

        TextView Blok =findViewById(R.id.locationView);
        Blok.setText("Location: "+burgerlokation);

        TextView Bsiz =findViewById(R.id.sizeView);
        Bsiz.setText("Size: "+burgersize);

        TextView Bcos =findViewById(R.id.costView);
        Bcos.setText("Cost: "+burgercost);

        TextView Baux =findViewById(R.id.auxView);
        Baux.setText(burgeraux);
    }
}
