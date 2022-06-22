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

        //restaurePrefs(mShowCountTextView);
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
        mCount = mCount + 1;
        mShowCountTextView.setText("" + mCount);
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
        int mmColor = ContextCompat.getColor(MainActivity.this, R.color.default_background);
        mCount = 0;
        mShowCountTextView.setText("0");
        mShowCountTextView.setBackgroundColor(mmColor);

        //clear the sharedPreferences
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.clear();
        editor.apply();
    }

    //TODO 3

    /**
     * Handles the onClick for the 'Save Prefs' button.
     * Saves the Color and Counter to shared preferences
     *
     * @param view The view (Button) that was clicked.
     */
    public void savePrefs(View view) {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(COUNT_KEY, mShowCountTextView.getText().toString());
        editor.putInt(COLOR_KEY, mColor);
        editor.apply();
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
        String count = mPreferences.getString(COUNT_KEY, "");
        int color = mPreferences.getInt(COLOR_KEY, 0);
        mShowCountTextView.setText("" + count);
        mShowCountTextView.setBackgroundColor(color);
    }
}