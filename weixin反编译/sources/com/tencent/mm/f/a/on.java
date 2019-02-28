package com.tencent.mm.f.a;

import java.lang.ref.WeakReference;

public final class on extends com.tencent.mm.sdk.b.b {
    public a fHl;
    public b fHm;

    public static final class a {
        public String fHn;
        public WeakReference frC;
        public Runnable frD;
        public int scene;
        public int type;
    }

    public static final class b {
        public int actionType;
        public String fHo;
        public String foE;
    }

    public on() {
        this((byte) 0);
    }

    private on(byte b) {
        this.fHl = new a();
        this.fHm = new b();
        this.xmE = false;
        this.frD = null;
    }
}
