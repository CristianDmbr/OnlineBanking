package com.example.onlinebanking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public Map<String, Integer> userList = new HashMap<String, Integer>();


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
                int pinInput = Integer.parseInt(pinNumberView.getText().toString());

                boolean isRegistered = false;

                for (Map.Entry<String, Integer> entry : userList.entrySet()) {
                    String username = entry.getKey();
                    int pin = entry.getValue();

                    if (nameInput.equals(username) && pinInput == pin) {
                        isRegistered = true;
                        break;
                    }
                }


                if (isRegistered) {
                    Intent secondActivity = new Intent(MainActivity.this,SecondActivity.class);
                    secondActivity.putExtra("username",nameInput);
                    Toast.makeText(MainActivity.this, "Log in successful", Toast.LENGTH_LONG).show();
                    startActivity(secondActivity);
                } else {
                    Toast.makeText(MainActivity.this, nameInput + " either is not registered or the pin was incorrect , please Try again !", Toast.LENGTH_LONG).show();
                }
            }
        });



        registerButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        Intent intent = getIntent();
        String userNameCreation = intent.getStringExtra("usernameCreation");
        int pinCreation = intent.getIntExtra("pinCreation",0);
        userList.put(userNameCreation,pinCreation);

    }

}
