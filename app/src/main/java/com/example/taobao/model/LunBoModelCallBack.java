package com.example.taobao.model;

import com.example.taobao.bean.HomeBean;

/**
 * Created by acer on 2017/12/7.
 */

public interface LunBoModelCallBack {
    public  void success(HomeBean bean);
    public void  failure(Exception e);
}
