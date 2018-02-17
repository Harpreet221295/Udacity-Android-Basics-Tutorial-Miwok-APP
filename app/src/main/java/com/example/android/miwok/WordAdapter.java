package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by harpreet on 8/12/17.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mbackgroundId;

    public WordAdapter(Activity context, ArrayList<Word> words, int backgroundId){
        super(context,0,words);
        mbackgroundId = backgroundId;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Word curWord = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        ImageView imgView = (ImageView) listItemView.findViewById(R.id.image_view);

        miwokTextView.setText(curWord.getMiwokTranslation());
        defaultTextView.setText(curWord.getDefaultTranslation());
        if(curWord.hasImage())
            imgView.setImageResource(curWord.getImageResourceId());
        else
            imgView.setVisibility(View.GONE);

        LinearLayout linear_layout = (LinearLayout) listItemView.findViewById(R.id.linear_layout);
        linear_layout.setBackgroundResource(mbackgroundId);


        return listItemView;
    }
}
