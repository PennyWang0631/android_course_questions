package com.college.quiz1_question;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //设置计数器显示的数字
    int mCounter;
    //button创建变量去调用setOnclick function
    Button reset, increment, decrement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //将variable与layout关联上
        //counterView is the TextView that displays the value of the counter
        TextView counterView = findViewById(R.id.counterId);
        Button reset = findViewById(R.id.buttonResetId);
        Button increment = findViewById(R.id.buttonIncId);
        Button decrement = findViewById(R.id.buttonDecId);

        //TODO
        // Your code goes here


        //每点一次加5
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter += 5;
                //将数字换成string
                counterView.setText(String.valueOf(mCounter));
            }
        });

        //每点击一次减1
        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCounter <= 0){
                    mCounter=0;
                }else {
                    mCounter--;
                }
                counterView.setText(String.valueOf(mCounter));
            }
        });

        //reset方法
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter = 0;
                counterView.setText(String.valueOf(mCounter));

            }
        });



    }
}