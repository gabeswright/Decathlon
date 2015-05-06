package com.example.gabewright.decathlon;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.realm.Realm;


/**
 * A simple {@link Fragment} subclass.
 */
public class SavedResults extends Fragment {

    private String title;
    private int page;
    private Realm realm;

    TextView lastScore;
    TextView lastDate;
    TextView twoScore;
    TextView twoDate;
    TextView threeScore;
    TextView threeDate;
    TextView fourScore;
    TextView fourDate;
    TextView fiveScore;
    TextView fiveDate;



    // newInstance constructor for creating fragment with arguments
    public static SavedResults newInstance(int page, String title) {
        SavedResults results = new SavedResults();
        Bundle args = new Bundle();
        args.putInt("Int", page);
        args.putString("Title", title);
        results.setArguments(args);
        return results;
    }


    public SavedResults() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saved_results, container, false);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        
    }
}
