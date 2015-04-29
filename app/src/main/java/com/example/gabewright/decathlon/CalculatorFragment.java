package com.example.gabewright.decathlon;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment {

    EditText one;
    EditText sp;
    EditText lj;
    EditText hj;
    EditText four;
    EditText hurdles;
    EditText discus;
    EditText pv;
    EditText jav;
    EditText fifteen;
    TextView submit;

    public CalculatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculator, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapViews(view);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                calculateScores();
            }
        });
    }

    private void calculateScores() {
        Intent intent = new Intent(getActivity(), CalculatorResult.class);
        double onetime = Double.parseDouble(one.getText().toString());
        double spd = Double.parseDouble(sp.getText().toString());
        double ljd = Double.parseDouble(lj.getText().toString());
        double hjh = Double.parseDouble(hj.getText().toString());
        double fourtime = Double.parseDouble(four.getText().toString());
        double hurdletime = Double.parseDouble(hurdles.getText().toString());
        double discd = Double.parseDouble(discus.getText().toString());
        double pvh = Double.parseDouble(pv.getText().toString());
        double javd = Double.parseDouble(jav.getText().toString());
        double fifteentime = Double.parseDouble(fifteen.getText().toString());

        int onescore;
        int fourscore;
        int fifteenscore;
        int hurdlescore;
        int spscore;
        int ljscore;
        int hjscore;
        int pvscore;
        int discusscore;
        int javscore;
        int totalscore;

        onescore = (int) Math.pow((25.437*(18-onetime)),1.81);
        fourscore = (int) Math.pow((1.53775*(82-fourtime)),1.81);
        fifteenscore = (int) Math.pow((.03768*(480-fifteentime)),1.85);
        hurdlescore = (int) Math.pow((5.74352*(28.5-hurdletime)),1.92);
        spscore = (int) Math.pow((51.39*(spd-1.5)),1.05);
        ljscore = (int) Math.pow((.14354*(ljd-2.2)),1.4);
        hjscore = (int) Math.pow((.8465*(hjh-.75)),1.42);
        pvscore = (int) Math.pow((.2797*(pvh-1)),1.35);
        discusscore = (int) Math.pow((12.91*(discd-4)),1.1);
        javscore = (int) Math.pow((10.14*(javd-7)),1.08);

        totalscore = onescore + fourscore + fifteenscore +hurdlescore + spscore + ljscore + hjscore + pvscore + discusscore + javscore;

        intent.putExtra("score", totalscore);
        startActivity(intent);



    }

    private void mapViews(View view) {
        one = (EditText) view.findViewById(R.id.et100);
        sp = (EditText) view.findViewById(R.id.etsp);
        lj = (EditText) view.findViewById(R.id.etlj);
        hj = (EditText) view.findViewById(R.id.ethj);
        four = (EditText) view.findViewById(R.id.et400);
        hurdles = (EditText) view.findViewById(R.id.et110h);
        discus = (EditText) view.findViewById(R.id.etdiscus);
        pv = (EditText) view.findViewById(R.id.etpv);
        jav = (EditText) view.findViewById(R.id.etjav);
        fifteen = (EditText) view.findViewById(R.id.et1500);
        submit = (TextView) view.findViewById(R.id.tvsubmit);
    }
}
