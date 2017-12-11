package com.example.taobao;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.taobao.fragment.Fragment1;
import com.example.taobao.fragment.Fragment2;
import com.example.taobao.fragment.Fragment3;
import com.example.taobao.fragment.Fragment4;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.shouye)
    RadioButton shouye;
    @BindView(R.id.weitao)
    RadioButton weitao;
    @BindView(R.id.msgs)
    RadioButton msgs;
    @BindView(R.id.goodscar)
    RadioButton goodscar;
    @BindView(R.id.mine)
    RadioButton mine;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position) {

                    case 0:
                        fragment = new Fragment1();
                        break;
                    case 1:
                        fragment = new Fragment2();
                        break;
                    case 2:
                        fragment = new Fragment2();
                        break;
                    case 3:
                        fragment = new Fragment3();
                        break;
                    case 4:
                        fragment = new Fragment4();
                        break;
                    default:
                        break;


                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 5;
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radioGroup.check(radioGroup.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @OnClick({R.id.shouye, R.id.weitao, R.id.msgs, R.id.goodscar, R.id.mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shouye:
                viewPager.setCurrentItem(0,false);
                break;
            case R.id.weitao:
                viewPager.setCurrentItem(1,false);
                break;
            case R.id.msgs:
                viewPager.setCurrentItem(2,false);
                break;
            case R.id.goodscar:
                viewPager.setCurrentItem(3,false);
                break;
            case R.id.mine:
                viewPager.setCurrentItem(4,false);
                break;
        }
    }
}
