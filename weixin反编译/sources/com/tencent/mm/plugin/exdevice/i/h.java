package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.f;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends ae {
    private f lPY;
    private a lWO;

    public h(f fVar) {
        this.lPY = fVar;
    }

    public final boolean a(m mVar, d dVar) {
        this.lWO = new a(this.lPY, dVar);
        x.i("MicroMsg.exdevice.MMSendDataToDeviceExcuter", "send data to devide : %b", Boolean.valueOf(this.lWO.b(mVar)));
        return this.lWO.b(mVar);
    }
}
