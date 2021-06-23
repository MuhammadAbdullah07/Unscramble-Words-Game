package com.abdullah.unscramblewords;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {
    //creating variable
    Button blog, bnew;
    TextInputLayout username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        //binding button to variable
        blog = findViewById(R.id.btnlog);
        bnew = findViewById(R.id.btnnew);
        // calling function
        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
        bnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensignup();
            }

            private void opensignup() {
                Intent intent = new Intent(login.this, signup.class);
                startActivity(intent);
                finish();
            }
        });


    }

    //validate username and password that they are empty or not
    private boolean validateUsername() {
        String val = username.getEditText().getText().toString();

        if (val.isEmpty()) {
            username.setError("Field cannot be empty");
            return false;
        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validatePassword() {
        String val = password.getEditText().getText().toString();

        if (val.isEmpty()) {
            password.setError("Field cannot be empty");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }
    //now we will call both validation functions from above and then we will check that
    // data entered by user is in our database or not
    public void loginUser() {
        //Validate Login Info
        if (!validateUsername() | !validatePassword()) {
            return;
        } else {
            isUser();
        }
    }
     //in this function we check that username and password entered by user is present in firebase datbase
     //or not
    private void isUser() {
        String userEnteredusername = username.getEditText().getText().toString().trim();
        String userEnteredpassword = password.getEditText().getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUser = reference.orderByChild("username").equalTo(userEnteredusername);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    username.setError(null);
                    username.setErrorEnabled(false);
                    String passwordinDB = snapshot.child(userEnteredusername).child("password").getValue(String.class);
                    if(passwordinDB.equals(userEnteredpassword)){
                        String nameinDB = snapshot.child(userEnteredusername).child("name").getValue(String.class);
                        String usernameinDB = snapshot.child(userEnteredusername).child("username").getValue(String.class);
                        String phoneNoinDB = snapshot.child(userEnteredusername).child("phoneNo").getValue(String.class);
                        String emailinDB = snapshot.child(userEnteredusername).child("email").getValue(String.class);

                        Intent intent = new Intent(login.this,MainActivity.class);
                        intent.putExtra("name",nameinDB);
                        intent.putExtra("username",usernameinDB);
                        intent.putExtra("email",emailinDB);
                        intent.putExtra("phone",phoneNoinDB);
                        intent.putExtra("password",passwordinDB);
                        startActivity(intent);
                    }
                    else {
                        password.setError("Incorrect Password");
                        password.requestFocus();
                    }
                }else {
                    username.setError("Incorrect Username");
                    username.requestFocus();
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}