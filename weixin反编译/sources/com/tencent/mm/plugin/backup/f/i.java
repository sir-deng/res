package com.tencent.mm.plugin.backup.f;

import android.os.Looper;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Queue;

public final class i {
    private static int kve = 300000;
    private a kri;
    long kvf = 0;
    long kvg;
    long kvh;
    long kvi;
    long kvj;
    int kvk = 0;
    Queue<Long> kvl = new LinkedList();
    al kvm = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            long j = 0;
            long bA = bi.bA(i.this.kvi);
            if (bA != 0) {
                i.this.kvg = (i.this.kvh / bA) * 1000;
                i.this.kvl.offer(Long.valueOf(i.this.kvg));
                try {
                    bA = ((Long) i.this.kvl.poll()).longValue();
                } catch (Exception e) {
                    bA = 0;
                }
                i.this.kvg = (((i.this.kvf * 10) - bA) + i.this.kvg) / 10;
                i iVar = i.this;
                if (i.this.kvg > 0) {
                    j = i.this.kvg;
                }
                iVar.kvg = j;
                i.this.kvf = i.this.kvg;
                i.this.kvh = 0;
                i.this.kvi = bi.Wy();
                i.this.kri.apK();
                if (i.this.kvg < 2) {
                    if (i.this.kvk == 0) {
                        i.this.kvk = 1;
                        i.this.kri.mW(1);
                        i.this.kvj = bi.Wy();
                        x.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is low speed! backupLowSpeedStartTime[%d]", Long.valueOf(i.this.kvj));
                    } else if (i.this.kvk == 1 && bi.bA(i.this.kvj) > ((long) i.kve)) {
                        x.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler low speed overtime, overtime[%d]", Long.valueOf(bi.bA(i.this.kvj)));
                        i.this.kvk = 2;
                        i.this.kri.apL();
                    }
                } else if (i.this.kvk != 0) {
                    i.this.kvk = 0;
                    i.this.kri.mW(0);
                    x.i("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is not low speed now.");
                }
            }
            return true;
        }
    }, true);

    public interface a {
        void apK();

        void apL();

        void mW(int i);
    }

    public i(a aVar) {
        this.kri = aVar;
        if (b.cfx()) {
            kve = 60000;
        }
    }

    static String bK(long j) {
        if ((j >> 30) > 0) {
            return bi.b(j, 100.0d);
        }
        if ((j >> 20) > 0) {
            return bi.a(j, 100.0d);
        }
        if ((j >> 9) <= 0) {
            return j + " B";
        }
        return Math.round(((float) j) / 1024.0f) + " KB";
    }
}
