package com.localhost.xakep.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by grok on 11/9/16.
 */
public class FragmentA extends MyFragment {

    ImageView imageView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_one, container,false);
        TextView textView = (TextView)view.findViewById(R.id.fo_text);
        textView.setText("Fragment A");
        imageView = (ImageView)view.findViewById(R.id.star1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (activity!=null)
                {
                    activity.onItemClicked();
                } else
                {
                    Log.e("MyFragment", "activity null");
                }
            }
        });
        return view;
    }



    public void sendData(String data)
    {
        Log.e("FragmentA", " "+data);
    }


}
