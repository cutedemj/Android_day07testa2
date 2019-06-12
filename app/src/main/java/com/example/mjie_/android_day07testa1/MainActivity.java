package com.example.mjie_.android_day07testa1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.mjie_.android_day07testa1.adapter.MainRecycAdapter;
import com.example.mjie_.android_day07testa1.bean.Objects;
import com.example.mjie_.android_day07testa1.model.ImpMymodel;
import com.example.mjie_.android_day07testa1.presenter.ImpMypresenter;
import com.example.mjie_.android_day07testa1.views.Myview;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Myview {

    private RecyclerView mMainRecyc;
    private ArrayList<Objects.BodyBean.ResultBean.DataBean> beans;
    private MainRecycAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mMainRecyc = (RecyclerView) findViewById(R.id.main_recyc);
        mMainRecyc.setLayoutManager(new LinearLayoutManager(this));
        beans = new ArrayList<>();
        adapter = new MainRecycAdapter(this, beans);
        mMainRecyc.setAdapter(adapter);
        ImpMypresenter mypresenter = new ImpMypresenter(new ImpMymodel(), this);
        mypresenter.getData();
    }

    @Override
    public void onOk(Objects objects) {
        if (objects != null) {
            List<Objects.BodyBean.ResultBean.DataBean> data = objects.getBody().getResult().getData();
            beans.addAll(data);
            Log.e("TAG", "onNo::自条目数量" + beans.size());

            adapter.notifyDataSetChanged();
            adapter.setMyOnCLick(new MainRecycAdapter.MyOnCLick() {
                @Override
                public void myonc(int post) {
                    int id = beans.get(post).getID();
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                }
            });
        } else {
            Toast.makeText(this, "数据为空", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNo(String error) {
        Log.e("TAG", "onNo::" + error);
    }
}
