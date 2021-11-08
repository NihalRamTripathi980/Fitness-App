package com.nihalramtripathi.indian_fitness_nrt.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nihalramtripathi.indian_fitness_nrt.FouthActivity;
import com.nihalramtripathi.indian_fitness_nrt.Models.MenModel;
import com.nihalramtripathi.indian_fitness_nrt.R;

import java.util.ArrayList;

public class MenAdapter extends RecyclerView.Adapter<MenAdapter.viewHolder> {
ArrayList<MenModel> list ;
Context context;

    public MenAdapter(ArrayList<MenModel> list, Context context) {
        this.list = list;
        this.context = context;
    }



    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_yoga_men,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder( @NonNull MenAdapter.viewHolder holder, int position) {
        MenModel model=list.get(position);

        holder.menImage.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition));
        holder.menText.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition));
        holder.menImage.setImageResource(model.getImage());
        holder.menText.setText(model.getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, FouthActivity.class);
                intent.putExtra("menImage",model.getImage());
                intent.putExtra("menName",model.getName());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
ImageView menImage;
TextView menText;
        public viewHolder( View itemView) {
            super(itemView);

            menImage=itemView.findViewById(R.id.menImageView);
            menText=itemView.findViewById(R.id.menTextView);

            
        }
    }
}
