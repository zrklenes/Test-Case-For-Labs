package com.enes.testcaseapplicationforlabs.adapters;



import static com.enes.testcaseapplicationforlabs.view.MainActivity.openStory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.enes.testcaseapplicationforlabs.R;
import com.enes.testcaseapplicationforlabs.models.Feed;
import com.enes.testcaseapplicationforlabs.view.Fragments.StoryFragment;
import com.google.android.material.imageview.ShapeableImageView;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder>{
    private Feed[] listdata;

    // RecyclerView recyclerView;
    public FeedAdapter(Feed[] listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.feed_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Feed myListData = listdata[position];
        holder.imageView.setImageResource(listdata[position].getImgId());
        if(listdata[position].getStatus()){
            holder.imageView.setStrokeWidth(10.0F); 
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listdata[position].getUserId()>0) {
                    openStory();
                }
            }
        });
       /* holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"click on item: "+myListData.getName(),Toast.LENGTH_LONG).show();
            }
        })*/
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ShapeableImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ShapeableImageView) itemView.findViewById(R.id.image);
        }
    }
}