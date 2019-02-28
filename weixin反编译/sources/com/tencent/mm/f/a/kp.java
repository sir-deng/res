package com.tencent.mm.f.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vp;
import java.util.ArrayList;

public final class kp extends com.tencent.mm.sdk.b.b {
    public a fCH;
    public b fCI;

    public static final class a {
        public Context context;
        public String fCJ;
        public String fCK;
        public boolean fCL = false;
        public Bundle fCM;
        public int fCN = 0;
        public int fCO = 0;
        public ArrayList fCP;
        public boolean fCQ = true;
        public vp fCR;
        public vn field_favProto;
        public long field_localId = 0;
        public String path;
        public int type = 0;
    }

    public static final class b {
        public String path;
        public int ret = 0;
    }

    public kp() {
        this((byte) 0);
    }

    private kp(byte b) {
        this.fCH = new a();
        this.fCI = new b();
        this.xmE = false;
        this.frD = null;
    }
}
