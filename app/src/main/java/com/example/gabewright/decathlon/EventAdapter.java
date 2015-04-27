package com.example.gabewright.decathlon;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by GabeWright on 4/21/15.
 */
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    List<Event> events;

    public EventAdapter(List<Event> events) {this.events = events;}

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view, new ViewHolder.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(parent.getContext(), EventDetails.class);
                String name = events.get(position).getName();
                String picint = Integer.toString(events.get(position).getPicint());
                String tip1 = events.get(position).getTip1();
                String tip2 = events.get(position).getTip2();
                String tip3 = events.get(position).getTip3();
                String tip4 = events.get(position).getTip4();
                String tip5 = events.get(position).getTip5();

                intent.putExtra("name", name);
                intent.putExtra("picint", picint);
                intent.putExtra("tip1", tip1);
                intent.putExtra("tip2", tip2);
                intent.putExtra("tip3", tip3);
                intent.putExtra("tip4", tip4);
                intent.putExtra("tip5", tip5);

                parent.getContext().startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tvName.setText(events.get(i).getName());
        viewHolder.ivPic.setImageDrawable(events.get(i).getPic());
    }

    public int getItemCount(){
        return events.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {



        ItemClickListener listener;
        TextView tvName;
        ImageView ivPic;

        public ViewHolder(View itemView, ItemClickListener listener){
            super(itemView);
            this.listener = listener;

            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            ivPic = (ImageView) itemView.findViewById(R.id.iv_pic);
            tvName.setOnClickListener(this);
            ivPic.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(v, getPosition());
        }

        public interface ItemClickListener{
            void onItemClick(View view, int position);
        }
    }


}

