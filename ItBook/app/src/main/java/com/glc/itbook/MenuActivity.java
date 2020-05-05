package com.glc.itbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.glc.itbook.fragment.Fragment_dongtai;
import com.glc.itbook.fragment.Fragment_index;
import com.glc.itbook.fragment.Fragment_wode;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    private ViewPager vp;
    private LinearLayout btn1;
    private TextView tv1;
    private ImageView imgIndex;
    private LinearLayout btn2;
    private TextView tv2;
    private ImageView imgDongtai;
    private LinearLayout btn3;
    private TextView tv3;
    private ImageView imgMe;

    List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        vp = findViewById(R.id.vp_vp1);
        btn1 = findViewById(R.id.ly_btn1);
        tv1 = findViewById(R.id.tv_index);
        imgIndex = findViewById(R.id.img_index);
        btn2 = findViewById(R.id.ly_btn2);
        tv2 = findViewById(R.id.tv_dongtai);
        imgDongtai = findViewById(R.id.img_dongtai);
        btn3 = findViewById(R.id.ly_btn3);
        tv3 = findViewById(R.id.tv_wode);
        imgMe = findViewById(R.id.img_me);
        fragments.add(new Fragment_index());
        fragments.add(new Fragment_dongtai());
        fragments.add(new Fragment_wode());


        SharedPreferences sharedPreferences=getSharedPreferences("data", Context.MODE_PRIVATE);
        String username1 = sharedPreferences.getString("username", null);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String phone = intent.getStringExtra("phone");

        intent.getStringExtra("msg");
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putString("phone", phone);
        fragments.get(2).setArguments(bundle);

        fragments.get(1).setArguments(bundle);
        vp.setOffscreenPageLimit(3);
        vp.setAdapter(new MyPageAdapter(getSupportFragmentManager()));

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(0);
                tv1.setTextColor(Color.parseColor("#0099ff"));
                tv2.setTextColor(Color.parseColor("#F7F7F7"));
                tv3.setTextColor(Color.parseColor("#F7F7F7"));
                imgIndex.setImageResource(R.drawable.index);
                imgDongtai.setImageResource(R.drawable.dongtai);
                imgMe.setImageResource(R.drawable.me1);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(1);
                tv2.setTextColor(Color.parseColor("#0099ff"));
                tv1.setTextColor(Color.parseColor("#F7F7F7"));
                tv3.setTextColor(Color.parseColor("#F7F7F7"));
                imgIndex.setImageResource(R.drawable.index1);
                imgDongtai.setImageResource(R.drawable.dongtai1);
                imgMe.setImageResource(R.drawable.me1);

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(2);
                tv3.setTextColor(Color.parseColor("#0099ff"));
                tv1.setTextColor(Color.parseColor("#F7F7F7"));
                tv2.setTextColor(Color.parseColor("#F7F7F7"));
                imgIndex.setImageResource(R.drawable.index1);
                imgDongtai.setImageResource(R.drawable.dongtai);
                imgMe.setImageResource(R.drawable.me);
            }
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        tv1.setTextColor(Color.parseColor("#0099ff"));
                        tv2.setTextColor(Color.parseColor("#F7F7F7"));
                        tv3.setTextColor(Color.parseColor("#F7F7F7"));
                        imgIndex.setImageResource(R.drawable.index);
                        imgDongtai.setImageResource(R.drawable.dongtai);
                        imgMe.setImageResource(R.drawable.me1);
                        break;
                    case 1:
                        tv2.setTextColor(Color.parseColor("#0099ff"));
                        tv1.setTextColor(Color.parseColor("#F7F7F7"));
                        tv3.setTextColor(Color.parseColor("#F7F7F7"));
                        imgIndex.setImageResource(R.drawable.index1);
                        imgDongtai.setImageResource(R.drawable.dongtai1);
                        imgMe.setImageResource(R.drawable.me1);

                        break;
                    case 2:
                        tv3.setTextColor(Color.parseColor("#0099ff"));
                        tv1.setTextColor(Color.parseColor("#F7F7F7"));
                        tv2.setTextColor(Color.parseColor("#F7F7F7"));
                        imgIndex.setImageResource(R.drawable.index1);
                        imgDongtai.setImageResource(R.drawable.dongtai);
                        imgMe.setImageResource(R.drawable.me);
                        break;


                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class MyPageAdapter extends FragmentPagerAdapter {

        public MyPageAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
