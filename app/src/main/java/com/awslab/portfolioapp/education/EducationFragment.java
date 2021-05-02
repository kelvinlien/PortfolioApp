package com.awslab.portfolioapp.education;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.awslab.portfolioapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EducationFragment extends Fragment {


    RecyclerView RvEducation;
    EducationAdapter adapter;
    List<EducationItem> mdata;

    public EducationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_education, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RvEducation = view.findViewById(R.id.rv_education);

        // create list of Education items

        EducationItem item = new EducationItem(getString(R.string.gpa_title),getString(R.string.gpa_description),R.drawable.gpa);
        EducationItem item2 = new EducationItem(getString(R.string.highest_ranking_title),getString(R.string.highest_ranking_description),R.drawable.ranking);
        EducationItem item3 = new EducationItem(getString(R.string.thesis_title),getString(R.string.thesis_description),R.drawable.thesis);
        EducationItem item4 = new EducationItem(getString(R.string.leadership_and_experiment_title),getString(R.string.leadership_and_experiment_description),R.drawable.leadership);
        EducationItem item5 = new EducationItem(getString(R.string.additional_activities_title),getString(R.string.additional_activities_description),R.drawable.activities);
        mdata = new ArrayList<>();
        mdata.add(item);
        mdata.add(item2);
        mdata.add(item3);
        mdata.add(item4);
        mdata.add(item5);

        // setup adapter and recyclerview

        RvEducation.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new EducationAdapter(mdata);
        RvEducation.setAdapter(adapter);


    }
}
