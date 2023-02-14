package com.enes.testcaseapplicationforlabs.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.enes.testcaseapplicationforlabs.R;
import com.enes.testcaseapplicationforlabs.models.Feed;
import com.enes.testcaseapplicationforlabs.models.Post;

public class HomeViewModel extends ViewModel {

    public MutableLiveData<Post[]> myPostDatam;
    public MutableLiveData<Feed[]> myFeedDatam;

    public HomeViewModel() {
        myPostDatam = new MutableLiveData<>();
        myFeedDatam = new MutableLiveData<>();
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

        myPostDatam.setValue(myPostData);
        myFeedDatam.setValue(myFeedData);
    }

    public LiveData<Post[]> getSaveDatam() {
        return myPostDatam;
    }
    public LiveData<Feed[]> getFeedDatam() {
        return myFeedDatam;
    }
}