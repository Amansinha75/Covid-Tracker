package com.example.volleytestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class WorldGraphActivity extends AppCompatActivity {
    private List<WorldCovidSample> covidSampleList = new ArrayList<>();
    Spinner spinner;
    Spinner spinner2;
    String[] year = {"Year","2020","2021"};
    String[] months = {"Months","Jan", "Feb", "Mar", "Apr","May","June","July","Aug","Sept","Oct","Nov","Dec"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_graph);
        getSupportActionBar().setTitle("Covid Cases Graph: World");
        spinner = findViewById(R.id.spinner4);
        spinner2 = findViewById(R.id.spinner3);
        ArrayAdapter ad =new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,year);
        ArrayAdapter ad2 =new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,months);
        spinner.setAdapter(ad);

        readCovidData();
        readCovidDataSec();


        BarChart barChart=findViewById(R.id.barChart);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==1 || position==2) {
                    spinner2.setAdapter(ad2);
                }

                if(position==0) {
                    ArrayList<BarEntry> values = new ArrayList<>();
                    values.add(new BarEntry(0, 0));
                    values.add(new BarEntry(0, 0));
                    values.add(new BarEntry(0, 0));

                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                    barDataSet.setValueTextColor(Color.BLACK);
                    barDataSet.setValueTextSize(16f);

                    BarData barData = new BarData(barDataSet);

                    barChart.setFitBars(true);
                    barChart.setData(barData);
                    barChart.getDescription().setText("Bar Chart");
                    barChart.animateY(2000);
                }

                if(position==1) {
                    spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if(position==0) {
                                ArrayList<BarEntry> values = new ArrayList<>();
                                values.add(new BarEntry(0, 0));
                                values.add(new BarEntry(0, 0));
                                values.add(new BarEntry(0, 0));

                                BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                barDataSet.setValueTextColor(Color.BLACK);
                                barDataSet.setValueTextSize(16f);

                                BarData barData = new BarData(barDataSet);

                                barChart.setFitBars(true);
                                barChart.setData(barData);
                                barChart.getDescription().setText("Bar Chart");
                                barChart.animateY(2000);
                            }

                            if(position!=0) {

                                if(position==1) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(0).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(0).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(0).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }

                                if(position==2) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(1).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(1).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(1).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }

                                if(position==3) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(2).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(2).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(2).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }

                                if(position==4) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(3).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(3).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(3).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }

                                if(position==5) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(4).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(4).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(4).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }

                                if(position==6) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(5).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(5).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(5).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }

                                if(position==7) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(6).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(6).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(6).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }

                                if(position==8) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(7).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(7).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(7).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }

                                if(position==9) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(8).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(8).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(8).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }

                                if(position==10) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(9).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(9).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(9).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }

                                if(position==11) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(10).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(10).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(10).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }

                                if(position==12) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(11).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(11).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(11).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

                if(position==2) {
                    spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if(position==0) {
                                ArrayList<BarEntry> values = new ArrayList<>();
                                values.add(new BarEntry(0, 0));
                                values.add(new BarEntry(0, 0));
                                values.add(new BarEntry(0, 0));

                                BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                barDataSet.setValueTextColor(Color.BLACK);
                                barDataSet.setValueTextSize(16f);

                                BarData barData = new BarData(barDataSet);

                                barChart.setFitBars(true);
                                barChart.setData(barData);
                                barChart.getDescription().setText("Bar Chart");
                                barChart.animateY(2000);
                            }

                            if(position!=0) {

                                if(position==1) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(12).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(12).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(12).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }

                                if(position==2) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(13).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(13).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(13).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }

                                if(position==3) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(14).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(14).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(14).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }

                                if(position==4) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(15).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(15).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(15).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }

                                if(position==5) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(16).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(16).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(16).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }

                                if(position==6) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(17).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(17).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(17).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }

                                if(position==7) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(18).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(18).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(18).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }

                                if(position==8) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(19).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(19).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(19).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }

                                if(position==9) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(20).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(20).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(20).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }

                                if(position==10) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(21).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(21).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(21).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }

                                if(position==11) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(22).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(22).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(22).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }

                                if(position==12) {
                                    ArrayList<BarEntry> values = new ArrayList<>();
                                    values.add(new BarEntry(0, covidSampleList.get(23).getConfirmedCases()));
                                    values.add(new BarEntry(0, covidSampleList.get(23).getRecovered()));
                                    values.add(new BarEntry(0, covidSampleList.get(23).getDeaths()));

                                    BarDataSet barDataSet = new BarDataSet(values, "Cases");
                                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                                    barDataSet.setValueTextColor(Color.BLACK);
                                    barDataSet.setValueTextSize(16f);

                                    BarData barData = new BarData(barDataSet);

                                    barChart.setFitBars(true);
                                    barChart.setData(barData);
                                    barChart.getDescription().setText("Bar Chart");
                                    barChart.animateY(2000);
                                }
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void readCovidData() {
        Log.d("MyActivity", "Method started");
        InputStream is = getResources().openRawResource(R.raw.worlddata);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        Log.e("MyActivity", "Method started");
        String line="";
        try {
            reader.readLine();
            Log.e("MyActivity", "line: ");
            while( (line=reader.readLine())!=null) {
                Log.d("MyActivity", "line: ");
                String[] tokens = line.split(",");
                WorldCovidSample sample = new WorldCovidSample();
                sample.setMonth(tokens[0]);
                if(tokens[1].length()>0) {
                    sample.setConfirmedCases(Integer.parseInt(tokens[1]));
                }
                else {
                    sample.setConfirmedCases(0);
                }
                if(tokens[2].length()>0) {
                    sample.setRecovered(Integer.parseInt(tokens[2]));
                }
                else {
                    sample.setRecovered(0);
                }
                if(tokens.length>=3 && tokens[3].length()>0) {
                    sample.setDeaths(Integer.parseInt(tokens[3]));
                }
                else {
                    sample.setDeaths(0);
                }

                covidSampleList.add(sample);

                Log.d("MyActivity", "Just Created: "+ sample);
            }
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading file from csv"+ line, e);
            e.printStackTrace();
        }
    }

    private void readCovidDataSec() {
        Log.d("MyActivity", "Method started");
        InputStream is = getResources().openRawResource(R.raw.worlddata2);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        Log.e("MyActivity", "Method started");
        String line="";
        try {
            reader.readLine();
            Log.e("MyActivity", "line: ");
            while( (line=reader.readLine())!=null) {
                Log.d("MyActivity", "line: ");
                String[] tokens = line.split(",");
                WorldCovidSample sample = new WorldCovidSample();
                sample.setMonth(tokens[0]);
                if(tokens[1].length()>0) {
                    sample.setConfirmedCases(Integer.parseInt(tokens[1]));
                }
                else {
                    sample.setConfirmedCases(0);
                }
                if(tokens[2].length()>0) {
                    sample.setRecovered(Integer.parseInt(tokens[2]));
                }
                else {
                    sample.setRecovered(0);
                }
                if(tokens.length>=3 && tokens[3].length()>0) {
                    sample.setDeaths(Integer.parseInt(tokens[3]));
                }
                else {
                    sample.setDeaths(0);
                }

                covidSampleList.add(sample);

                Log.d("MyActivity", "Just Created: "+ sample);
            }
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading file from csv"+ line, e);
            e.printStackTrace();
        }
    }
}