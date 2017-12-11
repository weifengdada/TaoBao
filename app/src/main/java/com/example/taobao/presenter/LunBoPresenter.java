package com.example.taobao.presenter;

import com.example.taobao.bean.HomeBean;
import com.example.taobao.model.LunBoModel;
import com.example.taobao.model.LunBoModelCallBack;
import com.example.taobao.view.LunBoMainView;

/**
 * Created by acer on 2017/12/8.
 */

public class LunBoPresenter {

    LunBoMainView lunBoMainView;
    LunBoModel lunBoModel;
    public LunBoPresenter(LunBoMainView lunBoMainView) {
        this.lunBoMainView=lunBoMainView;
        this.lunBoModel=new LunBoModel();

    }
    public void get(){
     lunBoModel.getData(new LunBoModelCallBack() {
         @Override
         public void success(HomeBean bean) {
             if(lunBoMainView!=null){
                 lunBoMainView.success(bean);
             }
         }

         @Override
         public void failure(Exception e) {
             if(lunBoMainView!=null){
                 lunBoMainView.failure(e);
             }
         }
     });

    }
}
