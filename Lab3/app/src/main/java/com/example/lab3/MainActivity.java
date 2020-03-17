package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String username ="ana";
    String password = "maria";
    EditText usernameTxt;
    EditText passwordTxt;
    String actualUsername;
    String actualPassword;
    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginBtn = findViewById(R.id.loginBtn);
        usernameTxt = findViewById(R.id.username);
        passwordTxt = findViewById(R.id.password);

        loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                actualPassword= passwordTxt.getText().toString();
                actualUsername = usernameTxt.getText().toString();
                Log.i("USERNAME","username is "+ actualUsername );
                Log.i("PASSWORD","password is  "+ actualPassword );
                if(actualUsername.equals(username) && actualPassword.equals(password)){
                    Log.i("Checking login","LOGGING IN ");
                    Intent intent= new Intent(getApplicationContext(), FindTheNumberActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Logged in successfully", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(MainActivity.this,"Wrong username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



}
