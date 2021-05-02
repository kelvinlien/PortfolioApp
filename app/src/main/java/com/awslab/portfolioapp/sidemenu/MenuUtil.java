package com.awslab.portfolioapp.sidemenu;

import com.awslab.portfolioapp.R;

import java.util.ArrayList;
import java.util.List;

public class MenuUtil  {

    public static final int HOME_FRAGMENT_CODE = 0;
    public static final int WORK_FRAGMENT_CODE = 1;
    public static final int PROJECT_FRAGMENT_CODE = 2;
    public static final int EDUCATION_FRAGMENT_CODE = 3;


    public static List<MenuItem> getMenuList() {

        List<MenuItem> list = new ArrayList<>();
        // first menu item is selected
        list.add(new MenuItem(R.drawable.ic_baseline_home_24,HOME_FRAGMENT_CODE,true));
        list.add(new MenuItem(R.drawable.ic_baseline_work_24, WORK_FRAGMENT_CODE,false));
        list.add(new MenuItem(R.drawable.ic_baseline_school_24, EDUCATION_FRAGMENT_CODE,false));
        list.add(new MenuItem(R.drawable.ic_baseline_dashboard_24, PROJECT_FRAGMENT_CODE,false));

        return list;



    }



}
