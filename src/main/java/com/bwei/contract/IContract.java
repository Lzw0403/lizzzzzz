package com.bwei.contract;

import com.bwei.bean.MyBean;

/*
 *@auther:李泽炜
 *@Date: 2019/11/11
 *@Time:9:10
 *@Description:${DESCRIPTION}
 **/public interface IContract {
    //接口
        interface CallBack{
            void success(String jsonstr);
            void error(String err);
        }
        interface IPresenter{
            void success(String url);
        }
        interface IView{
            void success(MyBean myBean);
        }
}
