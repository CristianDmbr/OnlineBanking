package com.example.onlinebanking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Map<String, Integer> userList = new HashMap<String, Integer>();

    private EditText usernameView,pinNumberView;
    private Button registerButtonView,logInButtonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        usernameView = findViewById(R.id.editTextTextPersonName);
        pinNumberView = findViewById(R.id.editTextNumberPassword2);

        registerButtonView = findViewById(R.id.button);
        logInButtonView = findViewById(R.id.button2);

        logInButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameInput = usernameView.getText().toString();

                if (nameInput.equals("Cristian")){
                    Toast.makeText(MainActivity.this, nameInput + " is not a registered user. Try another one", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
