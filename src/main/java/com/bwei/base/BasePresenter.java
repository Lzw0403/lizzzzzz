package com.bwei.base;

import com.bwei.lzw20191111.MainActivity;

/*
 *@auther:李泽炜
 *@Date: 2019/11/11
 *@Time:9:02
 *@Description:${DESCRIPTION}
 **/public class BasePresenter<V extends BaseActivity> {
    public V v;
    public void Success(V v){
        this.v =v;
    }
    public void unSuccess(){
        if (v!=null){
            v=null;
        }
    }
}
