package com.awslab.portfolioapp.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.awslab.portfolioapp.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {

    List<ProjectItem> mdata;
    ProjectCallback listener;

    public ProjectAdapter(List<ProjectItem> mdata, ProjectCallback listener) {
        this.mdata = mdata;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_project, parent, false);

        return new ProjectViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {

        Glide.with(holder.itemView.getContext()).load(mdata.get(position).getImage()).into(holder.imgProj);


    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class ProjectViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProj;


        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProj = itemView.findViewById(R.id.item_project_img);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onProjectItemClick(getAdapterPosition());
                }
            });

        }
    }
}
