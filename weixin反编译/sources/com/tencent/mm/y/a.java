package com.tencent.mm.y;

import com.tencent.mm.a.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.c;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public byte[] hgg;
    public long hgh = -1;

    public final int EV() {
        return this.hgg == null ? -1 : this.hgg.length;
    }

    public a() {
        if (EW()) {
            ah.h(new Runnable() {
                public final void run() {
                    try {
                        if (a.EW()) {
                            d.pVE.a(226, 1, 1, false);
                        }
                    } catch (Throwable e) {
                        x.e("MicroMsg.AccInfoCacheInWorker", "init Exception:%s", bi.i(e));
                    }
                }
            }, 5000);
        }
    }

    public static boolean EW() {
        if (com.tencent.mm.kernel.a.Cz() || !g.Do().CF()) {
            return false;
        }
        int i = bi.getInt(((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("AndroidUseWorkerAuthCache"), 0);
        g.Dr();
        g.Do();
        int aJ = h.aJ(com.tencent.mm.kernel.a.Cn(), 100);
        boolean cfx = b.cfx();
        r7 = new Object[5];
        g.Dr();
        g.Do();
        r7[2] = Integer.valueOf(com.tencent.mm.kernel.a.Cn());
        r7[3] = Integer.valueOf(aJ);
        r7[4] = Boolean.valueOf(g.Do().CF());
        x.i("MicroMsg.AccInfoCacheInWorker", "checkUse debug:%s dyVal:%s uin:%d  uinHash:%d init:%b", r7);
        if (cfx) {
            return true;
        }
        if (i > aJ) {
            return true;
        }
        return false;
    }

    public static void EX() {
        if (EW()) {
            try {
                g.Dr();
                a aVar = g.Do().gQY;
                g.Dr();
                c KD = g.Dp().gRu.hoF.KD();
                long Wy = bi.Wy();
                if (KD == null) {
                    x.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker  accinfo == null");
                    d.pVE.a(226, 2, 1, false);
                    return;
                }
                x.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker islogin:%b cache:%s", Boolean.valueOf(KD.Kz()), Integer.valueOf(aVar.EV()));
                if (KD.Kz()) {
                    aVar.hgg = KD.KC();
                    d.pVE.a(226, aVar.EV() > 0 ? 4 : 5, 1, false);
                    x.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker time:%s cache:%s useCacheCount:%s ", Long.valueOf(bi.bA(Wy)), Integer.valueOf(aVar.EV()), Long.valueOf(aVar.hgh));
                    if (aVar.EV() > 0) {
                        d.pVE.a(226, 31 - (aVar.hgh > 5 ? 5 : aVar.hgh), 1, false);
                        d.pVE.h(11098, Integer.valueOf(MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN), Long.valueOf(aVar.hgh));
                        aVar.hgh = -1;
                        return;
                    }
                    return;
                }
                d.pVE.a(226, 3, 1, false);
                x.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker ERR: Is Not Login");
            } catch (Throwable th) {
                x.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", bi.i(th));
            }
        }
    }
}
