package com.example.jacob.eventfinder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

import Model.Event;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{
    private ArrayList<Event> data = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public Adapter(Context context, ArrayList<Event>data){
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_row,viewGroup,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.eventName.setText(data.get(position).getEventName());
        holder.location.setText(data.get(position).getLocation());
        Date date = data.get(position).getDate();
        String dateStr = String.format("%1$s %2$tB %2$td, %2$tY",date);
        holder.time.setText(dateStr);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView eventName;
        private TextView location;
        private TextView time;
        public MyViewHolder(View itemView){
            super(itemView);
            eventName = (TextView)itemView.findViewById(R.id.eventNameView);
            location = (TextView)itemView.findViewById(R.id.locationView);
            time = (TextView)itemView.findViewById(R.id.timeView);
        }
    }
}
