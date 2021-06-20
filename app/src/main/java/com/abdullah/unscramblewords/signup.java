package com.abdullah.unscramblewords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signup extends AppCompatActivity {
    Button bsign,balready;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();
        //binding button to variable
        bsign=findViewById(R.id.btnsign);
        balready=findViewById(R.id.btnalready);
        // calling function
        bsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openhomepage(); }
            //making function
            private void openhomepage() {
                Intent intent = new Intent(signup.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        balready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlogin();
            }
            private void openlogin(){
                Intent intent = new Intent(signup.this,login.class);
                startActivity(intent);
                finish();
            }
        });

    }
}