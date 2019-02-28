package com.tencent.mm.plugin.emoji.a.a;

import android.text.TextUtils;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ak;

public final class f {
    public int lAA;
    public String lAB;
    public boolean lAC;
    public boolean lAD = true;
    public boolean lAE = false;
    public int lAx;
    public sx lAy;
    public so lAz;
    public int mStatus;
    public int sm;

    public enum a {
        ;

        static {
            lAF = 1;
            lAG = 2;
            lAH = new int[]{lAF, lAG};
        }
    }

    public f(sx sxVar) {
        this.lAy = sxVar;
        this.lAx = a.lAF;
    }

    public f(so soVar) {
        this.lAz = soVar;
        this.lAx = a.lAG;
    }

    public final void eR(int i) {
        if (i == 7 && this.mStatus == 6 && this.lAD) {
            this.lAC = true;
        }
        this.mStatus = i;
    }

    public final void a(boolean z, ak akVar, boolean z2) {
        sx sxVar = this.lAy;
        if (sxVar != null) {
            if (z2) {
                eR(7);
                return;
            }
            boolean a = e.a(sxVar);
            boolean b = e.b(sxVar);
            boolean cs = sxVar == null ? false : e.cs(sxVar.whA, 8);
            boolean isEmpty = TextUtils.isEmpty(sxVar.why);
            if (!cs || !b) {
                if (!a) {
                    if (!b && (z || !isEmpty)) {
                        this.lAA = 1;
                        if (z && akVar != null) {
                            switch (akVar.xHc) {
                                case 11:
                                    eR(11);
                                    break;
                                case 12:
                                    eR(4);
                                    break;
                                default:
                                    if (!(akVar.xHa == 7 || akVar.xHa == 6 || akVar.xHa == 3)) {
                                        eR(10);
                                        break;
                                    }
                            }
                        } else if (z) {
                            eR(11);
                        } else {
                            eR(4);
                        }
                    } else {
                        eR(3);
                        this.lAA = 0;
                    }
                } else {
                    eR(3);
                    if (b || (!z && isEmpty)) {
                        this.lAA = 0;
                    } else {
                        this.lAA = 1;
                    }
                }
            } else {
                eR(8);
            }
            if (z && akVar != null && !bi.oN(akVar.xHe)) {
                this.lAy.why = akVar.xHe;
            }
        }
    }
}
