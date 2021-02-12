package com.example.fragmentdata;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ThirdFragment extends Fragment {
    TextView textView;
    String text;
    Button button;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        text=bundle.getString("text");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_third,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView=view.findViewById(R.id.text1);
        textView.setText(text);
        button=view.findViewById(R.id.button1);
        button.setOnClickListener(v->
        {
            Toast.makeText(getActivity(),"last page to go through",Toast.LENGTH_SHORT).show();
        });
    }
    static ThirdFragment getInstance(String text)
    {
        Bundle bundle= new Bundle();
        bundle.putString("text",text);
        ThirdFragment thirdFragment=new ThirdFragment();
        thirdFragment.setArguments(bundle);
        return thirdFragment;
    }

}
