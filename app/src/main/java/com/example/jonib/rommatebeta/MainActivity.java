package com.example.jonib.rommatebeta;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.pager);
        com.example.jonib.rommatebeta.PagerAdapter adapter = new com.example.jonib.rommatebeta.PagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new RoomsFragment(), "Rooms");
        adapter.addFragment(new StatisticsFragment(), "Stat.s");
        adapter.addFragment(new AboutFragment(), "About");
        adapter.addFragment(new AboutFragment(), "In App");

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }
}
