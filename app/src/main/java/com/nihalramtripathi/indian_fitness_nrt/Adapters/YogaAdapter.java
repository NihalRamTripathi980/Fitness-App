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
import com.nihalramtripathi.indian_fitness_nrt.Models.YogaModel;
import com.nihalramtripathi.indian_fitness_nrt.R;

import java.util.ArrayList;
import java.util.BitSet;

public class YogaAdapter  extends RecyclerView.Adapter<YogaAdapter.viewHolder> {
  // Second Activity

ArrayList<YogaModel> list;
Context context;

    private BitSet IOUtils;

    public YogaAdapter(ArrayList<YogaModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public viewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_yoga_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YogaAdapter.viewHolder holder, int position) {

        YogaModel model = list.get(position);

holder.imageView.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition));
holder.textView.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition));

        holder.imageView.setImageResource(model.getImage());
        holder.textView.setText(model.getTextView());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, FouthActivity.class);
                intent.putExtra("yogaImage",model.getImage());
                intent.putExtra("yogaName",model.getTextView());
                intent.putExtra("type","first");
                context.startActivity(intent);
            }
        });


    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class viewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.menImageView);

            textView=itemView.findViewById(R.id.menTextView);
        }
    }
}
