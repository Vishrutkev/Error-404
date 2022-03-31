package ca.yorku.error_404;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Arrays;

public class Number_Sequence_Page extends AppCompatActivity {
    private static final String TAG = "\n";
    private Button readybutton;
    private long mLastClickTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_sequence__page);
        TextView genSeq = findViewById(R.id.genSeq);

        String tempString = NumGameModel.formatArr(Arrays.toString(NumGameModel.getNumList()));


        if (tempString.length() > NumGameModel.getTextSizes()[0]) {
            genSeq.setTextSize(TypedValue.COMPLEX_UNIT_SP, NumGameModel.getTextSizes()[1]);
            genSeq.setText(tempString);
            NumGameModel.updateSizes();
        }
        else {
            genSeq.setText(tempString);
        }

        readybutton = (Button) findViewById(R.id.readyButton);
        readybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Number_Sequence_Page.this, User_Sequence_Input_Page.class);
                startActivity(intent);
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

                Intent intent = new Intent(Number_Sequence_Page.this, HelpPopup.class);
                startActivity(intent);
                finish();
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
                finish();
            }
        });
    }




}
