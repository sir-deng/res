package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

public final class f {
    public final String aBD;
    public final String appId;
    public final Exception exception;
    public final String fNc;
    public final String fNd;
    public final int fNe;
    public final long fNf;
    public final String filePath;
    public final String url;
    public final String version;

    public f(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, long j, Exception exception) {
        this.url = str;
        this.filePath = str2;
        this.version = str3;
        this.appId = str4;
        this.fNc = str5;
        this.fNd = str6;
        this.fNe = i;
        this.aBD = str7;
        this.fNf = j;
        this.exception = exception;
    }

    public final String toString() {
        return "WebViewCacheResponseWrapper{url='" + this.url + '\'' + ", filePath='" + this.filePath + '\'' + ", version='" + this.version + '\'' + ", appId='" + this.appId + '\'' + ", domain='" + this.fNc + '\'' + ", packageId='" + this.fNd + '\'' + ", cacheType=" + this.fNe + ", contentType='" + this.aBD + '\'' + ", contentLength=" + this.fNf + ", exception=" + this.exception + '}';
    }
}
