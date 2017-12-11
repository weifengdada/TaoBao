package com.example.taobao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.taobao.R;
import com.example.taobao.SelectActivity;
import com.example.taobao.adapter.HomeAdapter;
import com.example.taobao.bean.HomeBean;
import com.example.taobao.presenter.LunBoPresenter;
import com.example.taobao.view.LunBoMainView;
import com.liaoinstan.springview.widget.SpringView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by acer on 2017/12/7.
 */

public class Fragment1 extends Fragment implements LunBoMainView {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    Unbinder unbinder;
    @BindView(R.id.springview)
    SpringView springview;
    @BindView(R.id.edit_sousuo)
    EditText editSousuo;
    private HomeAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LunBoPresenter lunBoPresenter = new LunBoPresenter(this);
        lunBoPresenter.get();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(manager);
        editSousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SelectActivity.class));
            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void success(HomeBean bean) {
        adapter = new HomeAdapter(getActivity(), bean);
        recyclerview.setAdapter(adapter);
    }

    @Override
    public void failure(Exception e) {

    }
}
