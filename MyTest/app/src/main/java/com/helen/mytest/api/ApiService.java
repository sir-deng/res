package com.helen.mytest.api;

import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

public interface ApiService {
    @GET("article/list/0/json")
    Observable<String> getTest(@Query("cid") String cid);

    @FormUrlEncoded
    @POST
    Observable<?> postRequest(@Url String url, @FieldMap Map<String,Object> params);

    @FormUrlEncoded
    @PUT
    Observable<?> putRequest(@Url String url, @FieldMap Map<String,Object> params);

    @DELETE
    Observable<?> deleteRequest(@Url String url,@QueryMap Map<String,Object> params);

    @Streaming
    @GET
    Observable<?> downloadRequest(@Url String url,@QueryMap Map<String,Object> params);

    @Multipart
    @POST
    Observable<?> upLoad(@Url String url, @Part("description") MultipartBody.Part file);
}
