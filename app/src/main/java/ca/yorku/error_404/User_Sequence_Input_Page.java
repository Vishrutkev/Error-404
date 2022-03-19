package ca.yorku.error_404;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class User_Sequence_Input_Page extends AppCompatActivity {
    private Button checkbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_sequence_inputt_page);

        checkbutton = (Button) findViewById(R.id.checkButton);
        checkbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCorrect_input_Score_Page();
            }
        });

    }


    public void openCorrect_input_Score_Page() {
        Intent intent = new Intent(this, Correct_input_Score_Page.class);
        startActivity(intent);
    }
}