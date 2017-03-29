package com.yunifang.my.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yunifang.my.R;
import com.yunifang.my.act.SetActivity;
import com.yunifang.my.basic.BaseFragment;

/**
 * Created by lenovo on 2017/3/17.
 */

public class MyFragment extends BaseFragment {

    private View view;
    private ImageView set;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my, null);
        set = (ImageView) view.findViewById(R.id.set);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), SetActivity.class);
                startActivity(it);
            }
        });
    }
}
