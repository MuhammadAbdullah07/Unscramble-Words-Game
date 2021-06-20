package com.abdullah.unscramblewords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {
    //creating variable
    Button blog,bnew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        //binding button to variable
        blog=findViewById(R.id.btnlog);
        bnew=findViewById(R.id.btnnew);
        // calling function
        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openhomepage(); }
            //making function
            private void openhomepage() {
                Intent intent = new Intent(login.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        bnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensignup();
            }
            private void opensignup(){
                Intent intent = new Intent(login.this,signup.class);
                startActivity(intent);
                finish();
            }
        });

    }
}