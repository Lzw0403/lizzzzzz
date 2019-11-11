package com.bwei.app;

import android.app.Application;
import android.content.Context;

/*
 *@auther:李泽炜
 *@Date: 2019/11/11
 *@Time:9:24
 *@Description:${DESCRIPTION}
 **/public class MyApp extends Application {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}




