package ca.yorku.error_404;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainPage2 extends AppCompatActivity {
    private Button playagainbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_pagee2);

        TextView currentScore = findViewById(R.id.currentScore3View);
        TextView highScore = findViewById(R.id.highScoreView);

        currentScore.setText("" + NumGameModel.getLatestScore());
        highScore.setText("" + NumGameModel.getHighScore());

        playagainbutton = (Button) findViewById(R.id.playAgainbutton);
        playagainbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDifficultySelectionpage();
            }
        });

    }

    public void openDifficultySelectionpage() {
        NumGameModel.resetGame();
        Intent intent = new Intent(this, DifficultySelectionPage.class);
        startActivity(intent);


    }
}