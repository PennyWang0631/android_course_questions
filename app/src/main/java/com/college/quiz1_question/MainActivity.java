package com.college.quiz1_question;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.graphics.drawable.ColorDrawable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Current count.
    private int mCount = 0;
    // Current background color.
    private int mColor;
    // Text view to display both count and color.
    private TextView mShowCountTextView;

    // Key for current count当前计数键
    private final String COUNT_KEY = "count";
    // Key for current color当前颜色（为了存储）
    private final String COLOR_KEY = "color";

    // Shared preferences object
    private SharedPreferences mPreferences;
    // Name of shared preferences file
    private static final String mSharedPrefFile = "mysharedprefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views, color, preferences
        mShowCountTextView = findViewById(R.id.count_textview);
        mColor = ContextCompat.getColor(this, R.color.default_background);
        //写入数据：步骤1：创建一个Sharedpreferences对象，
        //获取Sharedpreferences的方法
        mPreferences = getSharedPreferences(mSharedPrefFile, MODE_PRIVATE);

        restaurePrefs(mShowCountTextView);
    }

    /**
     * Handles the onClick for the background color buttons.
     * Gets background color of the button
     * that was clicked and sets the textview background to that color.
     * Saves the current background
     *
     * @param view The view (Button) that was clicked.
     */
    public void changeBackground(View view) {
        int color = ((ColorDrawable) view.getBackground()).getColor();
        mShowCountTextView.setBackgroundColor(color);
        mColor = color;
    }

    //TODO 1
    /**
     * Handles the onClick for the Count button.  Increments the value of the mCount global and
     * updates the textview.
     *
     * @param view The view (Button) that was clicked.
     */
    public void countUp(View view) {
        Button count = findViewById(R.id.count_button);
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                mShowCountTextView.setText(String.valueOf(mCount));

            }
        });


    }

    //TODO 2
    /**
     * Handles the onClick for the Reset button.
     * Resets the global count and background
     * variables to the defaults, resets the views to those values,
     * and clears the shared preferences
     *
     * @param view The view (Button) that was clicked.
     */
    public void reset(View view) {
        Button reset = findViewById(R.id.reset_button);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount =0;
                mShowCountTextView.setText(String.valueOf(mCount));
                mColor = ContextCompat.getColor(MainActivity.this,R.color.default_background);
                mShowCountTextView.setBackgroundColor(mColor);

                //clear perferencew
                SharedPreferences.Editor preferencesEditor = mPreferences.edit();
                preferencesEditor.clear();
                preferencesEditor.apply();
            }
        });

    }


    //TODO 3
    /**
     * Handles the onClick for the 'Save Prefs' button.
     * Saves the Color and Counter to shared preferences
     *
     * @param view The view (Button) that was clicked.
     */


    public void savePrefs(View view) {
        Button savePref = findViewById(R.id.save_button);
        savePref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //步骤2：实例化sharedpreference.editor对象，为了写入数据
                SharedPreferences.Editor preferencesEditor = mPreferences.edit();
                //步骤3：将获取过来的值放入文件
                preferencesEditor.putInt(COUNT_KEY,mCount);
                preferencesEditor.putInt(COUNT_KEY,mColor);
                //提交
                preferencesEditor.commit();
            }
        });

    }

    //TODO 4
    /**
     * Handles the onClick for the 'Restaure Prefs' button.
     * Reads the Color and Counter from the Preferences
     * Updates the color and counter textviews.
     *
     * @param view The view (Button) that was clicked.
     */
    public void restaurePrefs(View view) {
        Button restaure = findViewById(R.id.start_activity_button);
        restaure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount= mPreferences.getInt("COUNT_KEY",mCount);
                mShowCountTextView.setText(String.valueOf(mCount));
                mColor=mPreferences.getInt("COUNT_KEY",mColor);
                mShowCountTextView.setBackgroundColor(mColor);

            }
        });
    }

}
