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
        EditText userGues = (EditText) findViewById(R.id.userGuess);



        checkbutton = (Button) findViewById(R.id.checkButton);
        checkbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = getIntent().getExtras().getString("value1");
                int int1 = Integer.parseInt(userGues.getText().toString());
                String str1 = Integer.toString(int1);
                //String str = getIntent().getExtras().getString("value");
//                int userGue = Integer.parseInt(str1);
//                int finalValue = Integer. parseInt(str);
//                int[] num1 = NumGameModel.Int_to_array(finalValue);
//                int[] num2 = NumGameModel.Int_to_array(userGue);
//                boolean ans = NumGameModel.trueorFalse(num1,num2);
                if (str.equals(str1)) {
                    Intent intent1 = new Intent(User_Sequence_Input_Page.this, Correct_input_Score_Page.class);
                    startActivity(intent1);
                } else {
                   // Toast.makeText(User_Sequence_Input_Page.this," Not equals!",Toast.LENGTH_SHORT);
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