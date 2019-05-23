package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;

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
        String burgercost = extras.getString("cost");
        String burgerCals = String.valueOf(extras.getInt("cals"));
        String burgerfats = String.valueOf(extras.getInt("fats"));
        String burgerprots = String.valueOf(extras.getInt("prots"));
        String burgercarbs = String.valueOf(extras.getInt("carbs"));
        String burgerfibs = String.valueOf(extras.getInt("fibs"));
        String burgersalts = String.valueOf(extras.getInt("salts"));


        Log.e("Calories", String.valueOf(burgerCals));


        Log.d("burgare","burgerkategori:" + burgerkategori);

        Log.d("burgare","burgernamn:" + burgernamn);
        Log.d("burgare","burgerkategori:" + burgerkategori);




        TextView Bkat =findViewById(R.id.Kategoriview);
        Bkat.setText("Category: "+burgerkategori);

        TextView Bname =findViewById(R.id.nameView);
        Bname.setText("Name: "+burgernamn);

        TextView Blok =findViewById(R.id.locationView);
        Blok.setText("Location: "+burgerlokation);

        TextView Bsiz =findViewById(R.id.sizeView);
        Bsiz.setText("Size: "+burgersize + " grams");

        TextView Bcos =findViewById(R.id.costView);
        Bcos.setText("Cost: "+burgercost + " kr");

        TextView Bcals =findViewById(R.id.calsView);
        Bcals.setText(burgerCals+ " calories");

        TextView Bfats =findViewById(R.id.fatsView);
        Bfats.setText(burgerfats+ " g fat");

        TextView Bprots =findViewById(R.id.protsView);
        Bprots.setText(burgerprots+ " g proteins");

        TextView Bcarbs =findViewById(R.id.carbsView);
        Bcarbs.setText(burgercarbs+ " g carbs");

        TextView Bfibs =findViewById(R.id.fibsView);
        Bfibs.setText(burgerfibs+ " g fibres");

        TextView Bsalts =findViewById(R.id.saltsView);
        Bsalts.setText(burgersalts+ " g salt");
    }
}
