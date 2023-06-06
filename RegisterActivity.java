package com.example.onlinebanking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class RegisterActivity extends AppCompatActivity {

    private ImageButton homeButton;
    private EditText nameUserInputRegister, pinUserInputRegister;
    private Button registrationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_register);

        homeButton = findViewById(R.id.imageButton);
        nameUserInputRegister = findViewById(R.id.editTextTextPersonName2);
        pinUserInputRegister = findViewById(R.id.editTextNumber);
        registrationButton = findViewById(R.id.button3);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backHome = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(backHome);
            }
        });

        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernameCreation = nameUserInputRegister.getText().toString();
                Integer pinCreation = Integer.parseInt(pinUserInputRegister.getText().toString());

                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                intent.putExtra("usernameCreation",usernameCreation);
                intent.putExtra("pinCreation",pinCreation);

                startActivity(intent);

            }
        });

    }
}
