package com.example.administrator.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.CollegeListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeftFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private CollegeListAdapter mMenuAdapter;
    private List<String> mCollegeList;


    public LeftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_left, container, false);
        mRecyclerView = (RecyclerView)v.findViewById(R.id.Recycle_View);

        initdata();

        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mMenuAdapter=new CollegeListAdapter(R.layout.item_view,mCollegeList);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mMenuAdapter);


        return v;
    }

    private void initdata() {
        mCollegeList = new ArrayList<>();
        mCollegeList.add("美术学院");
        mCollegeList.add("数统学院");
        mCollegeList.add("设计学院");
        mCollegeList.add("文学院");
    }

}
