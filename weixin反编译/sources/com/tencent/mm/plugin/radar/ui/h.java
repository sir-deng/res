package com.tencent.mm.plugin.radar.ui;

import com.tencent.mm.plugin.radar.b.c.e;

public final /* synthetic */ class h {
    public static final /* synthetic */ int[] pDt;
    public static final /* synthetic */ int[] pEz;
    public static final /* synthetic */ int[] pFW;

    static {
        int[] iArr = new int[e.values().length];
        pDt = iArr;
        iArr[e.Stranger.ordinal()] = 1;
        pDt[e.NeedVerify.ordinal()] = 2;
        iArr = new int[com.tencent.mm.plugin.radar.b.e.e.values().length];
        pEz = iArr;
        iArr[com.tencent.mm.plugin.radar.b.e.e.SEARCHING.ordinal()] = 1;
        pEz[com.tencent.mm.plugin.radar.b.e.e.SEARCH_RETRUN.ordinal()] = 2;
        pEz[com.tencent.mm.plugin.radar.b.e.e.RALATIONCHAIN_RETRUN.ordinal()] = 3;
        iArr = new int[com.tencent.mm.plugin.radar.b.e.e.values().length];
        pFW = iArr;
        iArr[com.tencent.mm.plugin.radar.b.e.e.SEARCHING.ordinal()] = 1;
        pFW[com.tencent.mm.plugin.radar.b.e.e.SEARCH_RETRUN.ordinal()] = 2;
        pFW[com.tencent.mm.plugin.radar.b.e.e.RALATIONCHAIN.ordinal()] = 3;
        pFW[com.tencent.mm.plugin.radar.b.e.e.RALATIONCHAIN_RETRUN.ordinal()] = 4;
        pFW[com.tencent.mm.plugin.radar.b.e.e.CREATING_CHAT.ordinal()] = 5;
    }
}
