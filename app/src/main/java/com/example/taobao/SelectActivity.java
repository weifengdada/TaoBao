package com.example.taobao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.taobao.fragment.Fragment1;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectActivity extends AppCompatActivity {

    @BindView(R.id.fanhuishouye)
    ImageView fanhuishouye;
    @BindView(R.id.select_goods)
    ImageView selectGoods;
    @BindView(R.id.edit_select)
    EditText editSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.fanhuishouye, R.id.select_goods})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fanhuishouye:
                finish();
                break;
            case R.id.select_goods:
                String sel = editSelect.getText().toString();

                break;
        }
    }
}
