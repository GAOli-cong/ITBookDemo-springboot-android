package com.glc.itbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private EditText login_username;
    private EditText login_password;
    private Button btn_login;
    private Button btnRegister;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //透明状态栏          
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        btnRegister = findViewById(R.id.btn_registerActivity);
        login_username = findViewById(R.id.edt_login_username);
        login_password = findViewById(R.id.edt_login_password);
        btn_login = findViewById(R.id.btn_login);


        sharedPreferences =getSharedPreferences("data",Context.MODE_PRIVATE);
        String userstr= sharedPreferences.getString("username","");
        String phonestr= sharedPreferences.getString("phone","");
        if(userstr.equals("")){

        }else {
            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
            intent.putExtra("username", userstr);
            intent.putExtra("phone", phonestr);
            startActivity(intent);
        }
        Intent intent = getIntent();
        final String username1 = intent.getStringExtra("username1");
        login_username.setText(username1);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameStr = login_username.getText().toString().trim();
                String passwordStr = login_password.getText().toString().trim();
                if (usernameStr.equals("") || passwordStr.equals("")) {
                    Toast.makeText(LoginActivity.this, "用户名密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("username", usernameStr);
                        jsonObject.put("password", passwordStr);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String url = "http://192.168.1.103:8085/user/login";
                    RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {
                            try {
                                Log.d("信心", jsonObject.toString());
                                String msg = jsonObject.getString("msg");
                                Log.d("msg", msg);
                                if (msg.equals("登录成功")) {

                                    JSONObject detail = jsonObject.getJSONObject("detail");
                                    String username = detail.getString("username");
                                    String phone = detail.getString("phone");

                                    sharedPreferences=getSharedPreferences("data",Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("username",username);
                                    editor.putString("phone",phone);
                                    editor.commit();



                                    Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                                    intent.putExtra("username", username);
                                    intent.putExtra("phone", phone);
                                    startActivity(intent);
                                } else if (msg.equals("用户名或密码错误")) {
                                    Toast.makeText(LoginActivity.this, "用户名密码有误", Toast.LENGTH_SHORT).show();
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {
                            Toast.makeText(LoginActivity.this, "网络出错", Toast.LENGTH_SHORT).show();
                        }
                    });
                    requestQueue.add(jsonObjectRequest);
                }

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegistActivity.class));
            }
        });


    }
}
