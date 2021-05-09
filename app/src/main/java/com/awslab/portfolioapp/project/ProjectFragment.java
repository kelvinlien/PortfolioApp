package com.awslab.portfolioapp.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.awslab.portfolioapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectFragment extends Fragment implements ProjectCallback {

    List<ProjectItem> mdata;
    RecyclerView rv_project;
    ProjectAdapter projectAdapter;


    public ProjectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_project, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv_project = view.findViewById(R.id.rv_project);
        // create a list of project items
        mdata = new ArrayList<>();


        mdata.add(new ProjectItem(R.drawable.castlevania, getString(R.string.project_title_0), getText(R.string.project_description_0)));
        mdata.add(new ProjectItem(R.drawable.reactjs, getString(R.string.project_title_1), getText(R.string.project_description_1)));
        mdata.add(new ProjectItem(R.drawable.lories, getString(R.string.project_title_2), getText(R.string.project_description_2)));
        mdata.add(new ProjectItem(R.drawable.tmdblogo, getString(R.string.project_title_3), getText(R.string.project_description_3)));


        projectAdapter = new ProjectAdapter(mdata, this);

        // setup grid recyclerview
        rv_project.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rv_project.setAdapter(projectAdapter);

    }

    @Override
    public void onProjectItemClick(int pos) {

        //handle click listener event when project item clicked

        // first we need to create a fragment bottom sheet instance

        ProjectFragmentDetails projectFragmentDetails =
                new ProjectFragmentDetails();

        // now we need to send project item to project dialog fragment
        // we will use bundle for that
        // also we need our project item data class to implement serializable interface so we can send it

        Bundle bundle = new Bundle();
        bundle.putSerializable("object", mdata.get(pos));
        projectFragmentDetails.setArguments(bundle);

        // now let's open the project bottom sheet fregment

        projectFragmentDetails.show(getActivity().getSupportFragmentManager(), "tagname");

        //now we done opening the bottom sheet let's test it out
        // ok everthing goes well
        // let's set the data in details fragment


    }
}
