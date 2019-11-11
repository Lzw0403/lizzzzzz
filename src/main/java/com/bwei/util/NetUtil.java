package com.bwei.util;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bwei.app.MyApp;
import com.bwei.contract.IContract;
import com.bwei.lzw20191111.MainActivity;

import java.util.Map;

/*
 *@auther:李泽炜
 *@Date: 2019/11/11
 *@Time:9:15
 *@Description:${DESCRIPTION}
 **/public class NetUtil {
    //声明单例
    private static NetUtil netUtil;
    private final RequestQueue queue;

    //构造函数
    private NetUtil() {
        queue = Volley.newRequestQueue(MyApp.context);
    }

    public static NetUtil getInstance(){
        if (netUtil==null){
            netUtil = new NetUtil();
        }
            return netUtil;
    }
    //get请求
    public void toGet(String url, final IContract.CallBack callBack){
        final StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.error(error.getMessage());
            }
        });
        queue.add(request);
    }
    //post请求
    public void toPost(String url, final Map<String,String> map , final IContract.CallBack callBack){
        final StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.error(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
        queue.add(request);
    }
}
