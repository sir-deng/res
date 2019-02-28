package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.e;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.d;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends ae {
    private e lWK;
    private a lWL;
    private int mErrorCode;

    public f(int i, long j, int i2, int i3, byte[] bArr) {
        this.lWK = new e(j, i2, i3, bArr);
        this.mErrorCode = i;
    }

    public final boolean a(m mVar, d dVar) {
        if (!u.aFs().cE(this.lWK.kGc)) {
            x.e("MicroMsg.exdevice.MMInitTaskExcuter", "This device send other cmd before do auth, device id = %d", Long.valueOf(this.lWK.kGc));
            this.lWK.a(-2, "", new byte[0], new byte[0], 0, 0);
            this.lWL = new a(this.lWK, dVar);
            x.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", Boolean.valueOf(this.lWL.b(mVar)));
            return this.lWL.b(mVar);
        } else if (-5 == this.mErrorCode || -3 == this.mErrorCode || -4 == this.mErrorCode) {
            x.e("MicroMsg.exdevice.MMInitTaskExcuter", "Error Code = %d, reply errorcode to device and close channel", Integer.valueOf(this.mErrorCode));
            this.lWK.a(-1, "", new byte[0], new byte[0], 0, 0);
            this.lWL = new a(this.lWK, dVar);
            x.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", Boolean.valueOf(this.lWL.b(mVar)));
            return this.lWL.b(mVar);
        } else {
            com.tencent.mm.plugin.exdevice.e.f fVar = (com.tencent.mm.plugin.exdevice.e.f) this.lWK.aEq();
            if (fVar == null) {
                x.e("MicroMsg.exdevice.MMInitTaskExcuter", "Init Request parse failed, Tell device before stop this task");
                this.lWK.a(-4, "", new byte[0], new byte[0], 0, 0);
                this.lWL = new a(this.lWK, dVar);
                x.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", Boolean.valueOf(this.lWL.b(mVar)));
                return this.lWL.b(mVar);
            }
            byte[] toByteArray;
            byte[] toByteArray2;
            if (fVar.lUf != null) {
                toByteArray = fVar.lUf.toByteArray();
            } else {
                toByteArray = null;
            }
            if (fVar.lUe != null) {
                toByteArray2 = fVar.lUe.toByteArray();
            } else {
                toByteArray2 = null;
            }
            ad.aEY();
            int aEz = d.aEz();
            switch (aEz) {
                case 1:
                case 2:
                    break;
                default:
                    x.e("MicroMsg.exdevice.MMInitTaskExcuter", "initScene = %d, Cannot start init response", Integer.valueOf(aEz));
                    break;
            }
            this.lWK.a(0, null, toByteArray2, toByteArray, aEz, (int) (b.aGf() / 1000));
            this.lWL = new a(this.lWK, dVar);
            return this.lWL.b(mVar);
        }
    }
}
