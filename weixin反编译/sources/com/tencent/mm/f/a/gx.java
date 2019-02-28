package com.tencent.mm.f.a;

import android.content.Context;
import android.os.Bundle;

public final class gx extends com.tencent.mm.sdk.b.b {
    public a fxW;
    public b fxX;

    public static final class a {
        public int actionCode;
        public Context context;
        public Bundle fxY;
        public String result;
        public String username;
    }

    public static final class b {
        public int ret = 0;
    }

    public gx() {
        this((byte) 0);
    }

    private gx(byte b) {
        this.fxW = new a();
        this.fxX = new b();
        this.xmE = false;
        this.frD = null;
    }
}
