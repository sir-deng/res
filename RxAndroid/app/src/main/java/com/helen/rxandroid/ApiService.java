package com.helen.rxandroid;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("login")
    Observable<BaseResponse> login();
}
