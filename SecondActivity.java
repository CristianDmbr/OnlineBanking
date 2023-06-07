package com.example.onlinebanking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView displayView;
    private ImageButton returnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_second);

        displayView = findViewById(R.id.textDisplayView);
        returnHome = findViewById(R.id.imageButton2);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        displayView.setText("Greetings " + username + ", welcome back !");


        returnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(homeIntent);
            }
        });

    }

}
