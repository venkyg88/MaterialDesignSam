package com.example.venkatgonuguntala.materialdesignsam;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by venkatgonuguntala on 2/13/15.
 */
public class VenksAdapter extends RecyclerView.Adapter<VenksAdapter.MyViewHolder>{

    private LayoutInflater inflater;
    List<Information> data= Collections.emptyList();

    public VenksAdapter(Context context, List<Information> data){
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_row, parent,false);
        Log.d("VENKS","onCreateViewHolder called");
        MyViewHolder holder=new MyViewHolder(view);
        return holder ;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Information current=data.get(position);
        Log.d("VENKS","onBindViewHolder called"+position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.imageId);
    }

    @Override
    public int getItemCount()  {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
         TextView title;
         ImageView icon;
        Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.textview);
            icon= (ImageView) itemView.findViewById(R.id.ListIcon);
            icon.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context,"Item clicked at"+getPosition(),Toast.LENGTH_SHORT).show();
        }
    }
}
