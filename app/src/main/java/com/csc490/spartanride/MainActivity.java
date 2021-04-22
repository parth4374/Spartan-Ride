package com.csc490.spartanride;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public EditText emailId, password;
    Button btnSignUp;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnSignUp = findViewById(R.id.signUp);
        tvSignIn = findViewById(R.id.signIn);
        btnSignUp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                emailId.setError(null);
                password.setError(null);

                String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(MainActivity.this, "Fields are empty!",Toast.LENGTH_SHORT).show();
                }
                else if(email.isEmpty()){
                    emailId.setError("Please enter email address");
                    emailId.requestFocus();
                }
                else if(pwd.isEmpty()){
                    password.setError("Please enter a password");
                    password.requestFocus();
                }
                else try {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Log.d("debug","Signup Unsuccesful");
                                Toast.makeText(MainActivity.this, "Sign Up unsuccessful, please try again",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                startActivity(new Intent(MainActivity.this, MapsActivity.class));
                            }
                        }
                    });
                }
                catch (Exception e) {
                    Log.d("debug","Signup Error Occured!");
                    Toast.makeText(MainActivity.this, "Error Occured!",Toast.LENGTH_SHORT);
                }
            }
        });

        tvSignIn.setOnClickListener(v -> {
            Intent i = new Intent (MainActivity.this,LoginActivity.class);
            startActivity(i);
        });
    }
}