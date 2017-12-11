package com.example.taobao.model;

import com.example.taobao.bean.HomeBean;
import com.example.taobao.okhttp.AbstractUiCallBack;
import com.example.taobao.okhttp.OkhttpUtils;

/**
 * Created by acer on 2017/12/7.
 */

public class LunBoModel {

       public void getData(final LunBoModelCallBack lunBoModelCallBack){

         OkhttpUtils.getInstance().asy(null, "http://120.27.23.105/ad/getAd", new AbstractUiCallBack<HomeBean>() {
             @Override
             public void success(HomeBean bean) {

                 lunBoModelCallBack.success(bean);
             }

             @Override
             public void failure(Exception e) {
                 lunBoModelCallBack.failure(new Exception(""));
             }
         });




       }



}
