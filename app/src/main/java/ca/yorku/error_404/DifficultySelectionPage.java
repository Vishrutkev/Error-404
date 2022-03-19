package ca.yorku.error_404;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DifficultySelectionPage extends AppCompatActivity {
    private Button easybutton;
    private Button mediumbutton;
    private Button hardbutton;

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

    }


    public void openNumber_Sequence_Page() {
        Intent intent = new Intent(this, Number_Sequence_Page.class);
        startActivity(intent);
    }
}