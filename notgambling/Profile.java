package com.example.a2021999.notgambling;


import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


import java.io.IOException;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class Profile extends Fragment{
    public static int lootBoxNum = 0;
    public static int money = 1000;
    private AnimationDrawable boxGif;
    View rootView;
    public Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        ImageButton box = rootView.findViewById( R.id.box );
        try {
            boxGif = new GifAnimationDrawable(getResources().openRawResource( R.raw.rotatecrate ), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        boxGif.setOneShot( true );
        box.setImageDrawable( boxGif );
        boxGif.start();
        ((GifAnimationDrawable) box.getDrawable()).setVisible( true, true );
        load(getActivity(), rootView);
        return rootView;
    }

    public static void load(Activity a, View v) {
        TextView inventory = v.findViewById(R.id.inventory);
        SharedPreferences prefs = a.getSharedPreferences("nom", MODE_PRIVATE);
        try {
            lootBoxNum = prefs.getInt("boxes", 0); // will return 0 if no  value is saved
            money = prefs.getInt("money", 100);
        } catch(NullPointerException e){
            Log.i("Null", "Error");
        }
        inventory.setText("Lootboxes: "+lootBoxNum+"\nCash: "+money);
    }

}
