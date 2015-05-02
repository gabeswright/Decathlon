package com.example.gabewright.decathlon;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class CalculatorResult extends ActionBarActivity {

    TextView scoreis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_result);

        scoreis = (TextView) findViewById(R.id.tvscore);
        scoreis.setText(getIntent().getStringExtra("score"));
    }
}
