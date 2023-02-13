package com.enes.testcaseapplicationforlabs.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.enes.testcaseapplicationforlabs.R;
import com.enes.testcaseapplicationforlabs.models.Feed;
import com.enes.testcaseapplicationforlabs.models.Post;
import com.google.android.material.imageview.ShapeableImageView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder>{
    private Post[] listdata;

    // RecyclerView recyclerView;
    public PostAdapter(Post[] listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.post_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Post myListData = listdata[position];
        holder.postimage.setImageResource(listdata[position].getPostimage());
        holder.userimage.setImageResource(listdata[position].getUserimage());
        holder.username.setText(listdata[position].getUsername());
        holder.hours.setText(listdata[position].getHours());
        /*holder.likecount.setText(listdata[position].getLikecount());
        holder.commentcount.setText(listdata[position].getCommentcount());
        holder.savecount.setText(listdata[position].getSavecount());*/
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ShapeableImageView userimage;
        public ShapeableImageView postimage;
        public TextView username;
        public TextView hours;
        public TextView likecount;
        public TextView commentcount;
        public TextView savecount;
        public ViewHolder(View itemView) {
            super(itemView);
            this.userimage = (ShapeableImageView) itemView.findViewById(R.id.userimage);
            this.postimage = (ShapeableImageView) itemView.findViewById(R.id.image);
            this.username = (TextView) itemView.findViewById(R.id.username);
            this.hours = (TextView) itemView.findViewById(R.id.hours);
            this.likecount = (TextView) itemView.findViewById(R.id.likecount);
            this.commentcount = (TextView) itemView.findViewById(R.id.commentcount);
            this.savecount = (TextView) itemView.findViewById(R.id.savecount);
        }
    }
}