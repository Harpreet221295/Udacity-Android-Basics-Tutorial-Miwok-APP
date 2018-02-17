package com.example.android.miwok;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

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
            words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));

        //final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.naja);

        WordAdapter itemsAdapter = new WordAdapter(this, words,R.color.category_numbers);

        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word clickedWord = (Word)listView.getAdapter().getItem(i);
                int audioResourceId = clickedWord.getAudioResourceId();
                if(audioResourceId != -1) {
                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, audioResourceId);
                    if(mMediaPlayer.isPlaying())
                        mMediaPlayer.pause();
                    else
                        mMediaPlayer.start();
                }
            }
        });
    }


}
