package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.p;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import junit.framework.Assert;

public class a implements c {
    private long lVx = -1;
    protected c lWE = null;
    protected d lWF = null;
    private m lWG = null;

    public a(c cVar, d dVar) {
        this.lWE = cVar;
        this.lWF = dVar;
    }

    public final void a(d dVar) {
        this.lWF = dVar;
    }

    public final boolean b(m mVar) {
        if (mVar == null) {
            x.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher is null");
            return false;
        } else if (this.lWG != null) {
            x.e("MicroMsg.exdevice.ExDeviceTask", "Prev task is still working!!!");
            return false;
        } else {
            x.i("MicroMsg.exdevice.ExDeviceTask", "------startTask begin------cmdReqId = %d, cmdRespId = %d, deviceId = %d", Short.valueOf(this.lWE.aEn()), Short.valueOf(this.lWE.lPL), Long.valueOf(this.lWE.kGc));
            p mVar2 = new m(this.lWE, this);
            long a = mVar.a(mVar2);
            if (-1 == a) {
                x.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher.startTask Failed!!!");
                return false;
            }
            this.lWG = mVar2;
            this.lVx = a;
            m mVar3 = this.lWG;
            Assert.assertNotNull(mVar3.lXb);
            l lVar = mVar3.lXb;
            lVar.lWU = false;
            lVar.lWV = false;
            as.Dt().cgs().postDelayed(lVar.lWW, 15000);
            return true;
        }
    }

    public final void a(long j, int i, int i2, String str, p pVar) {
        int i3 = 1;
        x.i("MicroMsg.exdevice.ExDeviceTask", "------onTaskEnd------ taskId = %d, errType = %d, errCode = %d, errMsg = %s, deviceId = %d, reqCmdId = %d, respCmdId = %d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(this.lWE.kGc), Short.valueOf(this.lWE.aEn()), Short.valueOf(this.lWE.lPL));
        com.tencent.mm.plugin.exdevice.g.a.l(this.lWE.kGc, i == 0 ? 1 : 0);
        if (pVar == null || pVar == this.lWG) {
            if (-1 == i && -2 == i2) {
                x.e("MicroMsg.exdevice.ExDeviceTask", "Time Out in local!!!");
            }
            int i4 = this.lWE.lPM != null ? this.lWE.lPM.lUc : 0;
            if (-5 == i4 || -3 == i4 || -4 == i4) {
                x.w("MicroMsg.exdevice.ExDeviceTask", "ErrorCode = %d, destroy channel(deviceId = %d)", Integer.valueOf(this.lWE.lPM.lUc), Long.valueOf(this.lWE.kGc));
                if (u.aFt().lQh == null || !u.aFt().lQh.cG(this.lWE.kGc)) {
                    i3 = 0;
                }
                if (i3 == 0) {
                    x.e("MicroMsg.exdevice.ExDeviceTask", "stopChannel Failed!!!");
                }
            }
            if (this.lWF != null) {
                this.lWF.a(j, i, i2, str);
            }
            this.lWG = null;
            return;
        }
        x.e("MicroMsg.exdevice.ExDeviceTask", "netCmd != mRemoteTask");
    }
}
