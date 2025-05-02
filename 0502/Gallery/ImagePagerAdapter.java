package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ImagePagerAdapter extends RecyclerView.Adapter<ImagePagerAdapter.ViewHolder> {
    private Context context;
    private Integer[] imageIds;
    private String[] imageTitles; // 이미지 제목 추가

    public ImagePagerAdapter(Context context, Integer[] imageIds, String[] imageTitles) {
        this.context = context;
        this.imageIds = imageIds;
        this.imageTitles = imageTitles; // 제목 배열 추가
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageResource(imageIds[position]);
        holder.textView.setText(imageTitles[position]); // 제목을 설정
    }

    @Override
    public int getItemCount() {
        return imageIds.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView; // 제목 텍스트뷰 추가

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.imageTitle); // 제목 텍스트뷰
        }
    }
}
