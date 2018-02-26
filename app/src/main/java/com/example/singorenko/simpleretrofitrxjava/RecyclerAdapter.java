package com.example.singorenko.simpleretrofitrxjava;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.singorenko.simpleretrofitrxjava.data.model.List;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by baeza on 23/2/18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    java.util.List<List> list;

    public RecyclerAdapter(java.util.List<List> list) {
        this.list = list;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layout = R.layout.item_rv;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layout, parent,false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String date = formatter.format(new Date(list.get(position).getDt().longValue()*1000));

        holder.tv_date.setText(date);
        holder.tv_minTemp.setText(list.get(position).getTemp().getMin().toString());
        holder.tv_maxTemp.setText(list.get(position).getTemp().getMax().toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView tv_date, tv_minTemp, tv_maxTemp;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_minTemp = itemView.findViewById(R.id.tv_minTemp);
            tv_maxTemp = itemView.findViewById(R.id.tv_maxTemp);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
