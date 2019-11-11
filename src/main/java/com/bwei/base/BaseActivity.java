package com.bwei.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/*
 *@auther:李泽炜
 *@Date: 2019/11/11
 *@Time:9:00
 *@Description:
 **/
    //抽取基类
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    public P p ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        p = initPresenter();
        if (p!=null){
            p.Success(this);
        }
        initData();
        initView();
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract P initPresenter();

    protected abstract int initLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (p!=null){
            p.unSuccess();
            p=null;
        }
    }
}
