package com.tencent.mm.f.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public final class ir extends com.tencent.mm.sdk.b.b {
    public a fzV;
    public b fzW;

    public static final class b {
        public boolean fzZ;
    }

    public static final class a {
        public String appId;
        public Context context;
        public Bundle frc;
        public WXMediaMessage fzX;
        public com.tencent.mm.pluginsdk.model.app.g.a fzY;
        public int showType;
    }

    public ir() {
        this((byte) 0);
    }

    private ir(byte b) {
        this.fzV = new a();
        this.fzW = new b();
        this.xmE = false;
        this.frD = null;
    }
}
