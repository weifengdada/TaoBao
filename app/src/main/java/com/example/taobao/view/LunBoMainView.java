package com.example.taobao.view;

import com.example.taobao.bean.HomeBean;

/**
 * Created by acer on 2017/12/7.
 */

public interface LunBoMainView {
    public  void success(HomeBean bean);
    public void  failure(Exception e);
}
