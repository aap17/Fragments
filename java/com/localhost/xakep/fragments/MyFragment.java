package com.localhost.xakep.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by grok on 11/15/16.
 */
public abstract class MyFragment extends Fragment{


    MainActivity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity) context;

    }

    public interface MyInterface {
        public void onItemClicked();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity=null;
    }
}
