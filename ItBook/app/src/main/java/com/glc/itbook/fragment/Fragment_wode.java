package com.glc.itbook.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.glc.itbook.BanBenActivity;
import com.glc.itbook.LoginActivity;
import com.glc.itbook.R;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class Fragment_wode extends Fragment {

    private ImageView hBack;
    private ImageView hHead;
    private TextView muser_name;
    private TextView muser_val;
    private Button tuichu;

    private LinearLayout lyBanben;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_wode,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hBack=view.findViewById(R.id.h_back);
        hHead=view.findViewById(R.id.h_head);
        muser_name=view.findViewById(R.id.user_name);
        muser_val=view.findViewById(R.id.user_val);
        tuichu=view.findViewById(R.id.btn_tuichudenglu);
        lyBanben=view.findViewById(R.id.ly_banben);
        tuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });

        lyBanben.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), BanBenActivity.class));
            }
        });

        String username = getArguments().getString("username");
        muser_name.setText(username);
        String phone = getArguments().getString("phone").replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
        muser_val.setText(phone);

        Glide.with(getActivity()).load(R.drawable.admin).bitmapTransform(new BlurTransformation(getActivity(),25),new CenterCrop(getActivity()))
                .into(hBack);

        Glide.with(getActivity()).load(R.drawable.admin).bitmapTransform(new CropCircleTransformation(getActivity())).into(hHead);

    }
}
