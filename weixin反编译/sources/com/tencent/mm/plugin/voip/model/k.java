package com.tencent.mm.plugin.voip.model;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class k {
    public static k ssT;
    v2protocal ssL = new v2protocal(new ag(Looper.getMainLooper()));
    boolean ssM = false;
    public a ssN;
    int ssO = -1;
    boolean ssP = false;
    int ssQ = 0;
    public int ssR;
    public int ssS;
    al ssU = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            if (!k.this.ssP) {
                return false;
            }
            int i;
            byte[] bArr = new byte[4];
            if (k.this.ssL.setAppCmd(10, bArr, 4) < 0) {
                x.d("MicroMsg.VoipNetStatusChecker", "get netStatus failed");
                i = -1;
            } else {
                i = bi.aI(bArr);
                x.d("MicroMsg.VoipNetStatusChecker", "netStatus: %d", Integer.valueOf(i));
            }
            if (i != -1) {
                k.this.ssO = i;
                k.this.ssR = k.this.ssO + k.this.ssR;
                k kVar = k.this;
                kVar.ssS++;
                kVar = k.this;
                if (kVar.ssO < 5) {
                    kVar.ssQ = 0;
                    if (!kVar.ssM) {
                        kVar.ssM = true;
                        x.d("MicroMsg.VoipNetStatusChecker", "go to bad net status");
                        if (kVar.ssN != null) {
                            kVar.ssN.aTD();
                        }
                    }
                } else if (kVar.ssM) {
                    if (kVar.ssQ <= 0) {
                        x.d("MicroMsg.VoipNetStatusChecker", "ignore this good net status");
                        kVar.ssQ++;
                    } else {
                        kVar.ssM = false;
                        x.d("MicroMsg.VoipNetStatusChecker", "go to good net status");
                        if (kVar.ssN != null) {
                            kVar.ssN.aTE();
                        }
                    }
                }
            }
            return true;
        }
    }, true);

    public interface a {
        void aTD();

        void aTE();
    }

    public static k bHR() {
        if (ssT == null) {
            ssT = new k();
        }
        return ssT;
    }

    private k() {
    }

    public final void bHS() {
        x.d("MicroMsg.VoipNetStatusChecker", "startNetStatusCheck");
        this.ssO = -1;
        this.ssP = true;
        this.ssS = 0;
        this.ssR = 0;
        ah.h(new Runnable() {
            public final void run() {
                k.this.ssU.K(2000, 2000);
            }
        }, 3000);
    }

    public final void bHT() {
        x.d("MicroMsg.VoipNetStatusChecker", "stopNetStatusCheck");
        this.ssO = -1;
        this.ssM = false;
        this.ssP = false;
        this.ssS = 0;
        this.ssR = 0;
        ah.y(new Runnable() {
            public final void run() {
                k.this.ssU.TN();
            }
        });
    }
}
