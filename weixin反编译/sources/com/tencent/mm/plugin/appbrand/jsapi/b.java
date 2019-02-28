package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public abstract class b {
    private String jeT;
    private Integer jeU;

    public b() {
        Assert.assertTrue("Must declare NAME and CTRL_INDEX in subclasses", true);
    }

    public final String getName() {
        if (bi.oN(this.jeT)) {
            try {
                this.jeT = (String) new c(this, "NAME", null).get();
            } catch (Throwable e) {
                x.e("MicroMsg.AppBrand.BaseJsApi", "getName exp = %s", bi.i(e));
            }
        }
        return this.jeT;
    }

    public final int afG() {
        return bi.a(afH(), -1);
    }

    private Integer afH() {
        if (this.jeU == null) {
            try {
                this.jeU = (Integer) new c(this, "CTRL_INDEX", null).get();
            } catch (Throwable e) {
                x.e("MicroMsg.AppBrand.BaseJsApi", "getCtrlIndex exp = %s", bi.i(e));
            }
        }
        return this.jeU;
    }
}
