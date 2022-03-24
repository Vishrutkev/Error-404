package ca.yorku.error_404;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.SystemClock;
import android.widget.ImageButton;

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
                openNumber_Sequence_Page();
            }
        });

        mediumbutton = (Button) findViewById(R.id.mediumButton);
        mediumbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNumber_Sequence_Page();
            }
        });

        hardbutton = (Button) findViewById(R.id.hardButton);
        hardbutton.setOnClickListener(new View.OnClickListener() {
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


    public void openNumber_Sequence_Page() {
        Intent intent = new Intent(this, Number_Sequence_Page.class);
        startActivity(intent);
    }
}
