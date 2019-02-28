package com.tencent.mm.modelstat;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.a.e;
import com.tencent.mm.a.o;
import com.tencent.mm.a.q;
import com.tencent.mm.accessibility.AccessibilityCapture;
import com.tencent.mm.accessibility.AccessibilityCapture.APIProvider;
import com.tencent.mm.accessibility.AccessibilityCapture.Event;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.acm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONObject;

public class c implements APIProvider {
    private static c hRL;
    private al hRM = null;
    private final int hRN = 20971520;
    private ArrayList<b> hRO = new ArrayList();
    private String hRP = null;
    private long hRQ = 0;
    private ArrayList<c> hRR = new ArrayList();
    private boolean hRS = false;
    private Map<String, Boolean> hRT = new HashMap();
    private long hRU = 0;
    private long hRV = 0;
    private List<d> hRW = new ArrayList();
    private ag handler = null;

    private static class c {
        long hSg;
        float hSh;
        int hSi;
        String hSj;
        ArrayList<Pair<String, Boolean>> hSk;
        ArrayList<Pair<String, String>> hSl;
        int id;
        String name;

        private c() {
            this.hSk = new ArrayList();
            this.hSl = new ArrayList();
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final String toString() {
            Pair pair;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ReportConfigEvent{");
            stringBuilder.append("id=" + this.id);
            stringBuilder.append(", name='" + this.name + "'");
            stringBuilder.append(", expireTime=" + this.hSg);
            stringBuilder.append(", rate=" + this.hSh);
            stringBuilder.append(", logId=" + this.hSi);
            stringBuilder.append(", pagesType='" + this.hSj + "'");
            stringBuilder.append(", pageList=[");
            Iterator it = this.hSk.iterator();
            while (it.hasNext()) {
                pair = (Pair) it.next();
                stringBuilder.append("{" + ((String) pair.first) + "," + pair.second + "}");
                stringBuilder.append(",");
            }
            stringBuilder.append("]");
            stringBuilder.append(", specialPVPages=[");
            it = this.hSl.iterator();
            while (it.hasNext()) {
                pair = (Pair) it.next();
                stringBuilder.append("{" + ((String) pair.first) + "," + ((String) pair.second) + "}");
                stringBuilder.append(",");
            }
            stringBuilder.append("]}");
            return stringBuilder.toString();
        }
    }

    static class d implements Serializable, Comparable<d> {
        String hSm = null;
        int left;
        long time = 0;
        int top;
        int type = 0;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return (int) (this.time - ((d) obj).time);
        }

        d() {
        }

        public final String toString() {
            return String.format(Locale.getDefault(), "[%s,%s]", new Object[]{this.hSm, c.bq(this.time)});
        }
    }

    static class b implements Serializable, Comparable<b> {
        long elapsedTime = 0;
        int fvo = 0;
        List<d> hRW = null;
        String hSe = null;
        long hSf;
        long time = 0;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return (int) (this.time - ((b) obj).time);
        }

        b() {
        }

        public final String toString() {
            return String.format(Locale.getDefault(), "[%s,%d,%s]", new Object[]{this.hSe, Integer.valueOf(this.fvo), c.bq(this.time)});
        }
    }

    private static class a {
        Map<String, Boolean> hRT = new HashMap();
        long hRU;
        long hRV;
        List<c> hSd = new ArrayList();

        static class a extends Exception {
            a(String str) {
                super(str);
            }

            a(Throwable th) {
                super(th);
            }
        }

        private a() {
        }

        public final String toString() {
            return "Config{nextUpdateInterval=" + this.hRU + ", samplePeriod=" + this.hRV + ", eventList=" + this.hSd + '}';
        }

        static a mO(String str) {
            a aVar = new a();
            try {
                Map y = bj.y(str, "eventSampleConf");
                if (y == null) {
                    x.e("MicroMsg.ClickFlowStatReceiver", "Config.parseString unable parse XML: %s", str);
                    throw new a("reportConfigMap is null");
                }
                aVar.hRU = bi.getLong((String) y.get(".eventSampleConf.nextUpdateInterval"), 0);
                if (aVar.hRU <= 0 || aVar.hRU > 432000) {
                    aVar.hRU = 432000;
                }
                aVar.hRV = bi.getLong((String) y.get(".eventSampleConf.samplePeriod"), 0);
                int i = 0;
                while (true) {
                    c cVar = new c();
                    String str2 = ".eventSampleConf.events.event" + (i > 0 ? Integer.valueOf(i) : "") + ".";
                    int i2 = i + 1;
                    cVar.id = bi.getInt((String) y.get(str2 + SlookAirButtonFrequentContactAdapter.ID), 0);
                    if (cVar.id > 0) {
                        String str3;
                        int i3;
                        String str4;
                        cVar.hSg = bi.getLong((String) y.get(str2 + "expireTime"), 0);
                        cVar.name = (String) y.get(str2 + "name");
                        cVar.hSh = bi.getFloat((String) y.get(str2 + "rate"), 0.0f);
                        cVar.hSi = bi.getInt((String) y.get(str2 + "logId"), 0);
                        cVar.hSj = (String) y.get(str2 + "pages.$type");
                        ArrayList arrayList = new ArrayList();
                        i = 0;
                        while (true) {
                            str3 = str2 + "pages.page" + (i > 0 ? Integer.valueOf(i) : "") + ".";
                            i3 = i + 1;
                            str4 = (String) y.get(str3 + "$id");
                            if (str4 == null) {
                                break;
                            }
                            boolean equals = ((String) y.get(str3 + "$action")).equals("true");
                            arrayList.add(new Pair(str4, Boolean.valueOf(equals)));
                            aVar.hRT.put(str4, Boolean.valueOf(equals));
                            i = i3;
                        }
                        cVar.hSk = arrayList;
                        arrayList = new ArrayList();
                        i = 0;
                        while (true) {
                            str3 = str2 + "specialPVPages.pageItem" + (i > 0 ? Integer.valueOf(i) : "") + ".";
                            i3 = i + 1;
                            str4 = (String) y.get(str3 + "$prePage");
                            if (str4 == null) {
                                break;
                            }
                            arrayList.add(new Pair(str4, (String) y.get(str3 + "$page")));
                            i = i3;
                        }
                        cVar.hSl = arrayList;
                        aVar.hSd.add(cVar);
                        x.i("MicroMsg.ClickFlowStatReceiver", "Config.parseString Event: %s", cVar);
                        i = i2;
                    } else {
                        x.v("MicroMsg.ClickFlowStatReceiver", "Config.parseString %s", aVar);
                        return aVar;
                    }
                }
            } catch (Throwable e) {
                throw new a(e);
            }
        }
    }

    static /* synthetic */ void a(c cVar) {
        if (AccessibilityCapture.isEnable()) {
            AccessibilityCapture.disableAccessibilityCapture(ad.getContext());
        }
        if (cVar.hRO == null || cVar.hRO.size() == 0) {
            x.e("MicroMsg.ClickFlowStatReceiver", "page info array size is 0");
            return;
        }
        Pair g = cVar.g(cVar.hRO);
        cVar.hRO.clear();
        cVar.hRW.clear();
        if (g == null) {
            x.e("MicroMsg.ClickFlowStatReceiver", "report failed :getResumeList return null ");
            return;
        }
        Object str;
        int intValue = ((Integer) g.first).intValue();
        ArrayList arrayList = (ArrayList) g.second;
        int i = 0;
        if (ad.cgj() && g.Do().CF()) {
            g.Do();
            if (!com.tencent.mm.kernel.a.Cz()) {
                g.Do();
                i = com.tencent.mm.kernel.a.Cn();
            }
        }
        if (i == 0) {
            x.e("MicroMsg.ClickFlowStatReceiver", "report get uin failed  , maybe AccNotReady,  but report it");
        }
        long longValue = new o(i).longValue();
        if (cVar.hRP == null) {
            cVar.hRP = com.tencent.mm.loader.stub.a.hbv + "ClickFlow/";
            File file = new File(cVar.hRP);
            if (!file.exists()) {
                file.mkdir();
            }
        }
        final com.tencent.mm.sdk.e.a aVar = new com.tencent.mm.sdk.e.a(cVar.hRP + "stg_20971520_" + longValue + ".cfg");
        final String str2 = cVar.hRP + "ReportConfig_20971520_" + longValue + ".xml";
        if (cVar.hRR == null || cVar.hRR.size() == 0) {
            byte[] e = e.e(str2, 0, -1);
            str = e != null ? new String(e) : "";
            try {
                if (com.tencent.mm.sdk.a.b.cfx() && e.bO("/sdcard/reportConfig-android.xml")) {
                    e = e.e("/sdcard/reportConfig-android.xml", 0, -1);
                    x.w("MicroMsg.ClickFlowStatReceiver", "parseAndApplyString: use /sdcard/reportConfig-android.xml as config, cgi config is ignored!!!");
                    str = e != null ? new String(e) : "";
                }
                if (TextUtils.isEmpty(str)) {
                    x.i("MicroMsg.ClickFlowStatReceiver", "parseAndApplyString xml is empty and don't use /sdcard/reportConfig-android.xml");
                } else {
                    cVar.a(a.mO(str));
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", e2, "", new Object[0]);
                x.e("MicroMsg.ClickFlowStatReceiver", "parseAndApplyString throwable :%s %s", e2.getMessage(), bi.i(e2));
                v(15013, bi.i(e2));
            }
        }
        if (!bp(longValue)) {
            long Wx = bi.Wx();
            long a = bi.a(aVar.WG("LAST_UPDATE_CONFIG"), 0);
            long j = a - Wx > 432000 ? 0 : a;
            str = (j <= 0 || cVar.hRU <= 0 || cVar.hRU + j < Wx) ? 1 : null;
            boolean z = str != null && cVar.hRQ + 3600 < Wx;
            x.i("MicroMsg.ClickFlowStatReceiver", "readReportConfig shouldUpdate:%b now:%d lastCheckUpdateConfigDiff:%d lastUpdate:%d diff:%d  updateintval:%d", Boolean.valueOf(z), Long.valueOf(Wx), Long.valueOf(Wx - cVar.hRQ), Long.valueOf(j), Long.valueOf(Wx - j), Long.valueOf(cVar.hRU));
            if (z) {
                com.tencent.mm.network.e eVar = g.Dp().gRu.hoF;
                if (eVar == null) {
                    x.d("MicroMsg.ClickFlowStatReceiver", "dispatcher is null");
                } else {
                    if (new j(new com.tencent.mm.bp.b(bi.Wj(aVar.getValue("versionBuffer")))).a(eVar, new com.tencent.mm.ad.e() {
                        public final void a(int i, int i2, String str, k kVar) {
                            if (kVar.getType() == 1126 && i == 0 && i2 == 0) {
                                final acm acm = (acm) ((j) kVar).hTp.hnR.hnY;
                                if (acm == null) {
                                    x.e("MicroMsg.ClickFlowStatReceiver", "NetSceneUpdateEventConfig onSceneEnd resp is null");
                                } else {
                                    c.this.handler.post(new Runnable() {
                                        public final void run() {
                                            String str = null;
                                            aVar.am("LAST_UPDATE_CONFIG", bi.Wx());
                                            String str2;
                                            if (acm.wsd == null || acm.wsd.oz.length <= 0 || acm.wsb == null || acm.wsb.oz.length <= 0) {
                                                Integer num;
                                                Integer valueOf;
                                                String str3 = "MicroMsg.ClickFlowStatReceiver";
                                                str2 = "OnSceneEnd NetSceneUpdateEventConfig failed, eventsampleconf:%s, versionbuffer:%s";
                                                Object[] objArr = new Object[2];
                                                if (acm.wsd == null) {
                                                    num = null;
                                                } else {
                                                    num = Integer.valueOf(acm.wsd.oz.length);
                                                }
                                                objArr[0] = num;
                                                if (acm.wsb != null) {
                                                    valueOf = Integer.valueOf(acm.wsb.oz.length);
                                                }
                                                objArr[1] = valueOf;
                                                x.e(str3, str2, objArr);
                                                return;
                                            }
                                            com.tencent.mm.plugin.report.d.pVE.a(346, 3, 1, false);
                                            str2 = bi.bA(acm.wsb.oz);
                                            String value = aVar.getValue("versionBuffer");
                                            aVar.fB("versionBuffer", str2);
                                            com.tencent.mm.bp.b bVar = acm.wsd;
                                            try {
                                                str = new String(q.v(bVar.oz), "UTF-8");
                                            } catch (Throwable e) {
                                                int i;
                                                Throwable th = e;
                                                String str4 = "MicroMsg.ClickFlowStatReceiver";
                                                String str5 = "decompress failed, configString length %d, msg:%s  [%s]";
                                                Object[] objArr2 = new Object[3];
                                                if (bVar == null) {
                                                    i = 0;
                                                } else {
                                                    i = bVar.oz.length;
                                                }
                                                objArr2[0] = Integer.valueOf(i);
                                                objArr2[1] = th.getMessage();
                                                objArr2[2] = bi.i(th);
                                                x.e(str4, str5, objArr2);
                                            }
                                            if (TextUtils.isEmpty(str)) {
                                                com.tencent.mm.plugin.report.d.pVE.a(346, 2, 1, false);
                                                return;
                                            }
                                            boolean z;
                                            try {
                                                a mO = a.mO(str);
                                                e.b(str2, str.getBytes(), str.getBytes().length);
                                                c.this.a(mO);
                                                z = true;
                                            } catch (Throwable e2) {
                                                x.e("MicroMsg.ClickFlowStatReceiver", "readReportConfig failed :%s  [%s]", e2.getMessage(), bi.i(e2));
                                                z = false;
                                            }
                                            if (!str2.equals(value)) {
                                                long j;
                                                x.i("MicroMsg.ClickFlowStatReceiver", "idKeyStat, configOK:%b", Boolean.valueOf(z));
                                                com.tencent.mm.plugin.report.d dVar = com.tencent.mm.plugin.report.d.pVE;
                                                if (z) {
                                                    j = 0;
                                                } else {
                                                    j = 1;
                                                }
                                                dVar.a(346, j, 1, false);
                                            }
                                        }
                                    });
                                }
                            }
                        }
                    }) == 0) {
                        cVar.hRQ = Wx;
                    }
                }
            }
        }
        cVar.a(longValue, arrayList, aVar);
        cVar.a(longValue, arrayList, aVar, intValue);
        if (!bp(longValue)) {
            cVar.b(longValue, arrayList, aVar);
        }
    }

    static /* synthetic */ void a(c cVar, int i, String str, int i2, long j, long j2) {
        long Wy = bi.Wy();
        if (TextUtils.isEmpty(str) || j > Wy) {
            x.e("MicroMsg.ClickFlowStatReceiver", "writeToList page:%s  start - time = %d", str, Long.valueOf(Wy - j));
            return;
        }
        b bVar = new b();
        bVar.fvo = i;
        bVar.hSe = str.contains(".") ? str.substring(str.lastIndexOf(".") + 1) : str;
        if (3 == i && ((cVar.hRS || (cVar.hRT.containsKey(bVar.hSe) && ((Boolean) cVar.hRT.get(bVar.hSe)).booleanValue())) && !AccessibilityCapture.isEnable())) {
            Object obj = (com.tencent.mm.protocal.d.vHe == null || !com.tencent.mm.protocal.d.vHe.toLowerCase().startsWith("samsung")) ? null : 1;
            if (obj == null) {
                obj = 1;
            } else {
                int i3 = 0;
                if (ad.cgj() && g.Dr().gSy && g.Do().CF()) {
                    g.Do();
                    if (!com.tencent.mm.kernel.a.Cz()) {
                        g.Do();
                        i3 = com.tencent.mm.kernel.a.Cn();
                    }
                }
                obj = (i3 == 0 || !a((long) i3, 0.01f, cVar.hRV)) ? null : 1;
            }
            if (obj != null) {
                AccessibilityCapture.enableAccessibilityCapture(ad.getContext(), cVar);
            }
        }
        if (5 == i || 6 == i) {
            bVar.fvo = 4;
        } else if (!(3 == i || 4 == i)) {
            x.i("MicroMsg.ClickFlowStatReceiver", "writeToList error opCode:%d  (%s)", Integer.valueOf(i), str);
            return;
        }
        bVar.time = j;
        bVar.elapsedTime = j2;
        cVar.hRO.add(bVar);
        x.i("MicroMsg.ClickFlowStatReceiver", "ActivityState op:%d time:%s 0x%x %s useTime:%d", Integer.valueOf(bVar.fvo), bq(bVar.time), Integer.valueOf(i2), bVar.hSe, Long.valueOf(bi.bA(Wy)));
        if (bVar.fvo == 3) {
            cVar.hRM.TN();
        } else if (bVar.fvo == 4) {
            cVar.hRM.TN();
            cVar.hRM.K(5000, 5000);
        }
    }

    public static c SV() {
        if (hRL == null) {
            synchronized (c.class) {
                if (hRL == null) {
                    hRL = new c();
                }
            }
        }
        return hRL;
    }

    public void onEvent(Event event) {
        if (event != null && event.view != null && event.activity != null && event.activity.getComponentName() != null) {
            Object shortClassName = event.activity.getComponentName().getShortClassName();
            if (shortClassName.contains(".")) {
                shortClassName = shortClassName.substring(shortClassName.lastIndexOf(".") + 1);
            }
            if (this.hRS || this.hRT.containsKey(shortClassName)) {
                d dVar = new d();
                long currentTimeMillis = System.currentTimeMillis();
                dVar.hSm = Integer.toHexString(event.view.getId());
                dVar.type = event.event.getEventType();
                dVar.time = event.elapsedTime;
                this.hRW.add(dVar);
                int[] iArr = new int[2];
                event.view.getLocationOnScreen(iArr);
                dVar.left = iArr[0];
                dVar.top = iArr[1];
                x.d("MicroMsg.ClickFlowStatReceiver", "[oneliang]id:" + dVar.hSm + ",ui:" + event.activity.getComponentName().getShortClassName() + ",left:" + dVar.left + ",top:" + dVar.top + ",time:" + dVar.time + ",cost:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public void v(String str, String str2, Object... objArr) {
        x.v("MicroMsg.ClickFlowStatReceiver", str2, objArr);
    }

    public void d(String str, String str2, Object... objArr) {
        x.d("MicroMsg.ClickFlowStatReceiver", str2, objArr);
    }

    public void i(String str, String str2, Object... objArr) {
        x.i("MicroMsg.ClickFlowStatReceiver", str2, objArr);
    }

    public void e(String str, String str2, Object... objArr) {
        x.e("MicroMsg.ClickFlowStatReceiver", str2, objArr);
    }

    public void post(Runnable runnable, String str) {
        if (this.handler != null) {
            this.handler.post(runnable);
        }
    }

    public void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        x.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", th, str2, objArr);
    }

    private c() {
        if (com.tencent.mm.sdk.a.b.cfx()) {
            Assert.assertTrue("Error: ClickFlow internal code can only run in MM process.", ad.cgj());
        }
        HandlerThread WL = com.tencent.mm.sdk.f.e.WL("ClickFlow");
        WL.start();
        this.handler = new ag(WL.getLooper());
        this.hRM = new al(WL.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
            public final boolean uG() {
                x.d("MicroMsg.ClickFlowStatReceiver", "monitorHandler ScreenOn:%s isTop:%s top:%s ", Boolean.valueOf(m.eK(ad.getContext())), Boolean.valueOf(!bi.oN(c.by(ad.getContext()))), c.by(ad.getContext()));
                if (m.eK(ad.getContext()) && r0) {
                    return true;
                }
                c.this.handler.post(new Runnable() {
                    public final void run() {
                        c.a(c.this);
                    }
                });
                return false;
            }
        }, true);
    }

    public final void SW() {
        long Wy = bi.Wy();
        x.w("MicroMsg.ClickFlowStatReceiver", "commitNow return:%s time:%d", (Boolean) new bd<Boolean>(Boolean.valueOf(false)) {
            protected final /* synthetic */ Object run() {
                c.a(c.this);
                return Boolean.valueOf(true);
            }
        }.b(this.handler), Long.valueOf(bi.bA(Wy)));
    }

    public final void r(final Intent intent) {
        if (intent != null && intent.getAction().equals("com.tencent.mm.Intent.ACTION_CLICK_FLOW_REPORT")) {
            this.handler.post(new Runnable() {
                public final void run() {
                    String stringExtra = intent.getStringExtra("ui");
                    int intExtra = intent.getIntExtra("uiHashCode", 0);
                    int intExtra2 = intent.getIntExtra("opCode", 0);
                    x.d("MicroMsg.ClickFlowStatReceiver", "onReceive op:%d ui:%s hash:0x%x time:%d, elapsed time:%d", Integer.valueOf(intExtra2), stringExtra, Integer.valueOf(intExtra), Long.valueOf(bi.bA(intent.getLongExtra("nowMilliSecond", 0))), Long.valueOf(intent.getLongExtra("elapsedRealtime", 0)));
                    if (2147483632 == intExtra2) {
                        c.a(c.this);
                    } else {
                        c.a(c.this, intExtra2, stringExtra, intExtra, r4, r6);
                    }
                }
            });
        }
    }

    private static boolean bp(long j) {
        return j == 0;
    }

    private Pair<Integer, ArrayList<b>> g(ArrayList<b> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        long Wy = bi.Wy();
        try {
            b bVar;
            Object arrayList3 = new ArrayList();
            long j = 0;
            int i = 0;
            while (i < arrayList.size()) {
                bVar = (b) arrayList.get(i);
                if (bVar.time < 0 || bVar.time > Wy || Wy - bVar.time > 50400000) {
                    x.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err timestamp:%d diff:%d opcode:%d page:%s", Long.valueOf(bVar.time), Long.valueOf(Wy - bVar.time), Integer.valueOf(bVar.fvo), bVar.hSe);
                    return null;
                }
                long j2;
                if (bVar.fvo == 4) {
                    if (j < bVar.time) {
                        j2 = bVar.time;
                    }
                    j2 = j;
                } else if (bVar.fvo != 3) {
                    x.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err Opcode:%d %s", Integer.valueOf(bVar.fvo), bVar.hSe);
                    return null;
                } else {
                    arrayList3.add(bVar);
                    j2 = j;
                }
                i++;
                j = j2;
            }
            if (arrayList3.size() == 0) {
                return null;
            }
            Collections.sort(arrayList3);
            Collections.sort(this.hRW);
            bVar = new b();
            Iterator it = arrayList3.iterator();
            b bVar2 = bVar;
            while (it.hasNext()) {
                bVar = (b) it.next();
                if (!bVar.hSe.equals(bVar2.hSe)) {
                    a(bVar2, bVar.elapsedTime);
                    arrayList2.add(bVar);
                    bVar2.hSf = bVar.time;
                    bVar2 = bVar;
                } else if (bVar.time - bVar2.time > 10800000) {
                    x.i("MicroMsg.ClickFlowStatReceiver", "[oneliang]Duplicate resume info check,current resume info time:%s,previous resume info time:%s", Long.valueOf(bVar.time), Long.valueOf(bVar2.time));
                    bVar2.time = bVar.time;
                }
            }
            if (!arrayList2.isEmpty()) {
                a((b) arrayList2.get(arrayList2.size() - 1), j);
            }
            bVar2.hSf = ((b) arrayList.get(arrayList.size() - 1)).time;
            if (((b) arrayList2.get(arrayList2.size() - 1)).time > j) {
                ((b) arrayList2.get(arrayList2.size() - 1)).hSf = Wy;
            } else if (j > Wy) {
                ((b) arrayList2.get(arrayList2.size() - 1)).hSf = Wy;
            }
            if (((b) arrayList2.get(arrayList2.size() - 1)).hSf - ((b) arrayList2.get(0)).time > 50400000) {
                x.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err list time");
                return null;
            }
            x.i("MicroMsg.ClickFlowStatReceiver", "getResumeList errType:%d list:%d time:%d", Integer.valueOf(0), Integer.valueOf(arrayList2.size()), Long.valueOf(bi.bA(Wy)));
            return Pair.create(Integer.valueOf(0), arrayList2);
        } catch (Throwable e) {
            v(15008, bi.i(e));
            x.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed %s", bi.i(e));
            return null;
        }
    }

    private void a(b bVar, long j) {
        if (bVar.elapsedTime > 0) {
            int c = c(bVar.elapsedTime, 0, this.hRW.isEmpty() ? 0 : this.hRW.size() - 1);
            if (c != -1) {
                if (bVar.hRW == null) {
                    bVar.hRW = new ArrayList();
                }
                int size = this.hRW.size();
                int i = c;
                while (i < size) {
                    d dVar = (d) this.hRW.get(i);
                    if (dVar.time > bVar.elapsedTime && dVar.time <= j) {
                        bVar.hRW.add(dVar);
                    }
                    if (dVar.time < j) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private int c(long j, int i, int i2) {
        if (this.hRW == null || this.hRW.isEmpty()) {
            return -1;
        }
        int i3 = (i + i2) / 2;
        if (i2 - i == 0 || i2 - i == 1) {
            if (j < ((d) this.hRW.get(i2)).time) {
                return i;
            }
            return i2;
        } else if (j < ((d) this.hRW.get(i3)).time) {
            return c(j, i, i3);
        } else {
            return j > ((d) this.hRW.get(i3)).time ? c(j, i3, i2) : i3;
        }
    }

    private static void v(int i, String str) {
        com.tencent.mm.plugin.report.d.pVE.k(13328, i + ",0,0,0,0,0,0,0,0,0,0,0,0," + str);
    }

    private void a(a aVar) {
        this.hRU = aVar.hRU;
        if (this.hRU <= 0 || this.hRU > 432000) {
            this.hRU = 432000;
        }
        this.hRV = aVar.hRV;
        this.hRR.clear();
        this.hRR.addAll(aVar.hSd);
        this.hRT.clear();
        this.hRT.putAll(aVar.hRT);
        if (this.hRT.containsKey("*") && ((Boolean) this.hRT.get("*")).booleanValue()) {
            this.hRS = true;
        }
        x.i("MicroMsg.ClickFlowStatReceiver", "applyConfig OK evenCount:%d nextUpdateInterval:%d samplePeriod:%d", Integer.valueOf(this.hRR.size()), Long.valueOf(this.hRU), Long.valueOf(this.hRV));
    }

    private static boolean a(long j, float f, long j2) {
        if (com.tencent.mm.sdk.a.b.cfx()) {
            return true;
        }
        if (f <= 0.0f) {
            return false;
        }
        long j3;
        boolean z;
        int i = 10000 / ((int) (10000.0f * f));
        int i2 = (int) j;
        i2 = (i2 ^ (i2 >> 16)) * 73244475;
        i2 = (i2 ^ (i2 >> 16)) * 73244475;
        int i3 = ((i2 >> 16) ^ i2) % i;
        long Wx = bi.Wx();
        if (j2 == 0) {
            j3 = 259200;
        } else {
            j3 = j2;
        }
        if (i3 == ((int) ((Wx / j3) % ((long) i)))) {
            z = true;
        } else {
            z = false;
        }
        x.v("MicroMsg.ClickFlowStatReceiver", "checkRate %b uin:%s rate:%s period:%s rec:%s x:%s uinMod:%s timeMod:%s", Boolean.valueOf(z), Long.valueOf(j), Float.valueOf(f), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(r5), Integer.valueOf(i3), Integer.valueOf(r1));
        return z;
    }

    private static void a(List<b> list, c cVar, SparseArray<String> sparseArray) {
        int i = 0;
        String str = cVar.hSj;
        int i2 = -1;
        switch (str.hashCode()) {
            case -929554094:
                if (str.equals("respective")) {
                    i2 = 1;
                    break;
                }
                break;
            case 3117816:
                if (str.equals("ends")) {
                    i2 = 2;
                    break;
                }
                break;
            case 3433103:
                if (str.equals("page")) {
                    i2 = 0;
                    break;
                }
                break;
            case 379114255:
                if (str.equals("continuous")) {
                    i2 = 3;
                    break;
                }
                break;
        }
        int i3;
        int i4;
        switch (i2) {
            case 0:
                x.i("MicroMsg.ClickFlowStatReceiver", "type: page, handle %s", cVar);
                sparseArray.put(cVar.hSi, bi.oM((String) sparseArray.get(cVar.hSi)) + cVar.id + ";");
                return;
            case 1:
                x.i("MicroMsg.ClickFlowStatReceiver", "type: respective, handle %s", cVar);
                for (i2 = 0; i2 < list.size(); i2 = i3 + 1) {
                    i4 = 0;
                    i3 = i2;
                    while (i4 < cVar.hSk.size()) {
                        int size;
                        if (((String) ((Pair) cVar.hSk.get(i4)).first).equals(((b) list.get(i3)).hSe)) {
                            sparseArray.put(cVar.hSi, bi.oM((String) sparseArray.get(cVar.hSi)) + cVar.id + ";");
                            i4 = cVar.hSk.size();
                            size = list.size();
                        } else {
                            size = i3;
                        }
                        i4++;
                        i3 = size;
                    }
                }
                return;
            case 2:
                x.i("MicroMsg.ClickFlowStatReceiver", "type: ends, handle %s", cVar);
                if (list.size() >= 2) {
                    if ((cVar.hSk.size() == 2 ? 1 : 0) == 0) {
                        x.e("MicroMsg.ClickFlowStatReceiver", "ends's pages size is not 2: " + cVar.hSk.toString());
                        return;
                    }
                    String str2 = (String) ((Pair) cVar.hSk.get(1)).first;
                    if (((b) list.get(0)).hSe.equals((String) ((Pair) cVar.hSk.get(0)).first) && ((b) list.get(list.size() - 1)).hSe.equals(str2)) {
                        sparseArray.put(cVar.hSi, bi.oM((String) sparseArray.get(cVar.hSi)) + cVar.id + ";");
                        return;
                    }
                    return;
                }
                return;
            case 3:
                x.i("MicroMsg.ClickFlowStatReceiver", "type: continuous, handle %s", cVar);
                List list2 = cVar.hSk;
                if (list2.size() > 0) {
                    for (i2 = list2.size() - 1; i2 < list.size(); i2 = (list2.size() - i4) + i3) {
                        i4 = list2.size() - 1;
                        i3 = i2;
                        while (((String) ((Pair) list2.get(i4)).first).equals(((b) list.get(i3)).hSe)) {
                            if (i4 == 0) {
                                i = 1;
                            } else {
                                i4--;
                                i3--;
                            }
                        }
                    }
                }
                if (i != 0) {
                    sparseArray.put(cVar.hSi, bi.oM((String) sparseArray.get(cVar.hSi)) + cVar.id + ";");
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void a(long j, ArrayList<b> arrayList, com.tencent.mm.sdk.e.a aVar) {
        c cVar;
        long j2 = ((b) arrayList.get(0)).time;
        long j3 = ((b) arrayList.get(arrayList.size() - 1)).hSf;
        long Wx = bi.Wx();
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= this.hRR.size()) {
                    cVar = null;
                    break;
                } else if ("app".equals(((c) this.hRR.get(i2)).hSj)) {
                    cVar = (c) this.hRR.get(i2);
                    break;
                } else {
                    i = i2 + 1;
                }
            } catch (Throwable e) {
                v(15004, bi.i(e));
                x.e("MicroMsg.ClickFlowStatReceiver", "report ev:1 exception : %s", bi.i(e));
                return;
            }
        }
        if (cVar == null) {
            x.i("MicroMsg.ClickFlowStatReceiver", "type: app, skip null");
            if (bp(j)) {
                a(aVar, 13604, 100001, j2, j3);
            } else {
                x.i("MicroMsg.ClickFlowStatReceiver", "type: app, event null, uin not zero");
            }
        } else if (cVar.hSg <= Wx || !a(j, cVar.hSh, this.hRV)) {
            x.i("MicroMsg.ClickFlowStatReceiver", "type: app, skip %s, now:%d", cVar, Long.valueOf(Wx));
        } else {
            x.i("MicroMsg.ClickFlowStatReceiver", "type: app, handle %s, now:%d", cVar, Long.valueOf(Wx));
            a(aVar, cVar.hSi, cVar.id, j2, j3);
        }
    }

    private static void a(com.tencent.mm.sdk.e.a aVar, int i, int i2, long j, long j2) {
        long Wy = bi.Wy();
        if (j > j2 || j < 0 || j2 < 0 || j > Wy || j2 > Wy) {
            x.e("MicroMsg.ClickFlowStatReceiver", "reportAppInternal ErrorParam begin:%d end:%d now:%d", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(Wy));
            return;
        }
        int e = bi.e(aVar.WH("SEQ_" + i));
        aVar.da("SEQ_" + i, e + 1);
        Wy = bi.c(aVar.WG("LastQuit_" + i2));
        aVar.am("LastQuit_" + i2, j2);
        if (Wy <= 0 || Wy > j) {
            Wy = j;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("t", 1).put("tbe", j / 1000).put("ten", j2 / 1000).put("in", (j2 - j) / 1000).put("lten", Wy / 1000).put("inbg", (j - Wy) / 1000);
        a(i, String.valueOf(i2), e, jSONObject.toString());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(long r18, java.util.ArrayList<com.tencent.mm.modelstat.c.b> r20, com.tencent.mm.sdk.e.a r21, int r22) {
        /*
        r17 = this;
        r6 = com.tencent.mm.sdk.platformtools.bi.Wy();	 Catch:{ Exception -> 0x01b5 }
        r8 = new org.json.JSONArray;	 Catch:{ Exception -> 0x01b5 }
        r8.<init>();	 Catch:{ Exception -> 0x01b5 }
        r2 = 0;
        r5 = r2;
    L_0x000b:
        r2 = r20.size();	 Catch:{ Exception -> 0x01b5 }
        if (r5 >= r2) goto L_0x0106;
    L_0x0011:
        r9 = new org.json.JSONObject;	 Catch:{ Exception -> 0x01b5 }
        r9.<init>();	 Catch:{ Exception -> 0x01b5 }
        r0 = r20;
        r2 = r0.get(r5);	 Catch:{ Exception -> 0x01b5 }
        r2 = (com.tencent.mm.modelstat.c.b) r2;	 Catch:{ Exception -> 0x01b5 }
        r10 = r2.hSf;	 Catch:{ Exception -> 0x01b5 }
        r12 = r2.time;	 Catch:{ Exception -> 0x01b5 }
        r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r3 < 0) goto L_0x0042;
    L_0x0026:
        r10 = r2.time;	 Catch:{ Exception -> 0x01b5 }
        r12 = 0;
        r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r3 < 0) goto L_0x0042;
    L_0x002e:
        r10 = r2.hSf;	 Catch:{ Exception -> 0x01b5 }
        r12 = 0;
        r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r3 < 0) goto L_0x0042;
    L_0x0036:
        r10 = r2.hSf;	 Catch:{ Exception -> 0x01b5 }
        r3 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1));
        if (r3 > 0) goto L_0x0042;
    L_0x003c:
        r10 = r2.time;	 Catch:{ Exception -> 0x01b5 }
        r3 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1));
        if (r3 <= 0) goto L_0x0068;
    L_0x0042:
        r3 = "MicroMsg.ClickFlowStatReceiver";
        r4 = "reportPage ErrorTime: [%d, %d]  now:%d ";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x01b5 }
        r8 = 0;
        r10 = r2.time;	 Catch:{ Exception -> 0x01b5 }
        r9 = java.lang.Long.valueOf(r10);	 Catch:{ Exception -> 0x01b5 }
        r5[r8] = r9;	 Catch:{ Exception -> 0x01b5 }
        r8 = 1;
        r10 = r2.hSf;	 Catch:{ Exception -> 0x01b5 }
        r2 = java.lang.Long.valueOf(r10);	 Catch:{ Exception -> 0x01b5 }
        r5[r8] = r2;	 Catch:{ Exception -> 0x01b5 }
        r2 = 2;
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ Exception -> 0x01b5 }
        r5[r2] = r6;	 Catch:{ Exception -> 0x01b5 }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);	 Catch:{ Exception -> 0x01b5 }
    L_0x0067:
        return;
    L_0x0068:
        r3 = "p";
        r4 = r2.hSe;	 Catch:{ Exception -> 0x01b5 }
        r3 = r9.put(r3, r4);	 Catch:{ Exception -> 0x01b5 }
        r4 = "tbe";
        r10 = r2.time;	 Catch:{ Exception -> 0x01b5 }
        r12 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r10 = r10 / r12;
        r3 = r3.put(r4, r10);	 Catch:{ Exception -> 0x01b5 }
        r4 = "in";
        r10 = r2.hSf;	 Catch:{ Exception -> 0x01b5 }
        r12 = r2.time;	 Catch:{ Exception -> 0x01b5 }
        r10 = r10 - r12;
        r12 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r10 = r10 / r12;
        r3.put(r4, r10);	 Catch:{ Exception -> 0x01b5 }
        r3 = r2.hRW;	 Catch:{ Exception -> 0x01b5 }
        if (r3 == 0) goto L_0x00fe;
    L_0x008f:
        r3 = r2.hRW;	 Catch:{ Exception -> 0x01b5 }
        r3 = r3.isEmpty();	 Catch:{ Exception -> 0x01b5 }
        if (r3 != 0) goto L_0x00fe;
    L_0x0097:
        r10 = new org.json.JSONArray;	 Catch:{ Exception -> 0x01b5 }
        r10.<init>();	 Catch:{ Exception -> 0x01b5 }
        r3 = 0;
        r4 = r3;
    L_0x009e:
        r3 = r2.hRW;	 Catch:{ Exception -> 0x01b5 }
        r3 = r3.size();	 Catch:{ Exception -> 0x01b5 }
        if (r4 >= r3) goto L_0x00f8;
    L_0x00a6:
        r3 = r2.hRW;	 Catch:{ Exception -> 0x01b5 }
        r3 = r3.get(r4);	 Catch:{ Exception -> 0x01b5 }
        r3 = (com.tencent.mm.modelstat.c.d) r3;	 Catch:{ Exception -> 0x01b5 }
        r11 = new org.json.JSONObject;	 Catch:{ Exception -> 0x01b5 }
        r11.<init>();	 Catch:{ Exception -> 0x01b5 }
        r12 = "w";
        r13 = r3.hSm;	 Catch:{ Exception -> 0x01b5 }
        r12 = r11.put(r12, r13);	 Catch:{ Exception -> 0x01b5 }
        r13 = "t";
        r14 = r3.type;	 Catch:{ Exception -> 0x01b5 }
        r12 = r12.put(r13, r14);	 Catch:{ Exception -> 0x01b5 }
        r13 = "tbp";
        r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01b5 }
        r15 = "{";
        r14.<init>(r15);	 Catch:{ Exception -> 0x01b5 }
        r15 = r3.left;	 Catch:{ Exception -> 0x01b5 }
        r14 = r14.append(r15);	 Catch:{ Exception -> 0x01b5 }
        r15 = ";";
        r14 = r14.append(r15);	 Catch:{ Exception -> 0x01b5 }
        r3 = r3.top;	 Catch:{ Exception -> 0x01b5 }
        r3 = r14.append(r3);	 Catch:{ Exception -> 0x01b5 }
        r14 = "}";
        r3 = r3.append(r14);	 Catch:{ Exception -> 0x01b5 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x01b5 }
        r12.put(r13, r3);	 Catch:{ Exception -> 0x01b5 }
        r10.put(r11);	 Catch:{ Exception -> 0x01b5 }
        r3 = r4 + 1;
        r4 = r3;
        goto L_0x009e;
    L_0x00f8:
        r2 = "wf";
        r9.put(r2, r10);	 Catch:{ Exception -> 0x01b5 }
    L_0x00fe:
        r8.put(r9);	 Catch:{ Exception -> 0x01b5 }
        r2 = r5 + 1;
        r5 = r2;
        goto L_0x000b;
    L_0x0106:
        r4 = new org.json.JSONObject;	 Catch:{ Exception -> 0x01b5 }
        r4.<init>();	 Catch:{ Exception -> 0x01b5 }
        r2 = "t";
        r3 = 2;
        r2 = r4.put(r2, r3);	 Catch:{ Exception -> 0x01b5 }
        r3 = "errt";
        r0 = r22;
        r2 = r2.put(r3, r0);	 Catch:{ Exception -> 0x01b5 }
        r3 = "pf";
        r2.put(r3, r8);	 Catch:{ Exception -> 0x01b5 }
        r2 = bp(r18);	 Catch:{ Exception -> 0x01b5 }
        if (r2 == 0) goto L_0x014b;
    L_0x0128:
        r2 = "SEQ_13604";
        r0 = r21;
        r2 = r0.WH(r2);	 Catch:{ Exception -> 0x01b5 }
        r2 = com.tencent.mm.sdk.platformtools.bi.e(r2);	 Catch:{ Exception -> 0x01b5 }
        r3 = "SEQ_13604";
        r5 = r2 + 1;
        r0 = r21;
        r0.da(r3, r5);	 Catch:{ Exception -> 0x01b5 }
        r3 = 13604; // 0x3524 float:1.9063E-41 double:6.7213E-320;
        r5 = "100002";
        r6 = r4.toString();	 Catch:{ Exception -> 0x01b5 }
        a(r3, r5, r2, r6);	 Catch:{ Exception -> 0x01b5 }
    L_0x014b:
        r5 = new android.util.SparseArray;	 Catch:{ Exception -> 0x01b5 }
        r5.<init>();	 Catch:{ Exception -> 0x01b5 }
        r0 = r17;
        r2 = r0.hRR;	 Catch:{ Exception -> 0x01b5 }
        r2 = r2.size();	 Catch:{ Exception -> 0x01b5 }
        if (r2 != 0) goto L_0x0163;
    L_0x015a:
        r2 = "MicroMsg.ClickFlowStatReceiver";
        r3 = "type: page, no event";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);	 Catch:{ Exception -> 0x01b5 }
    L_0x0163:
        r2 = 0;
        r3 = r2;
    L_0x0165:
        r0 = r17;
        r2 = r0.hRR;	 Catch:{ Exception -> 0x01b5 }
        r2 = r2.size();	 Catch:{ Exception -> 0x01b5 }
        if (r3 >= r2) goto L_0x01d4;
    L_0x016f:
        r0 = r17;
        r2 = r0.hRR;	 Catch:{ Exception -> 0x01b5 }
        r2 = r2.get(r3);	 Catch:{ Exception -> 0x01b5 }
        r2 = (com.tencent.mm.modelstat.c.c) r2;	 Catch:{ Exception -> 0x01b5 }
        r6 = r2.hSg;	 Catch:{ Exception -> 0x01b5 }
        r8 = com.tencent.mm.sdk.platformtools.bi.Wx();	 Catch:{ Exception -> 0x01b5 }
        r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r6 <= 0) goto L_0x019a;
    L_0x0183:
        r6 = r2.hSh;	 Catch:{ Exception -> 0x01b5 }
        r0 = r17;
        r8 = r0.hRV;	 Catch:{ Exception -> 0x01b5 }
        r0 = r18;
        r6 = a(r0, r6, r8);	 Catch:{ Exception -> 0x01b5 }
        if (r6 == 0) goto L_0x019a;
    L_0x0191:
        r0 = r20;
        a(r0, r2, r5);	 Catch:{ Exception -> 0x01b5 }
    L_0x0196:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x0165;
    L_0x019a:
        r6 = "MicroMsg.ClickFlowStatReceiver";
        r7 = "type: page, skip %s, now: %d";
        r8 = 2;
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x01b5 }
        r9 = 0;
        r8[r9] = r2;	 Catch:{ Exception -> 0x01b5 }
        r2 = 1;
        r10 = com.tencent.mm.sdk.platformtools.bi.Wx();	 Catch:{ Exception -> 0x01b5 }
        r9 = java.lang.Long.valueOf(r10);	 Catch:{ Exception -> 0x01b5 }
        r8[r2] = r9;	 Catch:{ Exception -> 0x01b5 }
        com.tencent.mm.sdk.platformtools.x.i(r6, r7, r8);	 Catch:{ Exception -> 0x01b5 }
        goto L_0x0196;
    L_0x01b5:
        r2 = move-exception;
        r3 = 15005; // 0x3a9d float:2.1026E-41 double:7.4135E-320;
        r4 = com.tencent.mm.sdk.platformtools.bi.i(r2);
        v(r3, r4);
        r3 = "MicroMsg.ClickFlowStatReceiver";
        r4 = "report ev:2 exception : %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r2 = com.tencent.mm.sdk.platformtools.bi.i(r2);
        r5[r6] = r2;
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);
        goto L_0x0067;
    L_0x01d4:
        r2 = 0;
        r3 = r2;
    L_0x01d6:
        r2 = r5.size();	 Catch:{ Exception -> 0x01b5 }
        if (r3 >= r2) goto L_0x0067;
    L_0x01dc:
        r6 = r5.keyAt(r3);	 Catch:{ Exception -> 0x01b5 }
        r2 = r5.get(r6);	 Catch:{ Exception -> 0x01b5 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x01b5 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01b5 }
        r8 = "SEQ_";
        r7.<init>(r8);	 Catch:{ Exception -> 0x01b5 }
        r7 = r7.append(r6);	 Catch:{ Exception -> 0x01b5 }
        r7 = r7.toString();	 Catch:{ Exception -> 0x01b5 }
        r0 = r21;
        r7 = r0.WH(r7);	 Catch:{ Exception -> 0x01b5 }
        r7 = com.tencent.mm.sdk.platformtools.bi.e(r7);	 Catch:{ Exception -> 0x01b5 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01b5 }
        r9 = "SEQ_";
        r8.<init>(r9);	 Catch:{ Exception -> 0x01b5 }
        r8 = r8.append(r6);	 Catch:{ Exception -> 0x01b5 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x01b5 }
        r9 = r7 + 1;
        r0 = r21;
        r0.da(r8, r9);	 Catch:{ Exception -> 0x01b5 }
        r8 = r4.toString();	 Catch:{ Exception -> 0x01b5 }
        a(r6, r2, r7, r8);	 Catch:{ Exception -> 0x01b5 }
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x01d6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelstat.c.a(long, java.util.ArrayList, com.tencent.mm.sdk.e.a, int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(long r38, java.util.ArrayList<com.tencent.mm.modelstat.c.b> r40, com.tencent.mm.sdk.e.a r41) {
        /*
        r37 = this;
        r18 = com.tencent.mm.sdk.platformtools.bi.Wy();
        r4 = r40.size();
        r4 = r4 + -1;
        r0 = r40;
        r4 = r0.get(r4);
        r4 = (com.tencent.mm.modelstat.c.b) r4;
        r0 = r4.hSf;
        r20 = r0;
        r4 = 0;
        r4 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x0020;
    L_0x001c:
        r4 = (r20 > r18 ? 1 : (r20 == r18 ? 0 : -1));
        if (r4 <= 0) goto L_0x003b;
    L_0x0020:
        r4 = "MicroMsg.ClickFlowStatReceiver";
        r5 = "reportStat  ErrorTime end:%d now:%d";
        r6 = 2;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = java.lang.Long.valueOf(r20);
        r6[r7] = r8;
        r7 = 1;
        r8 = java.lang.Long.valueOf(r18);
        r6[r7] = r8;
        com.tencent.mm.sdk.platformtools.x.e(r4, r5, r6);
    L_0x003a:
        return;
    L_0x003b:
        r22 = com.tencent.mm.sdk.platformtools.bi.Wx();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = r37;
        r5 = r0.hRP;
        r4 = r4.append(r5);
        r5 = "stg_20971520_";
        r4 = r4.append(r5);
        r0 = r38;
        r4 = r4.append(r0);
        r5 = ".HashMap";
        r4 = r4.append(r5);
        r17 = r4.toString();
        r6 = mN(r17);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = java.lang.Long.valueOf(r20);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r40;
        r6.put(r4, r0);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = r6.entrySet();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = r4.iterator();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
    L_0x0079:
        r4 = r5.hasNext();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r4 == 0) goto L_0x00b0;
    L_0x007f:
        r4 = r5.next();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = (java.util.Map.Entry) r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = r4.getKey();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = (java.lang.Long) r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r8 = r4.longValue();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r10 = 259200000; // 0xf731400 float:1.1984677E-29 double:1.280618154E-315;
        r8 = r8 + r10;
        r4 = (r8 > r20 ? 1 : (r8 == r20 ? 0 : -1));
        if (r4 >= 0) goto L_0x0079;
    L_0x0097:
        r5.remove();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        goto L_0x0079;
    L_0x009b:
        r4 = move-exception;
        r5 = "MicroMsg.ClickFlowStatReceiver";
        r6 = "report ev:4 exception : %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r4 = com.tencent.mm.sdk.platformtools.bi.i(r4);
        r7[r8] = r4;
        com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
        goto L_0x003a;
    L_0x00b0:
        r0 = r37;
        r1 = r17;
        r0.a(r1, r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = com.tencent.mm.sdk.a.b.cfx();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r4 == 0) goto L_0x0116;
    L_0x00bd:
        r4 = 180000; // 0x2bf20 float:2.52234E-40 double:8.8932E-319;
    L_0x00c0:
        r7 = "LAST_REPORT_STATISITIC_TIME";
        r0 = r41;
        r7 = r0.WG(r7);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r8 = 0;
        r8 = com.tencent.mm.sdk.platformtools.bi.a(r7, r8);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r10 = r8 + r4;
        r7 = (r10 > r20 ? 1 : (r10 == r20 ? 0 : -1));
        if (r7 <= 0) goto L_0x011a;
    L_0x00d5:
        r6 = "MicroMsg.ClickFlowStatReceiver";
        r7 = "type: stat, skip all, lastStatisticTime: %d, end: %d, FREQ: %d";
        r10 = 3;
        r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r11 = 0;
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r10[r11] = r8;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r8 = 1;
        r9 = java.lang.Long.valueOf(r20);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r10[r8] = r9;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r8 = 2;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r10[r8] = r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.x.i(r6, r7, r10);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        goto L_0x003a;
    L_0x00f8:
        r4 = move-exception;
        com.tencent.mm.loader.stub.b.deleteFile(r17);
        java.lang.System.gc();
        r5 = "MicroMsg.ClickFlowStatReceiver";
        r6 = "OutOfMemoryError";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
        r5 = 15010; // 0x3aa2 float:2.1033E-41 double:7.416E-320;
        r4 = com.tencent.mm.sdk.platformtools.bi.i(r4);
        v(r5, r4);
        goto L_0x003a;
    L_0x0116:
        r4 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        goto L_0x00c0;
    L_0x011a:
        r4 = "LAST_REPORT_STATISITIC_TIME";
        r0 = r41;
        r1 = r20;
        r0.am(r4, r1);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r24 = new java.util.HashMap;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r24.<init>();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = r6.keySet();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = r4.iterator();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
    L_0x0131:
        r4 = r5.hasNext();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r4 == 0) goto L_0x014f;
    L_0x0137:
        r4 = r5.next();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = (java.lang.Long) r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r10 = r4.longValue();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));
        if (r7 <= 0) goto L_0x0131;
    L_0x0145:
        r7 = r6.get(r4);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r24;
        r0.put(r4, r7);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        goto L_0x0131;
    L_0x014f:
        r8 = 0;
        r6 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r25 = new java.util.HashMap;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r25.<init>();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r26 = new java.util.HashMap;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r26.<init>();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r27 = new java.util.HashMap;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r27.<init>();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r28 = new java.util.HashMap;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r28.<init>();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r29 = new java.util.HashMap;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r29.<init>();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = 0;
        r4 = 0;
        r10 = r4;
    L_0x0172:
        r0 = r37;
        r4 = r0.hRR;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = r4.size();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r10 >= r4) goto L_0x0791;
    L_0x017c:
        r11 = "pagestat";
        r0 = r37;
        r4 = r0.hRR;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = r4.get(r10);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = (com.tencent.mm.modelstat.c.c) r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = r4.hSj;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = r11.equals(r4);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r4 == 0) goto L_0x022f;
    L_0x0191:
        r0 = r37;
        r4 = r0.hRR;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = r4.get(r10);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = (com.tencent.mm.modelstat.c.c) r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r16 = r4;
    L_0x019d:
        r4 = "MicroMsg.ClickFlowStatReceiver";
        r5 = "[oneliang] click flow session count:%s";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r11 = 0;
        r12 = r24.size();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r12 = java.lang.Integer.valueOf(r12);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r10[r11] = r12;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r10);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = r24.keySet();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r30 = r4.iterator();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
    L_0x01bc:
        r4 = r30.hasNext();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r4 == 0) goto L_0x03ff;
    L_0x01c2:
        r4 = r30.next();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = (java.lang.Long) r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r10 = r4.longValue();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r5 <= 0) goto L_0x078e;
    L_0x01d0:
        r6 = r4.longValue();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r12 = r6;
    L_0x01d5:
        r5 = "MicroMsg.ClickFlowStatReceiver";
        r6 = "find min key,min key:%s,cur key:%s";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r10 = 0;
        r11 = java.lang.Long.valueOf(r12);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7[r10] = r11;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r10 = 1;
        r7[r10] = r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r24;
        r4 = r0.get(r4);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = (java.util.ArrayList) r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = r4.size();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = r5 + -1;
        r5 = r4.get(r5);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = (com.tencent.mm.modelstat.c.b) r5;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r5.hSf;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = 0;
        r5 = r4.get(r5);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = (com.tencent.mm.modelstat.c.b) r5;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r10 = r5.time;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r6 - r10;
        r14 = r8 + r6;
        r6 = 0;
        r5 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1));
        if (r5 < 0) goto L_0x021a;
    L_0x0213:
        r6 = 172800000; // 0xa4cb800 float:9.856849E-33 double:8.53745436E-316;
        r5 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x0234;
    L_0x021a:
        r4 = "MicroMsg.ClickFlowStatReceiver";
        r5 = "reportStat ErrorTime sumInFg:%d";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = 0;
        r8 = java.lang.Long.valueOf(r14);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.x.e(r4, r5, r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        goto L_0x003a;
    L_0x022f:
        r4 = r10 + 1;
        r10 = r4;
        goto L_0x0172;
    L_0x0234:
        r6 = 0;
        r5 = 0;
        r10 = r5;
        r11 = r6;
    L_0x0238:
        r5 = r4.size();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r10 >= r5) goto L_0x03af;
    L_0x023e:
        r5 = r4.get(r10);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = (com.tencent.mm.modelstat.c.b) r5;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = "MicroMsg.ClickFlowStatReceiver";
        r8 = "pageIntervalMap page:%s old:%d  new[%d,%d,%d]";
        r6 = 5;
        r9 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = 0;
        r0 = r5.hSe;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r31 = r0;
        r9[r6] = r31;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r31 = 1;
        r6 = r5.hSe;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r25;
        r6 = r0.get(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = (java.lang.Long) r6;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r32 = com.tencent.mm.sdk.platformtools.bi.c(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = java.lang.Long.valueOf(r32);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r9[r31] = r6;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = 2;
        r0 = r5.hSf;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r32 = r0;
        r31 = java.lang.Long.valueOf(r32);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r9[r6] = r31;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = 3;
        r0 = r5.time;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r32 = r0;
        r31 = java.lang.Long.valueOf(r32);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r9[r6] = r31;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = 4;
        r0 = r5.hSf;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r32 = r0;
        r0 = r5.time;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r34 = r0;
        r32 = r32 - r34;
        r31 = java.lang.Long.valueOf(r32);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r9[r6] = r31;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.x.v(r7, r8, r9);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r5.hSf;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r8 = r5.time;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r6 - r8;
        r8 = 0;
        r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r8 < 0) goto L_0x02a6;
    L_0x029f:
        r8 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r8 <= 0) goto L_0x078b;
    L_0x02a6:
        r8 = "MicroMsg.ClickFlowStatReceiver";
        r9 = "pageIntervalMap ErrorTime [%d,%d] now:%d diff:%d";
        r31 = 4;
        r0 = r31;
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r31 = r0;
        r32 = 0;
        r0 = r5.time;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r34 = r0;
        r33 = java.lang.Long.valueOf(r34);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r31[r32] = r33;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r32 = 1;
        r0 = r5.hSf;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r34 = r0;
        r33 = java.lang.Long.valueOf(r34);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r31[r32] = r33;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r32 = 2;
        r33 = java.lang.Long.valueOf(r18);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r31[r32] = r33;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r32 = 3;
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r31[r32] = r6;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r31;
        com.tencent.mm.sdk.platformtools.x.e(r8, r9, r0);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = 0;
        r8 = r6;
    L_0x02e4:
        r7 = r5.hSe;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r5.hSe;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r25;
        r6 = r0.get(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = (java.lang.Long) r6;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r32 = com.tencent.mm.sdk.platformtools.bi.c(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r8 = r8 + r32;
        r6 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r25;
        r0.put(r7, r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = r5.hSe;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r5.hSe;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r26;
        r6 = r0.get(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = (java.lang.Long) r6;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r8 = com.tencent.mm.sdk.platformtools.bi.c(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r32 = 1;
        r8 = r8 + r32;
        r6 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r26;
        r0.put(r7, r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r11 == 0) goto L_0x0353;
    L_0x031e:
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6.<init>();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = r11.hSe;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = ",";
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = r5.hSe;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = r6.toString();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r28;
        r6 = r0.get(r7);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = (java.lang.Long) r6;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r8 = com.tencent.mm.sdk.platformtools.bi.c(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r32 = 1;
        r8 = r8 + r32;
        r6 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r28;
        r0.put(r7, r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
    L_0x0353:
        r6 = r5.hRW;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r6 == 0) goto L_0x03a9;
    L_0x0357:
        r6 = r5.hSe;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r29;
        r6 = r0.containsKey(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r6 == 0) goto L_0x039b;
    L_0x0361:
        r6 = r5.hSe;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r29;
        r6 = r0.get(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = (java.util.Map) r6;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = r6;
    L_0x036c:
        r6 = 0;
        r8 = r6;
    L_0x036e:
        r6 = r5.hRW;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r6.size();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r8 >= r6) goto L_0x03a9;
    L_0x0376:
        r6 = r5.hRW;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r6.get(r8);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = (com.tencent.mm.modelstat.c.d) r6;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r9 = r6.hSm;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r6.hSm;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r7.get(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = (java.lang.Long) r6;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r32 = com.tencent.mm.sdk.platformtools.bi.c(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r34 = 1;
        r32 = r32 + r34;
        r6 = java.lang.Long.valueOf(r32);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7.put(r9, r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r8 + 1;
        r8 = r6;
        goto L_0x036e;
    L_0x039b:
        r6 = new java.util.HashMap;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6.<init>();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = r5.hSe;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r29;
        r0.put(r7, r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = r6;
        goto L_0x036c;
    L_0x03a9:
        r6 = r10 + 1;
        r10 = r6;
        r11 = r5;
        goto L_0x0238;
    L_0x03af:
        if (r16 == 0) goto L_0x03fb;
    L_0x03b1:
        r0 = r16;
        r4 = r0.hSl;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = r4.iterator();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
    L_0x03b9:
        r4 = r6.hasNext();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r4 == 0) goto L_0x03fb;
    L_0x03bf:
        r4 = r6.next();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = (android.util.Pair) r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7.<init>();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = r4.first;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = r7.append(r5);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = ",";
        r7 = r5.append(r7);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = r4.second;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = r7.append(r5);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r28;
        r7 = r0.containsKey(r5);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        if (r7 == 0) goto L_0x03b9;
    L_0x03ed:
        r4 = r4.second;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r28;
        r5 = r0.get(r5);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r27;
        r0.put(r4, r5);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        goto L_0x03b9;
    L_0x03fb:
        r6 = r12;
        r8 = r14;
        goto L_0x01bc;
    L_0x03ff:
        r4 = java.lang.Long.valueOf(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r0 = r24;
        r4 = r0.get(r4);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = (java.util.ArrayList) r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = 0;
        r4 = r4.get(r5);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = (com.tencent.mm.modelstat.c.b) r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r10 = r4.time;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = "MicroMsg.ClickFlowStatReceiver";
        r5 = "min key:%s,tbe:%s";
        r12 = 2;
        r12 = new java.lang.Object[r12];	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r13 = 0;
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r12[r13] = r6;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6 = 1;
        r7 = java.lang.Long.valueOf(r10);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r12[r6] = r7;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r12);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r4 = (r10 > r18 ? 1 : (r10 == r18 ? 0 : -1));
        if (r4 > 0) goto L_0x0438;
    L_0x0432:
        r4 = 0;
        r4 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r4 >= 0) goto L_0x0454;
    L_0x0438:
        r4 = "MicroMsg.ClickFlowStatReceiver";
        r5 = "reportStat ErroTime tbe:%d now:%d";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = 0;
        r8 = java.lang.Long.valueOf(r10);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7 = 1;
        r8 = java.lang.Long.valueOf(r18);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.x.e(r4, r5, r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        goto L_0x003a;
    L_0x0454:
        r5 = 0;
        r4 = 0;
        r6 = r4;
    L_0x0457:
        r0 = r37;
        r4 = r0.hRR;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r4 = r4.size();	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        if (r6 >= r4) goto L_0x0788;
    L_0x0461:
        r7 = "appstat";
        r0 = r37;
        r4 = r0.hRR;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r4 = r4.get(r6);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r4 = (com.tencent.mm.modelstat.c.c) r4;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r4 = r4.hSj;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r4 = r7.equals(r4);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        if (r4 == 0) goto L_0x06b8;
    L_0x0476:
        r0 = r37;
        r4 = r0.hRR;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r4 = r4.get(r6);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r4 = (com.tencent.mm.modelstat.c.c) r4;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
    L_0x0480:
        r5 = "MicroMsg.ClickFlowStatReceiver";
        r6 = "[oneliang] end:%s,tbe:%s,sumInFg:%s";
        r7 = 3;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r12 = 0;
        r13 = java.lang.Long.valueOf(r20);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r7[r12] = r13;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r12 = 1;
        r13 = java.lang.Long.valueOf(r10);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r7[r12] = r13;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r12 = 2;
        r13 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r7[r12] = r13;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        if (r4 == 0) goto L_0x06f4;
    L_0x04a3:
        r6 = r20 - r10;
        r6 = r6 - r8;
        r12 = 0;
        r5 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1));
        if (r5 < 0) goto L_0x06f4;
    L_0x04ac:
        r6 = r4.hSg;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r5 = (r6 > r22 ? 1 : (r6 == r22 ? 0 : -1));
        if (r5 <= 0) goto L_0x06bd;
    L_0x04b2:
        r5 = r4.hSh;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r0 = r37;
        r6 = r0.hRV;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r0 = r38;
        r5 = a(r0, r5, r6);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        if (r5 == 0) goto L_0x06bd;
    L_0x04c0:
        r5 = "MicroMsg.ClickFlowStatReceiver";
        r6 = "type: appstat, handle %s, now:%d";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r12 = 0;
        r7[r12] = r4;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r12 = 1;
        r13 = java.lang.Long.valueOf(r22);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r7[r12] = r13;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r6 = "SEQ_";
        r5.<init>(r6);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r6 = r4.hSi;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r0 = r41;
        r5 = r0.WH(r5);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r5 = com.tencent.mm.sdk.platformtools.bi.e(r5);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r7 = "SEQ_";
        r6.<init>(r7);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r7 = r4.hSi;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r7 = r5 + 1;
        r0 = r41;
        r0.da(r6, r7);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r6 = new org.json.JSONObject;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r6.<init>();	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r7 = "t";
        r12 = 5;
        r7 = r6.put(r7, r12);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r12 = "tbe";
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r14 = r10 / r14;
        r7 = r7.put(r12, r14);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r12 = "ten";
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r14 = r20 / r14;
        r7 = r7.put(r12, r14);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r12 = "in";
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r14 = r8 / r14;
        r7 = r7.put(r12, r14);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r12 = "inbg";
        r14 = r20 - r10;
        r8 = r14 - r8;
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r8 = r8 / r14;
        r7 = r7.put(r12, r8);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r8 = "swc";
        r9 = r24.size();	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r7.put(r8, r9);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r7 = r4.hSi;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r8.<init>();	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r4 = r4.id;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r4 = r8.append(r4);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        a(r7, r4, r5, r6);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
    L_0x0569:
        r5 = 0;
        r4 = 0;
        r6 = r4;
    L_0x056c:
        r0 = r37;
        r4 = r0.hRR;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r4 = r4.size();	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        if (r6 >= r4) goto L_0x0785;
    L_0x0576:
        r7 = "pagestat";
        r0 = r37;
        r4 = r0.hRR;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r4 = r4.get(r6);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r4 = (com.tencent.mm.modelstat.c.c) r4;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r4 = r4.hSj;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r4 = r7.equals(r4);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        if (r4 == 0) goto L_0x0710;
    L_0x058b:
        r0 = r37;
        r4 = r0.hRR;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r4 = r4.get(r6);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r4 = (com.tencent.mm.modelstat.c.c) r4;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r6 = r4;
    L_0x0596:
        if (r6 == 0) goto L_0x077a;
    L_0x0598:
        r4 = r6.hSg;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r4 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1));
        if (r4 <= 0) goto L_0x0762;
    L_0x059e:
        r4 = r6.hSh;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r0 = r37;
        r8 = r0.hRV;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r0 = r38;
        r4 = a(r0, r4, r8);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        if (r4 == 0) goto L_0x0762;
    L_0x05ac:
        r4 = "MicroMsg.ClickFlowStatReceiver";
        r5 = "type: pagestat, handle %s, now:%d";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r8 = 0;
        r7[r8] = r6;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r8 = 1;
        r9 = java.lang.Long.valueOf(r22);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r7[r8] = r9;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r7);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r5 = "SEQ_";
        r4.<init>(r5);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r5 = r6.hSi;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r0 = r41;
        r4 = r0.WH(r4);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r7 = com.tencent.mm.sdk.platformtools.bi.e(r4);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r5 = "SEQ_";
        r4.<init>(r5);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r5 = r6.hSi;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r5 = r7 + 1;
        r0 = r41;
        r0.da(r4, r5);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r8 = new org.json.JSONArray;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r8.<init>();	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r4 = r25.keySet();	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r9 = r4.iterator();	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
    L_0x0604:
        r4 = r9.hasNext();	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        if (r4 == 0) goto L_0x0720;
    L_0x060a:
        r4 = r9.next();	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r4 = (java.lang.String) r4;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r12 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r12.<init>();	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r5 = "p";
        r13 = r12.put(r5, r4);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r14 = "in";
        r0 = r25;
        r5 = r0.get(r4);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r5 = (java.lang.Long) r5;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r18 = r5.longValue();	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r22 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r18 = r18 / r22;
        r0 = r18;
        r5 = r13.put(r14, r0);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r13 = "c";
        r0 = r26;
        r14 = r0.get(r4);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r5 = r5.put(r13, r14);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r13 = "c2";
        r0 = r27;
        r14 = r0.get(r4);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r5.put(r13, r14);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r0 = r29;
        r5 = r0.containsKey(r4);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        if (r5 == 0) goto L_0x071b;
    L_0x0656:
        r13 = new org.json.JSONArray;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r13.<init>();	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r0 = r29;
        r4 = r0.get(r4);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r0 = r4;
        r0 = (java.util.Map) r0;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r5 = r0;
        r4 = r5.keySet();	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r14 = r4.iterator();	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
    L_0x066d:
        r4 = r14.hasNext();	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        if (r4 == 0) goto L_0x0715;
    L_0x0673:
        r4 = r14.next();	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r4 = (java.lang.String) r4;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r15 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r15.<init>();	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r16 = "w";
        r0 = r16;
        r16 = r15.put(r0, r4);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r18 = "c";
        r4 = r5.get(r4);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r0 = r16;
        r1 = r18;
        r0.put(r1, r4);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r13.put(r15);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        goto L_0x066d;
    L_0x0699:
        r4 = move-exception;
        r5 = 15007; // 0x3a9f float:2.1029E-41 double:7.4144E-320;
        r6 = com.tencent.mm.sdk.platformtools.bi.i(r4);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        v(r5, r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = "MicroMsg.ClickFlowStatReceiver";
        r6 = "report ev:4 exception : %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r8 = 0;
        r4 = com.tencent.mm.sdk.platformtools.bi.i(r4);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7[r8] = r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        goto L_0x003a;
    L_0x06b8:
        r4 = r6 + 1;
        r6 = r4;
        goto L_0x0457;
    L_0x06bd:
        r5 = "MicroMsg.ClickFlowStatReceiver";
        r6 = "type: appstat, skip %s, now:%d";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r8 = 0;
        r7[r8] = r4;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r4 = 1;
        r8 = java.lang.Long.valueOf(r22);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r7[r4] = r8;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        goto L_0x0569;
    L_0x06d5:
        r4 = move-exception;
        r5 = 15006; // 0x3a9e float:2.1028E-41 double:7.414E-320;
        r6 = com.tencent.mm.sdk.platformtools.bi.i(r4);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        v(r5, r6);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r5 = "MicroMsg.ClickFlowStatReceiver";
        r6 = "report ev:3 exception : %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r8 = 0;
        r4 = com.tencent.mm.sdk.platformtools.bi.i(r4);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        r7[r8] = r4;	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);	 Catch:{ Exception -> 0x009b, OutOfMemoryError -> 0x00f8 }
        goto L_0x0569;
    L_0x06f4:
        r5 = "MicroMsg.ClickFlowStatReceiver";
        r6 = "type: appstat, skip null, event:%s, (end - tbe - sumInFg):%s";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r12 = 0;
        r7[r12] = r4;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r4 = 1;
        r12 = r20 - r10;
        r8 = r12 - r8;
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        r7[r4] = r8;	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);	 Catch:{ Exception -> 0x06d5, OutOfMemoryError -> 0x00f8 }
        goto L_0x0569;
    L_0x0710:
        r4 = r6 + 1;
        r6 = r4;
        goto L_0x056c;
    L_0x0715:
        r4 = "wa";
        r12.put(r4, r13);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
    L_0x071b:
        r8.put(r12);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        goto L_0x0604;
    L_0x0720:
        r4 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r4.<init>();	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r5 = "t";
        r9 = 6;
        r5 = r4.put(r5, r9);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r9 = "tbe";
        r12 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r10 = r10 / r12;
        r5 = r5.put(r9, r10);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r9 = "ten";
        r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r10 = r20 / r10;
        r5 = r5.put(r9, r10);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r9 = "pa";
        r5.put(r9, r8);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r5 = r6.hSi;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r8.<init>();	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r6 = r6.id;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r6 = r8.append(r6);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        a(r5, r6, r7, r4);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        goto L_0x003a;
    L_0x0762:
        r4 = "MicroMsg.ClickFlowStatReceiver";
        r5 = "type: pagestat, skip %s, now:%d";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r8 = 0;
        r7[r8] = r6;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r6 = 1;
        r8 = java.lang.Long.valueOf(r22);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        r7[r6] = r8;	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r7);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        goto L_0x003a;
    L_0x077a:
        r4 = "MicroMsg.ClickFlowStatReceiver";
        r5 = "type: pagestat, skip null";
        com.tencent.mm.sdk.platformtools.x.i(r4, r5);	 Catch:{ Exception -> 0x0699, OutOfMemoryError -> 0x00f8 }
        goto L_0x003a;
    L_0x0785:
        r6 = r5;
        goto L_0x0596;
    L_0x0788:
        r4 = r5;
        goto L_0x0480;
    L_0x078b:
        r8 = r6;
        goto L_0x02e4;
    L_0x078e:
        r12 = r6;
        goto L_0x01d5;
    L_0x0791:
        r16 = r5;
        goto L_0x019d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelstat.c.b(long, java.util.ArrayList, com.tencent.mm.sdk.e.a):void");
    }

    @SuppressLint({"UseSparseArrays"})
    private static HashMap<Long, ArrayList<b>> mN(String str) {
        Throwable th;
        InputStream inputStream;
        FileInputStream fileInputStream = null;
        long Wy = bi.Wy();
        ObjectInputStream objectInputStream;
        try {
            File file = new File(str);
            if (!file.exists() || file.length() <= 0) {
                x.w("MicroMsg.ClickFlowStatReceiver", "readStorage not exist path[%s]", str);
                return new HashMap();
            }
            InputStream fileInputStream2 = new FileInputStream(file);
            try {
                objectInputStream = new ObjectInputStream(fileInputStream2);
                try {
                    HashMap<Long, ArrayList<b>> hashMap = (HashMap) objectInputStream.readObject();
                    x.i("MicroMsg.ClickFlowStatReceiver", "readStorage keys count:%d readTime:%d", Integer.valueOf(hashMap.size()), Long.valueOf(bi.bA(Wy)));
                    try {
                        objectInputStream.close();
                    } catch (Exception e) {
                    }
                    try {
                        fileInputStream2.close();
                        return hashMap;
                    } catch (Exception e2) {
                        return hashMap;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = fileInputStream2;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
                inputStream = fileInputStream2;
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            objectInputStream = null;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    private synchronized void a(String str, HashMap<Long, ArrayList<b>> hashMap) {
        ObjectOutputStream objectOutputStream;
        Throwable e;
        FileOutputStream fileOutputStream = null;
        synchronized (this) {
            FileOutputStream fileOutputStream2;
            try {
                long Wy = bi.Wy();
                fileOutputStream2 = new FileOutputStream(str);
                try {
                    objectOutputStream = new ObjectOutputStream(fileOutputStream2);
                } catch (Exception e2) {
                    e = e2;
                    objectOutputStream = null;
                    fileOutputStream = fileOutputStream2;
                    try {
                        x.e("MicroMsg.ClickFlowStatReceiver", "writeStorage exception: %s [%s]", e.getMessage(), bi.i(e));
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e3) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        e = th;
                        fileOutputStream2 = fileOutputStream;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Exception e6) {
                            }
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    objectOutputStream = null;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw e;
                }
                try {
                    objectOutputStream.writeObject(hashMap);
                    fileOutputStream2.flush();
                    x.i("MicroMsg.ClickFlowStatReceiver", "writeStorage count:%d time:%d", Integer.valueOf(hashMap.size()), Long.valueOf(bi.bA(Wy)));
                    try {
                        objectOutputStream.close();
                    } catch (Exception e7) {
                    }
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e8) {
                    }
                } catch (Exception e9) {
                    e = e9;
                    fileOutputStream = fileOutputStream2;
                    x.e("MicroMsg.ClickFlowStatReceiver", "writeStorage exception: %s [%s]", e.getMessage(), bi.i(e));
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return;
                } catch (Throwable th3) {
                    e = th3;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw e;
                }
            } catch (Exception e10) {
                e = e10;
                objectOutputStream = null;
                x.e("MicroMsg.ClickFlowStatReceiver", "writeStorage exception: %s [%s]", e.getMessage(), bi.i(e));
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return;
            } catch (Throwable th4) {
                e = th4;
                objectOutputStream = null;
                fileOutputStream2 = null;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw e;
            }
        }
        return;
    }

    private static void a(int i, String str, int i2, String str2) {
        try {
            String replace = str2.replace(",", ";");
            int ceil = (int) Math.ceil(((double) replace.length()) / 6000.0d);
            for (int i3 = 0; i3 < ceil; i3++) {
                x.i("MicroMsg.ClickFlowStatReceiver", "jsonKVReporter id:%d event[%s] [%s]", Integer.valueOf(i), str, str + "," + i2 + "," + i3 + "," + ceil + ",0,0,," + replace.substring(i3 * 6000, Math.min((i3 + 1) * 6000, replace.length())));
                com.tencent.mm.plugin.report.d.pVE.a(346, 4, 1, false);
                com.tencent.mm.plugin.report.d.pVE.a(i, r11, true, true);
            }
        } catch (Throwable e) {
            v(15009, bi.i(e));
            x.e("MicroMsg.ClickFlowStatReceiver", "jsonKVReporter exception : %s", bi.i(e));
        }
    }

    private static String bq(long j) {
        if (j < 100000000000L) {
            return new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(j * 1000));
        }
        return new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(j)) + String.format(Locale.getDefault(), ".%03d", new Object[]{Long.valueOf(j % 1000)});
    }

    private static String by(Context context) {
        int i;
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && (runningAppProcessInfo.processName.equals("com.tencent.mm") || runningAppProcessInfo.processName.equals("com.tencent.mm:tools"))) {
                    i = 1;
                    break;
                }
            }
        }
        i = 0;
        if (i == 0) {
            return "";
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String className;
            if (VERSION.SDK_INT >= 23) {
                List appTasks = activityManager.getAppTasks();
                if (appTasks == null || appTasks.size() <= 0) {
                    return "";
                }
                Iterator it = appTasks.iterator();
                if (it.hasNext()) {
                    ComponentName componentName = ((AppTask) it.next()).getTaskInfo().topActivity;
                    if (componentName == null) {
                        return null;
                    }
                    className = componentName.getClassName();
                    if (className.contains(".")) {
                        return className.substring(className.lastIndexOf(".") + 1);
                    }
                    return className;
                }
                return "";
            }
            className = ((RunningTaskInfo) activityManager.getRunningTasks(1).get(0)).topActivity.getClassName();
            if (className.contains(".")) {
                return className.substring(className.lastIndexOf(".") + 1);
            }
            return className;
        } catch (Throwable e) {
            x.e("MicroMsg.ClickFlowStatReceiver", "getTopActivityName Exception:%s stack:%s", e.getMessage(), bi.i(e));
        }
    }
}
