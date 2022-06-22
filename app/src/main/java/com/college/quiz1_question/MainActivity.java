package com.college.quiz1_question;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int mCounter;
    Button pay, clear;
    int mTotal;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This EditText contains the user input
        // for the number of burgers
        EditText numberStr = findViewById(R.id.numberId);

        // This textview displays the result of multiplying
        // the content of the numberId EditText by 5
        TextView resultTv = findViewById(R.id.resultId);
        Button pay = findViewById(R.id.btnPayId);
        Button clear = findViewById(R.id.btnResetId);

        // TODO
        // Implement the 2 listeners for buttons 'clear' and 'pay'
        // One burger is $5
        // Result should contain 5 multiplied by number chosen
        // Display should be prefixed with the '$' sign such as $15
        // Reset should clear all the fields
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //edittext string to int
                int count = Integer.parseInt(numberStr.getText().toString());
                mTotal = count * 5;
                //int to string
                resultTv.setText(String.valueOf("$" + mTotal));
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberStr.setText(null);
                resultTv.setText(String.valueOf(0));
            }
        });

    }
}