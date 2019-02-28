package com.tencent.mm.f.a;

import java.lang.ref.WeakReference;

public final class cm extends com.tencent.mm.sdk.b.b {
    public a frw;
    public b frx;

    public static final class a {
        public String appId;
        public String frA;
        public String frB;
        public WeakReference frC;
        public Runnable frD;
        public int frE = 0;
        public String fry;
        public String frz;
        public String nonceStr;
        public String packageExt;
        public String signType;
        public String signature;
        public String token;
    }

    public static final class b {
        public int retCode = 0;
    }

    public cm() {
        this((byte) 0);
    }

    private cm(byte b) {
        this.frw = new a();
        this.frx = new b();
        this.xmE = false;
        this.frD = null;
    }
}
