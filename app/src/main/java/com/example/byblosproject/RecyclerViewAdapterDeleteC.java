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

public class RecyclerViewAdapterDeleteC extends RecyclerView.Adapter<RecyclerViewAdapterDeleteC.ViewHolder>{

    private Context context;
    private ArrayList<Customer> customers = new ArrayList<>();

    public RecyclerViewAdapterDeleteC(Context context, ArrayList<Customer> customers){
        this.context = context;
        this.customers = customers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_user_for_admin, parent, false);
        RecyclerViewAdapterDeleteC.ViewHolder holder = new RecyclerViewAdapterDeleteC.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.delete.setText("Delete");
        int a = holder.getAdapterPosition();
        holder.name.setText(customers.get(a).getUserName());
        dbHandler db = new dbHandler(context);

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteCustomer(customers.get(a).getUserName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return customers.size();
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
