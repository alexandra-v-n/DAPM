package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class FindTheNumberActivity extends AppCompatActivity {
    Random random;
    Integer random_number;
    Button guessBtn;
    EditText guessedNumber;
    boolean isColor;
    int parsedGuessedNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_the_number);


        random = new Random();
        guessBtn = findViewById(R.id.guessBtn);
        guessedNumber = findViewById((R.id.guessedNumber));


        guessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                random_number = random.nextInt(11);

                try{
                    parsedGuessedNumber= Integer.parseInt(guessedNumber.getText().toString());
                    if(isColor)
                    {
                        guessBtn.setBackgroundColor(Color.BLUE);
                        isColor = false;
                    }
                    else
                    {
                        guessBtn.setBackgroundColor(Color.RED);
                        isColor = true;
                    }

                    if(parsedGuessedNumber==random_number){
                        Toast.makeText(FindTheNumberActivity.this,"You won! Try again", Toast.LENGTH_SHORT).show();
                        guessedNumber.setText(null);
                    }else{
                        if(parsedGuessedNumber< random_number){
                            Toast.makeText(FindTheNumberActivity.this,"Your number is lower!", Toast.LENGTH_SHORT).show();
                        }
                        if(parsedGuessedNumber> random_number){
                            Toast.makeText(FindTheNumberActivity.this,"Your number is higher!", Toast.LENGTH_SHORT).show();
                        }
                    }

                }catch(NumberFormatException e){
                    Log.e("ERROR","Field cannot be empty");
                    Toast.makeText(FindTheNumberActivity.this,"Field cannot be empty.", Toast.LENGTH_SHORT).show();


                }


            }
        });

    }
}
