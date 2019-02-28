package com.tencent.mm.plugin.radar.ui;

import com.tencent.mm.plugin.radar.b.e.a;

public final /* synthetic */ class e {
    public static final /* synthetic */ int[] pDt;
    public static final /* synthetic */ int[] pEz;

    static {
        int[] iArr = new int[a.values().length];
        pDt = iArr;
        iArr[a.UnSelected.ordinal()] = 1;
        pDt[a.Selected.ordinal()] = 2;
        iArr = new int[a.values().length];
        pEz = iArr;
        iArr[a.Selected.ordinal()] = 1;
        pEz[a.UnSelected.ordinal()] = 2;
    }
}
