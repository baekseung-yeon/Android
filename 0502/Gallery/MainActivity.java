package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("list view exam");

        final GridView gv = findViewById(R.id.gridView);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;

        public MyGridAdapter(Context c) {
            context = c;
        }

        Integer[] picID = {
                R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
                R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9, R.drawable.pic10,
                R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
                R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9, R.drawable.pic10,
                R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
                R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9, R.drawable.pic10
        };

        String[] picTitles = {
                "감자", "토마토", "사과", "오이", "양파",
                "배추", "시금치", "당근", "고구마", "청경채",
                "브로콜리", "양배추", "버섯", "마늘", "배",
                "토마토", "사과", "오이", "감자", "양파",
                "배추", "시금치", "당근", "고구마", "청경채",
                "브로콜리", "양배추", "버섯", "마늘", "배"
        };

        @Override
        public int getCount() {
            return picID.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(200, 300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5, 5, 5, 5);
            imageView.setImageResource(picID[i]);

            final int pos = i;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View dialogView = View.inflate(MainActivity.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                    ViewPager2 viewPager = dialogView.findViewById(R.id.viewPager);
                    ImagePagerAdapter pagerAdapter = new ImagePagerAdapter(context, picID, picTitles); // 제목 배열 전달
                    viewPager.setAdapter(pagerAdapter);
                    viewPager.setCurrentItem(pos);  // 현재 이미지부터 시작

                    Button btnNext = dialogView.findViewById(R.id.btnNext);
                    btnNext.setOnClickListener(v -> {
                        int currentItem = viewPager.getCurrentItem();
                        if (currentItem < picID.length - 1) {
                            viewPager.setCurrentItem(currentItem + 1);
                        } else {
                            viewPager.setCurrentItem(0); // 마지막이면 처음으로
                        }
                    });

                    dlg.setTitle("이미지 넘기기");
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });

            return imageView;
        }
    }
}
