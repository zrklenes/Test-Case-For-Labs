package com.enes.testcaseapplicationforlabs.view.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.enes.testcaseapplicationforlabs.R;
import com.enes.testcaseapplicationforlabs.adapters.ProfilePostAdapter;
import com.enes.testcaseapplicationforlabs.models.Post;
import com.google.android.material.tabs.TabLayout;

public class SaveFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    int ErrorCount;
    private ViewPager viewPager;
    private TabLayout tabLayout;


    Post[] myPostData = new Post[]{
            new Post("Mehmet Zorkol" , "2 Hours Ago" , 2283,394,291,1,1,R.drawable.profile2,R.drawable.postimage2),
            new Post("Enes Zorkol" , "2 Hours Ago" , 2283,394,291,1,1,R.drawable.profile1,R.drawable.postimage),
            new Post("Mehmet Zorkol" , "2 Hours Ago" , 2283,394,291,1,1,R.drawable.profile2,R.drawable.postimage2),
            new Post("Enes Zorkol" , "2 Hours Ago" , 2283,394,291,1,1,R.drawable.profile1,R.drawable.postimage),
            new Post("Mehmet Zorkol" , "2 Hours Ago" , 2283,394,291,1,1,R.drawable.profile2,R.drawable.postimage2),
            new Post("Enes Zorkol" , "2 Hours Ago" , 2283,394,291,1,1,R.drawable.profile1,R.drawable.postimage),
            new Post("Mehmet Zorkol" , "2 Hours Ago" , 2283,394,291,1,1,R.drawable.profile2,R.drawable.postimage2),
            new Post("Enes Zorkol" , "2 Hours Ago" , 2283,394,291,1,1,R.drawable.profile1,R.drawable.postimage),

    };

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


        RecyclerView recyclerViewPost = (RecyclerView) view.findViewById(R.id.recyclerViewPost);
        ProfilePostAdapter adapterPost = new ProfilePostAdapter(myPostData);
        recyclerViewPost.setHasFixedSize(true);
        recyclerViewPost.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerViewPost.setAdapter(adapterPost);
        recyclerViewPost.setNestedScrollingEnabled(false);

        return view;

    }

}
