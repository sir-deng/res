package com.helen.mytest.api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {
    @GET("article/list/0/json")
    Observable<String> getTest(@Query("cid") String cid);
}
