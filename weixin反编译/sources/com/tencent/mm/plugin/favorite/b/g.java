package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.a.l;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class g implements e {
    private static Map<Long, a> fmj = new HashMap();
    private static Map<Long, Integer> mwZ = new HashMap();
    private static Set<Long> mxb = new HashSet();
    private Queue<f> fmh = new LinkedList();
    public boolean fml = false;
    private boolean fmm = false;
    public int fmn = 0;
    private long fmo = 0;
    public al fms = new al(as.Dt().oFY.getLooper(), new al.a() {
        public final boolean uG() {
            try {
                g.d(g.this);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Fav.FavSendService", e, "", new Object[0]);
            }
            return false;
        }

        public final String toString() {
            return super.toString() + "|scenePusher";
        }
    }, false);

    static /* synthetic */ boolean d(g gVar) {
        f fVar;
        x.i("MicroMsg.Fav.FavSendService", "tryStartNetscene");
        gVar.fmo = System.currentTimeMillis();
        if (!gVar.fml && gVar.fmh.size() == 0) {
            List<f> aIJ = h.getFavItemInfoStorage().aIJ();
            if (!(aIJ == null || aIJ.size() == 0)) {
                for (f fVar2 : aIJ) {
                    if (mxb.contains(Long.valueOf(fVar2.field_localId))) {
                        x.i("MicroMsg.Fav.FavSendService", "info has existed, id %d, localId %d, sourceType %d, sourceId %s", Integer.valueOf(fVar2.field_id), Long.valueOf(fVar2.field_localId), Integer.valueOf(fVar2.field_sourceType), fVar2.field_sourceId);
                    } else if (fmj.containsKey(Long.valueOf(fVar2.field_localId))) {
                        x.i("MicroMsg.Fav.FavSendService", "File is Already running:" + fVar2.field_localId);
                    } else {
                        if (!mwZ.containsKey(Long.valueOf(fVar2.field_localId))) {
                            mwZ.put(Long.valueOf(fVar2.field_localId), Integer.valueOf(3));
                        }
                        gVar.fmh.add(fVar2);
                        fmj.put(Long.valueOf(fVar2.field_localId), null);
                    }
                }
                x.i("MicroMsg.Fav.FavSendService", "klem GetNeedRun procing:" + fmj.size() + ",send:" + gVar.fmh.size() + "]");
                gVar.fmh.size();
            }
        }
        if (gVar.fml || gVar.fmh.size() > 0) {
            x.i("MicroMsg.Fav.FavSendService", "Has Data, start service %d", Integer.valueOf(gVar.fmh.size()));
            if (!gVar.fml && gVar.fmh.size() > 0) {
                fVar2 = (f) gVar.fmh.poll();
                if (fVar2 != null && fVar2.field_localId > 0) {
                    gVar.fml = true;
                    as.CN().a(new l(fVar2), 0);
                    return true;
                }
            }
        }
        gVar.vC();
        x.i("MicroMsg.Fav.FavSendService", "klem No Data Any More , Stop Service");
        return false;
    }

    public g() {
        as.CN().a(401, (e) this);
    }

    public final void a(final int i, final int i2, String str, final k kVar) {
        x.i("MicroMsg.Fav.FavSendService", "on scene end, errType %d, errCode %d", Integer.valueOf(i), Integer.valueOf(i2));
        as.Dt().F(new Runnable() {
            public final void run() {
                if (kVar.getType() == 401 && (kVar instanceof l)) {
                    g.this.fml = false;
                    f fVar = ((l) kVar).mwg;
                    long j = fVar.field_localId;
                    g.fmj.remove(Long.valueOf(j));
                    if ((i == 0 && i2 == 0) || i2 == -400) {
                        g.mxb.add(Long.valueOf(j));
                    }
                    if (!(i == 0 || i2 == -400)) {
                        g.this.fmn = g.this.fmn - 1;
                    }
                    Integer valueOf = Integer.valueOf(bi.a((Integer) g.mwZ.get(Long.valueOf(j)), 0));
                    if (!(i == 1 || i == 0)) {
                        valueOf = Integer.valueOf(valueOf.intValue() - 1);
                        g.mwZ.put(Long.valueOf(fVar.field_localId), valueOf);
                    }
                    if (valueOf.intValue() <= 0) {
                        int cA = com.tencent.mm.plugin.fav.a.g.cA(i, i2);
                        com.tencent.mm.plugin.report.service.g.pWK.h(10659, Integer.valueOf(0), Integer.valueOf(fVar.field_type), Integer.valueOf(cA), Long.valueOf(j.b(fVar)), Long.valueOf(com.tencent.mm.plugin.fav.a.g.cV(fVar.field_localId)));
                        g.mwZ.remove(Long.valueOf(j));
                        x.e("MicroMsg.Fav.FavSendService", "achieved retry limit, set error, localId:%d", Long.valueOf(j));
                        if (fVar.field_itemStatus == 12) {
                            h.getFavItemInfoStorage().t(14, fVar.field_localId);
                        }
                        if (fVar.field_itemStatus == 9) {
                            h.getFavItemInfoStorage().t(11, fVar.field_localId);
                        }
                    }
                    if (g.this.fmn <= 0) {
                        x.i("MicroMsg.Fav.FavSendService", "klem stopFlag <= 0 , Stop Service");
                        g.this.vC();
                    } else if (!g.d(g.this)) {
                        j.startSync();
                    }
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
                long currentTimeMillis = System.currentTimeMillis() - g.this.fmo;
                if (g.this.fmm) {
                    if (currentTimeMillis >= 60000) {
                        x.e("MicroMsg.Fav.FavSendService", "klem ERR: Try Run service runningFlag:" + g.this.fmm + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + g.this.fmm);
                    } else {
                        return;
                    }
                }
                g.this.fml = false;
                g.this.fmm = true;
                g.this.fmn = 3;
                g.this.fms.K(10, 10);
            }

            public final String toString() {
                return super.toString() + "|run";
            }
        });
    }

    public final void vC() {
        x.i("MicroMsg.Fav.FavSendService", "on finish");
        this.fmh.clear();
        fmj.clear();
        this.fmm = false;
        this.fml = false;
        mwZ.clear();
    }
}
