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
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.therr.kenpodefinitionapp.MESSAGE";
    public static final String EXTRA_ARRAY_LIST="com.example.therr.kenpodefinitionapp.ARRAYLISTVAL";
    public static final String EXTRA_BELT="com.example.therr.kenpodefinitionapp.BELT";
    public final ArrayList<Terminology> arrTerms = setTermArray();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner beltSpin = (Spinner) findViewById(R.id.spnBelt);
        try{
            Field drpDwn = Spinner.class.getDeclaredField("mPopup");
            drpDwn.setAccessible(true);
            android.widget.ListPopupWindow popupWindow= (android.widget.ListPopupWindow) drpDwn.get(beltSpin);
            popupWindow.setHeight(800);
        }
        catch (Exception ex){

        }

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
        if(!term.equals("")) {
            ArrayList<Terminology> subList = new ArrayList<Terminology>();
            for (int a = 0; a < arrTerms.size(); a++) {
                if (arrTerms.get(a).getName().toLowerCase().contains(term.toLowerCase())
                        || arrTerms.get(a).getDef().toLowerCase().contains(term.toLowerCase())
                        || arrTerms.get(a).getBelt().toLowerCase().contains(term.toLowerCase())) {
                    subList.add(arrTerms.get(a));
                }
            }
            intent.putExtra(EXTRA_MESSAGE, term);
            intent.putExtra(EXTRA_ARRAY_LIST,subList);
            startActivity(intent);
        }
    }
    public void sendBelt(View view){
        Intent intent = new Intent(this,BeltDisplay.class);
        Spinner spin = (Spinner) findViewById(R.id.spnBelt);
        String belt=spin.getSelectedItem().toString();
        intent.putExtra(EXTRA_BELT,belt);

        ArrayList<Terminology> subList = new ArrayList<Terminology>();
        for (int a = 0; a < arrTerms.size(); a++) {
            if (arrTerms.get(a).getBelt().toLowerCase().equals(belt.toLowerCase())) {
                subList.add(arrTerms.get(a));
            }
        }
        Collections.sort(subList,(new Comparator<Terminology>() {
            @Override
            public int compare(Terminology o1, Terminology o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }));

        intent.putExtra(EXTRA_ARRAY_LIST,subList);
        startActivity(intent);
    }

    public void sendAll(View view){
        Intent intent = new Intent(this,DisplaySearchActivity.class);
        intent.putExtra(EXTRA_ARRAY_LIST,arrTerms);
        startActivity(intent);
    }

    private ArrayList<Terminology> setTermArray(){
        ArrayList<Terminology> toReturn = new ArrayList<Terminology>();

        toReturn.add(new Terminology("Zenkutsu Dachi","Front Stance","white","Zen-koot-soo dot-chee"));
        toReturn.add(new Terminology("Neko Ashi Dachi","Cat Stance","white","Neigh-ko ah-shee dot-chee"));
        toReturn.add(new Terminology("Kiba Dachi","Horse Stance","white","Kee-buh dot-chee"));
        toReturn.add(new Terminology("Karate","Empty Hand","white","Kah-rah-teh"));
        toReturn.add(new Terminology("Kenpo","Fist Law, Fist Way","white","Ken-poh"));
        toReturn.add(new Terminology("Kobudo","Weapons, Ancient Way","white","Koh-boo-doh"));
        toReturn.add(new Terminology("Gi","Uniform","white","Gee"));
        toReturn.add(new Terminology("Obi","Belt","white","Oh-bee"));
        toReturn.add(new Terminology("Dojo","School","white","Doh-joe"));
        toReturn.add(new Terminology("Kiai","Spirited or Concentrated yell","white","Kee-aye"));
        toReturn.add(new Terminology("Bunkai","Interpretation or Application","white","Boon-kah-ee"));
        toReturn.add(new Terminology("Kiyotsuke","Attention","white","Kee-oh-t-soo-kay"));
        toReturn.add(new Terminology("Rei(Dei)","Bow","white","Ray/Day"));
        toReturn.add(new Terminology("Yoi","Ready","white","Yoh-ee"));
        toReturn.add(new Terminology("Waza","Techniques","yellow","Wah-zah"));
        toReturn.add(new Terminology("Mae Geri","front kick","white","My ge-ree"));
        toReturn.add(new Terminology("Yoko Geri","Step Behind Side Kick","white","Yo-koh ge-ree"));
        toReturn.add(new Terminology("Mawashi Geri","Roundhouse Kick","white","Mah-wah-shee ge-ree"));
        toReturn.add(new Terminology("Chinto","Fighting to the East","black-2nd","Chin-toh"));
        toReturn.add(new Terminology("Tae Zuki","Vertical fist","purple","Tie zoo-kee"));
        toReturn.add(new Terminology("Yame","Stop","purple","Yah-meh"));
        toReturn.add(new Terminology("Owadi","Finish","purple","Oh-wah-dee"));
        toReturn.add(new Terminology("Kyu","Grading of rank held below black belt","purple","Kee-u"));
        toReturn.add(new Terminology("Dan","Grading of rank held above black belt","purple","Dah-n"));
        toReturn.add(new Terminology("Sensei","Person born before another, Teacher, Master, based on age & experience","purple","Sen-say"));
        toReturn.add(new Terminology("Renshi","Honorific Title meaning Polished Instructor. (Skilled person or expert teacher). Can be awarded to 5th Dan and above.","purple","Ren-shee"));
        toReturn.add(new Terminology("Kyoshi","Honorific Title meaning an advanced teacher. (Senior Teacher/Expert). Can be awarded to 7th Dan and above.","purple","Kee-oh-shee"));
        toReturn.add(new Terminology("Shihan","Honorific Title meaning Master professor, chief instructor, Honorific Title","purple","Shee-han"));
        toReturn.add(new Terminology("Hanshi","Honorific Title meaning a senior expert considered a teacher of teachers, sometimes translated as Grand Master. Can be awarded to 8th Dan and above.","purple","Han-shee"));
        toReturn.add(new Terminology("Kusanku","Warrior General","black-3rd","Koo-sahn-koo"));
        toReturn.add(new Terminology("Seisan","To attack from 13 directions","black-1st","Say-sahn"));
        toReturn.add(new Terminology("ToDe","Old Karate","low brown","Toe-Day"));
        toReturn.add(new Terminology("Kohai","Student lower rank than oneself","green","Koh-high"));
        toReturn.add(new Terminology("Zanshin","Awareness","low brown","Zahn-shin"));
        toReturn.add(new Terminology("Hai","Yes","low brown","Ha-ee"));
        toReturn.add(new Terminology("Iye","No","low brown","Ee-yay"));
        toReturn.add(new Terminology("Wakarimas","I understand","low brown","Wah-kah-ree-mah-ss"));
        toReturn.add(new Terminology("Wakarimasen","I do not understand","low brown","Wah-kah-ree-mah-sen"));
        toReturn.add(new Terminology("Hidari","Left","high blue","Hee-dah-ree"));
        toReturn.add(new Terminology("Migi","Right","high blue","Mee-gee"));
        toReturn.add(new Terminology("Yoko","Side","high blue","Yoh-koh"));
        toReturn.add(new Terminology("Hon","Fingers","high blue","Hoh-n"));
        toReturn.add(new Terminology("Tuite","General term for locking/grappling","high blue","Too-ee-teh"));
        toReturn.add(new Terminology("Tsuki","Punch","high blue","T-soo-kee"));
        toReturn.add(new Terminology("Tanden","The point just below the navel.","high blue","Tahn-den"));
        toReturn.add(new Terminology("Renmei","Federation or association, a governing entity","blue","Rehn-may"));
        toReturn.add(new Terminology("Do","The way (path to self enlightenment).","blue","Doh"));
        toReturn.add(new Terminology("Bushido","Way of the warrior","blue","Boo-shee-doh"));
        toReturn.add(new Terminology("Bujutsu","Fighting arts of the warrior class of Japan","blue","Boo-joot-soo"));
        toReturn.add(new Terminology("Kihon","Basic","blue","Kee-hoh-n"));
        toReturn.add(new Terminology("Kime","Focus.","blue","Kee-meh"));
        toReturn.add(new Terminology("Ryu","Style of school or martial art","blue","Ree-you"));
        toReturn.add(new Terminology("Uki","Attacker, to whom techniques are done","blue","Oo-kee"));
        toReturn.add(new Terminology("Tori","Defender, demonstrator of technique","blue","Toh-ree"));
        toReturn.add(new Terminology("Kyusho","Pressure point","blue","Kee-you-show"));
        toReturn.add(new Terminology("Pinan","Peace of Mind","purple","Pee-nah-n"));
        toReturn.add(new Terminology("Haito Uchi/Haitto Uchi","Ridgehand","green","High-toe oo-chee"));
        toReturn.add(new Terminology("Mikazuki Geri","Crescent Kick","green","Mee-kah-zoo-kee geh-ree"));
        toReturn.add(new Terminology("Senpai","Senior Student","green","Sen-pie"));
        toReturn.add(new Terminology("Ki/Chi","Inner Energy","green","Kee/Chee"));
        toReturn.add(new Terminology("Ohayo Gozaimas","Good Morning","green","Oh-high-oh Goh-z-eye-mah-s"));
        toReturn.add(new Terminology("Nukite","spear hand strike","green","Noo-kee-teh"));
        toReturn.add(new Terminology("Konnichiwa","Good Afternoon","green","Koh-nee-chee-wah"));
        toReturn.add(new Terminology("Kuzushi","to unbalance","green","Koo-zoo-shee"));
        toReturn.add(new Terminology("Konbonwa","Good Evening","green","Koh-n-boh-n-wah"));
        toReturn.add(new Terminology("Empe/Empi","elbow","green","Ehm-peh"));
        toReturn.add(new Terminology("Jodan","high, ex. the head.","green","Joe-dahn"));
        toReturn.add(new Terminology("Chudan","middle, ex. chest and stomach area.","green","Chuu-dahn"));
        toReturn.add(new Terminology("Gedan","low, ex. anything below the obi","green","Geh-dahn"));
        toReturn.add(new Terminology("Ananku","southern lights or peace from the south","blue","Ah-nah-n-koo"));
        toReturn.add(new Terminology("Chou No Kun","Morning Cloud","orange","Choo no koon"));
        toReturn.add(new Terminology("Kagi Tsuki","Hook Punch","orange","Kah-gee t-soo-kee"));
        toReturn.add(new Terminology("Makiwara","Punching Board","orange","Mah-kee-wah-rah"));
        toReturn.add(new Terminology("Arigato Gozaimas","Thank you","orange","Ah-ree-gah-toe goh-z-aye-mah-ss"));
        toReturn.add(new Terminology("Domo Arigato Gozaimas","Thank you Very much","orange","Doh-moh ah-ree-gah-toe goh-z-aye-mah-ss"));
        toReturn.add(new Terminology("Shimi Igiri Bo Ichi","Named after a person & a place, geographically: the butt of the island","yellow","Shee-mee ee-gee-ree Bo ee-chee"));
        toReturn.add(new Terminology("Shuto","knife hand","yellow","Shoo-toe"));
        toReturn.add(new Terminology("Tettsui Uchi","Hammer Fist","yellow","Teh-t-soo-ee oo-chee"));
        toReturn.add(new Terminology("Embusen","Pattern","yellow","Ehm-boo-sen"));
        toReturn.add(new Terminology("Pinan","Peace of Mind","yellow","Pee-nahn"));
        toReturn.add(new Terminology("Hajime","Start","yellow","Hah-gee-may"));
        toReturn.add(new Terminology("Kumite","Spar or Fight","yellow","Koo-mee-teh"));


        return toReturn;
    }
}
