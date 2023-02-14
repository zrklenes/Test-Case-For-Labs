package com.enes.testcaseapplicationforlabs.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.enes.testcaseapplicationforlabs.R;
import com.enes.testcaseapplicationforlabs.models.Post;

public class ProfileViewModel extends ViewModel {

    private final MutableLiveData<String> username,userlink,posts,followers,follows;

    public ProfileViewModel() {
        username = new MutableLiveData<>();
        userlink = new MutableLiveData<>();
        posts = new MutableLiveData<>();
        followers = new MutableLiveData<>();
        follows = new MutableLiveData<>();
        username.setValue("Jhon Doe");
        userlink.setValue("@jhondoe");
        posts.setValue("35");
        followers.setValue("1,532");
        follows.setValue("128");
    }

    public LiveData<String> getUsername() {
        return username;
    }

    public LiveData<String> getUserlink() {
        return userlink;
    }

    public LiveData<String> getPosts() {
        return posts;
    }

    public LiveData<String> getFollowers() {
        return followers;
    }

    public LiveData<String> getFollows() {
        return follows;
    }

}