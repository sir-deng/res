package com.tencent.mm.plugin.multitalk.a;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;

public final class j {
    public a oLV;
    public a oMA = new a();
    public ag oMz;

    private class a {
        public int angle;
        public int h;
        public Bitmap mZu;
        public boolean mgx;
        public int oMC;
        public int oMD;
        public int[] oME;
        public int w;

        private a() {
        }

        /* synthetic */ a(j jVar, byte b) {
            this();
        }
    }

    public class b implements Runnable {
        public final void run() {
            j.this.oMA.mgx = true;
            if (j.this.oMA.mZu != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (j.this.oLV != null) {
                    j.this.oLV.a(q.FY(), j.this.oMA.mZu, j.this.oMA.oMD, j.this.oMA.angle);
                }
                if (System.currentTimeMillis() - currentTimeMillis > 30) {
                    x.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "steve: draw native picture use time total: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                j.this.oMA.mgx = false;
            }
            try {
                Thread.sleep(20);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MT.MultiTalkVideoNativeReceiver", e, "", new Object[0]);
            }
        }
    }

    public j(a aVar) {
        this.oLV = aVar;
    }
}
