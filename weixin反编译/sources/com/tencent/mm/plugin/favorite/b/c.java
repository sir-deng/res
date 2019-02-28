package com.tencent.mm.plugin.favorite.b;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.a.o;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class c implements e {
    private static Map<Long, a> fmj = new HashMap();
    private Queue<f> fmh = new LinkedList();
    private boolean fml = false;
    private boolean fmm = false;
    private long fmo = 0;
    public al fms = new al(as.Dt().oFY.getLooper(), new al.a() {
        public final boolean uG() {
            try {
                c.b(c.this);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", e, "", new Object[0]);
            }
            return false;
        }

        public final String toString() {
            return super.toString() + "|scenePusher";
        }
    }, false);
    public n huc = new n.a() {
        public final void eq(int i) {
            try {
                boolean isWifi = ao.isWifi(ad.getContext());
                if (i == 4 || i == 6) {
                    x.i("MicroMsg.Fav.FavCheckCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", Integer.valueOf(i), Boolean.valueOf(isWifi), Boolean.valueOf(c.this.mwN));
                    if (!c.this.mwN && isWifi) {
                        c cVar = c.this;
                        List<f> aIH = h.getFavItemInfoStorage().aIH();
                        if (aIH == null || aIH.size() <= 0) {
                            x.i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size 0");
                        } else {
                            x.i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size:%d", Integer.valueOf(aIH.size()));
                            for (f fVar : aIH) {
                                if (fVar.field_itemStatus == 3) {
                                    fVar.field_itemStatus = 1;
                                    h.getFavItemInfoStorage().a(fVar, "localId");
                                }
                            }
                            cVar.run();
                        }
                    }
                    c.this.mwN = isWifi;
                    return;
                }
                c.this.mwN = isWifi;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", e, "", new Object[0]);
            }
        }
    };
    private boolean mwN = ao.isWifi(ad.getContext());

    static /* synthetic */ void b(c cVar) {
        f fVar;
        cVar.fmo = System.currentTimeMillis();
        if (!cVar.fml && cVar.fmh.size() == 0) {
            List<f> aII = h.getFavItemInfoStorage().aII();
            if (!(aII == null || aII.size() == 0)) {
                for (f fVar2 : aII) {
                    if (fmj.containsKey(Long.valueOf(fVar2.field_localId))) {
                        x.d("MicroMsg.Fav.FavCheckCdnService", "File is Already running:" + fVar2.field_localId);
                    } else {
                        cVar.fmh.add(fVar2);
                        fmj.put(Long.valueOf(fVar2.field_localId), null);
                    }
                }
                x.i("MicroMsg.Fav.FavCheckCdnService", "klem GetNeedRun procing:" + fmj.size() + ",send:" + cVar.fmh.size() + "]");
                cVar.fmh.size();
            }
        }
        if (!cVar.fml && cVar.fmh.size() <= 0) {
            cVar.vC();
            x.i("MicroMsg.Fav.FavCheckCdnService", "klem No Data Any More , Stop Service");
        } else if (!cVar.fml && cVar.fmh.size() > 0) {
            fVar2 = (f) cVar.fmh.poll();
            if (fVar2 != null && fVar2.field_localId > 0) {
                cVar.fml = true;
                as.CN().a(new o(fVar2), 0);
            }
        }
    }

    public c() {
        as.a(this.huc);
        as.CN().a((int) TencentLocation.ERROR_UNKNOWN, (e) this);
    }

    public final void a(final int i, int i2, String str, final k kVar) {
        as.Dt().F(new Runnable() {
            public final void run() {
                if (kVar.getType() == TencentLocation.ERROR_UNKNOWN && (kVar instanceof o)) {
                    c.this.fml = false;
                    long j = ((o) kVar).mwn.field_localId;
                    f fVar = ((o) kVar).mwn;
                    c.fmj.remove(Long.valueOf(j));
                    if (i != 0) {
                        x.e("MicroMsg.Fav.FavCheckCdnService", "achieved retry limit, set error, localId:%d", Long.valueOf(j));
                        g.pWK.h(10659, Integer.valueOf(0), Integer.valueOf(fVar.field_type), Integer.valueOf(-2), Long.valueOf(j.b(fVar)), Long.valueOf(com.tencent.mm.plugin.fav.a.g.cV(fVar.field_localId)));
                        h.getFavItemInfoStorage().t(3, j);
                    }
                    c.b(c.this);
                }
            }

            public final String toString() {
                return super.toString() + "|onSceneEnd";
            }
        });
    }

    public final void run() {
        as.Dt().F(new Runnable() {
            public final void run() {
                long currentTimeMillis = System.currentTimeMillis() - c.this.fmo;
                if (c.this.fmm) {
                    if (currentTimeMillis >= 60000) {
                        x.e("MicroMsg.Fav.FavCheckCdnService", "klem ERR: Try Run service runningFlag:" + c.this.fmm + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + c.this.fmm);
                    } else {
                        return;
                    }
                }
                c.this.fml = false;
                c.this.fmm = true;
                c.this.fms.K(10, 10);
            }

            public final String toString() {
                return super.toString() + "|run";
            }
        });
    }

    public final void vC() {
        this.fmh.clear();
        fmj.clear();
        this.fmm = false;
        this.fml = false;
    }
}
