package ca.yorku.error_404;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageButton;

public class DifficultySelectionPage extends AppCompatActivity {

    private long mLastClickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dificulty_selection_page);

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