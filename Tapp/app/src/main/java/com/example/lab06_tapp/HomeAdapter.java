package com.example.lab06_tapp;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ImageViewHolder> {


    private ArrayList<Integer> images;
    private OnClickListener onClickListener;

    public HomeAdapter(ArrayList<Integer> images, OnClickListener onClickListener){
        this.images = images;
        this.onClickListener = onClickListener;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_layout, parent,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view, onClickListener);

        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int i) {
        int images_id = images.get(i);
        holder.album.setImageResource(images_id);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public static class ImageViewHolder extends  RecyclerView.ViewHolder implements  View.OnClickListener{

        ImageView album;
        OnClickListener onClickListener;

        public ImageViewHolder(@NonNull View itemView, OnClickListener onClickListener) {
            super(itemView);
            album = itemView.findViewById(R.id.album);
            this.onClickListener = onClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onClickListener.onClick(getAdapterPosition());

        }
    }

    public interface OnClickListener{
        void onClick(int position);
    }
}
