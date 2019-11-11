package com.bwei.model;

import com.bwei.contract.IContract;
import com.bwei.util.NetUtil;

/*
 *@auther:李泽炜
 *@Date: 2019/11/11
 *@Time:9:15
 *@Description:${DESCRIPTION}
 **/public class MyModel {
        public void getMoel(String url, IContract.CallBack callBack){
            NetUtil.getInstance().toGet(url,callBack);
        }
}
