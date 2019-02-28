package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mm.f.a.dj;
import com.tencent.mm.f.a.dk;
import com.tencent.mm.f.a.dl;
import com.tencent.mm.j.g;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelmulti.e;
import com.tencent.mm.protocal.c.alg;
import com.tencent.mm.protocal.c.ali;
import com.tencent.mm.protocal.c.all;
import com.tencent.mm.protocal.c.zj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.as;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class k {
    private static c gAg;
    private static float gAh = -85.0f;
    private static float gAi = -1000.0f;
    private static boolean gAj = false;
    private static Map<String, alg> gAk = new ConcurrentHashMap();
    private static List<alg> gAl = new CopyOnWriteArrayList();
    private static Boolean gAm = Boolean.valueOf(false);
    private static a gAn = new a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (z) {
                x.d("MicroMsg.PostTaskStartRangeForIBeacon", "on location get ok");
                k.gAh = f2;
                k.gAi = f;
                k.gAj = true;
                if (k.gAg != null) {
                    k.gAg.c(k.gAn);
                    k.gAj = false;
                }
            } else {
                x.w("MicroMsg.PostTaskStartRangeForIBeacon", "getLocation fail");
            }
            return false;
        }
    };
    private static al gAo = new al(Looper.getMainLooper(), new al.a() {
        public final boolean uG() {
            try {
                as.Hm();
                Boolean valueOf = Boolean.valueOf(bi.a((Boolean) com.tencent.mm.y.c.Db().get(w.a.USERINFO_IBEACON_PUSH_IS_IN_SHAKEUI_BOOLEAN, null), false));
                List<String> zU = g.Ag().zU();
                if (zU != null) {
                    for (String str : zU) {
                        x.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=false,isInShakeUI:" + valueOf + ",iBeacon = %s", str);
                        b dkVar = new dk();
                        dkVar.fsP.fsR = str;
                        dkVar.fsP.fsO = false;
                        if (!valueOf.booleanValue()) {
                            com.tencent.mm.sdk.b.a.xmy.m(dkVar);
                        }
                    }
                    ali ali = new ali();
                    ali.latitude = (double) k.gAh;
                    ali.longitude = (double) k.gAi;
                    as.Hm();
                    long a = bi.a((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_IBEACON_PUSH_SHOP_ID_LONG, null), 0);
                    if (k.gAk.size() <= 0 || k.gAm.booleanValue() || k.gAl.size() <= 0) {
                        as.Hm();
                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                    } else {
                        k.gAm = Boolean.valueOf(true);
                        final com.tencent.mm.ad.k eVar = new e(k.gAl, a, ali);
                        x.d("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]PostTaskStartRangeForIBeacon[kevinkma] shopId " + a + ",beaconInfos size " + k.gAl.size() + ",info:" + k.gAl.toString());
                        as.CN().a(1708, new com.tencent.mm.ad.e() {
                            public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
                                if (i == 0 && i2 == 0) {
                                    zj zjVar = (zj) eVar.hGV.hnR.hnY;
                                    if (zjVar.result == 0) {
                                        all all = zjVar.wpZ;
                                        alg alg = zjVar.wqb;
                                        Object obj = all.title + "," + all.desc + "," + all.wzk + "," + all.wzl + "," + alg.njL + "," + alg.major + "," + alg.minor;
                                        as.Hm();
                                        String[] split = bi.aD((String) com.tencent.mm.y.c.Db().get(w.a.USERINFO_IBEACON_PUSH_LAST_BEACONINFO_STRING, null), "").split(",");
                                        Boolean valueOf = Boolean.valueOf(false);
                                        Boolean bool = valueOf;
                                        for (String equals : split) {
                                            if (equals.equals(alg.njL + alg.major + alg.minor)) {
                                                bool = Boolean.valueOf(true);
                                            }
                                        }
                                        if (bool.booleanValue()) {
                                            as.Hm();
                                            com.tencent.mm.y.c.Db().a(w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                                        } else {
                                            com.tencent.mm.plugin.report.service.g.pWK.h(12653, Integer.valueOf(1), Integer.valueOf(1));
                                            com.tencent.mm.plugin.report.service.g.pWK.h(12653, Integer.valueOf(2), Integer.valueOf(1));
                                            as.Hm();
                                            com.tencent.mm.y.c.Db().a(w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, obj);
                                        }
                                    } else {
                                        as.Hm();
                                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                                    }
                                } else {
                                    as.Hm();
                                    com.tencent.mm.y.c.Db().a(w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                                }
                                as.Hm();
                                com.tencent.mm.y.c.CB();
                                com.tencent.mm.sdk.b.a.xmy.m(new dj());
                                k.gAm = Boolean.valueOf(false);
                                as.CN().b(1708, (com.tencent.mm.ad.e) this);
                            }
                        });
                        as.CN().a(eVar, 0);
                    }
                    k.gAk.clear();
                    k.gAl.clear();
                    com.tencent.mm.sdk.b.a.xmy.c(k.gAp);
                }
            } catch (Exception e) {
                x.e("MicroMsg.PostTaskStartRangeForIBeacon", e.getMessage());
            }
            return false;
        }
    }, true);
    private static com.tencent.mm.sdk.b.c gAp = new com.tencent.mm.sdk.b.c<dl>() {
        {
            this.xmG = dl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            dl dlVar = (dl) bVar;
            if (dlVar != null && (dlVar instanceof dl)) {
                String str = dlVar.fsT.fsR;
                int i = dlVar.fsT.fsU;
                int i2 = dlVar.fsT.fsV;
                if (!k.gAk.containsKey(str + "," + i + "," + i2)) {
                    alg alg = new alg();
                    alg.njL = str;
                    alg.major = i;
                    alg.minor = 65535 & i2;
                    alg.hNI = dlVar.fsT.fsW;
                    k.gAk.put(str + "," + i + "," + i2, alg);
                    if (dlVar.fsT.fsW >= 0.0d && k.gAl.size() > 0) {
                        int i3 = 0;
                        while (i3 < k.gAl.size()) {
                            alg alg2 = (alg) k.gAl.get(i3);
                            if (dlVar.fsT.fsW >= alg2.hNI) {
                                if (i3 == k.gAl.size() - 1 && dlVar.fsT.fsW > alg2.hNI) {
                                    k.gAl.add(alg);
                                    break;
                                }
                                i3++;
                            } else {
                                k.gAl.add(i3, alg);
                                break;
                            }
                        }
                    }
                    k.gAl.add(alg);
                }
                x.i("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]result iBeacon = %s,beaconMap.size:%d", str + "," + i + "," + i2, Integer.valueOf(k.gAk.size()));
            }
            return false;
        }
    };

    public static void run() {
        if (as.Hp() && !as.Cz()) {
            as.Hm();
            Boolean valueOf = Boolean.valueOf(bi.a((Boolean) com.tencent.mm.y.c.Db().get(w.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false));
            x.i("MicroMsg.PostTaskStartRangeForIBeacon", "the range road status is " + valueOf);
            if (valueOf.booleanValue()) {
                long Wx = bi.Wx();
                as.Hm();
                long a = bi.a((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_IBEACON_PUSH_OPEN_TIEMSTAMP_LONG, null), 0);
                as.Hm();
                if (Wx - a > bi.a((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_IBEACON_PUSH_CHANNEL_OPEN_TIME_LONG, null), 0)) {
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(w.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.valueOf(false));
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(w.a.USERINFO_IBEACON_PUSH_LAST_BEACONINFO_STRING, (Object) "");
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                    as.Hm();
                    com.tencent.mm.y.c.CB();
                    return;
                }
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (VERSION.SDK_INT < 18 || defaultAdapter == null || defaultAdapter.getState() != 12) {
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                    return;
                }
                List<String> zU = g.Ag().zU();
                if (zU != null) {
                    for (String str : zU) {
                        x.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=true,iBeacon = %s", str);
                        b dkVar = new dk();
                        dkVar.fsP.fsR = str;
                        dkVar.fsP.fsO = true;
                        com.tencent.mm.sdk.b.a.xmy.m(dkVar);
                    }
                    gAg = c.OV();
                    if (gAo.cgx()) {
                        gAo.K(3000, 3000);
                    }
                    if (!(gAj || gAg == null)) {
                        gAg.b(gAn);
                    }
                    com.tencent.mm.sdk.b.a.xmy.b(gAp);
                }
            }
        }
    }
}
