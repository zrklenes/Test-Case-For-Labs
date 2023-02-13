package com.enes.testcaseapplicationforlabs.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.enes.testcaseapplicationforlabs.R;
import com.enes.testcaseapplicationforlabs.models.Post;
import com.google.android.material.imageview.ShapeableImageView;

public class ProfilePostAdapter extends RecyclerView.Adapter<ProfilePostAdapter.ViewHolder>{
    private Post[] listdata;

    // RecyclerView recyclerView;
    public ProfilePostAdapter(Post[] listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.profile_post_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Post myListData = listdata[position];
        holder.postimage.setImageResource(listdata[position].getPostimage());
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ShapeableImageView postimage;
        public ViewHolder(View itemView) {
            super(itemView);
            this.postimage = (ShapeableImageView) itemView.findViewById(R.id.postimage);
        }
    }
}