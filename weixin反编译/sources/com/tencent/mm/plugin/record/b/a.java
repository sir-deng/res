package com.tencent.mm.plugin.record.b;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.protocal.c.bps;
import com.tencent.mm.protocal.c.gm;
import com.tencent.mm.protocal.c.gn;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public final class a extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE = null;
    private int mwi = 0;
    private int mwm = 0;
    String pKF = "";
    g pKG = null;
    private SparseArray<uz> pKH = new SparseArray();
    private SparseBooleanArray pKI = new SparseBooleanArray();

    public a(g gVar) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new gm();
        aVar.hnU = new gn();
        aVar.uri = "/cgi-bin/micromsg-bin/batchtranscdnitem";
        aVar.hnS = 632;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.pKG = gVar;
    }

    private void bnu() {
        this.pKF = com.tencent.mm.x.g.a.a(h.a(this.pKG.field_title, this.pKG.field_desc, this.pKG.field_dataProto), null, null);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneTransCDN", "netId %d errType %d errCode %d localErrCode %d begIndex %d errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.mwm), Integer.valueOf(this.mwi), str);
        if (i2 == 3 && this.mwm == -100) {
            bnu();
            this.gLE.a(0, 0, str, this);
        } else if (i2 == 0 && i3 == 0) {
            Object obj;
            Iterator it = ((gn) ((b) qVar).hnR.hnY).kyB.iterator();
            while (it.hasNext()) {
                bps bps = (bps) it.next();
                uz uzVar = (uz) this.pKH.get(bps.wYH);
                if (uzVar != null) {
                    if (this.pKI.get(bps.wYH)) {
                        x.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[true], old thumb url[%s], new thumb url[%s], old size[%d], new size[%d]", Integer.valueOf(bps.wYH), uzVar.mBr, uzVar.hcU, bps.vXI, Long.valueOf(uzVar.wkt), Long.valueOf(bps.wYJ));
                        uzVar.TX(bps.vXI);
                        uzVar.TY(bps.wgS);
                        if (bi.oN(bps.vXI) || bi.oN(bps.wgS) || bps.wYJ <= 0) {
                            x.w("MicroMsg.NetSceneTransCDN", "match error server return");
                            i2 = 3;
                        } else {
                            uzVar.fy(bps.wYJ);
                        }
                    } else {
                        x.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[false], old url[%s], new url[%s], old size[%d], new size[%d]", Integer.valueOf(bps.wYH), uzVar.mBr, uzVar.wjN, bps.vXI, Long.valueOf(uzVar.wki), Long.valueOf(bps.wYJ));
                        uzVar.TZ(bps.vXI);
                        uzVar.Ua(bps.wgS);
                        if (bi.oN(bps.vXI) || bi.oN(bps.wgS) || bps.wYJ <= 0) {
                            x.w("MicroMsg.NetSceneTransCDN", "match error server return");
                            i2 = 3;
                        } else {
                            uzVar.fx(bps.wYJ);
                        }
                    }
                }
            }
            x.i("MicroMsg.NetSceneTransCDN", "check need continue, indexOK %B", Boolean.valueOf(this.mwi < this.pKG.field_dataProto.wlY.size()));
            if (this.mwi < this.pKG.field_dataProto.wlY.size()) {
                obj = a(this.hok, this.gLE) == -100 ? 1 : null;
            } else {
                int obj2 = 1;
            }
            if (obj2 != null) {
                x.i("MicroMsg.NetSceneTransCDN", "do callback");
                bnu();
                this.gLE.a(i2, i3, str, this);
            }
        } else {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 632;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.tencent.mm.network.e r13, com.tencent.mm.ad.e r14) {
        /*
        r12 = this;
        r12.gLE = r14;
        r0 = r12.gLB;
        r0 = r0.hnQ;
        r0 = r0.hnY;
        r0 = (com.tencent.mm.protocal.c.gm) r0;
        r1 = r12.pKH;
        r1.clear();
        r1 = r12.pKI;
        r1.clear();
        r1 = r12.pKG;
        r1 = r1.field_dataProto;
        r1 = r1.wlY;
        r1 = r1.size();
        if (r1 != 0) goto L_0x0030;
    L_0x0020:
        r0 = "MicroMsg.NetSceneTransCDN";
        r1 = "doScene data list null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = -100;
        r12.mwm = r0;
        r0 = -100;
    L_0x002f:
        return r0;
    L_0x0030:
        r3 = 1;
        r4 = new java.util.LinkedList;
        r4.<init>();
        r1 = r12.mwi;
        r2 = r1;
    L_0x0039:
        r1 = r12.pKG;
        r1 = r1.field_dataProto;
        r1 = r1.wlY;
        r1 = r1.size();
        if (r2 >= r1) goto L_0x01ee;
    L_0x0045:
        r1 = r12.pKG;
        r1 = r1.field_dataProto;
        r1 = r1.wlY;
        r1 = r1.get(r2);
        r1 = (com.tencent.mm.protocal.c.uz) r1;
        r5 = r12.pKG;
        r5 = r5.field_type;
        r6 = 14;
        if (r5 != r6) goto L_0x0083;
    L_0x0059:
        r5 = r1.bjS;
        r6 = 3;
        if (r5 != r6) goto L_0x0083;
    L_0x005e:
        r5 = "MicroMsg.NetSceneTransCDN";
        r6 = "match voice type, clear cdn info";
        com.tencent.mm.sdk.platformtools.x.w(r5, r6);
        r5 = "";
        r1.Ua(r5);
        r5 = "";
        r1.TZ(r5);
        r5 = "";
        r1.TY(r5);
        r5 = "";
        r1.TX(r5);
    L_0x007f:
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x0039;
    L_0x0083:
        r5 = r1.wkf;
        if (r5 == 0) goto L_0x00f1;
    L_0x0087:
        r5 = r1.wjN;
        r5 = com.tencent.mm.sdk.platformtools.bi.oN(r5);
        if (r5 == 0) goto L_0x00f1;
    L_0x008f:
        r1 = 0;
    L_0x0090:
        r2 = r2 + 1;
        r12.mwi = r2;
        r2 = r4.size();
        r0.kyA = r2;
        r2 = r0.kyB;
        r2.clear();
        r2 = r0.kyB;
        r2.addAll(r4);
        r2 = "MicroMsg.NetSceneTransCDN";
        r3 = "ashutest::data list size %d, need check size %d, nextIndex %d";
        r4 = 3;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = r12.pKG;
        r6 = r6.field_dataProto;
        r6 = r6.wlY;
        r6 = r6.size();
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 1;
        r6 = r12.pKH;
        r6 = r6.size();
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 2;
        r6 = r12.mwi;
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r0 = r0.kyA;
        if (r0 <= 0) goto L_0x00dd;
    L_0x00db:
        if (r1 != 0) goto L_0x01f1;
    L_0x00dd:
        r12.bnu();
        r0 = "MicroMsg.NetSceneTransCDN";
        r1 = "doScene no more data";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        r0 = -100;
        r12.mwm = r0;
        r0 = -100;
        goto L_0x002f;
    L_0x00f1:
        r5 = r1.wjN;
        r5 = com.tencent.mm.sdk.platformtools.bi.oN(r5);
        if (r5 != 0) goto L_0x0162;
    L_0x00f9:
        r5 = new com.tencent.mm.protocal.c.bps;
        r5.<init>();
        r6 = r1.wjN;
        r5.vXI = r6;
        r6 = r1.wjP;
        r5.wgS = r6;
        r6 = r1.bjS;
        r5.wYI = r6;
        r6 = r1.wki;
        r6 = (int) r6;
        r6 = (long) r6;
        r5.wYJ = r6;
        r6 = r1.mBr;
        r7 = "";
        r6 = com.tencent.mm.sdk.platformtools.bi.aD(r6, r7);
        r6 = r6.hashCode();
        r5.wYH = r6;
        r6 = "MicroMsg.NetSceneTransCDN";
        r7 = "add cdnitem, clientID[%d] dataID[%s] datatype[%d] dataurl[%s] size[%d]";
        r8 = 5;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = r5.wYH;
        r10 = java.lang.Integer.valueOf(r10);
        r8[r9] = r10;
        r9 = 1;
        r10 = r1.mBr;
        r8[r9] = r10;
        r9 = 2;
        r10 = r5.wYI;
        r10 = java.lang.Integer.valueOf(r10);
        r8[r9] = r10;
        r9 = 3;
        r10 = r1.wjN;
        r8[r9] = r10;
        r9 = 4;
        r10 = r1.wki;
        r10 = java.lang.Long.valueOf(r10);
        r8[r9] = r10;
        com.tencent.mm.sdk.platformtools.x.d(r6, r7, r8);
        r4.add(r5);
        r6 = r12.pKH;
        r7 = r5.wYH;
        r6.put(r7, r1);
        r6 = r12.pKI;
        r5 = r5.wYH;
        r7 = 0;
        r6.put(r5, r7);
    L_0x0162:
        r5 = r1.hcU;
        r5 = com.tencent.mm.sdk.platformtools.bi.oN(r5);
        if (r5 != 0) goto L_0x01e6;
    L_0x016a:
        r5 = new com.tencent.mm.protocal.c.bps;
        r5.<init>();
        r6 = r1.hcU;
        r5.vXI = r6;
        r6 = r1.wjJ;
        r5.wgS = r6;
        r6 = 2;
        r5.wYI = r6;
        r6 = r1.wkt;
        r6 = (int) r6;
        r6 = (long) r6;
        r5.wYJ = r6;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = r1.mBr;
        r8 = "";
        r7 = com.tencent.mm.sdk.platformtools.bi.aD(r7, r8);
        r6 = r6.append(r7);
        r7 = "@thumb";
        r6 = r6.append(r7);
        r6 = r6.toString();
        r6 = r6.hashCode();
        r5.wYH = r6;
        r6 = "MicroMsg.NetSceneTransCDN";
        r7 = "add cdnitem, clientID[%d] thumbID[%s_t] datatype[%d] thumburl[%s] size[%d]";
        r8 = 5;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = r5.wYH;
        r10 = java.lang.Integer.valueOf(r10);
        r8[r9] = r10;
        r9 = 1;
        r10 = r1.mBr;
        r8[r9] = r10;
        r9 = 2;
        r10 = r5.wYI;
        r10 = java.lang.Integer.valueOf(r10);
        r8[r9] = r10;
        r9 = 3;
        r10 = r1.hcU;
        r8[r9] = r10;
        r9 = 4;
        r10 = r1.wkt;
        r10 = java.lang.Long.valueOf(r10);
        r8[r9] = r10;
        com.tencent.mm.sdk.platformtools.x.d(r6, r7, r8);
        r4.add(r5);
        r6 = r12.pKH;
        r7 = r5.wYH;
        r6.put(r7, r1);
        r1 = r12.pKI;
        r5 = r5.wYH;
        r6 = 1;
        r1.put(r5, r6);
    L_0x01e6:
        r1 = r4.size();
        r5 = 20;
        if (r1 < r5) goto L_0x007f;
    L_0x01ee:
        r1 = r3;
        goto L_0x0090;
    L_0x01f1:
        r0 = r12.gLB;
        r0 = r12.a(r13, r0, r12);
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.record.b.a.a(com.tencent.mm.network.e, com.tencent.mm.ad.e):int");
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    protected final int Bo() {
        return 10;
    }
}
