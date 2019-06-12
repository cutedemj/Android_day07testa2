package com.example.mjie_.android_day07testa1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mjie_.android_day07testa1.R;
import com.example.mjie_.android_day07testa1.bean.Objects;

import java.util.ArrayList;

public class MainRecycAdapter extends RecyclerView.Adapter<MainRecycAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Objects.BodyBean.ResultBean.DataBean> list;

    public MainRecycAdapter(Context context, ArrayList<Objects.BodyBean.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);
        MyViewHolder holder = new MyViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.item_name.setText(list.get(position).getClassRecommend());
        Glide.with(context).load(list.get(position).getClassCoverPic()).into(holder.item_img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myOnCLick != null) {
                    myOnCLick.myonc(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView item_img;
        private TextView item_name;

        public MyViewHolder(View itemView) {
            super(itemView);
            item_img = itemView.findViewById(R.id.item_img);
            item_name = itemView.findViewById(R.id.item_name);

        }
    }

    public interface MyOnCLick {
        void myonc(int post);
    }

    private MyOnCLick myOnCLick;

    public void setMyOnCLick(MyOnCLick myOnCLick) {
        this.myOnCLick = myOnCLick;
    }
}
