package com.tencent.mm.af;

import android.net.Uri;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.ok;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.x.l;
import java.util.Iterator;
import java.util.LinkedList;

public final class k {
    private a gAn;
    int hrA;
    boolean hrB;
    b hrC;
    int hrx;
    private c hry;
    private int hrz;
    String userName;

    protected k() {
        this.userName = null;
        this.hrx = 0;
        this.hrz = 2;
        this.hrA = 10;
        this.hrB = false;
        this.hrC = new b() {
            public final void a(int i, m mVar, Object obj) {
                if (obj == null || !(obj instanceof String)) {
                    x.i("MicroMsg.ReportLocation", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
                } else if (k.this.userName.equals((String) obj) && k.this.hrx == 1) {
                    x.i("MicroMsg.ReportLocation", "contactStgUpdate, %s", k.this.userName);
                    k.this.kh(k.this.userName);
                    ((h) g.h(h.class)).Ff().b(k.this.hrC);
                }
            }
        };
        this.gAn = new a() {
            long lastReportTime = 0;

            public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                if (!z) {
                    return true;
                }
                x.i("MicroMsg.ReportLocation", "LBSManager notify. lat:%f, lng:%f", Float.valueOf(f2), Float.valueOf(f));
                if (bi.Wx() >= this.lastReportTime + ((long) k.this.hrA)) {
                    k.a(k.this.userName, 11, 0, f2, f, (int) d2, null);
                    this.lastReportTime = bi.Wx();
                }
                if (k.this.hrx == 2) {
                    k.this.Me();
                }
                if (!k.this.hrB) {
                    k.this.hrB = true;
                    o.a(2013, f, f2, (int) d2);
                }
                return true;
            }
        };
        this.hrA = bi.getInt(((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).Ag().F("BrandService", "continueLocationReportInterval"), 5);
        if (this.hrA < this.hrz) {
            this.hrA = this.hrz;
        }
        x.i("MicroMsg.ReportLocation", "reportLocation interval %d", Integer.valueOf(this.hrA));
    }

    public final void b(final String str, final au auVar) {
        if (auVar == null || !auVar.cjK()) {
            a(str, 10, 0, 0.0f, 0.0f, 0, null);
        } else {
            g.Dt().F(new Runnable() {
                public final void run() {
                    LinkedList linkedList = new LinkedList();
                    l wr = ((com.tencent.mm.plugin.biz.a.a) g.h(com.tencent.mm.plugin.biz.a.a.class)).wr(auVar.field_content);
                    if (wr == null || bi.cC(wr.hfI)) {
                        k.a(str, 10, 0, 0.0f, 0.0f, 0, null);
                        return;
                    }
                    Iterator it = wr.hfI.iterator();
                    while (it.hasNext()) {
                        com.tencent.mm.x.m mVar = (com.tencent.mm.x.m) it.next();
                        String str = mVar.url;
                        if (!bi.oN(str)) {
                            Uri parse = Uri.parse(str);
                            try {
                                String queryParameter = parse.getQueryParameter("mid");
                                str = parse.getQueryParameter("idx");
                                ok okVar = new ok();
                                okVar.wef = bi.getLong(queryParameter, 0);
                                okVar.qnM = bi.getInt(str, 0);
                                okVar.fGh = mVar.hfX;
                                okVar.path = mVar.hfU;
                                linkedList.add(okVar);
                            } catch (UnsupportedOperationException e) {
                                x.w("MicroMsg.ReportLocation", "UnsupportedOperationException %s", e.getMessage());
                            }
                        }
                    }
                    k.a(str, 10, 0, 0.0f, 0.0f, 0, linkedList);
                }
            });
        }
    }

    public static void kg(String str) {
        a(str, 12, 0, 0.0f, 0.0f, 0, null);
    }

    public final void kh(String str) {
        x.i("MicroMsg.ReportLocation", "Start report");
        this.userName = str;
        d jV = f.jV(str);
        if (jV != null) {
            if (this.hrx != 0) {
                Me();
            }
            this.hrx = 0;
            if (jV.Le()) {
                x.i("MicroMsg.ReportLocation", "need update contact %s", str);
                com.tencent.mm.ac.b.ja(str);
            }
            d.b bK = jV.bK(false);
            if (bK == null) {
                return;
            }
            if (bK.Lg() && jV.Ld()) {
                this.hry = c.OV();
                bK = jV.bK(false);
                if (bK.hqe != null) {
                    boolean z;
                    if (bi.getInt(bK.hqe.optString("ReportLocationType"), 0) == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bK.hqr = z;
                }
                this.hrx = bK.hqr ? 3 : 2;
                if (c.OW() || c.OX()) {
                    this.hry.a(this.gAn, true);
                } else {
                    a(str, 11, 2, 0.0f, 0.0f, 0, null);
                }
            } else if (bK.Lg() && !jV.Ld()) {
                a(str, 11, 1, 0.0f, 0.0f, 0, null);
            }
        }
    }

    public final void Me() {
        x.i("MicroMsg.ReportLocation", "Stop report");
        this.hrx = 0;
        if (this.hry != null) {
            this.hry.c(this.gAn);
        }
        if (g.Do().CF()) {
            ((h) g.h(h.class)).Ff().b(this.hrC);
        }
    }

    private static void a(String str, int i, int i2, float f, float f2, int i3, LinkedList<ok> linkedList) {
        String str2;
        if (i2 == 3) {
            str2 = "<event></event>";
        } else {
            str2 = String.format("<event><location><errcode>%d</errcode><data><latitude>%f</latitude><longitude>%f</longitude><precision>%d</precision></data></location></event>", new Object[]{Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i3)});
        }
        x.i("MicroMsg.ReportLocation", "doScene, info: %s", str2);
        g.Dp().gRu.a(new q(str, i, str2, linkedList), 0);
    }
}
