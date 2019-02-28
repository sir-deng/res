package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.ad.e;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.JsApiVoiceSplitJoint;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.a.k;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.ash;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vq;
import com.tencent.mm.protocal.c.wg;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class f implements e {
    private static Map<Integer, a> fmj = new HashMap();
    private static Map<Integer, Integer> mwZ = new HashMap();
    private Queue<com.tencent.mm.plugin.fav.a.f> fmh = new LinkedList();
    private boolean fml = false;
    private boolean fmm = false;
    public int fmn = 0;
    private long fmo = 0;
    public al fms = new al(as.Dt().oFY.getLooper(), new al.a() {
        public final boolean uG() {
            try {
                f.d(f.this);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Fav.FavModService", e, "", new Object[0]);
            }
            return false;
        }

        public final String toString() {
            return super.toString() + "|scenePusher";
        }
    }, false);

    static /* synthetic */ void D(com.tencent.mm.plugin.fav.a.f fVar) {
        vq vqVar = new vq();
        StringBuffer stringBuffer = new StringBuffer();
        vqVar.vNB = fVar.field_id;
        stringBuffer.append("favid:" + fVar.field_id);
        vqVar.wmb = new LinkedList();
        Iterator it = fVar.field_favProto.wlY.iterator();
        while (it.hasNext()) {
            uz uzVar = (uz) it.next();
            if (uzVar.wkZ != 0) {
                wg wgVar = new wg();
                if (uzVar.wkZ > 0) {
                    wgVar.wck = uzVar.mBr;
                    wgVar.wcq = 0;
                    wgVar.kyY = uzVar.wkZ;
                } else {
                    wgVar.wck = uzVar.mBr;
                    wgVar.wcq = 1;
                    wgVar.kyY = -uzVar.wkZ;
                }
                stringBuffer.append(" fileId:" + wgVar.wck + " IsThumb:" + wgVar.wcq + " status:" + wgVar.kyY);
                vqVar.wmb.add(wgVar);
                uzVar.Df(0);
            }
        }
        x.i("MicroMsg.Fav.FavModService", "checkFavItem %s", stringBuffer.toString());
        if (vqVar.wmb.size() > 0) {
            ((r) g.k(r.class)).checkFavItem(vqVar);
        }
    }

    static /* synthetic */ boolean d(f fVar) {
        fVar.fmo = System.currentTimeMillis();
        if (!fVar.fml && fVar.fmh.size() == 0) {
            List<com.tencent.mm.plugin.fav.a.f> aIK = h.getFavItemInfoStorage().aIK();
            if (!(aIK == null || aIK.size() == 0)) {
                for (com.tencent.mm.plugin.fav.a.f fVar2 : aIK) {
                    if (fmj.containsKey(Integer.valueOf(fVar2.field_id))) {
                        x.i("MicroMsg.Fav.FavModService", "File is Already running:" + fVar2.field_id);
                    } else {
                        if (!mwZ.containsKey(Integer.valueOf(fVar2.field_id))) {
                            mwZ.put(Integer.valueOf(fVar2.field_id), Integer.valueOf(3));
                        }
                        fVar.fmh.add(fVar2);
                        fmj.put(Integer.valueOf(fVar2.field_id), null);
                    }
                }
                x.i("MicroMsg.Fav.FavModService", "klem GetNeedRun procing:" + fmj.size() + ",send:" + fVar.fmh.size() + "]");
                fVar.fmh.size();
            }
        }
        if (!fVar.fml && fVar.fmh.size() <= 0) {
            fVar.vC();
            x.i("MicroMsg.Fav.FavModService", "klem No Data Any More , Stop Service");
            return false;
        } else if (fVar.fml || fVar.fmh.size() <= 0) {
            return false;
        } else {
            com.tencent.mm.plugin.fav.a.f fVar3 = (com.tencent.mm.plugin.fav.a.f) fVar.fmh.poll();
            if (fVar3 == null || fVar3.field_id <= 0) {
                return false;
            }
            fVar.fml = true;
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            if (fVar3.aIy()) {
                x.i("MicroMsg.Fav.FavModService", "Resend Item %d", Long.valueOf(fVar3.field_localId));
                as.CN().a(new com.tencent.mm.plugin.favorite.a.r(fVar3.field_id, linkedList, linkedList2, com.tencent.mm.plugin.fav.a.f.c(fVar3), (byte) 0), 0);
            } else if (fVar3.field_type != 18) {
                k.a(fVar3.field_localId, linkedList, linkedList2);
                as.CN().a(new com.tencent.mm.plugin.favorite.a.r(fVar3.field_id, linkedList, linkedList2), 0);
            } else {
                ash ash = new ash();
                ash.wGK = 1;
                ash.wGL = (int) bi.Wx();
                linkedList.add(ash);
                as.CN().a(new com.tencent.mm.plugin.favorite.a.r(fVar3.field_id, linkedList, linkedList2, com.tencent.mm.plugin.fav.a.f.c(fVar3)), 0);
            }
            return true;
        }
    }

    public f() {
        as.CN().a((int) JsApiVoiceSplitJoint.CTRL_INDEX, (e) this);
    }

    public final void a(final int i, final int i2, String str, final com.tencent.mm.ad.k kVar) {
        if (kVar.getType() == JsApiVoiceSplitJoint.CTRL_INDEX && (kVar instanceof com.tencent.mm.plugin.favorite.a.r)) {
            as.Dt().F(new Runnable() {
                public final void run() {
                    f.this.fml = false;
                    int i = ((com.tencent.mm.plugin.favorite.a.r) kVar).mwy;
                    f.fmj.remove(Integer.valueOf(i));
                    if (!(i2 == 3 && i2 == 0)) {
                        f.this.fmn = f.this.fmn - 1;
                    }
                    com.tencent.mm.plugin.fav.a.f dd = h.getFavItemInfoStorage().dd((long) i);
                    if (dd != null && dd.field_itemStatus != 10) {
                        if (i != 0 || i2 != 0) {
                            Integer valueOf = Integer.valueOf(bi.a((Integer) f.mwZ.get(Integer.valueOf(i)), 0));
                            if (!(i == 1 || i == 0)) {
                                valueOf = Integer.valueOf(valueOf.intValue() - 1);
                            }
                            if (valueOf.intValue() <= 0) {
                                int cA = com.tencent.mm.plugin.fav.a.g.cA(i, i2);
                                com.tencent.mm.plugin.report.service.g.pWK.h(10659, Integer.valueOf(0), Integer.valueOf(dd.field_type), Integer.valueOf(cA), Long.valueOf(b.b(dd)), Long.valueOf(com.tencent.mm.plugin.fav.a.g.cV(dd.field_localId)));
                                f.mwZ.remove(Integer.valueOf(i));
                                x.e("MicroMsg.Fav.FavModService", "achieved retry limit, set error, favId:%d", Integer.valueOf(i));
                                dd.field_itemStatus = 18;
                                h.getFavItemInfoStorage().a(dd, "localId");
                            }
                        } else if (dd.field_itemStatus == 17) {
                            com.tencent.mm.plugin.report.service.g.pWK.h(10659, Integer.valueOf(0), Integer.valueOf(dd.field_type), Integer.valueOf(0), Long.valueOf(b.b(dd)), Long.valueOf(com.tencent.mm.plugin.fav.a.g.cV(dd.field_localId)));
                            x.i("MicroMsg.Fav.FavModService", "mod end set status done. favId:%d", Integer.valueOf(dd.field_id));
                            dd.field_itemStatus = 10;
                            f.D(dd);
                            h.getFavItemInfoStorage().a(dd, "localId");
                            h.aIZ().cZ(dd.field_localId);
                        }
                        if (f.this.fmn <= 0) {
                            x.i("MicroMsg.Fav.FavModService", "klem stopFlag <= 0 , Stop Service");
                            f.this.vC();
                        } else if (!f.d(f.this)) {
                            j.startSync();
                        }
                    }
                }

                public final String toString() {
                    return super.toString() + "|onSceneEnd";
                }
            });
        }
    }

    public final void run() {
        as.Dt().F(new Runnable() {
            public final void run() {
                long currentTimeMillis = System.currentTimeMillis() - f.this.fmo;
                if (f.this.fmm) {
                    if (currentTimeMillis >= 60000) {
                        x.e("MicroMsg.Fav.FavModService", "klem ERR: Try Run service runningFlag:" + f.this.fmm + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + f.this.fmm);
                    } else {
                        return;
                    }
                }
                f.this.fml = false;
                f.this.fmm = true;
                f.this.fmn = 3;
                f.this.fms.K(10, 10);
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
        mwZ.clear();
    }
}
