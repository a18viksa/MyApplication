package com.example.myapplication;


import android.content.Intent;
import android.location.Location;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;




public class MainActivity extends AppCompatActivity {



    private ArrayList<Burger> burgerArrayList=new ArrayList<>();
    private ArrayAdapter<Burger> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        adapter=new ArrayAdapter<Burger>(this,R.layout.list_item_textview,R.id.list_item_textview);
        ListView myListView = (ListView) findViewById(R.id.list_item_textview);
        myListView.setAdapter(adapter);
        new FetchData().execute();

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Burger b = adapter.getItem(position);

                String storlek = b.getSize();
                String kostnad = b.getCost();
                String lokation = b.getLocation();
                String kategori = b.getCategory();
                String kompani = b.getCompany();
                String namn = b.toString();
                int cals = b.getCals();
                int fats = b.getFats();
                int prots = b.getProts();
                int carbs = b.getCarbs();
                float fibs = b.getFibs();
                float salts = b.getSalts();

                //Log.d("carbs", ""+ b.getCarbs());

                message(view, storlek, kostnad, lokation, kategori, kompani, namn, cals, fats, prots, carbs, fibs, salts);


            }



        });




    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {

            Intent intent = new Intent(this, about.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_refresh) {

            adapter.clear();
            new FetchData().execute();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class FetchData extends AsyncTask<Void,Void,String>{
        @Override
        protected String doInBackground(Void... params) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            // Will contain the raw JSON response as a Java string.
            String jsonStr = null;



            try {

                URL url = new URL("https://wwwlab.iit.his.se/brom/kurser/mobilprog/dbservice/admin/getdataasjson.php?type=a18viksa");


                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();


                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {

                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {

                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {

                    return null;
                }
                jsonStr = buffer.toString();
                return jsonStr;
            } catch (IOException e) {
                Log.e("PlaceholderFragment", "Error ", e);

                return null;
            } finally{
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e("Network error", "Error closing stream", e);
                    }
                }
            }
        }


        @Override
        protected void onPostExecute(String o) {
            super.onPostExecute(o);


            try {
                JSONArray json1 = new JSONArray(o);
                JSONObject a = new JSONObject(json1.getString(1));


                for(int i = 0; i<json1.length(); i++) {

                    JSONObject burgers = json1.getJSONObject(i);
                    String burgerName = burgers.getString("name");
                    String burgerCompany = burgers.getString("company");
                    String burgerLocation = burgers.getString("location");
                    String burgerCategory = burgers.getString("category");
                    int burgerSize = burgers.getInt("size");
                    int burgerCost = burgers.getInt("cost");

                    JSONObject auxdata = new JSONObject(burgers.getString("auxdata"));


                    int burgerCals = auxdata.getInt("Calories");
                    int burgerFats = auxdata.getInt("Fat");
                    int burgerProts = auxdata.getInt("Protein");
                    int burgerCarbs = auxdata.getInt("Carbohydrates");
                    float burgerFibs = auxdata.getInt("Fibers");
                    float burgerSalts = auxdata.getInt("Salt");




                    //JSONObject aux = new JSONObject(burgerCals);

                    //Log.e("blaaa", aux.getString("Calories"));
                    //int cals = aux.getInt("Calories");

                    Burger b = new Burger(burgerName, burgerCompany, burgerLocation, burgerCategory, burgerSize, burgerCost, burgerCals, burgerFats, burgerProts, burgerCarbs, burgerFibs, burgerSalts);

                    //int cals=aux.getString("Calories");



                    adapter.add(b);
                }

                Log.d("mupp",a.toString());



            } catch (JSONException e) {
                e.printStackTrace();
            }



        }


    }
    public void message(View view, String storlek, String kostnad, String lokation, String kategori, String kompani, String namn, int cals, int fats, int prots, int carbs, float fibs, float salts){
        Intent intent = new Intent(getApplicationContext(), BurgerActivity.class);

        Bundle extras = new Bundle();
        extras.putString("size", storlek);
        extras.putString("cost", kostnad);
        extras.putString("location", lokation);
        extras.putString("category", kategori);
        extras.putString("company", kompani);
        extras.putString("name", namn);
        extras.putInt("cals", cals);
        extras.putInt("fats", fats);
        extras.putInt("prots", prots);
        extras.putInt("carbs", carbs);
        extras.putInt("fibs", (int) fibs);
        extras.putInt("salts", (int) salts);




        intent.putExtras(extras);
        startActivity(intent);

    }
}


