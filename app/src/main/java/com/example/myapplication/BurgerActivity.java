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
        String burgerkompani = extras.getString("company");
        String burgerlokation = extras.getString("location");



        //String burgerkategori = incomingIntent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
        Log.d("jacke","burgerkategori:" + burgerkategori);
        //String burgernamn = incomingIntent.getStringExtra(MainActivity. EXTRA_MESSAGE4);

        Log.d("jacke","burgernamn:" + burgernamn);
        Log.d("jacke","burgerkategori:" + burgerkategori);


        TextView Bname =findViewById(R.id.NamntextView);
        Bname.setText(burgernamn);

        TextView Bkat =findViewById(R.id.Kategoriview);
        Bkat.setText(burgerkategori);

        TextView Bkom =findViewById(R.id.kompaniView);
        Bkom.setText(burgerkompani);

        TextView Blok =findViewById(R.id.locationView);
        Blok.setText(burgerlokation);
    }
}
