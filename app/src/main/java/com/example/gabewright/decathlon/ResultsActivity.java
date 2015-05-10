package com.example.gabewright.decathlon;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ResultsActivity extends ActionBarActivity {

    TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //shows the saved results
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        results = (TextView) findViewById(R.id.results);
        results.setText(getIntent().getStringExtra("Results"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_results, menu);
        return true;
    }

}
