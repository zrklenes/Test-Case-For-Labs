package com.enes.testcaseapplicationforlabs.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.enes.testcaseapplicationforlabs.R;
import com.enes.testcaseapplicationforlabs.adapters.SlideAdapter;
import com.enes.testcaseapplicationforlabs.databinding.FirstActivityBinding;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import android.widget.Button;

public class FirstActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private FirstActivityBinding binding;
    private ViewPager viewPager;
    private SlideAdapter myadapter;
    private Button button;
    private int buttonstatus = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = FirstActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewPager = (ViewPager) findViewById(R.id.pager);
        button = (Button) findViewById(R.id.buttun);
        myadapter = new SlideAdapter(this);
        viewPager.setAdapter(myadapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position==2){
                    buttonstatus=1;
                    button.setText("Finish");
                }else{
                    buttonstatus=0;
                    button.setText("Nest");
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void NextPage(View view){
        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
        if(viewPager.getCurrentItem()==2){
            buttonstatus=1;
            button.setText("Finish");
        }else{
            buttonstatus=0;
            button.setText("Nest");
        }
        if(buttonstatus==1){
            SharedPreferences sharedPreferences = getSharedPreferences("FirstPrefences",MODE_PRIVATE);
            SharedPreferences.Editor myEdit = sharedPreferences.edit();
            myEdit.putBoolean("FirstLogin",true);
            myEdit.commit();

            Bundle bundle = new Bundle();
            Intent newIntent = new Intent(FirstActivity.this, MainActivity.class);
            newIntent.putExtras(bundle);
            startActivityForResult(newIntent, 0);

        }
    }


}