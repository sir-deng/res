package com.tencent.mm.plugin.radar.b;

import android.content.Context;
import android.os.Message;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.c.bbo;
import com.tencent.mm.protocal.c.bbp;
import com.tencent.mm.protocal.c.bbq;
import com.tencent.mm.protocal.c.bbr;
import com.tencent.mm.protocal.c.bbt;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public final class e implements com.tencent.mm.ad.e {
    private static final String TAG = TAG;
    private static final int pCZ = pCZ;
    private static final int pDa = 5000;
    private static final int pDb = 1;
    public static final b pDc = new b();
    private final Context context;
    private String fsK;
    public final com.tencent.mm.modelgeo.a.a gAn = new i(this);
    private final LinkedList<bbr> hKw = new LinkedList();
    private boolean hpb;
    public com.tencent.mm.modelgeo.c hry;
    private Location pCN;
    private b pCO;
    private f pCP = f.Stopped;
    public LinkedList<bbp> pCQ;
    public Map<String, String> pCR = new LinkedHashMap();
    private Map<String, com.tencent.mm.plugin.radar.b.c.e> pCS = new LinkedHashMap();
    private Map<String, com.tencent.mm.plugin.radar.b.c.e> pCT = new LinkedHashMap();
    public Map<Long, c> pCU = new LinkedHashMap();
    public Map<String, a> pCV = new LinkedHashMap();
    private final al pCW = new al(new h(this), false);
    private final g pCX = new g();
    private final d pCY;

    public enum a {
        Selected,
        UnSelected
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    public static final class c {
        public final bbr pDg;
        public final com.tencent.mm.plugin.radar.b.c.e pDh;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r3) {
            /*
            r2 = this;
            if (r2 == r3) goto L_0x001c;
        L_0x0002:
            r0 = r3 instanceof com.tencent.mm.plugin.radar.b.e.c;
            if (r0 == 0) goto L_0x001e;
        L_0x0006:
            r3 = (com.tencent.mm.plugin.radar.b.e.c) r3;
            r0 = r2.pDg;
            r1 = r3.pDg;
            r0 = b.c.b.e.h(r0, r1);
            if (r0 == 0) goto L_0x001e;
        L_0x0012:
            r0 = r2.pDh;
            r1 = r3.pDh;
            r0 = b.c.b.e.h(r0, r1);
            if (r0 == 0) goto L_0x001e;
        L_0x001c:
            r0 = 1;
        L_0x001d:
            return r0;
        L_0x001e:
            r0 = 0;
            goto L_0x001d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.radar.b.e.c.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i = 0;
            bbr bbr = this.pDg;
            int hashCode = (bbr != null ? bbr.hashCode() : 0) * 31;
            com.tencent.mm.plugin.radar.b.c.e eVar = this.pDh;
            if (eVar != null) {
                i = eVar.hashCode();
            }
            return hashCode + i;
        }

        public final String toString() {
            return "LatestChangeStat(member=" + this.pDg + ", state=" + this.pDh + ")";
        }

        public c(bbr bbr, com.tencent.mm.plugin.radar.b.c.e eVar) {
            b.c.b.e.i(bbr, "member");
            b.c.b.e.i(eVar, "state");
            this.pDg = bbr;
            this.pDh = eVar;
        }
    }

    public enum e {
        SEARCHING,
        SEARCH_RETRUN,
        RALATIONCHAIN,
        RALATIONCHAIN_RETRUN,
        CREATING_CHAT
    }

    private enum f {
        Stopped,
        Locating,
        RadarSearching,
        Waiting
    }

    public static final class g extends ag {
        g() {
        }

        public final void handleMessage(Message message) {
            b.c.b.e.i(message, "msg");
            int i = message.what;
            b bVar = e.pDc;
            if (i == e.pDb) {
                com.tencent.mm.kernel.g.CN().d((k) new b());
            }
        }
    }

    static final class h implements com.tencent.mm.sdk.platformtools.al.a {
        final /* synthetic */ e pDu;

        h(e eVar) {
            this.pDu = eVar;
        }

        public final boolean uG() {
            b bVar;
            if (this.pDu.hpb) {
                bVar = e.pDc;
                x.d(e.TAG, "cancel radar searching");
            } else {
                this.pDu.pCP = f.RadarSearching;
                bVar = e.pDc;
                x.d(e.TAG, "status: %s", this.pDu.pCP);
                Location c = this.pDu.pCN;
                if (c == null) {
                    bVar = e.pDc;
                    x.e(e.TAG, "error! location is null!");
                } else if (c.bZJ()) {
                    bVar = e.pDc;
                    x.e(e.TAG, "error! location is null!");
                } else {
                    bVar = e.pDc;
                    x.d(e.TAG, "do once search");
                    e eVar = this.pDu;
                    float f = c.hzq;
                    float f2 = c.hzr;
                    int i = c.accuracy;
                    int i2 = c.fBZ;
                    Object obj = c.mac;
                    b.c.b.e.h(obj, "it.mac");
                    Object obj2 = c.fCb;
                    b.c.b.e.h(obj2, "it.cellId");
                    eVar.pCO = new b(1, f, f2, i, i2, obj, obj2);
                    com.tencent.mm.kernel.g.CN().d((k) this.pDu.pCO);
                }
            }
            return false;
        }
    }

    static final class i implements com.tencent.mm.modelgeo.a.a {
        final /* synthetic */ e pDu;

        i(e eVar) {
            this.pDu = eVar;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            b bVar;
            if (this.pDu.hpb) {
                bVar = e.pDc;
                x.d(e.TAG, "cancel location");
                return false;
            } else if (this.pDu.pCN != null) {
                return false;
            } else {
                if (z) {
                    o.a(TXLiveConstants.PLAY_EVT_PLAY_END, f, f2, (int) d2);
                    bVar = e.pDc;
                    x.d(e.TAG, "lat:%f lng:%f accuracy:%f", Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d2));
                    this.pDu.pCN = new Location(f2, f, (int) d2, i, "", "");
                    this.pDu.pCW.fI(0);
                } else {
                    this.pDu.stop();
                }
                this.pDu.pCY.hx(true);
                return false;
            }
        }
    }

    public interface d {
        void a(int i, int i2, LinkedList<bbr> linkedList);

        void b(int i, int i2, LinkedList<bbo> linkedList);

        void hx(boolean z);
    }

    public e(d dVar, Context context) {
        b.c.b.e.i(dVar, "delegate");
        b.c.b.e.i(context, "context");
        this.pCY = dVar;
        this.context = context;
    }

    public final void blZ() {
        bma();
        this.hpb = false;
        this.pCN = null;
        this.pCP = f.Stopped;
        this.pCW.TN();
        x.d(TAG, "start radar");
        if (this.hry == null) {
            this.hry = com.tencent.mm.modelgeo.c.OV();
        }
        this.pCP = f.Locating;
        com.tencent.mm.modelgeo.c cVar = this.hry;
        if (cVar != null) {
            cVar.b(this.gAn);
        }
        x.d(TAG, "status: %s", this.pCP);
    }

    public final void bma() {
        switch (f.pDt[this.pCP.ordinal()]) {
            case 1:
                return;
            case 2:
                stop();
                break;
            case 3:
                if (this.pCO != null) {
                    stop();
                    com.tencent.mm.kernel.g.CN().c((k) this.pCO);
                    bmb();
                    break;
                }
                break;
            case 4:
                stop();
                bmb();
                break;
        }
        x.d(TAG, "stop radar");
    }

    private final void bmb() {
        this.pCX.sendEmptyMessageDelayed(pDb, (long) pDa);
    }

    public final void stop() {
        this.hpb = true;
        this.pCP = f.Stopped;
        this.pCW.TN();
    }

    private final void a(int i, int i2, LinkedList<bbr> linkedList) {
        this.pCY.a(i, i2, linkedList);
    }

    private final void b(int i, int i2, LinkedList<bbo> linkedList) {
        this.pCY.b(i, i2, linkedList);
    }

    public final void a(int i, int i2, String str, k kVar) {
        LinkedList linkedList = null;
        b.c.b.e.i(kVar, "scene");
        switch (kVar.getType()) {
            case com.tencent.mm.plugin.appbrand.jsapi.x.CTRL_INDEX /*425*/:
                if (this.pCO != kVar) {
                    return;
                }
                if (((b) kVar).fvo == 1) {
                    this.pCP = f.Waiting;
                    if (i == 0 && i2 == 0) {
                        x.d(TAG, "rader members count: %s ticket: %s", Integer.valueOf(((b) kVar).blX()), this.fsK);
                        this.pCW.fI((long) pCZ);
                        com.tencent.mm.ad.b bVar = ((b) kVar).gLB;
                        bbt bbt = (bbt) (bVar != null ? bVar.Kd() : null);
                        if (bbt != null) {
                            linkedList = bbt.vNu;
                        }
                        if (linkedList != null) {
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                bbr bbr = (bbr) it.next();
                                Object Yf = com.tencent.mm.plugin.d.a.Yf();
                                b.c.b.e.h(Yf, "PinAntispam.instance()");
                                Yf.FP().fH(bbr.kyG, bbr.woW);
                            }
                        }
                        if (linkedList != null) {
                            this.hKw.clear();
                            this.hKw.addAll(linkedList);
                        }
                        LinkedList linkedList2 = this.hKw;
                        ((b) kVar).blX();
                        a(i, i2, linkedList2);
                        x.d(TAG, "status: %s", this.pCP);
                        return;
                    }
                    stop();
                    a(i, i2, null);
                    return;
                }
                a(i, i2, null);
                return;
            case 602:
                x.d(TAG, " MMFunc_MMRadarRelationChain ");
                if (i == 0 && i2 == 0) {
                    com.tencent.mm.bp.a Kd = ((a) kVar).gLB.Kd();
                    if (Kd == null) {
                        throw new b.i("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarRelationChainResponse");
                    }
                    bbq bbq = (bbq) Kd;
                    this.fsK = bbq.wgO;
                    if (bbq.lfj > 0) {
                        linkedList = bbq.vNu;
                        int i3 = bbq.lfj;
                        b(i, i2, linkedList);
                        return;
                    }
                    b(i, i2, null);
                    return;
                }
                b(i, i2, null);
                return;
            default:
                return;
        }
    }

    public final void a(String str, com.tencent.mm.plugin.radar.b.c.e eVar) {
        Object obj = (com.tencent.mm.plugin.radar.b.c.e) this.pCS.get(str);
        if (obj != null && (b.c.b.e.h(obj, (Object) eVar) ^ 1) != 0) {
            this.pCT.put(str, obj);
        }
    }

    public final void b(String str, com.tencent.mm.plugin.radar.b.c.e eVar) {
        b.c.b.e.i(str, "username");
        b.c.b.e.i(eVar, "state");
        if (!b.f.g.Y(str)) {
            a(str, eVar);
            this.pCS.put(str, eVar);
        }
    }

    public final com.tencent.mm.plugin.radar.b.c.e a(bbr bbr, boolean z) {
        b.c.b.e.i(bbr, "member");
        Object obj = bbr.kyG;
        b.c.b.e.h(obj, "member.UserName");
        com.tencent.mm.plugin.radar.b.c.e aw = aw(obj, z);
        if (aw != null) {
            return aw;
        }
        obj = bbr.wjz;
        b.c.b.e.h(obj, "member.EncodeUserName");
        return aw(obj, z);
    }

    public final com.tencent.mm.plugin.radar.b.c.e IF(String str) {
        b.c.b.e.i(str, "username");
        return aw(str, false);
    }

    private final com.tencent.mm.plugin.radar.b.c.e aw(String str, boolean z) {
        if (z) {
            return (com.tencent.mm.plugin.radar.b.c.e) this.pCT.get(str);
        }
        return (com.tencent.mm.plugin.radar.b.c.e) this.pCS.get(str);
    }

    public final void a(bbr bbr) {
        if (bbr != null) {
            com.tencent.mm.plugin.radar.ui.g gVar = com.tencent.mm.plugin.radar.ui.g.pFl;
            String b = com.tencent.mm.plugin.radar.ui.g.b(bbr);
            if (this.pCV.containsKey(b)) {
                this.pCV.remove(b);
            } else {
                this.pCV.put(b, a.Selected);
            }
        }
    }
}
