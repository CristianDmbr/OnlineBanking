package com.example.bankproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class BalanceActivity extends AppCompatActivity {

    private ImageButton backToMainMenu;
    private TextView displayName;
    private TextView balanceDisplay;

    public static Double balance = 100.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_balance);

        backToMainMenu = findViewById(R.id.backToMainMenuView);
        displayName = findViewById(R.id.displayBalanceName);
        balanceDisplay = findViewById(R.id.balanceDisplayView);

        balanceDisplay.setText("£"+ balance);

        Intent intent = getIntent();
        String userNameDisplay = intent.getStringExtra("usernameCreation");

        if (intent.hasExtra("balance")) {
            balance = intent.getDoubleExtra("balance", 0.0);
        }

        displayName.setText( userNameDisplay + "'s Balance.");

        backToMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent backToSecondActivity = new Intent(BalanceActivity.this,SecondActivity.class);
                backToSecondActivity.putExtra("balance",balance);
                startActivity(backToSecondActivity);

            }
        });

    }
}
