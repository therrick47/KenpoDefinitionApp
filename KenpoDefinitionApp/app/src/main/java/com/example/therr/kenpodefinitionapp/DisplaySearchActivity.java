package com.example.therr.kenpodefinitionapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DisplaySearchActivity extends AppCompatActivity {

    public static final String SEND_ITEM = "com.example.therr.kenpodefinitionapp.ItemSend";
    private ListView listView;
    private ArrayList<Terminology> valList;
    private ArrayList<Terminology> termArr=new ArrayList<Terminology>();
    private String term="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_search);



        Intent intent = getIntent();
        listView = (ListView) findViewById(R.id.vwArrList);
        ArrayAdapter<Terminology> arrayAdapter;
        termArr=(ArrayList<Terminology>) intent.getSerializableExtra(MainActivity.EXTRA_ARRAY_LIST);
        term=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        valList = termArr;
         Collections.sort(valList,(new Comparator<Terminology>() {
            @Override
            public int compare(Terminology o1, Terminology o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }));
        if (term == null) {
            getSupportActionBar().setTitle("Browsing All Definitions");
            arrayAdapter = new ArrayAdapter<Terminology>(this, android.R.layout.simple_list_item_1, valList);
        } else {
            term = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
            getSupportActionBar().setTitle("Browsing: "+term);
            ArrayList<Terminology> subList = new ArrayList<Terminology>();
            for (int a = 0; a < valList.size(); a++) {
                if (valList.get(a).getName().toLowerCase().contains(term.toLowerCase())
                        || valList.get(a).getDef().toLowerCase().contains(term.toLowerCase())
                        || valList.get(a).getBelt().toLowerCase().contains(term.toLowerCase())) {
                    subList.add(valList.get(a));
                }
            }
            arrayAdapter = new ArrayAdapter<Terminology>(this, android.R.layout.simple_list_item_1, subList);
        }

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DisplaySearchActivity.this, DisplayItem.class);
                intent.putExtra(SEND_ITEM, (Terminology) parent.getItemAtPosition(position));

                intent.putExtra(MainActivity.EXTRA_ARRAY_LIST,termArr);
                intent.putExtra(MainActivity.EXTRA_MESSAGE,term);
                startActivity(intent);
            }
        });
    }
}
