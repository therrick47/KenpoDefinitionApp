package com.example.therr.kenpodefinitionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String EXTRA_ARRAY_ITEM = "com.example.myfirstapp.ARRAYITEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner searchTypeList = (Spinner) findViewById(R.id.searchType);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.searchArr,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        searchTypeList.setAdapter(adapter);
        searchTypeList.setSelection(0);
    }
    public void sendSearch(View view){
        Intent intent = new Intent(this,DisplaySearchActivity.class);
        EditText term = (EditText) findViewById(R.id.txtTerm);
        Spinner searchTypeList = (Spinner) findViewById(R.id.searchType);
        String arrItem = searchTypeList.getSelectedItem().toString();
        String msg = term.getText().toString();
        if(msg != "") {
            intent.putExtra(EXTRA_MESSAGE, msg);
            intent.putExtra(EXTRA_ARRAY_ITEM,arrItem);
            startActivity(intent);
        }
    }
}
