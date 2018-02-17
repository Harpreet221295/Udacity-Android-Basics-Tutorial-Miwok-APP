package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        //String [] array = {"one","two","three","four","five","six","seven",
        //                      "eight","nine","ten"};
        //for(int i=0; i<10; i++)
        //Log.v("NumbersActivity", "Word at index "+i+" : "+words[i]);

        ArrayList<Word> words = new ArrayList<>();

        for(int i=0; i<1000; i++)
            words.add(new Word("one", "lutti"));

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }


}
