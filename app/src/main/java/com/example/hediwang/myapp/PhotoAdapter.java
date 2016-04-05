package com.example.hediwang.myapp;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hediwang on 16/3/29.
 */
public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {

    private Context context;
    private ArrayList<String> imagePaths;
    private ViewSelectedImageInterface viewSelectedImageInterface;

    public PhotoAdapter() {
        context = null;
        imagePaths = new ArrayList<>();
    }


    public PhotoAdapter(Context context, ArrayList<String> imagePaths, ViewSelectedImageInterface viewSelectedImageInterface) {
        this.context = context;
        this.imagePaths = imagePaths;
        this.viewSelectedImageInterface = viewSelectedImageInterface;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<String> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(ArrayList<String> imagePaths) {
        this.imagePaths = imagePaths;
    }

    public void addImage(String imagePath) {
        imagePaths.add(imagePath);
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View entryLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.photo_entry_layout, viewGroup, false);
        PhotoViewHolder photoViewHolder = new PhotoViewHolder(entryLayoutView);
        return photoViewHolder;
    }

    @Override
    public void onBindViewHolder(final PhotoViewHolder photoViewHolder, int i) {
        final String imagePath = imagePaths.get(i);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 10;
        options.inJustDecodeBounds = false;
        photoViewHolder.photo.setImageBitmap(BitmapFactory.decodeFile(imagePath, options));
        photoViewHolder.imagePath.setText(imagePath);
        photoViewHolder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewSelectedImageInterface.viewImage(imagePath);
            }
        });
        photoViewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = photoViewHolder.getAdapterPosition();
                imagePaths.remove(index);
                PhotoAdapter.this.notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return imagePaths.size();
    }

    public static class PhotoViewHolder extends RecyclerView.ViewHolder {

        TextView imagePath;
        ImageView photo;
        Button delete;

        public PhotoViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            imagePath = (TextView) itemLayoutView.findViewById(R.id.photo_name);
            photo = (ImageView) itemLayoutView.findViewById(R.id.photo);
            delete = (Button) itemLayoutView.findViewById(R.id.delete);
        }
    }

    public interface ViewSelectedImageInterface{
        public void viewImage(String path);
    }
}
