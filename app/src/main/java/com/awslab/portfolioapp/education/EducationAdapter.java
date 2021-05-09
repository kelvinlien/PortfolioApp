package com.awslab.portfolioapp.education;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.awslab.portfolioapp.R;

import java.util.List;

public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.EducationViewHolder> {

    List<EducationItem> mdata;


    public EducationAdapter(List<EducationItem> mdata) {
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public EducationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_education, parent, false);

        return new EducationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EducationViewHolder holder, int position) {

        holder.tv_name.setText(mdata.get(position).getTitle());
        holder.tv_desc.setText(mdata.get(position).getDesc());
        holder.img.setImageResource(mdata.get(position).getImg());


    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class EducationViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name, tv_desc;
        ImageView img;

        public EducationViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.education_item_name);
            tv_desc = itemView.findViewById(R.id.education_item_desc);
            img = itemView.findViewById(R.id.education_item_img);
        }
    }
}
