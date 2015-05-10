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
        //constructor for pager
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
        //sets up recycler view
        super.onViewCreated(view, savedInstanceState);
        recyclerEvents = (RecyclerView) view.findViewById(R.id.recycler_events);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerEvents.setLayoutManager(layoutManager);
        List<Event> events = tenEvents();
        recyclerEvents.setAdapter(new EventAdapter(events));
    }

    private List<Event> tenEvents() {

        //creates a list of the info for the 10 events
        int difoot = R.drawable.trackfoot;
        Resources res = getResources();
        Drawable trackfoot = res.getDrawable(R.drawable.trackfoot);

        List<Event> events = new ArrayList<>();
        events.add(new Event("100 Meter Dash", trackfoot, difoot,"1: The first event of the decathlon","2: Athletes are allowed one false start, they are disqualified on the second","3: Staying low on the start allows for faster acceleration","4: Every tenth of a second is approx. 20 points ","5: Run the race as if it were 103 meters - don't break stride at the finish line"));
        events.add(new Event("Long Jump", trackfoot, difoot,"1: The decathlon's second event","2: Athletes are given three attempts to jump as far as you can","3: If any part of the athlete's foot is over the board, it's a scratch","4: The jump is measured from the furthest back mark in the sand","5: Athletes must exit the pit beyond said furthest back mark"));
        events.add(new Event("Shot Put", trackfoot, difoot,"1: The decathlon's third event","2: Athletes are given three throws","3: Athletes must exit out of the back of the ring","4: Athletes must exit the ring under control","5: A shot put weighs 16 pounds"));
        events.add(new Event("High Jump", trackfoot, difoot,"1: The fourth event of the decathlon","2: Athletes are allowed three consecutive misses","3: If anything (other than wind or an issue with the standards) knocks the bar down, it counts as a scratch","4: Athletes can pass any height they choose","5: Each height is 3cm (just over 1 in) higher than the last "));
        events.add(new Event("400 Meter Dash", trackfoot, difoot,"1: The fifth event of the decathlon","2: Like in the 100 Meter Dash, athletes are allowed one false start before being disqualified","3: Staying low on the start allows for faster acceleration","4: Unless athletes are in great shape, slight pacing during the first 200 meters is key","5: The 400 Meter Dash is the last event of day one of the decathlon"));
        events.add(new Event("110 Hurdles", trackfoot, difoot,"1: The sixth event of the decathlon (and the first event of day two)","2: As in the 100 and 400, athletes are allowed 1 false start before being disqualified","3: Athletes are disqualified if they touch the hurdle with their hand","4: Athletes must make an attempt to clear the hurdle, or else they are disqualified","5: There are 10 hurdles that must be cleared during the race"));
        events.add(new Event("Discus", trackfoot, difoot,"1: The seventh event of the decathlon (the second event of day two)","2: Most athletes throw the discus using a technique called the spin","3: Athletes must exit out of the back of the ring","4: Athletes must exit the ring under control","5: Each meter is worth about 20 points"));
        events.add(new Event("Pole Vault", trackfoot, difoot,"1: The eighth event of the decathlon (the third event of day two)","2: Athletes are allowed three consecutive misses","3: Athletes can choose how far forwards/backwards on the pit the bar is set","4: If anything (other than wind or an issue with the standards) knocks the bar down, it counts as a scratch","5: Each consecutive height is 10cm (about 4in) higher than the last height"));
        events.add(new Event("Javelin", trackfoot, difoot,"1: The ninth event of the decathlon (the fourth event of day two)","2: Athletes are allowed three throws","3: Athletes must exit the runway under control behind the toe-board","4: The javelin must land tip first (it does not have to stick in the ground)","5: Each meter in the javelin is worth about 15 points"));
        events.add(new Event("1500 Meter Run", trackfoot, difoot,"1: The tenth and final event of the decathlon (the fifth event of day two)","2: Pacing is very important in the 1500 meter dash - do not expend all of your energy at the beginning of the race","3: Draft off of other athletes on windy days","4: Each second in the 1500 Meter Run is worth about 7 points","5: Mindset is key during distance races, if you're thinking 'I feel good' then you will feel and run better than if your thinking 'this sucks'"));

        return events;

    }


}
