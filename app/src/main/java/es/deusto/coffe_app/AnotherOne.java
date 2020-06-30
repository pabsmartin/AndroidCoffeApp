package es.deusto.coffe_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnotherOne extends AppCompatActivity {

    private Button yesBtn, noBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_one);

        yesBtn = findViewById(R.id.btn_another_yes);
        noBtn = findViewById(R.id.btn_another_no);
        backBtn = findViewById(R.id.btn_back_from_another_no);

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sizeActivityIntent = new Intent(getApplicationContext(), CoffeeSize.class);
                startActivity(sizeActivityIntent);
            }
        });

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sizeActivityIntent = new Intent(getApplicationContext(), OverallView.class);
                startActivity(sizeActivityIntent);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent moodActivityIntent = new Intent(getApplicationContext(), ConfirmDeny.class);
               startActivity(moodActivityIntent);
           }
        });
    }
}