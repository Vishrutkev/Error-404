package ca.yorku.error_404;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Incorrect_input_Score_Page extends AppCompatActivity {
    private long mLastClickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.incorrect_inputt_score_page);

        ImageButton helpPopupBtn = (ImageButton) findViewById(R.id.helpIconButton);
        ImageButton exitPopupBtn = (ImageButton) findViewById(R.id.exitIconButton);
        Button returnToMainPageBtn = findViewById(R.id.returntoMainpagebutton);

        TextView numSequenceView = findViewById(R.id.numSeqView);
        TextView userGuessView = findViewById(R.id.userGuessView);

        returnToMainPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (NumGameModel.getHighScore() == 0) {
                    Intent intent = new Intent(Incorrect_input_Score_Page.this, MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(Incorrect_input_Score_Page.this, MainPage2.class);
                    startActivity(intent);
                }
            }
        });

        helpPopupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                Intent intent = new Intent(Incorrect_input_Score_Page.this, HelpPopup.class);
                startActivity(intent);
            }
        });

        exitPopupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                Intent intent = new Intent(Incorrect_input_Score_Page.this, ExitPopup.class);
                startActivity(intent);
            }
        });

    }


}