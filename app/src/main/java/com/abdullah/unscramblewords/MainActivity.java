package com.abdullah.unscramblewords;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.abdullah.unscramblewords.fragments.BlankFragmenteasy;
import com.abdullah.unscramblewords.fragments.BlankFragmenthard;
import com.abdullah.unscramblewords.fragments.BlankFragmentmedium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button frageasy,fragmedium,fraghard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
      frageasy= findViewById(R.id.btn_easy);
      fragmedium= findViewById(R.id.btn_medium);
      fraghard = findViewById(R.id.btn_hard);

      frageasy.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            replaceFragment(new BlankFragmenteasy());
          }
      });
      fragmedium.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              replaceFragment(new BlankFragmentmedium());
          }
      });
      fraghard.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              replaceFragment(new BlankFragmenthard());
          }
      });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,fragment);
        fragmentTransaction.commit();
    }
}