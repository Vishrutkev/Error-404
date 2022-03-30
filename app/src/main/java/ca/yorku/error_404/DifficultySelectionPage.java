package ca.yorku.error_404;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.SystemClock;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Arrays;

public class DifficultySelectionPage extends AppCompatActivity {
    private Button easybutton;
    private Button mediumbutton;
    private Button hardbutton;
    private long mLastClickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dificulty_selection_page);


        easybutton = (Button) findViewById(R.id.easyButton);
        easybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] easyNum = NumGameModel.generateRandomNumber(1);
                String eS = Arrays.toString(easyNum);
                Intent i = new Intent(DifficultySelectionPage.this, Number_Sequence_Page.class);
                i.putExtra("value", eS);
                startActivity(i);
                finish();
            }
        });

        mediumbutton = (Button) findViewById(R.id.mediumButton);
        mediumbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] mediumNum = NumGameModel.generateRandomNumber(2);
                String mS = Arrays.toString(mediumNum);
                Intent i1 = new Intent(DifficultySelectionPage.this, Number_Sequence_Page.class);
                i1.putExtra("value", mS);
                startActivity(i1);
                finish();
            }
        });

        hardbutton = (Button) findViewById(R.id.hardButton);
        hardbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] hardNum = NumGameModel.generateRandomNumber(3);
                String hS = Arrays.toString(hardNum);
                Intent i2 = new Intent(DifficultySelectionPage.this, Number_Sequence_Page.class);
                i2.putExtra("value", hS);
                startActivity(i2);
                finish();
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

                Intent intent = new Intent(DifficultySelectionPage.this, HelpPopup.class);
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

                Intent intent = new Intent(DifficultySelectionPage.this, ExitPopup.class);
                startActivity(intent);
            }
        });

    }

}

