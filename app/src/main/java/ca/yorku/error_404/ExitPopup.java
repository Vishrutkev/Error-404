package ca.yorku.error_404;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ExitPopup extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exit_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width * 0.8), (int)(height * 0.6));

        Button noButton = findViewById(R.id.noButton);
        Button yesButton = findViewById(R.id.yesButton);

        //Fix: can click buttons multiple times, assign boolean click if unopened

        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // IMPLEMENT getLatestScore in NumModel.java
                //if (NumGameModel.getLatestScore == 0) {
                    Intent intent = new Intent(ExitPopup.this, MainActivity.class);
                //}
                //else {
                //    Intent intent = new Intent(ExitPopup.this, MainPage2.class);
                //}
                startActivity(intent);
            }
        });

    }

}