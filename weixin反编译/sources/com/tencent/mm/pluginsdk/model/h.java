package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.af.a.e;
import com.tencent.mm.af.f;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.j.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.va;
import com.tencent.mm.protocal.c.vb;
import com.tencent.mm.protocal.c.vc;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.protocal.c.wb;
import com.tencent.mm.protocal.c.wc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.x.i;
import com.tencent.mm.x.l;
import com.tencent.mm.x.m;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.q;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class h {
    private static final SimpleDateFormat pOG = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static boolean a(Context context, cg cgVar, String str, List<au> list, boolean z, boolean z2) {
        if (list == null || list.isEmpty() || context == null) {
            x.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msgs is null");
            cgVar.frk.frq = R.l.efu;
            return false;
        }
        boolean eG = f.eG(str);
        au auVar;
        if (list.size() != 1 || z2) {
            cgVar.frk.frm = new vn();
            cgVar.frk.frn = new wb();
            if (context != null) {
                if (eG) {
                    if (e.kq(e.bb(((au) list.get(0)).field_bizChatId))) {
                        cgVar.frk.frm.UL(context.getString(R.l.eCN));
                    } else {
                        if (e.kt(str) != null) {
                            cgVar.frk.frm.UL(context.getString(R.l.egv, new Object[]{r1.field_userName, e.kr(r0)}));
                        }
                    }
                } else if (s.eX(str)) {
                    cgVar.frk.frm.UL(context.getString(R.l.eCN));
                } else {
                    if (q.Ga().equals(r.gv(str))) {
                        cgVar.frk.frm.UL(context.getString(R.l.egw, new Object[]{r0}));
                    } else {
                        cgVar.frk.frm.UL(context.getString(R.l.egv, new Object[]{q.Ga(), r.gv(str)}));
                    }
                }
                x.d("MicroMsg.GetFavRecordDataSource", "title %s", cgVar.frk.frm.title);
            }
            cgVar.frk.frm.a(RY(str));
            cgVar.frk.type = 14;
            int i = 0;
            boolean z3 = true;
            for (au auVar2 : list) {
                if (a(context, cgVar, auVar2, z)) {
                    i = 1;
                } else {
                    z3 = false;
                }
            }
            if (i == 0 || cgVar.frk.frq <= 0) {
                return z3;
            }
            cgVar.frk.frq = 0;
            return z3;
        }
        auVar2 = (au) list.get(0);
        if (!auVar2.cjK()) {
            return f.a(cgVar, auVar2);
        }
        l wr = ((a) g.h(a.class)).wr(auVar2.field_content);
        if (wr.hfI != null && wr.hfI.size() == 1) {
            return f.a(cgVar, auVar2);
        }
        cgVar.frk.frm = new vn();
        cgVar.frk.frn = new wb();
        cgVar.frk.frm.a(RY(str));
        cgVar.frk.type = 14;
        return a(context, cgVar, auVar2, z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(android.content.Context r12, com.tencent.mm.f.a.cg r13, com.tencent.mm.storage.au r14, boolean r15) {
        /*
        r10 = 0;
        r6 = 3;
        r9 = 2;
        r1 = 0;
        r2 = 1;
        if (r13 == 0) goto L_0x000a;
    L_0x0008:
        if (r14 != 0) goto L_0x001c;
    L_0x000a:
        r0 = "MicroMsg.GetFavRecordDataSource";
        r2 = "fill favorite event fail, event or msg is null";
        com.tencent.mm.sdk.platformtools.x.w(r0, r2);
        if (r13 == 0) goto L_0x001b;
    L_0x0015:
        r0 = r13.frk;
        r2 = com.tencent.mm.R.l.efu;
        r0.frq = r2;
    L_0x001b:
        return r1;
    L_0x001c:
        r4 = com.tencent.mm.storage.au.ae(r14);
        r0 = r4.cjV();
        if (r0 == 0) goto L_0x00a1;
    L_0x0026:
        r0 = new com.tencent.mm.protocal.c.va;
        r0.<init>();
        r1 = Y(r4);
        r0.c(r1);
        r1 = new com.tencent.mm.protocal.c.uz;
        r1.<init>();
        r3 = Z(r4);
        r1.Un(r3);
        r1.Dc(r2);
        r3 = r4.ckl();
        if (r3 != 0) goto L_0x0081;
    L_0x0047:
        r3 = r4.field_content;
        r1.TW(r3);
    L_0x004c:
        r1.lA(r2);
        r1.lz(r2);
        r1.a(r0);
        r3 = r0.wlb;
        r3 = a(r3);
        r1.Uq(r3);
        r0 = r0.wlb;
        r0 = b(r0);
        r1.Ur(r0);
        r0 = r13.frk;
        r0 = r0.frm;
        r0 = r0.wlY;
        r0.add(r1);
        r0 = r13.frk;
        r0 = r0.frn;
        r1 = r0.wmo;
        r1 = r1 + 1;
        r0.wmo = r1;
        r1 = r2;
    L_0x007b:
        if (r15 != 0) goto L_0x001b;
    L_0x007d:
        com.tencent.mm.pluginsdk.model.c.a(r4, r13, r1);
        goto L_0x001b;
    L_0x0081:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r5 = r4.field_content;
        r3 = r3.append(r5);
        r5 = "\n\n";
        r3 = r3.append(r5);
        r5 = r4.field_transContent;
        r3 = r3.append(r5);
        r3 = r3.toString();
        r1.TW(r3);
        goto L_0x004c;
    L_0x00a1:
        r0 = r4.cjL();
        if (r0 == 0) goto L_0x0154;
    L_0x00a7:
        r3 = new com.tencent.mm.protocal.c.va;
        r3.<init>();
        r0 = Y(r4);
        r3.c(r0);
        r5 = new com.tencent.mm.protocal.c.uz;
        r5.<init>();
        r0 = Z(r4);
        r5.Un(r0);
        r5.Dc(r6);
        if (r15 == 0) goto L_0x00f5;
    L_0x00c4:
        r5.lA(r2);
        r5.lz(r2);
    L_0x00ca:
        r5.a(r3);
        r0 = r3.wlb;
        r0 = a(r0);
        r5.Uq(r0);
        r0 = r3.wlb;
        r0 = b(r0);
        r5.Ur(r0);
        r0 = r13.frk;
        r0 = r0.frm;
        r0 = r0.wlY;
        r0.add(r5);
        r0 = r13.frk;
        r0 = r0.frn;
        r1 = r0.wmq;
        r1 = r1 + 1;
        r0.wmq = r1;
        r0 = r2;
    L_0x00f3:
        r1 = r0;
        goto L_0x007b;
    L_0x00f5:
        r0 = r4.field_talker;
        r0 = com.tencent.mm.y.s.hd(r0);
        if (r0 == 0) goto L_0x0130;
    L_0x00fd:
        r0 = r4.field_imgPath;
        com.tencent.mm.y.as.Hm();
        r6 = com.tencent.mm.y.c.Fu();
        r7 = "recbiz_";
        r8 = ".rec";
        r0 = com.tencent.mm.sdk.platformtools.i.a(r6, r7, r0, r8, r9);
        r6 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r6 == 0) goto L_0x0127;
    L_0x0116:
        r0 = 0;
    L_0x0117:
        r5.Uj(r0);
    L_0x011a:
        r5.lA(r2);
        r0 = r4.field_imgPath;
        r0 = com.tencent.mm.modelvoice.q.nX(r0);
        if (r0 != 0) goto L_0x013a;
    L_0x0125:
        r0 = r1;
        goto L_0x00f3;
    L_0x0127:
        r6 = new java.io.File;
        r6.<init>(r0);
        r6.exists();
        goto L_0x0117;
    L_0x0130:
        r0 = r4.field_imgPath;
        r0 = com.tencent.mm.modelvoice.q.getFullPath(r0);
        r5.Uj(r0);
        goto L_0x011a;
    L_0x013a:
        r0 = r0.getFormat();
        r0 = com.tencent.mm.pluginsdk.model.f.BS(r0);
        r5.Uf(r0);
        r0 = new com.tencent.mm.modelvoice.n;
        r1 = r4.field_content;
        r0.<init>(r1);
        r0 = r0.time;
        r0 = (int) r0;
        r5.Db(r0);
        goto L_0x00ca;
    L_0x0154:
        r0 = r4.aNL();
        if (r0 == 0) goto L_0x0160;
    L_0x015a:
        r1 = b(r13, r4);
        goto L_0x007b;
    L_0x0160:
        r0 = r4.cjT();
        if (r0 == 0) goto L_0x02d9;
    L_0x0166:
        r0 = 0;
        r6 = r4.field_msgId;
        r3 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r3 <= 0) goto L_0x0179;
    L_0x016d:
        r0 = com.tencent.mm.ap.o.PC();
        r6 = r4.field_msgId;
        r3 = (int) r6;
        r6 = (long) r3;
        r0 = r0.bj(r6);
    L_0x0179:
        if (r0 == 0) goto L_0x0181;
    L_0x017b:
        r6 = r0.hBA;
        r3 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r3 > 0) goto L_0x0191;
    L_0x0181:
        r6 = r4.field_msgSvrId;
        r3 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r3 <= 0) goto L_0x0191;
    L_0x0187:
        r0 = com.tencent.mm.ap.o.PC();
        r6 = r4.field_msgSvrId;
        r0 = r0.bi(r6);
    L_0x0191:
        if (r0 != 0) goto L_0x01a4;
    L_0x0193:
        r0 = "MicroMsg.GetFavRecordDataSource";
        r2 = "getImgDataPath: try get imgInfo fail";
        com.tencent.mm.sdk.platformtools.x.w(r0, r2);
        r0 = r13.frk;
        r2 = com.tencent.mm.R.l.efA;
        r0.frq = r2;
        goto L_0x007b;
    L_0x01a4:
        r3 = new com.tencent.mm.protocal.c.va;
        r3.<init>();
        r5 = Y(r4);
        r3.c(r5);
        r5 = new com.tencent.mm.protocal.c.uz;
        r5.<init>();
        r6 = Z(r4);
        r5.Un(r6);
        r5.Dc(r9);
        r6 = com.tencent.mm.ap.o.PC();
        r7 = com.tencent.mm.ap.f.c(r0);
        r8 = "";
        r9 = "";
        r6 = r6.m(r7, r8, r9);
        r5.Uj(r6);
        r6 = r0.Pk();
        if (r6 == 0) goto L_0x020d;
    L_0x01da:
        r6 = com.tencent.mm.ap.o.PC();
        r7 = r0.hBK;
        r6 = r6.hT(r7);
        r7 = r6.hmZ;
        r6 = r6.offset;
        if (r7 <= r6) goto L_0x020d;
    L_0x01ea:
        r6 = com.tencent.mm.ap.o.PC();
        r7 = new java.lang.StringBuilder;
        r8 = "SERVERID://";
        r7.<init>(r8);
        r8 = r4.field_msgSvrId;
        r7 = r7.append(r8);
        r7 = r7.toString();
        r8 = "";
        r9 = "";
        r6 = r6.m(r7, r8, r9);
        r5.Uj(r6);
    L_0x020d:
        r6 = com.tencent.mm.ap.o.PC();
        r7 = r4.field_imgPath;
        r6 = r6.B(r7, r2);
        r5.Uk(r6);
        r5.a(r3);
        r6 = r3.wlb;
        r6 = a(r6);
        r5.Uq(r6);
        r3 = r3.wlb;
        r3 = b(r3);
        r5.Ur(r3);
        r6 = r4.field_msgId;
        r5.fz(r6);
        if (r15 == 0) goto L_0x028b;
    L_0x0236:
        r3 = r0.Pk();
        if (r3 == 0) goto L_0x024a;
    L_0x023c:
        r3 = r0.hmZ;
        if (r3 != 0) goto L_0x024a;
    L_0x0240:
        r3 = com.tencent.mm.ap.o.PC();
        r0 = r0.hBK;
        r0 = r3.hT(r0);
    L_0x024a:
        r3 = r4.field_isSend;
        if (r3 != r2) goto L_0x02a3;
    L_0x024e:
        r3 = r0.Pk();
        if (r3 == 0) goto L_0x02a1;
    L_0x0254:
        r3 = r2;
    L_0x0255:
        r6 = r0.hBL;
        r7 = "msg";
        r6 = com.tencent.mm.sdk.platformtools.bj.y(r6, r7);
        if (r6 == 0) goto L_0x02c9;
    L_0x0260:
        if (r3 != r2) goto L_0x028b;
    L_0x0262:
        r0 = ".msg.img.$cdnbigimgurl";
        r0 = r6.get(r0);
        r0 = (java.lang.String) r0;
        r5.TZ(r0);
        r0 = ".msg.img.$length";
        r0 = r6.get(r0);
        r0 = (java.lang.String) r0;
        r0 = com.tencent.mm.sdk.platformtools.bi.getInt(r0, r1);
        r0 = (long) r0;
        r5.fx(r0);
        r0 = ".msg.img.$aeskey";
        r0 = r6.get(r0);
        r0 = (java.lang.String) r0;
        r5.Ua(r0);
    L_0x028b:
        r0 = r13.frk;
        r0 = r0.frm;
        r0 = r0.wlY;
        r0.add(r5);
        r0 = r13.frk;
        r0 = r0.frn;
        r1 = r0.wmp;
        r1 = r1 + 1;
        r0.wmp = r1;
        r1 = r2;
        goto L_0x007b;
    L_0x02a1:
        r3 = r1;
        goto L_0x0255;
    L_0x02a3:
        r3 = r0.Pk();
        if (r3 != 0) goto L_0x02ab;
    L_0x02a9:
        r3 = r1;
        goto L_0x0255;
    L_0x02ab:
        r3 = com.tencent.mm.ap.f.a(r0);
        r6 = com.tencent.mm.ap.o.PC();
        r3 = r3.hBB;
        r7 = "";
        r8 = "";
        r3 = r6.m(r3, r7, r8);
        r3 = com.tencent.mm.a.e.bO(r3);
        if (r3 != 0) goto L_0x02c7;
    L_0x02c5:
        r3 = r1;
        goto L_0x0255;
    L_0x02c7:
        r3 = r2;
        goto L_0x0255;
    L_0x02c9:
        r3 = "MicroMsg.GetFavRecordDataSource";
        r6 = "parse cdnInfo failed. [%s]";
        r7 = new java.lang.Object[r2];
        r0 = r0.hBL;
        r7[r1] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r3, r6, r7);
        goto L_0x028b;
    L_0x02d9:
        r0 = r4.cjW();
        if (r0 == 0) goto L_0x02e5;
    L_0x02df:
        r1 = a(r13, r4, r15);
        goto L_0x007b;
    L_0x02e5:
        r0 = r4.cjX();
        if (r0 == 0) goto L_0x02f1;
    L_0x02eb:
        r1 = a(r13, r4, r15);
        goto L_0x007b;
    L_0x02f1:
        if (r15 == 0) goto L_0x0302;
    L_0x02f3:
        r0 = r4.getType();
        r3 = 318767153; // 0x13000031 float:1.6155966E-27 double:1.574918993E-315;
        if (r0 != r3) goto L_0x0302;
    L_0x02fc:
        r1 = a(r12, r13, r4, r6);
        goto L_0x001b;
    L_0x0302:
        r0 = r4.cjK();
        if (r0 == 0) goto L_0x030e;
    L_0x0308:
        r1 = c(r13, r4);
        goto L_0x007b;
    L_0x030e:
        if (r15 == 0) goto L_0x0322;
    L_0x0310:
        r0 = r4.cjY();
        if (r0 != 0) goto L_0x031c;
    L_0x0316:
        r0 = r4.cjZ();
        if (r0 == 0) goto L_0x0322;
    L_0x031c:
        r1 = a(r12, r13, r4, r2);
        goto L_0x007b;
    L_0x0322:
        if (r15 == 0) goto L_0x0333;
    L_0x0324:
        r0 = r4.getType();
        r3 = 419430449; // 0x19000031 float:6.6174836E-24 double:2.072261757E-315;
        if (r0 != r3) goto L_0x0333;
    L_0x032d:
        r1 = a(r12, r13, r4, r9);
        goto L_0x007b;
    L_0x0333:
        r0 = r4.cjU();
        if (r0 == 0) goto L_0x03ec;
    L_0x0339:
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fh();
        r3 = r4.field_content;
        r3 = r0.Fq(r3);
        r5 = new com.tencent.mm.protocal.c.va;
        r5.<init>();
        r0 = Y(r4);
        r5.c(r0);
        if (r3 == 0) goto L_0x03a3;
    L_0x0354:
        r0 = r3.tth;
        r0 = com.tencent.mm.y.s.gN(r0);
        if (r0 == 0) goto L_0x03a3;
    L_0x035c:
        r0 = new com.tencent.mm.protocal.c.uz;
        r0.<init>();
        r1 = Z(r4);
        r0.Un(r1);
        r1 = 16;
        r0.Dc(r1);
        r1 = r4.field_content;
        r0.TW(r1);
        r0.lA(r2);
        r0.lz(r2);
        r0.a(r5);
        r1 = r5.wlb;
        r1 = a(r1);
        r0.Uq(r1);
        r1 = r5.wlb;
        r1 = b(r1);
        r0.Ur(r1);
    L_0x038d:
        r1 = r13.frk;
        r1 = r1.frm;
        r1 = r1.wlY;
        r1.add(r0);
        r0 = r13.frk;
        r0 = r0.frn;
        r1 = r0.wmC;
        r1 = r1 + 1;
        r0.wmC = r1;
        r1 = r2;
        goto L_0x007b;
    L_0x03a3:
        if (r3 == 0) goto L_0x03e1;
    L_0x03a5:
        r0 = r3.sfb;
        r0 = com.tencent.mm.storage.x.Xg(r0);
        if (r0 == 0) goto L_0x03e1;
    L_0x03ad:
        r0 = com.tencent.mm.openim.a.b.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.openim.a.b) r0;
        r3 = r3.xHM;
        r6 = "openim_card_type_name";
        r7 = com.tencent.mm.openim.a.b.a.idv;
        r0 = r0.h(r3, r6, r7);
        r3 = android.text.TextUtils.isEmpty(r0);
        if (r3 == 0) goto L_0x03d5;
    L_0x03c6:
        r0 = r12.getResources();
        r1 = com.tencent.mm.R.l.dFA;
        r0 = r0.getString(r1);
    L_0x03d0:
        r0 = a(r4, r0, r5);
        goto L_0x038d;
    L_0x03d5:
        r3 = "[%s]";
        r6 = new java.lang.Object[r2];
        r6[r1] = r0;
        r0 = java.lang.String.format(r3, r6);
        goto L_0x03d0;
    L_0x03e1:
        r0 = com.tencent.mm.R.l.dFA;
        r0 = r12.getString(r0);
        r0 = a(r4, r0, r5);
        goto L_0x038d;
    L_0x03ec:
        r0 = r4.aNJ();
        if (r0 == 0) goto L_0x08db;
    L_0x03f2:
        r0 = r4.cjZ();
        if (r0 == 0) goto L_0x0400;
    L_0x03f8:
        r0 = r13.frk;
        r2 = com.tencent.mm.R.l.efC;
        r0.frq = r2;
        goto L_0x007b;
    L_0x0400:
        r3 = new com.tencent.mm.protocal.c.va;
        r3.<init>();
        r0 = Y(r4);
        r3.c(r0);
        r0 = r4.field_content;
        if (r0 != 0) goto L_0x041a;
    L_0x0410:
        r0 = r13.frk;
        r2 = com.tencent.mm.R.l.efD;
        r0.frq = r2;
        r2 = r1;
    L_0x0417:
        r1 = r2;
        goto L_0x007b;
    L_0x041a:
        r5 = com.tencent.mm.x.g.a.fV(r0);
        if (r5 != 0) goto L_0x0428;
    L_0x0420:
        r0 = r13.frk;
        r2 = com.tencent.mm.R.l.efD;
        r0.frq = r2;
        r2 = r1;
        goto L_0x0417;
    L_0x0428:
        r0 = r3.wlb;
        r6 = r5.appId;
        r0.UB(r6);
        r0 = r3.wlb;
        r6 = r5.fHu;
        r0.UD(r6);
        r0 = r5.appId;
        r0 = com.tencent.mm.pluginsdk.model.app.g.aZ(r0, r2);
        if (r0 == 0) goto L_0x045a;
    L_0x043e:
        r0 = r0.YI();
        if (r0 == 0) goto L_0x045a;
    L_0x0444:
        if (r15 == 0) goto L_0x045a;
    L_0x0446:
        r0 = com.tencent.mm.R.l.dFB;
        r0 = r12.getString(r0);
        r0 = a(r4, r0, r3);
        r1 = r13.frk;
        r1 = r1.frm;
        r1 = r1.wlY;
        r1.add(r0);
        goto L_0x0417;
    L_0x045a:
        r0 = r5.type;
        switch(r0) {
            case 1: goto L_0x0475;
            case 2: goto L_0x04b9;
            case 3: goto L_0x0537;
            case 4: goto L_0x0566;
            case 5: goto L_0x059a;
            case 6: goto L_0x0644;
            case 7: goto L_0x06de;
            case 8: goto L_0x045f;
            case 9: goto L_0x045f;
            case 10: goto L_0x070b;
            case 11: goto L_0x045f;
            case 12: goto L_0x045f;
            case 13: goto L_0x07ca;
            case 14: goto L_0x045f;
            case 15: goto L_0x045f;
            case 16: goto L_0x08bb;
            case 17: goto L_0x045f;
            case 18: goto L_0x045f;
            case 19: goto L_0x082c;
            case 20: goto L_0x076d;
            case 21: goto L_0x045f;
            case 22: goto L_0x045f;
            case 23: goto L_0x045f;
            case 24: goto L_0x08a4;
            default: goto L_0x045f;
        };
    L_0x045f:
        if (r15 == 0) goto L_0x08d2;
    L_0x0461:
        r0 = com.tencent.mm.R.l.dGU;
        r0 = r12.getString(r0);
        r0 = a(r4, r0, r3);
        r1 = r13.frk;
        r1 = r1.frm;
        r1 = r1.wlY;
        r1.add(r0);
        goto L_0x0417;
    L_0x0475:
        r0 = new com.tencent.mm.protocal.c.uz;
        r0.<init>();
        r1 = Z(r4);
        r0.Un(r1);
        r0.Dc(r2);
        r1 = r5.title;
        r0.TW(r1);
        r0.lA(r2);
        r0.lz(r2);
        r0.a(r3);
        r1 = r3.wlb;
        r1 = a(r1);
        r0.Uq(r1);
        r1 = r3.wlb;
        r1 = b(r1);
        r0.Ur(r1);
        r1 = r13.frk;
        r1 = r1.frm;
        r1 = r1.wlY;
        r1.add(r0);
        r0 = r13.frk;
        r0 = r0.frn;
        r1 = r0.wmo;
        r1 = r1 + 1;
        r0.wmo = r1;
        goto L_0x0417;
    L_0x04b9:
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.isSDCardAvailable();
        if (r0 != 0) goto L_0x04cb;
    L_0x04c2:
        r0 = r13.frk;
        r2 = com.tencent.mm.R.l.efJ;
        r0.frq = r2;
        r2 = r1;
        goto L_0x0417;
    L_0x04cb:
        r0 = com.tencent.mm.pluginsdk.model.app.an.aqK();
        r1 = r5.for;
        r0 = r0.Se(r1);
        r1 = new com.tencent.mm.protocal.c.uz;
        r1.<init>();
        r6 = Z(r4);
        r1.Un(r6);
        if (r0 == 0) goto L_0x04e8;
    L_0x04e3:
        r0 = r0.field_fileFullPath;
        r1.Uj(r0);
    L_0x04e8:
        r0 = com.tencent.mm.ap.o.PC();
        r6 = r4.field_imgPath;
        r0 = r0.B(r6, r2);
        r6 = com.tencent.mm.a.e.bO(r0);
        if (r6 == 0) goto L_0x04fb;
    L_0x04f8:
        r1.Uk(r0);
    L_0x04fb:
        r1.Dc(r9);
        r0 = r5.title;
        r1.TV(r0);
        r0 = r5.description;
        r1.TW(r0);
        r1.a(r3);
        r0 = r3.wlb;
        r0 = a(r0);
        r1.Uq(r0);
        r0 = r3.wlb;
        r0 = b(r0);
        r1.Ur(r0);
        r6 = r4.field_msgId;
        r1.fz(r6);
        r0 = r13.frk;
        r0 = r0.frm;
        r0 = r0.wlY;
        r0.add(r1);
        r0 = r13.frk;
        r0 = r0.frn;
        r1 = r0.wmp;
        r1 = r1 + 1;
        r0.wmp = r1;
        goto L_0x0417;
    L_0x0537:
        r0 = 7;
        r0 = a(r4, r5, r0);
        r0.a(r3);
        r1 = r3.wlb;
        r1 = a(r1);
        r0.Uq(r1);
        r1 = r3.wlb;
        r1 = b(r1);
        r0.Ur(r1);
        r1 = r13.frk;
        r1 = r1.frm;
        r1 = r1.wlY;
        r1.add(r0);
        r0 = r13.frk;
        r0 = r0.frn;
        r1 = r0.wmu;
        r1 = r1 + 1;
        r0.wmu = r1;
        goto L_0x0417;
    L_0x0566:
        r0 = 4;
        r0 = a(r4, r5, r0);
        r0.a(r3);
        r1 = r3.wlb;
        r1 = a(r1);
        r0.Uq(r1);
        r1 = r3.wlb;
        r1 = b(r1);
        r0.Ur(r1);
        r6 = r4.field_msgId;
        r0.fz(r6);
        r1 = r13.frk;
        r1 = r1.frm;
        r1 = r1.wlY;
        r1.add(r0);
        r0 = r13.frk;
        r0 = r0.frn;
        r1 = r0.wmr;
        r1 = r1 + 1;
        r0.wmr = r1;
        goto L_0x0417;
    L_0x059a:
        r0 = r5.url;
        if (r0 == 0) goto L_0x0624;
    L_0x059e:
        r0 = r5.url;
        r6 = "";
        r0 = r0.equals(r6);
        if (r0 != 0) goto L_0x0624;
    L_0x05a9:
        r0 = r3.wlb;
        r1 = r5.url;
        r0.UC(r1);
        r0 = 5;
        r0 = a(r4, r5, r0);
        r0.a(r3);
        r1 = r3.wlb;
        r1 = a(r1);
        r0.Uq(r1);
        r1 = r3.wlb;
        r1 = b(r1);
        r0.Ur(r1);
        r1 = new com.tencent.mm.protocal.c.wc;
        r1.<init>();
        r6 = r5.title;
        r6 = com.tencent.mm.sdk.platformtools.bi.oN(r6);
        if (r6 != 0) goto L_0x05dc;
    L_0x05d7:
        r6 = r5.title;
        r1.Va(r6);
    L_0x05dc:
        r6 = r5.description;
        r6 = com.tencent.mm.sdk.platformtools.bi.oN(r6);
        if (r6 != 0) goto L_0x05e9;
    L_0x05e4:
        r6 = r5.description;
        r1.Vb(r6);
    L_0x05e9:
        r6 = r5.thumburl;
        r6 = com.tencent.mm.sdk.platformtools.bi.oN(r6);
        if (r6 != 0) goto L_0x05f6;
    L_0x05f1:
        r6 = r5.thumburl;
        r1.Vd(r6);
    L_0x05f6:
        r6 = r5.canvasPageXml;
        r6 = com.tencent.mm.sdk.platformtools.bi.oN(r6);
        if (r6 != 0) goto L_0x0603;
    L_0x05fe:
        r5 = r5.canvasPageXml;
        r1.Ve(r5);
    L_0x0603:
        r5 = r1.bkL();
        if (r5 <= 0) goto L_0x060f;
    L_0x0609:
        r1.Dm(r2);
        r3.a(r1);
    L_0x060f:
        r1 = r13.frk;
        r1 = r1.frm;
        r1 = r1.wlY;
        r1.add(r0);
        r0 = r13.frk;
        r0 = r0.frn;
        r1 = r0.wms;
        r1 = r1 + 1;
        r0.wms = r1;
        goto L_0x0417;
    L_0x0624:
        r0 = r13.frk;
        r5 = com.tencent.mm.R.l.efy;
        r0.frq = r5;
        if (r15 == 0) goto L_0x0641;
    L_0x062c:
        r0 = com.tencent.mm.R.l.dGU;
        r0 = r12.getString(r0);
        r0 = a(r4, r0, r3);
        r1 = r13.frk;
        r1 = r1.frm;
        r1 = r1.wlY;
        r1.add(r0);
        goto L_0x0417;
    L_0x0641:
        r2 = r1;
        goto L_0x0417;
    L_0x0644:
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.isSDCardAvailable();
        if (r0 != 0) goto L_0x0656;
    L_0x064d:
        r0 = r13.frk;
        r2 = com.tencent.mm.R.l.efJ;
        r0.frq = r2;
        r2 = r1;
        goto L_0x0417;
    L_0x0656:
        r0 = com.tencent.mm.pluginsdk.model.app.an.aqK();
        r1 = r5.for;
        r0 = r0.Se(r1);
        r1 = new com.tencent.mm.protocal.c.uz;
        r1.<init>();
        if (r0 == 0) goto L_0x066c;
    L_0x0667:
        r0 = r0.field_fileFullPath;
        r1.Uj(r0);
    L_0x066c:
        r0 = Z(r4);
        r1.Un(r0);
        r0 = 8;
        r1.Dc(r0);
        r0 = r5.hcN;
        r1.Uf(r0);
        r0 = com.tencent.mm.ap.o.PC();
        r6 = r4.field_imgPath;
        r0 = r0.B(r6, r2);
        r6 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r6 == 0) goto L_0x0690;
    L_0x068d:
        r1.lA(r2);
    L_0x0690:
        r6 = com.tencent.mm.a.e.bO(r0);
        if (r6 == 0) goto L_0x0699;
    L_0x0696:
        r1.Uk(r0);
    L_0x0699:
        r0 = r5.title;
        r1.TV(r0);
        r0 = r5.description;
        r1.TW(r0);
        r1.a(r3);
        r0 = r3.wlb;
        r0 = a(r0);
        r1.Uq(r0);
        r0 = r3.wlb;
        r0 = b(r0);
        r1.Ur(r0);
        r6 = r4.field_msgId;
        r1.fz(r6);
        if (r15 == 0) goto L_0x06c9;
    L_0x06bf:
        r0 = r5.hcT;
        r1.TZ(r0);
        r0 = r5.hda;
        r1.Ua(r0);
    L_0x06c9:
        r0 = r13.frk;
        r0 = r0.frm;
        r0 = r0.wlY;
        r0.add(r1);
        r0 = r13.frk;
        r0 = r0.frn;
        r1 = r0.wmv;
        r1 = r1 + 1;
        r0.wmv = r1;
        goto L_0x0417;
    L_0x06de:
        r0 = r5.for;
        if (r0 == 0) goto L_0x06ea;
    L_0x06e2:
        r0 = r5.for;
        r0 = r0.length();
        if (r0 != 0) goto L_0x06f9;
    L_0x06ea:
        r0 = r13.frk;
        r2 = com.tencent.mm.R.l.efv;
        r0.frq = r2;
    L_0x06f0:
        r0 = r13.frk;
        r2 = com.tencent.mm.R.l.efC;
        r0.frq = r2;
        r2 = r1;
        goto L_0x0417;
    L_0x06f9:
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.isSDCardAvailable();
        if (r0 != 0) goto L_0x06f0;
    L_0x0702:
        r0 = r13.frk;
        r2 = com.tencent.mm.R.l.efJ;
        r0.frq = r2;
        r2 = r1;
        goto L_0x0417;
    L_0x070b:
        r0 = new com.tencent.mm.protocal.c.vm;
        r0.<init>();
        r1 = r5.title;
        r0.UG(r1);
        r1 = r5.description;
        r0.UH(r1);
        r1 = r5.hdh;
        r0.Di(r1);
        r1 = r5.hdi;
        r0.UJ(r1);
        r1 = r5.thumburl;
        r0.UI(r1);
        r3.a(r0);
        r0 = new com.tencent.mm.protocal.c.uz;
        r0.<init>();
        r1 = Z(r4);
        r0.Un(r1);
        r1 = 10;
        r0.Dc(r1);
        r0.lA(r2);
        r0.lz(r2);
        r0.a(r3);
        r1 = r3.wlb;
        r1 = a(r1);
        r0.Uq(r1);
        r1 = r3.wlb;
        r1 = b(r1);
        r0.Ur(r1);
        r1 = r13.frk;
        r1 = r1.frm;
        r1 = r1.wlY;
        r1.add(r0);
        r0 = r13.frk;
        r0 = r0.frn;
        r1 = r0.wmx;
        r1 = r1 + 1;
        r0.wmx = r1;
        goto L_0x0417;
    L_0x076d:
        r0 = new com.tencent.mm.protocal.c.vw;
        r0.<init>();
        r1 = r5.title;
        r0.UW(r1);
        r1 = r5.description;
        r0.UX(r1);
        r1 = r5.hdl;
        r0.UZ(r1);
        r1 = r5.thumburl;
        r0.UY(r1);
        r3.a(r0);
        r0 = new com.tencent.mm.protocal.c.uz;
        r0.<init>();
        r1 = Z(r4);
        r0.Un(r1);
        r1 = 14;
        r0.Dc(r1);
        r0.lA(r2);
        r0.lz(r2);
        r0.a(r3);
        r1 = r3.wlb;
        r1 = a(r1);
        r0.Uq(r1);
        r1 = r3.wlb;
        r1 = b(r1);
        r0.Ur(r1);
        r1 = r13.frk;
        r1 = r1.frm;
        r1 = r1.wlY;
        r1.add(r0);
        r0 = r13.frk;
        r0 = r0.frn;
        r1 = r0.wmB;
        r1 = r1 + 1;
        r0.wmB = r1;
        goto L_0x0417;
    L_0x07ca:
        r0 = new com.tencent.mm.protocal.c.vm;
        r0.<init>();
        r1 = r5.title;
        r0.UG(r1);
        r1 = r5.description;
        r0.UH(r1);
        r1 = r5.hdn;
        r0.Di(r1);
        r1 = r5.hdo;
        r0.UJ(r1);
        r1 = r5.thumburl;
        r0.UI(r1);
        r3.a(r0);
        r0 = new com.tencent.mm.protocal.c.uz;
        r0.<init>();
        r1 = Z(r4);
        r0.Un(r1);
        r1 = 11;
        r0.Dc(r1);
        r0.lA(r2);
        r0.lz(r2);
        r0.a(r3);
        r1 = r3.wlb;
        r1 = a(r1);
        r0.Uq(r1);
        r1 = r3.wlb;
        r1 = b(r1);
        r0.Ur(r1);
        r1 = r13.frk;
        r1 = r1.frm;
        r1 = r1.wlY;
        r1.add(r0);
        r0 = r13.frk;
        r0 = r0.frn;
        r1 = r0.wmy;
        r1 = r1 + 1;
        r0.wmy = r1;
        goto L_0x0417;
    L_0x082c:
        r0 = r5.hdm;
        if (r0 == 0) goto L_0x08a2;
    L_0x0830:
        r0 = r5.hdm;
        r6 = "<recordxml>";
        r0 = r0.contains(r6);
        if (r0 == 0) goto L_0x08a2;
    L_0x083b:
        r0 = r2;
    L_0x083c:
        if (r0 != 0) goto L_0x08a4;
    L_0x083e:
        r6 = new com.tencent.mm.protocal.c.uz;
        r6.<init>();
        r0 = Z(r4);
        r6.Un(r0);
        r0 = 17;
        r6.Dc(r0);
        r6.lA(r2);
        r0 = r5.title;
        r6.TV(r0);
        r0 = r5.hdm;
        r6.Uv(r0);
        r0 = r5.description;
        r7 = new com.tencent.mm.f.a.mv;
        r7.<init>();
        r8 = r7.fFz;
        r8.type = r1;
        r1 = r7.fFz;
        r5 = r5.hdm;
        r1.fFB = r5;
        r1 = com.tencent.mm.sdk.b.a.xmy;
        r1.m(r7);
        r1 = r7.fFA;
        r1 = r1.fFJ;
        if (r1 == 0) goto L_0x087a;
    L_0x0878:
        r0 = r1.desc;
    L_0x087a:
        r6.TW(r0);
        r6.a(r3);
        r0 = r3.wlb;
        r0 = a(r0);
        r6.Uq(r0);
        r0 = r3.wlb;
        r0 = b(r0);
        r6.Ur(r0);
        r0 = r4.field_msgId;
        r6.fz(r0);
        r0 = r13.frk;
        r0 = r0.frm;
        r0 = r0.wlY;
        r0.add(r6);
        goto L_0x0417;
    L_0x08a2:
        r0 = r1;
        goto L_0x083c;
    L_0x08a4:
        if (r15 == 0) goto L_0x08bb;
    L_0x08a6:
        r0 = com.tencent.mm.R.l.ehl;
        r0 = r12.getString(r0);
        r0 = a(r4, r0, r3);
        r1 = r13.frk;
        r1 = r1.frm;
        r1 = r1.wlY;
        r1.add(r0);
        goto L_0x0417;
    L_0x08bb:
        if (r15 == 0) goto L_0x045f;
    L_0x08bd:
        r0 = com.tencent.mm.R.l.dGy;
        r0 = r12.getString(r0);
        r0 = a(r4, r0, r3);
        r1 = r13.frk;
        r1 = r1.frm;
        r1 = r1.wlY;
        r1.add(r0);
        goto L_0x0417;
    L_0x08d2:
        r0 = r13.frk;
        r2 = com.tencent.mm.R.l.efC;
        r0.frq = r2;
        r2 = r1;
        goto L_0x0417;
    L_0x08db:
        r0 = r13.frk;
        r2 = com.tencent.mm.R.l.efC;
        r0.frq = r2;
        if (r15 == 0) goto L_0x007b;
    L_0x08e3:
        r1 = a(r12, r13, r4, r6);
        goto L_0x007b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.model.h.a(android.content.Context, com.tencent.mm.f.a.cg, com.tencent.mm.storage.au, boolean):boolean");
    }

    private static boolean a(Context context, cg cgVar, au auVar, int i) {
        va vaVar = new va();
        vaVar.c(Y(auVar));
        String str = null;
        if (i == 1) {
            str = context.getString(R.l.dER);
        } else if (i == 2) {
            str = context.getString(R.l.dGh);
        } else if (i == 3) {
            str = context.getString(R.l.dGU);
        }
        cgVar.frk.frm.wlY.add(a(auVar, str, vaVar));
        return true;
    }

    private static vt RY(String str) {
        vt vtVar = new vt();
        vtVar.UN(str);
        vtVar.Dl(1);
        vtVar.fD(bi.Wy());
        vtVar.UP("");
        return vtVar;
    }

    private static vb Y(au auVar) {
        vb vbVar = new vb();
        if (auVar == null) {
            return vbVar;
        }
        if (auVar.field_isSend == 1 || auVar.field_content.startsWith("<msg>")) {
            vbVar.Uw(q.FY());
            vbVar.Ux(auVar.field_talker);
            if (s.eX(auVar.field_talker)) {
                vbVar.Uz(vbVar.fAJ);
            }
        } else {
            vbVar.Uw(auVar.field_talker);
            vbVar.Ux(q.FY());
            if (s.eX(auVar.field_talker)) {
                vbVar.Uz(auVar.field_content != null ? auVar.field_content.substring(0, Math.max(0, auVar.field_content.indexOf(58))) : "");
                if (!(bi.oN(vbVar.wlx) || auVar.cjL())) {
                    auVar.setContent(auVar.field_content.substring(vbVar.wlx.length() + 1));
                    if (auVar.field_content.length() > 0 && 10 == auVar.field_content.charAt(0)) {
                        auVar.setContent(auVar.field_content.substring(1));
                    }
                    if (auVar.ckg()) {
                        auVar.dX(auVar.field_transContent.substring(vbVar.wlx.length() + 1));
                        if (auVar.field_transContent.length() > 0 && 10 == auVar.field_transContent.charAt(0)) {
                            auVar.dX(auVar.field_transContent.substring(1));
                        }
                    }
                }
            }
        }
        if (f.eG(auVar.field_talker)) {
            String str = auVar.field_bizChatUserId;
            if (str == null) {
                str = bb.hW(auVar.gkD).userId;
            }
            vbVar.Uz(str);
        }
        vbVar.Dg(1);
        vbVar.fA(auVar.field_createTime);
        vbVar.UA(auVar.field_msgSvrId);
        if (auVar.field_msgSvrId > 0) {
            vbVar.Uy(auVar.field_msgSvrId);
        }
        return vbVar;
    }

    private static String a(vb vbVar) {
        String str = vbVar.wlx;
        if (bi.oN(str)) {
            str = vbVar.fAJ;
        }
        if (e.kp(str)) {
            return e.kr(str);
        }
        return r.gv(str);
    }

    private static String b(vb vbVar) {
        return pOG.format(new Date(vbVar.hXs));
    }

    private static String Z(au auVar) {
        if (auVar.field_isSend != 1) {
            return String.valueOf(auVar.field_msgSvrId);
        }
        if (s.eX(auVar.field_talker) || auVar.field_talker.equals("filehelper")) {
            return String.format("%d", new Object[]{Long.valueOf(auVar.field_msgSvrId)});
        }
        return String.format("%s#%d", new Object[]{auVar.field_talker, Long.valueOf(auVar.field_msgSvrId)});
    }

    private static boolean b(cg cgVar, au auVar) {
        va vaVar = new va();
        vaVar.c(Y(auVar));
        Map y = bj.y(auVar.field_content, "msg");
        if (y != null) {
            try {
                vg vgVar = new vg();
                vgVar.UE((String) y.get(".msg.location.$label"));
                vgVar.s(Double.parseDouble((String) y.get(".msg.location.$x")));
                vgVar.r(Double.parseDouble((String) y.get(".msg.location.$y")));
                vgVar.Dh(Integer.valueOf((String) y.get(".msg.location.$scale")).intValue());
                vgVar.UF((String) y.get(".msg.location.$poiname"));
                vaVar.a(vgVar);
                uz uzVar = new uz();
                uzVar.Un(Z(auVar));
                uzVar.Dc(6);
                uzVar.lA(true);
                uzVar.lz(true);
                uzVar.a(vaVar);
                uzVar.Uq(a(vaVar.wlb));
                uzVar.Ur(b(vaVar.wlb));
                cgVar.frk.frm.wlY.add(uzVar);
                wb wbVar = cgVar.frk.frn;
                wbVar.wmt++;
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.GetFavRecordDataSource", "parse failed, %s", e.getStackTrace().toString());
            }
        }
        cgVar.frk.frq = R.l.efD;
        return false;
    }

    private static boolean a(cg cgVar, au auVar, boolean z) {
        va vaVar = new va();
        vaVar.c(Y(auVar));
        uz uzVar = new uz();
        uzVar.Un(Z(auVar));
        o.Ub();
        uzVar.Uj(com.tencent.mm.modelvideo.s.nx(auVar.field_imgPath));
        o.Ub();
        uzVar.Uk(com.tencent.mm.modelvideo.s.ny(auVar.field_imgPath));
        uzVar.Uf(com.tencent.mm.a.e.bQ(uzVar.wkl));
        if (auVar.cjX()) {
            uzVar.Dc(15);
        } else {
            uzVar.Dc(4);
        }
        com.tencent.mm.modelvideo.r nJ = t.nJ(auVar.field_imgPath);
        x.i("MicroMsg.GetFavRecordDataSource", "video length is %d", Integer.valueOf(nJ.hmZ));
        if (nJ.hmZ > b.zN()) {
            cgVar.frk.frq = R.l.ehb;
            return false;
        } else if (auVar.cjX() && t.nL(nJ.getFileName())) {
            cgVar.frk.frq = R.l.eft;
            return false;
        } else {
            uzVar.Db(nJ.hXv);
            uzVar.a(vaVar);
            uzVar.Uq(a(vaVar.wlb));
            uzVar.Ur(b(vaVar.wlb));
            uzVar.fz(auVar.field_msgId);
            uzVar.fx((long) nJ.hmZ);
            if (z) {
                Map y = bj.y(nJ.Un(), "msg");
                if (y != null) {
                    uzVar.TZ((String) y.get(".msg.videomsg.$cdnvideourl"));
                    uzVar.Ua((String) y.get(".msg.videomsg.$aeskey"));
                } else {
                    x.i("MicroMsg.GetFavRecordDataSource", "cdntra parse video recv xml failed");
                }
            }
            cgVar.frk.frm.wlY.add(uzVar);
            wb wbVar = cgVar.frk.frn;
            wbVar.wmr++;
            com.tencent.mm.modelvideo.r nJ2 = t.nJ(auVar.field_imgPath);
            uzVar.Ut(nJ2.fHB);
            bnp bnp = nJ2.hXE;
            if (!(bnp == null || bi.oN(bnp.hff))) {
                vc vcVar = new vc();
                vcVar.heZ = bnp.heZ;
                vcVar.wlG = bnp.wlG;
                vcVar.hfc = bnp.hfc;
                vcVar.hfd = bnp.hfd;
                vcVar.hfb = bnp.hfb;
                vcVar.hfe = bnp.hfe;
                vcVar.hff = bnp.hff;
                vcVar.hfg = bnp.hfg;
                uzVar.a(vcVar);
            }
            return true;
        }
    }

    private static uz a(au auVar, com.tencent.mm.x.g.a aVar, int i) {
        uz uzVar = new uz();
        uzVar.Un(Z(auVar));
        uzVar.Uc(aVar.hdd);
        uzVar.Ud(aVar.hde);
        uzVar.Ub(aVar.url);
        uzVar.lz(true);
        File file = new File(bi.aD(com.tencent.mm.ap.o.PC().B(auVar.field_imgPath, true), ""));
        if (file.exists()) {
            uzVar.Uk(file.getAbsolutePath());
        } else {
            uzVar.lA(true);
        }
        uzVar.TV(aVar.title);
        uzVar.TW(aVar.description);
        uzVar.Dc(i);
        uzVar.Uu(aVar.canvasPageXml);
        return uzVar;
    }

    private static uz a(au auVar, String str, va vaVar) {
        uz uzVar = new uz();
        uzVar.Un(Z(auVar));
        uzVar.Dc(1);
        uzVar.TW(str);
        uzVar.lA(true);
        uzVar.lz(true);
        uzVar.a(vaVar);
        uzVar.Uq(a(vaVar.wlb));
        uzVar.Ur(b(vaVar.wlb));
        return uzVar;
    }

    private static boolean c(cg cgVar, au auVar) {
        try {
            l wr = ((a) g.h(a.class)).wr(auVar.field_content);
            List<m> list = wr.hfI;
            if (list != null) {
                int i = 0;
                for (m mVar : list) {
                    if (!i.fX(mVar.hfT)) {
                        va vaVar = new va();
                        vaVar.c(Y(auVar));
                        vaVar.wlb.UD(wr.fHu);
                        vaVar.wlb.UC(mVar.url);
                        uz uzVar = new uz();
                        uzVar.TV(mVar.title);
                        uzVar.TW(mVar.hfQ);
                        uzVar.Un(Z(auVar));
                        if (bi.oN(mVar.hfO)) {
                            uzVar.lA(true);
                        } else {
                            uzVar.Uk(t.x(mVar.hfO, auVar.getType(), i == 0 ? "@T" : "@S"));
                        }
                        uzVar.lz(true);
                        wc wcVar = new wc();
                        if (!bi.oN(mVar.title)) {
                            wcVar.Va(mVar.title);
                        }
                        if (!bi.oN(mVar.hfQ)) {
                            wcVar.Vb(mVar.hfQ);
                        }
                        if (!bi.oN(mVar.hfO)) {
                            wcVar.Vd(mVar.hfO);
                        }
                        if (wcVar.bkL() > 0) {
                            wcVar.Dm(1);
                            vaVar.a(wcVar);
                        }
                        uzVar.Dc(5);
                        uzVar.a(vaVar);
                        uzVar.Uq(a(vaVar.wlb));
                        uzVar.Ur(b(vaVar.wlb));
                        cgVar.frk.frm.wlY.add(uzVar);
                        wb wbVar = cgVar.frk.frn;
                        wbVar.wms++;
                        i++;
                    }
                }
                if (i != 0) {
                    return true;
                }
                cgVar.frk.frq = R.l.efC;
                return false;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GetFavRecordDataSource", e, "", new Object[0]);
            x.e("MicroMsg.GetFavRecordDataSource", "retransmit app msg error : %s", e.getLocalizedMessage());
        }
        cgVar.frk.frq = R.l.efD;
        return false;
    }
}
