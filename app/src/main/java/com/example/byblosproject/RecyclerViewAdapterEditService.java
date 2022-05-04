package com.example.byblosproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapterEditService extends RecyclerView.Adapter<RecyclerViewAdapterEditService.ViewHolder>{
    private Context context;
    private String[] attributeStrings;
    private static int[] attributes = new int[17];

    public RecyclerViewAdapterEditService(Context context, String[] attributeStrings){
        this.context = context;
        this.attributeStrings = attributeStrings;
    }

    public static int[] getAttributesEdit() {
        return attributes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_service_attribute, parent, false);
        RecyclerViewAdapterEditService.ViewHolder holder = new RecyclerViewAdapterEditService.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(attributeStrings[position]);
        int a = holder.getAdapterPosition();

        holder.show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attributes[a] = 1;
            }
        });

        holder.hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attributes[a] = 0;
            }
        });
    }

    @Override
    public int getItemCount() {
        return attributeStrings.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        Button show, hide;
        ConstraintLayout parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView11);
            show = itemView.findViewById(R.id.button10);
            hide = itemView.findViewById(R.id.button11);
        }
    }
}
