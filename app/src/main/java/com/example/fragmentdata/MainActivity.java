package com.example.fragmentdata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentLoadedListener {
    FirstFragment firstFragment;
    SecondFragment secondFragment;
    ThirdFragment thirdFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        firstFragment= FirstFragment.getInstance(this);
        fragmentTransaction.add(R.id.framelayout,firstFragment).commit();
    }

    @Override
    public void loadSecondFragment(String data) {
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        secondFragment= SecondFragment.getInstance(data,this);
        fragmentTransaction.add(R.id.framelayout,secondFragment).addToBackStack(null).commit();
    }
    public void loadThirdFragment(String data) {
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
         thirdFragment= ThirdFragment.getInstance(data);
        fragmentTransaction.add(R.id.framelayout,thirdFragment).addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        for(Fragment fragment : getSupportFragmentManager().getFragments())
        {
            if(fragment instanceof SecondFragment)
            {
                firstFragment.text.setText(secondFragment.text);
            }
            else if(fragment instanceof ThirdFragment)
            {
                secondFragment.text = thirdFragment.text;
                secondFragment.textView.setText(thirdFragment.text);
            }
        }
        super.onBackPressed();
    }
}