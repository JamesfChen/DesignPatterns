package com.hawksjamesf.designpatterns;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends BaseActivity {

    FragmentManager supportFragmentManager;
    CreationalPatternsFragment creationalPatternsFragment;
    StructuralPatternsFragment structuralPatternsFragment;
    BehavioralPatternsFragment behavioralPatternsFragment;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.fl_content, creationalPatternsFragment)
                            .commitAllowingStateLoss();
                    return true;
                case R.id.navigation_dashboard:
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.fl_content, structuralPatternsFragment)
                            .commitAllowingStateLoss();
                    return true;
                case R.id.navigation_notifications:
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.fl_content, behavioralPatternsFragment)
                            .commitAllowingStateLoss();
                    return true;
            }
            return false;
        }
    };


    Toolbar toolbar;

    @Override
    protected void initComponent() {
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        supportFragmentManager = getSupportFragmentManager();
        creationalPatternsFragment = CreationalPatternsFragment.newInstance();
        structuralPatternsFragment = StructuralPatternsFragment.newInstance();
        behavioralPatternsFragment = BehavioralPatternsFragment.newInstance();
        supportFragmentManager.beginTransaction()
                .replace(R.id.fl_content, creationalPatternsFragment)
                .commitAllowingStateLoss();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    protected void createHandler() {

    }

    @Override
    protected void loadData() {

    }
}
