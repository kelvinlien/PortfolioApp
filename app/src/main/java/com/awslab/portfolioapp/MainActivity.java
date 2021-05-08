package com.awslab.portfolioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

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
        boolean darkTheme = false;
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
        {
            darkTheme = true;
            setTheme(R.style.AppThemeDark);
        }
        else
            setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState != null ? savedInstanceState : getIntent().getBundleExtra("saved_state"));
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        // setup side menu
        setupSideMenu();

        // set the default fragment when activity launch
        setHomeFragment();
        ImageView switchButton = findViewById(R.id.UIModeSwitchButton);
        if (darkTheme)
        {
            switchButton.setImageResource(R.drawable.ic_baseline_wb_sunny_24);
        }
        else
        {
            switchButton.setImageResource(R.drawable.ic_baseline_nights_stay_24);
        }
        final boolean finalDarkTheme = darkTheme;
        switchButton.setOnClickListener(new View.OnClickListener(){

                                            @Override
                                            public void onClick(View v) {
                                                if (finalDarkTheme)
                                                {
                                                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                                                }
                                                else
                                                {
                                                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                                                }
//                                                recreate();
                                                transitionRecreate();
                                            }
                                        }
        );


    }

    protected void transitionRecreate(){
        Bundle bundle = new Bundle();
        onSaveInstanceState(bundle);
        Intent intent = new Intent(this, getClass());
        intent.putExtra("saved_state", bundle);
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        startActivity(intent);
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
            default: setHomeFragment();
        }

        // hightligh the selected menu item

        menuItems.get(selectedMenuPos).setSelected(false);
        menuItems.get(i).setSelected(true);
        selectedMenuPos = i ;
        adapter.notifyDataSetChanged();

    }
}
