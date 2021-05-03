package com.awslab.portfolioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.awslab.portfolioapp.work.WorkFragment;
import com.awslab.portfolioapp.home.HomeFragment;
import com.awslab.portfolioapp.project.ProjectFragment;
import com.awslab.portfolioapp.sidemenu.Callback;
import com.awslab.portfolioapp.sidemenu.MenuAdapter;
import com.awslab.portfolioapp.sidemenu.MenuItem;
import com.awslab.portfolioapp.sidemenu.MenuUtil;
import com.awslab.portfolioapp.education.EducationFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Callback {

    RecyclerView menuRv;
    List<MenuItem> menuItems;
    MenuAdapter adapter;
    int selectedMenuPos = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        // setup side menu
        setupSideMenu();

        // set the default fragment when activity launch
        setHomeFragment();



    }

    private void setupSideMenu() {

        menuRv = findViewById(R.id.rv_side_menu);

        // get menu list item  will get data from a static data class

        menuItems = MenuUtil.getMenuList();
        adapter = new MenuAdapter(menuItems,this);
        menuRv.setLayoutManager(new LinearLayoutManager(this));
        menuRv.setAdapter(adapter);

    }

    void setProjectFragment() {

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new ProjectFragment()).commit();

    }

    void setEducationFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new EducationFragment()).commit();
    }

    void setWorkFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new WorkFragment()).commit();
    }


    void setHomeFragment() {

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();

    }


    @Override
    public void onSideMenuItemClick(int i) {

        switch (menuItems.get(i).getCode()) {

            case MenuUtil.WORK_FRAGMENT_CODE: setWorkFragment();
            break;
            case MenuUtil.EDUCATION_FRAGMENT_CODE: setEducationFragment();
            break;
            case MenuUtil.PROJECT_FRAGMENT_CODE:
                setProjectFragment();
            break;
            case MenuUtil.SWITCH_MODE_CODE:
                // call dark mode function here
                break;
            default: setHomeFragment();
        }

        // hightligh the selected menu item

        menuItems.get(selectedMenuPos).setSelected(false);
        menuItems.get(i).setSelected(true);
        selectedMenuPos = i ;
        adapter.notifyDataSetChanged();

    }
}
