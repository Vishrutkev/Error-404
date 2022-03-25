package ca.yorku.error_404;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Number_Sequence_Page extends AppCompatActivity {
    private Button readybutton;

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

    }

    private void openUser_Sequence_Input_Page() {
        Intent intent = new Intent(this, User_Sequence_Input_Page.class);
        startActivity(intent);

    }


}
