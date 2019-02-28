package com.tencent.mm.plugin.i.c;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.plugin.n.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.as;
import java.io.File;

public final class b implements Runnable {
    private int count = 0;
    public boolean isStop = false;

    public final void run() {
        if (!this.isStop) {
            String Fp = c.Fp();
            this.count = 0;
            long a = a(Fp, new PLong());
            if (!this.isStop) {
                Fp = c.Fq();
                this.count = 0;
                long a2 = a(Fp, new PLong());
                if (!this.isStop) {
                    as.Hm();
                    Fp = com.tencent.mm.y.c.getAccVideoPath();
                    this.count = 0;
                    long a3 = a(Fp, new PLong());
                    if (!this.isStop) {
                        as.Hm();
                        Fp = com.tencent.mm.y.c.Ft();
                        this.count = 0;
                        long a4 = a(Fp, new PLong());
                        if (!this.isStop) {
                            long nT = (com.tencent.mm.plugin.i.b.atn().ato().nT(43) + com.tencent.mm.plugin.i.b.atn().ato().nT(62)) + com.tencent.mm.plugin.i.b.atn().ato().nT(44);
                            long nU = (com.tencent.mm.plugin.i.b.atn().ato().nU(43) + com.tencent.mm.plugin.i.b.atn().ato().nU(62)) + com.tencent.mm.plugin.i.b.atn().ato().nU(44);
                            if (!this.isStop) {
                                long nT2 = com.tencent.mm.plugin.i.b.atn().ato().nT(3);
                                long nU2 = com.tencent.mm.plugin.i.b.atn().ato().nU(3);
                                if (!this.isStop) {
                                    long nT3 = com.tencent.mm.plugin.i.b.atn().ato().nT(34);
                                    long nU3 = com.tencent.mm.plugin.i.b.atn().ato().nU(34);
                                    long nT4 = com.tencent.mm.plugin.i.b.atn().ato().nT(49);
                                    long nU4 = com.tencent.mm.plugin.i.b.atn().ato().nU(49);
                                    g.pWK.h(14556, (Object[]) new Object[]{Integer.valueOf(43), Long.valueOf(nT), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(nU)});
                                    g.pWK.h(14556, (Object[]) new Object[]{Integer.valueOf(3), Long.valueOf(nT2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(nU2)});
                                    g.pWK.h(14556, (Object[]) new Object[]{Integer.valueOf(34), Long.valueOf(nT3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(nU3)});
                                    g.pWK.h(14556, (Object[]) new Object[]{Integer.valueOf(49), Long.valueOf(nT4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(nU4)});
                                    g.pWK.h(14556, (Object[]) new Object[]{Integer.valueOf(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE.hashCode()), Long.valueOf(a), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(r3.value)});
                                    g.pWK.h(14556, (Object[]) new Object[]{Integer.valueOf("image2".hashCode()), Long.valueOf(a2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(r6.value)});
                                    g.pWK.h(14556, (Object[]) new Object[]{Integer.valueOf(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE.hashCode()), Long.valueOf(a3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(r7.value)});
                                    g.pWK.h(14556, (Object[]) new Object[]{Integer.valueOf("voice".hashCode()), Long.valueOf(a4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(r12.value)});
                                    long longValue = ((Long) com.tencent.mm.kernel.g.Dq().Db().get(a.USERINFO_CALC_WX_SCAN_START_TIME_LONG, (Object) Long.valueOf(0))).longValue();
                                    long longValue2 = ((Long) com.tencent.mm.kernel.g.Dq().Db().get(a.USERINFO_CALC_WX_SCAN_FINISH_TIME_LONG, (Object) Long.valueOf(0))).longValue() - longValue;
                                    g.pWK.h(14556, (Object[]) new Object[]{Integer.valueOf("cost".hashCode()), Integer.valueOf(0), Long.valueOf(longValue), Long.valueOf(r34), Long.valueOf(longValue2)});
                                    x.i("MicroMsg.ReportTask", "report wx[%d %d %d %d] folder[%d %d %d %d] count_wx[%d %d %d %d] count_folder[%d %d %d %d]", Long.valueOf(nT), Long.valueOf(nT2), Long.valueOf(nT3), Long.valueOf(nT4), Long.valueOf(a3), Long.valueOf(a2), Long.valueOf(a4), Long.valueOf(a), Long.valueOf(nU), Long.valueOf(nU2), Long.valueOf(nU3), Long.valueOf(nU4), Long.valueOf(r7.value), Long.valueOf(r6.value), Long.valueOf(r12.value), Long.valueOf(r3.value));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private long a(String str, PLong pLong) {
        long j = 0;
        if (this.count >= 10) {
            if (this.isStop) {
                return -1;
            }
            this.count = 0;
        }
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String str2 : list) {
                    String str22;
                    StringBuilder append = new StringBuilder().append(str);
                    if (!str.endsWith("/")) {
                        str22 = "/" + str22;
                    }
                    long a = a(append.append(str22).toString(), pLong);
                    if (a == -1) {
                        return -1;
                    }
                    j += a;
                }
                return j;
            }
        }
        long length = file.length();
        if (length <= 0) {
            return length;
        }
        pLong.value++;
        return length;
    }
}
