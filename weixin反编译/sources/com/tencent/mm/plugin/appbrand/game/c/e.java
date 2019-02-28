package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.mm.sdk.platformtools.al;

public final class e {
    String appId;
    int fJh;
    int foh;
    public al ind;
    public int jbZ;
    int jca;
    int jcb;

    private enum a {
        FPS(1),
        CPU(2),
        MEM(3),
        DRAW_CALL(4),
        TRIANGLE(5),
        VERTEX(6),
        NATIVE_MEM(101),
        DALVIK_MEM(102),
        OTHER_MEM(103),
        MEM_DELTA(104);
        
        int jcn;

        private a(int i) {
            this.jcn = i;
        }
    }

    public e(String str, int i) {
        this.jbZ = Math.max(1, i);
        this.appId = str;
        com.tencent.mm.plugin.appbrand.e pi = com.tencent.mm.plugin.appbrand.a.pi(str);
        if (pi != null && pi.isS != null) {
            this.fJh = pi.isS.iRU.iJb;
            this.foh = pi.isS.iRU.iJa + 1;
        }
    }
}
