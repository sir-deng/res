package com.tencent.mm.f.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.b.b;

public final class kk extends b {
    public a fCB;

    public static final class a {
        public Context context;
        public e fCC;
        public String group;
        public Intent intent;
        public int type = 0;
    }

    public kk() {
        this((byte) 0);
    }

    private kk(byte b) {
        this.fCB = new a();
        this.xmE = false;
        this.frD = null;
    }
}
