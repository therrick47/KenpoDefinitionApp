package com.example.therr.kenpodefinitionapp;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayItem extends AppCompatActivity {

    private ArrayList<Terminology> termArr=new ArrayList<Terminology>();
    private String term="";
    private String belt="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {

            Intent intent = getIntent();
            Terminology currItem = (Terminology) intent.getSerializableExtra(DisplaySearchActivity.SEND_ITEM);

            termArr = (ArrayList<Terminology>) intent.getSerializableExtra(MainActivity.EXTRA_ARRAY_LIST);
            term = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);


            if (currItem.getBelt().toLowerCase().contains("white")) {
                this.setTheme(R.style.AppThemeWhite);
            } else if (currItem.getBelt().toLowerCase().contains("yellow")) {
                this.setTheme(R.style.AppThemeYellow);
            } else if (currItem.getBelt().toLowerCase().contains("orange")) {
                this.setTheme(R.style.AppThemeOrange);
            } else if (currItem.getBelt().toLowerCase().contains("green")) {
                this.setTheme(R.style.AppThemeGreen);
            } else if (currItem.getBelt().toLowerCase().contains("purple")) {
                this.setTheme(R.style.AppThemePurple);
            } else if (currItem.getBelt().toLowerCase().contains("blue")) {
                this.setTheme(R.style.AppThemeBlue);
            } else if (currItem.getBelt().toLowerCase().contains("brown")) {
                this.setTheme(R.style.AppThemeBrown);
            } else if (currItem.getBelt().toLowerCase().contains("black")) {
                this.setTheme(R.style.AppThemeBlack);
            }

            setContentView(R.layout.activity_display_item);

            TextView termName = (TextView) findViewById(R.id.txtTerm);
            TextView termDef = (TextView) findViewById(R.id.txtDef);
            TextView termBelt = (TextView) findViewById(R.id.txtBelt);
            TextView termPho = (TextView) findViewById(R.id.txtPho) ;
            termName.setText(currItem.getName());
            termDef.setText(currItem.getDef());
            termBelt.setText(currItem.getBelt());
            termPho.setText(currItem.getPhonetic());
            belt=currItem.getBelt();
        }
        catch(Exception ex){
            ex.printStackTrace();
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {

            Intent intent;
            String currBelt=getIntent().getStringExtra(MainActivity.EXTRA_BELT);
            if(currBelt == null) {
                intent = new Intent(DisplayItem.this, DisplaySearchActivity.class);
            }
            else{
                intent = new Intent(DisplayItem.this, BeltDisplay.class);
            }
            intent.putExtra(MainActivity.EXTRA_ARRAY_LIST,termArr);
            intent.putExtra(MainActivity.EXTRA_MESSAGE, term);
            intent.putExtra(MainActivity.EXTRA_BELT,belt);

            startActivity(intent);

            return true;
        } else {
            return  false;
        }
    }
}
