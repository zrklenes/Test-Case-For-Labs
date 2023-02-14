package com.enes.testcaseapplicationforlabs.view.Fragments;

import android.app.Notification;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.enes.testcaseapplicationforlabs.R;
import com.enes.testcaseapplicationforlabs.adapters.FeedAdapter;
import com.enes.testcaseapplicationforlabs.adapters.PostAdapter;
import com.enes.testcaseapplicationforlabs.adapters.ProfilePostAdapter;
import com.enes.testcaseapplicationforlabs.models.Feed;
import com.enes.testcaseapplicationforlabs.models.Post;
import com.enes.testcaseapplicationforlabs.viewmodels.HomeViewModel;
import com.enes.testcaseapplicationforlabs.viewmodels.SaveViewModel;

import java.util.List;

public class HomeFragment extends Fragment  {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    int ErrorCount;
    ImageView notification;
    FeedAdapter adapter;
    PostAdapter adapterPost;
    RecyclerView recyclerViewPost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  mPage = getArguments().getInt(ARG_PAGE);
        ErrorCount = 0;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        notification = (ImageView) view.findViewById(R.id.notification);

        notification.setTranslationY(-50);
        notification.animate().alpha(1f).translationYBy(75).setDuration(500);

        homeViewModel.getSaveDatam().observe(getViewLifecycleOwner(), new Observer<Post[]>() {
            @Override
            public void onChanged(Post[] posts) {
                adapterPost = new PostAdapter(posts);
                recyclerViewPost.setAdapter(adapterPost);
                adapterPost.notifyDataSetChanged();
            }
        });

        homeViewModel.getFeedDatam().observe(getViewLifecycleOwner(), new Observer<Feed[]>() {
            @Override
            public void onChanged(Feed[] feeds) {
                adapter = new FeedAdapter(feeds);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });



        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),1);
        layoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        recyclerViewPost = (RecyclerView) view.findViewById(R.id.recyclerViewPost);
        recyclerViewPost.setHasFixedSize(true);
        recyclerViewPost.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewPost.setAdapter(adapterPost);


        return view;

    }






}
