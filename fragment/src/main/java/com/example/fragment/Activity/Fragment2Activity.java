package com.example.fragment.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragment.R;
import com.example.fragment.fragment.BlankFragment;

public class Fragment2Activity extends AppCompatActivity {
    private Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment2);
        b1=findViewById(R.id.btn1);

        b2=findViewById(R.id.btn2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add(new BlankFragment());
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replace(new ListFragment());
            }
        });
    }

    private void replace(Fragment Fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,Fragment).commit();
    }

    private void add(Fragment fragment) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragmentContainerView,fragment).commit();
    }

    public void next(View view) {
        Intent intent=new Intent(Fragment2Activity.this,Frqagment3Activity.class);
        startActivity(intent);
    }
}