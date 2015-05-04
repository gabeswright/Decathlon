package com.example.gabewright.decathlon;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragmentEvents extends Fragment {

    private RecyclerView recyclerEvents;

    private String title;
    private int page;

    public static RecyclerViewFragmentEvents newInstance(int page, String title) {
        RecyclerViewFragmentEvents eventsFrag = new RecyclerViewFragmentEvents();
        Bundle args = new Bundle();
        args.putInt("An Int", page);
        args.putString("A String", title);
        eventsFrag.setArguments(args);
        return eventsFrag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("1", 0);
        title = getArguments().getString("Events");
    }

    public RecyclerViewFragmentEvents() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler_view_fragment_events, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerEvents = (RecyclerView) view.findViewById(R.id.recycler_events);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerEvents.setLayoutManager(layoutManager);
        List<Event> events = tenEvents();
        recyclerEvents.setAdapter(new EventAdapter(events));
    }

    private List<Event> tenEvents() {

        int difoot = R.drawable.trackfoot;
        Resources res = getResources();
        Drawable trackfoot = res.getDrawable(R.drawable.trackfoot);

        List<Event> events = new ArrayList<>();
        events.add(new Event("100 Meter Dash", trackfoot, difoot,"1: The first event of the decathlon","2: You are allowed 1 false start, you are disqualified on the second","3: Staying low on your start allows for faster acceleration","4: Every tenth of a second is apporox. 20 points ","5: Run the race as if it were 103 meters - don't break stride at the finish line"));
        events.add(new Event("Long Jump", trackfoot, difoot,"","","","",""));
        events.add(new Event("Shot Put", trackfoot, difoot,"","","","",""));
        events.add(new Event("High Jump", trackfoot, difoot,"","","","",""));
        events.add(new Event("400 Meter Dash", trackfoot, difoot,"","","","",""));
        events.add(new Event("110 Hurdles", trackfoot, difoot,"","","","",""));
        events.add(new Event("Discus", trackfoot, difoot,"","","","",""));
        events.add(new Event("Pole Vault", trackfoot, difoot,"","","","",""));
        events.add(new Event("Javelin", trackfoot, difoot,"","","","",""));
        events.add(new Event("1500 Meter Run", trackfoot, difoot,"","","","",""));

        return events;

    }


}
