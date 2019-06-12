package com.example.mjie_.android_day07testa1.model;

import com.example.mjie_.android_day07testa1.api.MyServer;
import com.example.mjie_.android_day07testa1.bean.Objects;
import com.example.mjie_.android_day07testa1.callback.CallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImpMymodel implements Mymodel {
    @Override
    public void getData(final CallBack callBack) {

        new Retrofit.Builder()
                .baseUrl(MyServer.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyServer.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Objects>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Objects objects) {
                        if (objects != null) {
                            callBack.onOk(objects);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onNo(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
