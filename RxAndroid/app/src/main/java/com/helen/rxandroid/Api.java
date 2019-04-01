package com.helen.rxandroid;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    public static final int CONNECT_TIME_OUT = 1024 * 7;
    public static final int READ_TIME_OUT = 1024 * 7;
    /**
     * 设缓存有效期为两天
     */
    private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 2;
    private final Interceptor mRewriteCacheControlInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            String cacheControl = request.cacheControl().toString();
            if (!BaseApplication.isNetConnected()) {
                request.newBuilder().cacheControl(TextUtils.isEmpty(cacheControl) ? CacheControl
                        .FORCE_NETWORK : CacheControl.FORCE_CACHE).build();
            }
            Response originalResponse = chain.proceed(request);
            if (BaseApplication.isNetConnected()) {
                return originalResponse.newBuilder().header("Cache-Control", cacheControl)
                        .removeHeader("Pragma").build();
            } else {
                return originalResponse.newBuilder().header("Cache-Control", "public," +
                        "only-if-cached," +
                        "max-stale=" + CACHE_STALE_SEC).removeHeader("Pragma").build();
            }
        }
    };
    private final OkHttpClient httpClient;
    private final Retrofit retrofit;
    private final ApiService apiService;

    public Api() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        File cacheFile = new File(BaseApplication.getAppcontext().getCacheDir(), "cache");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100);//１００M
        Interceptor headerinterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request build = chain.request().newBuilder().addHeader("Content-Type",
                        "application/json").build();
                return chain.proceed(build);
            }
        };
        httpClient = new OkHttpClient.Builder()
                .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .addInterceptor(mRewriteCacheControlInterceptor)
                .addNetworkInterceptor(mRewriteCacheControlInterceptor)
                .addInterceptor(headerinterceptor)
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").serializeNulls()
                .create();
        retrofit = new Retrofit.Builder()
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("")
                .build();
        apiService = retrofit.create(ApiService.class);
    }
}
