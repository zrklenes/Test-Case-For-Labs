package com.enes.testcaseapplicationforlabs.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.enes.testcaseapplicationforlabs.R;
import com.enes.testcaseapplicationforlabs.adapters.SlideAdapter;
import com.enes.testcaseapplicationforlabs.view.Fragments.HomeFragment;
import com.enes.testcaseapplicationforlabs.view.Fragments.ProfileFragment;
import com.enes.testcaseapplicationforlabs.view.Fragments.StoryFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.viewpager.widget.ViewPager;

import com.enes.testcaseapplicationforlabs.databinding.ActivityMainBinding;

import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private ViewPager viewPager;
    private SlideAdapter myadapter;
    BottomNavigationView bottomNavigationView;
    private int addPostMainRotat=120;
    static FragmentManager fm;
    static StoryFragment storyFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fm =getSupportFragmentManager();
        storyFragment = new StoryFragment();


        SharedPreferences sh = getSharedPreferences("FirstPrefences", MODE_PRIVATE);
        Boolean Loginstatus = sh.getBoolean("FirstLogin", false);
        if(!Loginstatus){
            Bundle bundle = new Bundle();
            Intent newIntent = new Intent(MainActivity.this, FirstActivity.class);
            newIntent.putExtras(bundle);
            startActivityForResult(newIntent, 0);
        }

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnavigationbar);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);



        addPostMainRotat=addPostMainRotat+360;
        binding.addpost.animate().rotation(addPostMainRotat).setDuration(500);


        getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,new HomeFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment temp = null;
                switch (item.getItemId())
                {
                    case R.id.mHome : temp = new HomeFragment();
                        break;
                    case R.id.mComment : temp = new HomeFragment();
                        break;
                    case R.id.mLike : temp = new HomeFragment();
                        break;
                    case R.id.mProfile:  temp = new ProfileFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,temp).commit();
                return true;
            }
        });

    }

    public void NextPage(View view){
        addPostMainRotat=addPostMainRotat+360;
        binding.addpost.animate().rotation(addPostMainRotat).setDuration(500);

    }


    public static void openStory(){
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.frameforstory,storyFragment,"Story");
        transaction.commit();
    }

    public static void closeStory(){
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.remove(storyFragment);
        transaction.commit();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
    }
}