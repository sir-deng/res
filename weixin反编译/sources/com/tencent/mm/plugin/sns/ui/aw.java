package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.database.Cursor;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.mm.ad.k;
import com.tencent.mm.k.a;
import com.tencent.mm.kiss.widget.textview.c;
import com.tencent.mm.kiss.widget.textview.f;
import com.tencent.mm.plugin.aj.a.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.widget.d;
import com.tencent.mm.plugin.sns.ui.widget.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.bku;
import com.tencent.mm.protocal.c.blb;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vending.a.b;
import com.tencent.mm.y.q;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aw extends b<ay, m> {
    private boolean DEBUG = false;
    ar hji;
    Context mContext;
    volatile String mgB = "";
    volatile String rCC = "";
    String rOd;
    av rPn;
    private int rPo = ((int) (System.currentTimeMillis() / 1000));
    private a rPp;
    private boolean rPq = false;
    volatile boolean rPr = false;
    byte[] rPs = new byte[0];
    protected HashMap<String, String> rPt = new HashMap();
    public HashMap<String, Boolean> rPu = new HashMap();
    private String rPv = "";
    private String rPw = "";

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        m mVar = (m) obj;
        if (mVar == null) {
            mVar = new m();
        }
        mVar.b(cursor);
        return mVar;
    }

    protected final /* synthetic */ void applyChangeSynchronized(Object obj) {
        Cursor cursor = (Cursor) obj;
        aUU();
        this.BA = cursor;
    }

    public final /* synthetic */ Object yg(int i) {
        return yf(i);
    }

    public aw() {
        super(new m());
        cAv();
    }

    public final void bCb() {
        long j;
        looperCheckForVending();
        if (this.mCount == 0) {
            j = 0;
        } else {
            int i = this.mCount - 1;
            int i2 = 0;
            while (true) {
                m mVar = (m) getItem(i);
                if (mVar != null && !mVar.xD(32) && mVar.field_snsId != 0) {
                    x.i("MicroMsg.SnsTimeLineVendingSide", "get list last not ad item %s %s", Long.valueOf(mVar.field_snsId), mVar.field_stringSeq);
                    j = r4;
                    break;
                }
                i2++;
                int i3 = i - 1;
                if (i3 < 0 || i2 > 500) {
                    j = 0;
                } else {
                    i = i3;
                }
            }
            j = 0;
        }
        this.rPr = true;
        synchronized (this.rPs) {
            this.mgB = q(j, this.mgB);
        }
    }

    String q(long j, String str) {
        x.d("MicroMsg.SnsTimeLineVendingSide", "updateLitmitSeq %s %s", Integer.valueOf(ae.bvV().bwE()), str);
        String es = i.es(ae.bwf().d(j, str.equals("") ? ae.bvV().bwE() / 2 : ae.bvV().bwE(), false));
        String str2 = this.rCC;
        if (!str2.equals("") && es.compareTo(str2) >= 0) {
            es = str2;
        }
        ux byR = ae.bwj().LV("@__weixintimtline").byR();
        if (byR.wjB == 0) {
            return es;
        }
        str2 = i.es(byR.wjB);
        if (es.equals("")) {
            return str2;
        }
        if (str2.compareTo(es) > 0) {
            return str2;
        }
        return es;
    }

    private ay yf(int i) {
        if (i < 0) {
            return null;
        }
        x.i("MicroMsg.SnsTimeLineVendingSide", "resolveAsynchronous %s", Integer.valueOf(i));
        long currentTimeMillis = System.currentTimeMillis();
        ay ayVar = new ay();
        m mVar = (m) super.getItem(i);
        if (mVar == null) {
            x.printErrStackTrace("MicroMsg.SnsTimeLineVendingSide", new Throwable(), "mSnsInfo is null, index %s, count %s, why?", Integer.valueOf(i), Integer.valueOf(this.mCount));
            return ayVar;
        }
        com.tencent.mm.plugin.sns.storage.b byB;
        int width;
        f Ej;
        String str;
        a Xu;
        a aVar;
        String AX;
        com.tencent.mm.plugin.sns.storage.b byB2;
        boolean z;
        com.tencent.mm.plugin.sns.storage.a byD;
        Iterator it;
        StringBuffer stringBuffer;
        Iterator it2;
        Object obj;
        bku bku;
        a Xu2;
        com.tencent.mm.vending.d.b.a aVar2;
        blb blb;
        a Xu3;
        com.tencent.mm.vending.d.b.a aVar3;
        Iterator it3;
        long j;
        String str2;
        String str3;
        CharSequence charSequence;
        com.tencent.mm.vending.j.a[] aVarArr;
        Long valueOf;
        com.tencent.mm.vending.j.a fVar;
        com.tencent.mm.plugin.sns.storage.a aVar4;
        String AX2;
        arf byS;
        long currentTimeMillis2;
        bpb byF = mVar.byF();
        blf n = ai.n(mVar);
        int d = av.d(byF);
        ayVar.aac = d;
        ayVar.rPN = mVar.field_snsId;
        ayVar.rPR = mVar.field_likeFlag;
        ayVar.rPS = mVar.byW();
        ayVar.rPT = mVar.bzj();
        ayVar.qEj = mVar;
        ayVar.qEn = byF;
        ayVar.qEi = n;
        String str4 = ayVar.qEn.wYg;
        Context context = this.mContext;
        d.bDp();
        CharSequence a = e.a(context, str4, d.getTextSize());
        ayVar.rPK = a;
        int bDr = d.bDp().bDr();
        if (i < this.rPn.getCount()) {
            m mVar2 = (m) super.getItem(i);
            if (mVar2 != null && mVar2.xD(32)) {
                byB = mVar2.byB();
                if (byB != null && byB.rla == 1) {
                    width = (((((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bu.a.fromDPToPix(this.mContext, 50)) - com.tencent.mm.bu.a.fromDPToPix(this.mContext, 50)) - com.tencent.mm.bu.a.fromDPToPix(this.mContext, 12)) - com.tencent.mm.bu.a.fromDPToPix(this.mContext, 12);
                    if (this.DEBUG) {
                        x.d("MicroMsg.SnsTimeLineVendingSide", "debug:renderSnsPostDesc position " + i + " viewWidth: " + width + " desc:" + str4);
                    }
                    Ej = com.tencent.mm.kiss.widget.textview.d.a(a, width, d.bDp().bDo()).Ej();
                    c.gUU.a(d.bDp().bDo(), Ej);
                    if (Ej.gVz.getLineCount() > 6) {
                        c.gUU.a(d.bDp().bDq(), com.tencent.mm.kiss.widget.textview.d.a(a, width, d.bDp().bDq()).Ej());
                    }
                    a(i, ayVar);
                    if (ayVar.qEj.xD(32)) {
                        ae.bwc().a(mVar, null);
                    } else {
                        ae.bwc().b(mVar, null);
                    }
                    f(ayVar.qEn);
                    str = mVar.field_userName;
                    Xu = this.hji.Xu(str);
                    if (str != null) {
                        if (str.equals(this.rOd)) {
                            aVar = Xu;
                        } else if (this.rPp != null) {
                            this.rPp = Xu;
                            aVar = Xu;
                        } else {
                            aVar = this.rPp;
                        }
                        AX = aVar != null ? str : aVar.AX();
                        if (mVar.xD(32) && bi.oN(AX)) {
                            byB2 = mVar.byB();
                            if (!(byB2 == null || bi.oN(byB2.fqG))) {
                                AX = byB2.fqG;
                            }
                        }
                        ayVar.jPV = str;
                        ayVar.rQb = AX;
                        ayVar.rxi = mVar.xD(32);
                        ayVar.ryG = mVar.bza();
                        z = aVar != null ? true : ((int) aVar.gKO) != 0;
                        ayVar.rQc = z;
                        ayVar.rPL = aVar;
                    }
                    ayVar.rPM = mVar.byG();
                    ayVar.rPO = byF.wYg;
                    ayVar.rPP = byF.wYl;
                    ayVar.rPQ = mVar.field_createTime;
                    ayVar.rPU = az.f(this.mContext, ((long) ayVar.rPQ) * 1000);
                    ayVar.rQe = false;
                    if (!(d != 11 || q.FY().equals(byF.kyG) || n.wVf == null || n.wVf.wVH == 0)) {
                        ayVar.rQf = n.wVf.wVH;
                        ayVar.rQe = true;
                    }
                    if (ayVar.rxi) {
                        AX = byF.wYh != null ? null : byF.wYh.hxg;
                        str = byF.wYh != null ? null : byF.wYh.nYL;
                        if (bi.oN(str)) {
                            if (mVar.field_snsId == 0 || bi.oN(AX)) {
                                ayVar.rQh = str;
                            } else {
                                ayVar.rQh = AX + "·" + str;
                            }
                            ayVar.rQi = true;
                        } else {
                            ayVar.rQh = AX;
                            ayVar.rQi = false;
                        }
                    } else {
                        byD = mVar.byD();
                        if (byD != null) {
                            ayVar.rQh = byD.rjX;
                            if (bi.oN(byD.rjY)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            ayVar.rQi = z;
                        }
                    }
                    str4 = f(byF);
                    if (!com.tencent.mm.plugin.sns.c.a.ihO.cz(str4) && g(byF)) {
                        ayVar.rQj = true;
                        boolean z2 = true;
                        if (byF.wYi == null) {
                            z = false;
                        } else {
                            if (!this.rPu.containsKey(byF.wYi.nMq)) {
                                if (!g.cA(byF.wYi.nMq)) {
                                    z = g.Sg(byF.wYi.nMq);
                                    if (!z) {
                                        z2 = false;
                                    }
                                } else if (byF.wYi.vOE == 0) {
                                    z = false;
                                    z2 = false;
                                } else {
                                    z = true;
                                    z2 = true;
                                }
                                this.rPu.put(byF.wYi.nMq, Boolean.valueOf(z));
                            } else if (!((Boolean) this.rPu.get(byF.wYi.nMq)).booleanValue()) {
                                z = false;
                            }
                            z = z2;
                        }
                        ayVar.mAppName = str4;
                        ayVar.rQl = z;
                    } else if (bi.oN(byF.wYk) && g(byF)) {
                        ayVar.mAppName = str4;
                        ayVar.rQk = true;
                        ayVar.rQn = byF.vtB;
                        ayVar.rQm = byF.wYk;
                    } else {
                        ayVar.rQj = false;
                        ayVar.rQk = false;
                    }
                    if (!(byF.reA == null || bi.oN(byF.reA.ttO))) {
                        ayVar.mAppName = h.Oy("discoverRecommendEntry").optString("wording");
                        ayVar.rQj = true;
                    }
                    z = ayVar.jPV == null && ayVar.jPV.equals(this.rOd);
                    ayVar.rQd = z;
                    ayVar.rQp = mVar.bzc();
                    ayVar.rQq = mVar.byS().wFu;
                    ayVar.rQr = false;
                    if (n != null && ayVar.rQd) {
                        width = n.wGH;
                        if (width == 3 || width == 5) {
                            ayVar.rQr = true;
                        }
                    }
                    if (n != null) {
                        if (n.wUX.size() > 0) {
                            if (this.rOd.equals(n.vPp)) {
                                it = n.wUX.iterator();
                                while (it.hasNext()) {
                                    if (this.rOd.equals(((bku) it.next()).vPp)) {
                                        ayVar.rQs = true;
                                        ayVar.rQu = true;
                                        break;
                                    }
                                }
                            }
                            ayVar.rQs = true;
                            stringBuffer = new StringBuffer();
                            it2 = n.wUX.iterator();
                            obj = null;
                            while (it2.hasNext()) {
                                bku = (bku) it2.next();
                                if (obj != null) {
                                    obj = 1;
                                    stringBuffer.append("  ");
                                } else {
                                    stringBuffer.append(",  ");
                                }
                                if (bku.wDh == null) {
                                    stringBuffer.append(bku.wDh);
                                } else {
                                    Xu2 = this.hji.Xu(bku.vPp);
                                    stringBuffer.append(Xu2 != null ? bku.vPp : Xu2.AX());
                                }
                            }
                            ayVar.rQt = stringBuffer.toString();
                        } else {
                            ayVar.rQs = false;
                        }
                        if (n.wVf != null && q.FY().equals(byF.kyG) && n.wVf.wVH > 0) {
                            ayVar.rQx = ((double) com.tencent.mm.plugin.sns.lucky.a.m.b(mVar, n)) * 1.0d;
                            ayVar.rQw = n.wVf.wVH;
                            ayVar.rQv = true;
                            aVar2 = new com.tencent.mm.vending.d.b.a();
                            it2 = n.wVf.wVI.iterator();
                            while (it2.hasNext()) {
                                blb = (blb) it2.next();
                                Xu3 = this.hji.Xu(blb.vPp);
                                if (Xu3 == null) {
                                    obj = bi.oM(Xu3.AX());
                                } else {
                                    obj = bi.oM(blb.vPp);
                                }
                                aVar2.s(com.tencent.mm.vending.j.a.v(blb.vPp, obj));
                            }
                            ayVar.rQy = aVar2.cAG();
                        }
                        if (n.wUR.size() > 0) {
                            aVar2 = new com.tencent.mm.vending.d.b.a();
                            it2 = n.wUR.iterator();
                            while (it2.hasNext()) {
                                bku = (bku) it2.next();
                                Xu3 = this.hji.Xu(bku.vPp);
                                if (Xu3 == null) {
                                    obj = bi.oM(Xu3.AX());
                                } else {
                                    obj = bi.oM(bku.vPp);
                                }
                                aVar2.s(com.tencent.mm.vending.j.a.v(bku.vPp, obj));
                            }
                            ayVar.rQz = aVar2.cAG();
                        }
                        if (n.wUU.size() > 0) {
                            aVar3 = new com.tencent.mm.vending.d.b.a();
                            it3 = n.wUU.iterator();
                            while (it3.hasNext()) {
                                bku = (bku) it3.next();
                                j = bku.wUn == 0 ? (long) bku.wUn : bku.wUq;
                                str2 = bku.vPp;
                                if (bku.vPp.equals(this.rOd)) {
                                    Xu3 = this.hji.Xu(bku.vPp);
                                } else if (this.rPp != null) {
                                    Xu3 = this.hji.Xu(bku.vPp);
                                    this.rPp = Xu3;
                                } else {
                                    Xu3 = this.rPp;
                                }
                                str = Xu3 == null ? Xu3.AX() : bku.wDh == null ? bku.wDh : bku.vPp;
                                str4 = str;
                                str3 = bku.noL;
                                charSequence = (CharSequence) ayVar.rPJ.qWT.get(bku.wUn + "-" + bku.wUq + "-" + bku.noL);
                                aVarArr = new com.tencent.mm.vending.j.a[1];
                                valueOf = Long.valueOf(j);
                                fVar = new com.tencent.mm.vending.j.f();
                                fVar.zMj = new Object[]{valueOf, str2, str4, str3, charSequence};
                                aVarArr[0] = (com.tencent.mm.vending.j.f) fVar;
                                aVar3.s(aVarArr);
                            }
                            ayVar.rQA = aVar3.cAG();
                        }
                    }
                    ag.a(this.mContext, ayVar, byF.rey);
                    if (ayVar.rxi) {
                        ayVar.rPV = mVar.byD();
                        ayVar.rPW = mVar.byB();
                        byB = mVar.byB();
                        ayVar.rPX = byB == null ? byB.rky : "";
                    }
                    if (ayVar.rxi) {
                        aVar4 = ayVar.rPV;
                        if (ayVar.rPV.rjZ != com.tencent.mm.plugin.sns.storage.a.rjL) {
                            ayVar.rPY = aVar4.rka;
                        } else if (aVar4.rjZ == com.tencent.mm.plugin.sns.storage.a.rjM && !bi.oN(aVar4.rka)) {
                            str = "";
                            it2 = aVar4.rkc.iterator();
                            while (it2.hasNext()) {
                                AX = (String) it2.next();
                                Xu2 = ae.bvT().Xu(AX);
                                if (Xu2 == null) {
                                    AX2 = Xu2.AX();
                                    if (bi.oN(AX2)) {
                                        str = str + AX2;
                                    } else {
                                        str = str + AX;
                                    }
                                } else {
                                    str = str + AX;
                                }
                                if (aVar4.rkc.getLast() != AX) {
                                    str = str + ",";
                                }
                            }
                            ayVar.rQa = str;
                            ayVar.rPZ = String.format(aVar4.rka, new Object[]{str});
                        }
                    }
                    byS = mVar.byS();
                    ayVar.rQD = byS;
                    if (!(byS == null || q.FY().equals(byF.kyG) || !com.tencent.mm.plugin.sns.lucky.a.m.a(mVar, n))) {
                        ayVar.rQg = true;
                    }
                    currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    x.d("MicroMsg.SnsTimeLineVendingSide", "SnsTimeLineVendingStruct resolve %s %s ms", Integer.valueOf(i), Long.valueOf(currentTimeMillis2));
                    return ayVar;
                }
            }
        }
        width = bDr;
        if (this.DEBUG) {
            x.d("MicroMsg.SnsTimeLineVendingSide", "debug:renderSnsPostDesc position " + i + " viewWidth: " + width + " desc:" + str4);
        }
        Ej = com.tencent.mm.kiss.widget.textview.d.a(a, width, d.bDp().bDo()).Ej();
        c.gUU.a(d.bDp().bDo(), Ej);
        if (Ej.gVz.getLineCount() > 6) {
            c.gUU.a(d.bDp().bDq(), com.tencent.mm.kiss.widget.textview.d.a(a, width, d.bDp().bDq()).Ej());
        }
        a(i, ayVar);
        if (ayVar.qEj.xD(32)) {
            ae.bwc().a(mVar, null);
        } else {
            ae.bwc().b(mVar, null);
        }
        f(ayVar.qEn);
        str = mVar.field_userName;
        Xu = this.hji.Xu(str);
        if (str != null) {
            if (str.equals(this.rOd)) {
                aVar = Xu;
            } else if (this.rPp != null) {
                aVar = this.rPp;
            } else {
                this.rPp = Xu;
                aVar = Xu;
            }
            if (aVar != null) {
            }
            byB2 = mVar.byB();
            AX = byB2.fqG;
            ayVar.jPV = str;
            ayVar.rQb = AX;
            ayVar.rxi = mVar.xD(32);
            ayVar.ryG = mVar.bza();
            if (aVar != null) {
                if (((int) aVar.gKO) != 0) {
                }
            }
            ayVar.rQc = z;
            ayVar.rPL = aVar;
        }
        ayVar.rPM = mVar.byG();
        ayVar.rPO = byF.wYg;
        ayVar.rPP = byF.wYl;
        ayVar.rPQ = mVar.field_createTime;
        ayVar.rPU = az.f(this.mContext, ((long) ayVar.rPQ) * 1000);
        ayVar.rQe = false;
        ayVar.rQf = n.wVf.wVH;
        ayVar.rQe = true;
        if (ayVar.rxi) {
            if (byF.wYh != null) {
            }
            if (byF.wYh != null) {
            }
            if (bi.oN(str)) {
                ayVar.rQh = AX;
                ayVar.rQi = false;
            } else {
                if (mVar.field_snsId == 0) {
                }
                ayVar.rQh = str;
                ayVar.rQi = true;
            }
        } else {
            byD = mVar.byD();
            if (byD != null) {
                ayVar.rQh = byD.rjX;
                if (bi.oN(byD.rjY)) {
                    z = false;
                } else {
                    z = true;
                }
                ayVar.rQi = z;
            }
        }
        str4 = f(byF);
        if (!com.tencent.mm.plugin.sns.c.a.ihO.cz(str4)) {
        }
        if (bi.oN(byF.wYk)) {
        }
        ayVar.rQj = false;
        ayVar.rQk = false;
        ayVar.mAppName = h.Oy("discoverRecommendEntry").optString("wording");
        ayVar.rQj = true;
        if (ayVar.jPV == null) {
        }
        ayVar.rQd = z;
        ayVar.rQp = mVar.bzc();
        ayVar.rQq = mVar.byS().wFu;
        ayVar.rQr = false;
        width = n.wGH;
        ayVar.rQr = true;
        if (n != null) {
            if (n.wUX.size() > 0) {
                ayVar.rQs = false;
            } else if (this.rOd.equals(n.vPp)) {
                it = n.wUX.iterator();
                while (it.hasNext()) {
                    if (this.rOd.equals(((bku) it.next()).vPp)) {
                        ayVar.rQs = true;
                        ayVar.rQu = true;
                        break;
                    }
                }
            } else {
                ayVar.rQs = true;
                stringBuffer = new StringBuffer();
                it2 = n.wUX.iterator();
                obj = null;
                while (it2.hasNext()) {
                    bku = (bku) it2.next();
                    if (obj != null) {
                        stringBuffer.append(",  ");
                    } else {
                        obj = 1;
                        stringBuffer.append("  ");
                    }
                    if (bku.wDh == null) {
                        Xu2 = this.hji.Xu(bku.vPp);
                        if (Xu2 != null) {
                        }
                        stringBuffer.append(Xu2 != null ? bku.vPp : Xu2.AX());
                    } else {
                        stringBuffer.append(bku.wDh);
                    }
                }
                ayVar.rQt = stringBuffer.toString();
            }
            ayVar.rQx = ((double) com.tencent.mm.plugin.sns.lucky.a.m.b(mVar, n)) * 1.0d;
            ayVar.rQw = n.wVf.wVH;
            ayVar.rQv = true;
            aVar2 = new com.tencent.mm.vending.d.b.a();
            it2 = n.wVf.wVI.iterator();
            while (it2.hasNext()) {
                blb = (blb) it2.next();
                Xu3 = this.hji.Xu(blb.vPp);
                if (Xu3 == null) {
                    obj = bi.oM(blb.vPp);
                } else {
                    obj = bi.oM(Xu3.AX());
                }
                aVar2.s(com.tencent.mm.vending.j.a.v(blb.vPp, obj));
            }
            ayVar.rQy = aVar2.cAG();
            if (n.wUR.size() > 0) {
                aVar2 = new com.tencent.mm.vending.d.b.a();
                it2 = n.wUR.iterator();
                while (it2.hasNext()) {
                    bku = (bku) it2.next();
                    Xu3 = this.hji.Xu(bku.vPp);
                    if (Xu3 == null) {
                        obj = bi.oM(bku.vPp);
                    } else {
                        obj = bi.oM(Xu3.AX());
                    }
                    aVar2.s(com.tencent.mm.vending.j.a.v(bku.vPp, obj));
                }
                ayVar.rQz = aVar2.cAG();
            }
            if (n.wUU.size() > 0) {
                aVar3 = new com.tencent.mm.vending.d.b.a();
                it3 = n.wUU.iterator();
                while (it3.hasNext()) {
                    bku = (bku) it3.next();
                    if (bku.wUn == 0) {
                    }
                    str2 = bku.vPp;
                    if (bku.vPp.equals(this.rOd)) {
                        Xu3 = this.hji.Xu(bku.vPp);
                    } else if (this.rPp != null) {
                        Xu3 = this.rPp;
                    } else {
                        Xu3 = this.hji.Xu(bku.vPp);
                        this.rPp = Xu3;
                    }
                    if (Xu3 == null) {
                        if (bku.wDh == null) {
                        }
                    }
                    str4 = str;
                    str3 = bku.noL;
                    charSequence = (CharSequence) ayVar.rPJ.qWT.get(bku.wUn + "-" + bku.wUq + "-" + bku.noL);
                    aVarArr = new com.tencent.mm.vending.j.a[1];
                    valueOf = Long.valueOf(j);
                    fVar = new com.tencent.mm.vending.j.f();
                    fVar.zMj = new Object[]{valueOf, str2, str4, str3, charSequence};
                    aVarArr[0] = (com.tencent.mm.vending.j.f) fVar;
                    aVar3.s(aVarArr);
                }
                ayVar.rQA = aVar3.cAG();
            }
        }
        ag.a(this.mContext, ayVar, byF.rey);
        if (ayVar.rxi) {
            ayVar.rPV = mVar.byD();
            ayVar.rPW = mVar.byB();
            byB = mVar.byB();
            if (byB == null) {
            }
            ayVar.rPX = byB == null ? byB.rky : "";
        }
        if (ayVar.rxi) {
            aVar4 = ayVar.rPV;
            if (ayVar.rPV.rjZ != com.tencent.mm.plugin.sns.storage.a.rjL) {
                str = "";
                it2 = aVar4.rkc.iterator();
                while (it2.hasNext()) {
                    AX = (String) it2.next();
                    Xu2 = ae.bvT().Xu(AX);
                    if (Xu2 == null) {
                        str = str + AX;
                    } else {
                        AX2 = Xu2.AX();
                        if (bi.oN(AX2)) {
                            str = str + AX;
                        } else {
                            str = str + AX2;
                        }
                    }
                    if (aVar4.rkc.getLast() != AX) {
                        str = str + ",";
                    }
                }
                ayVar.rQa = str;
                ayVar.rPZ = String.format(aVar4.rka, new Object[]{str});
            } else {
                ayVar.rPY = aVar4.rka;
            }
        }
        byS = mVar.byS();
        ayVar.rQD = byS;
        ayVar.rQg = true;
        currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        x.d("MicroMsg.SnsTimeLineVendingSide", "SnsTimeLineVendingStruct resolve %s %s ms", Integer.valueOf(i), Long.valueOf(currentTimeMillis2));
        return ayVar;
    }

    private String f(bpb bpb) {
        if (bpb.wYj.wfg == 26) {
            return this.mContext.getString(j.eeR);
        }
        if (bpb.wYi == null) {
            return "";
        }
        if (bi.oN(bpb.wYi.nMq)) {
            return "";
        }
        if (this.rPt.containsKey(bpb.wYi.nMq)) {
            return (String) this.rPt.get(bpb.wYi.nMq);
        }
        String a = g.a(this.mContext, g.cT(bpb.wYi.nMq, bi.getInt(bpb.wYi.kzm, 0)), null);
        if (bi.oN(a)) {
            return a;
        }
        this.rPt.put(bpb.wYi.nMq, a);
        return a;
    }

    private static boolean g(bpb bpb) {
        if (!bi.oN(bpb.wYk) && (al.a.bwF() & 2) > 0) {
            return false;
        }
        return true;
    }

    private void a(int i, ay ayVar) {
        List<bku> list = ayVar.qEi.wUU;
        com.tencent.mm.kiss.widget.textview.a.a bDo = com.tencent.mm.plugin.sns.ui.widget.b.bDn().bDo();
        ayVar.rPJ = new com.tencent.mm.plugin.sns.data.d();
        if (this.DEBUG) {
            x.d("MicroMsg.SnsTimeLineVendingSide", "debug:renderSnsComment position " + i + " commentInfoList: " + list.size() + " commentData:" + ayVar.rPJ.qWT.size());
        }
        for (bku bku : list) {
            String str;
            Object obj;
            int obj2;
            com.tencent.mm.plugin.sns.ui.widget.b bDn;
            DisplayMetrics displayMetrics;
            int dimension;
            int dimension2;
            int dimension3;
            c cVar = c.gUU;
            Context context = this.mContext;
            String str2 = ayVar.qEj.field_userName;
            String str3 = "";
            String a = com.tencent.mm.plugin.sns.ui.widget.c.a(bku);
            String str4 = bku.noL;
            com.tencent.mm.storage.x xVar = null;
            if (!bi.oN(str2)) {
                com.tencent.mm.kernel.g.Dr();
                xVar = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xt(str2);
            }
            if (bku.wUs == 1) {
                if (xVar != null) {
                    str = (a + context.getString(j.qQl)) + (xVar == null ? str2 : xVar.AX());
                }
                str = a;
            } else {
                if (!bi.oN(bku.wUH)) {
                    a Xu = ae.bvT().Xu(bku.wUH);
                    str = (a + context.getString(j.qSc)) + (Xu == null ? bku.wUH : Xu.AX());
                }
                str = a;
            }
            CharSequence charSequence = (str3 + str + ": ") + str4;
            if (bDo != null) {
                com.tencent.mm.kiss.widget.textview.b bVar = (com.tencent.mm.kiss.widget.textview.b) cVar.gUV.get(Integer.valueOf(c.a(bDo)));
                if (bVar != null) {
                    LinkedList linkedList = (LinkedList) bVar.gUT.get(charSequence.toString());
                    if (linkedList == null || linkedList.size() == 0) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 == null) {
                        ayVar.rPJ.a(bku, com.tencent.mm.plugin.sns.ui.widget.c.a(this.mContext, bku, this.rPn, ayVar.qEj.field_type, ayVar.qEj.field_userName));
                    } else {
                        charSequence = com.tencent.mm.plugin.sns.ui.widget.c.a(this.mContext, bku, this.rPn, ayVar.qEj.field_type, ayVar.qEj.field_userName);
                        ayVar.rPJ.a(bku, charSequence);
                        bDn = com.tencent.mm.plugin.sns.ui.widget.b.bDn();
                        if (bDn.rXM <= 0) {
                            displayMetrics = new DisplayMetrics();
                            ((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                            obj2 = displayMetrics.widthPixels;
                            dimension = (int) (ad.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.bvK) + ad.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.bvK));
                            dimension2 = (int) ad.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.qEP);
                            dimension3 = (int) ad.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.bvK);
                            bDn.rXM = ((obj2 - dimension2) - dimension) - dimension3;
                            x.i("MicroMsg.SnsCommentPreloadTextViewConfig", "screenWidth " + obj2 + " textViewWidth " + bDn.rXM + " padding: " + dimension + " marginLeft: " + dimension2 + " thisviewPadding: " + dimension3);
                        }
                        obj2 = bDn.rXM;
                        if (obj2 > 0) {
                            c.gUU.a(bDo, com.tencent.mm.kiss.widget.textview.d.a(charSequence, obj2, bDo).Ej());
                        }
                    }
                }
            }
            obj2 = null;
            if (obj2 == null) {
                charSequence = com.tencent.mm.plugin.sns.ui.widget.c.a(this.mContext, bku, this.rPn, ayVar.qEj.field_type, ayVar.qEj.field_userName);
                ayVar.rPJ.a(bku, charSequence);
                bDn = com.tencent.mm.plugin.sns.ui.widget.b.bDn();
                if (bDn.rXM <= 0) {
                    displayMetrics = new DisplayMetrics();
                    ((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                    obj2 = displayMetrics.widthPixels;
                    dimension = (int) (ad.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.bvK) + ad.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.bvK));
                    dimension2 = (int) ad.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.qEP);
                    dimension3 = (int) ad.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.bvK);
                    bDn.rXM = ((obj2 - dimension2) - dimension) - dimension3;
                    x.i("MicroMsg.SnsCommentPreloadTextViewConfig", "screenWidth " + obj2 + " textViewWidth " + bDn.rXM + " padding: " + dimension + " marginLeft: " + dimension2 + " thisviewPadding: " + dimension3);
                }
                obj2 = bDn.rXM;
                if (obj2 > 0) {
                    c.gUU.a(bDo, com.tencent.mm.kiss.widget.textview.d.a(charSequence, obj2, bDo).Ej());
                }
            } else {
                ayVar.rPJ.a(bku, com.tencent.mm.plugin.sns.ui.widget.c.a(this.mContext, bku, this.rPn, ayVar.qEj.field_type, ayVar.qEj.field_userName));
            }
        }
    }

    protected final Cursor bCE() {
        if (!this.rPq) {
            synchronized (this.rPs) {
                this.mgB = q(0, this.mgB);
            }
            this.rPq = true;
        }
        int Me = ae.bwf().Me(this.mgB);
        x.i("MicroMsg.SnsTimeLineVendingSide", "create time sql %s to %s getLimitSeq() %s", Integer.valueOf(this.rPo), Integer.valueOf(Me), this.mgB);
        if (this.rPo != Me) {
            com.tencent.mm.plugin.sns.storage.f bwi = ae.bwi();
            String str = ("select *,rowid from AdSnsInfo  where createTime > " + Me + " and createTime <= " + this.rPo) + " order by  createTime desc";
            x.d("MicroMsg.AdSnsInfoStorage", "getAdInTime " + str);
            Cursor rawQuery = bwi.gLA.rawQuery(str, null);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                LinkedList linkedList = new LinkedList();
                do {
                    int i;
                    com.tencent.mm.plugin.sns.storage.e eVar = new com.tencent.mm.plugin.sns.storage.e();
                    eVar.b(rawQuery);
                    m byH = eVar.byH();
                    StringBuilder stringBuilder = new StringBuilder("ad xml ");
                    com.tencent.mm.plugin.sns.storage.e bzl = byH.bzl();
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(byH.field_stringSeq);
                    stringBuffer.append(bzl.field_adxml);
                    stringBuffer.append(" <createtime " + byH.field_createTime + ">");
                    stringBuffer.append(" <exposuretime " + bzl.field_exposureTime + ">");
                    stringBuffer.append(" <adcreatetime " + bzl.field_createAdTime + "> ");
                    stringBuffer.append(bzl.byF().wYg);
                    x.d("MicroMsg.SnsTimeLineVendingSide", stringBuilder.append(stringBuffer.toString()).toString());
                    long j = 21600;
                    com.tencent.mm.plugin.sns.storage.a byD = byH.byD();
                    int i2 = byH.field_createTime;
                    boolean z = (eVar.field_localFlag & FileUtils.S_IWUSR) > 0;
                    if (byD == null) {
                        i = i2;
                    } else if (z) {
                        j = 60 * byD.rjP;
                        i = eVar.field_exposureTime;
                    } else {
                        j = 60 * byD.rjO;
                        i = eVar.field_createAdTime;
                    }
                    long bz = bi.bz((long) i);
                    if (bz >= j) {
                        Object obj;
                        blf n = ai.n(byH);
                        if (byH.field_likeFlag == 0) {
                            Iterator it = n.wUU.iterator();
                            while (it.hasNext()) {
                                bku bku = (bku) it.next();
                                if (bku == null || bi.oN(bku.vPp) || !bku.vPp.equals(this.rOd)) {
                                }
                            }
                            obj = null;
                            if (obj == null) {
                                ae.bwi().delete(byH.field_snsId);
                                x.i("MicroMsg.SnsTimeLineVendingSide", "~~addelete the item " + byH.field_snsId + " exposureTime: " + j + " field_createTime: " + byH.field_createTime + " checktime: " + bz + " gettime: " + i + " isexposure " + z + " exposureTime " + eVar.field_exposureTime + " adCreateTIme:" + eVar.field_createAdTime);
                                if (!z) {
                                    linkedList.add(eVar);
                                }
                            }
                        }
                        obj = 1;
                        if (obj == null) {
                            ae.bwi().delete(byH.field_snsId);
                            x.i("MicroMsg.SnsTimeLineVendingSide", "~~addelete the item " + byH.field_snsId + " exposureTime: " + j + " field_createTime: " + byH.field_createTime + " checktime: " + bz + " gettime: " + i + " isexposure " + z + " exposureTime " + eVar.field_exposureTime + " adCreateTIme:" + eVar.field_createAdTime);
                            if (z) {
                                linkedList.add(eVar);
                            }
                        }
                    }
                    long j2 = byH.field_snsId;
                    x.i("MicroMsg.SnsTimeLineVendingSide", "try to update snsid " + j2);
                    if (l.ew(j2)) {
                        k lVar = new l(j2, 1, byH.byD().rko);
                        com.tencent.mm.kernel.g.Dr();
                        com.tencent.mm.kernel.g.Dp().gRu.a(lVar, 0);
                    }
                } while (rawQuery.moveToNext());
                if (linkedList.size() > 0) {
                    LinkedList linkedList2 = new LinkedList();
                    Iterator it2 = linkedList.iterator();
                    while (it2.hasNext()) {
                        com.tencent.mm.plugin.sns.storage.e eVar2 = (com.tencent.mm.plugin.sns.storage.e) it2.next();
                        com.tencent.mm.protocal.c.bi biVar = new com.tencent.mm.protocal.c.bi();
                        biVar.vNn = 13298;
                        biVar.vNo = new com.tencent.mm.bp.b(eVar2.byD().rfQ.getBytes());
                        biVar.vNp = System.currentTimeMillis() / 1000;
                        linkedList2.add(biVar);
                    }
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dp().gRu.a(new com.tencent.mm.plugin.sns.model.k(linkedList2), 0);
                }
            }
            if (rawQuery != null) {
                x.d("MicroMsg.SnsTimeLineVendingSide", "test for adcount " + rawQuery.getCount());
                rawQuery.close();
            }
        }
        this.rPo = Me;
        Cursor cj = ae.bwf().cj(this.mgB, Me);
        x.d("MicroMsg.SnsTimeLineVendingSide", "onCursorResetFinish");
        com.tencent.mm.modelsns.b ix = com.tencent.mm.modelsns.b.ix(500);
        if (ix.SA()) {
            int i3 = this.mCount;
            if (i3 == 0) {
                ix.iA(0).iA(0).iA(0);
                ix.SE();
            } else {
                int i4 = i3 - 1;
                String g = i.g((m) getItem(1));
                String g2 = i.g((m) getItem(i4));
                if (!(g.equals(this.rPv) && g2.equals(this.rPw))) {
                    this.rPv = g;
                    this.rPw = g2;
                    ix.iA(i3).mF(g).mF(g2);
                    ix.SE();
                }
            }
        }
        return cj;
    }

    public final void destroyAsynchronous() {
        super.destroyAsynchronous();
        c.gUU.Ei();
        this.rPu.clear();
    }
}
