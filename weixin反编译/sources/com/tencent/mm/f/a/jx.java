package com.tencent.mm.f.a;

import java.util.LinkedList;

public final class jx extends com.tencent.mm.sdk.b.b {
    public a fBQ;
    public b fBR;

    public static final class a {
        public String chatroomName;
        public boolean fBE = false;
        public LinkedList<String> fBS;
        public int scene = 0;
    }

    public static final class b {
        public int errCode;
    }

    public jx() {
        this((byte) 0);
    }

    private jx(byte b) {
        this.fBQ = new a();
        this.fBR = new b();
        this.xmE = false;
        this.frD = null;
    }
}
