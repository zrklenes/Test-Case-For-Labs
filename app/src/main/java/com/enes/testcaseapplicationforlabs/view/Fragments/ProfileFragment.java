package com.enes.testcaseapplicationforlabs.view.Fragments;

import static androidx.fragment.app.FragmentManager.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.enes.testcaseapplicationforlabs.R;
import com.enes.testcaseapplicationforlabs.adapters.FeedAdapter;
import com.enes.testcaseapplicationforlabs.adapters.PostAdapter;
import com.enes.testcaseapplicationforlabs.models.Feed;
import com.enes.testcaseapplicationforlabs.models.Post;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    int ErrorCount;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  mPage = getArguments().getInt(ARG_PAGE);
        ErrorCount = 0;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        viewPager = view.findViewById(R.id.view_pager);
        tabLayout = view.findViewById(R.id.tab_layout);
        NestedScrollView scroller = (NestedScrollView) view.findViewById(R.id.nestedscroll);

        scroller.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                if (scrollY > oldScrollY) {
                    Log.i(TAG, "Scroll DOWN");
                }
                if (scrollY < oldScrollY) {
                    Log.i(TAG, "Scroll UP");
                }

                if (scrollY == 0) {
                    Log.i(TAG, "TOP SCROLL");
                }

                if (scrollY == ( v.getMeasuredHeight() - v.getChildAt(0).getMeasuredHeight() )) {
                    Log.i(TAG, "BOTTOM SCROLL");
                }
            }
        });

        MyPhotosFragment myPhotosFragment = new MyPhotosFragment();
        SaveFragment saveFragment = new SaveFragment();
        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), 0);
        //add fragments and set the adapter
        viewPagerAdapter.addFragment(myPhotosFragment,"");
        viewPagerAdapter.addFragment(saveFragment,"");
        viewPager.setAdapter(viewPagerAdapter);
        //set the icons
        tabLayout.getTabAt(0).setIcon(R.drawable.myphotos);
        tabLayout.getTabAt(1).setIcon(R.drawable.mysaved );

        return view;

    }



    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments = new ArrayList<>();
        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }
        //add fragment to the viewpager
        public void addFragment(Fragment fragment, String title){
            fragments.add(fragment);
        }
        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }
        @Override
        public int getCount() {
            return fragments.size();
        }
    }



}
