package com.example.lab06_tapp;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;

public class CuponesAdapter extends RecyclerView.Adapter<CuponesAdapter.ImageViewHolder> {


    private ArrayList<Integer> images;

    public CuponesAdapter(ArrayList<Integer> images){
        this.images=images;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_layout, parent,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);

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

    public static class ImageViewHolder extends  RecyclerView.ViewHolder {

        ImageView album;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            album = itemView.findViewById(R.id.album);
        }

    }

}
