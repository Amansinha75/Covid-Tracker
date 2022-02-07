package com.example.volleytestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView totalCases,newCases,deaths,recovered,activeCases,criticalCases;
    TextView test;
    ProgressBar progressBar;
    SimpleArcLoader loader;
    private IndiaCases activity = new IndiaCases();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Covid Cases: World");
        
        totalCases = findViewById(R.id.totalCases);
        newCases = findViewById(R.id.newCases);
        deaths = findViewById(R.id.deaths);
        recovered = findViewById(R.id.recovered);
        activeCases = findViewById(R.id.activeCases);
        criticalCases = findViewById(R.id.criticalCases);


        loader = findViewById(R.id.loader);

        
        fetchData();
    }

    private void fetchData() {
        activity.ShowDialog(this);
        String url = "https://disease.sh/v3/covid-19/all/";
        loader.start();

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            totalCases.setText(jsonObject.getString("cases"));
                            newCases.setText(jsonObject.getString("todayCases"));
                            deaths.setText(jsonObject.getString("deaths"));
                            recovered.setText(jsonObject.getString("recovered"));
                            activeCases.setText(jsonObject.getString("active"));
                            criticalCases.setText(jsonObject.getString("critical"));

                            Handler makeDelay = new Handler();
                            makeDelay.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    //countryWiseAdapter.notifyDataSetChanged();
                                    activity.DismissDialog();
                                }
                            }, 1000);

                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
        loader.stop();
        loader.setVisibility(View.GONE);

    }

    public void refresh(View view) {
        loader.start();
        fetchData();
        loader.stop();
        loader.setVisibility(View.GONE);
    }

    public void countryData(View view) {
        Intent intent = new Intent(this, CountryWiseDataActivity.class);
        startActivity(intent);
    }


}