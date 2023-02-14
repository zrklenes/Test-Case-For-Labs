package com.enes.testcaseapplicationforlabs.view.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.enes.testcaseapplicationforlabs.R;
import com.enes.testcaseapplicationforlabs.adapters.ProfilePostAdapter;
import com.enes.testcaseapplicationforlabs.models.Post;
import com.enes.testcaseapplicationforlabs.viewmodels.SaveViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class SaveFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    int ErrorCount;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    ProfilePostAdapter adapterPost;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  mPage = getArguments().getInt(ARG_PAGE);
        ErrorCount = 0;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_detail_fragment, container, false);
        SaveViewModel saveViewModel =
                new ViewModelProvider(this).get(SaveViewModel.class);

        RecyclerView recyclerViewPost = (RecyclerView) view.findViewById(R.id.recyclerViewPost);

        saveViewModel.getSaveDatam().observe(getViewLifecycleOwner(), new Observer<Post[]>() {
            @Override
            public void onChanged(Post[] posts) {
                adapterPost = new ProfilePostAdapter(posts);
                recyclerViewPost.setAdapter(adapterPost);
                adapterPost.notifyDataSetChanged();
            }
        });



        recyclerViewPost.setHasFixedSize(true);
        recyclerViewPost.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerViewPost.setNestedScrollingEnabled(false);

        return view;

    }

}
