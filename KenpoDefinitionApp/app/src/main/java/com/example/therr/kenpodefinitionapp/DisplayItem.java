package com.example.therr.kenpodefinitionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayItem extends AppCompatActivity {

    private boolean viewAll=false;
    private ArrayList<Terminology> termArr=new ArrayList<Terminology>();
    private String msg="";
    private String arrItem="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_item);
        TextView termName=(TextView) findViewById(R.id.txtTerm);
        TextView termDef =(TextView) findViewById(R.id.txtDef);
        Intent intent = getIntent();
        Terminology currItem=(Terminology) intent.getSerializableExtra(DisplaySearchActivity.SEND_ITEM);
        termName.setText(currItem.getName());
        termDef.setText(currItem.getDef());

        viewAll=intent.getBooleanExtra(MainActivity.EXTRA_TYPE,true);
        termArr=(ArrayList<Terminology>) intent.getSerializableExtra(MainActivity.EXTRA_ARRAY_LIST);
        if(!viewAll){
            msg = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
            arrItem = intent.getStringExtra(MainActivity.EXTRA_ARRAY_ITEM);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Handle "up" button behavior here.
            Intent intent=new Intent(DisplayItem.this,DisplaySearchActivity.class);
            intent.putExtra(MainActivity.EXTRA_TYPE,viewAll);
            intent.putExtra(MainActivity.EXTRA_ARRAY_LIST,termArr);
            if(!viewAll){
                intent.putExtra(MainActivity.EXTRA_MESSAGE, msg);
                intent.putExtra(MainActivity.EXTRA_ARRAY_ITEM,arrItem);
            }
            startActivity(intent);

            return true;
        } else {
            // handle other items here
            return  false;
        }
        // return true if you handled the button click, otherwise return false.
    }
}
