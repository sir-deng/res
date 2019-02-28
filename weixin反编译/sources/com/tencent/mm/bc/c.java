package com.tencent.mm.bc;

import com.tencent.map.a.a.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements a, e {
    private float fAo;
    private float fBX;
    private int fBY;
    private int fBZ;
    private String fCa;
    private String fCb;
    a hNC;
    byte[] hND;
    private al hNE;
    private int hNF;
    Object lock = new Object();
    private int scene;

    public c(float f, float f2, int i, int i2, String str, String str2, int i3, int i4) {
        g.Dr();
        this.hNE = new al(g.Dt().oFY.getLooper(), new al.a() {
            public final boolean uG() {
                x.w("MicroMsg.SenseWhereHttpUtil", "it is time up, has no sense where response.");
                if (c.this.hNC != null) {
                    g.Dp().gRu.c(c.this.hNC);
                }
                c.this.hNC = null;
                c.this.hND = null;
                synchronized (c.this.lock) {
                    c.this.lock.notifyAll();
                }
                return false;
            }
        }, false);
        this.fBX = f;
        this.fAo = f2;
        this.fBY = i;
        this.fBZ = i2;
        this.fCa = str;
        this.fCb = str2;
        this.hNF = i3;
        this.scene = i4;
        g.Dp().gRu.a(752, (e) this);
    }

    public final void finish() {
        this.hNE.TN();
        if (this.hNC != null) {
            g.Dp().gRu.c(this.hNC);
        }
        this.hNC = null;
        this.hND = null;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
        g.Dp().gRu.b(752, (e) this);
    }

    public final byte[] r(byte[] bArr) {
        try {
            String str = new String(bArr, "UTF-8");
            x.d("MicroMsg.SenseWhereHttpUtil", "sense where http request content : " + str);
            this.hND = null;
            this.hNC = new a(this.fBX, this.fAo, this.fBY, this.fBZ, this.fCa, this.fCb, this.hNF, this.scene, str);
            g.Dp().gRu.a(this.hNC, 0);
            this.hNE.K(60000, 60000);
            synchronized (this.lock) {
                this.lock.wait();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SenseWhereHttpUtil", e, "", new Object[0]);
            x.e("MicroMsg.SenseWhereHttpUtil", "sense where http request error: " + e.toString());
        }
        x.i("MicroMsg.SenseWhereHttpUtil", "upload sense where info finish. it is response is null? %b", Boolean.valueOf(bi.by(this.hND)));
        return this.hND;
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.hNE.TN();
        if (i == 0 && i2 == 0) {
            if (kVar instanceof a) {
                String aD = bi.aD(((a) kVar).hNc, "");
                x.d("MicroMsg.SenseWhereHttpUtil", "senseWhereResp: " + aD);
                try {
                    this.hND = aD.getBytes("UTF-8");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SenseWhereHttpUtil", e, "", new Object[0]);
                    x.e("MicroMsg.SenseWhereHttpUtil", "string to byte[] error. " + e.toString());
                }
            } else {
                this.hND = null;
            }
            synchronized (this.lock) {
                this.lock.notifyAll();
            }
        } else {
            x.w("MicroMsg.SenseWhereHttpUtil", "upload sense where info error. errType[%d] errCode[%d] errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            this.hND = null;
            synchronized (this.lock) {
                this.lock.notifyAll();
            }
            b.Rr().Rt();
            com.tencent.mm.plugin.report.service.g.pWK.a(345, 4, 1, false);
        }
        this.hNC = null;
    }
}
