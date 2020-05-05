package com.glc.itbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class XiangQingActivity extends AppCompatActivity {
private TextView shuming;
private TextView zuozhe;
private TextView jianjie;
private TextView liulanqi;
private ImageView imgXiangqing;
 private    String down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);
        shuming=findViewById(R.id.tv_shuming);
        zuozhe=findViewById(R.id.tv_zuozhe);
        jianjie=findViewById(R.id.tv_jianjie);
        liulanqi=findViewById(R.id.tv_liulanqi);
        imgXiangqing=findViewById(R.id.img_imgXiangQing);
        Intent intent=getIntent();
        String name = intent.getStringExtra("name");
        String author = intent.getStringExtra("author");
        String jianjieStr= intent.getStringExtra("jianjie");
        down = intent.getStringExtra("down");
        String imgStr = intent.getStringExtra("img");
        shuming.setText("书名："+name);
        zuozhe.setText("作者："+author);
        jianjie.setText("简介："+jianjieStr);
        liulanqi.setText("下载链接："+down);
        Glide.with(XiangQingActivity.this).load(imgStr).into(imgXiangqing);
        liulanqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse(down));
                startActivity(intent1);
            }
        });
    }

}
