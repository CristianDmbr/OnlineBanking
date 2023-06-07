package com.example.bankproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class WithdrawActivity extends AppCompatActivity {

    private ImageButton backToSecondActivity;
    private EditText withdrawAmount;
    private Button withdrawButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_withdraw);

        backToSecondActivity = findViewById(R.id.backToSecondActivity);
        withdrawAmount = findViewById(R.id.withdrawAmountView);
        withdrawButton = findViewById(R.id.withdrawButtonView);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("userNameDisplay");
        Double currentBalance = intent.getDoubleExtra("balance",0.0);

        withdrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double withdrawValueAmount = Double.parseDouble(withdrawAmount.getText().toString());

                if (withdrawValueAmount < currentBalance) {
                    Toast.makeText(WithdrawActivity.this, userName + " you don't have enought on your balance to withdraw " + withdrawValueAmount + ".", Toast.LENGTH_SHORT).show();
                } else {
                    double updatedBalance = currentBalance - withdrawValueAmount;
                    Toast.makeText(WithdrawActivity.this, "Successful withdrawal!", Toast.LENGTH_SHORT).show();

                    // Update the balance in the intent for the next activity
                    Intent backToSecondActivity = new Intent(WithdrawActivity.this, SecondActivity.class);
                    backToSecondActivity.putExtra("balance", updatedBalance);
                    startActivity(backToSecondActivity);
                }

            }
        });

        backToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent backToSecondActivity = new Intent(WithdrawActivity.this,SecondActivity.class);
                //backToSecondActivity.putExtra("balance",balance);
                startActivity(backToSecondActivity);

            }
        });
    }
}
