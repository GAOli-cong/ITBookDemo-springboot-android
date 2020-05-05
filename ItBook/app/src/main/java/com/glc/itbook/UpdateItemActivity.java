package com.glc.itbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UpdateItemActivity extends AppCompatActivity {
    private EditText addBookName;
    private EditText addBookimg;
    private EditText addBookAuthor;
    private EditText addBookinfo;
    private EditText addBookLianjie;
    private Button addBtn;
    private ImageView fanhui;
    private  int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_item);
        addBookName=findViewById(R.id.edt_addBookName);
        addBookimg=findViewById(R.id.edt_addBookimg);
        addBookAuthor=findViewById(R.id.edt_addBookAuthor);
        addBookinfo=findViewById(R.id.edt_addBookInfo);
        addBookLianjie=findViewById(R.id.edt_addBookLianjie);
        fanhui=findViewById(R.id.img_fanhuiAdd);
        addBtn=findViewById(R.id.btn_Add);

        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
       /* bundle.putInt("id",id);
        bundle.putString("shutu",shutu);
        bundle.putString("author",author);
        bundle.putString("info",info);
        bundle.putString("lianjie",lianjie);*/
        Intent intent=getIntent();
        String name = intent.getStringExtra("name");
         id = Integer.parseInt(intent.getStringExtra("id"));
        String shutu=intent.getStringExtra("shutu");
        String author = intent.getStringExtra("author");
        String info = intent.getStringExtra("info");
        String lianjie = intent.getStringExtra("lianjie");
        addBookName.setText(name);
        addBookimg.setText(shutu);
        addBookAuthor.setText(author);
        addBookinfo.setText(info);
        addBookLianjie.setText(lianjie);
       addBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String name1 = addBookName.getText().toString().trim();
               String img1 = addBookimg.getText().toString().trim();
               String author1 = addBookAuthor.getText().toString().trim();
               String info1 = addBookinfo.getText().toString().trim();
               String lianjie1 = addBookLianjie.getText().toString().trim();
               if(name1.equals("")||img1.equals("")||author1.equals("")||info1.equals("")||lianjie1.equals("")){
                   Toast.makeText(UpdateItemActivity.this, "请填写完整", Toast.LENGTH_SHORT).show();
               }else {
                   try {
                       String name11 = URLEncoder.encode(name1, "utf-8");
                       String img11 = URLEncoder.encode(img1, "utf-8");
                       String author11 = URLEncoder.encode(author1, "utf-8");
                       String info11 = URLEncoder.encode(info1, "utf-8");
                       String lianjie11 = URLEncoder.encode(lianjie1, "utf-8");
                       updateInfo(id,name11,img11,author11,info11,lianjie11);
                   } catch (UnsupportedEncodingException e) {
                       e.printStackTrace();
                   }
               }
           }
       });


    }

    private void updateInfo(int id, String book_name, String shutu, String author, String info, String lianjie) {
        JSONObject jsonObject=new JSONObject();
        String url = "http://192.168.1.103:8085/item/updateItem?id=" + id + "&book_name=" + book_name + "&book_img=" + shutu + "&book_author=" + author + "&book_info=" + info + "&book_download=" + lianjie + "";

        RequestQueue requestQueue= Volley.newRequestQueue(UpdateItemActivity.this);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    String info1 = jsonObject.getString("info");
                    if(info1.equals("修改成功")){
                        Toast.makeText(UpdateItemActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(UpdateItemActivity.this, "修改失败", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("错误", volleyError.toString());
                Toast.makeText(UpdateItemActivity.this, "网络失败", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);

    }
}
