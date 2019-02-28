package com.tencent.mm.pluginsdk.i.a.d;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.pluginsdk.i.a.d.f.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class k implements b {
    private final String filePath;
    private final String groupId;
    protected volatile int jZl = 15000;
    private final String method;
    final int networkType;
    final int priority;
    protected final Map<String, String> requestHeaders = new HashMap();
    public final String url;
    public final String vmK;
    final int vmU;
    private final String vof;
    protected volatile int vov = HardCoderJNI.sHCENCODEVIDEOTIMEOUT;
    protected volatile int vow = 15000;

    public k(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3) {
        this.vmK = str;
        this.filePath = str2;
        this.vof = str3;
        this.groupId = str4;
        this.url = str5;
        this.method = str6;
        this.vmU = i;
        this.networkType = i2;
        this.priority = Math.max(i3, 0);
    }

    public boolean caa() {
        return false;
    }

    public String aam() {
        return this.groupId;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public final String bZW() {
        return this.vmK;
    }

    public final Map<String, String> getRequestHeaders() {
        if (this.requestHeaders.size() == 0) {
            return null;
        }
        return Collections.unmodifiableMap(this.requestHeaders);
    }

    public final void setConnectTimeout(int i) {
        this.jZl = i;
    }

    public final int getConnectTimeout() {
        return this.jZl;
    }

    public final void setReadTimeout(int i) {
        this.vov = i;
    }

    public final int getReadTimeout() {
        return this.vov;
    }

    public final int cal() {
        return this.vow;
    }
}
