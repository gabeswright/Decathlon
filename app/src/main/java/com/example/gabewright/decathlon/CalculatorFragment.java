package com.example.gabewright.decathlon;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
    public RealmResults<RealmScore> realmResults;

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
    TextView viewSaved;
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

        viewSaved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewSaved();
            }
        });
    }

    private void saveScores(){

        //this chunk of code checks if the edit text was left black, then converts the edit text into a double
        double onetime = 0;
        if(one.getText().toString().matches("")){onetime = 0;}
        else{onetime = Double.parseDouble(one.getText().toString());}

        double spd = 0;
        if(sp.getText().toString().matches("")){spd=0;}
        else{spd = Double.parseDouble(sp.getText().toString());}

        double ljd = 0;
        if(lj.getText().toString().matches("")){ljd=0;}
        else{ljd = Double.parseDouble(lj.getText().toString());}

        double hjh = 0;
        if(hj.getText().toString().matches("")){hjh=0;}
        else{hjh = Double.parseDouble(hj.getText().toString());}

        double fourtime = 0;
        if(four.getText().toString().matches("")){fourtime=0;}
        else{fourtime = Double.parseDouble(four.getText().toString());}

        double hurdletime = 0;
        if(hurdles.getText().toString().matches("")){hurdletime=0;}
        else{hurdletime = Double.parseDouble(hurdles.getText().toString());}

        double discd = 0;
        if(discus.getText().toString().matches("")){discd=0;}
        else{discd = Double.parseDouble(discus.getText().toString());}

        double pvh = 0;
        if(pv.getText().toString().matches("")){pvh=0;}
        else{pvh = Double.parseDouble(pv.getText().toString());}

        double javd = 0;
        if(jav.getText().toString().matches("")){javd=0;}
        else{javd = Double.parseDouble(jav.getText().toString());}

        double fifteentime = 0;
        if(fifteen.getText().toString().matches("")){fifteentime=0;}
        else{fifteentime = Double.parseDouble(fifteen.getText().toString());}

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

        //calculates the scores and converts them to ints
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

        //saves the total score and string to realm
        realm = Realm.getInstance(getActivity());
        realm.beginTransaction();

        RealmScore realmScore = realm.createObject(RealmScore.class);
        realmScore.setScore(score);
        realmScore.setDate(dates);
        realm.commitTransaction();
        realmResults = realm.where(RealmScore.class).findAll();

        //formats a nice string to be passed into the next activity

        String pastScores = "";
        for(int i=0;i<realmResults.size();i++){
            pastScores = pastScores + realmResults.get(i).getScore() + " on " + realmResults.get(i).getDate() + "\n";
        }

        Intent intent = new Intent(getActivity(), ResultsActivity.class);
        intent.putExtra("Results", pastScores);
        startActivity(intent);
    }


    private void calculateScores() {
        Intent intent = new Intent(getActivity(), CalculatorResult.class);

        //this chunk of code checks if the edit text was left black, then converts the edit text into a double
        double onetime = 0;
        if(one.getText().toString().matches("")){onetime = 0;}
        else{onetime = Double.parseDouble(one.getText().toString());}

        double spd = 0;
        if(sp.getText().toString().matches("")){spd=0;}
        else{spd = Double.parseDouble(sp.getText().toString());}

        double ljd = 0;
        if(lj.getText().toString().matches("")){ljd=0;}
        else{ljd = Double.parseDouble(lj.getText().toString());}

        double hjh = 0;
        if(hj.getText().toString().matches("")){hjh=0;}
        else{hjh = Double.parseDouble(hj.getText().toString());}

        double fourtime = 0;
        if(four.getText().toString().matches("")){fourtime=0;}
        else{fourtime = Double.parseDouble(four.getText().toString());}

        double hurdletime = 0;
        if(hurdles.getText().toString().matches("")){hurdletime=0;}
        else{hurdletime = Double.parseDouble(hurdles.getText().toString());}

        double discd = 0;
        if(discus.getText().toString().matches("")){discd=0;}
        else{discd = Double.parseDouble(discus.getText().toString());}

        double pvh = 0;
        if(pv.getText().toString().matches("")){pvh=0;}
        else{pvh = Double.parseDouble(pv.getText().toString());}

        double javd = 0;
        if(jav.getText().toString().matches("")){javd=0;}
        else{javd = Double.parseDouble(jav.getText().toString());}

        double fifteentime = 0;
        if(fifteen.getText().toString().matches("")){fifteentime=0;}
        else{fifteentime = Double.parseDouble(fifteen.getText().toString());}

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

        //this code calculates the scores and converts the points to an int value
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

        //calculates total score and passes it to the next activity

        totalscore = onescore + fourscore + fifteenscore +hurdlescore + spscore + ljscore + hjscore + pvscore + discusscore + javscore;
        String score = Integer.toString(totalscore);
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
        viewSaved = (TextView) view.findViewById(R.id.tvviewsaved);
        viewSaved.setText("View Saved");
    }

    private void viewSaved(){
        //allows user to view previously saved data
        realm = Realm.getInstance(getActivity());
        realmResults = realm.where(RealmScore.class).findAll();

        String pastScores = "";
        for(int i=0;i<realmResults.size();i++){
            pastScores = pastScores + realmResults.get(i).getScore() + " on " + realmResults.get(i).getDate() + "\n";
        }

        Intent intent = new Intent(getActivity(), ResultsActivity.class);
        intent.putExtra("Results", pastScores);
        startActivity(intent);

    }
}
