package com.glc.itbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BanBenActivity extends AppCompatActivity {
private ImageView fanhui;
private TextView lianZhang;
private TextView lianGao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ban_ben);
        lianZhang=findViewById(R.id.lianjie_zhang);
        fanhui=findViewById(R.id.img_fanhuiAdd);
        lianGao=findViewById(R.id.lianxiwo_gao);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        lianZhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                //intent 动作
                intent.setAction("android.intent.action.VIEW");
                //打开的网址
                intent.setData(Uri.parse("https://me.csdn.net/weixin_43912367"));
                startActivity(intent);
            }
        });
        lianGao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                //intent 动作
                intent.setAction("android.intent.action.VIEW");
                //打开的网址
                intent.setData(Uri.parse("http://www.gaolicong.xyz/"));
                startActivity(intent);
            }
        });
    }
}
