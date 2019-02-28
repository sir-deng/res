package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.b.h;
import com.tencent.mm.plugin.exdevice.h.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends a implements d {
    private final d lWH;

    public b(c cVar, d dVar) {
        super(cVar, dVar);
        a(this);
        this.lWH = dVar;
    }

    public final void a(long j, int i, int i2, String str) {
        x.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "onTaskSceneEnd, SwitchViewPush taskId = %d, errType = %d, errCode = %d, errMsg = %s", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (2 == ((h) this.lWE).aEr()) {
            x.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Switch view push has been sended to device, now try to check close strategy");
            com.tencent.mm.plugin.exdevice.h.b zL = ad.aER().zL(this.lWE.kGc);
            if (zL != null) {
                switch (zL.field_closeStrategy) {
                    case 1:
                        x.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, stop channel(device id = %d)", Integer.valueOf(zL.field_closeStrategy), Long.valueOf(this.lWE.kGc));
                        if (u.aFt().lQh != null) {
                            u.aFt().lQh.cG(this.lWE.kGc);
                            break;
                        }
                        break;
                    case 2:
                        x.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, Record it(%d) in the shut down device list", Integer.valueOf(zL.field_closeStrategy), Long.valueOf(this.lWE.kGc));
                        if (!a.z("shut_down_device", this.lWE.kGc)) {
                            x.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "MMExDeviceCore.getDeviceInfoManager().addShutDownDevice failed!!!");
                            break;
                        }
                        break;
                    default:
                        x.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Error close strategy(%d)", Integer.valueOf(zL.field_closeStrategy));
                        break;
                }
            }
            x.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "get hdinfo by mac failed!!!, Mac = %d", Long.valueOf(this.lWE.kGc));
            if (this.lWH != null) {
                this.lWH.a(j, i, i2, str);
                return;
            }
            return;
        }
        if (this.lWH != null) {
            this.lWH.a(j, i, i2, str);
        }
    }
}
