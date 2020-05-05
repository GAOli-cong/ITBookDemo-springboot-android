package com.glc.itbook.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.glc.itbook.AddActivity;
import com.glc.itbook.R;
import com.glc.itbook.UpdateActity;

public class Fragment_dongtai extends Fragment {
private LinearLayout addBook;
private LinearLayout updateBook;
 private String username;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dongtai,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addBook=view.findViewById(R.id.ly_addBook);
        updateBook=view.findViewById(R.id.ly_updateBook);

         username = getArguments().getString("username");

        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), AddActivity.class));
            }
        });

        updateBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.equals("admin")){
                    startActivity(new Intent(getActivity(), UpdateActity.class));

                }else {
                    Toast.makeText(getActivity(), "对不起您未有该权限，请联系管理员", Toast.LENGTH_SHORT).show();


                }
            }
        });
    }
}
