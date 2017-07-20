package com.example.therr.kenpodefinitionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.therr.kenpodefinitionapp.MESSAGE";
    public static final String EXTRA_ARRAY_ITEM = "com.example.therr.kenpodefinitionapp.ARRAYITEM";
    public static final String EXTRA_TYPE = "com.example.therr.kenpodefinitionapp.BOOLALL";
    public static final String EXTRA_ARRAY_LIST="com.example.therr.kenpodefinitionapp.ARRAYLISTVAL";
    public final ArrayList<Terminology> arrTerms = setTermArray();
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
            intent.putExtra(EXTRA_TYPE,false);
            intent.putExtra(EXTRA_ARRAY_LIST,arrTerms);
            startActivity(intent);
        }
    }
    public void sendAll(View view){
        Intent intent = new Intent(this,DisplaySearchActivity.class);
        intent.putExtra(EXTRA_TYPE,true);
        intent.putExtra(EXTRA_ARRAY_LIST,arrTerms);
        startActivity(intent);
    }

    private ArrayList<Terminology> setTermArray(){
        ArrayList<Terminology> toReturn = new ArrayList<Terminology>();

        toReturn.add(new Terminology("Zenkutsu Dachi","Front Stance"));
        toReturn.add(new Terminology("Neko Ashi Dachi","Cat Stance"));
        toReturn.add(new Terminology("Kiba Dachi","Horse Stance"));
        toReturn.add(new Terminology("Karate","Empty Hand"));
        toReturn.add(new Terminology("Kenpo","Fist Law, Fist Way"));
        toReturn.add(new Terminology("Kobudo","Weapons, Ancient Way"));
        toReturn.add(new Terminology("Gi","Uniform"));
        toReturn.add(new Terminology("Obi","Belt"));
        toReturn.add(new Terminology("Dojo","School"));
        toReturn.add(new Terminology("Kiai","Spirited or Concentrated yell"));
        toReturn.add(new Terminology("Bunkai","Interpretation or Application"));
        toReturn.add(new Terminology("Kiyotske","Attention"));
        toReturn.add(new Terminology("Rei","Bow"));
        toReturn.add(new Terminology("Yoi","Ready"));
        toReturn.add(new Terminology("waza","Techniques"));
        toReturn.add(new Terminology("Mae Geri","front kick"));
        toReturn.add(new Terminology("Yoko Geri","Step Behind Side Kick"));
        toReturn.add(new Terminology("Mawashi Geri","Roundhouse Kick"));
        toReturn.add(new Terminology("Tettsui uchi", "Hammer Fist"));
        toReturn.add(new Terminology("Chinto","Fighting to the East"));
        toReturn.add(new Terminology("Tae zuki","Vertical fist"));
        toReturn.add(new Terminology("Yame","Stop"));
        toReturn.add(new Terminology("Owadi","Finish"));
        toReturn.add(new Terminology("Kyu","Grading of rank held below black belt"));
        toReturn.add(new Terminology("Dan","Grading of rank held above black belt"));
        toReturn.add(new Terminology("Sensei","Person born before another, Teacher, Master, based on age & experience"));
        toReturn.add(new Terminology("Renshi","Honorific Title meaning Polished Instructor. (Skilled person or expert teacher). Can be awarded to 5th Dan and above."));
        toReturn.add(new Terminology("Kyōshi","Honorific Title meaning an advanced teacher. (Senior Teacher/Expert). Can be awarded to 7th Dan and above."));
        toReturn.add(new Terminology("Shihan","Honorific Title meaning Master professor, chief instructor, Honorific Title"));
        toReturn.add(new Terminology("Hanshi","Honorific Title meaning a senior expert considered a teacher of teachers, sometimes translated as Grand Master. Can be awarded to 8th Dan and above."));
        toReturn.add(new Terminology("Kusanku","Warrior General"));
        toReturn.add(new Terminology("Seisan","To attack from 13 directions"));
        toReturn.add(new Terminology("To De","Old Karate"));
        toReturn.add(new Terminology("Kohai","Student lower rank than oneself"));
        toReturn.add(new Terminology("Zanshin","Awareness"));
        toReturn.add(new Terminology("Hai","Yes"));
        toReturn.add(new Terminology("Iye","No"));
        toReturn.add(new Terminology("Wakarimas","I understand"));
        toReturn.add(new Terminology("Wakarimasen","I do not understand"));
        toReturn.add(new Terminology("Hadari","Left"));
        toReturn.add(new Terminology("Migi","Right"));
        toReturn.add(new Terminology("Yoko","Side"));
        toReturn.add(new Terminology("Hon","Fingers"));
        toReturn.add(new Terminology("Tuite","General term for locking/grappling"));
        toReturn.add(new Terminology("Tsuki","Punch"));
        toReturn.add(new Terminology("Tanden","The point just below the navel."));
        toReturn.add(new Terminology("Renmei","Federation or association, a governing entity"));
        toReturn.add(new Terminology("Do","The way (path to self enlightenment)."));
        toReturn.add(new Terminology("Bushido","Way of the warrior"));
        toReturn.add(new Terminology("Bujutsu","Fighting arts of the warrior class of Japan"));
        toReturn.add(new Terminology("Kihon","Basic"));
        toReturn.add(new Terminology("Kime","Focus."));
        toReturn.add(new Terminology("Ryu","Style of school or martial art"));
        toReturn.add(new Terminology("Uki","Attacker, to whom techniques are done"));
        toReturn.add(new Terminology("Tori","Defender, demonstrator of technique"));
        toReturn.add(new Terminology("Kyusho","Pressure point"));
        toReturn.add(new Terminology("Pinan","Peace of Mind"));
        toReturn.add(new Terminology("Haito Uchi/Haitto Uchi","Ridgehand"));
        toReturn.add(new Terminology("Crescent kick","Mikazuki Geri"));
        toReturn.add(new Terminology("Sempai","Senior Student"));
        toReturn.add(new Terminology("Ki/Chi","Inner Energy"));
        toReturn.add(new Terminology("Ohayo Gozaimas","Good Morning"));
        toReturn.add(new Terminology("nukite","spear hand strike"));
        toReturn.add(new Terminology("Kon nichi wa","Good Afternoon"));
        toReturn.add(new Terminology("Kuzushi","to unbalance"));
        toReturn.add(new Terminology("Kon bon wa","Good Evening"));
        toReturn.add(new Terminology("empe/empi","elbow"));
        toReturn.add(new Terminology("Jodan","high, ex. the head."));
        toReturn.add(new Terminology("Chudan","middle, ex. chest and stomach area."));
        toReturn.add(new Terminology("Gedan","low, ex. anything below the obi"));
        toReturn.add(new Terminology("Ananku","southern lights or peace from the south"));
        toReturn.add(new Terminology("Chou No Kun","Morning Cloud"));
        toReturn.add(new Terminology("Kagi tsuki","Hook Punch"));
        toReturn.add(new Terminology("Makiwara","Punching Board"));
        toReturn.add(new Terminology("Arigato Gozaimas","Thank you"));
        toReturn.add(new Terminology("Domo Arigato Gozaimas","Thank you Very much"));
        toReturn.add(new Terminology("Shimi Igiri Bo Ichi","Named after a person & a place, geographically the butt of the island"));
        toReturn.add(new Terminology("Shuto","knife hand"));
        toReturn.add(new Terminology("Tettsui uchi","Hammer Fist"));
        toReturn.add(new Terminology("Embusen","Pattern"));
        toReturn.add(new Terminology("Pinan","Peace of Mind"));
        toReturn.add(new Terminology("Hajime","Start"));
        toReturn.add(new Terminology("Kumite","Spar or Fight"));


        return toReturn;
    }
}
