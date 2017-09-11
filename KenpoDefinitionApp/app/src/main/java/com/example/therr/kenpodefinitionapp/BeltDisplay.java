package com.example.therr.kenpodefinitionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class BeltDisplay extends AppCompatActivity {

    public static final String SEND_ITEM = "com.example.therr.kenpodefinitionapp.ItemSend";
    private ListView listView;
    private ArrayList<Terminology> termArr = new ArrayList<Terminology>();
    private String term = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String beltRank = getIntent().getStringExtra(MainActivity.EXTRA_BELT);
        if (beltRank.toLowerCase().contains("white")) {
            this.setTheme(R.style.AppThemeWhite);
        } else if (beltRank.toLowerCase().contains("yellow")) {
            this.setTheme(R.style.AppThemeYellow);
        } else if (beltRank.toLowerCase().contains("orange")) {
            this.setTheme(R.style.AppThemeOrange);
        } else if (beltRank.toLowerCase().contains("green")) {
            this.setTheme(R.style.AppThemeGreen);
        } else if (beltRank.toLowerCase().contains("purple")) {
            this.setTheme(R.style.AppThemePurple);
        } else if (beltRank.toLowerCase().contains("blue")) {
            this.setTheme(R.style.AppThemeBlue);
        } else if (beltRank.toLowerCase().contains("brown")) {
            this.setTheme(R.style.AppThemeBrown);
        } else if (beltRank.toLowerCase().contains("black")) {
            this.setTheme(R.style.AppThemeBlack);
        }
        setContentView(R.layout.activity_belt_display);

        Intent intent = getIntent();
        listView = (ListView) findViewById(R.id.vwArrList);
        ArrayAdapter<Terminology> arrayAdapter;
        termArr = (ArrayList<Terminology>) intent.getSerializableExtra(MainActivity.EXTRA_ARRAY_LIST);
        term = intent.getStringExtra(MainActivity.EXTRA_BELT);
        getSupportActionBar().setTitle(term + " Belt Definitions");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        arrayAdapter = new ArrayAdapter<Terminology>(this, android.R.layout.simple_list_item_1, termArr);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BeltDisplay.this, DisplayItem.class);
                intent.putExtra(SEND_ITEM, (Terminology) parent.getItemAtPosition(position));

                intent.putExtra(MainActivity.EXTRA_ARRAY_LIST, termArr);
                intent.putExtra(MainActivity.EXTRA_MESSAGE, term);
                intent.putExtra(MainActivity.EXTRA_BELT,beltRank);

                startActivity(intent);
            }
        });
    }
}