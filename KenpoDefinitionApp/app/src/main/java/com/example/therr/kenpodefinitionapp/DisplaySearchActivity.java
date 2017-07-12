package com.example.therr.kenpodefinitionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplaySearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_search);

        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String arrItem = intent.getStringExtra(MainActivity.EXTRA_ARRAY_ITEM);
        TextView vwSearch = (TextView) findViewById(R.id.txtTermSearched);
        TextView derp = (TextView) findViewById(R.id.textView3);
        vwSearch.setText(msg);
        derp.setText(arrItem);
    }
}
