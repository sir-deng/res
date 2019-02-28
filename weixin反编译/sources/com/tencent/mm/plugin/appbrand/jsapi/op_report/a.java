package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.mm.plugin.appbrand.jsapi.f;

final class a extends f {
    private static final int CTRL_INDEX = 246;
    private static final String NAME = "onStartReportPageData";
    private static final a jsm = new a();

    a() {
    }

    static synchronized void sz(String str) {
        synchronized (a.class) {
            jsm.aA(str, 0).afI();
        }
    }
}
