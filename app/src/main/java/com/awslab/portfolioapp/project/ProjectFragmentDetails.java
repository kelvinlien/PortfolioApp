package com.awslab.portfolioapp.project;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.awslab.portfolioapp.R;
import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ProjectFragmentDetails extends BottomSheetDialogFragment {


    private ImageView imgProject;
    private TextView title,description;



    public ProjectFragmentDetails() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_project_details, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgProject = view.findViewById(R.id.project_details_img);
        title = view.findViewById(R.id.project_details_title);
        description = view.findViewById(R.id.project_details_desc);

        // first we need to get our project object from the bundle we have sent

        Bundle bundle = getArguments();
        ProjectItem item = (ProjectItem) bundle.getSerializable("object");

        // now we have the item we need just to load it

        loadProjectData(item);



    }

    void loadProjectData(ProjectItem item) {

        Glide.with(getContext()).load(item.getImage()).into(imgProject);
        if(item.getTitle()!= null)
            title.setText(item.getTitle());
        if (item.getDescription() != null)
            description.setText(item.getDescription());

    }


}