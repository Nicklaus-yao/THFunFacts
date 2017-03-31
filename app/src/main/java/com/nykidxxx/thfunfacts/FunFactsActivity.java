package com.nykidxxx.thfunfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FunFactsActivity extends AppCompatActivity {

    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOR = "KEY_COLOR";
    private RelativeLayout relativeLayoutFF;
    private TextView textViewFact;
    private Button buttonShowFact;

    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    public static final String TAG = FunFactsActivity.class.getSimpleName();
    private String mFact = mFactBook.mFacts[0];
    private int mColor = Color.parseColor(mColorWheel.mColors[8]);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        textViewFact = (TextView) findViewById(R.id.textViewFact);
        buttonShowFact = (Button) findViewById(R.id.buttonShowFact);
        relativeLayoutFF = (RelativeLayout) findViewById(R.id.relativeLayoutFF);

        View.OnClickListener listenToButtonSF = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFact = mFactBook.getFact();
                textViewFact.setText(mFact);

                mColor = mColorWheel.getColor();
                relativeLayoutFF.setBackgroundColor(mColor);
                buttonShowFact.setTextColor(mColor);

            }
        };
        buttonShowFact.setOnClickListener(listenToButtonSF);

        Log.d(TAG, "Log for FFA OnCreate method");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_FACT, mFact);
        outState.putInt(KEY_COLOR, mColor);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mFact = savedInstanceState.getString(KEY_FACT);
        mColor = savedInstanceState.getInt(KEY_COLOR);

        textViewFact.setText(mFact);
        relativeLayoutFF.setBackgroundColor(mColor);
        buttonShowFact.setTextColor(mColor);
    }
}












