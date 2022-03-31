package ca.yorku.error_404;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Correct_input_Score_Page extends AppCompatActivity {
    private Button nextroundbutton;
    private long mLastClickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.correct_inputt_score_page);

        TextView currentScore = findViewById(R.id.currentScore2View);
        currentScore.setText("" + NumGameModel.getLatestScore());

        nextroundbutton = (Button) findViewById(R.id.nextRoundbutton);
        nextroundbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNumber_Sequence_Page();
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

                Intent intent = new Intent(Correct_input_Score_Page.this, HelpPopup.class);
                startActivity(intent);
                finish();
            }
        });

        exitPopupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ADD METHOD TO RESET DATA
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                Intent intent = new Intent(Correct_input_Score_Page.this, ExitPopup.class);
                startActivity(intent);
                finish();
            }
        });

    }


    public void openNumber_Sequence_Page() {
        Intent intent = new Intent(this, Number_Sequence_Page.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
}
