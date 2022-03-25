package ca.yorku.error_404;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Number_Sequence_Page extends AppCompatActivity {
    private Button readybutton;
    private long mLastClickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_sequence__page);

        readybutton = (Button) findViewById(R.id.readyButton);
        readybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUser_Sequence_Input_Page();
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

                Intent intent = new Intent(Number_Sequence_Page.this, HelpPopup.class);
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

                Intent intent = new Intent(Number_Sequence_Page.this, ExitPopup.class);
                startActivity(intent);
            }
        });
    }

    private void openUser_Sequence_Input_Page() {
        Intent intent = new Intent(this, User_Sequence_Input_Page.class);
        startActivity(intent);

    }


}
