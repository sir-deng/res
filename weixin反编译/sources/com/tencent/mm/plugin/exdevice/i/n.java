package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.service.o.a;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class n extends a {
    private c lWE = null;

    public n(c cVar) {
        Assert.assertNotNull(cVar);
        this.lWE = cVar;
    }

    public final long aFk() {
        x.i("MicroMsg.exdevice.RemoteExDeviceTaskRequest", "getDeviceId : " + this.lWE.kGc);
        return this.lWE.kGc;
    }

    public final byte[] aFl() {
        return this.lWE.aEp();
    }

    public final int aFm() {
        return this.lWE.aEn();
    }

    public final int aFn() {
        return this.lWE.lPL;
    }

    public final int aFo() {
        return this.lWE.aEo();
    }
}
