package com.awslab.portfolioapp.work;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.awslab.portfolioapp.R;

import java.util.List;

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.WorkViewHolder> {


    List<WorkItem> mdata;

    public WorkAdapter(List<WorkItem> mdata) {
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public WorkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_work, parent, false);

        return new WorkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkViewHolder holder, int position) {

        holder.tvCompanyAndDuration.setText(mdata.get(position).getCompanyAndDuration());
        holder.tvJobTitle.setText(mdata.get(position).getJobTitle());
        holder.tvDescription.setText(mdata.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class WorkViewHolder extends RecyclerView.ViewHolder {

        TextView tvCompanyAndDuration, tvJobTitle, tvDescription;

        public WorkViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCompanyAndDuration = itemView.findViewById(R.id.item_company_and_duration);
            tvJobTitle = itemView.findViewById(R.id.item_job_title);
            tvDescription = itemView.findViewById(R.id.item_work_desc);
        }
    }
}
