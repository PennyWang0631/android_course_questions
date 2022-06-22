package com.college.quiz1_question;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG="MainActivity";
    // EditText view for the website URI
    private EditText mWebsiteEditText;
    // EditText view for the location URI
    private EditText mLocationEditText;
    // EditText view for the share text
    private EditText mShareTextEditText;
    //EditText for Dial action
    private EditText mDialEditText;
    Button openWeb, openLoc,share, dial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_editext);
        mShareTextEditText = findViewById(R.id.share_edittext);
        mDialEditText = findViewById(R.id.phone_edittext);


    }

    // TODO
    /**
     * Handles the onClick for the "Open Website" button.  Gets the URI
     * from the edit text and sends an implicit intent for that URL.
     *
     * @param view The view (Button) that was clicked.
     */
    public void openWebsite(View view) {
        Button openWeb = findViewById(R.id.open_website_button);
        openWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //把edittext变成string
                String url = mWebsiteEditText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

    }

    // TODO
    /**
     * Handles the onClick for the "Open Location" button.  Gets the location
     * text from the edit text and sends an implicit intent for that location.
     *
     * The location text can be any searchable geographic location.
     *
     * @param view The view (Button) that was clicked.
     */

    public void openLocation(View view) {
        Button openLoc = findViewById(R.id.open_location_button);
        openLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = mLocationEditText.getText().toString();
                Uri locationUri = Uri.parse("geo:0?q=" + location);
                Intent intent = new Intent(Intent.ACTION_VIEW,locationUri);
                startActivity(intent);
            }
        });

    }

    // TODO
    /**
     * Handles the onClick for the "Share This Text" button.  The
     * implicit intent here is created by the  {@link ShareCompat.IntentBuilder}
     * class.  An app chooser appears with the available options for sharing.
     *
     * ShareCompat.IntentBuilder is from the v4 Support Library.
     *
     * @param view The view (Button) that was clicked.
     */
    public void shareText(View view) {
        Button share = findViewById(R.id.share_text_button);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String context =  mShareTextEditText.getText().toString();
                String Type = "text/plain";
                ShareCompat.IntentBuilder.from(MainActivity.this)
                        .setType(Type)
                        .setText(context)
                        .setChooserTitle("Share this content with")
                        .startChooser();
            }
        });

    }



    // TODO
    /**
     * Handles the onClick for the "Dial" button.
     *
     * @param view The view (Button) that was clicked.
     */
    public void dial(View view) {
        Button dial = findViewById(R.id.dial_button);
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNo = mDialEditText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phoneNo));
                startActivity(intent);
            }
        });

    }

    // TODO
    /**
     * Handles the onClick for the "View Contacts" button.
     *
     * @param view The view (Button) that was clicked.
     */
    public void viewContact(View view) {

    }

}