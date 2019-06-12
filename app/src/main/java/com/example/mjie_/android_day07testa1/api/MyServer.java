package com.example.mjie_.android_day07testa1.api;

import com.example.mjie_.android_day07testa1.bean.Objects;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

public interface MyServer {
    String url = "https://api.yunxuekeji.cn/yunxue_app_api/";

    @POST("course/getCourseByTypeAndMore?orderOn=&classtype=031001004&forPeopleType=&format=&price=&pageIndex=1&pageSize=10&classTag=")
   //@FormUrlEncoded
    Observable<Objects> getData();
}
