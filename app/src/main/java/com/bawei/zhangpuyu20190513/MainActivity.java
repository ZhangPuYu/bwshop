package com.bawei.zhangpuyu20190513;

import android.os.Bundle;
import android.widget.ListView;

import com.bawei.zhangpuyu20190513.adapter.ListAdapter;
import com.bawei.zhangpuyu20190513.base.BaseActivity;
import com.bawei.zhangpuyu20190513.bean.Bean;
import com.bawei.zhangpuyu20190513.util.NetUtil;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends BaseActivity {
    private String server_url = "https://code.aliyun.com/598254259/FristProject/raw/master/bw_list.txt";
    private ListView list_view;
    private ListAdapter listAdapter;

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        list_view = findViewById(R.id.list_view);
    }

    @Override
    protected void initData() {
        boolean time = NetUtil.getTime(MainActivity.this);
        if(time){
            NetUtil.getInstance().getAcyncTask(server_url, new NetUtil.CallBackTask() {
                @Override
                public void onError(int code, String msg) {

                }

                @Override
                public void onSuccess(String s) {
                    Gson gson = new Gson();
                    Bean bean = gson.fromJson(s, Bean.class);
                    List<Bean.ItemsBean> items = bean.getItems();
                    listAdapter = new ListAdapter(MainActivity.this,items);
                    list_view.setAdapter(listAdapter);
                }
            });
        }else{

        }

    }

    @Override
    protected void initListener() {

    }

}
