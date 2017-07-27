package com.localhost.xakep.fragments;

import android.support.v4.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by grok on 11/10/16.
 */
public class FragmentLandscape extends Fragment {

    TextView textView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_landscape, container,false);
        textView = (TextView)view.findViewById(R.id.landscape_text);
        textView.setText("Lorem ipsum dolor sit amet, platonem forensibus pri at. Stet periculis ne quo. Pri vidit eligendi ut, nec eu quaeque suavitate.");
        textView.setTypeface(null, Typeface.ITALIC);
        return view;
    }

    public void showMessage(String text)
    {
        textView.setText(text);
    }
}
