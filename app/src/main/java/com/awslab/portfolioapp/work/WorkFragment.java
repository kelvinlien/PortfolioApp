package com.awslab.portfolioapp.work;


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
public class WorkFragment extends Fragment {

    RecyclerView RvWork;
    WorkAdapter adapter ;
    List<WorkItem> items;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RvWork = view.findViewById(R.id.recyclerview_work);

        // create a list of Work items
        items = new ArrayList<>();
        items.add(new WorkItem("An Awesome Company | Present",getString(R.string.job_name),getString(R.string.lorem_text)));
        items.add(new WorkItem("Real-Time Analytics (RTA)  | Sep 2019 - Feb 2020","Front-end Web Software Developer intern",getString(R.string.lorem_text2)));

        adapter = new WorkAdapter(items);

        RvWork.setLayoutManager(new LinearLayoutManager(getContext()));
        RvWork.setAdapter(adapter);



    }

    public WorkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_work, container, false);
    }

}
