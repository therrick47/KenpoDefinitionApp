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

public class DisplaySearchActivity extends AppCompatActivity {

    public static final String SEND_ITEM = "com.example.therr.kenpodefinitionapp.ItemSend";
    private ListView listView;
    private ArrayList<Terminology> valList;


    private boolean viewAll=false;
    private ArrayList<Terminology> termArr=new ArrayList<Terminology>();
    private String msg="";
    private String arrItem="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_search);

        TextView vwSearch = (TextView) findViewById(R.id.txtTermSearched);
        Intent intent = getIntent();
        viewAll = intent.getBooleanExtra(MainActivity.EXTRA_TYPE, true);
        listView = (ListView) findViewById(R.id.vwArrList);
        ArrayAdapter<Terminology> arrayAdapter;
        termArr=(ArrayList<Terminology>) intent.getSerializableExtra(MainActivity.EXTRA_ARRAY_LIST);
        valList = termArr;

        if (viewAll) {
            vwSearch.setText("ALL");
            arrayAdapter = new ArrayAdapter<Terminology>(this, android.R.layout.simple_list_item_1, valList);
        } else {
            msg = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
            arrItem = intent.getStringExtra(MainActivity.EXTRA_ARRAY_ITEM);
            ArrayList<Terminology> subList = new ArrayList<Terminology>();
            if (arrItem.equals("Name")) {
                for (int a = 0; a < valList.size(); a++) {
                    if (valList.get(a).getName().equals(msg)) {
                        subList.add(valList.get(a));
                    }
                }
            } else if (arrItem.equals("Description")) {
                for (int a = 0; a < valList.size(); a++) {
                    if (valList.get(a).getDef().equals(msg)) {
                        subList.add(valList.get(a));
                    }
                }
            }
            arrayAdapter = new ArrayAdapter<Terminology>(this, android.R.layout.simple_list_item_1, subList);
            vwSearch.setText("Searching for: " + msg);
        }

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DisplaySearchActivity.this, DisplayItem.class);
                intent.putExtra(SEND_ITEM, (Terminology) parent.getItemAtPosition(position));

                intent.putExtra(MainActivity.EXTRA_TYPE,viewAll);
                intent.putExtra(MainActivity.EXTRA_ARRAY_LIST,termArr);
                if(!viewAll){
                    intent.putExtra(MainActivity.EXTRA_MESSAGE,msg);
                    intent.putExtra(MainActivity.EXTRA_ARRAY_ITEM,arrItem);
                }
                startActivity(intent);
            }
        });
    }
}
