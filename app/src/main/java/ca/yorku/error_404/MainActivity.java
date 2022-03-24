package ca.yorku.error_404;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page1);

        button = (Button) findViewById(R.id.playButton1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDifficultySelectionpage();
            }
        });

    }

    public void openDifficultySelectionpage() {
        Intent intent = new Intent(this, DifficultySelectionPage.class);
        startActivity(intent);
    }


}