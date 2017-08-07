package com.example.therr.kenpodefinitionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.therr.kenpodefinitionapp.MESSAGE";
    public static final String EXTRA_ARRAY_LIST="com.example.therr.kenpodefinitionapp.ARRAYLISTVAL";
    public final ArrayList<Terminology> arrTerms = setTermArray();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.constraintLayout).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                return true;
            }
        });
    }

    public void sendSearch(View view){
        Intent intent = new Intent(this,DisplaySearchActivity.class);
        EditText txtTerm = (EditText) findViewById(R.id.txtTerm);
        String term = txtTerm.getText().toString();
        if(term != "") {
            intent.putExtra(EXTRA_MESSAGE, term);
            intent.putExtra(EXTRA_ARRAY_LIST,arrTerms);
            startActivity(intent);
        }
    }
    public void sendAll(View view){
        Intent intent = new Intent(this,DisplaySearchActivity.class);
        intent.putExtra(EXTRA_ARRAY_LIST,arrTerms);
        startActivity(intent);
    }

    private ArrayList<Terminology> setTermArray(){
        ArrayList<Terminology> toReturn = new ArrayList<Terminology>();

        toReturn.add(new Terminology("Zenkutsu Dachi","Front Stance","white"));
        toReturn.add(new Terminology("Neko Ashi Dachi","Cat Stance","white"));
        toReturn.add(new Terminology("Kiba Dachi","Horse Stance","white"));
        toReturn.add(new Terminology("Karate","Empty Hand","white"));
        toReturn.add(new Terminology("Kenpo","Fist Law, Fist Way","white"));
        toReturn.add(new Terminology("Kobudo","Weapons, Ancient Way","white"));
        toReturn.add(new Terminology("Gi","Uniform","white"));
        toReturn.add(new Terminology("Obi","Belt","white"));
        toReturn.add(new Terminology("Dojo","School","white"));
        toReturn.add(new Terminology("Kiai","Spirited or Concentrated yell","white"));
        toReturn.add(new Terminology("Bunkai","Interpretation or Application","white"));
        toReturn.add(new Terminology("Kiyotsuke","Attention","white"));
        toReturn.add(new Terminology("Rei","Bow","white"));
        toReturn.add(new Terminology("Yoi","Ready","white"));
        toReturn.add(new Terminology("Waza","Techniques","gold"));
        toReturn.add(new Terminology("Mae Geri","front kick","white"));
        toReturn.add(new Terminology("Yoko Geri","Step Behind Side Kick","white"));
        toReturn.add(new Terminology("Mawashi Geri","Roundhouse Kick","white"));
        toReturn.add(new Terminology("Tettsui Uchi", "Hammer Fist","white"));
        toReturn.add(new Terminology("Chinto","Fighting to the East","black-2nd"));
        toReturn.add(new Terminology("Tae Zuki","Vertical fist","purple"));
        toReturn.add(new Terminology("Yame","Stop","purple"));
        toReturn.add(new Terminology("Owadi","Finish","purple"));
        toReturn.add(new Terminology("Kyu","Grading of rank held below black belt","purple"));
        toReturn.add(new Terminology("Dan","Grading of rank held above black belt","purple"));
        toReturn.add(new Terminology("Sensei","Person born before another, Teacher, Master, based on age & experience","purple"));
        toReturn.add(new Terminology("Renshi","Honorific Title meaning Polished Instructor. (Skilled person or expert teacher). Can be awarded to 5th Dan and above.","purple"));
        toReturn.add(new Terminology("Kyoshi","Honorific Title meaning an advanced teacher. (Senior Teacher/Expert). Can be awarded to 7th Dan and above.","purple"));
        toReturn.add(new Terminology("Shihan","Honorific Title meaning Master professor, chief instructor, Honorific Title","purple"));
        toReturn.add(new Terminology("Hanshi","Honorific Title meaning a senior expert considered a teacher of teachers, sometimes translated as Grand Master. Can be awarded to 8th Dan and above.","purple"));
        toReturn.add(new Terminology("Kusanku","Warrior General","black-3rd"));
        toReturn.add(new Terminology("Seisan","To attack from 13 directions","black-1st"));
        toReturn.add(new Terminology("To De","Old Karate","low brown"));
        toReturn.add(new Terminology("Kohai","Student lower rank than oneself","green"));
        toReturn.add(new Terminology("Zanshin","Awareness","low brown"));
        toReturn.add(new Terminology("Hai","Yes","low brown"));
        toReturn.add(new Terminology("Iye","No","low brown"));
        toReturn.add(new Terminology("Wakarimas","I understand","low brown"));
        toReturn.add(new Terminology("Wakarimasen","I do not understand","low brown"));
        toReturn.add(new Terminology("Hidari","Left","high blue"));
        toReturn.add(new Terminology("Migi","Right","high blue"));
        toReturn.add(new Terminology("Yoko","Side","high blue"));
        toReturn.add(new Terminology("Hon","Fingers","high blue"));
        toReturn.add(new Terminology("Tuite","General term for locking/grappling","high blue"));
        toReturn.add(new Terminology("Tsuki","Punch","high blue"));
        toReturn.add(new Terminology("Tanden","The point just below the navel.","high blue"));
        toReturn.add(new Terminology("Renmei","Federation or association, a governing entity","blue"));
        toReturn.add(new Terminology("Do","The way (path to self enlightenment).","blue"));
        toReturn.add(new Terminology("Bushido","Way of the warrior","blue"));
        toReturn.add(new Terminology("Bujutsu","Fighting arts of the warrior class of Japan","blue"));
        toReturn.add(new Terminology("Kihon","Basic","blue"));
        toReturn.add(new Terminology("Kime","Focus.","blue"));
        toReturn.add(new Terminology("Ryu","Style of school or martial art","blue"));
        toReturn.add(new Terminology("Uki","Attacker, to whom techniques are done","blue"));
        toReturn.add(new Terminology("Tori","Defender, demonstrator of technique","blue"));
        toReturn.add(new Terminology("Kyusho","Pressure point","blue"));
        toReturn.add(new Terminology("Pinan","Peace of Mind","purple"));
        toReturn.add(new Terminology("Haito Uchi/Haitto Uchi","Ridgehand","green"));
        toReturn.add(new Terminology("Crescent Kick","Mikazuki Geri","green"));
        toReturn.add(new Terminology("Senpai","Senior Student","green"));
        toReturn.add(new Terminology("Ki/Chi","Inner Energy","green"));
        toReturn.add(new Terminology("Ohayo Gozaimas","Good Morning","green"));
        toReturn.add(new Terminology("Nukite","spear hand strike","green"));
        toReturn.add(new Terminology("Kon'nichiwa","Good Afternoon","green"));
        toReturn.add(new Terminology("Kuzushi","to unbalance","green"));
        toReturn.add(new Terminology("Konbanwa","Good Evening","green"));
        toReturn.add(new Terminology("Empe/Empi","elbow","green"));
        toReturn.add(new Terminology("Jodan","high, ex. the head.","green"));
        toReturn.add(new Terminology("Chudan","middle, ex. chest and stomach area.","green"));
        toReturn.add(new Terminology("Gedan","low, ex. anything below the obi","green"));
        toReturn.add(new Terminology("Ananku","southern lights or peace from the south","blue"));
        toReturn.add(new Terminology("Chou No Kun","Morning Cloud","orange"));
        toReturn.add(new Terminology("Kagi Tsuki","Hook Punch","orange"));
        toReturn.add(new Terminology("Makiwara","Punching Board","orange"));
        toReturn.add(new Terminology("Arigato Gozaimas","Thank you","orange"));
        toReturn.add(new Terminology("Domo Arigato Gozaimas","Thank you Very much","orange"));
        toReturn.add(new Terminology("Shimi Igiri Bo Ichi","Named after a person & a place, geographically: the butt of the island","gold"));
        toReturn.add(new Terminology("Shuto","knife hand","gold"));
        toReturn.add(new Terminology("Tettsui Uchi","Hammer Fist","gold"));
        toReturn.add(new Terminology("Embusen","Pattern","gold"));
        toReturn.add(new Terminology("Pinan","Peace of Mind","gold"));
        toReturn.add(new Terminology("Hajime","Start","gold"));
        toReturn.add(new Terminology("Kumite","Spar or Fight","gold"));


        return toReturn;
    }
}
