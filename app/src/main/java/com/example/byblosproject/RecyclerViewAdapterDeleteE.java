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

import java.util.ArrayList;

public class RecyclerViewAdapterDeleteE extends RecyclerView.Adapter<RecyclerViewAdapterDeleteE.ViewHolder> {

    private Context context;
    private ArrayList<BranchEmployee> employees = new ArrayList<>();

    public RecyclerViewAdapterDeleteE(Context context, ArrayList<BranchEmployee> employees){
        this.context = context;
        this.employees = employees;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_user_for_admin, parent, false);
        RecyclerViewAdapterDeleteE.ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.delete.setText("Delete");
        int a = holder.getAdapterPosition();
        holder.name.setText(employees.get(a).getUserName());
        dbHandler db = new dbHandler(context);

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteEmployee(employees.get(a).getUserName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        Button delete;
        ConstraintLayout parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView12);
            delete = itemView.findViewById(R.id.button5);
        }
    }
}
