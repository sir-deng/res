package com.tencent.mm.plugin.nfc_open;

import android.content.ComponentName;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.nfc.NfcAdapter;
import android.os.Process;
import com.tencent.mm.ad.e;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.nfc_open.a.b;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bq;
import com.tencent.mm.y.c;
import java.util.HashMap;

public final class a implements ap {
    private com.tencent.mm.plugin.nfc_open.b.a oXJ;

    private static a bgd() {
        as.Hg();
        a aVar = (a) bq.ib("plugin.nfc_open");
        if (aVar != null) {
            return aVar;
        }
        x.w("MicroMsg.SubCoreCpuCard", "[NFC]not found in MMCore, new one");
        Object aVar2 = new a();
        as.Hg().a("plugin.nfc_open", aVar2);
        return aVar2;
    }

    public final HashMap<Integer, d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bt(boolean z) {
    }

    public final void bs(boolean z) {
        boolean z2;
        int i = 1800;
        x.i("MicroMsg.SubCoreCpuCard", "alvinluo process: %s", bi.r(ad.getContext(), Process.myPid()));
        g.Do().CA();
        if (bgd().oXJ == null) {
            bgd().oXJ = new com.tencent.mm.plugin.nfc_open.b.a();
        }
        e eVar = bgd().oXJ;
        if (NfcAdapter.getDefaultAdapter(ad.getContext()) == null) {
            x.i("MicroMsg.CpuCardConfigManager", "Nfc not support no need update");
        } else if (eVar.oXL != null) {
            int i2 = eVar.oXL.wft;
            if (i2 >= 1800) {
                if (i2 > 604800) {
                    i = 604800;
                } else {
                    i = i2;
                }
            }
            x.i("MicroMsg.CpuCardConfigManager", "now=" + bi.Wx() + ", lastUpdateTime=" + eVar.oXL.lastUpdateTime + ", updateFreq=" + i + ", configUpdateFreq=" + eVar.oXL.wft);
            if (bi.Wx() - eVar.oXL.lastUpdateTime > ((long) i)) {
                z2 = true;
                if (z2) {
                    x.i("MicroMsg.CpuCardConfigManager", "do update cpu card config");
                    as.CN().a(1561, eVar);
                    as.CN().a(new b(eVar.oXL.version), 0);
                }
                as.Hm();
                i = ((Integer) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue();
                if (i == 0) {
                    as.Hm();
                    if (((Integer) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue() != 1) {
                        he(true);
                    } else {
                        he(false);
                    }
                } else if (i != 1) {
                    he(true);
                } else {
                    he(false);
                }
                x.i("MicroMsg.SubCoreCpuCard", "doNFCReport start");
                com.tencent.mm.sdk.f.e.post(new Runnable() {
                    public final void run() {
                        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "system_config_prefs", 4);
                        if (bi.bB(sharedPreferences.getLong("NFC_REPORT_TIME", 0)) > 86400000) {
                            int i;
                            int dk = com.tencent.mm.plugin.nfc.c.a.a.bgb().dk(ad.getContext());
                            int i2 = dk == 0 ? 0 : 1;
                            if (com.tencent.mm.plugin.hce.a.b.aSY()) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                            x.i("MicroMsg.SubCoreCpuCard", "alvinluo NFC report isSupportNFC: %d, isSupportHCE: %d", Integer.valueOf(i2), Integer.valueOf(i));
                            com.tencent.mm.plugin.report.service.g.pWK.h(12779, q.yL(), Integer.valueOf(i2), Integer.valueOf(i));
                            Editor edit = sharedPreferences.edit();
                            edit.putLong("NFC_REPORT_TIME", bi.Wz());
                            edit.commit();
                            x.i("MicroMsg.SubCoreCpuCard", "doNFCReport status = " + dk);
                        }
                    }
                }, getClass().getName());
            }
        }
        z2 = false;
        if (z2) {
            x.i("MicroMsg.CpuCardConfigManager", "do update cpu card config");
            as.CN().a(1561, eVar);
            as.CN().a(new b(eVar.oXL.version), 0);
        }
        as.Hm();
        i = ((Integer) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue();
        if (i == 0) {
            as.Hm();
            if (((Integer) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue() != 1) {
                he(false);
            } else {
                he(true);
            }
        } else if (i != 1) {
            he(false);
        } else {
            he(true);
        }
        x.i("MicroMsg.SubCoreCpuCard", "doNFCReport start");
        com.tencent.mm.sdk.f.e.post(/* anonymous class already generated */, getClass().getName());
    }

    private static void he(boolean z) {
        if (z) {
            ad.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ad.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
        } else {
            ad.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ad.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
        }
    }

    public final void onAccountRelease() {
    }
}
