package com.example.chatapp2;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import com.example.chatapp2.Fragments.FirstFragment;
import com.example.chatapp2.Fragments.SecondFragment;

import com.example.chatapp2.Fragments.ThirdFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //for tool par
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("");
        TabLayout tabLayout=findViewById(R.id.tab_layout);
        ViewPager viewPager=findViewById(R.id.view_pager);
ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
viewPagerAdapter.addFragment(new FirstFragment(),"First");
        viewPagerAdapter.addFragment(new SecondFragment(),"Second");
        viewPagerAdapter.addFragment(new ThirdFragment(),"Third");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }


    //for the view pager
    class ViewPagerAdapter extends FragmentPagerAdapter{
private ArrayList<Fragment> fragments;
private  ArrayList<String>titles;
ViewPagerAdapter(FragmentManager fm){
    super(fm);
    this.fragments=new ArrayList<>();
    this.titles=new ArrayList<>();

}
        @Override
        public Fragment getItem(int i) {
            return fragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
        public  void addFragment(Fragment fragment,String title){
    fragments.add(fragment);
    titles.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
