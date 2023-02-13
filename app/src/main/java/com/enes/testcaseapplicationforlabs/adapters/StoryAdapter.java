package com.enes.testcaseapplicationforlabs.adapters;


import static com.enes.testcaseapplicationforlabs.view.Fragments.StoryFragment.ChangePage;
import static com.enes.testcaseapplicationforlabs.view.MainActivity.closeStory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.viewpager.widget.PagerAdapter;

import com.enes.testcaseapplicationforlabs.R;

public class StoryAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    // list of images
    public int[] lst_images = {
            R.drawable.story1,
            R.drawable.story2,
            R.drawable.story3
    };


    public StoryAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return lst_images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(RelativeLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.story_first_fragment,container,false);
        ImageView imgslide = (ImageView)  view.findViewById(R.id.slideimg);
        RelativeLayout leftside = (RelativeLayout)  view.findViewById(R.id.left_side);
        RelativeLayout rightside = (RelativeLayout)  view.findViewById(R.id.right_side);
        rightside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position== (lst_images.length-1)){
                    closeStory();
                }
                    ChangePage(position+1);
            }
        });
        leftside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(position== 0){
                    closeStory();
                }
                ChangePage(position-1);
            }
        });
        imgslide.setImageResource(lst_images[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
