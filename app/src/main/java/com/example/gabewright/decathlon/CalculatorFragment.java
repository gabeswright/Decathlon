package com.example.gabewright.decathlon;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment {

    private String title;
    private int page;

    public static CalculatorFragment newInstance(int page, String title) {
        CalculatorFragment calcFrag = new CalculatorFragment();
        Bundle args = new Bundle();
        args.putInt("Int", page);
        args.putString("Title", title);
        calcFrag.setArguments(args);
        return calcFrag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("String", 0);
        title = getArguments().getString("Calculator");
    }

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
    EditText date;
    TextView save;
    TextView submit;
    private Realm realm;


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

        realm = realm.getInstance(getActivity());

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                calculateScores();
            }
        });

        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                saveScores();

            }
        });
    }

    private void saveScores(){

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
        String dates = date.getText().toString();

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

        String yourscore = Integer.toString(totalscore);

        realm.beginTransaction();

        RealmScore score = realm.createObject(RealmScore.class);
        score.setScore(yourscore);
        score.setDate(dates);
        realm.commitTransaction();

    }

    private void calculateScores() {
        Intent intent = new Intent(getActivity(), CalculatorResult.class);

        double onetime = 0;
        onetime = Double.parseDouble(one.getText().toString());
        double spd = 0;
        spd = Double.parseDouble(sp.getText().toString());
        double ljd = 0;
        ljd = Double.parseDouble(lj.getText().toString());
        double hjh = 0;
        hjh = Double.parseDouble(hj.getText().toString());
        double fourtime = 0;
        fourtime = Double.parseDouble(four.getText().toString());
        double hurdletime = 0;
        hurdletime = Double.parseDouble(hurdles.getText().toString());
        double discd = 0;
        discd = Double.parseDouble(discus.getText().toString());
        double pvh = 0;
        pvh = Double.parseDouble(pv.getText().toString());
        double javd = 0;
        javd = Double.parseDouble(jav.getText().toString());
        double fifteentime = 0;
        fifteentime = Double.parseDouble(fifteen.getText().toString());

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

        if (onetime==0){onescore=0;}
        else{onescore = (int) (25.437*Math.pow((18-onetime),1.81));}

        if (fourtime==0){fourscore=0;}
        else{fourscore = (int) (1.53775*Math.pow((82-fourtime),1.81));}

        if (fifteentime==0){fifteenscore=0;}
        else{fifteenscore = (int) (.03768*Math.pow((480-fifteentime),1.85));}

        if (hurdletime==0){hurdlescore=0;}
        else {hurdlescore = (int) (5.74352*Math.pow((28.5-hurdletime),1.92));}

        if (spd==0){spscore=0;}
        else{spscore = (int) (51.39*(Math.pow((spd-1.5),1.05)));}

        ljd = ljd*100;
        if(ljd==0){ljscore=0;}
        else {ljscore = (int) (.14354*Math.pow((ljd-220),1.4));}

        hjh=hjh*100;
        if (hjh==0){hjscore=0;}
        else{hjscore = (int) (.8465*Math.pow(hjh-75,1.42));}

        pvh=pvh*100;
        if (pvh==0){pvscore=0;}
        else{pvscore = (int) (.2797*Math.pow((pvh-100),1.35));}

        if (discd==0){discusscore=0;}
        else{discusscore = (int) (12.91*Math.pow((discd-4),1.1));}

        if (javd==0){javscore=0;}
        else{javscore = (int) (10.14*Math.pow((javd-7),1.08));}

        totalscore = onescore + fourscore + fifteenscore +hurdlescore + spscore + ljscore + hjscore + pvscore + discusscore + javscore;
        String score = Integer.toString(totalscore);
        //String score = onescore +"," + fourscore +"," + fifteenscore +"," +hurdlescore+"," + spscore+"," + ljscore+"," + hjscore+"," + pvscore+"," + discusscore+"," + javscore;
        intent.putExtra("score", score);
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
        submit.setText("Submit");
        date = (EditText) view.findViewById(R.id.etdate);
        save = (TextView) view.findViewById(R.id.tvsave);
        save.setText("Save");
    }
}
