package com.example.gabewright.decathlon;

import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class EventDetails extends ActionBarActivity {

    TextView name;
    TextView tip1;
    TextView tip2;
    TextView tip3;
    TextView tip4;
    TextView tip5;

    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        //maps views
        name = (TextView) findViewById(R.id.eventName);
        tip1 = (TextView) findViewById(R.id.tip1);
        tip2 = (TextView) findViewById(R.id.tip2);
        tip3 = (TextView) findViewById(R.id.tip3);
        tip4 = (TextView) findViewById(R.id.tip4);
        tip5 = (TextView) findViewById(R.id.tip5);
        pic = (ImageView) findViewById(R.id.eventpic);

        Resources res = getResources();

        //sets text
        name.setText(getIntent().getStringExtra("name"));
        tip1.setText(getIntent().getStringExtra("tip1"));
        tip2.setText(getIntent().getStringExtra("tip2"));
        tip3.setText(getIntent().getStringExtra("tip3"));
        tip4.setText(getIntent().getStringExtra("tip4"));
        tip5.setText(getIntent().getStringExtra("tip5"));

        //sets image
        int picint = Integer.parseInt(getIntent().getStringExtra("picint"));
        pic.setImageDrawable(res.getDrawable(picint));

    }


}
