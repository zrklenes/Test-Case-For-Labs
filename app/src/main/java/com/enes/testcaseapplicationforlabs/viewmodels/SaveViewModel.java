package com.enes.testcaseapplicationforlabs.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.enes.testcaseapplicationforlabs.R;
import com.enes.testcaseapplicationforlabs.models.Post;

public class SaveViewModel extends ViewModel {

    public MutableLiveData<Post[]> myPostDatam;

    public SaveViewModel() {
        myPostDatam = new MutableLiveData<>();
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
        myPostDatam.setValue(myPostData);
    }

    public LiveData<Post[]> getSaveDatam() {
        return myPostDatam;
    }
}