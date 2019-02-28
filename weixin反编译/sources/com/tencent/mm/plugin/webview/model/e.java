package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.protocal.c.alv;
import com.tencent.mm.protocal.c.aob;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;
import java.util.List;

public final class e {
    public int tyr;
    public int tys;
    public int tyt;
    public final List<aob> tyu;
    public int tyv;
    public long tyw;

    private static final class a {
        private static final e tyx = new e();
    }

    /* synthetic */ e(byte b) {
        this();
    }

    private e() {
        this.tyr = 20480;
        this.tys = 30720;
        this.tyt = 51200;
        this.tyu = new LinkedList();
        this.tyv = 0;
        this.tyw = 0;
    }

    public static void cq(List<alv> list) {
        if (!bi.cC(list)) {
            for (alv alv : list) {
                f.bSq().typ.r(Integer.valueOf(alv.wzI), Long.valueOf(bi.Wx() + ((long) alv.wzJ)));
            }
            f.bSq().bRm();
        }
    }
}
