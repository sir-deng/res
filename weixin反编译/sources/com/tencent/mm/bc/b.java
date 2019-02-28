package com.tencent.mm.bc;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.d.a.a.t;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mm.a.h;
import com.tencent.mm.a.o;
import com.tencent.mm.ay.k;
import com.tencent.mm.c.f;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.f.a.e;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class b {
    private static final byte[] hNd = "@wechat*weixin!!".getBytes();
    private static b hNe;
    private boolean hNf = false;
    private ah hNg;
    int hNh = 5000;
    int hNi = 5000;
    int hNj = 30000;
    private int hNk = 3600;
    private c hNl;
    private List<d> hNm = new ArrayList();
    private List<d> hNn = new ArrayList();
    private c hNo = new c<e>() {
        {
            this.xmG = e.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (!((e) bVar).fnJ.fnK) {
                x.i("MicroMsg.SenseWhereHelper", "it is [deactivated mode], stop sense where sdk after %d", Integer.valueOf(Math.max(b.this.hNi, b.this.hNh)));
                g.pWK.a(345, 5, 1, false);
                b.a(b.this, r0);
            }
            return false;
        }
    };
    private al hNp;
    private com.tencent.map.a.a.b hNq;
    private int hNr;
    private com.tencent.map.a.a.c hNs;
    private long startTime = 0;

    /* renamed from: com.tencent.mm.bc.b$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String hNA;
        final /* synthetic */ int hNt;
        final /* synthetic */ float hNu;
        final /* synthetic */ float hNv;
        final /* synthetic */ int hNw;
        final /* synthetic */ int hNx;
        final /* synthetic */ int hNy = 0;
        final /* synthetic */ String hNz;

        public AnonymousClass1(int i, float f, float f2, int i2, int i3, int i4, String str, String str2) {
            this.hNt = i;
            this.hNu = f;
            this.hNv = f2;
            this.hNw = i2;
            this.hNx = i3;
            this.hNz = str;
            this.hNA = str2;
        }

        public final void run() {
            if (b.this.hNf) {
                x.d("MicroMsg.SenseWhereHelper", "it is collection now, do not start sense where sdk.");
            } else if (b.this.Ru()) {
                b.Rv();
                if (b.this.hNn.size() == 0 && b.this.hNm.size() == 0) {
                    b.e(b.this);
                }
                if (b.a(b.this, this.hNt, this.hNu, this.hNv)) {
                    x.i("MicroMsg.SenseWhereHelper", "it begin to start sense where sdk to upload location info.[%d, %f, %f, %d]", Integer.valueOf(this.hNt), Float.valueOf(this.hNu), Float.valueOf(this.hNv), Integer.valueOf(this.hNw));
                    b.this.hNf = true;
                    com.tencent.mm.kernel.g.Dq().Db().a(a.USERINFO_LAST_START_SENSE_WHERE_LONG, Long.valueOf(bi.Wx()));
                    com.tencent.mm.sdk.b.a.xmy.b(b.this.hNo);
                    if (b.this.hNl != null) {
                        b.this.hNl.finish();
                    }
                    b.this.hNr = 0;
                    b.this.startTime = bi.Wz();
                    b.this.hNl = new c(this.hNu, this.hNv, this.hNx, this.hNy, this.hNz, this.hNA, this.hNt, this.hNw);
                    Object Rw = b.Rs();
                    if (TextUtils.isEmpty(Rw)) {
                        throw new NullPointerException("SenseWhereEngine:invalid imei!");
                    }
                    t.setImei(Rw);
                    t.a(ad.getContext(), b.this.hNl);
                    Handler i = b.this.hNg = new ah("sensewhere");
                    int i2 = b.this.hNh;
                    t.a(i, (long) b.this.hNi, b.this.hNq, b.this.hNs);
                    g.pWK.a(345, 1, 1, false);
                    b.a(b.this, b.this.hNj);
                }
            } else {
                x.d("MicroMsg.SenseWhereHelper", "it do not start sense where sdk by config.");
            }
        }
    }

    static /* synthetic */ void a(b bVar, int i) {
        long j = (long) i;
        bVar.hNp.K(j, j);
    }

    static /* synthetic */ boolean a(b bVar, int i, float f, float f2) {
        List<d> list = i == 1 ? bVar.hNm : bVar.hNn;
        if (list == null || list.size() <= 0) {
            x.i("MicroMsg.SenseWhereHelper", "it has not report location, do not start sense where.");
            return false;
        }
        boolean z;
        long Wz = bi.Wz();
        for (d dVar : list) {
            x.d("MicroMsg.SenseWhereHelper", "loc[%f, %f], config[%f, %f], dis[%f, %f]", Float.valueOf(f2), Float.valueOf(f), Double.valueOf(dVar.latitude), Double.valueOf(dVar.longitude), Double.valueOf(TencentLocationUtils.distanceBetween(dVar.latitude, dVar.longitude, (double) f2, (double) f)), Double.valueOf(dVar.hNI));
            if (TencentLocationUtils.distanceBetween(dVar.latitude, dVar.longitude, (double) f2, (double) f) <= dVar.hNI) {
                z = true;
                break;
            }
        }
        z = false;
        x.i("MicroMsg.SenseWhereHelper", "check location[%d, %f, %f] finish %b, cost time %d", Integer.valueOf(i), Float.valueOf(f2), Float.valueOf(f), Boolean.valueOf(z), Long.valueOf(bi.bB(Wz)));
        return z;
    }

    static /* synthetic */ void e(b bVar) {
        bVar.hNm.clear();
        bVar.hNn.clear();
        String str = (String) com.tencent.mm.kernel.g.Dq().Db().get(a.USERINFO_SENSE_WHERE_LOCATION_STRING, (Object) "");
        if (bi.oN(str)) {
            x.i("MicroMsg.SenseWhereHelper", "sense where location xml is null.");
            return;
        }
        Map y = f.y(str, "SenseWhere");
        if (y == null) {
            x.w("MicroMsg.SenseWhereHelper", "parseLocation maps is null, xml[%s]", str);
            return;
        }
        int i = 0;
        while (true) {
            String str2 = ".SenseWhere.item" + (i == 0 ? "" : Integer.valueOf(i));
            str = (String) y.get(str2 + ".$gpstype");
            if (bi.oN(str)) {
                g.pWK.a(345, 6, 1, false);
                x.i("MicroMsg.SenseWhereHelper", "parse location finish earth[%d] mars[%d]", Integer.valueOf(bVar.hNn.size()), Integer.valueOf(bVar.hNm.size()));
                return;
            }
            d dVar = new d();
            dVar.hNH = str;
            dVar.longitude = bi.getDouble((String) y.get(str2 + ".$longitude"), 0.0d);
            dVar.latitude = bi.getDouble((String) y.get(str2 + ".$latitude"), 0.0d);
            dVar.hNI = bi.getDouble((String) y.get(str2 + ".$distance"), 0.0d);
            if (dVar.hNI > 5500000.0d) {
                dVar.hNI = 5500000.0d;
            }
            if ("1".equals(dVar.hNH)) {
                bVar.hNm.add(dVar);
            } else {
                bVar.hNn.add(dVar);
            }
            i++;
        }
    }

    static /* synthetic */ void l(b bVar) {
        if (bVar.hNg != null) {
            bVar.hNg.oFY.quit();
        }
        bVar.hNg = null;
    }

    static /* synthetic */ void n(b bVar) {
        if (bVar.startTime > 0) {
            x.d("MicroMsg.SenseWhereHelper", "reportCollectionTime time %d, res %d", Long.valueOf((bi.Wz() - bVar.startTime) / 1000), Integer.valueOf(bi.e((Integer) g.a((int) ((bi.Wz() - bVar.startTime) / 1000), new int[]{5, 10, 20, 30}, 10, 14))));
            g.pWK.a(345, (long) r0, 1, false);
        }
    }

    static /* synthetic */ int o(b bVar) {
        int i = bVar.hNr + 1;
        bVar.hNr = i;
        return i;
    }

    public static b Rr() {
        if (hNe == null) {
            hNe = new b();
        }
        return hNe;
    }

    public b() {
        com.tencent.mm.kernel.g.Dr();
        this.hNp = new al(com.tencent.mm.kernel.g.Dt().oFY.getLooper(), new al.a() {
            public final boolean uG() {
                x.i("MicroMsg.SenseWhereHelper", "time up, stop sense where sdk.");
                g.pWK.a(345, 2, 1, false);
                b.this.Rt();
                return false;
            }
        }, false);
        this.hNq = new com.tencent.map.a.a.b() {
            public final void a(double d, double d2, int i, int i2, long j) {
                x.d("MicroMsg.SenseWhereHelper", "onLocationUpdate latitude[%f] longitude[%f] error[%d] floor[%d] buildingId[%d]", Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j));
            }
        };
        this.hNr = 0;
        this.hNs = new com.tencent.map.a.a.c() {
            public final void onMessage(int i, String str) {
                x.d("MicroMsg.SenseWhereHelper", "onMessage code[%d] message[%s]", Integer.valueOf(i), str);
                if (i != 0 && b.o(b.this) > 3) {
                    x.i("MicroMsg.SenseWhereHelper", "sense where error time more than %d, stop now.", Integer.valueOf(3));
                    g.pWK.a(345, 3, 1, false);
                    b.this.Rt();
                }
            }
        };
    }

    private static String Rs() {
        String yL = q.yL();
        com.tencent.mm.kernel.g.Do();
        try {
            x.i("MicroMsg.SenseWhereHelper", "create encrypt imei[%s], original imei[%s]", new String(Base64.encode(new s().encrypt((yL + "_" + new o(com.tencent.mm.kernel.a.Cn()).toString()).getBytes("UTF-8"), hNd), 0), "UTF-8"), bi.Wz(r1));
            return new String(Base64.encode(new s().encrypt((yL + "_" + new o(com.tencent.mm.kernel.a.Cn()).toString()).getBytes("UTF-8"), hNd), 0), "UTF-8");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SenseWhereHelper", e, "", new Object[0]);
            x.e("MicroMsg.SenseWhereHelper", "create imei error: " + e.toString());
            return "";
        }
    }

    public final void Rt() {
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dt().F(new Runnable() {
            public final void run() {
                x.i("MicroMsg.SenseWhereHelper", "it stop sense where sdk.");
                com.tencent.mm.sdk.b.a.xmy.c(b.this.hNo);
                t.sq();
                t.finish();
                if (b.this.hNl != null) {
                    b.this.hNl.finish();
                    b.this.hNl = null;
                }
                b.l(b.this);
                b.this.hNp.TN();
                b.n(b.this);
                b.this.hNf = false;
            }
        });
    }

    private boolean Ru() {
        com.tencent.mm.kernel.g.Do();
        if (new o(com.tencent.mm.kernel.a.Cn()).longValue() < 1000000) {
            x.i("MicroMsg.SenseWhereHelper", "it boss uin do not start sense where.");
            return false;
        }
        String value = com.tencent.mm.j.g.Af().getValue("AndroidSenseWhereArgs");
        if (bi.oN(value)) {
            x.i("MicroMsg.SenseWhereHelper", "it has no config do not start sense where.");
            return false;
        }
        try {
            x.d("MicroMsg.SenseWhereHelper", "sense where config : " + value);
            String[] split = value.split(";");
            int i = bi.getInt(split[0], 0);
            com.tencent.mm.kernel.g.Do();
            if (h.aJ(com.tencent.mm.kernel.a.Cn() + 5, 100) > i) {
                x.d("MicroMsg.SenseWhereHelper", "do not start sense where.uinhash %d, percent %d", Integer.valueOf(h.aJ(com.tencent.mm.kernel.a.Cn() + 5, 100)), Integer.valueOf(i));
                return false;
            }
            this.hNi = bi.getInt(split[1], 5000);
            this.hNh = bi.getInt(split[2], 5000);
            this.hNj = bi.getInt(split[3], 30000);
            this.hNk = bi.getInt(split[4], 3600);
            x.i("MicroMsg.SenseWhereHelper", "check sense where report args[%d, %d, %d, %d]", Integer.valueOf(this.hNi), Integer.valueOf(this.hNh), Integer.valueOf(this.hNj), Integer.valueOf(this.hNk));
            if (bi.bz(((Long) com.tencent.mm.kernel.g.Dq().Db().get(a.USERINFO_LAST_START_SENSE_WHERE_LONG, Long.valueOf(0))).longValue()) > ((long) this.hNk)) {
                return true;
            }
            x.i("MicroMsg.SenseWhereHelper", "it is not time out. diff[%d], collection interval[%d]", Long.valueOf(bi.bz(((Long) com.tencent.mm.kernel.g.Dq().Db().get(a.USERINFO_LAST_START_SENSE_WHERE_LONG, Long.valueOf(0))).longValue())), Integer.valueOf(this.hNk));
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SenseWhereHelper", e, "", new Object[0]);
            x.e("MicroMsg.SenseWhereHelper", "check sense where config error: " + e.toString());
            x.i("MicroMsg.SenseWhereHelper", "it default do not start sense where.");
            return false;
        }
    }

    public static void Rv() {
        if (bi.bz(bi.a((Long) com.tencent.mm.kernel.g.Dq().Db().get(a.USERINFO_LAST_GET_SENSE_WHERE_LOCATION_LONG, null), 0)) * 1000 > 21600000) {
            x.i("MicroMsg.SenseWhereHelper", "update sense where location package list.");
            com.tencent.mm.kernel.g.Dp().gRu.a(new k(36), 0);
            com.tencent.mm.kernel.g.Dq().Db().a(a.USERINFO_LAST_GET_SENSE_WHERE_LOCATION_LONG, Long.valueOf(bi.Wx()));
        }
    }
}
