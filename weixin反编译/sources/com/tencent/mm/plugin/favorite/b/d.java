package com.tencent.mm.plugin.favorite.b;

import android.os.SystemClock;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.JsApiVoiceSplitJoint;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.r;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d implements e {
    public Map<String, a> mwW = new HashMap();

    private static class a {
        int mwy;
        com.tencent.mm.plugin.fav.a.e mwz;
        int retryCount;
        long time;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    static /* synthetic */ void a(a aVar, boolean z) {
        aVar.retryCount--;
        if (aVar.retryCount < 0) {
            if (SystemClock.elapsedRealtime() - aVar.time < 7200000) {
                x.i("MicroMsg.Fav.FavEditService", "try mod item fail time limit, favid %d, localId %d, edit type %d", Integer.valueOf(aVar.mwy), Long.valueOf(aVar.mwz.field_localId), Integer.valueOf(aVar.mwz.field_type));
                return;
            }
            aVar.time = SystemClock.elapsedRealtime();
            aVar.retryCount = 3;
        }
        if (aVar.mwy <= 0) {
            f dc = h.getFavItemInfoStorage().dc(aVar.mwz.field_localId);
            if (dc == null || dc.field_id <= 0) {
                x.w("MicroMsg.Fav.FavEditService", "want to start mod item, but favid is invalid, local id %d", Long.valueOf(aVar.mwz.field_localId));
                return;
            }
            aVar.mwy = dc.field_id;
            x.i("MicroMsg.Fav.FavEditService", "want mod item, find id %d by local id %d", Integer.valueOf(aVar.mwy), Long.valueOf(aVar.mwz.field_localId));
        } else if (!z) {
            x.w("MicroMsg.Fav.FavEditService", "want to mod item, favid %d, it is running, but not enforce, return", Integer.valueOf(aVar.mwy));
            return;
        }
        x.i("MicroMsg.Fav.FavEditService", "try mod item, enforce %B, favid %d, edit type %d", Boolean.valueOf(z), Integer.valueOf(aVar.mwy), Integer.valueOf(aVar.mwz.field_type));
        as.CN().a(new r(aVar.mwy, aVar.mwz), 0);
    }

    public d() {
        as.CN().a((int) JsApiVoiceSplitJoint.CTRL_INDEX, (e) this);
        as.CN().a(401, (e) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar != null) {
            x.i("MicroMsg.Fav.FavEditService", "on edit service scene end, errType=%d errCode=%d, %s, scene type %d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(kVar.getType()));
            if (kVar.getType() == 401) {
                x.i("MicroMsg.Fav.FavEditService", "on add fav item scene end, try mod item");
                run();
                return;
            }
            r rVar = (r) kVar;
            if (rVar.type == 0) {
                return;
            }
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.Fav.FavEditService", "clear job, key %s", t(rVar.aJC(), rVar.aJD()));
                this.mwW.remove(r0);
                h.aJa().p(rVar.aJC(), rVar.aJD());
                f dc = h.getFavItemInfoStorage().dc(rVar.aJC());
                if (dc != null) {
                    g gVar = g.pWK;
                    Object[] objArr = new Object[4];
                    objArr[0] = Integer.valueOf(dc.field_id);
                    objArr[1] = Integer.valueOf(dc.field_tagProto.wmn.size());
                    objArr[2] = Integer.valueOf(h.aIX().aJe());
                    objArr[3] = Integer.valueOf(rVar.mwz == null ? 1 : rVar.mwz.field_scene);
                    gVar.h(11122, objArr);
                    return;
                }
                return;
            }
            x.i("MicroMsg.Fav.FavEditService", "retry job, key %s", t(rVar.aJC(), rVar.aJD()));
            final a aVar = (a) this.mwW.get(r0);
            if (aVar == null) {
                x.w("MicroMsg.Fav.FavEditService", "want to retry mod item, localid %d, type %d", Long.valueOf(r2), Integer.valueOf(r4));
            } else {
                as.Dt().g(new Runnable() {
                    public final void run() {
                        d.a(aVar, false);
                    }

                    public final String toString() {
                        return super.toString() + "|retryJob";
                    }
                }, 3000);
            }
        }
    }

    public final void run() {
        as.Dt().F(new Runnable() {
            public final void run() {
                List<com.tencent.mm.plugin.fav.a.e> aIE = h.aJa().aIE();
                if (aIE != null) {
                    x.i("MicroMsg.Fav.FavEditService", "infos size %d", Integer.valueOf(aIE.size()));
                    for (com.tencent.mm.plugin.fav.a.e eVar : aIE) {
                        String t = d.t(eVar.field_localId, eVar.field_type);
                        a aVar = (a) d.this.mwW.get(t);
                        if (aVar == null) {
                            x.i("MicroMsg.Fav.FavEditService", "not match key %s", t);
                            aVar = new a();
                            aVar.mwz = eVar;
                            aVar.retryCount = 3;
                            aVar.time = SystemClock.elapsedRealtime();
                            d.this.mwW.put(t, aVar);
                            d.a(aVar, true);
                        } else {
                            x.i("MicroMsg.Fav.FavEditService", "match key %s, check start", t);
                            d.a(aVar, false);
                        }
                    }
                }
            }

            public final String toString() {
                return super.toString() + "|run";
            }
        });
    }

    public static String t(long j, int i) {
        return j + "&&" + i;
    }
}
