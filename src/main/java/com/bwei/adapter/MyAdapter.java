package com.bwei.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bwei.bean.MyBean;
import com.bwei.lzw20191111.R;

import java.util.List;

/*
 *@auther:李泽炜
 *@Date: 2019/11/11
 *@Time:9:58
 *@Description:${DESCRIPTION}
 **/public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<MyBean.DataBean.GridDataBean> glist;
    Context context;

    public MyAdapter(List<MyBean.DataBean.GridDataBean> glist, Context context) {
        this.glist = glist;
        this.context = context;
    }
    //布局
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder holder = null;
        switch (i){
            case 1:
                View view = LayoutInflater.from(context).inflate(R.layout.one_layout,null);
                holder = new oneHolder(view);
                break;
            case 2:
                View view1 = LayoutInflater.from(context).inflate(R.layout.two_layout,null);
                holder = new oneHolder(view1);
                break;
            case 3:
                View view2 = LayoutInflater.from(context).inflate(R.layout.three_layout,null);
                holder = new oneHolder(view2);
                break;
                default:
                    break;
        }
        return holder;
    }
    //赋值
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof oneHolder){
            Glide.with(context).load(glist.get(i)
                    .getImageurl())
                    .error(R.mipmap.ic_launcher)
                    .priority(Priority.HIGH)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .into(((oneHolder) viewHolder).imageView);

        }else if (viewHolder instanceof  twoHolder){
            Glide.with(context).load(glist.get(i)
                    .getImageurl())
                    .error(R.mipmap.ic_launcher)
                    .priority(Priority.HIGH)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .into(((twoHolder) viewHolder).imageView);
            ((twoHolder) viewHolder).textView.setText(glist.get(i).getTitle());
        }else if (viewHolder instanceof threeHolder){
            Glide.with(context).load(glist.get(i)
                    .getImageurl())
                    .error(R.mipmap.ic_launcher)
                    .priority(Priority.HIGH)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .into(((threeHolder) viewHolder).imageView);
            ((threeHolder) viewHolder).textView.setText(glist.get(i).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return glist.size();

    }
    public class oneHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public oneHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.one);
        }
    }
    public class twoHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public twoHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.two);
            textView = itemView.findViewById(R.id.te_one);
        }
    }
    public class threeHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public threeHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.three);
            textView = itemView.findViewById(R.id.te_two);
        }
    }
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
