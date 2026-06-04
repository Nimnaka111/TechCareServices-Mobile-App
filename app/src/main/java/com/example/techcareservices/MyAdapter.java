package com.example.techcareservices;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<RepairRequest> list;

    public MyAdapter(Context context, ArrayList<RepairRequest> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_request, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RepairRequest request = list.get(position);
        holder.device.setText(request.getDevice());
        holder.issue.setText(request.getIssue());
        // FIX: Combines Date and Time into your tvDateTime field
        holder.tvDateTime.setText(request.getDate() + " at " + request.getTime());
        holder.status.setText("Status: " + request.getStatus());
    }

    @Override
    public int getItemCount() { return list.size(); }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView device, issue, tvDateTime, status;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            device = itemView.findViewById(R.id.tvDevice);
            issue = itemView.findViewById(R.id.tvIssue);
            tvDateTime = itemView.findViewById(R.id.tvDateTime);
            status = itemView.findViewById(R.id.tvStatus);
        }
    }
}