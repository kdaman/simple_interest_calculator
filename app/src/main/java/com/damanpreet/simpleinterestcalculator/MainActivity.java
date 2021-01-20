package com.damanpreet.simpleinterestcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText principal, rate, time;
    TextView output;
    Button calculate, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principal = findViewById(R.id.principal);
        rate = findViewById(R.id.rate);
        time = findViewById(R.id.time);
        calculate = findViewById(R.id.calculate);
        output = findViewById(R.id.output);
        reset = findViewById(R.id.reset);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateInterest();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output.setText("Output");
                principal.setText("");
                rate.setText("");
                time.setText("");
            }
        });
    }

    private void calculateInterest() {
        Double amount = Double.parseDouble(principal.getText().toString());
        Double ratePercentage = Double.parseDouble(rate.getText().toString());
        Double timeInYears = Double.parseDouble(time.getText().toString());
        Double interest = (amount * ratePercentage * timeInYears) / 100;
        output.setText(interest.toString());
    }
}