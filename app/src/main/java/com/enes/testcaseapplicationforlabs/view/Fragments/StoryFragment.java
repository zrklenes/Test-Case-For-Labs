package com.enes.testcaseapplicationforlabs.view.Fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.enes.testcaseapplicationforlabs.R;
import com.enes.testcaseapplicationforlabs.adapters.SlideAdapter;
import com.enes.testcaseapplicationforlabs.adapters.StoryAdapter;
import com.enes.testcaseapplicationforlabs.view.FirstActivity;
import com.enes.testcaseapplicationforlabs.view.MainActivity;
import com.google.android.material.tabs.TabLayout;

public class StoryFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    int ErrorCount;
    private static ViewPager viewPager;
    private StoryAdapter myadapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  mPage = getArguments().getInt(ARG_PAGE);
        ErrorCount = 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.storyfragment, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.pager);
        myadapter = new StoryAdapter(getContext());
        viewPager.setAdapter(myadapter);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);
        ChangePage(0);

        return view;

    }

    public static void ChangePage(int position){
        viewPager.setCurrentItem(position);
    }


}
