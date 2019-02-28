package com.tencent.mm.plugin.appbrand.j;

import com.tencent.mm.plugin.appbrand.j.f.a;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class g {
    public volatile boolean bgH = false;
    int jGZ;
    Map<String, String> jHd;
    ArrayList<String> jHe;
    int jHf = 15;
    HttpURLConnection jHh = null;
    String jHi;
    String jHn;
    Map<String, String> jHo;
    a jHp;
    String jeC;
    String mFileName;
    String mMimeType;
    String mName;
    String mUrl;
    private long startTime;

    g(String str, String str2, String str3, String str4, int i, String str5, a aVar) {
        this.jHn = str;
        this.mUrl = str2;
        this.jHp = aVar;
        this.mName = str3;
        this.mFileName = str4;
        this.jGZ = i;
        this.mMimeType = str5;
        this.startTime = System.currentTimeMillis();
    }

    public final int ajf() {
        return (int) (System.currentTimeMillis() - this.startTime);
    }
}
