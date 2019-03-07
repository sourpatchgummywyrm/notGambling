package com.example.a2021999.notgambling;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class Shop extends Fragment implements View.OnClickListener{

    int lootBoxNum = 0;
    int money = 1000;

    public Shop() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_shop, container, false);
        Button boxBuy = rootView.findViewById(R.id.buyBox);
        Button reset = rootView.findViewById( R.id.restart );
        reset.setOnClickListener( this );
        boxBuy.setOnClickListener( this );
        return rootView;
    }

    public void save(Context c) {
        SharedPreferences.Editor editor = c.getSharedPreferences("nom", MODE_PRIVATE).edit();
        editor.putInt("boxes", lootBoxNum);
        editor.putInt("money", money);
        editor.commit();

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buyBox:
                lootBoxNum += 1;
                money -= 100;
                //Toast.makeText(getActivity(), "Bought a box!", Toast.LENGTH_LONG).show();
                save(getContext());
                break;
            case R.id.restart:
                lootBoxNum = 0;
                money = 1000;
               // Toast.makeText( getActivity(), "Values reset", Toast.LENGTH_SHORT ).show();
                save( getContext() );
                break;

        }
    }
}
