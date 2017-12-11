package com.example.taobao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.taobao.R;
import com.example.taobao.bean.HomeBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by acer on 2017/12/9.
 */

public class ShouyeGoodsAdapter extends RecyclerView.Adapter<ShouyeGoodsAdapter.GoodViewHolder> {
    Context context;
    List<HomeBean.TuijianBean.ListBean> goodsList;
    public ShouyeGoodsAdapter(Context context, List<HomeBean.TuijianBean.ListBean> goodsList) {
        this.context=context;
        this.goodsList=goodsList;
    }


    @Override
    public GoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.good_layout, parent, false);

        return new GoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GoodViewHolder holder, int position) {
        String images = goodsList.get(position).getImages();
        String[] imagesList = images.split("\\|");
        holder.goodSimpledraweeview.setImageURI(imagesList[0]);
        holder.goodName.setText(goodsList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return goodsList == null ? 0 : goodsList.size();
    }

    static class GoodViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.good_simpledraweeview)
        SimpleDraweeView goodSimpledraweeview;
        @BindView(R.id.good_name)
        TextView goodName;
        GoodViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}
