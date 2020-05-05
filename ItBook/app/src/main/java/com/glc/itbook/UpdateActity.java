package com.glc.itbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.glc.itbook.bean.Book;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UpdateActity extends AppCompatActivity {
    private ListView mlistView;
   private BaseAdapter adapter;
    private TextView tvShangye;
    private TextView tvNext;
    private EditText edtYeMa;
    private Button btnTiaozhuan;
    private int page = 1;
    private TextView tvCurrentPage;
    private int totalPage;
    private TextView bookName;
    private Button souSuo;
    private TextView shuaxin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_actity);
        mlistView = findViewById(R.id.menu_list);
        tvNext = findViewById(R.id.tv_next);
        tvShangye = findViewById(R.id.tv_shangye);
        tvCurrentPage = findViewById(R.id.tv_currentPage);
        edtYeMa = findViewById(R.id.edt_yema);
        btnTiaozhuan =findViewById(R.id.btn_tiaozhuan);
        bookName=findViewById(R.id.edt_bookName);
        souSuo=findViewById(R.id.btn_imgSousuo);
     shuaxin=findViewById(R.id.shuaxinshuju);

     shuaxin.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             String bookNameStr = bookName.getText().toString().trim();
             try {
                 String encode = URLEncoder.encode(bookNameStr, "utf-8");
                 selectFenYe(encode,page);
             } catch (UnsupportedEncodingException e) {
                 e.printStackTrace();
             }
         }
     });


        String bookNameStr = bookName.getText().toString().trim();
        selectFenYe(bookNameStr,1);
        //上一页
        tvShangye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (page > 1) {
                    String bookNameStr = bookName.getText().toString().trim();
                    try {
                        String encode = URLEncoder.encode(bookNameStr, "utf-8");
                        selectFenYe(encode,--page);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(UpdateActity.this, "当前第一页", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //下一页
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (page < totalPage) {
                    String bookNameStr = bookName.getText().toString().trim();
                    try {
                        String encode = URLEncoder.encode(bookNameStr, "utf-8");
                        selectFenYe(encode,++page);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(UpdateActity.this, "到达尾页", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //跳转页码
        btnTiaozhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                page = Integer.parseInt(edtYeMa.getText().toString().trim());
                if (page > 0 && page <= totalPage) {

                    String bookNameStr = bookName.getText().toString().trim();
                    try {
                        String encode = URLEncoder.encode(bookNameStr, "utf-8");
                        selectFenYe(encode,page);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(UpdateActity.this, "超过最大页数", Toast.LENGTH_SHORT).show();

                }
            }
        });

        //搜索按钮
        souSuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bookNameStr = bookName.getText().toString().trim();
                try {
                    String encode = URLEncoder.encode(bookNameStr, "utf-8");
                    selectFenYe(encode,1);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    //分页搜索显示的数据 -- 默认显示全部
    private  void selectFenYe(String name,int page){
        JSONObject jsonObject = new JSONObject();
        String url = "http://192.168.1.103:8085/item/findByPageName?name="+name+"&currentPage="+page+"&pageSize=10";
        RequestQueue requestQueue = Volley.newRequestQueue(UpdateActity.this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {

                Gson gson = new Gson();
                final Book book = gson.fromJson(jsonObject.toString(), Book.class);
                int currentPage = book.getCurrentPage();
                tvCurrentPage.setText("第" + currentPage + "页");
                totalPage = book.getTotalPage();
                adapter = new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return book.getItems().size();
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
                    public View getView(final int i, View view, ViewGroup viewGroup) {
                        view = View.inflate(UpdateActity.this, R.layout.item_booklist2, null);
                        ImageView imageView = view.findViewById(R.id.item_image);
                        TextView name = view.findViewById(R.id.item_bookName);
                        final TextView user = view.findViewById(R.id.item_bookUser);
                        TextView info = view.findViewById(R.id.item_bookInfo);
                        TextView update = view.findViewById(R.id.item_bookUpdate);
                        final TextView delete = view.findViewById(R.id.item_bookDelete);
                        name.setText("书名:"+book.getItems().get(i).getBook_name());
                        user.setText("作者:"+book.getItems().get(i).getBook_author());
                        info.setText("简介:"+book.getItems().get(i).getBook_info());
                        update.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                int id = book.getItems().get(i).getId();
                              String name= book.getItems().get(i).getBook_name();
                              String shutu= book.getItems().get(i).getBook_img();
                              String author=book.getItems().get(i).getBook_author();
                              String info=book.getItems().get(i).getBook_info();
                              String lianjie=book.getItems().get(i).getBook_download();
                              Intent intent=new Intent(UpdateActity.this,UpdateItemActivity.class);
                              Bundle bundle=new Bundle();
                              bundle.putString("name",name);
                              bundle.putString("id", String.valueOf(id));
                              bundle.putString("shutu",shutu);
                              bundle.putString("author",author);
                              bundle.putString("info",info);
                              bundle.putString("lianjie",lianjie);
                              intent.putExtras(bundle);
                              startActivity(intent);
                            }
                        });
                        delete.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                int id = book.getItems().get(i).getId();
                                deleteInfo(id);
                                book.getItems().remove(i);
                                adapter.notifyDataSetChanged();

                            }
                        });
                        Glide.with(UpdateActity.this).load(book.getItems().get(i).getBook_img()).into(imageView);

                        return view;
                    }
                };
                mlistView.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(UpdateActity.this, "网络出错", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    //删除请求
    private void  deleteInfo(int id){
        JSONObject jsonObject = new JSONObject();
        String url="http://192.168.1.103:8085/item/deleteItem/?id="+id+"";
        RequestQueue requestQueue=Volley.newRequestQueue(UpdateActity.this);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    String info = jsonObject.getString("info");
                    if(info.equals("删除成功")){
                        Toast.makeText(UpdateActity.this, "删除成功", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(UpdateActity.this, "删除失败", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
