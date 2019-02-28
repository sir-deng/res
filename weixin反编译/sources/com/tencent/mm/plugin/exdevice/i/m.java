package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.service.l;
import com.tencent.mm.plugin.exdevice.service.o;
import com.tencent.mm.plugin.exdevice.service.p.a;
import junit.framework.Assert;

public final class m extends a {
    private n lXa = null;
    l lXb = null;

    public m(c cVar, c cVar2) {
        Assert.assertNotNull(cVar);
        Assert.assertNotNull(cVar2);
        this.lXa = new n(cVar);
        this.lXb = new l(cVar2);
    }

    public final o aFp() {
        Assert.assertNotNull(this.lXa);
        return this.lXa;
    }

    public final l aFq() {
        Assert.assertNotNull(this.lXb);
        return this.lXb;
    }
}
