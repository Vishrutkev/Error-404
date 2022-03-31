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
import android.widget.Toast;

public class User_Sequence_Input_Page extends AppCompatActivity {
    private Button checkbutton;
    private long mLastClickTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_sequence_inputt_page);
        EditText userGuess = (EditText) findViewById(R.id.userGuess);

        checkbutton = (Button) findViewById(R.id.checkButton);
        checkbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userGuessStr = userGuess.getText().toString();
                NumGameModel.setUserGuess(userGuessStr);

                Boolean isGuessCorrect = NumGameModel.isEquals(userGuessStr);
                if (isGuessCorrect) {
                    Intent intent1 = new Intent(User_Sequence_Input_Page.this, Correct_input_Score_Page.class);
                    startActivity(intent1);
                } else {
                    Intent intent2 = new Intent(User_Sequence_Input_Page.this, Incorrect_input_Score_Page.class);
                    startActivity(intent2);
//                }

                }
            }

        });

        ImageButton helpPopupBtn = (ImageButton) findViewById(R.id.helpIconButton);
        ImageButton exitPopupBtn = (ImageButton) findViewById(R.id.exitIconButton);

        helpPopupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                Intent intent = new Intent(User_Sequence_Input_Page.this, HelpPopup.class);
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

                Intent intent = new Intent(User_Sequence_Input_Page.this, ExitPopup.class);
                startActivity(intent);
            }
        });

    }



}