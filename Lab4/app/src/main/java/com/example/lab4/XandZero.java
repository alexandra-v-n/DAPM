package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class XandZero extends AppCompatActivity {
    // 0 = x, 1 = o
    TextView textView;
    LinearLayout linearLayout;
    GridLayout gridLayout;
    int activePlayer = 0;
    boolean gameIsActive = true;;
     MediaPlayer mpDonut;
     MediaPlayer mpXman;
     MediaPlayer draw;
    // 2 unplayed
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xand_zero);
    }


    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        linearLayout =  findViewById(R.id.linearLayout);
        textView = findViewById(R.id.textView);
        mpXman= MediaPlayer.create(this,R.raw.xmen);
        mpDonut= MediaPlayer.create(this,R.raw.donut);
        draw= MediaPlayer.create(this,R.raw.draw);


        // get the current Image View (counter tag)
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        //if the space is empty(is 2) and the game is not over
        if (gameState[tappedCounter] == 2 && gameIsActive) {
            //set the current player
            gameState[tappedCounter] = activePlayer;
            if (activePlayer == 0) {
                Log.i("Active player 0","x   "+ counter );

                // setImageResource for counter as x
                // TODO
                counter.setImageResource(R.drawable.x);

                // change the player's turn
                activePlayer = 1;
            } else {
                Log.i("Active player 1","1   "+ counter );
                // setImageResource for counter as zero
                // TODO
                counter.setImageResource(R.drawable.zero);
                activePlayer = 0;
            }
            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {
                    // Someone has won!
                    gameIsActive = false;
                    String winner = "DonutKing  ";

                    if (gameState[winningPosition[0]] == 0) {
                        winner = "X-Men ";
                        mpXman.start();
                    }else{
                        mpDonut.start();


                    }
                    // Make a toast with the messaje winner + " has won!"

                    //ex2
                   // Toast.makeText(getApplicationContext(), winner + "has won the game!", Toast.LENGTH_SHORT).show();

                    //TODO

                    //ex4
                    textView.setText(winner + " has won the game!");
                    linearLayout.setVisibility(View.VISIBLE);


                } else {
                    boolean gameIsOver = true;

                    for (int counterState : gameState) {
                        if (counterState == 2)
                            gameIsOver = false;
                    }
                    if (gameIsOver) {
                        // Make a toast with the messaje "It's a draw!"
                        draw.start();

                        //ex2
                        //Toast.makeText(getApplicationContext(), "Its a draw!", Toast.LENGTH_SHORT).show();

                        //TODO

                        //ex4
                       textView.setText("\"Its a draw!\"");


                       linearLayout.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
    }
    public void playAgain (View view){

        gameState = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2};
        activePlayer=0;
        gameIsActive = true;
        mpDonut.stop();
        mpXman.stop();
        draw.stop();
        Log.i("BEFORE","FOR");
        linearLayout.setVisibility(View.INVISIBLE);
        gridLayout = findViewById(R.id.gridLayout);
        for (int i = 0; i< gridLayout.getChildCount(); i++) {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
        Toast.makeText(getApplicationContext(),"The game has been restarted! Good luck!", Toast.LENGTH_SHORT).show();


    }
}