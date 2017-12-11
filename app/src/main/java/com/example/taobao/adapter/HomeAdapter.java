package com.example.taobao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ViewFlipper;

import com.example.taobao.GlideImageLoader;
import com.example.taobao.R;
import com.example.taobao.bean.HomeBean;
import com.example.taobao.bean.OptionsBean;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by acer on 2017/12/7.
 */

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<String> lunboList;
    //自定义四个条目的名字
    private static final int BANNER = 0;
    private static final int OPTIONS = 1;
    private static final int PAOMADENG = 2;
    private static final int GOODS = 3;
    HomeBean bean;

    public HomeAdapter(Context context, HomeBean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        } else {
            return 3;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == BANNER) {
            View view = LayoutInflater.from(context).inflate(R.layout.lunbobanner, parent, false);
            return new BannerViewHolder(view);
        } else if (viewType == OPTIONS) {
            View view = LayoutInflater.from(context).inflate(R.layout.options_layout, parent, false);
            return new OptionsViewHolder(view);
        } else if (viewType == PAOMADENG) {
            View view = LayoutInflater.from(context).inflate(R.layout.paomadengs_layout, parent, false);
            return new PaoMaDengViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.goods_layout, parent, false);
            return new GoodsViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BannerViewHolder) {
            List<HomeBean.DataBean> list = bean.getData();
            ArrayList<String> imageList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                imageList.add(list.get(i).getIcon());
            }

            ((BannerViewHolder) holder).banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
            ((BannerViewHolder) holder).banner.setImageLoader(new GlideImageLoader());
            ((BannerViewHolder) holder).banner.setImages(imageList);
            ((BannerViewHolder) holder).banner.setBannerAnimation(Transformer.Default);
            ((BannerViewHolder) holder).banner.isAutoPlay(true);
            ((BannerViewHolder) holder).banner.setDelayTime(3000);
            ((BannerViewHolder) holder).banner.setIndicatorGravity(BannerConfig.CENTER);
            ((BannerViewHolder) holder).banner.start();
        }
        if (holder instanceof OptionsViewHolder) {
            ArrayList<OptionsBean> optionsList = new ArrayList<>();
            optionsList.add(new OptionsBean(R.drawable.g1, "天猫"));
            optionsList.add(new OptionsBean(R.drawable.g2, "聚划算"));
            optionsList.add(new OptionsBean(R.drawable.g3, "天猫国际"));
            optionsList.add(new OptionsBean(R.drawable.g4, "淘点点"));
            optionsList.add(new OptionsBean(R.drawable.g5, "天猫超市"));
            optionsList.add(new OptionsBean(R.drawable.g6, "充值中心"));
            optionsList.add(new OptionsBean(R.drawable.g7, "飞猪旅行"));
            optionsList.add(new OptionsBean(R.drawable.g8, "领金币"));
            optionsList.add(new OptionsBean(R.drawable.g9, "到家"));
            optionsList.add(new OptionsBean(R.drawable.g10, "分类"));
            OptionsAdapter optionsAdapter = new OptionsAdapter(context, optionsList);
            ((OptionsViewHolder) holder).gridview.setAdapter(optionsAdapter);
        }
        if (holder instanceof PaoMaDengViewHolder) {
           ((PaoMaDengViewHolder) holder).vf.addView(View.inflate(context, R.layout.item_paomadeng, null));

        }
        if (holder instanceof GoodsViewHolder) {

            List<HomeBean.TuijianBean.ListBean> goodsList = bean.getTuijian().getList();
            ((GoodsViewHolder) holder).goodsRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            ((GoodsViewHolder) holder).goodsRecyclerview.setAdapter(new ShouyeGoodsAdapter(context, goodsList));

        }

    }


    @Override
    public int getItemCount() {
        return 4;
    }

    static class BannerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.lunboBanner)
        Banner banner;

        BannerViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class OptionsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.gridview)
        GridView gridview;

        OptionsViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class GoodsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.goods_recyclerview)
        RecyclerView goodsRecyclerview;

        GoodsViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class PaoMaDengViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.vf)
        ViewFlipper vf;

        PaoMaDengViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
