package es.deusto.coffe_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConfirmDeny extends AppCompatActivity {

    private Button confirmBtn, denyBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_deny);

        confirmBtn = findViewById(R.id.btn_accept);
        denyBtn = findViewById(R.id.btn_deny);
        backBtn = findViewById(R.id.btn_back_from_confirm_deny);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            System.out.println("CONFIRMED");
            Intent anotherOneActivityIntent = new Intent(getApplicationContext(), AnotherOne.class);
            startActivity(anotherOneActivityIntent);
            }
        });

        denyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("DENIED");

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moodActivityIntent = new Intent(getApplicationContext(), Mood.class);
                startActivity(moodActivityIntent);

            }
        });
    }
}