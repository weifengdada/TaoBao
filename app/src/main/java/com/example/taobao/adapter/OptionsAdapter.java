package com.example.taobao.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.taobao.R;
import com.example.taobao.bean.OptionsBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

/**
 * Created by acer on 2017/12/9.
 */

public class OptionsAdapter extends BaseAdapter{
    Context context;
    ArrayList<OptionsBean> optionsList;
    public OptionsAdapter(Context context, ArrayList<OptionsBean> optionsList) {
        this.context=context;
        this.optionsList=optionsList;
    }

    @Override
    public int getCount() {
        return optionsList.size();
    }

    @Override
    public Object getItem(int position) {
        return optionsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView = View.inflate(context , R.layout.option_layout,null);
          holder=new ViewHolder();
          holder.simpleDraweeView= (SimpleDraweeView) convertView.findViewById(R.id.option_image);
          holder.textView= (TextView) convertView.findViewById(R.id.option_name);
          convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
       Uri uri = Uri.parse("res:// /" + optionsList.get(position).getId());
       holder.simpleDraweeView.setImageURI(uri);
        holder.textView.setText(optionsList.get(position).getName());
        return convertView;
    }

    class ViewHolder{
        SimpleDraweeView simpleDraweeView;
        TextView textView;
    }

}
