package com.glc.itbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class RegistActivity extends AppCompatActivity {
private EditText edt_username;
private EditText edt_password;
private EditText edt_address;
private EditText edt_phone;
private Button goLogin;
private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        edt_username=findViewById(R.id.edt_register_username);
        edt_password=findViewById(R.id.edt_register_password);
        edt_address=findViewById(R.id.edt_register_address);
        edt_phone=findViewById(R.id.edt_register_phone);
        goLogin=findViewById(R.id.btn_goLogin);
        submit=findViewById(R.id.btn_submit);
        //透明状态栏          
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edt_username.getText().toString().trim();
                String password = edt_password.getText().toString().trim();
                String address = edt_address.getText().toString().trim();
                String phone = edt_phone.getText().toString().trim();
                if(username.equals("")||password.equals("")||address.equals("")||phone.equals("")){
                    Toast.makeText(RegistActivity.this, "请填写完整", Toast.LENGTH_SHORT).show();
                }else {
                    JSONObject jsonObject=new JSONObject();
                    try {
                        jsonObject.put("username",username);
                        jsonObject.put("password",password);
                        jsonObject.put("address",address);
                        jsonObject.put("phone",phone);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String url="http://192.168.1.103:8085/user/register";
                    RequestQueue requestQueue=Volley.newRequestQueue(RegistActivity.this);
                    JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, url,jsonObject, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {
                            try {
                                Log.d("注册信息", jsonObject.toString());
                                String msg = jsonObject.getString("msg");
                                Toast.makeText(RegistActivity.this, msg, Toast.LENGTH_SHORT).show();
                                if(msg.equals("注册成功")){
                                    JSONObject detail = jsonObject.getJSONObject("detail");
                                   final String username_login = detail.getString("username");
                                    goLogin.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(RegistActivity.this, LoginActivity.class);
                                           intent.putExtra("username1",username_login);
                                           startActivity(intent);
                                        }
                                    });
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {
                            Toast.makeText(RegistActivity.this, "网络出错", Toast.LENGTH_SHORT).show();
                        }
                    });
                    requestQueue.add(jsonObjectRequest);
                }
            }
        });

        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistActivity.this, LoginActivity.class));
            }
        });
    }
}
