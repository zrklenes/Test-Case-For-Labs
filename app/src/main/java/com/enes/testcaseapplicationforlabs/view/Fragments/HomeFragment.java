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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.enes.testcaseapplicationforlabs.R;
import com.enes.testcaseapplicationforlabs.adapters.FeedAdapter;
import com.enes.testcaseapplicationforlabs.adapters.PostAdapter;
import com.enes.testcaseapplicationforlabs.models.Feed;
import com.enes.testcaseapplicationforlabs.models.Post;

import java.util.List;

public class HomeFragment extends Fragment  {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    int ErrorCount;
    ImageView notification;

    Feed[] myFeedData = new Feed[] {
            new Feed("Add Story",false,0, R.drawable.addstory),
            new Feed("Mehmet Zorkol",true,1, R.drawable.profile1),
            new Feed("Ahmet Zorkol",true,1, R.drawable.profile2),
            new Feed("Ceren Zorkol",true,1, R.drawable.profile3),
            new Feed("Ceren Zorkol",false,1, R.drawable.profile4),
            new Feed("Ceren Zorkol",false,1, R.drawable.profile1),
            new Feed("Ceren Zorkol",false,1, R.drawable.profile2),
    };

    Post[] myPostData = new Post[]{

            new Post("Enes Zorkol" , "2 Hours Ago" , 2283,394,291,1,1,R.drawable.profile1,R.drawable.postimage),
            new Post("Mehmet Zorkol" , "2 Hours Ago" , 2283,394,291,1,1,R.drawable.profile2,R.drawable.postimage2),
            new Post("Enes Zorkol" , "2 Hours Ago" , 2283,394,291,1,1,R.drawable.profile1,R.drawable.postimage),
            new Post("Mehmet Zorkol" , "2 Hours Ago" , 2283,394,291,1,1,R.drawable.profile2,R.drawable.postimage2)

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
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        notification = (ImageView) view.findViewById(R.id.notification);

        notification.setTranslationY(-50);
        notification.animate().alpha(1f).translationYBy(75).setDuration(500);


        FeedAdapter adapter = new FeedAdapter(myFeedData);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),1);
        layoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        RecyclerView recyclerViewPost = (RecyclerView) view.findViewById(R.id.recyclerViewPost);
        PostAdapter adapterPost = new PostAdapter(myPostData);
        recyclerViewPost.setHasFixedSize(true);
        recyclerViewPost.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewPost.setAdapter(adapterPost);


        return view;

    }






}
