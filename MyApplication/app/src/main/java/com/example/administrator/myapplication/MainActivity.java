package com.example.administrator.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.administrator.myapplication.fragment.CircleFragment;
import com.example.administrator.myapplication.fragment.FindFragment;
import com.example.administrator.myapplication.fragment.MeFragment;
import com.example.administrator.myapplication.fragment.MsgFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private BottomNavigationBar mBottomNavigationBar;
    private List<Fragment> mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationBar=(BottomNavigationBar)findViewById(R.id.Btm_nav);

        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.nav_circle,"动态"))
                .addItem(new BottomNavigationItem(R.drawable.nav_find,"发现"))
                .addItem(new BottomNavigationItem(R.drawable.nav_msg,"消息"))
                .addItem(new BottomNavigationItem(R.drawable.nav_me,"我的"))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .initialise();
        mBottomNavigationBar.setTabSelectedListener(this);

        mFragment = new ArrayList<>();
        mFragment.add(new CircleFragment());
        mFragment.add(new FindFragment());
        mFragment.add(new MsgFragment());
        mFragment.add(new MeFragment());

        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.Container,mFragment.get(0));
        ft.commit();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.Container,mFragment.get(position));
        ft.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
