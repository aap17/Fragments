package com.localhost.xakep.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by grok on 11/9/16.
 */
public class FragmentB extends MyFragment {



    ImageView imageView;
    TextView textView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_two, container,false);
        textView = (TextView)view.findViewById(R.id.fo_text);
        if (savedInstanceState!=null) {
            textView.setText(savedInstanceState.getString("text", "Fragment B"));
        }
        imageView = (ImageView)view.findViewById(R.id.star2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Observable.just(genText()).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        textView.setText(s);
                    }
                });


            }
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text", textView.getText().toString());
    }

    private String genText()
    {
        try {
            Thread.sleep(5000);
            return "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "";
    }


}
