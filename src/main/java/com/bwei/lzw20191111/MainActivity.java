package com.bwei.lzw20191111;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bwei.adapter.MyAdapter;
import com.bwei.api.Api;
import com.bwei.base.BaseActivity;
import com.bwei.base.BasePresenter;
import com.bwei.bean.MyBean;
import com.bwei.contract.IContract;
import com.bwei.presenter.MyPresenter;

import java.util.List;

public class MainActivity extends BaseActivity implements IContract.IView {
    private RecyclerView re_view;
    @Override
    protected void initView() {
        re_view = findViewById(R.id.re_view);
        re_view.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initData() {
        MyPresenter myPresenter = (MyPresenter) p;
        myPresenter.success(Api.url());
    }

    @Override
    protected BasePresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void success(MyBean myBean) {
        Log.i("aaa", "success: "+myBean);
        //结合
        List<MyBean.DataBean.GridDataBean> gData = myBean.getData().getGridData();
        //设置适配器
        MyAdapter myAdapter = new MyAdapter(gData, MainActivity.this);
        re_view.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }
}
