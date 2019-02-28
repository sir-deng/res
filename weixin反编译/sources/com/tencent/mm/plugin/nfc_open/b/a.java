package com.tencent.mm.plugin.nfc_open.b;

import android.content.ComponentName;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.nfc_open.a.b;
import com.tencent.mm.protocal.c.atx;
import com.tencent.mm.protocal.c.kn;
import com.tencent.mm.protocal.c.os;
import com.tencent.mm.protocal.c.pp;
import com.tencent.mm.protocal.c.pq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

public final class a implements e {
    public atx oXL;

    public a() {
        init();
    }

    private void init() {
        this.oXL = new atx();
        as.Hm();
        String valueOf = String.valueOf(c.Db().get(com.tencent.mm.storage.w.a.USERINFO_NFC_CPU_CARD_CONFIG_STRING, null));
        if (bi.oN(valueOf)) {
            this.oXL.wfs = new LinkedList();
            this.oXL.lastUpdateTime = 0;
            this.oXL.wft = 86400;
            this.oXL.version = 0;
            return;
        }
        try {
            this.oXL.aH(valueOf.getBytes("ISO-8859-1"));
        } catch (Exception e) {
            x.w("MicroMsg.CpuCardConfigManager", "parseConfig exp, " + e.getLocalizedMessage());
            this.oXL.wfs = new LinkedList();
            this.oXL.lastUpdateTime = 0;
            this.oXL.wft = 86400;
            this.oXL.version = 0;
        }
    }

    private void a(atx atx) {
        if (!as.Hp()) {
            x.i("MicroMsg.CpuCardConfigManager", "setConfig account not ready");
        } else if (atx != null) {
            x.i("MicroMsg.CpuCardConfigManager", "setConfig config");
            this.oXL = atx;
            try {
                Object str = new String(this.oXL.toByteArray(), "ISO-8859-1");
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_NFC_CPU_CARD_CONFIG_STRING, str);
            } catch (UnsupportedEncodingException e) {
                x.w("MicroMsg.CpuCardConfigManager", "save config exp, " + e.getLocalizedMessage());
            } catch (IOException e2) {
                x.w("MicroMsg.CpuCardConfigManager", "save config exp, " + e2.getLocalizedMessage());
            }
        }
    }

    private atx bge() {
        if (this.oXL == null) {
            init();
        }
        return this.oXL;
    }

    public final void a(int i, int i2, String str, k kVar) {
        as.CN().b(1561, (e) this);
        if (kVar instanceof b) {
            atx bge = bge();
            bge.lastUpdateTime = bi.Wx();
            if (i == 0 && i2 == 0) {
                pp ppVar = (pp) ((b) kVar).gLB.hnR.hnY;
                if (ppVar != null) {
                    bge.wft = ppVar.wft;
                    bge.wfu = ppVar.wfu;
                    as.Hm();
                    if (((Integer) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue() == 0) {
                        if (ppVar.wfu == 1) {
                            ad.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ad.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
                        } else {
                            ad.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ad.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
                        }
                    }
                    as.Hm();
                    c.Db().a(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, Integer.valueOf(ppVar.wfu));
                    as.Hm();
                    c.Db().a(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_SWITCH_WORDING_STRING_SYNC, ppVar.sPd);
                    if (bge.version != ppVar.version) {
                        bge.version = ppVar.version;
                        if (ppVar.wfs != null && !ppVar.wfs.isEmpty()) {
                            if (bge.wfs == null) {
                                bge.wfs = new LinkedList();
                            } else {
                                bge.wfs.clear();
                            }
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= ppVar.wfs.size()) {
                                    break;
                                }
                                kn knVar = new kn();
                                knVar.vJU = ((kn) ppVar.wfs.get(i4)).vJU;
                                knVar.vXZ = ((kn) ppVar.wfs.get(i4)).vXZ;
                                x.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd sflag=" + bi.e(Integer.valueOf(knVar.vXZ)) + ", url=" + bi.oM(knVar.vJU));
                                if (knVar.vXY == null) {
                                    knVar.vXY = new LinkedList();
                                } else {
                                    knVar.vXY.clear();
                                }
                                i3 = 0;
                                while (true) {
                                    int i5 = i3;
                                    if (i5 >= ((kn) ppVar.wfs.get(i4)).vXY.size()) {
                                        break;
                                    }
                                    pq pqVar = new pq();
                                    if (pqVar.wfv == null) {
                                        pqVar.wfv = new LinkedList();
                                    } else {
                                        pqVar.wfv.clear();
                                    }
                                    i3 = 0;
                                    while (true) {
                                        int i6 = i3;
                                        if (i6 >= ((pq) ((kn) ppVar.wfs.get(i4)).vXY.get(i5)).wfv.size()) {
                                            break;
                                        }
                                        os osVar = new os();
                                        osVar.wes = ((os) ((pq) ((kn) ppVar.wfs.get(i4)).vXY.get(i5)).wfv.get(i6)).wes;
                                        osVar.oik = ((os) ((pq) ((kn) ppVar.wfs.get(i4)).vXY.get(i5)).wfv.get(i6)).oik;
                                        x.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd cmd=" + bi.oM(osVar.wes) + ", answer=" + bi.oM(osVar.oik));
                                        pqVar.wfv.add(osVar);
                                        i3 = i6 + 1;
                                    }
                                    knVar.vXY.add(pqVar);
                                    i3 = i5 + 1;
                                }
                                bge.wfs.add(knVar);
                                i3 = i4 + 1;
                            }
                        } else {
                            bge.wfs.clear();
                        }
                    } else {
                        x.i("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd no config change return version = " + ppVar.version);
                        a(bge);
                        return;
                    }
                }
            }
            a(bge);
        }
    }
}
