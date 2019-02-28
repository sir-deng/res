package com.tencent.mm.f.a;

import com.tencent.mm.protocal.c.aor;
import java.util.List;

public final class jz extends com.tencent.mm.sdk.b.b {
    public a fBV;
    public b fBW;

    public static final class a {
        public float fAo = 0.0f;
        public boolean fBE = false;
        public float fBX = 0.0f;
        public int fBY = 0;
        public int fBZ = 0;
        public String fCa;
        public String fCb;
        public int fvo = 0;
    }

    public static final class b {
        public boolean fCc = false;
        public List<aor> fCd;
        public int fCe = -1;
        public int fvo = 0;
    }

    public jz() {
        this((byte) 0);
    }

    private jz(byte b) {
        this.fBV = new a();
        this.fBW = new b();
        this.xmE = false;
        this.frD = null;
    }
}
