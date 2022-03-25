package ca.yorku.error_404;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Correct_input_Score_Page extends AppCompatActivity {
    private Button nextroundbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.correct_inputt_score_page);

        nextroundbutton = (Button) findViewById(R.id.nextRoundbutton);
        nextroundbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNumber_Sequence_Page();
            }
        });

    }


    public void openNumber_Sequence_Page() {
        Intent intent = new Intent(this, Number_Sequence_Page.class);
        startActivity(intent);
    }
}