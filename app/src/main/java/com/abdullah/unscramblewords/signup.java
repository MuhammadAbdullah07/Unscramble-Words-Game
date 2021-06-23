package com.abdullah.unscramblewords;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {
     TextInputLayout regname,regusername,regemail,regphone,regpassword;
    Button bsign,balready;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
//    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();
        //binding button to variable
        bsign=findViewById(R.id.btnsign);
        balready=findViewById(R.id.btnalready);
        regname= findViewById(R.id.name);
        regusername= findViewById(R.id.username);
        regemail= findViewById(R.id.email);
        regphone=findViewById(R.id.phonenumber);
        regpassword=findViewById(R.id.password);
  //      mAuth = FirebaseAuth.getInstance();

        bsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
              rootNode = FirebaseDatabase.getInstance();
              reference = rootNode.getReference("users");
              //get all values
                String name= regname.getEditText().getText().toString();
                String username= regusername.getEditText().getText().toString();
                String email= regemail.getEditText().getText().toString();
                String phoneNo= regphone.getEditText().getText().toString();
                String password= regpassword.getEditText().getText().toString();
              userhelper helperclass = new userhelper(name,username,email,phoneNo,password);

                //mAuth.createUserWithEmailAndPassword(email,password)
                  //      .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    //        @Override
                      //      public void onComplete(@NonNull Task<AuthResult> task) {
                        //   if (task.isSuccessful()){
                          //     Toast.makeText(getApplicationContext(),"SignUP In",Toast.LENGTH_SHORT);
                           //}else{
                             //  Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT);

                           //}
                            //}
                        //});
                reference.child(phoneNo).setValue(helperclass);

            }
            private void openHomePage() {
                Intent intent = new Intent(signup.this, MainActivity.class);
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