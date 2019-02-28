package com.tencent.mm.plugin.sns.a.b;

import android.app.Activity;
import android.view.View;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.ki;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.be;
import com.tencent.mm.protocal.c.bh;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public final class g implements b {
    public static Map<String, Integer> qVb = new HashMap();
    public Activity activity;
    long kIK = 0;
    public HashMap<String, Long> qUQ = new HashMap();
    public HashSet<Long> qUR = new HashSet();
    private Map<String, Long> qUS = new HashMap();
    private Map<String, Integer> qUT = new HashMap();
    private Map<String, a> qUU = new HashMap();
    public HashSet<Long> qUV = new HashSet();
    public Map<Long, h> qUW = new HashMap();
    public Map<Long, h> qUX = new HashMap();
    public Map<String, a> qUY = new HashMap();
    private LinkedList<String> qUZ = new LinkedList();
    public int qUk = 0;
    private Map<String, Integer> qVa = new HashMap();
    private int qVc = 0;
    public View qVd = null;
    public Map<Long, Integer> qVe = new HashMap();
    public Map<Long, Integer> qVf = new HashMap();
    private int qVg = -1;
    public int sceneType = 1;

    static class a {
        public String fJa;
        public String hQh;
        public long hQi;
        public int kZv;
        public int position;
        public long qVm;
        public long qVn = 0;
        public long time;

        public a(long j, String str, int i, String str2, int i2, long j2) {
            this.time = j;
            this.fJa = str;
            this.position = i;
            this.hQh = str2;
            this.hQi = j2;
            this.kZv = i2;
        }
    }

    public final boolean ej(long j) {
        return this.qUR.contains(Long.valueOf(j));
    }

    public g(int i) {
        this.sceneType = i;
    }

    public final void onResume() {
        if (this.kIK > 0) {
            long bB = bi.bB(this.kIK);
            for (String str : this.qUY.keySet()) {
                x.i("MicroMsg.SnsAdStatistic", "before Key " + str + " " + ((a) this.qUY.get(str)).time);
            }
            for (String str2 : this.qUY.keySet()) {
                a aVar = (a) this.qUY.get(str2);
                aVar.time += bB;
                if (aVar.qVm > 0) {
                    aVar.qVm += bB;
                }
                h hVar = (h) this.qUW.get(Long.valueOf(aVar.hQi));
                if (hVar != null) {
                    hVar.onResume();
                }
                h hVar2 = (h) this.qUX.get(Long.valueOf(aVar.hQi));
                if (hVar2 != null) {
                    hVar2.onResume();
                }
            }
            for (String str22 : this.qUY.keySet()) {
                x.i("MicroMsg.SnsAdStatistic", "update Key " + str22 + " " + ((a) this.qUY.get(str22)).time);
            }
        }
    }

    public final void m(final long j, final boolean z) {
        ah.y(new Runnable() {
            public final void run() {
                if (g.this.ej(j)) {
                    g gVar = g.this;
                    long j = j;
                    boolean z = z;
                    h hVar = z ? gVar.qUX.containsKey(Long.valueOf(j)) ? (h) gVar.qUX.get(Long.valueOf(j)) : new h("timeline") : gVar.qUW.containsKey(Long.valueOf(j)) ? (h) gVar.qUW.get(Long.valueOf(j)) : new h("timeline");
                    hVar.qVo = 1;
                    hVar.qVw.qWt++;
                    if (z) {
                        gVar.qUX.put(Long.valueOf(j), hVar);
                    } else {
                        gVar.qUW.put(Long.valueOf(j), hVar);
                    }
                }
            }
        });
    }

    public final void w(long j, int i) {
        a(j, i, true, false);
    }

    public final void a(long j, int i, boolean z, boolean z2) {
        final long j2 = j;
        final int i2 = i;
        final boolean z3 = z2;
        ah.y(new Runnable(true) {
            public final void run() {
                g.this.b(j2, i2, true, z3);
            }
        });
    }

    public final void n(long j, boolean z) {
        b(j, 0, z, false);
    }

    public final void b(long j, int i, boolean z, boolean z2) {
        h hVar;
        if (z2) {
            if (this.qUX.containsKey(Long.valueOf(j))) {
                hVar = (h) this.qUX.get(Long.valueOf(j));
            } else {
                hVar = new h("timeline");
            }
        } else if (this.qUW.containsKey(Long.valueOf(j))) {
            hVar = (h) this.qUW.get(Long.valueOf(j));
        } else {
            hVar = new h("timeline");
        }
        if (i > 0) {
            hVar.qVy = (long) i;
            hVar.qVw.qWv = i;
        }
        hVar.qVo = z ? 1 : 0;
        if (z2) {
            this.qUX.put(Long.valueOf(j), hVar);
        } else {
            this.qUW.put(Long.valueOf(j), hVar);
        }
    }

    public final void o(long j, boolean z) {
        a(j, z, 1, false);
    }

    public final void a(long j, boolean z, int i, boolean z2) {
        h hVar;
        if (z2) {
            if (this.qUX.containsKey(Long.valueOf(j))) {
                hVar = (h) this.qUX.get(Long.valueOf(j));
            } else {
                hVar = new h("timeline");
            }
        } else if (this.qUW.containsKey(Long.valueOf(j))) {
            hVar = (h) this.qUW.get(Long.valueOf(j));
        } else {
            hVar = new h("timeline");
        }
        if (z) {
            hVar.qVw.qWw = 2;
        } else {
            hVar.qVw.qWw = 1;
        }
        hVar.qVw.qWx = 1;
        if (z2) {
            this.qUX.put(Long.valueOf(j), hVar);
        } else {
            this.qUW.put(Long.valueOf(j), hVar);
        }
    }

    public final void B(long j, long j2) {
        final long j3 = j;
        final long j4 = j2;
        ah.y(new Runnable() {
            public final void run() {
                if (g.this.ej(j3)) {
                    g gVar = g.this;
                    long j = j4;
                    if (!gVar.qUV.contains(Long.valueOf(j))) {
                        gVar.qUV.add(Long.valueOf(j));
                    }
                }
            }
        });
    }

    public final boolean ek(long j) {
        if (this.qUV.contains(Long.valueOf(j))) {
            return true;
        }
        return false;
    }

    public final void b(long j, long j2, boolean z) {
        final long j3 = j;
        final long j4 = j2;
        final boolean z2 = z;
        ah.y(new Runnable() {
            public final void run() {
                if (g.this.ej(j3)) {
                    g gVar = g.this;
                    long j = j3;
                    long j2 = j4;
                    boolean z = z2;
                    h hVar = z ? gVar.qUX.containsKey(Long.valueOf(j)) ? (h) gVar.qUX.get(Long.valueOf(j)) : new h("timeline") : gVar.qUW.containsKey(Long.valueOf(j)) ? (h) gVar.qUW.get(Long.valueOf(j)) : new h("timeline");
                    if (hVar.qVw.qWy == 0) {
                        hVar.qVw.qWy = j2;
                    }
                    if (z) {
                        gVar.qUX.put(Long.valueOf(j), hVar);
                    } else {
                        gVar.qUW.put(Long.valueOf(j), hVar);
                    }
                }
            }
        });
    }

    public final void p(long j, boolean z) {
        Object obj;
        if (z) {
            if (this.qUX.containsKey(Long.valueOf(j))) {
                obj = (h) this.qUX.get(Long.valueOf(j));
                obj.wJ(0);
            } else {
                obj = new h("timeline");
            }
            this.qUX.put(Long.valueOf(j), obj);
            return;
        }
        if (this.qUW.containsKey(Long.valueOf(j))) {
            obj = (h) this.qUW.get(Long.valueOf(j));
            obj.wJ(0);
        } else {
            obj = new h("timeline");
        }
        this.qUW.put(Long.valueOf(j), obj);
    }

    public final void onPause() {
        this.kIK = bi.Wz();
        for (String str : this.qUY.keySet()) {
            a aVar = (a) this.qUY.get(str);
            h hVar = (h) this.qUW.get(Long.valueOf(aVar.hQi));
            if (hVar != null) {
                hVar.hQq = bi.Wz();
            }
            h hVar2 = (h) this.qUX.get(Long.valueOf(aVar.hQi));
            if (hVar2 != null) {
                hVar2.hQq = bi.Wz();
            }
        }
    }

    public final void a(int i, String str, String str2, boolean z, View view, long j, bf bfVar, blf blf, int i2, int i3) {
        this.qUR.add(Long.valueOf(j));
        this.qUQ.put(str, Long.valueOf(j));
        if (this.qVg == -1) {
            this.qVg = this.activity == null ? -1 : e.ec(this.activity);
        }
        m LR = ae.bwf().LR(str);
        if (LR == null) {
            x.w("MicroMsg.SnsAdStatistic", "snsinfo not found! skip onAdAdded logic!");
            return;
        }
        a aVar;
        h hVar;
        a aVar2 = (a) this.qUU.get(str);
        if (aVar2 == null && view != null && ae.rbr) {
            a aVar3 = new a(bfVar == null ? null : bfVar.rSq, str, j, view, this.qUk, this.qVd, this.qVg, this.sceneType, blf, i, LR.byB());
            aVar3.qUt = System.currentTimeMillis();
            ae.aOA().post(new Runnable() {
                public final void run() {
                    if (!a.this.qUe) {
                        a.this.buG();
                    }
                }
            });
            this.qUU.put(str, aVar3);
            if (!this.qVe.containsKey(Long.valueOf(j))) {
                this.qVe.put(Long.valueOf(j), Integer.valueOf(LR.field_likeFlag == 1 ? 1 : 0));
            }
            aVar = aVar3;
        } else {
            aVar = aVar2;
        }
        if (i2 == 12 && LR.byF().wYj.wfh.size() > 1) {
            if (this.qUX.containsKey(Long.valueOf(j))) {
                hVar = (h) this.qUX.get(Long.valueOf(j));
            } else {
                hVar = new h("timeline");
            }
            hVar.qVq = bi.Wz();
            this.qUX.put(Long.valueOf(j), hVar);
        }
        if (this.qUS.containsKey(str)) {
            long bB = bi.bB(((Long) this.qUS.get(str)).longValue());
            if (bB < 1200000) {
                int intValue = this.qUT.containsKey(str) ? ((Integer) this.qUT.get(str)).intValue() : 0;
                if (intValue >= 2) {
                    x.i("MicroMsg.SnsAdStatistic", "passed localid " + str + " viewid " + str2 + " passedTime: " + bB);
                    return;
                }
                this.qUT.put(str, Integer.valueOf(intValue + 1));
            } else {
                this.qUS.put(str, Long.valueOf(bi.Wz()));
                this.qUT.put(str, Integer.valueOf(0));
            }
        }
        if (!this.qUY.containsKey(str)) {
            k dVar;
            this.qUY.put(str, new a(bi.Wz(), str, i, str2, i2, j));
            x.i("MicroMsg.SnsAdStatistic", "onAdAdded " + i + " " + str + "  isExposure: " + z);
            if (i2 == 9) {
                if (this.qUW.containsKey(Long.valueOf(j))) {
                    hVar = (h) this.qUW.get(Long.valueOf(j));
                } else {
                    hVar = new h("timeline");
                }
                hVar.qVq = bi.Wz();
                this.qUW.put(Long.valueOf(j), hVar);
            } else if (i2 == 12 && LR.byF().wYj.wfh.size() > 0 && ((are) LR.byF().wYj.wfh.get(0)).kzz == 6) {
                if (this.qUW.containsKey(Long.valueOf(j))) {
                    hVar = (h) this.qUW.get(Long.valueOf(j));
                } else {
                    hVar = new h("timeline");
                }
                hVar.qVq = bi.Wz();
                hVar.qVv = true;
                this.qUW.put(Long.valueOf(j), hVar);
            }
            if (!this.qUZ.contains(str)) {
                this.qUZ.add(str);
                x.i("MicroMsg.SnsAdStatistic", "exposures item " + str);
                this.qVa.put(str, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
            }
            b byB = LR.byB();
            bpb byF = LR.byF();
            bh bhVar = null;
            if (aVar != null && ae.rbr) {
                bhVar = aVar.buH();
            }
            c bzl = LR.bzl();
            int i4 = 0;
            if (i3 == 1) {
                i4 = bzl.field_exposureCount + 1;
                bzl.field_exposureCount = i4;
                ae.bwi().c(bzl, new String[0]);
            }
            if (byB.bxh()) {
                dVar = new d(str2, this.sceneType, bhVar, 3, i4, LR.bzm());
            } else if (byF != null && byF.wYj.wfg == 27) {
                dVar = new d(str2, this.sceneType, 1, 0, null, bhVar, 6, "", i4, LR.bzm(), 0, 0, LR.field_likeFlag == 1 ? 2 : 1);
            } else if (byB.bxi()) {
                if (byF == null || byF.wYj.wfg != 15 || byF.wYq == 1) {
                    dVar = new d(str2, this.sceneType, bhVar, 4, i4, LR.bzm());
                } else {
                    dVar = new d(str2, this.sceneType, bhVar, 5, i4, LR.bzm());
                }
            } else if (i2 == 9) {
                dVar = new d(str2, this.sceneType, bhVar, 2, i4, LR.bzm());
            } else {
                dVar = new d(str2, this.sceneType, bhVar, 1, i4, LR.bzm());
            }
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.a(dVar, 0);
        }
    }

    public final void t(int i, String str, String str2) {
        int nextInt;
        int i2;
        h hVar;
        String buJ;
        if (this.qUQ.containsKey(str)) {
            this.qUR.remove(Long.valueOf(((Long) this.qUQ.remove(str)).longValue()));
        }
        be beVar = null;
        bh bhVar = null;
        a aVar = (a) this.qUU.get(str);
        if (aVar != null && ae.rbr) {
            aVar.kRY = true;
            aVar.qUu = System.currentTimeMillis();
            if (aVar.qUp < 0) {
                aVar.qUK = 2;
            } else {
                aVar.qUK = 1;
            }
            if (aVar.qUr < 0) {
                aVar.qUL = 2;
            } else {
                aVar.qUL = 1;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i.er(aVar.hQi) + ",");
            stringBuilder.append(aVar.hQj + ",");
            stringBuilder.append(aVar.qUK + ",");
            stringBuilder.append(aVar.qUL + ",");
            stringBuilder.append(aVar.qUH + ",");
            stringBuilder.append(aVar.qUI + ",");
            stringBuilder.append(aVar.qUJ + ",");
            stringBuilder.append(aVar.qUt + ",");
            stringBuilder.append(aVar.qUu + ",");
            if (aVar.qUx > 0 && aVar.qUA == 0) {
                aVar.qUA = System.currentTimeMillis();
            }
            stringBuilder.append(aVar.qUx + ",");
            stringBuilder.append(aVar.qUA + ",");
            if (aVar.qUD > 0 && aVar.qUG == 0) {
                aVar.qUG = System.currentTimeMillis();
            }
            stringBuilder.append(aVar.qUD + ",");
            stringBuilder.append(aVar.qUG);
            f.a(aVar.hQi, stringBuilder);
            x.i("MicroMsg.AdViewStatic", "report " + stringBuilder.toString());
            beVar = new be();
            beVar.vNe = aVar.qUD;
            beVar.vNf = aVar.qUG;
            beVar.qUK = aVar.qUK;
            beVar.qUL = aVar.qUL;
            beVar.vMZ = (float) aVar.qUH;
            beVar.vNa = (float) aVar.qUI;
            beVar.vNb = (float) aVar.qUJ;
            beVar.vNc = aVar.qUx;
            beVar.vNd = aVar.qUA;
            beVar.startTime = aVar.qUt;
            beVar.endTime = aVar.qUu;
            if (aVar.qUo == null || !aVar.qUo.bxo()) {
                ae.bvZ().h(12010, stringBuilder.toString());
            } else {
                ae.bvZ().h(14648, stringBuilder.toString());
            }
            com.tencent.mm.modelsns.b ix = com.tencent.mm.modelsns.b.ix(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH);
            ix.mF(i.er(aVar.hQi)).mF(aVar.hQj).iA(aVar.qUK).iA(aVar.qUL).iA(aVar.qUH).iA(aVar.qUI).iA(aVar.qUJ).mF(aVar.qUt).mF(aVar.qUu).mF(aVar.qUx).mF(aVar.qUA).mF(aVar.qUD).mF(aVar.qUG);
            ix.SE();
            com.tencent.mm.sdk.b.b kiVar = new ki();
            kiVar.fCz.position = aVar.position;
            com.tencent.mm.sdk.b.a.xmy.m(kiVar);
            if (r.igs) {
                nextInt = new Random(System.currentTimeMillis()).nextInt(MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) + 10;
                x.i("MicroMsg.AdViewStatic", "run on test kv " + nextInt);
                for (i2 = 0; i2 < nextInt; i2++) {
                    if (aVar.qUo == null || !aVar.qUo.bxo()) {
                        ae.bvZ().h(12010, stringBuilder.toString());
                    } else {
                        ae.bvZ().h(14648, stringBuilder.toString());
                    }
                }
            }
            bhVar = aVar.buH();
            this.qUU.remove(str);
        }
        i2 = 0;
        m LR = ae.bwf().LR(str);
        if (LR != null) {
            if (this.qUX.containsKey(Long.valueOf(LR.field_snsId)) && LR.byF().wYj.wfg == 27) {
                i2 = LR.field_likeFlag == 1 ? 2 : 1;
                int intValue = this.qVf.containsKey(Long.valueOf(LR.field_snsId)) ? ((Integer) this.qVf.get(Long.valueOf(LR.field_snsId))).intValue() : 0;
                if (this.qVe.containsKey(Long.valueOf(LR.field_snsId))) {
                    nextInt = ((Integer) this.qVe.get(Long.valueOf(LR.field_snsId))).intValue();
                } else {
                    nextInt = 0;
                }
                long j = 0;
                long j2 = 0;
                long j3 = 0;
                hVar = (h) this.qUX.remove(Long.valueOf(LR.field_snsId));
                if (hVar != null) {
                    hVar.wJ(0);
                    hVar.buK();
                    j = (long) hVar.qVu;
                    j2 = (long) hVar.qVt;
                    j3 = hVar.qVy * 1000;
                }
                String str3 = "%s,%s,%s,%s,%s,%s,%s,%s,%s";
                Object[] objArr = new Object[9];
                objArr[0] = LR.byF().nMq;
                objArr[1] = LR.bzk();
                objArr[2] = this.sceneType;
                objArr[3] = String.valueOf(intValue);
                objArr[4] = String.valueOf(nextInt);
                objArr[5] = String.valueOf(j);
                objArr[6] = String.valueOf(j2);
                objArr[7] = String.valueOf(j3);
                objArr[8] = LR.field_likeFlag == 1 ? "1" : "0";
                com.tencent.mm.plugin.report.service.g.pWK.k(15155, String.format(str3, objArr));
                x.i("MicroMsg.SnsAdStatistic", "15155, %s", buJ);
                this.qUV.remove(Long.valueOf(LR.field_snsId));
                this.qUV.remove(Long.valueOf(LR.field_snsId + 1));
            }
            this.qVf.remove(Long.valueOf(LR.field_snsId));
            this.qVe.remove(Long.valueOf(LR.field_snsId));
        }
        int i3 = i2;
        if (this.qUY.containsKey(str)) {
            a aVar2 = (a) this.qUY.remove(str);
            this.qUS.put(str, Long.valueOf(bi.Wz()));
            if (aVar2 != null) {
                long bB = bi.bB(aVar2.time);
                if (aVar2.qVm > 0) {
                    aVar2.qVn += bi.bB(aVar2.qVm);
                    aVar2.qVm = 0;
                }
                x.i("MicroMsg.SnsAdStatistic", "onAdRemoved " + i + " " + str + " " + bB + " ");
                if (LR != null) {
                    int i4;
                    String str4;
                    String str5 = "";
                    bpb byF = LR.byF();
                    b byB = LR.byB();
                    if (byB.bxh()) {
                        i4 = 3;
                        str4 = str5;
                    } else if (byF.wYj.wfg == 27) {
                        i4 = 6;
                        hVar = (h) this.qUW.remove(Long.valueOf(aVar2.hQi));
                        if (hVar != null) {
                            if (LR.field_likeFlag == 0) {
                                hVar.wJ(0);
                            }
                            buJ = hVar.buJ();
                        } else {
                            buJ = str5;
                        }
                        str4 = buJ;
                    } else if (byB.bxi()) {
                        if (byF == null || byF.wYj.wfg != 15 || byF.wYq == 1) {
                            i4 = 4;
                            str4 = str5;
                        } else {
                            i4 = 5;
                            hVar = (h) this.qUW.remove(Long.valueOf(aVar2.hQi));
                            if (hVar != null) {
                                hVar.wJ(0);
                                str5 = hVar.buJ();
                            }
                            this.qUV.remove(Long.valueOf(aVar2.hQi));
                            str4 = str5;
                        }
                    } else if (aVar2.kZv == 9) {
                        i4 = 2;
                        hVar = (h) this.qUW.remove(Long.valueOf(aVar2.hQi));
                        if (hVar != null) {
                            hVar.wJ(0);
                            str5 = hVar.buJ();
                        }
                        this.qUV.remove(Long.valueOf(aVar2.hQi));
                        str4 = str5;
                    } else {
                        i4 = 1;
                        str4 = str5;
                    }
                    k dVar = new d(str2, this.sceneType, 2, (int) bB, beVar, bhVar, i4, str4, -1, LR.bzm(), (int) bB, (int) aVar2.qVn, i3);
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dp().gRu.a(dVar, 0);
                    return;
                }
                return;
            }
            return;
        }
        x.i("MicroMsg.SnsAdStatistic", "can not find onAdRemoved " + i + " " + str);
    }

    public final void buI() {
        for (Entry value : this.qUU.entrySet()) {
            a aVar = (a) value.getValue();
            if (aVar != null && ae.rbr) {
                aVar.buG();
                if (!(bi.oN(aVar.fvn) || this.qUY.get(aVar.fvn) == null)) {
                    a aVar2 = (a) this.qUY.get(aVar.fvn);
                    Object obj = aVar.qUM == 1 ? 1 : null;
                    if (obj != null && aVar2.qVm == 0) {
                        aVar2.qVm = bi.Wz();
                    } else if (obj == null && aVar2.qVm > 0) {
                        aVar2.qVn += bi.bB(aVar2.qVm);
                        aVar2.qVm = 0;
                    }
                }
            }
        }
    }

    public final void clear() {
        String str;
        onResume();
        x.i("MicroMsg.SnsAdStatistic", "clean the adRemove" + this.qUZ.size());
        List<String> linkedList = new LinkedList();
        for (String str2 : this.qUY.keySet()) {
            linkedList.add(str2);
        }
        for (String str22 : linkedList) {
            a aVar = (a) this.qUY.get(str22);
            t(aVar.position, aVar.fJa, aVar.hQh);
        }
        Iterator it = this.qUZ.iterator();
        while (it.hasNext()) {
            str22 = (String) it.next();
            com.tencent.mm.plugin.sns.storage.e xC = ae.bwi().xC(u.Ml(str22));
            if (xC != null) {
                int intValue;
                m byH = xC.byH();
                xC.field_localFlag |= FileUtils.S_IWUSR;
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (this.qVa.containsKey(str22)) {
                    intValue = ((Integer) this.qVa.get(str22)).intValue();
                } else {
                    intValue = currentTimeMillis;
                }
                if (xC.field_exposureTime <= 0) {
                    xC.field_exposureTime = intValue;
                }
                byH.field_localFlag |= FileUtils.S_IWUSR;
                ae.bwf().b(byH.field_snsId, byH);
                ae.bwi().b(xC.field_snsId, xC);
            }
        }
        this.qUZ.clear();
        this.qVa.clear();
    }

    public final void el(long j) {
        int i = 0;
        if (this.qVe.containsKey(Long.valueOf(j))) {
            i = ((Integer) this.qVe.get(Long.valueOf(j))).intValue();
        }
        this.qVe.put(Long.valueOf(j), Integer.valueOf(i + 1));
    }

    public final void em(long j) {
        int i = 0;
        if (this.qVf.containsKey(Long.valueOf(j))) {
            i = ((Integer) this.qVf.get(Long.valueOf(j))).intValue();
        }
        this.qVf.put(Long.valueOf(j), Integer.valueOf(i + 1));
    }
}
