package com.example.fragmentdata;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class    SecondFragment extends Fragment {
    Button button;
    String text;
    TextView textView;
    EditText editText;
    FragmentLoadedListener listener;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        text = bundle.getString("text");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_second,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button =view.findViewById(R.id.button1);
        textView=view.findViewById(R.id.text1);
        textView.setText(text);
        editText=view.findViewById(R.id.edittext);
        button.setOnClickListener(v->{
            String value = editText.getText().toString().trim();
                   listener.loadThirdFragment(text+value);
                   editText.setText(" ");
                });
    }
    static SecondFragment getInstance(String text,FragmentLoadedListener listener)
    {
        SecondFragment secondFragment=new SecondFragment();
        secondFragment.listener=listener;
        Bundle bundle=new Bundle();
        bundle.putString("text",text);
        secondFragment.setArguments(bundle);
        return secondFragment;
    }
}
