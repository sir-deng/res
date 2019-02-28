package com.tencent.mm.pluginsdk.wallet;

import com.tencent.mm.R;
import com.tencent.mm.f.a.tf;
import com.tencent.mm.f.a.tg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.x.g.a;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.List;

public final class e {
    public static String TE(String str) {
        as.Hm();
        List<au> FC = c.Fh().FC(str);
        if (FC != null) {
            x.i("MicroMsg.WalletConvDelCheckLogic", "checkUnProcessWalletMsgCount, msgInfoList size: %s", Integer.valueOf(FC.size()));
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            for (au auVar : FC) {
                if (ab(auVar)) {
                    if (auVar.getType() == 419430449) {
                        i++;
                    } else if (auVar.getType() == 436207665) {
                        a fV;
                        String str2 = auVar.field_content;
                        if (str2 != null) {
                            fV = a.fV(str2);
                        } else {
                            fV = null;
                        }
                        if (fV != null) {
                            if ("1001".equals(fV.her)) {
                                i2++;
                            } else {
                                i3++;
                            }
                        }
                    }
                }
                i3 = i3;
            }
            if (i3 > 0 || i2 > 0 || i > 0) {
                if (s.eX(str)) {
                    return ad.getContext().getString(R.l.eWA, new Object[]{Integer.valueOf(i2)});
                } else if (i3 > 0 && i <= 0) {
                    return ad.getContext().getString(R.l.eWC, new Object[]{Integer.valueOf(i3)});
                } else if (i > 0 && i3 <= 0) {
                    return ad.getContext().getString(R.l.eWD, new Object[]{Integer.valueOf(i)});
                } else if (i > 0 && i3 > 0) {
                    return ad.getContext().getString(R.l.eWB, new Object[]{Integer.valueOf(i3), Integer.valueOf(i)});
                }
            }
        }
        return null;
    }

    public static boolean ab(au auVar) {
        a aVar = null;
        String str;
        int i;
        if (auVar.getType() == 419430449) {
            if (auVar.field_isSend == 0) {
                a I;
                str = auVar.field_content;
                if (str != null) {
                    I = a.I(str, auVar.field_reserved);
                } else {
                    I = null;
                }
                if (I != null) {
                    b tgVar = new tg();
                    tgVar.fMA.fFn = I.hdR;
                    com.tencent.mm.sdk.b.a.xmy.m(tgVar);
                    i = tgVar.fMB.status;
                    if (i <= 0) {
                        i = I.hdO;
                    }
                    if (i >= 0 && (i == 1 || i == 7)) {
                        return true;
                    }
                }
            }
        } else if (auVar.getType() == 436207665 && auVar.field_isSend == 0) {
            str = auVar.field_content;
            if (str != null) {
                aVar = a.fV(str);
            }
            if (aVar != null) {
                if (!"1001".equals(aVar.her) && !s.eX(auVar.field_talker)) {
                    b tfVar = new tf();
                    if (!bi.oN(aVar.hes)) {
                        tfVar.fMv.fMx = aVar.hes;
                        com.tencent.mm.sdk.b.a.xmy.m(tfVar);
                        if (tfVar.fMw.fMz == 0) {
                            return true;
                        }
                    }
                } else if (s.eX(auVar.field_talker)) {
                    int i2;
                    str = q.FY();
                    if (!bi.cC(aVar.heH)) {
                        for (String split : aVar.heH) {
                            String[] split2 = split.split(",");
                            if (split2.length == 3 && split2[0].equals(str)) {
                                i = bi.getInt(split2[2], -1);
                                i2 = 1;
                                break;
                            }
                        }
                    }
                    i = 0;
                    i2 = 0;
                    if (i2 != 0 && r0 == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
