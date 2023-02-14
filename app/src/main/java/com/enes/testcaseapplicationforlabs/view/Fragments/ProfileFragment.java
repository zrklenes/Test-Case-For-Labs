package com.enes.testcaseapplicationforlabs.view.Fragments;

import static androidx.fragment.app.FragmentManager.TAG;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.enes.testcaseapplicationforlabs.R;
import com.enes.testcaseapplicationforlabs.adapters.FeedAdapter;
import com.enes.testcaseapplicationforlabs.adapters.PostAdapter;
import com.enes.testcaseapplicationforlabs.models.Feed;
import com.enes.testcaseapplicationforlabs.models.Post;
import com.enes.testcaseapplicationforlabs.viewmodels.ProfileViewModel;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    int ErrorCount;
    private ViewPager viewPager;
    TextView username,usertag,posts,followers,follows;
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

        ProfileViewModel profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);

        viewPager = view.findViewById(R.id.view_pager);
        tabLayout = view.findViewById(R.id.tab_layout);
        username = view.findViewById(R.id.username);
        usertag = view.findViewById(R.id.usertag);
        posts = view.findViewById(R.id.posts);
        followers = view.findViewById(R.id.followers);
        follows = view.findViewById(R.id.follows);

        profileViewModel.getUsername().observe(getViewLifecycleOwner(), username::setText);
        profileViewModel.getUserlink().observe(getViewLifecycleOwner(), usertag::setText);
        profileViewModel.getPosts().observe(getViewLifecycleOwner(), posts::setText);
        profileViewModel.getFollowers().observe(getViewLifecycleOwner(), followers::setText);
        profileViewModel.getFollows().observe(getViewLifecycleOwner(), follows::setText);


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
        tabLayout.getTabAt(1).setIcon(R.drawable.mysaved);

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
