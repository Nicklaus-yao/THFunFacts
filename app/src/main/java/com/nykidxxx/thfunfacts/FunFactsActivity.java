package com.nykidxxx.thfunfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FunFactsActivity extends AppCompatActivity {

    private RelativeLayout relativeLayoutFF;
    private TextView textViewFact;
    private Button buttonShowFact;

    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    public static final String TAG = FunFactsActivity.class.getSimpleName();

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
                String fact = mFactBook.getFact();
                textViewFact.setText(fact);

                int color = mColorWheel.getColor();
                relativeLayoutFF.setBackgroundColor(color);
                buttonShowFact.setTextColor(color);

            }
        };
        buttonShowFact.setOnClickListener(listenToButtonSF);

        Log.d(TAG, "Log for FFA OnCreate method");
    }
}
