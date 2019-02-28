package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Canvas;
import android.graphics.Paint.Style;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d implements com.tencent.mm.plugin.appbrand.canvas.widget.a {
    volatile boolean iNB;
    JSONArray iNC;
    public f iND;
    private e iNE;
    com.tencent.mm.plugin.appbrand.canvas.widget.a iNF;
    public volatile String iNG;
    public volatile boolean iNH;
    private Runnable iNI = new Runnable() {
        public final void run() {
            d.this.iNN = 0;
            d.this.iNH = true;
        }
    };
    private Runnable iNJ = new Runnable() {
        public final void run() {
            boolean z = d.this.iNH;
            d.this.iNH = false;
            if (z && d.this.iNB) {
                d.this.iNF.abx();
            }
        }
    };
    public volatile long iNK;
    protected long iNL;
    protected long iNM;
    protected volatile long iNN;
    protected int mCount;

    private static class a implements c {
        private WeakReference<com.tencent.mm.plugin.appbrand.canvas.widget.a> iNR;

        a(com.tencent.mm.plugin.appbrand.canvas.widget.a aVar) {
            this.iNR = new WeakReference(aVar);
        }

        public final void invalidate() {
            com.tencent.mm.plugin.appbrand.canvas.widget.a aVar = (com.tencent.mm.plugin.appbrand.canvas.widget.a) this.iNR.get();
            if (aVar != null) {
                aVar.abx();
            }
        }
    }

    public d(com.tencent.mm.plugin.appbrand.canvas.widget.a aVar) {
        this.iNF = aVar;
        this.iND = new f(new a(aVar));
        this.iNE = new e();
    }

    public final boolean d(Canvas canvas) {
        this.iNB = false;
        if (this.iNC == null || this.iNC.length() == 0) {
            return false;
        }
        long nanoTime;
        long j = this.iNK;
        long nanoTime2 = System.nanoTime();
        String str = this.iNG;
        if (j != 0) {
            c.aU(str, "before_draw_actions");
        }
        f fVar = this.iND;
        fVar.iNV.clear();
        fVar.iNW.clear();
        fVar.iNT.reset();
        fVar.iNU.reset();
        fVar.iNT.setStyle(Style.STROKE);
        fVar.iNU.setStyle(Style.FILL);
        fVar.iNT.setAntiAlias(true);
        fVar.iNU.setAntiAlias(true);
        fVar.iNT.setStrokeWidth((float) f.ma(1));
        fVar.iNU.setStrokeWidth((float) f.ma(1));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.iNC.length()) {
                break;
            }
            JSONObject optJSONObject = this.iNC.optJSONObject(i2);
            if (optJSONObject != null) {
                try {
                    e eVar = this.iNE;
                    f fVar2 = this.iND;
                    String optString = optJSONObject.optString("method");
                    JSONArray optJSONArray = optJSONObject.optJSONArray(SlookAirButtonFrequentContactAdapter.DATA);
                    com.tencent.mm.plugin.appbrand.canvas.a.d dVar = (com.tencent.mm.plugin.appbrand.canvas.a.d) eVar.iNS.get(optString);
                    if (dVar != null) {
                        dVar.a(fVar2, canvas, optJSONArray);
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.DrawActionDelegateImpl", "drawAction error, exception : %s", e);
                }
            }
            i = i2 + 1;
        }
        if (j != 0) {
            c.aU(str, "after_draw_actions");
            c.print(str);
            nanoTime = System.nanoTime();
            this.iNM = (nanoTime - nanoTime2) + this.iNM;
            this.iNL = (nanoTime - j) + this.iNL;
            this.mCount++;
        }
        nanoTime = this.iNN;
        j = System.currentTimeMillis();
        if (nanoTime != 0) {
            com.tencent.mm.plugin.appbrand.collector.f.bF(j - nanoTime);
        }
        if (!this.iNH) {
            this.iNN = j;
        }
        return true;
    }

    public final void abx() {
    }

    public final void a(final JSONArray jSONArray, final com.tencent.mm.plugin.appbrand.canvas.widget.a.a aVar) {
        this.iNF.l(new Runnable() {
            public final void run() {
                d.this.iNC = jSONArray;
                d.this.iNB = true;
                if (aVar != null) {
                    aVar.abF();
                }
            }
        });
    }

    public final void b(final JSONArray jSONArray, final com.tencent.mm.plugin.appbrand.canvas.widget.a.a aVar) {
        if (jSONArray != null && jSONArray.length() != 0) {
            this.iNF.l(new Runnable() {
                public final void run() {
                    if (d.this.iNC == null) {
                        d.this.iNC = jSONArray;
                    } else {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            d.this.iNC.put(jSONArray.opt(i));
                        }
                    }
                    d.this.iNB = true;
                    if (aVar != null) {
                        aVar.abF();
                    }
                }
            });
        }
    }

    public final void aby() {
        this.iNF.l(new Runnable() {
            public final void run() {
                d.this.iNC = null;
                d.this.iNB = true;
            }
        });
    }

    public final void qz(String str) {
        this.iND.gQA = str;
    }

    public final int getType() {
        return this.iNF.getType();
    }

    public final void onPause() {
        this.iNK = 0;
        this.iNF.l(this.iNI);
    }

    public final void onResume() {
        this.iNF.l(this.iNJ);
    }

    public final void l(Runnable runnable) {
        if (!equals(this.iNF)) {
            this.iNF.l(runnable);
        }
    }

    public final boolean isPaused() {
        return this.iNH;
    }

    public final void qA(String str) {
        this.iNG = str;
    }

    public final int abz() {
        if (equals(this.iNF)) {
            return 0;
        }
        return this.iNF.abz();
    }

    public final int abA() {
        if (equals(this.iNF)) {
            return 0;
        }
        return this.iNF.abA();
    }

    public final void setStartTime(long j) {
        this.iNK = j;
    }

    public final void abB() {
        int i = this.mCount;
        long j = this.iNM;
        long j2 = this.iNL;
        if (i > 0 && j > 0 && j2 > 0) {
            int abz = this.iNF.abz();
            long j3 = j / ((long) i);
            int i2 = j3 <= 500000 ? 0 : j3 <= 1000000 ? 1 : j3 <= 2000000 ? 2 : j3 <= 3000000 ? 3 : j3 <= 4000000 ? 4 : j3 <= 5000000 ? 5 : 6;
            g.pWK.a((long) abz, (long) i2, 1, false);
            abz = this.iNF.abA();
            j3 = j2 / ((long) i);
            i2 = j3 <= 20000000 ? 0 : j3 <= 25000000 ? 1 : j3 <= 30000000 ? 2 : j3 <= 35000000 ? 3 : j3 <= 40000000 ? 4 : j3 <= 50000000 ? 5 : j3 <= 60000000 ? 6 : j3 <= 70000000 ? 7 : j3 <= 80000000 ? 8 : 9;
            g.pWK.a((long) abz, (long) i2, 1, false);
            int type = getType();
            if (j > 0 && j2 > 0 && i > 0) {
                ArrayList arrayList = new ArrayList();
                IDKey iDKey = new IDKey();
                iDKey.SetID(703);
                iDKey.SetKey(type == 1 ? 3 : 0);
                iDKey.SetValue(j);
                arrayList.add(iDKey);
                iDKey = new IDKey();
                iDKey.SetID(703);
                iDKey.SetKey(type == 1 ? 4 : 1);
                iDKey.SetValue(j2);
                arrayList.add(iDKey);
                iDKey = new IDKey();
                iDKey.SetID(703);
                iDKey.SetKey(type == 1 ? 5 : 2);
                iDKey.SetValue((long) i);
                arrayList.add(iDKey);
                g.pWK.a(arrayList, false);
            }
        }
    }
}
