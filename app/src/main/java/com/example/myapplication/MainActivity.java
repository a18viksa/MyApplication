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


// Create a new class, Mountain, that can hold your JSON data

// Create a ListView as in "Assignment 1 - Toast and ListView"

// Retrieve data from Internet service using AsyncTask and the included networking code

// Parse the retrieved JSON and update the ListView adapter

// Implement a "refresh" functionality using Android's menu system


public class MainActivity extends AppCompatActivity {

    /* public static final String EXTRA_MESSAGE = "com.example.myapplication.extra.MESSAGE";
    public static final String EXTRA_MESSAGE1 = "com.example.myapplication.extra.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.example.myapplication.extra.MESSAGE";
    public static final String EXTRA_MESSAGE3 = "com.example.myapplication.extra.MESSAGE";
    public static final String EXTRA_MESSAGE4 = "com.example.myapplication.extra.MESSAGE";
    public static final String EXTRA_MESSAGE5 = "com.example.myapplication.extra.MESSAGE"; */

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
                //Toast.makeText(getApplicationContext(), adapter.getItem(position).info(), Toast.LENGTH_SHORT).show();
                String storlek = adapter.getItem(position).getSize();
                String kostnad = adapter.getItem(position).getCost();
                String lokation = adapter.getItem(position).getLocation();
                String kategori = adapter.getItem(position).getCategory();
                String kompani = adapter.getItem(position).getCompany();
                String namn = adapter.getItem(position).toString();
                String aux = adapter.getItem(position).getAux();
                int cals = adapter.getItem(position).getCals();
                message(view, storlek, kostnad, lokation, kategori, kompani, namn, aux, cals);


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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
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
            // These two variables need to be declared outside the try/catch
            // so that they can be closed in the finally block.
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            // Will contain the raw JSON response as a Java string.
            String jsonStr = null;



            try {
                // Construct the URL for the Internet service
                URL url = new URL("https://wwwlab.iit.his.se/brom/kurser/mobilprog/dbservice/admin/getdataasjson.php?type=a18viksa");

                // Create the request to the PHP-service, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // But it does make debugging a *lot* easier if you print out the completed
                    // buffer for debugging.
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                jsonStr = buffer.toString();
                return jsonStr;
            } catch (IOException e) {
                Log.e("PlaceholderFragment", "Error ", e);
                // If the code didn't successfully get the weather data, there's no point in
                // attempting to parse it.
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

            // This code executes after we have received our data. The String object o holds
            // the un-parsed JSON string or is null if we had an IOException during the fetch.

            // Implement a parsing code that loops through the entire JSON and creates objects
            // of our newly created Mountain class.
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
                    String burgerAux = burgers.getString("auxdata");

                    JSONObject aux = new JSONObject(burgerAux);

                    Log.e("blaaa", aux.getString("Calories"));
                    int cals = aux.getInt("Calories");
                   // int cals=aux.getString("Calories");
                 int fats=aux.getInt("Fat");
                    int prots=aux.getInt("Protein");
                    int carbs=aux.getInt("Carbohydrates");
                    int fibs=aux.getInt("Fibers");
                    int salts=aux.getInt("Salt");

                    Log.d("hejå", ""+fats);

                    Log.d("mupp",burgerName);


                    adapter.add(new Burger(burgerName, burgerCompany, burgerLocation, burgerCategory, burgerSize, burgerCost, burgerAux, cals));
                }

                Log.d("mupp",a.toString());



            } catch (JSONException e) {
                e.printStackTrace();
            }



        }


    }
    public void message(View view, String storlek, String kostnad, String lokation, String kategori, String kompani, String namn, String aux, int cals){
        Intent intent = new Intent(getApplicationContext(), BurgerActivity.class);

        Bundle extras = new Bundle();
        extras.putString("size", storlek);
        extras.putString("cost", kostnad);
        extras.putString("location", lokation);
        extras.putString("category", kategori);
        extras.putString("company", kompani);
        extras.putString("name", namn);
        extras.putString("auxdata", aux);
        extras.putInt("cals", cals);





        intent.putExtras(extras);
        startActivity(intent);

        //intent.putExtra(EXTRA_MESSAGE, storlek);
        //intent.putExtra(EXTRA_MESSAGE1, kostnad);
        //intent.putExtra(EXTRA_MESSAGE2, lokation);
        //intent.putExtra(EXTRA_MESSAGE3, kategori);
        //intent.putExtra(EXTRA_MESSAGE4, kompani);
        //intent.putExtra(EXTRA_MESSAGE5, namn);
        Log.d("burgare1","kategori:" + kategori + "\tnamn:" + namn);

        //startActivity(intent);
    }
}


