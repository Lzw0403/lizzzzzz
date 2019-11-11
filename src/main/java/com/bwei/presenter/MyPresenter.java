package com.bwei.presenter;

import android.util.Log;

import com.bwei.base.BasePresenter;
import com.bwei.bean.MyBean;
import com.bwei.contract.IContract;
import com.bwei.lzw20191111.MainActivity;
import com.bwei.model.MyModel;
import com.google.gson.Gson;

/*
 *@auther:李泽炜
 *@Date: 2019/11/11
 *@Time:9:36
 *@Description:${DESCRIPTION}
 **/public class MyPresenter extends BasePresenter implements IContract.IPresenter {
        MyModel myModel;
    private MyBean myBean;

    public MyPresenter() {
        myModel = new MyModel();
    }

    @Override
    public void success(final String url) {
        myModel.getMoel(url, new IContract.CallBack() {
            @Override
            public void success(String jsonstr) {
                Log.i("aa", "success: "+jsonstr);
                Gson gson = new Gson();
                myBean = gson.fromJson(jsonstr, MyBean.class);
                MainActivity mainActivity = (MainActivity) v;
                mainActivity.success(myBean);
            }

            @Override
            public void error(String err) {

            }
        });
    }
}
